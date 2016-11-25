var INDICADOR_NUEVO = '0';
var INDICADOR_CREADO = '1';
var INDICADOR_MODIFICADO = '2';
var INDICADOR_ELIMINADO = '3';
var tabla;
var claseColumna=[];

$(document).on("ready", function() {
	alertify.set('notifier','position', 'top-right');
	$('.date-picker').datepicker({
	    format: 'dd/mm/yyyy'
	});
	$(".numeroEntero").attr("onkeypress","return fn_validaEntero(event)");
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

function inicializarParametros(data){
	tabla = data.tabla;
	$(tabla).DataTable({
	 	"bSort" : false,
		"bFilter": false, 
		"bLengthChange": false,
		"bInfo": false,
		"bPaginate": false,
		"columnDefs": [
		                { className: "center"}
		              ]
	});
	claseColumna=data.claseColumna;
}

$(".checkSelectedAll").click(function(){
	 $(tabla+' input:checkbox').not(this).prop('checked', this.checked);
});

function eliminarDetalle(arrayJson){
	var arrayCheckbox = $(tabla+' .checkDetalle:checked');
	var dimCheck = arrayCheckbox.length;
	var indexArray=0;
	if(dimCheck > 0) {
		alertify.confirm("Eliminar","¿Está seguro en eliminar los items seleccionados?",
				function(){
			//Eliminando la fila en vista
  		  		for(var i = 0;i<dimCheck;i++){	  
		        	var obtenerFila=$(arrayCheckbox[i]).closest("tr");
		        	if(arrayCheckbox[i].checked){		        		
		        		if(arrayJson[indexArray].idDetalle==""){
		        			arrayCheckbox[i].closest("tr").remove();
		        			arrayJson.splice(indexArray,1);		        			
		        		}else{
		        			arrayJson[obtenerFila.index()].indicadorBD=INDICADOR_ELIMINADO;
		        			obtenerFila.addClass("hidden");
		        			indexArray++;
		        		}
		        		
		        	}	            
		        }	
  		  	    $(".checkSelectedAll").removeAttr("checked");
						  },
				function(){});
	}else{
		alertify.alert("Alerta","Seleccione un registro para eliminar");
	}
}

function inicializarStyleTablaDetalle(){
	 $(tabla+"_wrapper").removeClass("dataTables_wrapper");
	 $(tabla+"_wrapper div.row-fluid").remove();
	 $(tabla+" tbody").find("tr.odd").remove();
}

function agregarFila(data){
	var text = "<tr>"+
	  "<td class='center'><label><input type='checkbox' class='checkDetalle'><span class='lbl'></span></label></td>";
	for (var i = 0; i < data.length; i++) {
		text+="<td class='center "+claseColumna[i]+"'>"+data[i]+"</td>";
	}
	$(tabla+' tBody').append(text);
}

function actualizarDetalleGrabar(arrayJson,index){
	for (var j = 0; j < arrayJson.length; j++) {
		if(arrayJson[j].indicadorBD==INDICADOR_ELIMINADO){
			arrayJson.splice(j,1);
			$(tabla+" > tbody").find("tr.hidden").remove();
		}
	}

	for (var i = 0; i < arrayJson.length; i++) {
		if(arrayJson[i].idDetalle==""){
			arrayJson[i].idDetalle=(index).toString();
			arrayJson[i].indicadorBD=INDICADOR_CREADO;								
		}
	}
	return (parseInt(mercaderiaJSONArray[mercaderiaJSONArray.length-1].idDetalle)+1).toString();
}

function showLoading(){
	$("#loading").removeClass("hidden");
}

function hideLoading(){
	$("#loading").addClass("hidden");
}

function fn_validaEntero(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla==8 || tecla==0) return true; //Tecla de retroceso (para poder borrar)
    patron = /[0-9]/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}
