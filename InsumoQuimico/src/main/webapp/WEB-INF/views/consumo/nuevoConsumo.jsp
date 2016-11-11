<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<c:set var="now" value="<%=Calendar.getInstance().getTime()%>" />
<div class="page-header">
	<h1>
		Registrar Ingreso de Mercadería <span> <i class="icon-double-angle-right"></i>
		</span><a href="../area/verAreas.htm" title="Guardar Mercadería"
			class="btn btn-success btn-small pull-right"><i class="icon-save"></i>Guardar</a>
	</h1>
</div>
<div class="page-header position-relative">
	<form id="formUnidadMineraArea" method="POST" class="form-horizontal">
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
								<label class="control-label" for="fecha">Código Consumo</label>
								<div class="controls codigoDisabled">
									<input type="text" class="form-control" name="codigoInsumo" id="codigoInsumo" 
									readonly="readonly" >
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idAlmacen">Área</label>
								<div class="controls">									
									<select name="idAlmacen" id="idAlmacen" required
										data-msg-required="El campo Estado es obligatorio.">
										<option value="">Seleccionar</option>
										<option value="S">VIGENTE</option>
										<option value="N">NO VIGENTE</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="idProveedor">Almacén</label>
								<div class="controls">									
									<select name="idProveedor" id="idProveedor" required
										data-msg-required="El campo Estado es obligatorio.">
										<option value="">Seleccionar</option>
										<option value="S">VIGENTE</option>
										<option value="N">NO VIGENTE</option>
									</select>
								</div>
							</div>

						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha</label>
								<div class="controls">
									<input type="text" class="form-control" name="fecha" id="fecha" 
									readonly="readonly" value="<fmt:formatDate value="${now}" pattern="dd/MM/yyyy" />">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</form>
<!-- 	<div class="actions form-actions"> -->

<!-- 			<a title="Agregar Detalle" id="agregarDetalle" -->
<!-- 				class="btn btn-small btn-success"> -->
<!-- 				<i class="icon-save bigger-110"></i>Agregar -->
<!-- 			</a> -->
<!-- 		</div> -->
	<div class="header table-header">
			<a href="#" title="Agregar Detalle" class="btn btn-small btn-primary" id="abrirDetalleMercaderia"
				style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Agregar</a>
			<a href="#" title="Eliminar Detalle" class="btn btn-small btn-primary" id="eliminarMercaderiaDetalle"
				style="border: 1px solid #c4e7ff;"><i class="icon-trash"></i>Eliminar</a>

	</div>
	<table id="tablaMercaderiaDetalle"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">
								<label><input type="checkbox" class="checkSelectedAll">
								<span class="lbl"></span></label>
							</th>
							<th class="center" width="40%">Material</th>
							<th class="center">Cantidad</th>
							<th class="center">Unidad Medida</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
</div>


<%@ include file="/WEB-INF/views/mercaderia/nuevaMercaderiaDetalle.jsp"%>