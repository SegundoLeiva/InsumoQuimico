<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="../assets/js/date-time/bootstrap-datepicker.min.js"></script>


<!--inline scripts related to this page-->

<script type="text/javascript">

//----------- Lista de Productos Modal-----------------------------------

	$(function() {
		var oTable1 = $('#productosmodal').dataTable({
			"aoColumns" : [ {
				"bSortable" : false
			}, null,null ]
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
//----------- Lista de Proveedor Modal-----------------------------------

	$(function() {
		var oTable1 = $('#proveedormodal').dataTable({
			"aoColumns" : [ {
				"bSortable" : false
			}, null,null ]
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


	 function agregar(a) {
	
	
				$('#numerocodigo').val(a);
				$('#codigo').modal('hide');
	
	}


	function agregar2() {
		var ch = document.getElementsByName('codigo2');

		for (var i = ch.length; i--;) {
			if (ch[i].checked) {

				$('#numerocodigo2').val(ch[i].value);
				$('#codigo2').modal('hide');
			}

		}
	}


	$('.date-picker').datepicker().next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
	
</script>

