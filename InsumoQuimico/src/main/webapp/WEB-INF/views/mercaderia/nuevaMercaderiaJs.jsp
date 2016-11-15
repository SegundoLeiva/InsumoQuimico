<script src="../assets/js/jquery.dataTables.1.3.1.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var mercaderiaJSONArray = [];
var filaIndex = 0;
var index = 1;

$(document).ready(function() {
	var data = {
			tabla:"#tablaMercaderiaDetalle",
			claseColumna:["idInsumo","descripcion","cantidad","unidadMedida"]
			};
	
	inicializarParametros(data);
	inicializarStyleTablaDetalle();
	
	if($("#flagEditar").val()=="editar"){
//		$(loading).show();
		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath}/ingresarMercaderia/listaMercaderiaDetalle.htm',
			data: {'idMercaderia': $("#idMercaderia").val()},
			
			success : function(data) {	
				var jsonData = JSON.parse(data);
				for (var i = 0; i < jsonData.length; i++) {
							
					 var data = [jsonData[i].unidadMineraInsumo.idUnidadMineraInsumo,
					             jsonData[i].unidadMineraInsumo.insumo.insumo,
					             jsonData[i].cantidad,"Kg"];
					 agregarDetalle(data); 
					 mercaderiaJSONArray[i].idDetalle=(jsonData[i].id.idMercaderiaDetalle).toString();
					 mercaderiaJSONArray[i].idUnidadMineraInsumo=jsonData[i].unidadMineraInsumo.idUnidadMineraInsumo;
					 mercaderiaJSONArray[i].cantidad=jsonData[i].cantidad;
					 mercaderiaJSONArray[i].unidadMedida="Kg";
					 mercaderiaJSONArray[i].indicadorBD=INDICADOR_CREADO;
				}		
				
				index = (jsonData[jsonData.length-1].id.idMercaderiaDetalle+1).toString();

			}
		});
	}

} );

$("#abrirDetalleAgregar").click(function(){
	$("#btnEditarDetalle").hide();
	$("#btnAgregarDetalle").show();
	$("#cantidad").val("");
	$("#idInsumo").val($("#idInsumo option:first").val());
	$("#modalDetalleForm").modal("show");
});

$("#btnAgregarDetalle").click(function(){
	 if(validarCamposRequeridos("modalDetalleForm") && validarInsumoAgregar()){			 	
 		 	var data = [$("#idInsumo").val(),$("#idInsumo option:selected").text(),
 		 	         	 $("#cantidad").val(),"Kg"];
 		 	agregarDetalle(data);
 		 	var fila = mercaderiaJSONArray.length-1;
 		 	mercaderiaJSONArray[fila].idUnidadMineraInsumo=$("#idInsumo").val();
			mercaderiaJSONArray[fila].cantidad=$("#cantidad").val();
		 	$("#modalDetalleForm").modal("hide");
	 }
	
});

function agregarDetalle(data){
	agregarJsonDetalle();	
	agregarFila(data);
}

$("#btnEditarDetalle").click(function(){
	 if(validarCamposRequeridos("modalDetalleForm") && validarInsumoEditar()){	
		 setearCampo("idInsumo",$("#idInsumo").val());
		 setearCampo("descripcion",$("#idInsumo option:selected").text());
		 setearCampo("cantidad",$("#cantidad").val());
		 mercaderiaJSONArray[filaIndex].indicadorBD=INDICADOR_MODIFICADO;
		 $("#modalDetalleForm").modal("hide");
	 }
	
});

$("#abrirDetalleEditar").click(function(){
	$("#btnAgregarDetalle").hide();
	$("#btnEditarDetalle").show();
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
		$("#modalDetalleForm").modal("show");
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
function agregarJsonDetalle(){
	 var mercaderiaJSON = {
			    idDetalle:'',idUnidadMineraInsumo:'',cantidad:'',
			    unidadMedida:'Kg',indicadorBD: INDICADOR_NUEVO};
	 mercaderiaJSONArray.push(mercaderiaJSON);
}

$("#eliminarDetalle").click(function(){
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
						index = actualizarDetalleGrabar(mercaderiaJSONArray,index);						
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