<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var consumoJSONArray  = arrayJsonDetalle;
var index = 1;

$(document).ready(function() {
	tabla="#tablaConsumoDetalle";
	claseColumna=["idUnidadMineraInsumo","descripcion","cantidad","unidadMedida"];
	inicializarStyleTablaDetalle();
	
	if($("#flagEditar").val()=="editar"){

		var i=0;
		<c:forEach var="jbean" items="${listaConsumoDetalle}">		
		 	var data = ["${jbean.unidadMineraInsumo.idUnidadMineraInsumo}",
		             "${jbean.unidadMineraInsumo.insumo.insumo}",
		             "${jbean.cantidad}","KG"];
			agregarDetalle(data); 
			consumoJSONArray[i].idDetalle="${jbean.id.idConsumoDetalle}";
			consumoJSONArray[i].idUnidadMineraInsumo="${jbean.unidadMineraInsumo.idUnidadMineraInsumo}";
			consumoJSONArray[i].cantidad="${jbean.cantidad}";
			consumoJSONArray[i].unidadMedida="KG";
			consumoJSONArray[i].indicadorBD=INDICADOR_CREADO;
			i++;
		</c:forEach>
		index = "${listaConsumoDetalle.get(listaConsumoDetalle.size()-1).id.idConsumoDetalle+1}";
	}
	
	var dataInsumo=[{id:" ",text:"Seleccionar"}];
	<c:forEach var="item" items="${listaUnidadMineraInsumo}">
		var obj = {id:"${item.idUnidadMineraInsumo}",text:"${item.insumo.insumo}"}
		dataInsumo.push(obj);
	</c:forEach>

	$("#idUnidadMineraInsumo").select2({
		  data: dataInsumo
	});
} );

$("#btnAgregarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarInsumo("")){			 	
 		 	var data = [$("#idUnidadMineraInsumo").val(),$("#idUnidadMineraInsumo option:selected").text(),
 		 	         	 $("#cantidad").val(),"KG"];
 		 	agregarDetalle(data);
 		 	var fila = consumoJSONArray.length-1;
 		 	consumoJSONArray[fila].idUnidadMineraInsumo=$("#idUnidadMineraInsumo").val();
			consumoJSONArray[fila].cantidad=$("#cantidad").val();
		 	$("#divModalDetalleForm").modal("hide");
	 }
	
});

function agregarDetalle(data){
	agregarJsonDetalle();	
	agregarFila(data);
}

$("#btnEditarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarInsumo("editar")){	
		 setearCampo("idUnidadMineraInsumo",$("#idUnidadMineraInsumo").val());
		 setearCampo("descripcion",$("#idUnidadMineraInsumo option:selected").text());
		 setearCampo("cantidad",$("#cantidad").val());
		 cambiarIndicadorModificado();
		 $("#divModalDetalleForm").modal("hide");
	 }
	
});

$("#abrirDetalleEditar").click(function(){
	$("#btnAgregarDetalle").hide();
	$("#btnEditarDetalle").show();
	var checkDetalle = $('#tablaConsumoDetalle> tbody .checkDetalle:checked');
	if(checkDetalle.length==1){
		var idUnidadMineraInsumoDetalle = checkDetalle.closest("tr").find("td.idUnidadMineraInsumo").text();
		for (var i = 0; i < consumoJSONArray.length; i++) {
			var idUnidadMineraInsumo = consumoJSONArray[i].idUnidadMineraInsumo;
			if(idUnidadMineraInsumo==idUnidadMineraInsumoDetalle){
				$("#idUnidadMineraInsumo").val(idUnidadMineraInsumo).trigger('change');
				$("#cantidad").val(consumoJSONArray[i].cantidad);
				filaIndexDetalle = i;
			}
		}
		$("#divModalDetalleForm").modal("show");
	}else{
		alertify.error("Seleccione un Item.");
	}	
});

function validarInsumo(flag){
	var rpta=true;
	var idUnidadMineraInsumo = $("#idUnidadMineraInsumo").val();
	for (var i = 0; i < consumoJSONArray.length; i++) {
		var _idUnidadMineraInsumo = consumoJSONArray[i].idUnidadMineraInsumo;
		if(flag!="editar"){
			if(_idUnidadMineraInsumo==idUnidadMineraInsumo){
				alertify.error("Ya existe un insumo.");
				rpta=false;
			}
		}else{
			if(i!=filaIndexDetalle){
				if(_idUnidadMineraInsumo==idUnidadMineraInsumo){
					alertify.error("Ya existe un insumo.");
					rpta=false;
				}
			}
		}

	}
	if(parseFloat($("#cantidad").val())==0){
		alertify.error("La cantidad debe ser mayor a 0.");
		rpta=false;
	}
// 	if(cantidad<parseFloat(obtienerStock(idUnidadMineraInsumo))){
// 		alertify.error("No se encuentra dentro del rango de stock del insumo.");
// 		$("#cantidad").val("");
// 		rpta=false;
// 	}
	return rpta;
}

function agregarJsonDetalle(){
	 var mercaderiaJSON = {
			    idDetalle:'',idUnidadMineraInsumo:'',cantidad:'',
			    descripcion:'',unidadMedida:'KG',indicadorBD: INDICADOR_NUEVO};
	 consumoJSONArray.push(mercaderiaJSON);
}

$("#eliminarDetalle").click(function(){
	eliminarDetalle();
});

$("#guardar").click(function(){
	if(fnValidarGuardarConsumo()){
		alertify.confirm("Guardar","¿Usted está seguro de guardar los registros?",
				function(){
			$.ajax({
				type : 'post',
				data: {
					idConsumo:$("#idConsumo").val(),
					idUnidadMinera:$("#idUnidadMinera").val(),
					idUnidadMineraAlmacen:$("#idUnidadMineraAlmacen").val(),
					idUnidadMineraArea:$("#idUnidadMineraArea").val(),
					index:index,
	 				consumoJSONArray: JSON.stringify(consumoJSONArray)
					
				},
				url : '${pageContext.request.contextPath}/registrarConsumo/guardarConsumo.htm',
				success : function(data) {
					if(data!=""){	
						index = actualizarDetalleGrabar(index);						
						$("#idConsumo").val(data);	
						mensajeTransaccion("guardar");											
					}else{
						mensajeTransaccion("error");
					}
					
				}
			});
						  },
				function(){});
	}
});

function fnValidarGuardarConsumo(){
	if(consumoJSONArray.length==0){
		alertify.error("Mínimo debe registrar un detalle");
		return false;
	}
	
	return true;
}

$("#idUnidadMineraInsumo").change(function(){
debugger;
	if($(this).val().trim()!=""){
		$("#stock").val(obtienerStock($(this).val()));
	}else{
		$("#stock").val("");
	}
});

function obtienerStock(idUnidadMineraInsumo){
	var resultado = 0;
			$.ajax({
				type : 'post',
				data: {'idUnidadMineraInsumo': idUnidadMineraInsumo,
					   'idUnidadMineraAlmacen': $("#idUnidadMineraAlmacen").val()
					  },
				url : '${pageContext.request.contextPath}/ajax/obtienerStock.htm',
				async:false,
				success : function(data) {	
					resultado=data;
					
				}
			});
	return resultado;
}
</script>