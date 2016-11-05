<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Registrar Categoría <small> <i class="icon-double-angle-right"></i>
			</small> <a href="../sistema/listacategoria.htm" title="Lista de Categoría"
			class="btn btn-success btn-small pull-right"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
	</h1>
</div>
<div class="page-header position-relative">
	<form id="form_categoria" class="form-horizontal">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span10">

					<div class="row-fluid">
						<div class="span6">

							<div class="control-group">
								<label class="control-label" for="">Nombre Categoría</label>
								<div class="controls">
									<input type="text" name="descripcion" id="descripcion"
										placeholder="Nombre">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Estado</label>
								<div class="controls">
									<select name="estado" class="">
										<option value="1">HABILITADO</option>
										<option value="2">DESHABILITADO</option>

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
			</strong> Su categoría se registró exitosamente. <br>
		</div>
		<div style="display: none" id="mensajealertaerror"
			class="alert alert-error">
			<strong> <i class="ace-icon fa fa-check"></i>
			No se pudo registrar </strong> llene los campos requeridos. <br>
		</div>

		<div class="form-actions">

			<button title="Agregar Categoría" type="submit" class="btn btn-success">
				<i class="icon-save bigger-110"></i>Agregar
			</button>
			<a href="../sistema/listacategoria.htm" title="Regresar Panel"
				type="submit" class="btn btn-info"> <i
				class="icon-undo bigger-110"></i>Regresar
			</a>

		</div>
	</form>
</div>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
	
</script>

<script type="text/javascript">
	$('#form_categoria')
			.submit(
					function(event) {
						var asd = $(this).serialize();
						$
								.post(
										'${pageContext.request.contextPath}/sistema/registrarcategoria.htm',
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





