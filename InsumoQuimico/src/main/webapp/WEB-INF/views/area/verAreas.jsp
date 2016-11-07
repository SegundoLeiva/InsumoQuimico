<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="row-fluid">
	<div class="span12">

		<div class="table-header"
			style="background: #2283c5; padding-left: 5px; padding-bottom: 2px;">

			<a href="../sistema/nuevoProducto.htm" data-toggle="modal"
				title="Nueva Marca" class="btn btn-small btn-primary"
				style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Registrar
				Marca</a>

		</div>
		<form id="verMarcasForm" action="../sistema/eliminarMarca.htm" method="POST">
		<input type="hidden" id="idMarca" name="idMarca">

				<table id="tablaArea"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center">Código</th>
							<th class="center">Descripción</th>
							<th class="center">Estado</th>
						</tr>
					</thead>
				</table>
</form>

	</div>
	<!--/.span-->
</div>
<!--/.row-fluid-->

<script type="text/javascript">

	function eliminarMarca(idMarca) {
		$("#idMarca").val(idMarca);
		alertify.confirm("Eliminar","¿Seguro que desea eliminar esta marca?",
				function(){
					$("#verMarcasForm").submit();
				 },
				function(){});
	}
</script>