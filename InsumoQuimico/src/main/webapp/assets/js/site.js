$(document).on("ready", function() {
		alertify.set('notifier','position', 'top-right');
});
function validarCamposRequeridos(idFormulario){
		var rpta = true;
		var form = $("#"+idFormulario+" input[type=text]");
		$.each( form, function(index, value ) {
			  if($(form[index]).prop("required")){
				  if($(this).val()==""){
					 alertify.alert("Alerta",($(this).data("msg-required")));
					 rpta = false;
					  }
				}
		});
		return rpta;
}