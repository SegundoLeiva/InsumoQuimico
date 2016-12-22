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
								<label class="control-label" for="idUnidadMineraArea">Área</label>
								<div class="controls">									
									<select name="idUnidadMineraArea" id="idUnidadMineraArea">						
										<option value="">Seleccionar</option>
										<c:forEach var="item" items="${listaUnidadMineraArea}">
											<option value="${item.idUnidadMineraArea}" ${item.idUnidadMineraArea == beanConsulta.idUnidadMineraArea ? 'selected' : ' '}>${item.area.area}</option>
										</c:forEach>
									</select>
								</div>
							</div>	
							<div class="control-group">
								<label class="control-label" for="idUnidadMinera">Unidad Minera</label>
								<div class="controls">
									<select name="idUnidadMinera" id="idUnidadMinera" disabled="disabled">
										<c:forEach var="item" items="${listaUnidadesMineras}">
											<option value="${item.valorOrganizacional}">${item.descripcion}</option>
										</c:forEach>
									</select>
								</div>
							</div>	
							
							
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idUnidadMineraInsumo">Insumo</label>
								<div class="controls">									
									<select name="idUnidadMineraInsumo" id="idUnidadMineraInsumo">						
										<option value="">Seleccionar</option>
										<c:forEach var="item" items="${listaUnidadMineraInsumo}">
											<option value="${item.idUnidadMineraInsumo}" ${item.idUnidadMineraInsumo == beanConsulta.idUnidadMineraInsumo ? 'selected' : ' '}>${item.insumo.insumo}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Inicio</label>
								<div class="controls">
									<input type="text" class="form-control date-picker" name="fechaInicio" id="fechaInicio" readonly="readonly" value="${beanConsulta.fechaInicio}">
								</div>
							</div>
							

						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idPresentacionInsumo">Presentacion</label>
								<div class="controls">
									<select id="idPresentacionInsumo" name="idPresentacionInsumo">
									</select>
								</div>
							</div>	
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Fin</label>
								<div class="controls">
									<input type="text" class="form-control date-picker" name="fechaFin" id="fechaFin" readonly="readonly" value="${beanConsulta.fechaFin}">
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
							<th class="center">Insumo</th>
							<th class="center">Área</th>
							<th class="center">Presentación</th>
							<th class="center">Cantidad</th>
							<th class="center">Fecha Creación</th>
							<th class="center" width="10%">Opciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jbean" items="${listaConsulta}"
							varStatus="contador">
							<tr>
								<td class="center">${contador.count}</td>
								<td class="center">${jbean.unidadMineraInsumo}</td>
								<td class="center">${jbean.unidadMineraArea}</td>
								<td class="center">${jbean.presentacionInsumo}</td>
								<td class="center">${jbean.cantidad}</td>
								<td class="center">${jbean.fechaCreacion}</td>
								<td class="center">
									<a class="green" href="consultar.htm?id=<c:out value="${jbean.idDistribucionMercaderia}" />"> <i
											class="icon-align-justify bigger-130"></i></a>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>