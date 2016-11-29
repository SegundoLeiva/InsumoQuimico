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
	 
    $('#tablaInsumo').DataTable({
		"aoColumns" : [ {
			"bSortable" : false
		},null,null,null,{
			"bSortable" : false
		}]
	});
} );

function eliminarUnidadMineraInsumo(idUnidadMineraInsumo) {
	$("#idUnidadMineraInsumoEliminar").val(idUnidadMineraInsumo);
	alertify.confirm("Eliminar","¿Seguro que desea eliminar este insumo?",
			function(){
				$("#formVerUnidadMineraInsumo").submit();
			 },
			function(){});
}

$("#agregarInsumo").click(function(){
	if(validarCamposRequeridos("formUnidadMineraInsumo")){
		alertify.confirm("Confirmar","¿Esta seguro realizar esta operación?",
				function(){
					var url = '${pageContext.request.contextPath}/insumo/agregarInsumo.htm';
				    $.ajax({
				           type: "POST",
				           url: url,
				           data: $("#formUnidadMineraInsumo").serialize(),
				           success: function(data)
				           {	
				        	   if($("#idUnidadMineraInsumo").val()==""){limpiarCampos("formUnidadMineraInsumo")};
				        	   mensajeTransaccion(data);
				           }
				    });
						  },
				function(){});
	}

});
	
</script>