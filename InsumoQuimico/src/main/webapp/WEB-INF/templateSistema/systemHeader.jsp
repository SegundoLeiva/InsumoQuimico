<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1 class="tituloHeader">
		<span> <i class="icon-double-angle-right"></i>
		</span>
 		<c:if test="${mostrarBotonNuevo}">
 			<a href="<c:url value="nuevo.htm"/>" title="nuevo" style="margin-left: 5px" 
 			class="btn btn-info btn-small pull-right"><i class="icon-plus"></i>Nuevo</a> 
 		</c:if>
 		<c:if test="${mostrarBotonBuscar}">
 			<a href="#" title="Buscar" onclick="buscarConsulta()" class="btn btn-success btn-small pull-right">
 			<i class="icon-search"></i>Buscar</a>
 		</c:if>
 		<c:if test="${mostrarBotonRegresar}">
 			<a href="<c:url value="listar.htm"/>?cod=RE" title="Regresar" style="margin-left: 5px"
			class="btn btn-info btn-small pull-right"><i class="icon-undo"></i>Regresar</a>
 		</c:if>
 		<c:if test="${mostrarBotonGuardar}">
 			<a href="#" id="guardar" title="Guardar"
			class="btn btn-success btn-small pull-right"><i class="icon-save"></i>Guardar</a>
 		</c:if>
			
	</h1>
</div>