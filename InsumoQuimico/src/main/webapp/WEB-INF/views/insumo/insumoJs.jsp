<script type="text/javascript">

$("#guardar").click(function(){
	if(validarCamposRequeridos("formUnidadMineraInsumo")){
		alertify.confirm("Confirmar","¿Esta seguro realizar esta operación?",
				function(){
					var url = '${pageContext.request.contextPath}/insumo/agregarInsumo.htm';
				    $.ajax({
				           type: "POST",
				           url: url,
				           data: $("#formUnidadMineraInsumo").serialize(),
				           success: function(data)
				           {	
				        	   if($("#idUnidadMineraInsumo").val()==""){limpiarCampos("formUnidadMineraInsumo")};
				        	   mensajeTransaccion(data);
				           }
				    });
						  },
				function(){});
	}

});
	
</script>