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
								<label class="control-label" for="descripcion">Descripción</label>
								<div class="controls">
									<input type="text" id="descripcion" class="inputInsumo" required data-msg-required="El campo Descripción es obligatorio.">
								</div>
							</div>
						
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="idPresentacion">Valor</label>
									<div class="controls">
										<input type="text" id="valor" class="numeroDecimal inputInsumo" required data-msg-required="El campo Valor es obligatorio.">
									</div>
							</div>
						
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="pesoBruto">Peso Bruto (Kg)</label>
								<div class="controls">
									<input type="text" id="pesoBruto" class="numeroDecimal inputInsumo" required data-msg-required="El campo Peso Bruto es obligatorio.">
								</div>
							</div>
						
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="pesoNeto">Peso Neto (Kg)</label>
									<div class="controls">
										<input type="text" id="pesoNeto" class="numeroDecimal inputInsumo" required data-msg-required="El campo Peso Neto es obligatorio.">
									</div>
							</div>
						
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="idunidadMedida">Unidad Medida</label>
								<div class="controls selectInsumo">
									<select id="unidadMedida" required
										data-msg-required="El campo Unidad Medida es obligatorio."></select>
								</div>
							</div>					
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="vigenciaInsumo">Estado</label>
								<div class="controls selectInsumo">									
									<select id="vigenciaInsumo" required
										data-msg-required="El campo Estado es obligatorio.">
										<option value="">Seleccionar</option>
										<option value="S" ${insumo.vigencia == 'S' ? 'selected' : ' '}>VIGENTE</option>
										<option value="N" ${insumo.vigencia == 'N' ? 'selected' : ' '}>NO VIGENTE</option>
									</select>
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