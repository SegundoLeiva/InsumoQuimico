<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<c:set var="now" value="<%=Calendar.getInstance().getTime()%>" />
<div class="page-header">
	<h1>
		Registrar Ingreso de Mercader�a <span> <i class="icon-double-angle-right"></i>
		</span><a href="../ingresarMercaderia/verMercaderias.htm" title="Ver Mercader�as" style="margin-left: 5px"
			class="btn btn-success btn-small pull-right"><i class="icon-tasks"></i>Listar</a>
			<a href="#" id="guardarMercaderia" title="Guardar Mercader�a"
			class="btn btn-success btn-small pull-right"><i class="icon-save"></i>Guardar</a>
	</h1>
</div>
<div class="page-header position-relative">
	<form id="formMercaderia" method="POST" class="form-horizontal">
	<input type="hidden" value="${flagEditar}" id="flagEditar">
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
								<label class="control-label" for="fecha">C�digo Mercader�a</label>
								<div class="controls codigoDisabled">
									<input type="text" class="form-control" name="idMercaderia" id="idMercaderia" 
									readonly="readonly" value="${mercaderia.idMercaderia}">
								</div>
							</div>					
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idAlmacen">Almac�n</label>
								<div class="controls">									
									<select name="idUnidadMineraAlmacen" id="idUnidadMineraAlmacen">
										<c:forEach var="item" items="${listaUnidadMineraAlmacen}">
											<option value="${item.idUnidadMineraAlmacen}" ${item.idUnidadMineraAlmacen == mercaderia.unidadMineraAlmacen.idUnidadMineraAlmacen ? 'selected' : ' '}>${item.almacen.almacen}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="transporte">Transporte</label>
								<div class="controls">
									<input type="text" class="form-control" name="transporte" id="transporte" value="${mercaderia.transporte}">
								</div>
							</div>	
							<div class="control-group">
								<label class="control-label" for="guiaRemision">Gu�a Remisi�n</label>
								<div class="controls">
									<input type="text" class="form-control" name="guiaRemision" id="guiaRemision" value="${mercaderia.guiaRemision}">
								</div>
							</div>					
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="comprobanteVenta">Comprobante Venta</label>
								<div class="controls">
									<input type="text" class="form-control" name="comprobanteVenta" id="comprobanteVenta" value="${mercaderia.comprobanteVenta}">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="guiaInterna">Gu�a Interna</label>
								<div class="controls">
									<input type="text" class="form-control" name="guiaInterna" id="guiaInterna" value="${mercaderia.guiaInterna}">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha</label>
								<div class="controls">
									<input type="text" class="form-control" name="fechaMercaderia" id="fechaMercaderia" 
									readonly="readonly" value="<fmt:formatDate value="${now}" pattern="dd/MM/yyyy" />">
								</div>
							</div>							
						</div>
					</div>
				</div>
			</div>

		</div>

	</form>
	<div class="header table-header">
			<a href="#" title="Agregar Detalle" class="btn btn-small btn-primary" id="abrirDetalleMercaderia"
				style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Agregar</a>
			<a href="#" title="Eliminar Detalle" class="btn btn-small btn-primary" id="eliminarMercaderiaDetalle"
				style="border: 1px solid #c4e7ff;"><i class="icon-trash"></i>Eliminar</a>
			<a href="#" title="Editar Detalle" class="btn btn-small btn-primary" id="abrirDetalleEditar"
				style="border: 1px solid #c4e7ff;"><i class="icon-edit"></i>Editar</a>

	</div>
	<table id="tablaMercaderiaDetalle"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">
								<label><input type="checkbox" class="checkSelectedAll">
								<span class="lbl"></span></label>
							</th>
							<th class="center" width="10%">C�digo</th>
							<th class="center" width="50%">Descripcion</th>
							<th class="center">Cantidad</th>
							<th class="center">Unidad Medida</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
</div>


<%@ include file="/WEB-INF/views/mercaderia/nuevaMercaderiaDetalle.jsp"%>