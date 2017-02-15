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
							<th class="center">Ver Detalle</th>
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
								<td class="center">
									<a class="green" onclick="verDetalleConsumo('${jbean.idConsumo}')" href="#" 
										title="Consultar"> <i
											class="icon-align-justify bigger-130"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>
<%@ include file="/WEB-INF/views/cerrarPeriodo/verDetalleConsumo.jsp"%>