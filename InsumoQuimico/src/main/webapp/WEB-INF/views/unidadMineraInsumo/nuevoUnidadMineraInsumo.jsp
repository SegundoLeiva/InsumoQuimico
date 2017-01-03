<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header position-relative">
	<form id="formUnidadMineraInsumo" method="POST" class="form-horizontal">
	<input type="hidden" name="idUnidadMineraInsumo" id="idUnidadMineraInsumo" value="${unidadMineraInsumo.idUnidadMineraInsumo}" data-id="${unidadMineraInsumo.idUnidadMineraInsumo}">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span8">

					<div class="row-fluid">
						<div class="span6">
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
								<label class="control-label" for="idInsumo">Insumo</label>
								<div class="controls">
									<select name="idInsumo" id="idInsumo" required
										data-msg-required="El campo Insumo es obligatorio.">
										<option value="">Seleccionar</option>									
										<c:forEach var="item" items="${listaInsumos}">
											<c:if test="${item.vigencia=='S'}">
												<option value="${item.idInsumo}" ${item.idInsumo == unidadMineraInsumo.insumo.idInsumo ? 'selected' : ' '}>${item.insumo}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="">Estado</label>
								<div class="controls">									
									<select name="vigencia" id="vigencia" required
										data-msg-required="El campo Estado es obligatorio.">
										<option value="">Seleccionar</option>
										<option value="S" ${unidadMineraInsumo.vigencia == 'S' ? 'selected' : ' '}>VIGENTE</option>
										<option value="N" ${unidadMineraInsumo.vigencia == 'N' ? 'selected' : ' '}>NO VIGENTE</option>
									</select>
								</div>
							</div>
							

						</div>
					</div>
				</div>
			</div>

		</div>
	</form>
</div>