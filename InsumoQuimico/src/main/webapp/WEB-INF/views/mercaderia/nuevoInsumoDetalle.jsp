<form id="formModalDetalleForm">
<div id="divModalDetalleForm" class="modal hide fade"
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
								<label class="control-label" for="idUnidadMineraInsumo">Insumo</label>
								<div class="controls selectInsumo">
									<select id="idUnidadMineraInsumo"></select>
								</div>
							</div>
						
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="idPresentacion">Presentacion</label>
								<div class="controls selectInsumo">
									<select id="idPresentacion">
										<option value="1">Bolsa de 20 Kg</option>
									</select>
								</div>
							</div>
						
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="idConversion">Conversión</label>
								<div class="controls selectInsumo">
									<select id="idConversion">
										<option value="1">conversion 1</option>
									</select>
								</div>
							</div>					
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="cantidad">Cantidad</label>
								<div class="controls selectInsumo">
									<input type="text" id="cantidad" class="numeroDecimal" required data-msg-required="El campo Cantidad es obligatorio.">
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
</form>