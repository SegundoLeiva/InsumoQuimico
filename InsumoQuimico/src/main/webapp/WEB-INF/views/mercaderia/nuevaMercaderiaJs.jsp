<script src="../assets/js/jquery.dataTables.1.3.1.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
var mercaderiaJSONArray = [];
var table;

$(document).ready(function() {

	 $('#tablaMercaderiaDetalle').DataTable({
		 	"bSort" : false,
			"bFilter": false, 
			"bLengthChange": false,
			"bInfo": false,
			"bPaginate": false,
			"columnDefs": [
			                { className: "center", "targets": [0,1,2,3] }
			              ]
	 });
	 $("#tablaMercaderiaDetalle_wrapper").removeClass("dataTables_wrapper");
	 $("#tablaMercaderiaDetalle_wrapper div.row-fluid").remove();
	 $('#tablaMercaderiaDetalle tbody').find("tr.odd").remove();
	 table = $('#tablaMercaderiaDetalle').DataTable();

} );

$("#abrirDetalleMercaderia").click(function(){
	 $("#cantidad").val("");
	 $("#modalDetalleMercaderia").modal("show");
});

$("#agregarMercaderiaDetalle").click(function(){
	 if(validarCamposRequeridos("modalDetalleMercaderia")){		 
 		 	agregarJsonMercaderiaDetalle();	
			var agregarFila = '<tr>'+
				  '<td class="center"><label><input type="checkbox" class="checkMercaderia"><span class="lbl"></span></label></td>'+
				  '<td class=" center">'+$("#idInsumo option:selected").text()+'</td>'+
				  '<td class=" center">'+$("#cantidad").val()+'</td>'+
				  '<td class=" center">Kg</td>'+
				  '<tr>';

			$('#tablaMercaderiaDetalle tBody').append(agregarFila)
		 	$("#modalDetalleMercaderia").modal("hide");
	 }
	
});



function agregarJsonMercaderiaDetalle(){
	 var mercaderiaJSON = {
			    idMercaderiaDetalle:'',
			    codigoMaterial: $("#idInsumo").val(),
			    cantidad:$("#cantidad").val(),
			    unidadmedida:'Kg',
			    indicadorBD: INDICADOR_NUEVO};
	 mercaderiaJSONArray.push(mercaderiaJSON);
}

$("#eliminarMercaderiaDetalle").click(function(){
	var arrayCheckbox = $('#tablaMercaderiaDetalle .checkMercaderia:checked');
	var dimCheck = arrayCheckbox.length;
	var indexArray=0;
	if(dimCheck > 0) {
		alertify.confirm("Eliminar","¿Está seguro en eliminar los items seleccionados?",
				function(){
			//Eliminando la fila en vista
  		  		for(var i = 0;i<dimCheck;i++){	  
		        	var obtenerFila=$(arrayCheckbox[i]).closest("tr");
		        	if(arrayCheckbox[i].checked){		        		
		        		if(mercaderiaJSONArray[indexArray].idMercaderiaDetalle==""){
		        			arrayCheckbox[i].closest("tr").remove();
		        			mercaderiaJSONArray.splice(indexArray,1);		        			
		        		}else{
		        			mercaderiaJSONArray[i].indicadorBD=INDICADOR_ELIMINADO;
		        			obtenerFila.hide();
		        			indexArray++;
		        		}
		        		
		        	}	            
		        }	
						  },
				function(){});
	}else{
		alertify.alert("Alerta","Seleccione un registro para eliminar");
	}
});


$(".checkSelectedAll").click(function(){
	 $('#tablaMercaderiaDetalle input:checkbox').not(this).prop('checked', this.checked);
});
	



</script>