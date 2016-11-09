<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Registrar Insumo <small> <i class="icon-double-angle-right"></i>
			Descripcion
		</small> <a href="../insumo/verInsumos.htm" title="Lista de Áreas"
			class="btn btn-success btn-small pull-right"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
	</h1>
</div>
<div class="page-header position-relative">
	<form id="formUnidadMineraInsumo" method="POST" class="form-horizontal">
	<input type="hidden" name="idUnidadMineraInsumo" id="idUnidadMineraInsumo" value="${unidadMineraInsumo.idUnidadMineraInsumo}">
	<input type="hidden" name="idUnidadMinera" value="${listaUnidadesMineras[0].valorOrganizacional}">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span10">

					<div class="row-fluid">
						<div class="span6">
							<div class="control-group codigoDisabled">
								<label class="control-label" for="idUnidadMinera">Código</label>
								<div class="controls">
									<input type="text" value="${listaUnidadesMineras[0].descripcion}" readonly>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="idInsumo">Insumo</label>
								<div class="controls">
									<select name="idInsumo" id="idInsumo" required
										data-msg-required="El campo Insumo es obligatorio.">
										<option value="">Seleccionar</option>
										<c:forEach var="item" items="${listaInsumos}">
											<option value="${item.idInsumo}" ${item.idInsumo == unidadMineraInsumo.insumo.idInsumo ? 'selected' : ' '}>${item.insumo}</option>
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

		<div class="form-actions">

			<a title="Agregar Insumo" id="agregarInsumo"
				class="btn btn-success">
				<i class="icon-save bigger-110"></i>${!empty unidadMineraInsumo.idUnidadMineraInsumo ? 'Modificar' : 'Agregar'}
			</a>
			<a href="../insumo/verInsumos.htm" title="Regresar"
				class="btn btn-info"> <i
				class="icon-undo bigger-110"></i>Regresar
			</a>

		</div>
	</form>
</div>