<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="row-fluid">
	<div class="span12">

		<div class="table-header"
			style="background: #2283c5; padding-left: 5px; padding-bottom: 2px;">

			<a href="../sistema/nuevoProducto.htm" data-toggle="modal"
				title="Nueva Marca" class="btn btn-small btn-primary"
				style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Agregar
				Área</a>

		</div>
		<form id="verMarcasForm" action="../sistema/eliminarMarca.htm" method="POST">
		<input type="hidden" id="idMarca" name="idMarca">

				<table id="tablaArea"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">Nro</th>
							<th class="center">Código</th>
							<th class="center">Descripción</th>
							<th class="center">Estado</th>
							<th class="center">Opciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jbean" items="${listaAreas}"
							varStatus="contador">
							<tr>
								<td class="center"><c:out value="${contador.count}" /></td>
								<td class="center"><a
									href="#"
									title="Modificar Producto"><c:out value="${jbean.idUnidadMineraArea}"></c:out></a></td>
								<td class="center"><c:out value="${jbean.area.area}"></c:out></td>
								<td class="center"><c:choose>
										<c:when test="${jbean.vigencia=='S'}">
											<span class="label label-success">Vigente</span>
										</c:when>
										<c:otherwise>
											<span class="label label-warning">No Vigente</span>
										</c:otherwise>
									</c:choose></td>
								<td class="center"><a class="red" href="#" onclick=""> <i
										class="icon-trash bigger-130"></i>
								</a></td>

							</tr>
						</c:forEach>
					</tbody>
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