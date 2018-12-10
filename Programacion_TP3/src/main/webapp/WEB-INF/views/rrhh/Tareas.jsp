 <%@ include file="../Header.jsp"%> 
 
 
 
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="inicio-rrhh"><i class="fa fa-fw fa-home"></i> Inicio</a>
                    </li>
					<li>
                        <a href="menu-ABM"><i class="fa fa-fw fa-book"></i> Empleados </a>
                    </li>
                    <li>
                        <a href="licencias-rrhh"><i class="fa fa-fw fa-pencil-square-o"></i> Licencias </a>
                    </li>
                    <li class="active">
                        <a href="tareas-rrhh"><i class="fa fa-fw fa-tasks"></i> Tareas</a>
                    </li>
                    <li>
                        <a href="cierre-rrhh"><i class="fa fa-fw fa-tasks"></i> Cierre mensual</a>
                    </li>

                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
		
		 <!-- FIN - MENU NAVEGACIÓN -->


            <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                           Software Company - Gestion de licencias | <small>Recursos Humanos</small>
                        </h1>
                       
                    </div>
                </div>
                <!-- /.row -->

				<br></br>
                <!-- /.row -->
				
				
				 <div class="row">
                <span class="input-group-addon">  
                	  <c:if test="${ingresado!=null}">	
                		  <label for="enable">Empleado: ${ingresado.nombre}  ${ingresado.apellido} </label>
                	  </c:if>
                	  <c:if test="${ingresado==null}">	
                		  <label for="enable"> Ingresar un empleado </label>
                	  </c:if>                	           	

                </span>
                <br></br>
                
                 <form method = "post" action = "buscar-empleado-tareas">     
                
	                <div class="row">
	                    <div class="col-lg-4">           
	                
	                	  <div class="form-group">
	                         
	                         <span class="input-group-addon">
	                          <label for="enable">Documento empleado:</label>
                        	  <input class="form-control" name = "dni" id="dni" maxlength ="8" value = "${dni}"  />                	  
                        	 
	                                                 
	                         </span>
	                      </div>            
	                
	                	  <button class="btn btn-default">Buscar</button>
	                	  
	                	  <label class = "error">${errorDni}</label>
	                	  
	                	  <br></br>
	                	  
	                	  </div>            	                 	  
	                	  
	                 </div>           	  
               
                 </form>
                 
                <form method = "post" action = "buscar-solo-tareas-por-mes" style="display: ${form2};">     
                
	                <div class="row">
	                    <div class="col-lg-4">           
	                
	                	  <div class="form-group">
	                         
	                         <span class="input-group-addon">
	                         
                        	  <input class="form-control" name = "dni" id="dni" type="hidden" maxlength ="8" value = "${dni}" readOnly />   
	                         <label for="enable">Buscar tareas por mes</label>
	                         <select name = "mes" class="form-control">
											<option value="1">Enero</option>
											<option value="2">Febrero</option>
											<option value="3">Marzo</option>
											<option value="4">Abril</option>
											<option value="5">Mayo</option>
											<option value="6">Junio</option>
											<option value="7">Julio</option>
											<option value="8">Agosto</option>
											<option value="9">Septiembre</option>
											<option value="10">Octubre</option>
											<option value="11">Noviembre</option>		
											<option value="12">Diciembre</option>									
										</select>     
										
										<br></br>
							 <label for="enable">Año:</label>
						 <input type="number" name="anio" value="${anioencurso}" min="2010"
                                                max="${anioencurso}" step="1">   	                         
	                         </span>
	                      </div>            
	                
	                	  <button class="btn btn-default">Buscar</button>
	                	  
	                	  <br></br>
	                	  
	                	  <label class = "error">${erroranio}</label>	                	  
	                	  
	                	  </div>            	                 	  
	                	  
	                 </div>           	  
               
                 </form>
                
                               
                 
                               
               
                 <c:if test="${sTareas!=null}">		
                	 <h3 align = "center"> TAREAS CARGADAS DE ${nombreMes} DE ${anioencurso} PARA EL EMPLEADO SELECCIONADO </h3>			 
							
							<span class="input-group-addon">
					
							<table id="tabla" class="display" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Fecha</th>
										<th>Requerimiento</th>													
										<th>Titulo</th>	
										<th>Horas</th>		
										<th>Eliminar</th>						
									</tr>
								</thead>
			
								<tfoot>
									<tr>
									    <th>Fecha</th>
										<th>Requerimiento</th>													
										<th>Titulo</th>	
										<th>Horas</th>		
										<th>Eliminar</th>
									</tr>
								</tfoot>
			
								<tbody>
			
									<c:forEach items="${sTareas}" var="tarea">
										<tr align = "left">
											<td>${tarea.fecha}</td>
											<td>${tarea.requerimiento.numero}</td>
											<td>${tarea.requerimiento.descripcion}</td>		
											<td>${tarea.horas}</td>	
											<td>											
											<button class="btn btn-default"
								                onclick="window.location.href='<%=request.getContextPath() %>/eliminar-tarea-rrhh?fecha=${tarea.fecha}&id=${tarea.requerimiento.idRequerimiento}&dni=${tarea.empleado.dni}'">
								                Eliminar
							  					</button>										
											</td>			
																			
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
							</span>
								
							
						
						</c:if>
						
						
						
						<c:if test="${sTareas==null}">
						
						<div class="row">
							<div class="descripcion">
								
								<h5 align = "center"> NO HAY TAREAS CARGADAS POR EL MOMENTO</h5>
							</div>			
						</div>
							
						</c:if>
						
						<!-- ------------------------------------------------------------------- -->
				
				<br></br>
				<br></br>
				<br></br>
				<br></br>
				<br></br>

				
				<!-- FIN - CUADROS DEL CENTRO -->
				
				
				
                

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
	
    
 <%@ include file="../Footer.jsp"%> 
  <!-- Calendario -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="js/jquery.ui.datepicker-es.js"></script>
	<script>
		$(function() {
			$.datepicker.setDefaults($.datepicker.regional["es"]);
			$("#fechaInicio").datepicker({
				firstDay : 1,
				dateFormat : 'yy-mm-dd',
				changeMonth : true,
				changeYear : false,
				yearRange: "-0:+1"
			});
		});
	</script>
	
	<script>
		$(function() {
			$.datepicker.setDefaults($.datepicker.regional["es"]);
			$("#fechaFin").datepicker({
				firstDay : 1,
				dateFormat : 'yy-mm-dd',
				changeMonth : true,
				changeYear : false,
				yearRange: "-0:+1"
			});
		});
	</script>
