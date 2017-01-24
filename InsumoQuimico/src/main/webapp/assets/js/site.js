var INDICADOR_NUEVO = '0';
var INDICADOR_CREADO = '1';
var INDICADOR_MODIFICADO = '2';
var INDICADOR_ELIMINADO = '3';
var tabla;
var filaIndexDetalle=0;
var claseColumna=[];
var arrayJsonDetalle=[];

$(document).on("ready", function() {
	alertify.set('notifier','position', 'top-right');
	$('.date-picker').datepicker({
	    format: 'dd/mm/yyyy'
	});
	
	$(".numeroEntero").attr("onkeypress","return fn_validaEntero(event)");
	$(".numeroDecimal").attr("onkeypress","return fn_validaSoloDecimal(event,this)");
	inicializarHeader();
	
	//SEGMENTO TABLA BUSCAR DEFAULT
	if($('.tablaSearch').length==1){
		$('.tablaSearch').DataTable({
		 	"bSort" : false,
			"columnDefs": [{ className: "center"}]
	 	});	
	}
	
});

function validarCamposRequeridos(idFormulario){
	if(!camposRequeridos(idFormulario)){
		return false;
	}
	return true;
}

function camposRequeridos(idFormulario){
	var rpta = true;
	var formInput = $("#"+idFormulario)[0];
	$.each( formInput, function(index, value ) {
		  if($(formInput[index]).prop("required")){
			  if($(this).val().trim()==""){
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
	}else if(respuesta=='eliminar'){
		alertify.success("Se elimin\u00f3 correctamente");
	}else if(respuesta=='guardar'){
		alertify.success("Se guard\u00f3 correctamente");
	}else if(respuesta=='modificar'){
		alertify.success("Se modific\u00f3 correctamente");
	}else{
		alertify.error(respuesta);
	}
}

function inicializarParametros(){
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
}

$(".checkSelectedAll").click(function(){
	 $(tabla+' input:checkbox').not(this).prop('checked', this.checked);
});

function eliminarDetalle(){
	var arrayCheckbox = $(tabla+' .checkDetalle:checked');
	var dimCheck = arrayCheckbox.length;
	var indexArray=0;
	if(dimCheck > 0) {
		alertify.confirm("Eliminar","\u00BFEstá seguro en eliminar los items seleccionados?",
				function(){
			//Eliminando la fila en vista
  		  		for(var i = 0;i<dimCheck;i++){	  
		        	var obtenerFila=$(arrayCheckbox[i]).closest("tr");
		        	if(arrayCheckbox[i].checked){		        		
		        		if(arrayJsonDetalle[indexArray].idDetalle==""){
		        			arrayCheckbox[i].closest("tr").remove();
		        			arrayJsonDetalle.splice(indexArray,1);		        			
		        		}else{
		        			arrayJsonDetalle[obtenerFila.index()].indicadorBD=INDICADOR_ELIMINADO;
		        			obtenerFila.addClass("hidden");
		        			indexArray++;
		        		}
		        		
		        	}	            
		        }	
  		  	    $(".checkSelectedAll").removeAttr("checked");
						  },
				function(){});
	}else{
		alertify.error("Seleccione un registro para eliminar");
	}
}

function inicializarStyleTablaDetalle(){
	 inicializarParametros();
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

function actualizarDetalleGrabar(index){
	for (var j = 0; j < arrayJsonDetalle.length; j++) {
		if(arrayJsonDetalle[j].indicadorBD==INDICADOR_ELIMINADO){
			arrayJsonDetalle.splice(j,1);
			$(tabla+" > tbody").find("tr.hidden").remove();
		}
	}

	for (var i = 0; i < arrayJsonDetalle.length; i++) {
		if(arrayJsonDetalle[i].idDetalle==""){
			arrayJsonDetalle[i].idDetalle=(index).toString();
			arrayJsonDetalle[i].indicadorBD=INDICADOR_CREADO;								
		}
	}
	return (parseInt(arrayJsonDetalle[arrayJsonDetalle.length-1].idDetalle)+1).toString();
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

function fn_validaSoloDecimal(evt, obj){
    
    var tecla = window.event ? evt.keyCode : evt.which;    
    if(tecla == 46){
        if(obj.value.split('.').length == 1){return true;}
    }
    if(tecla == 8 || tecla == 13  || tecla == 9  || tecla == 0){return true;}
    var patron = /[0-9]/;
    var teclaValue = String.fromCharCode(tecla);
    var dato = patron.test(teclaValue);
    return dato;
}

$("#abrirDetalleAgregar").click(function(){
	$("#btnEditarDetalle").hide();
	$("#btnAgregarDetalle").show();
	limpiarCampos("formModalDetalleForm");
	$("#divModalDetalleForm").modal("show");
});

function limpiarCampos(idFormulario){
	$("#"+idFormulario+" input").val("");
	
	var formSelect = $("#"+idFormulario+" select");
	$.each( formSelect, function(index, value ) {
		var id = $(formSelect[index]).attr("id");
		$("#"+id).val($("#"+id+" option:first").val()).trigger('change');
	});
}

function setearCampo(clase,data){
	arrayJsonDetalle[filaIndexDetalle][clase]=data;
	$("."+clase, $(tabla+' > tbody > tr:eq('+filaIndexDetalle+')')).html(data);
}

function cambiarIndicadorModificado(){
	 if(arrayJsonDetalle[filaIndexDetalle].indicadorBD==INDICADOR_CREADO){
		 arrayJsonDetalle[filaIndexDetalle].indicadorBD=INDICADOR_MODIFICADO; 
	 }	
}

function buscarConsulta(){
	var form = document.forms[0];
    form.idUnidadMinera.disabled=false;
    form.action="buscarConsulta.htm"
    form.submit();
    form.idUnidadMinera.disabled=true;
}

function exportarReporteTxt(){
	var form = document.forms[0];
    form.action="generarReporte.htm"
    form.submit();
}

function eliminarSearch(id) {
	$("#id").val(id);
	var form = document.forms[0];
	alertify.confirm("Eliminar","\u00BFSeguro que desea eliminar este registro?",
			function(){
				form.action="eliminar.htm"
				form.submit();
			 },
			function(){});
}

function inicializarHeader(){
	//SEGMENTO DEL TITULO CABACERA
	var titulo = $("#sidebar li.active").text();
	if($("#sidebar").find("li.active").length==1){
		$("#menuDescripcion").html(titulo);
		$(".tituloHeader").prepend(titulo);
	}else{
		$("#menuDescripcion").html("Bienvenido");
		$(".tituloHeader").prepend("Bienvenido");
	}
}

function guardarMantenimiento(){
	document.forms[0].action="grabar.htm";
	var form = document.forms[0];
	var idForm = form.id;
	var idModel = $("#"+idForm+" input[data-id]").data("id");

		alertify.confirm("Confirmar","\u00BFEsta seguro realizar esta operaci\u00f3n?",
				function(){
				    $.ajax({
				           type: "POST",
				           url: form.action,
				           data: $(form).serialize(),
	 			           async:false,
				           success: function(data)
				           {
				        	   var data = JSON.parse(data);
				        	   if(idModel==""){limpiarCampos(idForm);};
				        	   mensajeTransaccion(data.mensaje);

				           }
				    });
						  },
				function(){});

}

function bloquearCamposConsultar(){
	var form = document.forms[0];
	var idForm = form.id;
	$(".header").hide();
	$("#"+idForm+" input").attr("disabled","disabled");
	$("#"+idForm+" select").attr("disabled","disabled")
}

$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};