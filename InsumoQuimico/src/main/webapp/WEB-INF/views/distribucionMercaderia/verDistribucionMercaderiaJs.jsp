<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

var dataInsumo=[];
var dataAreas=[];

$(document).ready(function() {
	
	<c:forEach var="item" items="${listaUnidadMineraInsumoPresentacion}">
		var obj = {id:"${item.idUnidadMineraInsumoPresentacion}",text:"${item.presentacionInsumo.insumo.insumo} - ${item.presentacionInsumo.descripcion}",
				pesoNeto:"${item.presentacionInsumo.pesoNeto}",unidadMedidaPresentacion:"${item.presentacionInsumo.idUnidadMedidaPresentacion}",idUnidadMinera:"${item.idUnidadMinera}"}
		dataInsumo.push(obj);
	</c:forEach>
	
	<c:forEach var="item" items="${listaUnidadMineraArea}">
		var obj = {id:"${item.idUnidadMineraArea}",text:"${item.area.area}",idUnidadMinera:"${item.idUnidadMinera}"}
		dataAreas.push(obj);
	</c:forEach>
	
	cargarComboInsumo();
	cargarComboAreas();

 	var idUnidadMineraInsumoPresentacion = "${beanConsulta.idUnidadMineraInsumoPresentacion}";
 	if(idUnidadMineraInsumoPresentacion.trim()!=""){
 		$("#idUnidadMineraInsumoPresentacion").val(idUnidadMineraInsumoPresentacion).trigger('change');
 	}
 	
 	var idUnidadMineraArea = "${beanConsulta.idUnidadMineraArea}";
 	if(idUnidadMineraArea.trim()!=""){
 		$("#idUnidadMineraArea").val(idUnidadMineraArea).trigger('change');
 	}
	
});

$("#idUnidadMinera").change(function(){
	
	$('#idUnidadMineraInsumoPresentacion').empty();
	$('#idUnidadMineraArea').empty();
	
	cargarComboInsumo();
	cargarComboAreas();

});

function cargarComboInsumo(){
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
}

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