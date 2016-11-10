<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

$(document).ready(function() {
	
	 $('#tablaMercaderia').DataTable({
			"aoColumns" : [ {"bSortable" : false},
			                {"bSortable" : false},
			                {"bSortable" : false},
			                {"bSortable" : false},
			                {"bSortable" : false}
			               ]
	 });
} );

</script>