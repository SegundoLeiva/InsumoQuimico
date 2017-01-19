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
									<input type="text" class="form-control inputInsumo" name="insumo" id="insumo" value="${insumo.insumo}" required
										data-msg-required="El campo Insumo es obligatorio.">
								</div>
							</div>
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="">Estado</label>
								<div class="controls selectInsumo">									
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
	<h5 class="green">Agregar Presentación</h5>
	<hr>
	<div class="header table-header">
			<a href="#" title="Agregar Detalle" class="btn btn-small btn-primary" id="abrirDetalleAgregar"
				style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Agregar</a>
			<a href="#" title="Eliminar Detalle" class="btn btn-small btn-primary" id="eliminarDetalle"
				style="border: 1px solid #c4e7ff;"><i class="icon-trash"></i>Eliminar</a>
			<a href="#" title="Editar Detalle" class="btn btn-small btn-primary" id="abrirDetalleEditar"
				style="border: 1px solid #c4e7ff;"><i class="icon-edit"></i>Editar</a>
	</div>
	<table id="tablaDetalle"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">
								<label><input type="checkbox" class="checkSelectedAll">
								<span class="lbl"></span></label>
							</th>
							<th class="center" width="30%">Descripcion</th>
							<th class="center">Valor</th>
							<th class="center">Unidad Medida</th>
							<th class="center">Peso Bruto (Kg)</th>
							<th class="center">Peso Neto (Kg)</th>
							<th class="center" width="10%">Estado</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
	</table>
</div>
<%@ include file="/WEB-INF/views/insumo/nuevaPresentacionInsumo.jsp"%>