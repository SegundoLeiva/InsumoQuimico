<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header position-relative">
	<form method="POST" class="form-horizontal">
	<input type="hidden" name="id" id="id">	
		<div class="row-fluid">
			<div class="page-content">
				<div class="span12">

					<div class="row-fluid">
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idUnidadMinera">Unidad Minera</label>
								<div class="controls">
									<select name="idUnidadMinera" id="idUnidadMinera">
										<c:forEach var="item" items="${listaUnidadesMineras}">
											<option value="${item.valorOrganizacional}" ${item.valorOrganizacional == beanConsulta.idUnidadMinera ? 'selected' : ' '}>${item.descripcion}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Inicio</label>
								<div class="controls">
									<span class="input-icon input-icon-right"> 
										<input type="text" name="fechaInicio" id="fechaInicio" class="span12 date-picker" readonly="readonly" value="${beanConsulta.fechaInicio}"> <i class="icon-calendar"></i>
									</span>								</div>
							</div>							
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idUnidadMineraArea">Área</label>
								<div class="controls">									
									<select name="idUnidadMineraArea" id="idUnidadMineraArea">						

									</select>
								</div>
							</div>	
							<div class="control-group">
								<label class="control-label" for="fecha">Fecha Fin</label>
								<div class="controls">
									<span class="input-icon input-icon-right"> 
										<input type="text" name="fechaFin" id="fechaFin" class="span12 date-picker" readonly="readonly" value="${beanConsulta.fechaFin}"> <i class="icon-calendar"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="span4">
<!-- 							<div class="control-group"> -->
<!-- 								<label class="control-label" for="idConsumo">Código Consumo</label> -->
<!-- 								<div class="controls"> -->
<%-- 									<input type="text" class="form-control" name="idConsumo" id="idConsumo" value="${beanConsulta.idConsumo}"> --%>
<!-- 								</div> -->
<!-- 							</div>	 -->
						</div>
					</div>
				</div>
			</div>

		</div>

	</form>
	<hr>
	<table class="tablaSearch table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center" width="5%">Nro</th>
							<th class="center">Código</th>
							<th class="center">Área</th>
							<th class="center">Cantidad Total</th>
							<th class="center">Fecha Creación</th>
							<th class="center" width="10%">Opciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jbean" items="${listaConsulta}"
							varStatus="contador">
							<tr>
								<td class="center">${contador.count}</td>
								<td class="center">${jbean.idConsumo}</td>
								<td class="center">${jbean.area}</td>
								<td class="center">${jbean.cantidad}</td>
								<td class="center">${jbean.fechaCreacion}</td>
								<td class="center">
									<c:if test="${cierreMes eq null}">
										<a class="blue" href="modificar.htm?id=<c:out value="${jbean.idConsumo}" />"
											title="Modificar"> <i class="icon-edit bigger-130"></i>
										</a>
									</c:if>
									<a class="green" href="consultar.htm?id=<c:out value="${jbean.idConsumo}" />"
										title="Consultar"> <i
											class="icon-align-justify bigger-130"></i>
									</a>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>