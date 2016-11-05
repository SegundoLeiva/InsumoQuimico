<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<a href="#" class="brand">
	<small>
		<img src="../assets/images/logo.png" style="max-width: 10%;">
		Sistema Inventario Computienda
	</small>
</a>

<ul class="nav ace-nav pull-right">


	<li class="green">
		<a data-toggle="dropdown" class="dropdown-toggle" href="#"> 
			<i class="icon-envelope icon-animated-vertical"></i> 
			<span class="badge badge-success">5</span>
		</a>

		<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-closer">
			<li class="nav-header">
				<i class="icon-envelope-alt"></i> 5 Mensajes
			</li>

			<li>
				<a href="#"> 
					<img src="../assets/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar" /> 
					<span class="msg-body"> 
						<span class="msg-title"> 
							<span class="blue">Alex:</span> Ciao sociis natoque	penatibus et auctor ...
						</span> 
						<span class="msg-time"> 
							<i class="icon-time"></i> 
							<span>a moment ago</span>
						</span>
					</span>
				</a>
			</li>

			<li>
				<a href="#"> 
					<img src="../assets/avatars/avatar3.png" class="msg-photo" alt="Susan's Avatar" /> 
					<span class="msg-body"> 
						<span class="msg-title"> 
							<span class="blue">Susan:</span> Vestibulum id ligula porta felis euismod ...
						</span> 
						<span class="msg-time"> 
							<i class="icon-time"></i> 
							<span>20 minutes ago</span>
						</span>
					</span>
				</a>
			</li>

			<li>
				<a href="#"> 
					<img src="../assets/avatars/avatar4.png" class="msg-photo" alt="Bob's Avatar" /> 
					<span class="msg-body"> 
						<span class="msg-title"> 
							<span class="blue">Bob:</span> Nullam quis risus eget urna mollis ornare ...
						</span> 
						<span class="msg-time"> 
							<i class="icon-time"></i> 
							<span>3:15 pm</span>
						</span>
					</span>
				</a>
			</li>

			<li>
				<a href="#"> Ver todos los mensajes
					<i class="icon-arrow-right"></i>
				</a>
			</li>
		</ul>
	</li>

	<li class="light-blue">
		<a data-toggle="dropdown" href="#" class="dropdown-toggle"> 
			<img class="nav-user-photo" src="../assets/avatars/user.jpg" alt="Jason's Photo" /> 
			<span class="user-info"> 
				<small>Bienvenido,</small>	<security:authentication property="principal.usuario" />
			</span> 
			<i class="icon-caret-down"></i>
		</a>

		<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
			<li>
				<a href="<c:out value="configuracion.htm" />"> 
					<i class="icon-cog"></i> Configuración
				</a>
			</li>

			<li>
				<a href="../home/perfil.htm" > 
					<i class="icon-user"></i> Perfil
				</a>
			</li>

			<li class="divider"></li>

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