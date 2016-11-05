<%@ include file="/WEB-INF/views/include.jsp"%>

<!--#################### MODAL DE ALERTAA ###############################-->

<div id="alerta" class="modal hide fade" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">×</button>
        <h3 id="myModalLabel">Alerta!!</h3>
    </div>
    <div class="modal-body">


        <div class="row-fluid">
            <div class="page-content">
             
                   completar los camposs!!!                  

         

            </div>

        </div>


    </div>

    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
        <button class="btn btn-primary" onclick="insertar()" type="submit">Agregar</button>
    </div>

</div>



<!--#################### MODAL BUSQUEDA DE PEDIDO POR RANGOS DE FECHAS ###############################-->

<div id="pedidolista" class="modal hide fade" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">×</button>
        <h3 id="myModalLabel">Alerta!!</h3>
    </div>
    <div class="modal-body">


        <div class="widget-box">
											<div class="widget-header">
												<h4>Date Picker</h4>

												<span class="widget-toolbar">
													<a href="#" data-action="settings">
														<i class="icon-cog"></i>
													</a>

													<a href="#" data-action="reload">
														<i class="icon-refresh"></i>
													</a>

													<a href="#" data-action="collapse">
														<i class="icon-chevron-up"></i>
													</a>

													<a href="#" data-action="close">
														<i class="icon-remove"></i>
													</a>
												</span>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													<div class="row-fluid">
														<label for="id-date-picker-1">Date Picker</label>
													</div>

													<div class="control-group">
														<div class="row-fluid input-append">
															<input class="span10 date-picker" id="id-date-picker-1" type="text" data-date-format="dd-mm-yyyy">
															<span class="add-on">
																<i class="icon-calendar"></i>
															</span>
														</div>
													</div>

													<hr>
													<div class="row-fluid">
														<label for="id-date-range-picker-1">Date Range Picker</label>
													</div>

													<div class="control-group">
														<div class="row-fluid input-prepend">
															<span class="add-on">
																<i class="icon-calendar"></i>
															</span>

															<input class="span10" type="text" name="date-range-picker" id="id-date-range-picker-1">
														</div>
													</div>

													<hr>
													<div class="row-fluid">
														<label for="timepicker1">Time Picker</label>
													</div>

													<div class="control-group">
														<div class="input-append bootstrap-timepicker"><div class="bootstrap-timepicker-widget dropdown-menu"><table><tbody><tr><td><a href="#" data-action="incrementHour"><i class="icon-chevron-up"></i></a></td><td class="separator">&nbsp;</td><td><a href="#" data-action="incrementMinute"><i class="icon-chevron-up"></i></a></td><td class="separator">&nbsp;</td><td><a href="#" data-action="incrementSecond"><i class="icon-chevron-up"></i></a></td></tr><tr><td><input type="text" name="hour" class="bootstrap-timepicker-hour" maxlength="2"></td> <td class="separator">:</td><td><input type="text" name="minute" class="bootstrap-timepicker-minute" maxlength="2"></td> <td class="separator">:</td><td><input type="text" name="second" class="bootstrap-timepicker-second" maxlength="2"></td></tr><tr><td><a href="#" data-action="decrementHour"><i class="icon-chevron-down"></i></a></td><td class="separator"></td><td><a href="#" data-action="decrementMinute"><i class="icon-chevron-down"></i></a></td><td class="separator">&nbsp;</td><td><a href="#" data-action="decrementSecond"><i class="icon-chevron-down"></i></a></td></tr></tbody></table></div>
															<input id="timepicker1" type="text" class="input-small">
															<span class="add-on">
																<i class="icon-time"></i>
															</span>
														</div>
													</div>
												</div>
											</div>
										</div>


    </div>

    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
        <button class="btn btn-primary" onclick="insertar()" type="submit">Agregar</button>
        <a href="../sistema/pedidolista.htm" title="Lista de productos"
			class="btn btn-success btn-small pull-right" href="#codigo" data-toggle="modal"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
    </div>

</div>




<!-- Modal -->

<div id="codigo" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">Búsqueda Productos</h3>
	</div>
	<div class="modal-body">
		<table id="productosmodal"
			class="table table-striped table-bordered table-hover">

			<thead>
				<tr>
					<th class="center">N°</th>
					<th class="">Id</th>
					<th class="center">Descripción</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="n" items="${model.listacitas}" varStatus="contador">
					<tr>
						<td class="center">${contador.count}</td>
						<td class="center"><c:out value="${n[0]}"></c:out></td>
						<td><a href="#"
							onclick="agregar('<c:out value="${n[2]}"></c:out>')" /> <c:out
								value="${n[2]}" /></a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>


	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
	</div>

</div>


<!-- ############### Modal Proveedor ##########################################-->

<div id="codigo2" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">Búsqueda Proveedor</h3>
	</div>
	<div class="modal-body">
		<table id="proveedormodal"
			class="table table-striped table-bordered table-hover">

			<thead>
				<tr>
					<th class="center">N°</th>
					<th class="center">Descripción</th>
					<th class="">#</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="n" items="${model.getlistaproveedor}"
					varStatus="contador">
					<tr>
						<td class="center"><c:out value="${contador.count}" /></td>
						<td><c:out value="${n[1]}"></c:out></td>
						<td class="center"><label><input type="radio"
								name="codigo2" value="${n[1]}" class="ace"> <span
								class="lbl"></span> </label></td>


					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>


	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
		<button class="btn btn-primary" onclick="agregar2()">Agregar</button>
	</div>

</div>

<!-- ##################### Nuevo Producto #####################################-->
<form id="form_producto" class="form-horizontal">
	<div id="nuevoproducto" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Nuevo Producto</h3>
		</div>
		<div class="modal-body">


			<div class="row-fluid">
				<div class="page-content">
					<div class="span10">

						<div class="row-fluid">
							<div class="span6">

							<div class="control-group">
								<label class="control-label" for="">Nombre Producto</label>
								<div class="controls">
									<input type="text" name="nombre" id="nombre"
										placeholder="Nombre" required="required">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Categoría</label>
								<div class="controls">
									<select name="categoria" class="">

										<c:forEach var="a" items="${model.getlistacategorias}">

											<option value="${a.id}">
												<c:out value="${a.descripcion}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Marca</label>
								<div class="controls">
									<select name="marca" class="">

										<c:forEach var="a" items="${model.getlistamarcas}">

											<option value="${a.id}">
												<c:out value="${a.descripcion}"></c:out>
											</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Estado</label>
								<div class="controls">
									<select name="estado" class="">
										<option value="1">HABILITADO</option>
										<option value="2">DESHABILITADO</option>

									</select>
								</div>
							</div>



							</div>

						</div>


					</div>
				</div>

			</div>


		</div>

		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
			<button class="btn btn-primary" type="submit">Agregar</button>
		</div>

	</div>
</form>




<!-- Agregar Nuemro de Serie -->

<div id="numeroserie" class="modal hide fade" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">×</button>
        <h3 id="myModalLabel">Agregar Series</h3>
    </div>
    <div class="modal-body">


        <div class="row-fluid">
            <div class="page-content">
                <div class="span8">
                    <textarea rows="10" id="agregaserie" ></textarea>
                  

                </div>
                 <div class="span4" >
                
               <label  id="cantser"></label>
                        
                    
                 </div>

            </div>

        </div>


    </div>

    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
        <button class="btn btn-primary" onclick="insertar()" type="submit">Agregar</button>
    </div>

</div>


<script type="text/javascript" charset="utf-8">


    function insertar() {
        var a = document.getElementById("agregaserie").value;

        var b = a.split("\n");
        var c = "";
        for (var i = 0; i < b.length; i++) {
          
                c = c + b[i] + ";";
         }

        $('#serie').val(c);
        $('#numeroserie').modal('hide');

        

    }
    
    function enviarcantidad(){
        var c = document.getElementById("cantidad").value;
         document.getElementById('cantser').innerHTML=c;
        
    }
</script>



