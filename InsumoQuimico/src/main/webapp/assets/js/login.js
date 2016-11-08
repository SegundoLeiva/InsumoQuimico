
function fn_loguea(){
	var form = document.getElementById("formularioLogin");
//	if(fn_validaForm()){
            form.submit();
//	}
}

function fn_limpiar(){
	var form = document.getElementById("formularioLogin");
	form.idUsuario.value = '';
	form.clave.value = '';
	form.idUsuario.focus();
}

function fn_validaForm(){
	var valida = true;
	var form = document.getElementById("formularioLogin");
	
	if(form.idUsuario.value == ''){
            alert('Ingrese su c\u00f3digo de usuario por favor.');
            //jAlert('Ingrese su código de usuario por favor.', 'Sistema de Gesti\u00F3n de Vacaciones');
            form.idUsuario.focus();
            valida = false;
	}else if(form.clave.value == ''){
            alert('Ingrese su clave por favor.');
            //jAlert('Ingrese su clave por favor.', 'Sistema de Gesti\u00F3n de Vacaciones');
            form.clave.focus();
            valida = false;
	}
	
	return valida;
}