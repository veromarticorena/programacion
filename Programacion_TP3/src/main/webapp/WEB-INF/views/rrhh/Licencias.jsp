 <%@ include file="../Header.jsp"%> 
 
 
 
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="inicio-rrhh"><i class="fa fa-fw fa-home"></i> Inicio</a>
                    </li>
					<li>
                        <a href="menu-ABM"><i class="fa fa-fw fa-book"></i> Empleados </a>
                    </li>
                    <li class="active">
                        <a href="licencias-rrhh"><i class="fa fa-fw fa-pencil-square-o"></i> Licencias </a>
                    </li>
                    <li>
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
                
                 <form method = "post" action = "buscar-empleado">     
                
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
                               
                 
               <form method = "post" action = "guardar-licencia" style="display: ${form2};" >     
                
                <div class="row">
                    <div class="col-lg-4">           
                
                	  <div class="form-group">
                         
                         <span class="input-group-addon">
                         <input class="form-control" name = "dni" id="dni" type="hidden" maxlength ="8" value = "${ingresado.dni}" readOnly />
                         <label for="enable">Cargar licencia</label>
                         <br>
                         <label for="enable">Fecha Inicio:</label>
                         <input class="form-control" name = "fechaInicio" id="fechaInicio" type="text"  maxlength ="10" value = "${fechaInicio}" />  
                         <br>
                         <label for="enable">Fecha Fin:</label>
                         <input class="form-control" name = "fechaFin" id="fechaFin" type="text"  maxlength ="10" value = "${fechaFin}" /> 
                          
                                                      
                         <br>
                        	
						 <label for="enable">Seleccione un tipo de licencia:</label>
						 <select class="form-control" name = "tipo">
							<c:forEach items="${tipoLicencias}" var = "licencia">
								<c:if  test="${licencia.idTipoLicencia == idTipo}">
									<option selected = "selected" value="${licencia.idTipoLicencia}">${licencia.descripcion}</option>
								</c:if>
								<c:if test="${licencia.idTipoLicencia != idTipo}">
									<option value="${licencia.idTipoLicencia}">${licencia.descripcion}</option>
								</c:if>
							</c:forEach>										
						 </select>
						 <br>
						 
						 <label for="enable">Seleccione la cantidad de dias:</label>
						 <input type="number" name="dias" value="1" min="1"
                                                max="45" step="1"> 	      
											 
                         </span>
                         
                       	     
                      </div>            
                
                	  <button class="btn btn-default">Cargar</button>
                	  
                	  <br></br>
                	  
                	   <label class = "error">${error}</label>
                	    <label class = "confirmacion">${mensaje}</label>
                	     <br></br>
                	  
                	  </div>
                	  
            	  
                	  
                 </div>           	  
               
                 </form>
                 
               
                 
                     <c:if test="${!licencias.isEmpty()}">	
                     	<h3 align = "center"> TODAS LAS LICENCIAS CARGADAS PARA EL EMPLEADO SELECCIONADO </h3>				 
							
							<span class="input-group-addon">
					
							<table id="tabla2" class="display" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Licencia</th>
										<th>Fecha Inicio</th>													
										<th>Fecha Fin</th>	
										<th>Días</th>	
										<th>Eliminar</th>							
									</tr>
								</thead>
			
								<tfoot>
									<tr>
									   	<th>Licencia</th>
										<th>Fecha Inicio</th>													
										<th>Fecha Fin</th>	
										<th>Días</th>		
										<th>Eliminar</th>
									</tr>
								</tfoot>
			
								<tbody>
			
									<c:forEach items="${licencias}" var="licencia">
										<tr align = "left">
											<td>${licencia.tipoLicencia.descripcion}</td>
											<td>${licencia.fechaInicio}</td>
											<td>${licencia.fechaFin}</td>		
											<td>${licencia.cantidadDias}</td>	
											<td>											
											<button class="btn btn-default"
								                onclick="window.location.href='<%=request.getContextPath() %>/eliminar-licencia?fechaInicio=${licencia.fechaInicio}&fechaFin=${licencia.fechaFin}&dni=${licencia.empleado.dni}'">
								                Eliminar
							  					</button>										
											</td>			
																			
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
							</span>
								
							
						
						</c:if>
						
						<c:if test="${licencias.isEmpty()}">
						
						<div class="row">
							<div class="descripcion">
								
								<h5 align = "center"> NO HAY LICENCIAS CARGADAS POR EL MOMENTO</h5>
							</div>			
						</div>
							
						</c:if>
				
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
