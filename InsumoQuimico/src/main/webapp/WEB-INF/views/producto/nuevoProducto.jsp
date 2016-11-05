<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Registrar Producto <small> <i class="icon-double-angle-right"></i>
			Descripcion
		</small> <a href="../producto/verProductos.htm" title="Lista de productos"
			class="btn btn-success btn-small pull-right"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
	</h1>
</div>
<div class="page-header position-relative">
	<form id="form_producto" class="form-horizontal">
	<input type="hidden" value="${producto.id}" id="id" name="id">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span10">

					<div class="row-fluid">
						<div class="span6">

							<div class="control-group">
								<label class="control-label" for="">Nombre Producto</label>
								<div class="controls">
									<input type="text" name="nombre" id="nombre" required value="${producto.nombre}"
										placeholder="Nombre" data-msg-required="El campo Nombre es obligatorio.">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Categoría</label>
								<div class="controls">
									<select name="codCategoria" class="">
										<c:forEach var="item" items="${getlistacategorias}">
											<option value="${item.id}" ${item.id == producto.codCategoria ? 'selected' : ' '}>${item.descripcion}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="span6">

							<div class="control-group">
								<label class="control-label" for="">Marca</label>
								<div class="controls">
									<select name="codMarca" class="">
										<c:forEach var="item" items="${getlistamarcas}">
											<option value="${item.id}" ${item.id == producto.codMarca ? 'selected' : ' '}>${item.descripcion}</option>
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

		<div class="form-actions">

			<a title="Agregar Producto" id="agregarProducto"
				class="btn btn-success">
				<i class="icon-save bigger-110"></i>Agregar
			</a>
			<a href="../producto/verProductos.htm" title="Regresar Panel"
				type="submit" class="btn btn-info"> <i
				class="icon-undo bigger-110"></i>Regresar
			</a>

		</div>
	</form>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel">Cargando...</h4>
      </div>
      <div align="center" style="padding: 30px 0px">
      	<div class="loader"></div>
      </div>
        
    </div>
  </div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">

	$("#agregarProducto").click(function(){
		var mensaje = "guardó";
		if($("#id").val()!=""){mensaje="modificó";};
		if(validarCamposRequeridos("form_producto")){
			alertify.confirm("Confirmar","¿Esta seguro realizar esta operación?",
					function(){
						var url = '${pageContext.request.contextPath}/producto/registrarProducto.htm';
					    $.ajax({
					           type: "POST",
					           url: url,
					           data: $("#form_producto").serialize(),
					           success: function(data)
					           {		        	   
					        	   alertify.success("Se "+mensaje+" correctamente");
					           }
					    });
							  },
					function(){});
		}
	
	});
	
</script>

