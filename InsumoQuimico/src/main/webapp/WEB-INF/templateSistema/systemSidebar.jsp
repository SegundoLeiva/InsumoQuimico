<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<a href="#" class="brand"> <small> <i class="ace-icon icon-beaker"></i>
						Sistema Insumos Químicos
				</small>
				</a>

<ul class="nav ace-nav pull-right">


	<li class="light-blue">
		<a data-toggle="dropdown" href="#" class="dropdown-toggle"> 
			<span class="user-info"> 
				<small>Bienvenido,<br>${session_usuario.nombre}</small>	
			</span> 
			<i class="icon-caret-down"></i>
		</a>

		<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
			<li>
				<a href="#cerrar" data-toggle="modal"> 
					<i class="icon-off"></i> Cerrar Sesión
				</a>
			</li>
		</ul>
	</li>
</ul>
<div id="cerrar" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		

		<div class="modal-body">
			<h4>¿Estás seguro que desea cerrar sesión?</h4>


		</div>
		<div class="modal-footer">
			<c:url value="/logout.htm" var="logoutUrl" />
			<a href="${logoutUrl}" class="btn btn-primary" >Aceptar</a>
			<button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
		</div>

	</div>