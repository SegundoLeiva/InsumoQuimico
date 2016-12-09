<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Ingresar Mercadería <span> <i class="icon-double-angle-right"></i>
		</span><a href="../ingresarMercaderia/nuevaMercaderia.htm" title="Nueva mercadería" style="margin-left: 5px"
			class="btn btn-info btn-small pull-right"><i class="icon-plus"></i>Nuevo</a>
			<a href="#" title="Buscar" onclick="buscarConsulta()"
			class="btn btn-success btn-small pull-right"><i class="icon-search"></i>Buscar</a>
	</h1>
</div>
<div class="page-header position-relative">
	<form id="formVerMercaderias"  action="../ingresarMercaderia/eliminarMercaderia.htm" method="POST" class="form-horizontal">
		<input type="hidden" name="idMercaderia" id="idMercaderia">	
		<div class="row-fluid">
			<div class="page-content">
				<div class="span12">

					<div class="row-fluid">
						<div class="span4">
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
							<div class="control-group">
								<label class="control-label" for="guiaRemision">Guía Remisión</label>
								<div class="controls">
									<input type="text" class="form-control" name="guiaRemision" id="guiaRemision" value="${mercaderiaConsulta.guiaRemision}" placeholder="Guía Remisión...">
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
											<option value="${item.idUnidadMineraAlmacen}" ${item.idUnidadMineraAlmacen == mercaderiaConsulta.idUnidadMineraAlmacen ? 'selected' : ' '}>${item.almacen.almacen}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="fechaInicio">Fecha Inicio</label>
								<div class="controls">
									<input type="text" class="form-control date-picker" name="fechaInicio" id="fechaInicio" readonly="readonly" value="${fechaInicio}">
								</div>
							</div>

						</div>
						<div class="span4">
						<div class="control-group">
								<label class="control-label" for="proveedor">Ruc Proveedor</label>
								<div class="controls">									
									<input type="text" class="form-control numeroEntero" name="rucProveedor" id="rucProveedor" maxlength="11" value="${mercaderiaConsulta.rucProveedor}" placeholder="Proveedor...">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="fechaFin">Fecha Fin</label>
								<div class="controls">
									<input type="text" class="form-control date-picker" name="fechaFin" id="fechaFin" readonly="readonly" value="${fechaFin}">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</form>
	<hr>
	<table id="tablaMercaderia" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
						<th class="center" width="5%">Nro</th>
						<th class="center">Código</th>
						<th class="center">Transporte</th>
						<th class="center">Proveedor</th>
						<th class="center">Guía Remisión</th>
						<th class="center">Comprobante de Venta</th>
						<th class="center" width="10%">Opciones</th>
				</tr>
			</thead>
			<tbody>
						<c:forEach var="jbean" items="${listaMercaderiaConsulta}"
							varStatus="contador">
							<tr>
								<td class="center">${contador.count}</td>
								<td class="center"><a
									href="modificarMercaderia.htm?idMercaderia=<c:out value="${jbean.idMercaderia}" />"
									title="Modificar Mercadería">${jbean.idMercaderia}</a></td>
								<td class="center">${jbean.transporte}</td>
								<td class="center">${jbean.rucProveedor} - ${jbean.descripcionProveedor}</td>
								<td class="center">${jbean.guiaRemision}</td>
								<td class="center">${jbean.comprobanteVenta}</td>
								<td class="center"><a class="red" href="#" onclick="eliminarMercaderia('${jbean.idMercaderia}')"> <i
										class="icon-trash bigger-130"></i>
								</a></td>

							</tr>
						</c:forEach>
					</tbody>
	</table>
</div>