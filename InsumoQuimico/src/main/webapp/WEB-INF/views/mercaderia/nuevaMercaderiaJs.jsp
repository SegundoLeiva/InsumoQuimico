<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var mercaderiaJSONArray = arrayJsonDetalle;
var index = 1;
var listaPresentacionInsumo;
var dataInsumo=[];

$(document).ready(function() {
	tabla="#tablaMercaderiaDetalle";
	claseColumna=["idUnidadMineraInsumoPresentacion","descripcionPresentacion","cantidad","unidadMedidaPresentacion"];
	inicializarStyleTablaDetalle();
	
	if('<c:out value="${accion}"/>'=="CONSULTAR"){
		$("#codigoGenerado").html("N° "+$("#idMercaderia").val());
		var i=0;
		<c:forEach var="jbean" items="${listaMercaderiaDetalle}">		
		 	var data = ["${jbean.unidadMineraInsumoPresentacion.idUnidadMineraInsumoPresentacion}",
		             	"${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.insumo.insumo}"+" - "+"${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.descripcion}",
		             	"${jbean.cantidad}","${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.idUnidadMedidaPresentacion}"];
			agregarDetalle(data); 
			mercaderiaJSONArray[i].idDetalle="${jbean.id.idMercaderiaDetalle}";
			mercaderiaJSONArray[i].idUnidadMineraInsumoPresentacion="${jbean.unidadMineraInsumoPresentacion.idUnidadMineraInsumoPresentacion}";
			mercaderiaJSONArray[i].cantidad="${jbean.cantidad}";
			mercaderiaJSONArray[i].descripcionPresentacion="${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.descripcion}";
			mercaderiaJSONArray[i].unidadMedidaPresentacion="${jbean.unidadMineraInsumoPresentacion.presentacionInsumo.idUnidadMedidaPresentacion}";
			mercaderiaJSONArray[i].indicadorBD=INDICADOR_CREADO;
			i++;
		</c:forEach>
		index = "${listaMercaderiaDetalle.get(listaMercaderiaDetalle.size()-1).id.idMercaderiaDetalle+1}";
		
		bloquearCamposConsultar();
	}
	
	<c:forEach var="item" items="${listaUnidadMineraInsumoPresentacion}">
			var obj = {id:"${item.idUnidadMineraInsumoPresentacion}",text:"${item.presentacionInsumo.insumo.insumo} - ${item.presentacionInsumo.descripcion}",
					pesoNeto:"${item.presentacionInsumo.pesoNeto}",unidadMedidaPresentacion:"${item.presentacionInsumo.idUnidadMedidaPresentacion}",idUnidadMinera:"${item.idUnidadMinera}"}
			dataInsumo.push(obj);
	</c:forEach>

	var dataInsumoTemp = [];
	dataInsumoTemp = [{id:" ",text:"Seleccionar",pesoNeto:"",unidadMedidaPresentacion:"",idUnidadMinera:""}];
	for (var i = 0; i < dataInsumo.length; i++) {
		if($("#idUnidadMinera").val()==dataInsumo[i].idUnidadMinera){
			dataInsumoTemp.push(dataInsumo[i]);
		}
	}
	
	$("#idUnidadMineraInsumoPresentacion").select2({
		  data: dataInsumoTemp
	});


} );

$("#btnAgregarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarInsumoPresentacion("")){			 	
 		 	var data = [$("#idUnidadMineraInsumoPresentacion").val(),$("#idUnidadMineraInsumoPresentacion option:selected").text(),
 		 	            $("#cantidad").val(),$("#unidadMedidaPresentacion").val()];
 		 	agregarDetalle(data);
 		 	var fila = mercaderiaJSONArray.length-1;
 		 	mercaderiaJSONArray[fila].idUnidadMineraInsumoPresentacion=$("#idUnidadMineraInsumoPresentacion").val();
			mercaderiaJSONArray[fila].cantidad=$("#cantidad").val();
			mercaderiaJSONArray[fila].descripcionPresentacion=$("#idUnidadMineraInsumoPresentacion option:selected").text();
			mercaderiaJSONArray[fila].unidadMedidaPresentacion=$("#unidadMedidaPresentacion").val();
		 	$("#divModalDetalleForm").modal("hide");
	 }
});

function agregarDetalle(data){
	var mercaderiaJSON = {
		    idDetalle:'',idUnidadMineraInsumoPresentacion:'',cantidad:'',descripcionPresentacion:'',
		    unidadMedidaPresentacion:'',indicadorBD: INDICADOR_NUEVO};
	mercaderiaJSONArray.push(mercaderiaJSON);
	agregarFila(data);
}

$("#btnEditarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarInsumoPresentacion("editar")){	
		 setearCampo("idUnidadMineraInsumoPresentacion",$("#idUnidadMineraInsumoPresentacion").val());
		 setearCampo("descripcionPresentacion",$("#idUnidadMineraInsumoPresentacion option:selected").text());
		 setearCampo("cantidad",$("#cantidad").val());
		 setearCampo("unidadMedidaPresentacion",$("#unidadMedidaPresentacion").val());
		 cambiarIndicadorModificado();	 
		 $("#divModalDetalleForm").modal("hide");
	 }
	
});

$("#abrirDetalleEditar").click(function(){
	$("#btnAgregarDetalle").hide();
	$("#btnEditarDetalle").show();
	var checkDetalle = $('#tablaMercaderiaDetalle> tbody .checkDetalle:checked');
	if(checkDetalle.length==1){
		var index = checkDetalle.closest("tr").index();
		var idUnidadMineraInsumoPresentacionDetalle = checkDetalle.closest("tr").find("td.idUnidadMineraInsumoPresentacion").text();

		$("#idUnidadMineraInsumoPresentacion").val(mercaderiaJSONArray[index].idUnidadMineraInsumoPresentacion).trigger('change');
		$("#cantidad").val(mercaderiaJSONArray[index].cantidad);
		filaIndexDetalle = index;

		$("#divModalDetalleForm").modal("show");
	}else{
		alertify.error("Seleccione un Item.");
	}	
});

function validarInsumoPresentacion(flag){
	var rpta=true;
	var cantidad = parseFloat($("#cantidad").val());
	var idUnidadMineraInsumoPresentacion = $("#idUnidadMineraInsumoPresentacion").val();
	var indexEditar = 0;

	for (var i = 0; i < mercaderiaJSONArray.length; i++) {
		var _idUnidadMineraInsumoPresentacion = mercaderiaJSONArray[i].idUnidadMineraInsumoPresentacion;
		if(flag!="editar"){
			if(_idUnidadMineraInsumoPresentacion==idUnidadMineraInsumoPresentacion){
				alertify.error("Ya existe un insumo con la misma presentación.");
				rpta=false;
			}
		}else{
			if(i!=filaIndexDetalle){
				if(_idUnidadMineraInsumoPresentacion==idUnidadMineraInsumoPresentacion){
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

	var data = $("#formMercaderia").serializeObject();
	data.index = index;
	data.mercaderiaJSONArray = JSON.stringify(mercaderiaJSONArray);
		
	if(fnValidarGuardarMercaderia()){
		alertify.confirm("Guardar","¿Usted está seguro de guardar los registros?",
				function(){
			showLoading();
			$.ajax({
				type : 'post',
				data: data,
				url : '${pageContext.request.contextPath}/ingresarMercaderia/guardarMercaderia.htm',
				success : function(data) {
					hideLoading();
					if(data!=""){	
						index = actualizarDetalleGrabar(index);						
						$("#idMercaderia").val(data);	
						$("#codigoGenerado").html("N° "+data);
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
						$("#descripcionProveedor").val("");
					}else{
						$("#descripcionProveedor").val(data);
					}
					
				}
			});
	}else{
		$("#rucProveedor").val("");
		$("#descripcionProveedor").val("");
	}
		
}

$("#idUnidadMineraInsumoPresentacion").change(function(){
	if($(this).val().trim().length>0){
		for (var i = 0; i < dataInsumo.length; i++) {
			if(dataInsumo[i].id==$(this).val()){
				$("#unidadMedidaPresentacion").val(dataInsumo[i].unidadMedidaPresentacion);
				$("#pesoNeto").val(dataInsumo[i].pesoNeto);
				break;
			}
		}
	}else{
		$("#pesoNeto").val("");
	}

});

$("#idUnidadMinera").change(function(){
	
	$('#idUnidadMineraInsumoPresentacion').empty();
	var dataInsumoTemp = [];
	dataInsumoTemp = [{id:" ",text:"Seleccionar",pesoNeto:"",unidadMedidaPresentacion:"",idUnidadMinera:""}];
	for (var i = 0; i < dataInsumo.length; i++) {
		if($("#idUnidadMinera").val()==dataInsumo[i].idUnidadMinera){
			dataInsumoTemp.push(dataInsumo[i]);
		}
	}
	$("#idUnidadMineraInsumoPresentacion").select2({
		  data: dataInsumoTemp
	});

});

</script>