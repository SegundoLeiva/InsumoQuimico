<%@ include file="/WEB-INF/views/include.jsp"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>::Hochschild Mining:: Sistema Insumos Químicos</title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Expires" content="0" /> 
		<meta http-equiv="Pragma" content="no-cache" />
		<link rel="shortcut icon" href="<c:url value="/assets/images/logo.jpg"/>" />

		<!-- ##########################  HEAD ######################  -->
		<tiles:insertAttribute name="css"/>
<%-- 		<tiles:insertAttribute name="css2"/> --%>
		<!-- ########################  END HEAD ######################  -->
		
</head>

<body>

	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
					
			<!-- ##########################  HEAD ######################  -->
			<tiles:insertAttribute name="sidebar"/>
			<!-- ########################  END HEAD ######################  -->
										
			</div>
		</div>
	</div>
	<div id="loading" class="loading hidden">
		<div class="sk-circle">
		  <div class="sk-circle1 sk-child"></div>
		  <div class="sk-circle2 sk-child"></div>
		  <div class="sk-circle3 sk-child"></div>
		  <div class="sk-circle4 sk-child"></div>
		  <div class="sk-circle5 sk-child"></div>
		  <div class="sk-circle6 sk-child"></div>
		  <div class="sk-circle7 sk-child"></div>
		  <div class="sk-circle8 sk-child"></div>
		  <div class="sk-circle9 sk-child"></div>
		  <div class="sk-circle10 sk-child"></div>
		  <div class="sk-circle11 sk-child"></div>
		  <div class="sk-circle12 sk-child"></div>
		</div>
<!-- 		<div style="color: #FFF;position: absolute;text-align: center;width: 100%;font-size: 16px;margin-top: -30px">cargando</div> -->
	</div>

	<div class="main-container container-fluid">
		<a class="menu-toggler" id="menu-toggler" href="#">
			<span class="menu-text"></span>
		</a>

		<!-- ##########################  MENU ######################  -->
		<tiles:insertAttribute name="menu"/>
		<!-- ########################  END MENU ######################  -->

		<div class="main-content">
			<div class="breadcrumbs" id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="active">
						<i class="icon-home home-icon"></i>
						<a href="../home/bienvenida.htm">Inicio</a>

						<span class="divider">
							<i class="icon-angle-right arrow-icon"></i>
						</span>
					</li>
					<li id="menuDescripcion"></li>
				</ul>
			</div>

			<div class="page-content">
				<tiles:insertAttribute name="header"/>
				<!-- ##########################  CONTENIDO ######################  -->
				<tiles:insertAttribute name="contenido"/>
				<!-- ########################  END CONTENIDO ######################  -->
					
			</div><!--/.page-content-->

		</div><!--/.main-content-->
	</div><!--/.main-container-->

	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-small btn-inverse">
		<i class="icon-double-angle-up icon-only bigger-110"></i>
	</a>

	<!-- ############################### SCRIPT  ################################ -->
	<tiles:insertAttribute name="js"/>
	<tiles:insertAttribute name="js2"/>
	<!-- ############################# END SCRIPT ############################### -->

</body>
<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<script type="text/javascript">
$(document).ready(function() {

	//SEGMENTO MENSAJES
	<c:if test="${flagTransaccion=='eliminar'}">
		alertify.success("Se eliminó correctamente");
	</c:if>
	<c:if test="${flagTransaccion=='error'}">
		alertify.error("Se produjo un error");
	</c:if>
	<c:if test="${flagTransaccion=='apertura'}">
		alertify.success("Se cambió la Apertura correctamente");
	</c:if>
});
</script>
</html>