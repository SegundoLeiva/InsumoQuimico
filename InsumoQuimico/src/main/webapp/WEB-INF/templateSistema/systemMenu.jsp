<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="sidebar active open" id="sidebar">

	<ul class="nav nav-list active open">
		<!-- INICIO -->
		<li id="inicio"><a href="#" class="dropdown-toggle"> <i
				class="icon-home"></i> <span class="menu-text "> Inicio </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu" style="display: block;">
				<li id="productos" class="<c:if test="${index==1}">active</c:if>"><a href="../producto/verProductos.htm"><i
						class="icon-align-justify"></i> Productos </a></li>
				<li id="marcas" class="<c:if test="${index==2}">active</c:if>"><a href="../marca/verMarcas.htm"><i
						class="icon-align-justify"></i> Marcas </a></li>
			</ul></li>
	</ul>


</div>