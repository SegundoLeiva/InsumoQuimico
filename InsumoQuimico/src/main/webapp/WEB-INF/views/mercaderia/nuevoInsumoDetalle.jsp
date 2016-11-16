<div id="modalDetalleForm" class="modal hide fade" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="tituloText">Ingresar</h3>
	</div>
	<div class="modal-body">		
				<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="idArea">Insumo</label>
								<div class="controls">
									<select name="idInsumo" id="idInsumo" required style="width: inherit;"
										data-msg-required="El campo Área es obligatorio.">
										<c:forEach var="item" items="${listaUnidadMineraInsumo}">
											<option value="${item.idUnidadMineraInsumo}">${item.insumo.insumo}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="cantidad">Cantidad</label>
								<div class="controls">
									<input type="number" id="cantidad" required data-msg-required="El campo Cantidad es obligatorio.">
								</div>
							</div>
							

						</div>
					</div>
	</div>
	<div class="modal-footer">
		<a title="Agregar" id="btnAgregarDetalle"
				class="btn btn-small btn-success">Agregar
		</a>
		<a title="Editar" id="btnEditarDetalle"
				class="btn btn-small btn-success">Editar
		</a>
		<button class="btn btn-small btn-primary" data-dismiss="modal" aria-hidden="true">Cancelar</button>
	</div>
</div>