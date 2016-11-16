<script src="../assets/js/jquery.dataTables.1.3.1.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="../assets/select2/select2.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var consumoJSONArray = [];
var filaIndex = 0;
var index = 1;

$(document).ready(function() {
	var data = {
			tabla:"#tablaConsumoDetalle",
			claseColumna:["idInsumo","descripcion","cantidad","unidadMedida"]
			};
	inicializarParametros(data);
	inicializarStyleTablaDetalle();
	
	if($("#flagEditar").val()=="editar"){
//		$(loading).show();	
		var i=0;
		<c:forEach var="jbean" items="${listaConsumoDetalle}">		
		 	var data = ["${jbean.unidadMineraInsumo.idUnidadMineraInsumo}",
		             "${jbean.unidadMineraInsumo.insumo.insumo}",
		             "${jbean.cantidad}","Kg"];
			agregarDetalle(data); 
			consumoJSONArray[i].idDetalle="${jbean.id.idConsumoDetalle}";
			consumoJSONArray[i].idUnidadMineraInsumo="${jbean.unidadMineraInsumo.idUnidadMineraInsumo}";
			consumoJSONArray[i].cantidad="${jbean.cantidad}";
			consumoJSONArray[i].unidadMedida="Kg";
			consumoJSONArray[i].indicadorBD=INDICADOR_CREADO;
			i++;
		</c:forEach>
		index = "${listaConsumoDetalle.get(listaConsumoDetalle.size()-1).id.idConsumoDetalle+1}";
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
 		 	var fila = consumoJSONArray.length-1;
 		 	consumoJSONArray[fila].idUnidadMineraInsumo=$("#idInsumo").val();
			consumoJSONArray[fila].cantidad=$("#cantidad").val();
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
		 consumoJSONArray[filaIndex].indicadorBD=INDICADOR_MODIFICADO;
		 $("#modalDetalleForm").modal("hide");
	 }
	
});

$("#abrirDetalleEditar").click(function(){
	$("#btnAgregarDetalle").hide();
	$("#btnEditarDetalle").show();
	var checkDetalle = $('#tablaConsumoDetalle> tbody .checkDetalle:checked');
	if(checkDetalle.length==1){
		var idInsumo = checkDetalle.closest("tr").find("td.idInsumo").text();
		for (var i = 0; i < consumoJSONArray.length; i++) {
			var idUnidadMineraInsumo = consumoJSONArray[i].idUnidadMineraInsumo;
			if(idUnidadMineraInsumo==idInsumo){
				$("#idInsumo").val(idInsumo);
				$("#cantidad").val(consumoJSONArray[i].cantidad);
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
	for (var i = 0; i < consumoJSONArray.length; i++) {
		var idUnidadMineraInsumo = consumoJSONArray[i].idUnidadMineraInsumo;
		if(idUnidadMineraInsumo==$("#idInsumo").val()){
			alertify.error("Ya existe un insumo.");
			rpta=false;
		}
	}
	return rpta;
}
function validarInsumoEditar(){
	var rpta=true;
	for (var i = 0; i < consumoJSONArray.length; i++) {
		var idUnidadMineraInsumo = consumoJSONArray[i].idUnidadMineraInsumo;
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
	 consumoJSONArray.push(mercaderiaJSON);
}

$("#eliminarDetalle").click(function(){
	eliminarDetalle(consumoJSONArray);
});

function setearCampo(clase,data){
	if(clase=="idInsumo"){
		consumoJSONArray[filaIndex].idInsumo=data;
	}else if(clase=="cantidad"){
		consumoJSONArray[filaIndex].cantidad=data;
	}
	$("."+clase, $('#tablaConsumoDetalle> tbody > tr:eq('+filaIndex+')')).html(data);
}

$("#guardarConsumo").click(function(){
	if(fnValidarGuardarConsumo()){
		alertify.confirm("Guardar","¿Usted está seguro de guardar los registros?",
				function(){
			$.ajax({
				type : 'post',
				data: {
					idConsumo:$("#idConsumo").val(),
					idUnidadMinera:$("#idUnidadMinera").val(),
					idUnidadMineraAlmacen:$("#idUnidadMineraAlmacen").val(),
					idUnidadMineraArea:$("#idUnidadMineraArea").val(),
					index:index,
	 				consumoJSONArray: JSON.stringify(consumoJSONArray)
					
				},
				url : '${pageContext.request.contextPath}/registrarConsumo/guardarConsumo.htm',
				success : function(data) {
					if(data!=""){	
						index = actualizarDetalleGrabar(consumoJSONArray,index);						
						$("#idConsumo").val(data);	
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

function fnValidarGuardarConsumo(){
	if(consumoJSONArray.length==0){
		alertify.error("Mínimo debe registrar un detalle");
		return false;
	}
	
	return true;
}
</script>