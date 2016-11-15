<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="sidebar active open" id="sidebar">
	<ul class="nav nav-list active open">
	
	 <c:forEach  var="obj" varStatus="status" items="${session_usuario.lst_opciones}">
	  <c:if test="${obj.idPadre == 0}">
	   <c:set var="idOpcion" value="${obj.idOpcion}" />
	  		<li>
	  			<a href="#" class="dropdown-toggle"> <i
					class="icon-folder-open"></i> <span class="menu-text "> ${obj.opcion}</span> <b
					class="arrow icon-angle-down"></b>					
				</a>
				<ul class="submenu" style="display: block;">
				<c:forEach var="objHijo" items="${session_usuario.lst_opciones}">
					<c:if test="${objHijo.idPadre==idOpcion}">
						<li class="<c:if test="${objHijo.orden==index}">active</c:if>"><a href="${objHijo.linkOpcion}"
						class="tamanioTextMenu"><i class="icon-align-justify tamanioTextMenu"></i> ${objHijo.opcion} </a></li>
				 	</c:if>
				 </c:forEach>
				</ul>
			</li>
	  </c:if>
	 </c:forEach>




<!-- 			<ul class="submenu" style="display: block;"> -->
<%-- 					<li id="areas" class="<c:if test="${index==3}">active</c:if>"><a href="../area/verAreas.htm" --%>
<!-- 					class="tamanioTextMenu"><i class="icon-align-justify tamanioTextMenu"></i> Mantenimiento de Áreas </a></li> -->
<%-- 					<li id="areas" class="<c:if test="${index==5}">active</c:if>"><a href="../insumo/verInsumos.htm" --%>
<!-- 					class="tamanioTextMenu"><i class="icon-align-justify tamanioTextMenu"></i> Mantenimiento de Insumos </a></li> -->
<!-- 			</ul> -->

		

<!-- 		<li id="insumosQuimicos"><a href="#" class="dropdown-toggle"> <i -->
<!-- 				class="icon-folder-open"></i> <span class="menu-text "> Insumos Químicos </span> <b -->
<!-- 				class="arrow icon-angle-down"></b> -->
<!-- 		</a> -->

<!-- 			<ul class="submenu" style="display: block;"> -->

<%-- 				<li id="ingresarMercaderia" class="<c:if test="${index==4}">active</c:if>"><a href="../ingresarMercaderia/verMercaderias.htm" --%>
<!-- 				class="tamanioTextMenu"><i class="icon-align-justify "></i> Ingresar Mercadería </a></li> -->
<%-- 				<li id="ingresarMercaderia" class="<c:if test="${index==6}">active</c:if>"><a href="../registrarConsumo/verConsumos.htm" --%>
<!-- 				class="tamanioTextMenu"><i class="icon-align-justify "></i> Registrar Consumo </a></li> -->
<!-- 			</ul> -->
<!-- 		</li> -->

		
		
	</ul>


</div>









<%--  <c:forEach  var="obj" varStatus="status" items="${session_usuario.lst_opciones}">             --%>
<%--             <c:if test="${obj.linkOpcion == '#'}"> --%>
<%--                 d.add('<c:out value="${obj.idOpcion}"/>','<c:out value="${obj.idPadre}"/>','<c:out value="${obj.opcion}"/>',''); --%>
<%--             </c:if> --%>
<%--             <c:if test="${obj.linkOpcion != '#'}">                 --%>
<%--                 d.add('<c:out value="${obj.idOpcion}"/>','<c:out value="${obj.idPadre}"/>','<c:out value="${obj.opcion}"/>',"javascript:carga_pagina('<c:out value="${obj.linkOpcion}"/>','<c:out value="${obj.opcion}"/>','<c:out value="${obj.idOpcion}"/>' )"); --%>
<%--             </c:if> --%>
<%--         </c:forEach> --%>