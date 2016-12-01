<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Mantenimiento de �rea <span> <i class="icon-double-angle-right"></i>
		</span><a href="../area/nuevaArea.htm" title="Nueva �rea"
			class="btn btn-success btn-small pull-right"><i class="icon-plus"></i>Agregar</a>
	</h1>
</div>
<div class="row-fluid">
	<div class="span12">
		<form id="formVerUnidadMineraArea" action="../area/eliminarUnidadMineraArea.htm" method="POST">
		<input type="hidden" name="idUnidadMineraArea" id="idUnidadMineraAreaEliminar">		
				<table id="tablaArea"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">Nro</th>
							<th class="center">C�digo</th>
							<th class="center">Descripci�n</th>
							<th class="center">Estado</th>
							<th class="center" width="10%">Opciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jbean" items="${listaUnidadMineraArea}"
							varStatus="contador">
							<tr>
								<td class="center"><c:out value="${contador.count}" /></td>
								<td class="center"><a
									href="modificarArea.htm?idUnidadMineraArea=<c:out value="${jbean.idUnidadMineraArea}" />"
									title="Modificar �rea"><c:out value="${jbean.idUnidadMineraArea}"></c:out></a></td>
								<td class="center"><c:out value="${jbean.area.area}"></c:out></td>
								<td class="center"><c:choose>
										<c:when test="${jbean.vigencia=='S'}">
											<span class="label label-success">Vigente</span>
										</c:when>
										<c:otherwise>
											<span class="label label-warning">No Vigente</span>
										</c:otherwise>
									</c:choose></td>
								<td class="center"><a class="red" href="#" onclick="eliminarUnidadMineraArea('${jbean.idUnidadMineraArea}')"> <i
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
