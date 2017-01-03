<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var consumoJSONArray  = arrayJsonDetalle;
var index = 1;

$(document).ready(function() {
	tabla="#tablaConsumoDetalle";
	claseColumna=["idUnidadMineraInsumo","descripcion","descripcionPresentacion","cantidad","unidadMedida"];
	inicializarStyleTablaDetalle();
	
	if('<c:out value="${accion}"/>'=="CONSULTAR"){	

		var i=0;
		<c:forEach var="jbean" items="${listaConsumoDetalle}">		
		 	var data = ["${jbean.unidadMineraInsumo.idUnidadMineraInsumo}",
		             "${jbean.unidadMineraInsumo.insumo.insumo}",
		             "${jbean.presentacionInsumo.descripcion}",
		             "${jbean.cantidad}","KG"];
			agregarDetalle(data); 
			consumoJSONArray[i].idDetalle="${jbean.id.idConsumoDetalle}";
			consumoJSONArray[i].idUnidadMineraInsumo="${jbean.unidadMineraInsumo.idUnidadMineraInsumo}";
			consumoJSONArray[i].cantidad="${jbean.cantidad}";
			consumoJSONArray[i].idPresentacionInsumo="${jbean.presentacionInsumo.idPresentacion}";
			consumoJSONArray[i].descripcionPresentacion="${jbean.presentacionInsumo.descripcion}";
			consumoJSONArray[i].unidadMedida="KG";
			consumoJSONArray[i].indicadorBD=INDICADOR_CREADO;
			i++;
		</c:forEach>
		index = "${listaConsumoDetalle.get(listaConsumoDetalle.size()-1).id.idConsumoDetalle+1}";
		bloquearCamposConsultar();
	}
	
	var dataInsumo=[{id:" ",text:"Seleccionar"}];
	<c:forEach var="item" items="${listaUnidadMineraInsumo}">
		var obj = {id:"${item.idUnidadMineraInsumo}",text:"${item.insumo.insumo}"}
		dataInsumo.push(obj);
	</c:forEach>

	$("#idUnidadMineraInsumo").select2({
		  data: dataInsumo
	});
	
	var dataPresentacion=[{id:" ",text:"Seleccionar"}];
	$("#idPresentacionInsumo").select2({
		  data: dataPresentacion
	});
} );

$("#btnAgregarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarInsumo("")){			 	
 		 	var data = [$("#idUnidadMineraInsumo").val(),$("#idUnidadMineraInsumo option:selected").text(),
 		 	          $("#idPresentacionInsumo option:selected").text(), $("#cantidad").val(),"KG"];
 		 	agregarDetalle(data);
 		 	var fila = consumoJSONArray.length-1;
 		 	consumoJSONArray[fila].idUnidadMineraInsumo=$("#idUnidadMineraInsumo").val();
			consumoJSONArray[fila].cantidad=$("#cantidad").val();
			consumoJSONArray[fila].idPresentacionInsumo=$("#idPresentacionInsumo").val();
			consumoJSONArray[fila].descripcionPresentacion=$("#idPresentacionInsumo option:selected").text();
		 	$("#divModalDetalleForm").modal("hide");
	 }
	
});

function agregarDetalle(data){
	 var mercaderiaJSON = {
			    idDetalle:'',idUnidadMineraInsumo:'',cantidad:'',idPresentacionInsumo:'',descripcionPresentacion:'',
			    descripcion:'',unidadMedida:'KG',indicadorBD: INDICADOR_NUEVO};
	consumoJSONArray.push(mercaderiaJSON);	
	agregarFila(data);
}

$("#btnEditarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarInsumo("editar")){	
		 setearCampo("idUnidadMineraInsumo",$("#idUnidadMineraInsumo").val());
		 setearCampo("descripcion",$("#idUnidadMineraInsumo option:selected").text());
		 setearCampo("cantidad",$("#cantidad").val());
		 setearCampo("descripcionPresentacion",$("#idPresentacionInsumo option:selected").text());
		 cambiarIndicadorModificado();
		 $("#divModalDetalleForm").modal("hide");
	 }
	
});

$("#abrirDetalleEditar").click(function(){
	$("#btnAgregarDetalle").hide();
	$("#btnEditarDetalle").show();
	var checkDetalle = $('#tablaConsumoDetalle> tbody .checkDetalle:checked');
	if(checkDetalle.length==1){
		var index = checkDetalle.closest("tr").index();
		var idUnidadMineraInsumoDetalle = checkDetalle.closest("tr").find("td.idUnidadMineraInsumo").text();
		
		$("#idUnidadMineraInsumo").val(consumoJSONArray[index].idUnidadMineraInsumo).trigger('change');
		$("#idPresentacionInsumo").val(consumoJSONArray[index].idPresentacionInsumo).trigger('change');
		$("#cantidad").val(consumoJSONArray[index].cantidad);
		filaIndexDetalle = index;

		$("#divModalDetalleForm").modal("show");
	}else{
		alertify.error("Seleccione un Item.");
	}	
});

function validarInsumo(flag){
	var rpta=true;
	var idUnidadMineraInsumo = $("#idUnidadMineraInsumo").val();
	var cantidad = parseFloat($("#cantidad").val());
	
	for (var i = 0; i < consumoJSONArray.length; i++) {
		var _idUnidadMineraInsumo = consumoJSONArray[i].idUnidadMineraInsumo;
		var _idPresentacionInsumo = consumoJSONArray[i].idPresentacionInsumo;
		if(flag!="editar"){
			if(_idUnidadMineraInsumo==idUnidadMineraInsumo && _idPresentacion==idPresentacion){
				alertify.error("Ya existe un insumo con la misma presentación.");
				rpta=false;
			}
		}else{
			if(i!=filaIndexDetalle){
				if(_idUnidadMineraInsumo==idUnidadMineraInsumo && _idPresentacion==idPresentacion){
					alertify.error("Ya existe un insumo con la misma presentación.");
					rpta=false;
				}
			}
		}

	}
	if(cantidad==0){
		alertify.error("La cantidad debe ser mayor a 0.");
		rpta=false;
	}
	if(cantidad > parseFloat($("#stock").val())){
		alertify.error("No se encuentra dentro del rango de stock del insumo.");
		$("#cantidad").val("");
		rpta=false;
	}
	return rpta;
}

$("#eliminarDetalle").click(function(){
	eliminarDetalle();
});

$("#guardar").click(function(){
	var data = $("#formConsumo").serializeObject();
	data.index = index;
	data.consumoJSONArray = JSON.stringify(consumoJSONArray);
	
	if(fnValidarGuardarConsumo()){
		alertify.confirm("Guardar","¿Usted está seguro de guardar los registros?",
				function(){
			$.ajax({
				type : 'post',
				data: data,
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
	$('#idPresentacionInsumo').empty();
	var objArray = [{id:" ",text:"Seleccionar"}];
	if($(this).val().trim()!=""){
		var insumo = $(this).val().split("-")[1];
		$.ajax({
			type : 'post',
			data: {'idInsumo': insumo},
			url : '${pageContext.request.contextPath}/ajax/listaPresentacionInsumoPorInsumo.htm',
			async:false,
			success : function(data) {	
				var listaPresentacionInsumo = JSON.parse(data);
				for (var i = 0; i < listaPresentacionInsumo.length; i++) {
					objArray.push({id:listaPresentacionInsumo[i].idPresentacionInsumo,
						text:listaPresentacionInsumo[i].descripcion});
				}
			}
		});
	}
	$("#idPresentacionInsumo").select2({
		  data: objArray
	});
	
	if($("#idPresentacionInsumo").val().trim()==""){
		$("#stock").val("");
	}
});

$("#idPresentacionInsumo").change(function(){
	var valor = $(this).val().trim();
	if(valor!=""){
		$("#stock").val(obtenerStockPorArea(valor));
	}else{
		$("#stock").val("");
	}
});

function obtenerStockPorArea(idPresentacionInsumo){

	var resultado = 0;
			$.ajax({
				type : 'post',
				data: {'idUnidadMineraArea': $("#idUnidadMineraArea").val(),
					   'idUnidadMineraInsumo': $("#idUnidadMineraInsumo").val(),
					   'idPresentacionInsumo': idPresentacionInsumo
					  },
				url : '${pageContext.request.contextPath}/ajax/obtenerStockPorArea.htm',
				async:false,
				success : function(data) {	
					resultado=data;
					
				}
			});
	return resultado;
}
</script>