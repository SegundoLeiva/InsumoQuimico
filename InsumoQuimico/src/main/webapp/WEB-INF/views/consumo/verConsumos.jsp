<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Registrar Consumo <span> <i class="icon-double-angle-right"></i>
		</span><a href="../registrarConsumo/nuevoConsumo.htm" title="Nuevo Consumo" style="margin-left: 5px"
			class="btn btn-info btn-small pull-right"><i class="icon-plus"></i>Nuevo</a>
			<a href="#" title="Buscar" onclick="buscarConsulta()"
			class="btn btn-success btn-small pull-right"><i class="icon-search"></i>Buscar</a>
	</h1>
</div>
<div class="page-header position-relative">
	<form id="formVerConsumos"  action="../registrarConsumo/eliminarConsumo.htm" method="POST" class="form-horizontal">
	<input type="hidden" name="idConsumo" id="idConsumo">	
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
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Inicio</label>
								<div class="controls">
									<input type="text" class="form-control date-picker" name="fechaInicio" id="fechaInicio" readonly="readonly" value="${fechaInicio}">
								</div>
							</div>
							
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idUnidadMineraAlmacen">Almacén</label>
								<div class="controls">									
									<select name="idUnidadMineraAlmacen" id="idUnidadMineraAlmacen">						
										<option value="">Seleccionar</option>
										<c:forEach var="item" items="${listaUnidadMineraAlmacen}">
											<option value="${item.idUnidadMineraAlmacen}" ${item.idUnidadMineraAlmacen == consumoConsulta.idUnidadMineraAlmacen ? 'selected' : ' '}>${item.almacen.almacen}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Fin</label>
								<div class="controls">
									<input type="text" class="form-control date-picker" name="fechaFin" id="fechaFin" readonly="readonly" value="${fechaFin}">
								</div>
							</div>

						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idUnidadMineraArea">Área</label>
								<div class="controls">									
									<select name="idUnidadMineraArea" id="idUnidadMineraArea">						
										<option value="">Seleccionar</option>
										<c:forEach var="item" items="${listaUnidadMineraArea}">
											<option value="${item.idUnidadMineraArea}" ${item.idUnidadMineraArea == consumoConsulta.idUnidadMineraArea ? 'selected' : ' '}>${item.area.area}</option>
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
	<table id="tablaConsumo"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">Nro</th>
							<th class="center">Código</th>
							<th class="center">Almacén</th>
							<th class="center">Área</th>
							<th class="center">Cantidad Total</th>
							<th class="center" width="10%">Opciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jbean" items="${listaConsumoConsulta}"
							varStatus="contador">
							<tr>
								<td class="center">${contador.count}</td>
								<td class="center"><a
									href="modificarConsumo.htm?idConsumo=<c:out value="${jbean.idConsumo}" />"
									title="Modificar Consumo">${jbean.idConsumo}</a></td>
								<td class="center">${jbean.almacen}</td>
								<td class="center">${jbean.area}</td>
								<td class="center">${jbean.cantidad}</td>
								<td class="center"><a class="red" href="#" onclick="eliminarConsumo('${jbean.idConsumo}')"> <i
										class="icon-trash bigger-130"></i>
								</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>