<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Registrar Proveedor <small> <i class="icon-double-angle-right"></i>
			Descripcion
		</small> <a href="../sistema/listarproveedor.htm" title="Lista de Proveedores"
			class="btn btn-success btn-small pull-right"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
	</h1>
</div>
<div class="page-header position-relative">

	<form:form method="POST" class="form-horizontal"
		modelAttribute="registrarproveedor" action="registrarproveedor.htm">


		<div class="row-fluid">
			<div class="page-content">
				<div class="span10">

					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="">R.U.C</label>
								<div class="controls">

									<form:input type="text" path="rucProv" id="rucProv"
										placeholder="Ruc" pattern=".{11,11}"
										title="solo puedes escribir 11 dígitos" class="numeros" />
									<span> <form:errors path="rucProv"
											cssClass="help-inline" /></span>

								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Descripción</label>
								<div class="controls">
									<form:input type="text" path="desProv" id="desProv"
										placeholder="Descripción" />
									<span> <form:errors path="desProv"
											cssClass="help-inline" /></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Dirección</label>
								<div class="controls">

									<form:input type="text" path="dirProv" id="dirProv"
										placeholder="Dirección" />
									<span> <form:errors path="dirProv"
											cssClass="help-inline" /></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Estado</label>
								<div class="controls">
									<form:select path="estado">
										<form:option value="1">HABILITADO</form:option>
										<form:option value="2">DESHABILITADO</form:option>

									</form:select>
								</div>
							</div>


						</div>
					</div>


				</div>
			</div>

		</div>

		<c:if test="${not empty model.mensajeError}">
			<div class="alert alert-error">


				<i class="icon-remove red"></i><strong><c:out
						value="${model.mensajeError}"></c:out></strong>
			</div>
		</c:if>
		<c:if test="${not empty model.mensajeOk}">
			<div class="alert alert-success">


				<i class="icon-ok "></i><strong><c:out
						value="${model.mensajeOk}"></c:out></strong>
			</div>
		</c:if>

		<div class="form-actions">

			<button title="Agregar Proveedor" type="submit"
				class="btn btn-success">
				<i class="icon-save bigger-110"></i> Agregar
			</button>
			<a href="../sistema/listarproveedor.htm" title="Regresar Panel"
				type="submit" class="btn btn-info"> <i
				class="icon-undo bigger-110"></i> Regresar
			</a>

		</div>
	</form:form>

</div>




