<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

var dataAreas=[];

$(document).ready(function() {
	
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

$("#idUnidadMinera").change(function(){
	
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