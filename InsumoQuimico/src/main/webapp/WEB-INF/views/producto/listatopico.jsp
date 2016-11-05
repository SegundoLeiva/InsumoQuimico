<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header">
	<h1>
		Lista de Alumnos en Tópico <small><i class="icon-double-angle-right"></i>
			Información del Alumno</small>

	</h1>
</div>


<div class="row-fluid">
	<div class="span12">

		<div class="table-header"
			style="background: #2283c5; padding-left: 5px; padding-bottom: 2px;">

			<a href="#dni" data-toggle="modal" title="Agregar Alumno"
				class="btn btn-small btn-primary" style="border: 1px solid #c4e7ff;"><i
				class="icon-inbox"></i>Agregar</a>

		</div>
		<table id="listatopico"
			class="table table-striped table-bordered table-hover">

			<thead>
				<tr>
					<th class="center">N°</th>
					<th class="">Paciente</th>
					<th class="center">Nro de Historia</th>
					<th class="center">Categoría</th>
					<th class="center">Estado</th>
					<th class="center">Llenar Ficha</th>


				</tr>
			</thead>
			<tbody>

				<c:forEach var="n" items="${model.listatopico}" varStatus="contador">
					<tr>
						<td class="center"><c:out value="${contador.count}" /></td>
						<td><c:out value="${n[1]} ${n[2]} ${n[3]}"></c:out></td>
						<td class="center"><c:out value="${n[4]}"></c:out></td>
						<td class="center"><c:out value="${n[5]}"></c:out></td>
	
							
							<td class="center"><c:choose>
								<c:when test="${n[6]!=null}">
									<span class="label label-success">Atendido</span>
								</c:when>

								<c:otherwise>
									<span class="label label-warning">Pendiente</span>
								</c:otherwise>
							</c:choose></td>
							
							<td class="center"><c:choose>
								<c:when test="${n[6]!=null}">
									<i class="icon-edit"></i> Llenado
								</c:when>

								<c:otherwise>
									<a
							href="fichatopico.htm?idclinico=<c:out value="${n[0]}" />"
							title="Llenar"><i class="icon-edit"></i> Llenar </a>
								</c:otherwise>
							</c:choose></td>
							
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<!--/.span-->
</div>
<!--/.row-fluid-->