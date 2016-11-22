<%@ include file="/WEB-INF/views/include.jsp"%>




<div class="page-header">
	<h1>
		Ingresar Mercadería <span> <i class="icon-double-angle-right"></i>
		</span><a href="#" title="Buscar"
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
									<input type="text" class="form-control" name="guiaRemision" id="guiaRemision">
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idAlmacen">Almacén</label>
								<div class="controls">									
									<select name="idUnidadMineraAlmacen" id="idUnidadMineraAlmacen">
										<c:forEach var="item" items="${listaUnidadMineraAlmacen}">
											<option value="${item.idUnidadMineraAlmacen}">${item.almacen.almacen}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Inicio</label>
								<div class="controls">
									<input type="text" class="form-control date-picker" name="fechaInicio" id="fechaInicio" readonly="readonly">
								</div>
							</div>

						</div>
						<div class="span4">
						<div class="control-group">
								<label class="control-label" for="idProveedor">Proveedor</label>
								<div class="controls">									
									<select name="idProveedor" id="idProveedor" required
										data-msg-required="El campo Estado es obligatorio.">
										<option value="">Seleccionar</option>
										<option value="S">VIGENTE</option>
										<option value="N">NO VIGENTE</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Fin</label>
								<div class="controls">
									<input type="text" class="form-control date-picker" name="fechaFin" id="fechaFin" readonly="readonly">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</form>
	<div class="header table-header">
			<a href="../ingresarMercaderia/nuevaMercaderia.htm"
				title="Nuevo Ingreso" class="btn btn-small btn-primary"
				style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Nuevo</a>

	</div>
	<table id="tablaMercaderia" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
						<th class="center" width="5%">Nro</th>
						<th class="center">Código</th>
						<th class="center">Transporte</th>
						<th class="center">Guía Remisión</th>
						<th class="center">Comprobante de Venta</th>
						<th class="center" width="10%">Opciones</th>
				</tr>
			</thead>
			<tbody>
						<c:forEach var="jbean" items="${listaMercaderias}"
							varStatus="contador">
							<tr>
								<td class="center">${contador.count}</td>
								<td class="center"><a
									href="modificarMercaderia.htm?idMercaderia=<c:out value="${jbean.idMercaderia}" />"
									title="Modificar Mercadería">${jbean.idMercaderia}</a></td>
								<td class="center">${jbean.transporte}</td>
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