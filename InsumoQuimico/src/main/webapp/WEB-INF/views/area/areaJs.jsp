<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

$(document).ready(function() {
	<c:if test="${flagTransaccion=='error'}">
		alertify.error("Se produjo un error");
	</c:if>
	<c:if test="${flagTransaccion=='eliminar'}">
		alertify.success("Se eliminó correctamente");
	</c:if>
	<c:if test="${flagTransaccion=='guardar'}">
		alertify.success("Se guardó correctamente");
	</c:if>
	<c:if test="${flagTransaccion=='modificar'}">
		alertify.success("Se modificó correctamente");
	</c:if>
	 
    $('#tablaArea').DataTable({
		"aoColumns" : [ {
			"bSortable" : false
		},null,null,null,{
			"bSortable" : false
		}]
	});
} );

function eliminarUnidadMineraArea(idUnidadMineraArea) {
	$("#idUnidadMineraAreaEliminar").val(idUnidadMineraArea);
	alertify.confirm("Eliminar","¿Seguro que desea eliminar esta área?",
			function(){
				$("#formVerUnidadMineraArea").submit();
			 },
			function(){});
}

$("#agregarArea").click(function(){
	if(validarCamposRequeridos("formUnidadMineraArea")){
		alertify.confirm("Confirmar","¿Esta seguro realizar esta operación?",
				function(){
					var url = '${pageContext.request.contextPath}/area/agregarArea.htm';
				    $.ajax({
				           type: "POST",
				           url: url,
				           data: $("#formUnidadMineraArea").serialize(),
				           success: function(data)
				           {	
				        	   if($("#idUnidadMineraArea").val()==""){limpiarArea()};
				        	   mensajeTransaccion(data);
				           }
				    });
						  },
				function(){});
	}

});

function limpiarArea(){
// 	$("#idUnidadMineraArea").val("");
	$("#formUnidadMineraArea select").val("");
}

function modificarArea(idUnidadMineraArea){
	$.ajax({
		type : 'post',
		data: {
			'idUnidadMineraArea':idUnidadMineraArea
			},
		url : '${pageContext.request.contextPath}/area/obtenerUnidadMineraArea.htm',
		success : function(data) {	
			obj = JSON.parse(data);
			$("#idUnidadMineraArea").val(obj.idUnidadMineraArea);
			$("#idUnidadMinera").val(obj.idUnidadMinera);
			$("#idArea").val(obj.area.idArea);
			$("#vigencia").val(obj.vigencia);
			$("#tituloText").html("Modificar Área");
			$("#agregarArea").html("Modificar");
			$("#nuevaArea").modal("show");
		}
	});
}
	
</script>