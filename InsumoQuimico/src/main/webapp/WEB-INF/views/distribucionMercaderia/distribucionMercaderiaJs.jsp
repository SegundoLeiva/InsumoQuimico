<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
$(document).ready(function() {
	
	var dataPresentacion=[{id:" ",text:"Seleccionar"}];
	$("#idPresentacionInsumo").select2({
		  data: dataPresentacion
	});
});
$("#idUnidadMineraInsumo").change(function(){
	$('#idPresentacionInsumo').empty();
	var objArray = [{id:" ",text:"Seleccionar"}];
	if($(this).val().trim()!=""){
		var insumo = $(this).val().split("-")[1];
		$.ajax({
			type : 'post',
			data: {'idInsumo': insumo},
			url : '${pageContext.request.contextPath}/ajax/listaPresentacionInsumoPorInsumo.htm',
			async:false,
			success : function(data) {	
				var listaPresentacionInsumo = JSON.parse(data);
				for (var i = 0; i < listaPresentacionInsumo.length; i++) {
					objArray.push({id:listaPresentacionInsumo[i].idPresentacionInsumo,
						text:listaPresentacionInsumo[i].descripcion});
				}
			}
		});
	}
	$("#idPresentacionInsumo").select2({
		  data: objArray
	});
	
	if($("#idPresentacionInsumo").val().trim()==""){
		$("#stock").val("");
	}
});

$("#idPresentacionInsumo").change(function(){
	var valor = $(this).val().trim();
	if(valor!=""){
		$("#stock").val(obtienerStockAlmacen(valor));
	}else{
		$("#stock").val("");
	}
});

function obtienerStockAlmacen(idPresentacionInsumo){
	var resultado = 0;
			$.ajax({
				type : 'post',
				data: {'idUnidadMineraInsumo': $("#idUnidadMineraInsumo").val(),
					   'idPresentacionInsumo': idPresentacionInsumo
					  },
				url : '${pageContext.request.contextPath}/ajax/obtienerStockAlmacen.htm',
				async:false,
				success : function(data) {	
					resultado=data;
					
				}
			});
	return resultado;
}

$("#guardar").click(function(){
	var cantidad = parseFloat($("#cantidad").val());
	if(fnValidarGuardarMercaderia()){
		guardarMantenimiento();
	}

});

function fnValidarGuardarMercaderia(){
	var cantidad = parseFloat($("#cantidad").val());
	var stock = parseFloat($("#stock").val());
	if(!validarCamposRequeridos("formDistribucionMercaderia")){
		return false;
	}else if(cantidad==0){
		alertify.error("El campo Cantidad debe ser mayor a 0");
		return false;
	}else if(cantidad > stock){
		alertify.error("No se encuentra dentro del rango de stock del insumo.");
		return false;
	}else{
		return true;
	}
}

</script>