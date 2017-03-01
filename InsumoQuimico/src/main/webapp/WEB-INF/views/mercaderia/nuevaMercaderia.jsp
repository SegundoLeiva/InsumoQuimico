<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<c:set var="now" value="<%=Calendar.getInstance().getTime()%>" />

<div class="page-header position-relative">
	<form id="formMercaderia" method="POST" class="form-horizontal">
	<input type="hidden" name="idMercaderia" id="idMercaderia"  value="${mercaderia.idMercaderia}">
		<div class="row-fluid">
				<div class="span12">
					<div class="span8" >
					<span class="tituloFielset">Guía Remisión</span>
					<fieldset class="agruparFielset">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="idUnidadMinera">Unidad Minera</label>
								<div class="controls">
									<select name="idUnidadMinera" id="idUnidadMinera">
										<c:forEach var="item" items="${listaUnidadesMineras}">
											<option value="${item.valorOrganizacional}" ${item.valorOrganizacional == mercaderia.unidadMinera.idUnidadMinera ? 'selected' : ' '}>${item.descripcion}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="guiaRemision">Guía Remisión</label>
								<div class="controls">
									<input type="text" class="form-control" name="guiaRemision" id="guiaRemision" value="${mercaderia.guiaRemision}" required="required" data-msg-required="El campo Guía Remisión es obligatorio.">
								</div>
							</div>						
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label">Almacén</label>
								<div class="controls">
									<input type="text" class="form-control" value="${listaUnidadMineraAlmacen[0].almacen.almacen}" readonly="readonly">
									<input type="hidden" name="idUnidadMineraAlmacen" id="idUnidadMineraAlmacen" value="${listaUnidadMineraAlmacen[0].idUnidadMineraAlmacen}">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="fecha">Fecha de Despacho</label>
								<div class="controls">
									<c:choose>
										<c:when test="${empty accion}">
											<input type="text" class="form-control date-picker" name="fechaMercaderia" id="fechaMercaderia" 
												readonly="readonly" value="<fmt:formatDate value="${now}" pattern="dd/MM/yyyy" />">
										</c:when>
										<c:otherwise>
											<input type="text" class="form-control date-picker" name="fechaMercaderia" id="fechaMercaderia" 
											readonly="readonly" value="<fmt:formatDate value="${mercaderia.fechaMercaderia}" pattern="dd/MM/yyyy" />">
										</c:otherwise>
									</c:choose>
									
								</div>
							</div>											
						</div>
					</fieldset>
					</div>
					<div class="span4">
					<span class="tituloFielset">Datos Proveedor</span>
					<fieldset class="agruparFielset">
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="rucProveedor">Ruc Proveedor</label>
								<div class="controls">		
									<input type="text" class="form-control numeroEntero" name="rucProveedor" id="rucProveedor" value="${mercaderia.rucProveedor}" required="required" maxlength="11" data-msg-required="El campo Ruc Proveedor es obligatorio." onblur="getProveedorDescripcion();">
								</div>
							</div>	
							<div class="control-group">
								<label class="control-label" for="descripcionProveedor">Razón Social</label>
								<div class="controls">		
									<input type="text" class="form-control" name="descripcionProveedor" id="descripcionProveedor" value="${mercaderia.descripcionProveedor}" readonly="readonly">
								</div>
							</div>
			
						</div>
					</fieldset>
					</div>
				</div>

		</div>

	</form>
	<div class="header table-header">
			<a href="#" title="Agregar Detalle" class="btn btn-small btn-primary" id="abrirDetalleAgregar"
				style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Agregar</a>
			<a href="#" title="Eliminar Detalle" class="btn btn-small btn-primary" id="eliminarDetalle"
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
							<th class="center" width="10%">Código</th>
							<th class="center" width="40%">Descripcion</th>
							<th class="center">Cantidad</th>
							<th class="center">Unidad Medida</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
</div>


<%@ include file="/WEB-INF/views/mercaderia/nuevoInsumoDetalle.jsp"%>