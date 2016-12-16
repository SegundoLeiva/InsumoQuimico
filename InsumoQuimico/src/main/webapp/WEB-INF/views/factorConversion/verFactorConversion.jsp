<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="row-fluid">
	<div class="span12">
		<form method="POST">
		<input type="hidden" name="id" id="id">		
				<table class="tablaSearch table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">Nro</th>
							<th class="center">Unidad Medida De</th>
							<th class="center">Unidad Medida A</th>
							<th class="center">Factor Conversión</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jbean" items="${listaConsulta}"
							varStatus="contador">
							<tr>
								<td class="center">${contador.count}</td>
								<td class="center">${jbean.id.idUnidadMedidaDe}</td>
								<td class="center">${jbean.id.idUnidadMedidaA}</td>
								<td class="center">${jbean.factorConversion}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</form>

	</div>
	<!--/.span-->
</div>
<!--/.row-fluid-->
