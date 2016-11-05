<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Orden de Venta <small> <i class="icon-double-angle-right"></i>
			Descripcion
		</small> <a href="../sistema/listarproductos.htm" title="Lista de productos"
			class="btn btn-success btn-small pull-right"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
	</h1>
</div>
<div class="row-fluid">
	<div class="">
		<div class="span10">
			<form id="form1" class="form-horizontal">
				<div class="row-fluid">
					<div class="span4">
						<div class="control-group">
							<label class="control-label" for="">Nro Documento</label>
							<div class="controls">
								<input type="text" name="numVen" id="numVen" value=""
									placeholder="Número">

							</div>
						</div>


						<div class="control-group">
							<label class="control-label">Producto:</label>
							<div class="controls">
								<div class="input-append">
									<input class="input-medium" name="codigo" id="numerocodigo"
										readonly="readonly" type="text" required> <a
										href="#codigo" data-toggle="modal" class="btn btn-info"
										type="button">Buscar</a>
								</div>
							</div>
						</div>



					</div>
					<div class="span4">

						<div class="control-group">
							<label class="control-label" for="">Cantidad</label>
							<div class="controls">
								<input type="text" name="cantidad" id="cantidad"
									placeholder="Cantidad">
							</div>
						</div>



					</div>
					<div class="span4">

						<div class="control-group">
							<label class="control-label"></label>
							<div class="controls">
								<input type="hidden" name="serie" id="serie">
							</div>
						</div>

					</div>
				</div>

			</form>
		</div>
	</div>

</div>



<div class="form-actions" style="margin-top: 0px; margin-bottom: 0px">

	<button title="Agregar Producto" type="submit"
		class="btn btn-small btn-success" id="btnInsertar">
		<i class="icon-save bigger-110"></i>Agregar
	</button>

	<a href="#numeroserie" data-toggle="modal" onclick="enviarcantidad()"
		class="btn btn-small btn-success" type="button">Nueva serie</a>
		
		<a href="#seriemodal" data-toggle="modal" 
		class="btn btn-small btn-success" type="button">Lista Serie</a>
</div>





<form method="POST" action="<c:url value='registrarventa.htm'/>">
	<div style="height: 300px; border: 1px solid #e5e5e5; overflow: scroll">
		<table class="table table-striped table-bordered table-hover"
			id="tblDatos">
			<tr class="">
				<td class="center" style="width: 10px">Nro</td>
				<td class="center">Documento</td>
				<td class="center">Producto</td>
				<td class="center" style="width: 60px">Cantidad</td>
				<td class="center" style="width: 30px">Borrar</td>

			</tr>
		</table>
	</div>
	<div class="form-actions">

		<button title="Agregar Marca" type="submit" class="btn btn-info">
			<i class="icon-ok bigger-110"></i>Guardar todo
		</button>

	</div>
</form>



<%@ include file="/WEB-INF/views/venta/ventamodal.jsp"%>









<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$("#btnInsertar").click(addUsuario);

	});

	function addUsuario() {
		var numVen = $("#numVen").val();
		var numerocodigo = $("#numerocodigo").val();
		var cantidad = $("#cantidad").val();
		var serie = $("#serie").val();
		var tablaDatos = $("#tblDatos");
		nro = document.getElementById('tblDatos').rows.length;
		coun = document.getElementById('tblDatos').rows.length - 1;
		if (numVen != "" && numerocodigo != "" && cantidad != "" && serie != "") {

			tablaDatos
					.append("<tr>"
							+ "<td>"
							+ nro
							+ "<input type='hidden' name='contadores' ></td>"
							+ "<td>"
							+ numVen
							+ "<input type='hidden' value='"+numVen+"' name='venta"+coun+"' ></td>"
							+ "<td>"
							+ numerocodigo
							+ "<input type='hidden' value='"+numerocodigo+"' name='producto"+coun+"' ></td>"
							+ "<td>"
							+ cantidad
							+ "<input type='hidden' value='"+cantidad+"' name='cantidad"+coun+"' >"
							+ "<input type='hidden' value='"+serie+"' name='serie"+coun+"' ></td>"
							+ "<td><a href='#' onclick='eliminar(this)' id='del'><i class='icon-trash'></i></a></td>"

							+ "</tr>");

			reset_campos();
		}
	}

	function reset_campos() {

		$("#numerocodigo").val("");
		$("#cantidad").val("");
		$("#serie").val("");

	}
	function eliminar(a) {

		var td = a.parentNode;
		var tr = td.parentNode;
		var table = tr.parentNode;
		table.removeChild(tr);

	}

</script>














