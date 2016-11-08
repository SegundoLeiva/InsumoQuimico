<form id="formUnidadMineraArea" method="POST" action="<c:url value='agregarArea.htm'/>" >
<input type="hidden" name="idUnidadMineraArea" id="idUnidadMineraArea" >
<div id="nuevaArea" class="modal hide fade" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="tituloText">Agregar Área</h3>
	</div>
	<div class="modal-body">		
				<div class="row-fluid">
						<div class="span6">

							<div class="control-group codigoDisabled">
								<label class="control-label" for="idUnidadMinera">Código</label>
								<div class="controls">
									<input type="text" name="idUnidadMinera" id="idUnidadMinera" value="1303" readonly>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="idArea">Área</label>
								<div class="controls">
									<select name="idArea" id="idArea" required
										data-msg-required="El campo Área es obligatorio.">
										<option value="">Seleccionar</option>
										<c:forEach var="item" items="${listaAreas}">
											<option value="${item.idArea}">${item.area}</option>
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
										<option value="S">VIGENTE</option>
										<option value="N">NO VIGENTE</option>
									</select>
								</div>
							</div>
							

						</div>
					</div>
	</div>
	<div class="modal-footer">
		<a title="Agregar Área" id="agregarArea"
				class="btn btn-small btn-success">Agregar
			</a>
		<button class="btn btn-small btn-primary" data-dismiss="modal" aria-hidden="true">Cancelar</button>
	</div>
</div>
</form>