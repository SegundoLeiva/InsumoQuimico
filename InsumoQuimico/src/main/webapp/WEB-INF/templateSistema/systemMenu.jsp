<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="sidebar active open" id="sidebar">

	<ul class="nav nav-list active open">
		<!-- ADMINISTRACION -->
		<li id="administracion"><a href="#" class="dropdown-toggle"> <i
				class="icon-folder-open"></i> <span class="menu-text "> Administración </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu" style="display: block;">
					<li id="areas" class="<c:if test="${index==3}">active</c:if>"><a href="../area/verAreas.htm"
					class="tamanioTextMenu"><i class="icon-align-justify tamanioTextMenu"></i> Mantenimiento de Áreas </a></li>
					<li id="areas" class="<c:if test="${index==5}">active</c:if>"><a href="../insumo/verInsumos.htm"
					class="tamanioTextMenu"><i class="icon-align-justify tamanioTextMenu"></i> Mantenimiento de Insumos </a></li>
			</ul>
		</li>
		

		<li id="insumosQuimicos"><a href="#" class="dropdown-toggle"> <i
				class="icon-folder-open"></i> <span class="menu-text "> Insumos Químicos </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu" style="display: block;">

				<li id="ingresarMercaderia" class="<c:if test="${index==4}">active</c:if>"><a href="../ingresarMercaderia/verMercaderias.htm"
				class="tamanioTextMenu"><i class="icon-align-justify "></i> Ingresar Mercadería </a></li>
			</ul>
		</li>

		
		
	</ul>


</div>