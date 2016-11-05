<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Modificar Categoría <small> <i class="icon-double-angle-right"></i>

		</small> <a href="../sistema/listacategoria.htm" title="Lista de Categorías"
			class="btn btn-success btn-small pull-right"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
	</h1>
</div>
<div class="page-header position-relative">
	<form id="form_categoria_modificar" class="form-horizontal">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span10">

					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="">Nombre Categoría</label>
								<div class="controls">
									<input type="text" name="descripcion" id="descripcion"
										placeholder="Nombre" value="${model.datoscategoria[2]}">
									<input type="hidden" name="idcategoria" id="idcategoria"
										value="${model.datoscategoria[0]}">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Estado</label>
								<div class="controls">
									<select name="estado" class="">

										<c:choose>
											<c:when test="${model.datosidcategoria[3]==1}">
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
					</div>


				</div>
			</div>

		</div>

		<div style="display: none" id="mensajealerta"
			class="alert alert-success">
			<strong> <i class="ace-icon fa fa-check"></i> Bien!
			</strong> Su categoría se modicó exitosamente. <br>
		</div>
		<div style="display: none" id="mensajealertaerror"
			class="alert alert-error">
			<strong> <i class="ace-icon fa fa-check"></i> No se pudo
				modificar
			</strong> llene los campos requeridos. <br>
		</div>

		<div class="form-actions">

			<button title="Modificar Marca" type="submit" class="btn btn-success">
				<i class="icon-save bigger-110"></i>Modificar
			</button>
			<a href="../sistema/listacategoria.htm" title="Regresar Panel"
				type="submit" class="btn btn-info"> <i
				class="icon-undo bigger-110"></i>Regresar
			</a>

		</div>
	</form>
</div>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("input").blur(function() {
			document.getElementById("mensaje").innerHTML = "";
		});
	});
</script>
<script type="text/javascript">
	$('#form_categoria_modificar')
			.submit(
					function(event) {
						var asd = $(this).serialize();
						$
								.post(
										'${pageContext.request.contextPath}/sistema/modificarcategoriaaction.htm',
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
												$('#descripcion').val("");
											}

										});

						event.preventDefault();
					});
</script>