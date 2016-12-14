<script type="text/javascript">

$("#guardar").click(function(){
	if(validarCamposRequeridos("formInsumo")){
		alertify.confirm("Confirmar","¿Esta seguro realizar esta operación?",
				function(){
					var url = '${pageContext.request.contextPath}/insumo/agregarInsumo.htm';
				    $.ajax({
				           type: "POST",
				           url: url,
				           data: $("#formInsumo").serialize(),
				           success: function(data)
				           {	
				        	   if($("#idInsumo").val()==""){limpiarCampos("formInsumo");};
				        	   mensajeTransaccion(data);
				           }
				    });
						  },
				function(){});
	}

});
	
</script>