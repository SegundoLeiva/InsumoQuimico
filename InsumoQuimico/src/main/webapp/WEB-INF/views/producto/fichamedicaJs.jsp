<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>

<!--inline scripts related to this page-->

<script type="text/javascript">

//----------- Lista de alumnos registrados en la historia social-----------------------------------

	$(function() {
		var oTable1 = $('#historiasocial').dataTable({
			"aoColumns" : [ {
				"bSortable" : false
			}, null,null,null,{
				"bSortable" : false
			} ]
		});

		$('table th input:checkbox').on(
				'click',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});

		$('[data-rel="tooltip"]').tooltip({
			placement : tooltip_placement
		});
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table');
			var off1 = $parent.offset();
			var w1 = $parent.width();

			var off2 = $source.offset();
			var w2 = $source.width();

			if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
				return 'right';
			return 'left';
		}
	});
	

	
</script>


<script type="text/javascript">
	

	function validateForm() {

		$
				.post('${pageContext.request.contextPath}/validardniclinico.htm',
						$("#form_dniclinico").serialize(),
						function(response) {

							if (response == "noexiste") {
								document.getElementById("mensaje").innerHTML = "El DNI no existe";
								document.getElementById("mensaje").style.color="#FA5858";
							} else
									{
								if(response == "nocompleto"){
									document.getElementById("mensaje").innerHTML = "El alumno no completo su Ficha Social";
									document.getElementById("mensaje").style.color="#FA5858";
								}else
									$("#form_dniclinico").submit();
									}
											
										
									
								
									

 							

						});
	};


	
</script>
<script type="text/javascript">
function topico() {
	 {
		var a = document.getElementById("peso").value;
		var b = document.getElementById("talla").value;
		var c = b*b;
		var total = a/c;
		if(total==Infinity){
			document.getElementById("nutricional").value = "";
			}else
			
		document.getElementById("nutricional").value = total.toPrecision(4);
		
	}
}
</script>
