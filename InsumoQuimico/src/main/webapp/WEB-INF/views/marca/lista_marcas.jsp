<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header"></div>

<div class="row-fluid">
	<div class="span12">

		<div class="table-header"
			style="background: #2283c5; padding-left: 5px; padding-bottom: 2px;">

			<a href="../sistema/nuevamarca.htm" data-toggle="modal"
				title="Nueva Marca" class="btn btn-small btn-primary"
				style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Registrar
				Marcas</a>

		</div>
		<c:choose>
			<c:when test="${empty model.listarmarcas}">
				<h3>No hay marcas disponible. Registrar una marca</h3>
			</c:when>
			<c:otherwise>
				<table id="listamarcas"
					class="table table-striped table-bordered table-hover">

					<thead>
						<tr>
							<th class="center">N°</th>
							<th class="center">Descripción</th>
							<th class="center">Estado</th>
							<th class="center">Eliminar</th>



						</tr>
					</thead>
					<tbody>
						<c:forEach var="n" items="${model.listarmarcas}"
							varStatus="contador">
							<tr>
								<td class="center"><c:out value="${contador.count}" /></td>
								<td><a
									href="modificarmarca.htm?idmarca=<c:out value="${n[3]}" />"
									title="Modificar Marca"><c:out value="${n[1]}"></c:out></a></td>
								<td class="center"><c:choose>
										<c:when test="${n[2]==1}">
											<span class="label label-success">Habilitado</span>
										</c:when>

										<c:otherwise>
											<span class="label label-warning">Deshabilitado</span>
										</c:otherwise>
									</c:choose></td>
								<td class="center"><a class="red" href="#eliminarmarca"
									onclick="eliminar('${n[3]}')" data-toggle="modal"> <i
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


<!-- ######################### Eliminar Marca ##################################-->

<form method="POST" class="form-horizontal"
	action="<c:url value='eliminarmarca.htm'/>">
	<div id="eliminarmarca" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h4 id="myModalLabel">Seguro que desea eliminar esta marca?</h4>
			<input type="hidden" id="idmarca" name="idmarca">
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
			<button class="btn btn-primary" type="submit">Eliminar</button>
		</div>

	</div>
</form>

<script type="text/javascript">
	function eliminar(a) {

		$("#idmarca").val(a);
	}
</script>



