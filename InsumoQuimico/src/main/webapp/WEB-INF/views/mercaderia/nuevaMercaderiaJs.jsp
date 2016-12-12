<script src="../assets/js/jquery.dataTables.1.3.1.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var mercaderiaJSONArray = arrayJsonDetalle;
var index = 1;

$(document).ready(function() {
	tabla="#tablaMercaderiaDetalle";
	claseColumna=["idUnidadMineraInsumo","descripcion","cantidad","unidadMedida"];
	inicializarStyleTablaDetalle();
	
	if($("#flagEditar").val()=="editar"){	
		var i=0;
		<c:forEach var="jbean" items="${listaMercaderiaDetalle}">		
		 	var data = ["${jbean.unidadMineraInsumo.idUnidadMineraInsumo}",
		             "${jbean.unidadMineraInsumo.insumo.insumo}",
		             "${jbean.cantidad}","Kg"];
			agregarDetalle(data); 
			mercaderiaJSONArray[i].idDetalle="${jbean.id.idMercaderiaDetalle}";
			mercaderiaJSONArray[i].idUnidadMineraInsumo="${jbean.unidadMineraInsumo.idUnidadMineraInsumo}";
			mercaderiaJSONArray[i].cantidad="${jbean.cantidad}";
			mercaderiaJSONArray[i].unidadMedida="Kg";
			mercaderiaJSONArray[i].indicadorBD=INDICADOR_CREADO;
			i++;
		</c:forEach>
		index = "${listaMercaderiaDetalle.get(listaMercaderiaDetalle.size()-1).id.idMercaderiaDetalle+1}";
	}
	
	var dataInsumo=[];
	<c:forEach var="item" items="${listaUnidadMineraInsumo}">
		var obj = {id:"${item.idUnidadMineraInsumo}",text:"${item.insumo.insumo}"}
		dataInsumo.push(obj);
	</c:forEach>

	$("#idUnidadMineraInsumo").select2({
		  data: dataInsumo
	});


} );

$("#btnAgregarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarInsumoAgregar()){			 	
 		 	var data = [$("#idUnidadMineraInsumo").val(),$("#idUnidadMineraInsumo option:selected").text(),
 		 	         	 $("#cantidad").val(),"Kg"];
 		 	agregarDetalle(data);
 		 	var fila = mercaderiaJSONArray.length-1;
 		 	mercaderiaJSONArray[fila].idUnidadMineraInsumo=$("#idUnidadMineraInsumo").val();
			mercaderiaJSONArray[fila].cantidad=$("#cantidad").val();
		 	$("#divModalDetalleForm").modal("hide");
	 }
	
});

function agregarDetalle(data){
	agregarJsonDetalle();	
	agregarFila(data);
}

$("#btnEditarDetalle").click(function(){
	 if(validarCamposRequeridos("formModalDetalleForm") && validarInsumoEditar()){	
		 setearCampo("idUnidadMineraInsumo",$("#idUnidadMineraInsumo").val());
		 setearCampo("descripcion",$("#idUnidadMineraInsumo option:selected").text());
		 setearCampo("cantidad",$("#cantidad").val());
		 cambiarIndicadorModificado();	 
		 $("#divModalDetalleForm").modal("hide");
	 }
	
});

$("#abrirDetalleEditar").click(function(){
	$("#btnAgregarDetalle").hide();
	$("#btnEditarDetalle").show();
	var checkDetalle = $('#tablaMercaderiaDetalle> tbody .checkDetalle:checked');
	if(checkDetalle.length==1){
		var idUnidadMineraInsumoDetalle = checkDetalle.closest("tr").find("td.idUnidadMineraInsumo").text();
		for (var i = 0; i < mercaderiaJSONArray.length; i++) {
			var idUnidadMineraInsumo = mercaderiaJSONArray[i].idUnidadMineraInsumo;
			if(idUnidadMineraInsumo==idUnidadMineraInsumoDetalle){
				$("#idUnidadMineraInsumo").val(idUnidadMineraInsumo).trigger('change');
				$("#cantidad").val(mercaderiaJSONArray[i].cantidad);
				filaIndexDetalle = i;
			}
		}
		$("#divModalDetalleForm").modal("show");
	}else{
		alertify.error("Seleccione un Item.");
	}	
});

function validarInsumoAgregar(){
	var rpta=true;
	for (var i = 0; i < mercaderiaJSONArray.length; i++) {
		var idUnidadMineraInsumo = mercaderiaJSONArray[i].idUnidadMineraInsumo;
		if(idUnidadMineraInsumo==$("#idUnidadMineraInsumo").val()){
			alertify.error("Ya existe un insumo.");
			rpta=false;
		}
	}
	if(parseFloat($("#cantidad").val())==0){
		alertify.error("La cantidad debe ser mayor a 0.");
		rpta=false;
	}
	return rpta;
}
function validarInsumoEditar(){
	var rpta=true;
	for (var i = 0; i < mercaderiaJSONArray.length; i++) {
		var idUnidadMineraInsumo = mercaderiaJSONArray[i].idUnidadMineraInsumo;
		if(i!=filaIndexDetalle){
			if(idUnidadMineraInsumo==$("#idUnidadMineraInsumo").val()){
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
			    descripcion:'',unidadMedida:'Kg',indicadorBD: INDICADOR_NUEVO};
	 mercaderiaJSONArray.push(mercaderiaJSON);
}

$("#eliminarDetalle").click(function(){
	eliminarDetalle();
});

$("#guardarMercaderia").click(function(){
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
				url : '${pageContext.request.contextPath}/ingresarMercaderia/getProveedorDescripcion.htm',
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
</script>