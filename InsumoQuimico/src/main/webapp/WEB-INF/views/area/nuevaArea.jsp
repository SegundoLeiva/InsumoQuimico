<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Registrar 햞ea <span><i class="icon-double-angle-right"></i>
		</span>
	</h1>
</div>
<div class="page-header position-relative">
	<form id="formUnidadMineraArea" method="POST" class="form-horizontal">
	<input type="hidden" name="idUnidadMineraArea" id="idUnidadMineraArea" value="${unidadMineraArea.idUnidadMineraArea}">
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
								<label class="control-label" for="idArea">햞ea</label>
								<div class="controls">
									<select name="idArea" id="idArea" required
										data-msg-required="El campo 햞ea es obligatorio.">
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

			<a title="Agregar 햞ea" id="agregarArea"
				class="btn btn-small btn-success">
				<i class="icon-save bigger-110"></i>${!empty unidadMineraArea.idUnidadMineraArea ? 'Modificar' : 'Agregar'}
			</a>
			<a href="../area/verAreas.htm" title="Regresar"
				class="btn btn-small btn-info"> <i
				class="icon-undo bigger-110"></i>Regresar
			</a>

		</div>
	</form>
</div>