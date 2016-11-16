<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

$(document).ready(function() {
	
	$('#tablaConsumo').DataTable({
	 	"bSort" : false,
		"columnDefs": [{ className: "center"}]
 	});
} );

function eliminarConsumo(idConsumo) {
	$("#idConsumo").val(idConsumo);
	alertify.confirm("Eliminar","¿Seguro que desea eliminar este Consumo?",
			function(){
				$("#formVerConsumos").submit();
			 },
			function(){});
}

</script>