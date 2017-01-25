<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1 class="tituloHeader">
		<span> <i class="icon-double-angle-right"></i>
		</span>
 		<c:if test="${mostrarBotonNuevo and cierreMes eq null}">
 			<a href="<c:url value="nuevo.htm"/>" title="nuevo" style="margin-left: 5px" 
 			class="btn btn-info btn-small pull-right"><i class="icon-plus"></i><span class="hidden-480">Nuevo</span></a> 
 		</c:if>
 		<c:if test="${mostrarBotonBuscar}">
 			<a href="#" title="Buscar" onclick="buscarConsulta()" class="btn btn-success btn-small pull-right">
 			<i class="icon-search"></i><span class="hidden-480">Buscar</span></a>
 		</c:if>
 		<c:if test="${mostrarBotonRegresar}">
 			<a href="<c:url value="listar.htm"/>?cod=RE" title="Regresar" style="margin-left: 5px"
			class="btn btn-info btn-small pull-right"><i class="icon-undo"></i><span class="hidden-480">Regresar</span></a>
 		</c:if>
 		<c:if test="${mostrarBotonGuardar}">
 			<a href="#" id="guardar" title="Guardar"
			class="btn btn-success btn-small pull-right"><i class="icon-save"></i><span class="hidden-480">${accion=='EDITAR' ? 'Modificar' : 'Guardar'}</span></a>
 		</c:if>
 		<c:if test="${mostrarBotonTxt}">
 			<a href="#" title="Generar Reporte" onclick="exportarReporteTxt()" class="btn btn-success btn-small pull-right">Exportar TXT</a>
 		</c:if>
 		
 		<span class="pull-right orange" style="margin-right: 15px;font-weight: normal;" id="codigoGenerado"></span>
	</h1>
</div>
<c:if test="${cierreMes eq 'C'}">
<div class="alert alert-error">
	El período actual se encuentra cerrado.
</div>
</c:if>