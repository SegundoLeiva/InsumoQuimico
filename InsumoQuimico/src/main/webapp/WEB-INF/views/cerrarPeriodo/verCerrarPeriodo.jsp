<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header position-relative">
	<form method="POST" class="form-horizontal" id="formCierrePeriodo">
		<input type="hidden" id="mes" name="mes">
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
											<option value="${item.valorOrganizacional}">${item.descripcion}</option>
										</c:forEach>
									</select>
								</div>
							</div>						
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="anio">Año</label>
								<div class="controls">	
									<select name="anio" id="anio">
										<c:forEach var="i" begin="${listRangoAnio[0].id.idCatalogoDetalle}" end="${listRangoAnio[1].id.idCatalogoDetalle}" step="1" varStatus="loop">
											<option value="${loop.end - i + loop.begin}" ${loop.end - i + loop.begin == beanConsulta.anio ? 'selected' : ' '}>${loop.end - i + loop.begin}</option>
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
	<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">Nro</th>
							<th class="center">Año</th>
							<th class="center">Mes</th>
							<th class="center">Estado Apertura</th>
							<th class="center">Opciones</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="jbean" items="${listaConsulta}"
							varStatus="contador">
							<tr>
								<td class="center">${contador.count}</td>
								<td class="center">${jbean.id.idAnioGestion}</td>
								<c:choose>
									<c:when test="${jbean.id.idMesGestion=='01'}">
										<td class="center">Enero</td>
									</c:when>
									<c:when test="${jbean.id.idMesGestion=='02'}">
										<td class="center">Febrero</td>
									</c:when>
									<c:when test="${jbean.id.idMesGestion=='03'}">
										<td class="center">Marzo</td>
									</c:when>
									<c:when test="${jbean.id.idMesGestion=='04'}">
										<td class="center">Abril</td>
									</c:when>
									<c:when test="${jbean.id.idMesGestion=='05'}">
										<td class="center">Mayo</td>
									</c:when>
									<c:when test="${jbean.id.idMesGestion=='06'}">
										<td class="center">Junio</td>
									</c:when>
									<c:when test="${jbean.id.idMesGestion=='07'}">
										<td class="center">Julio</td>
									</c:when>
									<c:when test="${jbean.id.idMesGestion=='08'}">
										<td class="center">Agosto</td>
									</c:when>
									<c:when test="${jbean.id.idMesGestion=='09'}">
										<td class="center">Septiembre</td>
									</c:when>
									<c:when test="${jbean.id.idMesGestion=='10'}">
										<td class="center">Octubre</td>
									</c:when>
									<c:when test="${jbean.id.idMesGestion=='11'}">
										<td class="center">Noviembre</td>
									</c:when>
									<c:when test="${jbean.id.idMesGestion=='12'}">
										<td class="center">Diciembre</td>
									</c:when>
								</c:choose>		
								<c:choose>
									<c:when test="${jbean.aperturado=='N'}">
										<td class="center"><span class="label label-warning">Cerrado</span></td>
									</c:when>
									<c:when test="${jbean.aperturado=='S'}">
										<td class="center"><span class="label label-success">Abierto</span></td>
									</c:when>
								</c:choose>					
								<td class="center">
									<a class="blue" href="consultar.htm?id=<c:out value="${jbean.id.idUnidadMinera},${jbean.id.idAnioGestion},${jbean.id.idMesGestion}" />"
										title="Consultar"> <i
											class="icon-align-justify bigger-130"></i>
									</a>
									<a class="green" onclick="cambiarApertura('${jbean.id.idMesGestion}')" href="#"
										title="Cambiar Apertura"> <i
											class="icon-edit bigger-130"></i>
									</a>
								</td>							
							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>