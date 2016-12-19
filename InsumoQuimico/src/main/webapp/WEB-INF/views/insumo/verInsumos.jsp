<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="row-fluid">
	<div class="span12">
		<form method="POST">
		<input type="hidden" name="id" id="id">		
				<table class="tablaSearch table table-striped table-bordered table-hover">
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
						<c:forEach var="jbean" items="${listaConsulta}"
							varStatus="contador">
							<tr>
								<td class="center"><c:out value="${contador.count}" /></td>
								<td class="center">${jbean.idInsumo}</td>
								<td class="center"><c:out value="${jbean.insumo}"></c:out></td>
								<td class="center"><c:choose>
										<c:when test="${jbean.vigencia=='S'}">
											<span class="label label-success">Vigente</span>
										</c:when>
										<c:otherwise>
											<span class="label label-warning">No Vigente</span>
										</c:otherwise>
									</c:choose></td>
								<td class="center">
									<a class="blue" href="modificar.htm?id=<c:out value="${jbean.idInsumo}" />"> <i
											class="icon-edit bigger-130"></i></a>
									<a class="red" href="#" onclick="eliminarSearch('${jbean.idInsumo}')"> <i
											class="icon-trash bigger-130"></i>
									</a>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
		</form>
	</div>
</div>