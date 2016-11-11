<script src="../assets/js/jquery.dataTables.1.3.1.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var mercaderiaJSONArray = [];

$(document).ready(function() {
	var data = {
			tabla:"#tablaMercaderiaDetalle"
			};
	
	inicializarParametros(data);
	
	 $("#tablaMercaderiaDetalle_wrapper").removeClass("dataTables_wrapper");
	 $("#tablaMercaderiaDetalle_wrapper div.row-fluid").remove();
	 $('#tablaMercaderiaDetalle tbody').find("tr.odd").remove();

} );

$("#abrirDetalleMercaderia").click(function(){
	 $("#cantidad").val("");
	 $("#modalDetalleMercaderia").modal("show");
});

$("#agregarMercaderiaDetalle").click(function(){
	 if(validarCamposRequeridos("modalDetalleMercaderia")){		 
 		 	agregarJsonMercaderiaDetalle();	
			var agregarFila = '<tr>'+
				  '<td class="center"><label><input type="checkbox" class="checkDetalle"><span class="lbl"></span></label></td>'+
				  '<td class=" center">'+$("#idInsumo option:selected").text()+'</td>'+
				  '<td class=" center">'+$("#cantidad").val()+'</td>'+
				  '<td class=" center">Kg</td>'+
				  '<tr>';

			$('#tablaMercaderiaDetalle tBody').append(agregarFila);
		 	$("#modalDetalleMercaderia").modal("hide");
	 }
	
});

function agregarJsonMercaderiaDetalle(){
	 var mercaderiaJSON = {
			    idDetalle:'',
			    codigoMaterial: $("#idInsumo").val(),
			    cantidad:$("#cantidad").val(),
			    unidadmedida:'Kg',
			    indicadorBD: INDICADOR_NUEVO};
	 mercaderiaJSONArray.push(mercaderiaJSON);
}

$("#eliminarMercaderiaDetalle").click(function(){
	eliminarDetalle(mercaderiaJSONArray);
});
</script>