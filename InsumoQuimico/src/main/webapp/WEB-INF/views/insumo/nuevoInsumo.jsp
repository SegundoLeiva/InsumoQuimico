<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header position-relative">
	<form id="formInsumo" method="POST" class="form-horizontal">
	<input type="hidden" name="idInsumo" id="idInsumo" value="${insumo.idInsumo}">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span8">

					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="area">Insumo</label>
								<div class="controls">
									<input type="text" class="form-control" name="insumo" id="insumo" value="${insumo.insumo}" required
										data-msg-required="El campo Insumo es obligatorio.">
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
										<option value="S" ${insumo.vigencia == 'S' ? 'selected' : ' '}>VIGENTE</option>
										<option value="N" ${insumo.vigencia == 'N' ? 'selected' : ' '}>NO VIGENTE</option>
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