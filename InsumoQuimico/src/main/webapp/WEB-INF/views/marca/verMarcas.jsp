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
		<c:choose>
			<c:when test="${empty listaMarcas}">
				<h3>No hay productos disponible. Registrar un producto</h3>
			</c:when>
			<c:otherwise>
				<table id="tablaMarca"
					class="table table-striped table-bordered table-hover">

					<thead>
						<tr>
							<th class="center">N�</th>
							<th class="center">Descripci�n</th>
							<th class="center">Estado</th>
							<th class="center">Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jbean" items="${listaMarcas}"
							varStatus="contador">
							<tr>
								<td class="center"><c:out value="${contador.count}" /></td>
								<td><a
									href="modificarMarca.htm?idMarca=<c:out value="${jbean.id}" />"
									title="Modificar Producto"><c:out value="${jbean.descripcion}"></c:out></a></td>
								<td class="center"><c:choose>
										<c:when test="${jbean.estado==1}">
											<span class="label label-success">Habilitado</span>
										</c:when>

										<c:otherwise>
											<span class="label label-warning">Deshabilitado</span>
										</c:otherwise>
									</c:choose></td>
								<td class="center"><a class="red" href="#" onclick="eliminarMarca('${jbean.id}')"> <i
										class="icon-trash bigger-130"></i>
								</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
</form>

	</div>
	<!--/.span-->
</div>
<!--/.row-fluid-->

<script type="text/javascript">

	function eliminarMarca(idMarca) {
		$("#idMarca").val(idMarca);
		alertify.confirm("Eliminar","�Seguro que desea eliminar esta marca?",
				function(){
					$("#verMarcasForm").submit();
				 },
				function(){});
	}
</script>