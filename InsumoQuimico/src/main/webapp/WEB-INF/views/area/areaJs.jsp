<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>

<!--inline scripts related to this page-->

<script type="text/javascript">

$(document).ready(function() {
    $('#tablaArea').DataTable({
		"aoColumns" : [ {
			"bSortable" : false
		},null,null,null,{
			"bSortable" : false
		}]
	});
} );
	
</script>