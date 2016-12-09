<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

$(document).ready(function() {
	<c:if test="${flagTransaccion=='eliminar'}">
		alertify.success("Se eliminó correctamente");
	</c:if>

	$('#tablaMercaderia').DataTable({
	 	"bSort" : false,
		"columnDefs": [{ className: "center"}]
 	});
	
} );

function eliminarMercaderia(idMercaderia) {
	$("#idMercaderia").val(idMercaderia);
	alertify.confirm("Eliminar","¿Seguro que desea eliminar esta mercadería?",
			function(){
				$("#formVerMercaderias").submit();
			 },
			function(){});
}

</script>