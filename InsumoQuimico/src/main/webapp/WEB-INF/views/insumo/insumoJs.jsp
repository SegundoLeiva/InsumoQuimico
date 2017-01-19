<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var insumoJSONArray = arrayJsonDetalle;
var index = 1;

$(document).ready(function() {
	tabla="#tablaDetalle";
	claseColumna=["descripcion","valor","unidadMedida","pesoBruto","pesoNeto","vigenciaInsumo"];
	inicializarStyleTablaDetalle();

	if('<c:out value="${accion}"/>'=="EDITAR"){	
		var i=0;
		<c:forEach var="jbean" items="${listaPresentacionInsumo}">	
			var vigencia = "VIGENTE";
			if('${jbean.vigencia}'=='N'){
				vigencia = "NO VIGENTE"
			}
		 	var data = ["${jbean.descripcion}",
		             "${jbean.valor}","${jbean.idUnidadMedidaPresentacion}","${jbean.pesoBruto}","${jbean.pesoNeto}",vigencia];
			agregarDetalle(data); 
			insumoJSONArray[i].idDetalle="${jbean.idPresentacionInsumo}";
			insumoJSONArray[i].idPresentacion="${jbean.idPresentacion}";
			insumoJSONArray[i].descripcion="${jbean.descripcion}";
			insumoJSONArray[i].valor="${jbean.valor}";
			insumoJSONArray[i].pesoBruto="${jbean.pesoBruto}";
			insumoJSONArray[i].pesoNeto="${jbean.pesoNeto}";
			insumoJSONArray[i].unidadMedida="${jbean.idUnidadMedidaPresentacion}";
			insumoJSONArray[i].vigenciaInsumo="${jbean.vigencia}";
			insumoJSONArray[i].indicadorBD=INDICADOR_CREADO;
			i++;
		</c:forEach>
		index = "${listaPresentacionInsumo.get(listaPresentacionInsumo.size()-1).idPresentacion+1}";
	}
	var data=[{id:" ",text:"Seleccionar"}];
	<c:forEach var="item" items="${listaUnidadMedida}">
		var obj = {id:"${item.idUnidadMedida}",text:"${item.unidadMedida}"}
		data.push(obj);
	</c:forEach>

	$("#unidadMedida").select2({
		  data: data
	});


} );

$("#btnAgregarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarDetalle()){			 	
 		 	var data = [$("#descripcion").val(),$("#valor").val(),$("#unidadMedida").val(),
 		 	          $("#pesoBruto").val(),$("#pesoNeto").val(),$("#vigenciaInsumo option:selected").text()];
 		 	agregarDetalle(data);
 		 	var fila = insumoJSONArray.length-1;
  		 	insumoJSONArray[fila].descripcion=$("#descripcion").val();
  		 	insumoJSONArray[fila].valor=$("#valor").val();
  		 	insumoJSONArray[fila].pesoBruto=$("#pesoBruto").val();
  		 	insumoJSONArray[fila].pesoNeto=$("#pesoNeto").val();
  		 	insumoJSONArray[fila].unidadMedida=$("#unidadMedida").val();
  		 	insumoJSONArray[fila].vigenciaInsumo=$("#vigenciaInsumo").val();
		 	$("#divModalDetalleForm").modal("hide");
	 }
	
});

function agregarDetalle(data){
	var insumoJSON = {idDetalle:'',idPresentacion:'',descripcion:'',
		    valor:'',unidadMedida:'',pesoBruto:'',pesoNeto:'',indicadorBD: INDICADOR_NUEVO};
	insumoJSONArray.push(insumoJSON);
	agregarFila(data);
}

$("#btnEditarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarDetalle()){	
		 setearCampo("descripcion",$("#descripcion").val());
		 setearCampo("valor",$("#valor").val());
		 setearCampo("unidadMedida",$("#unidadMedida").val());
		 setearCampo("pesoBruto",$("#pesoBruto").val());
		 setearCampo("pesoNeto",$("#pesoNeto").val());
		 setearCampo("vigenciaInsumo",$("#vigenciaInsumo option:selected").text());
		 insumoJSONArray[filaIndexDetalle].vigenciaInsumo=$("#vigenciaInsumo").val();
		 cambiarIndicadorModificado();	 
		 $("#divModalDetalleForm").modal("hide");
	 }
	
});

$("#abrirDetalleEditar").click(function(){
	$("#btnAgregarDetalle").hide();
	$("#btnEditarDetalle").show();
	var checkDetalle = $('#tablaDetalle> tbody .checkDetalle:checked');
	if(checkDetalle.length==1){
		var index = checkDetalle.closest("tr").index();
		$("#descripcion").val(insumoJSONArray[index].descripcion);
		$("#valor").val(insumoJSONArray[index].valor);
		$("#unidadMedida").val(insumoJSONArray[index].unidadMedida).trigger('change');
		$("#pesoBruto").val(insumoJSONArray[index].pesoBruto);
		$("#pesoNeto").val(insumoJSONArray[index].pesoNeto);
		$("#vigenciaInsumo").val(insumoJSONArray[index].vigenciaInsumo);
		filaIndexDetalle = index;
		$("#divModalDetalleForm").modal("show");
	}else{
		alertify.error("Seleccione un Item.");
	}	
});

function validarDetalle(){
	var rpta=true;
	var valor = parseFloat($("#valor").val());
	
	if(valor==0){
		alertify.error("El valor debe ser mayor a 0.");
		rpta=false;
	}
	
	return rpta;
}

$("#eliminarDetalle").click(function(){
	eliminarDetalle();
});

$("#guardar").click(function(){
	if(fnValidarGuardar()){
		alertify.confirm("Guardar","¿Usted está seguro de guardar los registros?",
				function(){
			showLoading();
			$.ajax({
				type : 'post',
				data: {
					idInsumo:$("#idInsumo").val(),
					insumo:$("#insumo").val(),
					vigencia:$("#vigencia").val(),
					index:index,
	 				insumoJSONArray: JSON.stringify(insumoJSONArray)
					
				},
				url : '${pageContext.request.contextPath}/insumo/guardarInsumo.htm',
				success : function(data) {
					hideLoading();
					if(data=="guardar"){	
						index = actualizarDetalleGrabar(index);						
					}
					mensajeTransaccion(data);
				}
			});
						  },
				function(){});
	}
});

function fnValidarGuardar(){
	if(!validarCamposRequeridos("formInsumo")){
		return false;
	}else if(insumoJSONArray.length==0){
		alertify.error("Mínimo debe registrar una presentación");
		return false;
	}else{
		return true;
	}
}
</script>