<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header position-relative">
	<form method="POST" class="form-horizontal">
	<input type="hidden" name="id" id="id">	
		<div class="row-fluid">
			<div class="page-content">

			<div class="span8">
					<input type="hidden" value="${accion}" id="accion">
					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="idUnidadMinera">Unidad Minera</label>
								<div class="controls selectInsumo">
									<select name="idUnidadMinera" id="idUnidadMinera">
										<c:forEach var="item" items="${listaUnidadesMineras}">
												<option value="${item.valorOrganizacional}" ${item.valorOrganizacional == beanConsulta.idUnidadMinera ? 'selected' : ' '}>${item.descripcion}</option>
										</c:forEach>
									</select>
								</div>
							</div>	
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="idUnidadMineraArea">Área</label>
								<div class="controls selectInsumo">									
									<select name="idUnidadMineraArea" id="idUnidadMineraArea">						
	
									</select>
								</div>
							</div>	
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="idUnidadMineraInsumoPresentacion">Insumo Presentación</label>
								<div class="controls selectInsumo">									
									<select name="idUnidadMineraInsumoPresentacion" id="idUnidadMineraInsumoPresentacion">						
										
									</select>
								</div>
							</div>
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Inicio</label>
								<div class="controls">
									<input type="text" name="fechaInicio" id="fechaInicio" class="inputInsumo date-picker" readonly="readonly" value="${beanConsulta.fechaInicio}"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Inicio</label>
								<div class="controls">
										<input type="text" name="fechaFin" id="fechaFin" class="inputInsumo date-picker" readonly="readonly" value="${beanConsulta.fechaFin}">
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
							<th class="center">Área</th>
							<th class="center">Insumo Presentación</th>
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
								<td class="center">${jbean.unidadMineraArea}</td>
								<td class="center">${jbean.unidadMineraInsumoPresentacion}</td>								
								<td class="center">${jbean.cantidad}</td>
								<td class="center">${jbean.fechaCreacion}</td>
								<td class="center">
									<a class="green" href="consultar.htm?id=<c:out value="${jbean.idDistribucionMercaderia}" />"> <i
										title="Consultar" class="icon-align-justify bigger-130"></i></a>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>