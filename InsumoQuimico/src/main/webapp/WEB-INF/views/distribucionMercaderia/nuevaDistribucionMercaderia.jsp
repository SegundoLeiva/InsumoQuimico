<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page import="com.hochschild.insumoQuimico.util.Constantes" %>
<div class="page-header position-relative">
	<form id="formDistribucionMercaderia" method="POST" class="form-horizontal">
	<input type="hidden" name="idDistribucionMercaderia" id="idDistribucionMercaderia" value="${distribucionMercaderia.idDistribucionMercaderia}" data-id="${distribucionMercaderia.idDistribucionMercaderia}">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span10">
					<input type="hidden" value="${accion}" id="accion">
					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="idUnidadMinera">Unidad Minera</label>
								<div class="controls selectInsumo">
									<select name="idUnidadMinera" id="idUnidadMinera">
										<c:forEach var="item" items="${listaUnidadesMineras}">
											<option value="${item.valorOrganizacional}" ${item.valorOrganizacional == distribucionMercaderia.unidadMineraArea.idUnidadMinera ? 'selected' : ' '}>${item.descripcion}</option>
										</c:forEach>
									</select>
								</div>
							</div>	
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="idUnidadMineraArea">Área</label>
								<div class="controls selectInsumo">									
									<select name="idUnidadMineraArea" id="idUnidadMineraArea" required data-msg-required="El campo Área es obligatorio.">						

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
									<select name="idUnidadMineraInsumoPresentacion" id="idUnidadMineraInsumoPresentacion" required data-msg-required="El campo Insumo Presentación es obligatorio.">						
										
									</select>
								</div>
							</div>
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="cantidad">Cantidad de Distribución</label>
								<div class="controls">
									<input type="text" id="cantidad" name="cantidad" class="numeroEntero inputInsumo" required data-msg-required="El campo Cantidad es obligatorio." value="${distribucionMercaderia.cantidad}">
								</div>
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="control-group" id="bloqueStock">
								<label class="control-label" for="stock">Cantidad Presentación</label>
								<div class="controls">
									<input type="text" id="stock" readonly="readonly" class="stock inputInsumo">
								</div>
							</div>	
						</div>
					</div>
				</div>
			</div>

		</div>

	</form>
</div>