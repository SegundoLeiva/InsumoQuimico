$(document).on("ready", function() {
		alertify.set('notifier','position', 'top-right');
});
function validarCamposRequeridos(idFormulario){
	if(!inputRequeridos(idFormulario)){
		return false;
	}
	if(!selectRequeridos(idFormulario)){
		return false;
	}
	return true;
}

function inputRequeridos(idFormulario){
	var rpta = true;
	var formInput = $("#"+idFormulario+" input[type=text]");
	$.each( formInput, function(index, value ) {
		  if($(formInput[index]).prop("required")){
			  if($(this).val()==""){
				 alertify.error($(this).data("msg-required"));
				 rpta = false;
				 return false;
				  }
			}
	});
	return rpta;
}

function selectRequeridos(idFormulario){
	var rpta = true;
	var formSelect = $("#"+idFormulario+" select");
	$.each( formSelect, function(index, value ) {
		  if($(formSelect[index]).prop("required")){
			  if($(this).val()==""){
				 alertify.error($(this).data("msg-required"));
				 rpta = false;	
				 return false;
				  }
			}
	});
	return rpta;
}