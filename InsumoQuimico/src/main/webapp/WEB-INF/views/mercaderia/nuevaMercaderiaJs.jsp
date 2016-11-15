<script src="../assets/js/jquery.dataTables.1.3.1.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var mercaderiaJSONArray = [];
var filaIndex = 0;
var index = 1;

$(document).ready(function() {
	var data = {
			tabla:"#tablaMercaderiaDetalle"
			};
	
	inicializarParametros(data);
	inicializarStyleTablaDetalle();
	
	if($("#flagEditar").val()=="flagEditar"){
//		$(loading).show();


		$.ajax({
			type : 'post',
			data: {'idMercaderia': $("#idMercaderia").val()},
			url : '${pageContext.request.contextPath}/ingresarMercaderia/listaMercaderiaDetalle.htm',
			success : function(data) {	
				var jsonData = JSON.parse(data);
				for (var i = 0; i < jsonData.length; i++) {
					agregarJsonMercaderiaDetalle();	
					var agregarFila = "<tr>"+
						  "<td class='center'><label><input type='checkbox' class='checkDetalle'><span class='lbl'></span></label></td>"+
						  "<td class='center idInsumo'>"+jsonData[i].unidadMineraInsumo.idUnidadMineraInsumo+"</td>"+
						  "<td class='center descripcion'>"+jsonData[i].unidadMineraInsumo.insumo.insumo+"</td>"+
						  "<td class='center cantidad'>"+jsonData[i].cantidad+"</td>"+
						  "<td class='center'>Kg</td>"+
						  "</tr>";
					 $('#tablaMercaderiaDetalle tBody').append(agregarFila);
					 mercaderiaJSONArray[i].idDetalle=(jsonData[i].id.idMercaderiaDetalle).toString();
					 mercaderiaJSONArray[i].indicadorBD=INDICADOR_CREADO;
					
				}		
				
				index = (jsonData[jsonData.length-1].id.idSolicitudPedidoDetalle+1).toString();

			}
		});
	}

} );

$("#abrirDetalleMercaderia").click(function(){
	$("#editarMercaderiaDetalle").hide();
	$("#agregarMercaderiaDetalle").show();
	$("#cantidad").val("");
	$("#idInsumo").val($("#idInsumo option:first").val());
	$("#modalDetalleMercaderia").modal("show");
});

$("#agregarMercaderiaDetalle").click(function(){
	 if(validarCamposRequeridos("modalDetalleMercaderia") && validarInsumoAgregar()){	
 		 	agregarJsonMercaderiaDetalle();	
			var agregarFila = "<tr>"+
				  "<td class='center'><label><input type='checkbox' class='checkDetalle'><span class='lbl'></span></label></td>"+
				  "<td class='center idInsumo'>"+$("#idInsumo").val()+"</td>"+
				  "<td class='center descripcion'>"+$("#idInsumo option:selected").text()+"</td>"+
				  "<td class='center cantidad'>"+$("#cantidad").val()+"</td>"+
				  "<td class='center'>Kg</td>"+
				  "</tr>";

			$('#tablaMercaderiaDetalle tBody').append(agregarFila);
		 	$("#modalDetalleMercaderia").modal("hide");
	 }
	
});

$("#editarMercaderiaDetalle").click(function(){
	 if(validarCamposRequeridos("modalDetalleMercaderia") && validarInsumoEditar()){	
		 setearCampo("idInsumo",$("#idInsumo").val());
		 setearCampo("descripcion",$("#idInsumo option:selected").text());
		 setearCampo("cantidad",$("#cantidad").val());
		 mercaderiaJSONArray[filaIndex].indicadorBD=INDICADOR_MODIFICADO;
		 $("#modalDetalleMercaderia").modal("hide");
	 }
	
});

$("#abrirDetalleEditar").click(function(){
	$("#agregarMercaderiaDetalle").hide();
	$("#editarMercaderiaDetalle").show();
	var checkDetalle = $('#tablaMercaderiaDetalle> tbody .checkDetalle:checked');
	if(checkDetalle.length==1){
		var idInsumo = checkDetalle.closest("tr").find("td.idInsumo").text();
		for (var i = 0; i < mercaderiaJSONArray.length; i++) {
			var idUnidadMineraInsumo = mercaderiaJSONArray[i].idUnidadMineraInsumo;
			if(idUnidadMineraInsumo==idInsumo){
				$("#idInsumo").val(idInsumo);
				$("#cantidad").val(mercaderiaJSONArray[i].cantidad);
				filaIndex = i;
			}
		}
		$("#modalDetalleMercaderia").modal("show");
	}else{
		alertify.error("Seleccione un Item.");
	}	
});

function validarInsumoAgregar(){
	var rpta=true;
	for (var i = 0; i < mercaderiaJSONArray.length; i++) {
		var idUnidadMineraInsumo = mercaderiaJSONArray[i].idUnidadMineraInsumo;
		if(idUnidadMineraInsumo==$("#idInsumo").val()){
			alertify.error("Ya existe un insumo.");
			rpta=false;
		}
	}
	return rpta;
}
function validarInsumoEditar(){
	var rpta=true;
	for (var i = 0; i < mercaderiaJSONArray.length; i++) {
		var idUnidadMineraInsumo = mercaderiaJSONArray[i].idUnidadMineraInsumo;
		if(i!=filaIndex){
			if(idUnidadMineraInsumo==$("#idInsumo").val()){
				alertify.error("Ya existe un insumo.");
				rpta=false;
			}
		}

	}
	return rpta;
}
function agregarJsonMercaderiaDetalle(){
	 var mercaderiaJSON = {
			    idDetalle:'',
			    idUnidadMineraInsumo: $("#idInsumo").val(),
			    cantidad:$("#cantidad").val(),
			    unidadMedida:'Kg',
			    indicadorBD: INDICADOR_NUEVO};
	 mercaderiaJSONArray.push(mercaderiaJSON);
}

$("#eliminarMercaderiaDetalle").click(function(){
	eliminarDetalle(mercaderiaJSONArray);
});

function setearCampo(clase,data){
	if(clase=="idInsumo"){
		mercaderiaJSONArray[filaIndex].idInsumo=data;
	}else if(clase=="cantidad"){
		mercaderiaJSONArray[filaIndex].cantidad=data;
	}
	$("."+clase, $('#tablaMercaderiaDetalle> tbody > tr:eq('+filaIndex+')')).html(data);
}

$("#guardarMercaderia").click(function(){
	if(fnValidarGuardarMercaderia()){
		alertify.confirm("Guardar","¿Usted está seguro de guardar los registros?",
				function(){
			$.ajax({
				type : 'post',
				data: {
					idMercaderia:$("#idMercaderia").val(),
					idUnidadMinera:$("#idUnidadMinera").val(),
					idUnidadMineraAlmacen:$("#idUnidadMineraAlmacen").val(),
					transporte:$("#transporte").val(),
					guiaRemision:$("#guiaRemision").val(),
					comprobanteVenta:$("#comprobanteVenta").val(),
					guiaInterna:$("#guiaInterna").val(),
					index:index,
	 				mercaderiaJSONArray: JSON.stringify(mercaderiaJSONArray)
					
				},
				url : '${pageContext.request.contextPath}/ingresarMercaderia/guardarMercaderia.htm',
				success : function(data) {
					if(data!=""){					
						for (var j = 0; j < mercaderiaJSONArray.length; j++) {
							if(mercaderiaJSONArray[j].indicadorBD==INDICADOR_ELIMINADO){
								mercaderiaJSONArray.splice(j,1);
								$("#tablaMercaderiaDetalle > tbody").find("tr.hidden").remove();
							}
						}
	
						for (var i = 0; i < mercaderiaJSONArray.length; i++) {
							if(mercaderiaJSONArray[i].idDetalle==""){
								mercaderiaJSONArray[i].idDetalle=(index).toString();
								mercaderiaJSONArray[i].indicadorBD=INDICADOR_CREADO;								
								index++;
							}
						}
						index = (parseInt(mercaderiaJSONArray[mercaderiaJSONArray.length-1].idDetalle)+1).toString();
						$("#idMercaderia").val(data);
	
						mensajeTransaccion("guardar");					
						
					}else{
						mensajeTransaccion("error");
					}
					
				}
			});
						  },
				function(){});
	}
});

function fnValidarGuardarMercaderia(){
	if(mercaderiaJSONArray.length==0){
		alertify.error("Mínimo debe registrar un detalle");
		return false;
	}
	
	return true;
}
</script>