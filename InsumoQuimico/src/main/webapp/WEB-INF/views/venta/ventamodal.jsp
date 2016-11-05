<%@ include file="/WEB-INF/views/include.jsp"%>

<!-- Modal Productos-->

<div id="codigo" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">Búsqueda Productos</h3>
	</div>
	<div class="modal-body">
		<table id="productosmodal"
			class="table table-striped table-bordered table-hover">

			<thead>
				<tr>
					<th class="center">N°</th>
					<th class="center">Stock</th>
					<th class="center">Descripción</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="n" items="${model.listacitas}" varStatus="contador">
					<tr>
						<td class="center">${contador.count}</td>
						<td class="center"><c:out value="${n[3]}"></c:out></td>
						<td><c:choose>
								<c:when test="${n[3]>0}">
									<a href="#"
										onclick="agregar('<c:out value="${n[2]}"></c:out>')"> <c:out
											value="${n[2]}" />
									</a>
								</c:when>
								<c:otherwise>
									${n[2]}
								</c:otherwise>
							</c:choose></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>


	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
	</div>

</div>


<!-- Agregar Nuemro de Serie -->

<div id="numeroserie" class="modal hide fade" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">Agregar Series</h3>
	</div>
	<div class="modal-body">


		<div class="row-fluid">
			<div class="page-content">
				<div class="span8">
					<textarea rows="10" id="agregaserie"></textarea>


				</div>
				<div class="span4">

					<label id="cantser"></label>


				</div>

			</div>

		</div>


	</div>

	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
		<button class="btn btn-primary" onclick="insertar()" type="submit">Agregar</button>
	</div>

</div>


<script type="text/javascript" charset="utf-8">
	function insertar() {
		var a = document.getElementById("agregaserie").value;

		var b = a.split("\n");
		var c = "";
		for (var i = 0; i < b.length; i++) {

			c = c + b[i] + ";";
		}

		$('#serie').val(c);
		$('#numeroserie').modal('hide');

	}

	function enviarcantidad() {
		var c = document.getElementById("cantidad").value;
		document.getElementById('cantser').innerHTML = c;

	}
</script>




<!-- Modal Lista de Series-->

<div id="seriemodal" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">Búsqueda de Series</h3>
	</div>
	<div class="modal-body">
		<table id="tablaserie"
			class="table table-striped table-bordered table-hover">

			<thead>
				<tr>
					<th class="center">N°</th>
					<th class="center">Nro Serie</th>
					<th class="center sorting_disabled" role="columnheader" rowspan="1"
						colspan="1"
						aria-label="
												
													
													
												
											"
						style="width: 61px;"><label> <input type="checkbox">
							<span class="lbl"></span>
					</label></th>


				</tr>
			</thead>
			<tbody>
				<c:forEach var="n" items="${model.listaserie}" varStatus="contador">
					<tr>
						<td class="center">${contador.count}</td>
						<td><c:choose>
								<c:when test="${n[3]>0}">
									<a href="#"
										onclick="agregar('<c:out value="${n[2]}"></c:out>')"> <c:out
											value="${n[2]}" />
									</a>
								</c:when>
								<c:otherwise>
									${n[2]}
								</c:otherwise>
							</c:choose></td>
						<td class="center  sorting_1"><label> <input
								type="checkbox" value="${n[2]}"> <span class="lbl"></span>
						</label></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>

	 <input type="button" value="Validate"
		  onClick="validate();return false;" />

	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
	</div>

</div>

<script type="text/javascript">
	function validate() {

		var checkBoxes = document.getElementsByTagName('input');
		//alert(checkBoxes.length);
		var param = "";
		for (var counter = 0; counter < checkBoxes.length; counter++) {
			if (checkBoxes[counter].type.toUpperCase() == 'CHECKBOX'
					&& checkBoxes[counter].checked == true) {
				param += checkBoxes[counter].value + ";";
			}
		}
		$('#serie').val(param);
		$('#seriemodal').modal('hide');
	}
</script>


