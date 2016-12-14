<script type="text/javascript">

$("#guardar").click(function(){
	if(validarCamposRequeridos("formArea")){
		alertify.confirm("Confirmar","¿Esta seguro realizar esta operación?",
				function(){
					var url = '${pageContext.request.contextPath}/area/agregarArea.htm';
				    $.ajax({
				           type: "POST",
				           url: url,
				           data: $("#formArea").serialize(),
				           success: function(data)
				           {	
				        	   if($("#idArea").val()==""){limpiarCampos("formArea");};
				        	   mensajeTransaccion(data);
				           }
				    });
						  },
				function(){});
	}

});
	
</script>