<%@ include file="/WEB-INF/views/include.jsp"%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" --%>
<%-- 	prefix="security"%> --%>

<%-- <security:authorize access="isAuthenticated()"> --%>
<%-- 	<c:redirect url="/home/bienvenida.htm" /> --%>
<%-- </security:authorize> --%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>::Hochschild Mining:: Sistema Insumos Químicos</title>

<meta name="description" content="User login page" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--basic styles-->

<link href="<c:url value="/assets/css/bootstrap.min.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/assets/css/bootstrap-responsive.min.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/assets/css/font-awesome.min.css"/>"
	rel="stylesheet" />
<link rel="stylesheet" href="<c:url value="/assets/css/alertify/alertify.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/assets/css/alertify/themes/bootstrap.min.css"/>" />
<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!--page specific plugin styles-->

<!--fonts-->

<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

<!--ace styles-->

<link rel="stylesheet" href="<c:url value="/assets/css/ace.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/css/ace-responsive.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/css/ace-skins.min.css"/>" />

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!--inline styles related to this page-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body class="login-layout" style="background: #FFF;">
	<div class="main-container container-fluid">
		<div class="main-content">
			<div class="row-fluid">
				<div class="span12">
					<div class="login-container" style="margin-top: 50px">
						<div class="row-fluid">
							<div class="center">
								<span> <br />
								</span>

								<c:if test="${not empty mensajeError}">
									<div class="alert alert-error">
										No se pudo INICIAR SESSION. <br />
										${mensajeError}
									</div>

								</c:if>

								<c:if test="${param.expired != null}">
									<div class="alert alert-error">La Sesión se ha cerrado a
										la fuerza debido a varias sesiones en la misma cuenta (sólo se
										permite una sesión activa por usuario).</div>
								</c:if>

								<c:if test="${expiro != null}">
									<div class="alert alert-error">Tiempo de Sessión
										Terminado</div>
								</c:if>

							</div>

							<div class="space-6"></div>

							<div class="row-fluid">
								<div class="position-relative">
									<div id="login-box"
										class="login-box visible widget-box no-border">
										<div class="widget-body">
											<div class="widget-main center">
												<h4 class="header blue">
													<i class="ace-icon icon-beaker green"></i> Sistema Insumos Químicos
												</h4>

												<div class="space-6"></div>


												<fieldset>

													<form id="formularioLogin" action="login.htm" method="POST">
														<label> <span
															class="block input-icon input-icon-right"> <input
																type="text" name="idUsuario" id="idUsuario" class="span12" data-msg-required="Ingrese su código de usuario por favor."
																placeholder="Usuario" required onkeydown="if(event.keyCode == 13){fn_loguea();}"/> <i class="icon-user"></i>
														</span>
														</label> <label> <span
															class="block input-icon input-icon-right"> <input
																type="password" name="clave" id="clave" class="span12" data-msg-required="Ingrese su clave por favor."
																placeholder="Contraseña" required onkeydown="if(event.keyCode == 13){fn_loguea();}"/> <i class="icon-lock"></i>
														</span>
														</label>

														<div class="space"></div>
														<div class="clearfix">			
 															<input type="text" class="width-35 pull-right btn btn-small btn-primary"
 																value="Ingresar" onclick="fn_loguea();"/>
														</div>
														<div class="space-4"></div>
													</form>
												</fieldset>
											</div>
											<!--/widget-main-->
										</div>
										<!--/widget-body-->
									</div>
									<!--/login-box-->
								</div>
								<!--/position-relative-->
							</div>
						</div>
					</div>
					<!--/.span-->
				</div>
				<!--/.row-fluid-->
			</div>
		</div>
	</div>

	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/login.js"></script>
<script src="assets/js/alertify/alertify.min.js"></script>
<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="assets/js/site.js"></script>



</body>
</html>
