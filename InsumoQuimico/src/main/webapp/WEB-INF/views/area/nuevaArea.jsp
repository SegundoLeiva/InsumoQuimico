<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Registrar Área <small> <i class="icon-double-angle-right"></i>
			Descripcion
		</small> <a href="../area/verAreas.htm" title="Lista de Áreas"
			class="btn btn-success btn-small pull-right"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
	</h1>
</div>
<div class="page-header position-relative">
	<form id="formUnidadMineraArea" method="POST" class="form-horizontal">
	<input type="hidden" name="idUnidadMineraArea" id="idUnidadMineraArea" value="${unidadMineraArea.idUnidadMineraArea}">
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
								<label class="control-label" for="idArea">Área</label>
								<div class="controls">
									<select name="idArea" id="idArea" required
										data-msg-required="El campo Área es obligatorio.">
										<option value="">Seleccionar</option>
										<c:forEach var="item" items="${listaAreas}">
											<option value="${item.idArea}" ${item.idArea == unidadMineraArea.area.idArea ? 'selected' : ' '}>${item.area}</option>
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
										<option value="S" ${unidadMineraArea.vigencia == 'S' ? 'selected' : ' '}>VIGENTE</option>
										<option value="N" ${unidadMineraArea.vigencia == 'N' ? 'selected' : ' '}>NO VIGENTE</option>
									</select>
								</div>
							</div>
							

						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="form-actions">

			<a title="Agregar Área" id="agregarArea"
				class="btn btn-success">
				<i class="icon-save bigger-110"></i>${!empty unidadMineraArea.idUnidadMineraArea ? 'Modificar' : 'Agregar'}
			</a>
			<a href="../area/verAreas.htm" title="Regresar"
				class="btn btn-info"> <i
				class="icon-undo bigger-110"></i>Regresar
			</a>

		</div>
	</form>
</div>