
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="row-fluid">
	<div class="span10">
		<div class="page-header">
			<h1>
				Configuración de Cuenta <small> <i
					class="icon-double-angle-right"></i> Infomación del Perfil
				</small>
			</h1>
		</div>
		
			<!-- --------------- ALERTA ----------- -->
			<c:if test="${not empty param.success}">	
				<div class="alert alert-success">
					 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					
					<i class="icon-ok green"></i> ¡La Operacion se realizo correctamente! <strong class="green">Se
						guardaron los cambios.</strong>
				</div>				
			</c:if>
			<!-- ------------- FIN ALERTA ------------- -->
			
			<!-- --------------- ALERTA ----------- -->
			<c:if test="${not empty param.error}">	
				<div class="alert alert-error">
					 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					
					<i class=" icon-ban-circle "></i> ¡Los Datos Ingresados son Incorrectos!. <strong class="red">No se
						guardaron los cambios.</strong>
				</div>				
			</c:if>
			<!-- ------------- FIN ALERTA ------------- -->

		<div class="row-fluid">
			<div class="span8">
				<div class="page-content">



					<div class="page-header position-relative">
						<h5>
							Cambiar Contraseña <a href="#editarcontraseña" class="pull-right"
								data-toggle="modal" title="Editar Contraseña"><i
								class="icon-edit "></i> Editar</a>
						</h5>
					</div>
					<!--/.page-header-->


				</div>



			</div>
			<!--/row-->

		</div>
		<!--/.span-->
	</div>
</div>
<!--/.span-->


<!-- Modal -->
<div id="editarcontraseña" class="modal hide fade" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">Cambiar Contraseña</h3>
	</div>
	<form class="form-horizontal" method="POST" action="<c:url value='cambiar_password.htm'/>" onSubmit="return validar()">
	<div class="modal-body">
		
			<div class="control-group">
				<label class="control-label" for="form-field-1">Contraseña
					Actual</label>

				<div class="controls">
					<input type="password" id="form-field-1" name="passwordActual" placeholder="Contraseña Actual" required>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="form-field-1">Nueva
					Contraseña</label>

				<div class="controls">
					<input type="password" id="nuevaPassword" name="nuevaPassword" placeholder="Nueva Contraseña" required>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="form-field-1">Confirmar
					Contraseña</label>

				<div class="controls">
					<input type="password" id="confPassword" placeholder="Confirmar Contraseña" required>
				</div>
			</div>
	</div>
	<div class="modal-footer">

		<input class="btn btn-primary"  type="submit" value="Aceptar">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
	</div>
	</form>
</div>


