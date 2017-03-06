<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var consumoJSONArray  = arrayJsonDetalle;
var index = 1;
var dataInsumo=[];
var dataAreas=[];

$(document).ready(function() {
	tabla="#tablaConsumoDetalle";
	claseColumna=["idUnidadMineraInsumoPresentacion","descripcionPresentacion","cantidad","unidadMedida"];
	inicializarStyleTablaDetalle();
	
	if('<c:out value="${accion}"/>'!=""){	
		$("#codigoGenerado").html("N° "+$("#idConsumo").val());
		var i=0;
		<c:forEach var="jbean" items="${listaConsumoDetalle}">		
		 	var data = ["${jbean.unidadMineraInsumoPresentacion.idUnidadMineraInsumoPresentacion}",
		             	"${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.insumo.insumo}"+" - "+"${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.descripcion}",
		                "${jbean.cantidad}","KG"];
			agregarDetalle(data); 
			consumoJSONArray[i].idDetalle="${jbean.id.idConsumoDetalle}";
			consumoJSONArray[i].idUnidadMineraInsumoPresentacion="${jbean.unidadMineraInsumoPresentacion.idUnidadMineraInsumoPresentacion}";
			consumoJSONArray[i].cantidad="${jbean.cantidad}";
			consumoJSONArray[i].pesoNeto="${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.pesoNeto}";
			consumoJSONArray[i].descripcionPresentacion="${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.descripcion}";
			consumoJSONArray[i].unidadMedidaPresentacion="${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.idUnidadMedidaPresentacion}";
			consumoJSONArray[i].indicadorBD=INDICADOR_CREADO;
			i++;
		</c:forEach>
		index = "${listaConsumoDetalle.get(listaConsumoDetalle.size()-1).id.idConsumoDetalle+1}";
		
		if('<c:out value="${accion}"/>'=="CONSULTAR"){
			bloquearCamposConsultar();		
		}
	}
	
	<c:forEach var="item" items="${listaUnidadMineraInsumoPresentacion}">
		var obj = {id:"${item.idUnidadMineraInsumoPresentacion}",text:"${item.presentacionInsumo.insumo.insumo} - ${item.presentacionInsumo.descripcion}",
				pesoNeto:"${item.presentacionInsumo.pesoNeto}",unidadMedidaPresentacion:"${item.presentacionInsumo.idUnidadMedidaPresentacion}",idUnidadMinera:"${item.idUnidadMinera}"}
		dataInsumo.push(obj);
	</c:forEach>

	var dataInsumoTemp = [];
	dataInsumoTemp = [{id:" ",text:"Seleccionar",pesoNeto:"",unidadMedidaPresentacion:"",idUnidadMinera:""}];
	for (var i = 0; i < dataInsumo.length; i++) {
		if($("#idUnidadMinera").val()==dataInsumo[i].idUnidadMinera){
			dataInsumoTemp.push(dataInsumo[i]);
		}
	}
	
	$("#idUnidadMineraInsumoPresentacion").select2({
	  data: dataInsumoTemp
	});
	
	<c:forEach var="item" items="${listaUnidadMineraArea}">
		var obj = {id:"${item.idUnidadMineraArea}",text:"${item.area.area}",idUnidadMinera:"${item.idUnidadMinera}"}
		dataAreas.push(obj);
	</c:forEach>

	cargarComboAreas();

	var idUnidadMineraArea = "${beanConsulta.idUnidadMineraArea}";
	if(idUnidadMineraArea.trim()!=""){
		$("#idUnidadMineraArea").val(idUnidadMineraArea).trigger('change');
	}

} );

$("#btnAgregarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarInsumo("")){			 	
 		 	var data = [$("#idUnidadMineraInsumoPresentacion").val(),$("#idUnidadMineraInsumoPresentacion option:selected").text(),
 		 	            $("#cantidad").val(),"KG"];
 		 	agregarDetalle(data);
 		 	var fila = consumoJSONArray.length-1;
 		 	consumoJSONArray[fila].idUnidadMineraInsumoPresentacion=$("#idUnidadMineraInsumoPresentacion").val();
 		 	consumoJSONArray[fila].cantidad=$("#cantidad").val();
 		 	consumoJSONArray[fila].pesoNeto=$("#pesoNeto").val();
			consumoJSONArray[fila].descripcionPresentacion=$("#idUnidadMineraInsumoPresentacion option:selected").text();
		 	$("#divModalDetalleForm").modal("hide");
	 }
	
});

function agregarDetalle(data){
	 var mercaderiaJSON = {
			    idDetalle:'',idUnidadMineraInsumoidPresentacion:'',cantidad:'',pesoNeto:'',descripcionPresentacion:'',
			    unidadMedidaPresentacion:'KG',indicadorBD: INDICADOR_NUEVO};
	consumoJSONArray.push(mercaderiaJSON);	
	agregarFila(data);
}

$("#btnEditarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarInsumo("editar")){	
		 setearCampo("idUnidadMineraInsumoPresentacion",$("#idUnidadMineraInsumoPresentacion").val());
		 setearCampo("descripcion",$("#idUnidadMineraInsumo option:selected").text());
		 setearCampo("cantidad",$("#cantidad").val());
		 setearCampo("descripcionPresentacion",$("#idUnidadMineraInsumoPresentacion option:selected").text());
		 consumoJSONArray[filaIndexDetalle].pesoNeto=$("#pesoNeto").val(); 
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
		
		$("#idUnidadMineraInsumoPresentacion").val(consumoJSONArray[index].idUnidadMineraInsumoPresentacion).trigger('change');
		$("#cantidad").val(consumoJSONArray[index].cantidad);
		$("#pesoNeto").val(consumoJSONArray[index].pesoNeto);
		filaIndexDetalle = index;

		$("#divModalDetalleForm").modal("show");
	}else{
		alertify.error("Seleccione un Item.");
	}	
});

function validarInsumo(flag){
	var rpta=true;
	var idUnidadMineraInsumoPresentacion = $("#idUnidadMineraInsumoPresentacion").val();
	var cantidad = parseFloat($("#cantidad").val());
	
	for (var i = 0; i < consumoJSONArray.length; i++) {
		var _idUnidadMineraInsumoPresentacion = consumoJSONArray[i].idUnidadMineraInsumoPresentacion;
		var _idPresentacionInsumoPresentacion = consumoJSONArray[i].idPresentacionInsumoPresentacion;
		if(flag!="editar"){
			if(_idUnidadMineraInsumoPresentacion==idUnidadMineraInsumoPresentacion){
				alertify.error("Ya existe un insumo con la misma presentación.");
				rpta=false;
			}
		}else{
			if(i!=filaIndexDetalle){
				if(_idUnidadMineraInsumoPresentacion==idUnidadMineraInsumoPresentacion){
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
						$("#codigoGenerado").html("N° "+data);
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

$("#idUnidadMineraInsumoPresentacion").change(function(){
	if($(this).val().trim()!=""){
		for (var i = 0; i < dataInsumo.length; i++) {
			if(dataInsumo[i].id==$(this).val()){
				$("#unidadMedidaPresentacion").val(dataInsumo[i].unidadMedidaPresentacion);
				$("#pesoNeto").val(dataInsumo[i].pesoNeto);
				$("#stock").val(obtenerStockPorArea($(this).val()));
				break;
			}
		}
		
	}else{
		$("#stock").val("");
	}
});


function obtenerStockPorArea(idUnidadMineraInsumoPresentacion){

	var resultado = 0;
			$.ajax({
				type : 'post',
				data: {'idUnidadMineraArea': $("#idUnidadMineraArea").val(),
					   'idUnidadMineraInsumoPresentacion': $("#idUnidadMineraInsumoPresentacion").val()
					  },
				url : '${pageContext.request.contextPath}/ajax/obtenerStockPorArea.htm',
				async:false,
				success : function(data) {	
					resultado=data;
					
				}
			});
	return resultado;
}

$("#idUnidadMinera").change(function(){
	
	$('#idUnidadMineraInsumoPresentacion').empty();
	var dataInsumoTemp = [];
	dataInsumoTemp = [{id:" ",text:"Seleccionar",pesoNeto:"",unidadMedidaPresentacion:"",idUnidadMinera:""}];
	for (var i = 0; i < dataInsumo.length; i++) {
		if($("#idUnidadMinera").val()==dataInsumo[i].idUnidadMinera){
			dataInsumoTemp.push(dataInsumo[i]);
		}
	}
	$("#idUnidadMineraInsumoPresentacion").select2({
		  data: dataInsumoTemp
	});
	
	$('#idUnidadMineraArea').empty();
	
	cargarComboAreas();

});

function cargarComboAreas(){
	var dataAreasTemp=[];
	dataAreasTemp = [{id:" ",text:"Seleccionar",idUnidadMinera:""}];
	for (var i = 0; i < dataAreas.length; i++) {
		if($("#idUnidadMinera").val()==dataAreas[i].idUnidadMinera){
			dataAreasTemp.push(dataAreas[i]);
		}
	}
	
	$("#idUnidadMineraArea").select2({
		  data: dataAreasTemp
	});
}
</script>