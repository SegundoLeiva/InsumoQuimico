<script type="text/javascript">


$(document).ready(function() {

} );

function cambiarApertura(mes){
	alertify.confirm("Alerta","¿Está seguro cambiar la Apertura?",
			function(){
			var form = document.forms[0];
			$("#mes").val(mes);	
		    form.action="cambiarApertura.htm"
		    form.submit();
					  },
			function(){});
}

</script>