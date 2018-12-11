 <%@ include file="../Header.jsp"%> 
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="inicio-desarrollador"><i class="fa fa-fw fa-home"></i> Inicio</a>
                    </li>
					<li>
                        <a href="requerimientos-desarrollador"><i class="fa fa-fw fa-book"></i> Requerimientos </a>
                    </li>
                    <li>
                        <a href="licencias-desarrollador"><i class="fa fa-fw fa-pencil-square-o"></i> Licencias </a>
                    </li>
                    <li class = "active">
                        <a href="tareas-desarrollador"><i class="fa fa-fw fa-tasks"></i> Tareas</a>
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
                           Asignar horas a mis requerimientos <small>| Desarrollador</small>
                        </h1>
                       
                    </div>
                </div>
                <!-- /.row -->

				<br></br>
                <!-- /.row -->
				

				
				<!-- INICIO - CUADROS DEL CENTRO -->
				<!--  -->
                <div class="row">
                <span class="input-group-addon">  
                	<label for="enable">Empleado: ${loggedIn.nombre}  ${loggedIn.apellido} </label>

                </span>
                <br></br>
                
                 <form method = "post" action = "buscar-por-mes">     
                
	                <div class="row">
	                    <div class="col-lg-4">           
	                
	                	  <div class="form-group">
	                         
	                         <span class="input-group-addon">
	                         
                        	  <input class="form-control" name = "dni" id="dni" type="hidden" maxlength ="8" value = "${loggedIn.dni}" readOnly />   
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
                
                <form method = "post" action = "buscar-por-fecha">     
                
                <div class="row">
                    <div class="col-lg-4">           
                
                	  <div class="form-group">
                         
                         <span class="input-group-addon">                         
                              
                        	  <input class="form-control" name = "dni" id="dni" type="hidden" maxlength ="8" value = "${loggedIn.dni}" readOnly />  
                        	  <label for="enable">Buscar tareas por fecha</label>
                         <input class="form-control" name = "fecha" id="datepicker" type="text"  placeholder="Ingrese una fecha" maxlength ="10" value = "${fecha}" />                              
                         </span>
                      </div>            
                
                	  <button class="btn btn-default">Buscar</button>
                	  
                	  <br></br>
                	  
                	  </div>            	                 	  
                	  
                 </div>           	  
               
                 </form>
                 
                 
                 
               <form method = "post" action = "guardar-tarea" style="display: ${form2};" >     
                
                <div class="row">
                    <div class="col-lg-4">           
                
                	  <div class="form-group">
                         
                         <span class="input-group-addon">
                         <input class="form-control" name = "dni" id="dni" type="hidden" maxlength ="8" value = "${loggedIn.dni}" readOnly />
                         <label for="enable">Fecha seleccionada:</label>
                         <input class="form-control" name = "fecha" id="datepicker" type="text"  maxlength ="10" value = "${fecha}" readOnly/>                                
                         <br>
                        	
						 <label for="enable">Seleccione un requerimiento:</label>
						 <select class="form-control" name = "rq">
							<c:forEach items="${requerimientos}" var = "requerimiento">
								<c:if  test="${requerimiento.requerimiento.numero == idRequerimiento}">
									<option selected = "selected" value="${requerimiento.requerimiento.numero}">${requerimiento.requerimiento.numero}-${requerimiento.requerimiento.descripcion}</option>
								</c:if>
								<c:if test="${requerimiento.requerimiento.numero != idRequerimiento}">
									<option value="${requerimiento.requerimiento.numero}">${requerimiento.requerimiento.numero}-${requerimiento.requerimiento.descripcion}</option>
								</c:if>
							</c:forEach>										
						 </select>
						 <br>
						 
						 <label for="enable">Seleccione la cantidad de horas:</label>
						 <select name = "horas" class="form-control">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>											
										</select>
										
				      
											 
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
                 
                 
                 
                     <c:if test="${!SessionTareas.isEmpty()}">	
                     
                     <h5 align = "center"> ${titulo} </h5>				 
							
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
			
									<c:forEach items="${SessionTareas}" var="tarea">
										<tr align = "left">
											<td>${tarea.fecha}</td>
											<td>${tarea.requerimiento.numero}</td>
											<td>${tarea.requerimiento.descripcion}</td>		
											<td>${tarea.horas}</td>	
											<td>											
											<button class="btn btn-default"
								                onclick="window.location.href='<%=request.getContextPath() %>/eliminar-tarea?fecha=${tarea.fecha}&id=${tarea.requerimiento.numero}&dni=${tarea.empleado.dni}'">
								                Eliminar
							  					</button>										
											</td>			
																			
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
							</span>
								
							
						
						</c:if>
						
						
						
						<c:if test="${SessionTareas.isEmpty()}">
						
						<div class="row">
							<div class="descripcion">
								
								<h5 align = "center"> NO HAY TAREAS CARGADAS POR EL MOMENTO</h5>
							</div>			
						</div>
							
						</c:if>
						
						<!-- ------------------------------------------------------------------- -->
						
						
				    <h5 align = "center"> LICENCIAS </h5>
                 
                     <c:if test="${!SessionLicencias.isEmpty()}">					 
							
							<span class="input-group-addon">
					
							<table id="tabla2" class="display" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Licencia</th>
										<th>Fecha Inicio</th>													
										<th>Fecha Fin</th>	
										<th>Días</th>								
									</tr>
								</thead>
			
								<tfoot>
									<tr>
									   	<th>Licencia</th>
										<th>Fecha Inicio</th>													
										<th>Fecha Fin</th>	
										<th>Días</th>		
									</tr>
								</tfoot>
			
								<tbody>
			
									<c:forEach items="${SessionLicencias}" var="licencia">
										<tr align = "left">
											<td>${licencia.tipoLicencia.descripcion}</td>
											<td>${licencia.fechaInicio}</td>
											<td>${licencia.fechaFin}</td>		
											<td>${licencia.cantidadDias}</td>				
																			
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
							</span>
								
							
						
						</c:if>
						
						<c:if test="${SessionLicencias.isEmpty()}">
						
						<div class="row">
							<div class="descripcion">
								
								<h5 align = "center"> NO HAY LICENCIAS CARGADAS POR EL MOMENTO</h5>
							</div>			
						</div>
							
						</c:if>
						
						
                </div>
                <!-- /.row -->
				

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
			$("#datepicker").datepicker({
				firstDay : 1,
				dateFormat : 'yy-mm-dd',
				changeMonth : true,
				changeYear : true,
				yearRange: "-8:+0"
			});
		});
	</script>