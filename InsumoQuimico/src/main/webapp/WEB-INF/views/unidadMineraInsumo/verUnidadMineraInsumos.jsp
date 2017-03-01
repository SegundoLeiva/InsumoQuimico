<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header position-relative">
	<form method="POST" class="form-horizontal">
		<input type="hidden" name="id" id="id">		
		<div class="row-fluid">
			<div class="page-content">
				<div class="span12">

					<div class="row-fluid">
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idUnidadMinera">Unidad Minera</label>
								<div class="controls">
									<select name="idUnidadMinera" id="idUnidadMinera">
										<c:forEach var="item" items="${listaUnidadesMineras}">
											<option value="${item.valorOrganizacional}" ${item.valorOrganizacional == beanConsulta.idUnidadMinera ? 'selected' : ' '}>${item.descripcion}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							
						</div>

					</div>
				</div>
			</div>

		</div>

	</form>
	<hr>
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
								<td class="center">${jbean.idUnidadMineraInsumo}</td>
								<td class="center"><c:out value="${jbean.insumo.insumo}"></c:out></td>
								<td class="center"><c:choose>
										<c:when test="${jbean.vigencia=='S'}">
											<span class="label label-success">Vigente</span>
										</c:when>
										<c:otherwise>
											<span class="label label-warning">No Vigente</span>
										</c:otherwise>
									</c:choose></td>
								<td class="center">
<%-- 									<a class="blue" href="modificar.htm?id=<c:out value="${jbean.idUnidadMineraInsumo}" />"> <i --%>
<!-- 													class="icon-edit bigger-130"></i></a> -->
									<a class="red" href="#" onclick="eliminarSearch('${jbean.idUnidadMineraInsumo}')"> <i
											class="icon-trash bigger-130"></i>
									</a>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>