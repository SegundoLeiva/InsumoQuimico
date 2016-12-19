<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var mercaderiaJSONArray = arrayJsonDetalle;
var index = 1;
var listaPresentacionInsumo;
var listaFactorConversionMedida=[];

$(document).ready(function() {
	tabla="#tablaMercaderiaDetalle";
	claseColumna=["idUnidadMineraInsumo","descripcion","descripcionPresentacion","cantidad","unidadMedida"];
	inicializarStyleTablaDetalle();
	
	//Lista de Factor Conversion
	<c:forEach var="item" items="${listaFactorConversionMedida}">		
		var obj = {idUnidadMedidaDe:"${item.id.idUnidadMedidaDe}",
				factorConversion:"${item.factorConversion}"}
		listaFactorConversionMedida.push(obj);
	</c:forEach>
	
	if($("#flagEditar").val()=="editar"){	
		var i=0;
		<c:forEach var="jbean" items="${listaMercaderiaDetalle}">		
		 	var data = ["${jbean.unidadMineraInsumo.idUnidadMineraInsumo}",
		             	"${jbean.unidadMineraInsumo.insumo.insumo}",
		             	"${jbean.presentacionInsumo.descripcion}",
		             	"${jbean.cantidad}","${jbean.unidadMedida}"];
			agregarDetalle(data); 
			mercaderiaJSONArray[i].idDetalle="${jbean.id.idMercaderiaDetalle}";
			mercaderiaJSONArray[i].idUnidadMineraInsumo="${jbean.unidadMineraInsumo.idUnidadMineraInsumo}";
			mercaderiaJSONArray[i].cantidad="${jbean.cantidad}";
			mercaderiaJSONArray[i].idPresentacion="${jbean.presentacionInsumo.idPresentacion}";
			mercaderiaJSONArray[i].descripcionPresentacion="${jbean.presentacionInsumo.descripcion}";
			mercaderiaJSONArray[i].unidadMedida="${jbean.unidadMedida}";
			mercaderiaJSONArray[i].indicadorBD=INDICADOR_CREADO;
			i++;
		</c:forEach>
		index = "${listaMercaderiaDetalle.get(listaMercaderiaDetalle.size()-1).id.idMercaderiaDetalle+1}";
	}
	
	var dataInsumo=[{id:" ",text:"Seleccionar"}];
	<c:forEach var="item" items="${listaUnidadMineraInsumo}">
		var obj = {id:"${item.idUnidadMineraInsumo}",text:"${item.insumo.insumo}"}
		dataInsumo.push(obj);
	</c:forEach>

	$("#idUnidadMineraInsumo").select2({
		  data: dataInsumo
	});


} );

$("#btnAgregarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarInsumo("")){			 	
 		 	var data = [$("#idUnidadMineraInsumo").val(),$("#idUnidadMineraInsumo option:selected").text(),
 		 	            $("#idPresentacion option:selected").text(),$("#cantidad").val(),$("#unidadMedida").val()];
 		 	agregarDetalle(data);
 		 	var fila = mercaderiaJSONArray.length-1;
 		 	mercaderiaJSONArray[fila].idUnidadMineraInsumo=$("#idUnidadMineraInsumo").val();
			mercaderiaJSONArray[fila].cantidad=$("#cantidad").val();
			mercaderiaJSONArray[fila].idPresentacion=$("#idPresentacion").val();
			mercaderiaJSONArray[fila].descripcionPresentacion=$("#idPresentacion option:selected").text();
			mercaderiaJSONArray[fila].unidadMedida=$("#unidadMedida").val();
			mercaderiaJSONArray[fila].factorConversion=$("#factorConversion").val();
		 	$("#divModalDetalleForm").modal("hide");
	 }
	
});

function agregarDetalle(data){
	var mercaderiaJSON = {
		    idDetalle:'',idUnidadMineraInsumo:'',cantidad:'',idPresentacion:'',descripcionPresentacion:'',
		    descripcion:'',unidadMedida:'',factorConversion:'',indicadorBD: INDICADOR_NUEVO};
	mercaderiaJSONArray.push(mercaderiaJSON);
	agregarFila(data);
}

$("#btnEditarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarInsumo("editar")){	
		 setearCampo("idUnidadMineraInsumo",$("#idUnidadMineraInsumo").val());
		 setearCampo("descripcion",$("#idUnidadMineraInsumo option:selected").text());
		 setearCampo("cantidad",$("#cantidad").val());
		 setearCampo("descripcionPresentacion",$("#idPresentacion option:selected").text());
		 setearCampo("unidadMedida",$("#unidadMedida").val());
		 cambiarIndicadorModificado();	 
		 mercaderiaJSONArray[filaIndexDetalle].idPresentacion=$("#idPresentacion").val();
		 mercaderiaJSONArray[filaIndexDetalle].factorConversion=$("#factorConversion").val();
		 $("#divModalDetalleForm").modal("hide");
	 }
	
});

$("#abrirDetalleEditar").click(function(){
	$("#btnAgregarDetalle").hide();
	$("#btnEditarDetalle").show();
	var checkDetalle = $('#tablaMercaderiaDetalle> tbody .checkDetalle:checked');
	if(checkDetalle.length==1){
		var index = checkDetalle.closest("tr").index();
		var idUnidadMineraInsumoDetalle = checkDetalle.closest("tr").find("td.idUnidadMineraInsumo").text();

		$("#idUnidadMineraInsumo").val(mercaderiaJSONArray[index].idUnidadMineraInsumo).trigger('change');
		$("#idPresentacion").val(mercaderiaJSONArray[index].idPresentacion).trigger('change');
		$("#cantidad").val(mercaderiaJSONArray[index].cantidad);
		filaIndexDetalle = index;

		$("#divModalDetalleForm").modal("show");
	}else{
		alertify.error("Seleccione un Item.");
	}	
});

function validarInsumo(flag){
	var rpta=true;
	var cantidad = parseFloat($("#cantidad").val());
	var idUnidadMineraInsumo = $("#idUnidadMineraInsumo").val();
	var idPresentacion = $("#idPresentacion").val();
	var idUnidadMineraAlmacen = $("#idUnidadMineraAlmacen").val();
	var indexEditar = 0;

	for (var i = 0; i < mercaderiaJSONArray.length; i++) {
		var _idUnidadMineraInsumo = mercaderiaJSONArray[i].idUnidadMineraInsumo;
		var _idPresentacion = mercaderiaJSONArray[i].idPresentacion;
		if(flag!="editar"){
			if(_idUnidadMineraInsumo==idUnidadMineraInsumo && _idPresentacion==idPresentacion){
				alertify.error("Ya existe un insumo con la misma presentación.");
				rpta=false;
			}
		}else{
			if(i!=filaIndexDetalle){
				if(_idUnidadMineraInsumo==idUnidadMineraInsumo && _idPresentacion==idPresentacion){
					alertify.error("Ya existe un insumo con la misma presentación.");
					rpta=false;
				}
			}
		}
		
	}
	
	if(cantidad==0){
		alertify.error("La cantidad debe ser mayor a 0.");
		rpta=false;
	}

	return rpta;
}

$("#eliminarDetalle").click(function(){
	eliminarDetalle();
});

$("#guardar").click(function(){
	if(fnValidarGuardarMercaderia()){
		alertify.confirm("Guardar","¿Usted está seguro de guardar los registros?",
				function(){
			showLoading();
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
					rucProveedor:$("#rucProveedor").val(),
					descripcionProveedor:$("#descripcionProveedor").val(),
					index:index,
	 				mercaderiaJSONArray: JSON.stringify(mercaderiaJSONArray)
					
				},
				url : '${pageContext.request.contextPath}/ingresarMercaderia/guardarMercaderia.htm',
				success : function(data) {
					hideLoading();
					if(data!=""){	
						index = actualizarDetalleGrabar(index);						
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
	if(!validarCamposRequeridos("formMercaderia")){
		return false;
	}else if(mercaderiaJSONArray.length==0){
		alertify.error("Mínimo debe registrar un detalle");
		return false;
	}else{
		return true;
	}
}

function getProveedorDescripcion(){
	var rucProveedor = $("#rucProveedor").val();
	if(rucProveedor!=""){	
		showLoading();
			$.ajax({
				type : 'post',
				data: {'rucProveedor': rucProveedor},
				url : '${pageContext.request.contextPath}/ajax/getProveedorDescripcion.htm',
				success : function(data) {	
					hideLoading();
					if(data==""){
						alertify.error("No existe proveedor.");
						$("#rucProveedor").val("");
						$("#spanDescripcionProveedor").html("");
					}else{
						$("#descripcionProveedor").val(data);
						$("#spanDescripcionProveedor").html(data);
					}
					
				}
			});
	}else{
		$("#rucProveedor").val("");
		$("#spanDescripcionProveedor").html("");
	}
		
}

$("#idUnidadMineraInsumo").change(function(){
	$('#idPresentacion').empty();
	var objArray = [{id:" ",text:"Seleccionar"}];
	if($(this).val().trim()!=""){
		var insumo = $(this).val().split("-")[1];
		$.ajax({
			type : 'post',
			data: {'idInsumo': insumo},
			url : '${pageContext.request.contextPath}/ajax/listaPresentacionInsumoPorInsumo.htm',
			async:false,
			success : function(data) {	
				listaPresentacionInsumo = JSON.parse(data);
				for (var i = 0; i < listaPresentacionInsumo.length; i++) {
					objArray.push({id:listaPresentacionInsumo[i].idPresentacion,
						text:listaPresentacionInsumo[i].descripcion});
				}
			}
		});
	}
	$("#idPresentacion").select2({
		  data: objArray
	});
});

$("#idPresentacion").change(function(){
	var idPresentacion = $(this).val().trim();
	var unidadMedida;
	if(idPresentacion.trim()!=""){
		for (var i = 0; i < listaPresentacionInsumo.length; i++) {
			if(listaPresentacionInsumo[i].idPresentacion==idPresentacion){
				unidadMedida = listaPresentacionInsumo[i].idUnidadMedida;
				$("#unidadMedida").val(unidadMedida);
				break;
			}
		}
		for (var i = 0; i < listaFactorConversionMedida.length; i++) {
			if(listaFactorConversionMedida[i].idUnidadMedidaDe==unidadMedida){
				$("#factorConversion").val(listaFactorConversionMedida[i].factorConversion);
				break;
			}
		}
	}else{
		$("#factorConversion").val("");
	}
});

</script>