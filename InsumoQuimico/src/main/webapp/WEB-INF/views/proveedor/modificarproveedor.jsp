<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Modificar Proveedor <small> <i class="icon-double-angle-right"></i>
			Descripcion
		</small> <a href="../sistema/listarproveedor.htm" title="Lista de Proveedores"
			class="btn btn-success btn-small pull-right"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
	</h1>
</div>
<div class="page-header position-relative">
	<form:form method="POST" class="form-horizontal"
		modelAttribute="modificarproveedor"
		action="modificarproveedoraction.htm">

		<div class="row-fluid">
			<div class="page-content">
				<div class="span10">

					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="">R.U.C</label>
								<div class="controls">
									<form:input type="text" path="rucProv" id="rucProv"
										placeholder="Ruc" value="${model.datosproveedor[2]}"
										pattern=".{11,11}" title="solo puedes escribir 11 d�gitos"
										class="numeros" />
									<span> <form:errors path="rucProv"
											cssClass="help-inline" /></span>

									<form:input type="hidden" path="id" id="id"
										value="${model.datosproveedor[0]}" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Descripci�n</label>
								<div class="controls">
									<form:input type="text" path="desProv" id="desProv"
										placeholder="Descripci�n" value="${model.datosproveedor[1]}" />
									<span> <form:errors path="desProv"
											cssClass="help-inline" /></span>

								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Direcci�n</label>
								<div class="controls">

									<form:input type="text" path="dirProv" id="dirProv"
										placeholder="Direcci�n" value="${model.datosproveedor[3]}" />
									<span> <form:errors path="dirProv"
											cssClass="help-inline" /></span>

								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Estado</label>
								<div class="controls">
									<form:select path="estado" class="">

										<c:choose>
											<c:when test="${model.datosproveedor[4]==1}">
												<form:option selected="selected" value="1">HABILITADO</form:option>
												<form:option value="2">DESHABILITADO</form:option>
											</c:when>

											<c:otherwise>
												<form:option selected="selected" value="2">DESHABILITADO</form:option>
												<form:option value="1">HABILITADO</form:option>

											</c:otherwise>
										</c:choose>

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

			<button title="Modificar Proveedor" type="submit"
				class="btn btn-success">
				<i class="icon-save bigger-110"></i> Modificar
			</button>
			<a href="../sistema/listarproveedor.htm" title="Regresar Panel"
				type="submit" class="btn btn-info"> <i
				class="icon-undo bigger-110"></i> Regresar
			</a>

		</div>
	</form:form>
</div>




