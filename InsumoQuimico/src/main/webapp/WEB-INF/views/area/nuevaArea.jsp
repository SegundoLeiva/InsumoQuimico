<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page import="com.hochschild.insumoQuimico.util.Constantes" %>
<div class="page-header position-relative">
	<form id="formArea" method="POST" class="form-horizontal">
	<input type="hidden" name="idArea" id="idArea" value="${area.idArea}" data-id="${area.idArea}">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span8">

					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="area">Área</label>
								<div class="controls">
									<input type="text" class="form-control" name="area" id="area" value="${area.area}" required
										data-msg-required="El campo Área es obligatorio.">
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
										<option value="S" ${area.vigencia == 'S' ? 'selected' : ' '}>VIGENTE</option>
										<option value="N" ${area.vigencia == 'N' ? 'selected' : ' '}>NO VIGENTE</option>
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