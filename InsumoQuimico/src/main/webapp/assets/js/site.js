var INDICADOR_NUEVO = '0';
var INDICADOR_CREADO = '1';
var INDICADOR_MODIFICADO = '2';
var INDICADOR_ELIMINADO = '3';

$(document).on("ready", function() {
	alertify.set('notifier','position', 'top-right');
	$(".date-picker").datepicker();
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
	var formInput = $("#"+idFormulario+" input");
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

function mensajeTransaccion(respuesta){
	if(respuesta=='error'){
		alertify.error("Se produjo un error");
	}
	if(respuesta=='eliminar'){
		alertify.success("Se elimin\u00f3 correctamente");
	}
	if(respuesta=='guardar'){
		alertify.success("Se guard\u00f3 correctamente");
	}
	if(respuesta=='modificar'){
		alertify.success("Se modific\u00f3 correctamente");
	}
}