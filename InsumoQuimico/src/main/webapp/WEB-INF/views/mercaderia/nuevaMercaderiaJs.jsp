<script src="../assets/js/jquery.dataTables.1.3.1.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var mercaderiaJSONArray = [];
var filaIndex = 0;
var index = 1;

$(document).ready(function() {
	var data2 = [{ id: -1, text: 'Seleccionar' },{ id: 0, text: 'enhancement' }, { id: 1, text: 'bug' }, { id: 2, text: 'duplicate' }, { id: 3, text: 'invalid' }, { id: 4, text: 'wontfix' }];

	var data = {
			tabla:"#tablaMercaderiaDetalle",
			claseColumna:["idInsumo","descripcion","cantidad","unidadMedida"]
			};
	inicializarParametros(data);
	inicializarStyleTablaDetalle();
	
	if($("#flagEditar").val()=="editar"){
//		$(loading).show();	
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
	$("#idProveedor").select2({
		  data: data2
	});


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