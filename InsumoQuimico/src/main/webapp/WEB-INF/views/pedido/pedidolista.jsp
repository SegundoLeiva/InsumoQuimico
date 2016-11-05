<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="row-fluid">
	<div class="span12">

		<div class="table-header"
			style="background: #2283c5; padding-left: 5px; padding-bottom: 2px;">

			<a href="../sistema/pedidopanel.htm" data-toggle="modal"
				title="Nuevp Producto" class="btn btn-small btn-primary"
				style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Registrar
				Producto</a>

		</div>
		<table id="historiasocial"
			class="table table-striped table-bordered table-hover">

			<thead>
				<tr>
					<th class="center">N°</th>
					<th class="center">Descripion</th>
					<th class="center">Stock Actual</th>
					<th class="center">Estado</th>
					<th class="center">Situación</th>



				</tr>
			</thead>
			<tbody>
				<c:forEach var="n" items="${model.listacitas}" varStatus="contador">
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
						<td class="center">s</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<!--/.span-->
</div>
<!--/.row-fluid-->




