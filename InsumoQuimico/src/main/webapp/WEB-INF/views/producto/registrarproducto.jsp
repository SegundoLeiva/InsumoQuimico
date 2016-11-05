<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Registrar Producto <small> <i class="icon-double-angle-right"></i>
			Descripcion
		</small> <a href="../sistema/listarproductos.htm" title="Lista de productos"
			class="btn btn-success btn-small pull-right"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
	</h1>
</div>
<div class="page-header position-relative">
	<form id="form_producto" class="form-horizontal">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span10">

					<div class="row-fluid">
						<div class="span6">

							<div class="control-group">
								<label class="control-label" for="">Nombre Producto</label>
								<div class="controls">
									<input type="text" name="nombre" id="nombre"
										placeholder="Nombre">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Categoría</label>
								<div class="controls">
									<select name="categoria" class="">

										<c:forEach var="a" items="${model.getlistacategorias}">

											<option value="${a.id}">
												<c:out value="${a.descripcion}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="span6">

							<div class="control-group">
								<label class="control-label" for="">Marca</label>
								<div class="controls">
									<select name="marca" class="">

										<c:forEach var="a" items="${model.getlistamarcas}">

											<option value="${a.id}">
												<c:out value="${a.descripcion}"></c:out>
											</option>
										</c:forEach>
									</select>
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
			</strong> Su producto se registró exitosamente. <br>
		</div>
		<div style="display: none" id="mensajealertaerror"
			class="alert alert-error">
			<strong> <i class="ace-icon fa fa-check"></i> No se pudo
				registrar!
			</strong> llene los campos requeridos. <br>
		</div>



		<div class="form-actions">

			<button title="Agregar Producto" type="submit"
				class="btn btn-success">
				<i class="icon-save bigger-110"></i>Agregar
			</button>
			<a href="../sistema/listarproductos.htm" title="Regresar Panel"
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
	$('#form_producto')
			.submit(
					function(event) {
						var asd = $(this).serialize();
						$
								.post(
										'${pageContext.request.contextPath}/sistema/registrarproducto.htm',
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

	function validar() {

		var a = document.getElementById("serie").value;
		var b = a.split(";");
		var suma;
		var stock = document.getElementById("stock").value;
		for (var i = 0; i < b.length; i++) {

			if (b[i].trim().length() != 0) {
				suma = i + 1;
			}

		}
		if (suma == 0) {
			return true;
		} else {
			alert("La cantidad de ufhieruhfeqr");
			return false;
		}

	}
</script>



