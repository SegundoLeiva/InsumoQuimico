
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<!--[if !IE]>-->
<script src="../assets/js/jquery.min.js"></script>
<!--<![endif]-->

<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

<!--[if !IE]>-->
<script type="text/javascript">
	window.jQuery
			|| document.write("<script src='../assets/js/jquery-2.0.3.min.js'>"
					+ "<"+"/script>");
</script>
<!--<![endif]-->

<!--[if IE]>
<script type="text/javascript">
window.jQuery || document.write("<script src='../assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
	if ("ontouchend" in document)
		document
				.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"
						+ "<"+"/script>");
</script>
<script src="../assets/js/bootstrap.min.js"></script>

<!--[if lte IE 8]>
<script src="../assets/js/excanvas.min.js"></script>
<![endif]-->

<script src="../assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="../assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="../assets/js/jquery.slimscroll.min.js"></script>
<script src="../assets/js/validarCampos.js"></script>
<script src="../assets/js/menu.js"></script>

<!--ace scripts-->

<script src="../assets/js/ace-elements.min.js"></script>
<script src="../assets/js/ace.min.js"></script>

<script type="text/javascript">
	$(document).on("ready", function() {
		$('#Agregar').modal({
			show : true,
			keyboard : false,
		});
	});

	$(function() {
		//Para escribir solo letras
		$('#miCampo1').validCampoFranz(' abcdefghijklmnñopqrstuvwxyzáéiou');

		//Para escribir solo numeros    
		$('.numeros').validCampoFranz('0123456789');

	});
</script>

