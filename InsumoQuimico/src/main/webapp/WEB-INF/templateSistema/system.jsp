<%@ include file="/WEB-INF/views/include.jsp"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>Sistema Inventario</title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Expires" content="0" /> 
		<meta http-equiv="Pragma" content="no-cache" />
		

		<!-- ##########################  HEAD ######################  -->
		<tiles:insertAttribute name="css"/>
		<tiles:insertAttribute name="css2"/>
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
						<a href="#">Inicio</a>

						<span class="divider">
							<i class="icon-angle-right arrow-icon"></i>
						</span>
					</li>
					<li >Bienvenida</li>
				</ul>

				<div class="nav-search" id="nav-search">
					<form class="form-search">
						<span class="input-icon">
							<input type="text" placeholder="Buscar ..." class="input-small nav-search-input" id="nav-search-input" autocomplete="off" />
							<i class="icon-search nav-search-icon"></i>
						</span>
					</form>
				</div>
			</div>

			<div class="page-content">
<!-- 				<div class="page-header position-relative"> -->
<!-- 					<h1> -->
<!-- 						Bienvenida <small><i class="icon-double-angle-right"></i> Bienvenida</small> -->
<!-- 					</h1> -->
<!-- 				</div>/.page-header -->

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
</html>
