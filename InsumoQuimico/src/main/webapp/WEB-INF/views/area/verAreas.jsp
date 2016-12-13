<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="row-fluid">
	<div class="span12">
		<form method="POST">
		<input type="hidden" name="id" id="id">		
				<table class="tablaSearch table table-striped table-bordered table-hover">
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
						<c:forEach var="jbean" items="${listaConsulta}"
							varStatus="contador">
							<tr>
								<td class="center"><c:out value="${contador.count}" /></td>
								<td class="center"><a
									href="modificar.htm?id=<c:out value="${jbean.idUnidadMineraArea}" />"
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
								<td class="center"><a class="red" href="#" onclick="eliminarSearch('${jbean.idUnidadMineraArea}')"> <i
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
