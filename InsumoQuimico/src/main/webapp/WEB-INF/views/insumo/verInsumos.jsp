<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Mantenimiento de Insumos <span> <i class="icon-double-angle-right"></i>
		</span><a href="../insumo/nuevoInsumo.htm" title="Nuevo Insumo"
			class="btn btn-success btn-small pull-right"><i class="icon-plus"></i>Agregar</a>
	</h1>
</div>
<div class="row-fluid">
	<div class="span12">
		<form id="formVerUnidadMineraInsumo" action="../insumo/eliminarUnidadMineraInsumo.htm" method="POST">
		<input type="hidden" name="idUnidadMineraInsumo" id="idUnidadMineraInsumoEliminar">		
				<table id="tablaInsumo"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">Nro</th>
							<th class="center">Código</th>
							<th class="center">Descripción</th>
							<th class="center">Estado</th>
							<th class="center" width="10%">Opciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jbean" items="${listaUnidadMineraInsumo}"
							varStatus="contador">
							<tr>
								<td class="center"><c:out value="${contador.count}" /></td>
								<td class="center"><a
									href="modificarInsumo.htm?idUnidadMineraInsumo=<c:out value="${jbean.idUnidadMineraInsumo}" />"
									title="Modificar Insumo"><c:out value="${jbean.idUnidadMineraInsumo}"></c:out></a></td>
								<td class="center"><c:out value="${jbean.insumo.insumo}"></c:out></td>
								<td class="center"><c:choose>
										<c:when test="${jbean.vigencia=='S'}">
											<span class="label label-success">Vigente</span>
										</c:when>
										<c:otherwise>
											<span class="label label-warning">No Vigente</span>
										</c:otherwise>
									</c:choose></td>
								<td class="center"><a class="red" href="#" onclick="eliminarUnidadMineraInsumo('${jbean.idUnidadMineraInsumo}')"> <i
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
