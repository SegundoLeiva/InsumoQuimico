<script type="text/javascript">

$("#guardar").click(function(){
	if(validarCamposRequeridos("formUnidadMineraArea")){
		alertify.confirm("Confirmar","¿Esta seguro realizar esta operación?",
				function(){
					var url = '${pageContext.request.contextPath}/unidadMineraArea/agregarUnidadMineraArea.htm';
				    $.ajax({
				           type: "POST",
				           url: url,
				           data: $("#formUnidadMineraArea").serialize(),
				           success: function(data)
				           {	
				        	   if($("#idUnidadMineraArea").val()==""){limpiarCampos("formUnidadMineraArea");};
				        	   mensajeTransaccion(data);
				           }
				    });
						  },
				function(){});
	}

});
	
</script>