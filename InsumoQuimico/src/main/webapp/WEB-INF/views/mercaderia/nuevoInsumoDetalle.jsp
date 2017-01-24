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
								<label class="control-label" for="idUnidadMineraInsumoPresentacion">Insumo Presentación</label>
								<div class="controls selectInsumo">
									<select id="idUnidadMineraInsumoPresentacion" required
										data-msg-required="El campo Insumo Presentación es obligatorio."></select>
								</div>
							</div>
						
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="pesoNeto">Peso Neto (Kg)</label>
								<div class="controls">
									<input type="text" id="pesoNeto" readonly="readonly" class="inputInsumo factor">
									<input type="hidden" id="unidadMedidaPresentacion">
								</div>
							</div>					
						</div>		
						
						
					</div>
					<div class="row-fluid">
						
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="cantidad">Cantidad de Presentación</label>
								<div class="controls">
									<input type="text" id="cantidad" class="numeroDecimal inputInsumo" required data-msg-required="El campo Cantidad es obligatorio.">
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