<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page import="com.hochschild.insumoQuimico.util.Constantes" %>
<div class="page-header position-relative">
	<form id="formDistribucionMercaderia" method="POST" class="form-horizontal">
	<input type="hidden" name="idDistribucionMercaderia" id="idDistribucionMercaderia" value="${distribucionMercaderia.idDistribucionMercaderia}" data-id="${distribucionMercaderia.idDistribucionMercaderia}">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span12">
					<input type="hidden" value="${accion}" id="accion">
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
								<label class="control-label" for="idPresentacionInsumo">Presentacion</label>
								<div class="controls">
									<select id="idPresentacionInsumo" name="idPresentacionInsumo" required data-msg-required="El campo Presentación es obligatorio.">
									</select>
								</div>
							</div>
						
							
								
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idUnidadMineraArea">Área</label>
								<div class="controls">									
									<select name="idUnidadMineraArea" id="idUnidadMineraArea" required data-msg-required="El campo Área es obligatorio.">						
										<option value="">Seleccionar</option>
										<c:forEach var="item" items="${listaUnidadMineraArea}">
											<option value="${item.idUnidadMineraArea}" ${item.idUnidadMineraArea == distribucionMercaderia.unidadMineraArea.idUnidadMineraArea ? 'selected' : ' '}>${item.area.area}</option>
										</c:forEach>
									</select>
								</div>
							</div>	
							<div class="control-group">
								<label class="control-label" for="cantidad">Cantidad</label>
								<div class="controls">
									<input type="text" id="cantidad" name="cantidad" class="numeroEntero" required data-msg-required="El campo Cantidad es obligatorio." value="${distribucionMercaderia.cantidad}">
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idUnidadMineraInsumo">Insumo</label>
								<div class="controls">									
									<select name="idUnidadMineraInsumo" id="idUnidadMineraInsumo" required data-msg-required="El campo Insumo es obligatorio.">						
										<option value="">Seleccionar</option>
										<c:forEach var="item" items="${listaUnidadMineraInsumo}">
											<option value="${item.idUnidadMineraInsumo}" ${item.idUnidadMineraInsumo == distribucionMercaderia.unidadMineraInsumo.idUnidadMineraInsumo ? 'selected' : ' '}>${item.insumo.insumo}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group" id="bloqueStock">
								<label class="control-label" for="stock">Stock</label>
								<div class="controls">
									<input type="text" id="stock" readonly="readonly" class="stock">
								</div>
							</div>	
						</div>
					</div>
				</div>
			</div>

		</div>

	</form>
</div>