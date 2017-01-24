<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="sidebar active open" id="sidebar">
	<ul class="nav nav-list active open">
	<c:forEach  var="obj" varStatus="status" items="${session_usuario.lst_opciones}">
	  <c:if test="${obj.idPadre == 0}">
	   <c:set var="idOpcion" value="${obj.idOpcion}" />
	  		<li>
	  			<a href="#" class="dropdown-toggle"> <i
					class="yellow icon-folder-open"></i><span class="menu-text ">${obj.opcion}</span> <b
					class="arrow icon-angle-down"></b>					
				</a>
				<ul class="submenu" style="display: block;">
				<c:forEach var="objHijo" items="${session_usuario.lst_opciones}">
					<c:if test="${objHijo.idPadre==idOpcion}">
						<li class="<c:if test="${objHijo.orden==index}">active</c:if>"><a href="${objHijo.linkOpcion}"
						class="tamanioTextMenu"><i class="icon-align-justify tamanioTextMenu"></i>${objHijo.opcion}</a></li>
				 	</c:if>
				 </c:forEach>
				</ul>
			</li>
	  </c:if>
	 </c:forEach>
	</ul>
	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="icon-double-angle-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
</div>