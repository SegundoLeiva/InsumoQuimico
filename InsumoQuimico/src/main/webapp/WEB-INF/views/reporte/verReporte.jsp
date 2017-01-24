<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header position-relative">
	<form method="POST" class="form-horizontal">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span10">

					<div class="row-fluid">
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="idUnidadMinera">Unidad Minera</label>
								<div class="controls">
									<select name="idUnidadMinera" id="idUnidadMinera">
										<c:forEach var="item" items="${listaUnidadesMineras}">
											<option value="${item.valorOrganizacional}">${item.descripcion}</option>
										</c:forEach>
									</select>
								</div>
							</div>			
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="anio">Año</label>
								<div class="controls">	
									<select name="anio" id="anio">
										<c:forEach var="i" begin="${listRangoAnio[0].id.idCatalogoDetalle}" end="${listRangoAnio[1].id.idCatalogoDetalle}" step="1" varStatus="loop">
											<option value="${loop.end - i + loop.begin}" ${loop.end - i + loop.begin == anioActual ? 'selected' : ' '}>${loop.end - i + loop.begin}</option>
										</c:forEach>								
									</select>						
								</div>
							</div>	
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label" for="mes">Mes</label>
								<div class="controls">									
									<select name="mes" id="mes">						
										<option value="0">Enero</option>
										<option value="1">Febrero</option>
										<option value="2">Marzo</option>
										<option value="3">Abril</option>
										<option value="4">Mayo</option>
										<option value="5">Junio</option>
										<option value="6">Julio</option>
										<option value="7">Agosto</option>
										<option value="8">Septiembre</option>
										<option value="9">Octubre</option>
										<option value="10">Noviembre</option>
										<option value="11">Diciembre</option>
									</select>
								</div>
							</div>	
						</div>
					</div>
				</div>
			</div>

		</div>
	</form>	
</div>