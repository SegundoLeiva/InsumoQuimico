<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="row-fluid">
	<div class="span12">

		<div class="table-header"
			style="background: #2283c5; padding-left: 5px; padding-bottom: 2px;">

			<a href="#" onclick="agregarArea()"
				title="Nueva Área" class="btn btn-small btn-primary"
				style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Agregar
				Área</a>

		</div>
		<form id="formVerUnidadMineraArea" action="../area/eliminarUnidadMineraArea.htm" method="POST">
		<input type="hidden" name="idUnidadMineraArea" id="idUnidadMineraAreaEliminar">		
				<table id="tablaArea"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">Nro</th>
							<th class="center">Código</th>
							<th class="center">Descripción</th>
							<th class="center">Estado</th>
							<th class="center" width="10%">Opciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jbean" items="${listaUnidadMineraArea}"
							varStatus="contador">
							<tr>
								<td class="center"><c:out value="${contador.count}" /></td>
								<td class="center"><a id="modificarArea"
									href="#" onclick="modificarArea('${jbean.idUnidadMineraArea}')"
									title="Modificar Área"><c:out value="${jbean.idUnidadMineraArea}"></c:out></a></td>
								<td class="center"><c:out value="${jbean.area.area}"></c:out></td>
								<td class="center"><c:choose>
										<c:when test="${jbean.vigencia=='S'}">
											<span class="label label-success">Vigente</span>
										</c:when>
										<c:otherwise>
											<span class="label label-warning">No Vigente</span>
										</c:otherwise>
									</c:choose></td>
								<td class="center"><a class="red" href="#" onclick="eliminarUnidadMineraArea('${jbean.idUnidadMineraArea}')"> <i
										class="icon-trash bigger-130"></i>
								</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
</form>

	</div>
	<!--/.span-->
</div>
<!--/.row-fluid-->

<%@ include file="/WEB-INF/views/area/nuevaArea.jsp"%>
