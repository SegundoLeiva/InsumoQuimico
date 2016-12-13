<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

$(document).ready(function() {
	<c:if test="${flagTransaccion=='eliminar'}">
		alertify.success("Se eliminó correctamente");
	</c:if>
	$('#tablaConsumo').DataTable({
	 	"bSort" : false,
		"columnDefs": [{ className: "center"}]
 	});
} );

function eliminarConsumo(idConsumo) {
	$("#id").val(idConsumo);
	alertify.confirm("Eliminar","¿Seguro que desea eliminar este Consumo?",
			function(){
				$("#formVerConsumos").submit();
			 },
			function(){});
}

</script>