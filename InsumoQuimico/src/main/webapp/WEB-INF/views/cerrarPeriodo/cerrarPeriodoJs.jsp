<script type="text/javascript">


$(document).ready(function() {

} );

function cambiarApertura(mes){
	alertify.confirm("Alerta","¿Está seguro cambiar la Apertura?",
			function(){
			var form = document.forms[0];
			$("#mes").val(mes);	
		    form.action="cambiarApertura.htm"
		    form.submit();
					  },
			function(){});
}

function verDetalleConsumo(idConsumo){
	$.ajax({
		type : 'post',
		data: {
			'idConsumo':idConsumo
			},
		url : '${pageContext.request.contextPath}/ajax/obtenerConsumoDetallePorIdConsumo.htm',
		async:false,
		success : function(data) {
			var listaDetalle = JSON.parse(data);
			var tbody="";
			
 			for (var i = 0; i < listaDetalle.length; i++) {
 				tbody+="<tr>";
 				tbody+="<td class='center'>"+listaDetalle[i].unidadMineraInsumoPresentacion.idUnidadMineraInsumoPresentacion+"</td>";			
 				tbody+="<td class='center'>"+listaDetalle[i].unidadMineraInsumoPresentacion.presentacionInsumo.insumo.insumo+" - "+listaDetalle[i].unidadMineraInsumoPresentacion.presentacionInsumo.descripcion+"</td>";
 				tbody+="<td class='center'>"+listaDetalle[i].cantidad+"</td>";
 				tbody+="<td class='center'>"+listaDetalle[i].unidadMedida+"</td>";
 				tbody+="</tr>";
 			}
			$("#tbodyTablaConsumoDetalle").html(tbody);
			$(loading).hide();
			
		}
	});
	$("#divDetalleConsumo").modal("show");
}


</script>