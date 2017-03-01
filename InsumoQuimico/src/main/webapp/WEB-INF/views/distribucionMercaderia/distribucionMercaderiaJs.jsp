<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

var dataInsumo=[];

$(document).ready(function() {
	
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
	
 	
 	if($("#accion").val()=="CONSULTAR"){	
 		$("#bloqueStock").hide();
		bloquearCamposConsultar();
	}

 	var idPresentacionInsumo ="${distribucionMercaderia.unidadMineraInsumoPresentacion.idUnidadMineraInsumoPresentacion}";

 	if(idPresentacionInsumo.trim()!=""){
 		$("#idUnidadMineraInsumoPresentacion").val(idPresentacionInsumo).trigger('change');
 	}
	
});

$("#idUnidadMineraInsumoPresentacion").change(function(){
	if($(this).val().trim()!=""){
		$("#stock").val(obtienerStockAlmacen($(this).val));		
	}else{
		$("#stock").val("");
	}

});


function obtienerStockAlmacen(idUnidadMineraInsumoPresentacion){
	var resultado = 0;
			$.ajax({
				type : 'post',
				data: {'idUnidadMineraInsumoPresentacion': $("#idUnidadMineraInsumoPresentacion").val()
					  },
				url : '${pageContext.request.contextPath}/ajax/obtienerStockAlmacen.htm',
				async:false,
				success : function(data) {	
					resultado=data;
					
				}
			});
	return resultado;
}

$("#guardar").click(function(){
	if(fnValidarGuardarMercaderia()){
		guardarMantenimiento();
	}

});

function fnValidarGuardarMercaderia(){
	var cantidad = parseFloat($("#cantidad").val());
	var stock = parseFloat($("#stock").val());
	if(!validarCamposRequeridos("formDistribucionMercaderia")){
		return false;
	}else if(cantidad==0){
		alertify.error("El campo Cantidad debe ser mayor a 0");
		return false;
	}else if(cantidad > stock){
		alertify.error("No se encuentra dentro del rango de stock del insumo.");
		return false;
	}else{
		return true;
	}
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

});

</script>