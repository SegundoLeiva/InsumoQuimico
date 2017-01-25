<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header position-relative">
	<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">Nro</th>
							<th class="center">Código</th>
							<th class="center">Área</th>
							<th class="center">Cantidad Total</th>
							<th class="center">Fecha Creación</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="jbean" items="${listaConsumoReporte}"
							varStatus="contador">
							<tr>
								<td class="center">${contador.count}</td>
								<td class="center">${jbean.idConsumo}</td>
								<td class="center">${jbean.area}</td>
								<td class="center">${jbean.cantidad}</td>
								<td class="center">${jbean.fechaCreacion}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>