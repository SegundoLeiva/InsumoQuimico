<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Modificar Producto <small> <i class="icon-double-angle-right"></i>
			Descripcion
		</small> <a href="../sistema/listarproductos.htm" title="Lista de Alumnos"
			class="btn btn-success btn-small pull-right"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
	</h1>
</div>

<div class="page-header position-relative">
	<form id="form_producto_modificar" class="form-horizontal">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span10">

					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="">Nombre Producto</label>
								<div class="controls">
									<input type="text" name="nombre" id="nombre"
										value="${model.datosproducto[1]}" placeholder="Nombre">
									<input type="hidden" name="idproducto" id="idproducto"
										value="${model.datosproducto[0]}">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Estado</label>
								<div class="controls">
									<select name="estado" class="">

										<c:choose>
											<c:when test="${model.datosproducto[7]==1}">
												<option selected="selected" value="1">HABILITADO</option>
												<option value="2">DESHABILITADO</option>
											</c:when>

											<c:otherwise>
												<option selected="selected" value="2">DESHABILITADO</option>
												<option value="1">HABILITADO</option>

											</c:otherwise>
										</c:choose>

									</select>
								</div>
							</div>

						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="">Categoría</label>
								<div class="controls">
									<select name="categoria" class="">
										<option value="${model.datosproducto[2]}">${model.datosproducto[4]}</option>
										<c:forEach var="a" items="${model.getlistacategorias}">
											<c:if test="${a.id!=model.datosproducto[2]}">
												<option value="${a.id}">
													<c:out value="${a.descripcion}"></c:out>
												</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Marca</label>
								<div class="controls">
									<select name="marca" class="">
										<option value="${model.datosproducto[3]}">${model.datosproducto[5]}</option>
										<c:forEach var="a" items="${model.getlistamarcas}">
											<c:if test="${a.id!=model.datosproducto[3]}">
												<option value="${a.id}">
													<c:out value="${a.descripcion}"></c:out>
												</option>
											</c:if>

										</c:forEach>
									</select>
								</div>
							</div>


						</div>
					</div>


				</div>
			</div>

		</div>
		<div style="display: none" id="mensajealerta"
			class="alert alert-success">
			<strong> <i class="ace-icon fa fa-check"></i> Bien!
			</strong> Su producto se modicó exitosamente. <br>
		</div>
		<div style="display: none" id="mensajealertaerror"
			class="alert alert-error">
			<strong> <i class="ace-icon fa fa-check"></i>
			No se pudo modificar</strong> llene los campos requeridos. <br>
		</div>
		<div class="form-actions">

			<button class="btn btn-success" type="submit">
				<i class="icon-save bigger-110"></i> Modificar
			</button>
			<a href="../sistema/listarproductos.htm" title="Regresar Panel"
				type="submit" class="btn btn-info"> <i
				class="icon-undo bigger-110"></i> Regresar
			</a>
		</div>
	</form>
</div>


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<script type="text/javascript">
	$('#form_producto_modificar')
			.submit(
					function(event) {
						var asd = $(this).serialize();
						$
								.post(
										'${pageContext.request.contextPath}/sistema/modificarproductoaction.htm',
										asd,
										function(response) {
											if (response == "error") {
												document
														.getElementById("mensajealertaerror").style.display = "";
												document
														.getElementById("mensajealerta").style.display = "none";
											} else {

												document
														.getElementById("mensajealerta").style.display = "";
												document
														.getElementById("mensajealertaerror").style.display = "none";
												$('#nombre').val("");
											}

										});

						event.preventDefault();
					});
</script>


