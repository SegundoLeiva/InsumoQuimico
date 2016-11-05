<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="row-fluid">
	<div class="span12">

		<div class="table-header"
			style="background: #2283c5; padding-left: 5px; padding-bottom: 2px;">

			<a href="../sistema/nuevoproducto.htm" data-toggle="modal"
				title="Nuevp Producto" class="btn btn-small btn-primary"
				style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Registrar
				Producto</a>

		</div>
		<c:choose>
			<c:when test="${empty model.listacitas}">
				<h3>No hay productos disponible. Registrar un producto</h3>
			</c:when>
			<c:otherwise>
				<table id="historiasocial"
					class="table table-striped table-bordered table-hover">

					<thead>
						<tr>
							<th class="center">N°</th>
							<th class="center">Descripion</th>
							<th class="center">Stock Actual</th>
							<th class="center">Estado</th>
							<th class="center">Eliminar</th>



						</tr>
					</thead>
					<tbody>
						<c:forEach var="n" items="${model.listacitas}"
							varStatus="contador">
							<tr>
								<td class="center"><c:out value="${contador.count}" /></td>
								<td><a
									href="modificarproducto.htm?idproducto=<c:out value="${n[0]}" />"
									title="Modificar Producto"><c:out value="${n[2]}"></c:out></a></td>
								<td class="center"><c:out value="${n[3]}"></c:out></td>
								<td class="center"><c:choose>
										<c:when test="${n[4]==1}">
											<span class="label label-success">Habilitado</span>
										</c:when>

										<c:otherwise>
											<span class="label label-warning">Deshabilitado</span>
										</c:otherwise>
									</c:choose></td>
								<td class="center"><a class="red" href="#eliminarproducto"
									onclick="eliminar('${n[0]}')" data-toggle="modal"> <i
										class="icon-trash bigger-130"></i>
								</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>


	</div>
	<!--/.span-->
</div>
<!--/.row-fluid-->



<!-- ######################### Eliminar Producto ##################################-->

<form method="POST" class="form-horizontal"
		action="<c:url value='eliminarproducto.htm'/>">
<div id="eliminarproducto" class="modal hide fade" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h4 id="myModalLabel">Seguro que desea eliminar este producto?</h4>
		<input type="hidden" id="idproducto" name="idproducto">
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
		<button class="btn btn-primary" type="submit">Eliminar</button>
	</div>

</div>
</form>

<script type="text/javascript">
	function eliminar(a) {

		$("#idproducto").val(a);
	}
</script>


