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
                    <li>
                        <a href="tareas-rrhh"><i class="fa fa-fw fa-tasks"></i> Tareas</a>
                    </li>
                    <li class="active">
                        <a href="menu-rq-rrhh"><i class="fa fa-fw fa-tasks"></i> Requerimientos</a>
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
                          Asignar requerimiento | <small>Recursos Humanos</small>
                        </h1>
                       
                    </div>
                </div>
                <!-- /.row -->
                
                  
                <form method = "post" action = "buscar-requerimiento">     
                
                <div class="row">
                    <div class="col-lg-4">           
                
                	  <div class="form-group">
                                                           
                        <span class="input-group-addon">                   
                         <label for="enable">Numero de requerimiento</label>
                         <input class="form-control" name = "numero" id="numero" type="text"  placeholder="Ingrese un numero"  maxlength ="5" value = "${numero}"/>            
                         <br>
                	
                         <button class="btn btn-default">Buscar</button>
                         </span>
                      </div>                      
                	
                	  
                	   <br></br>
                	   <br></br> 
                	  
                	  </div>
                	  
                	   <label class = "error">${error}</label>

                
                 </div>                          	  
               
                 </form>

                 
                <form method = "post" action = "agregar-empleado" style="display: ${form2};">     
                
                <div class="row">
                    <div class="col-lg-4">           
                
                	  <div class="form-group">
                         
                        <span class="input-group-addon">                  
                         <input class="form-control" name = "numero" id="numero" type="hidden" maxlength ="5" value = "${numero}" readOnly />
                         
                         <label for="enable">Documento empleado</label>
                         <input class="form-control" name = "dni" id="dni" type="text"  placeholder="Ingrese el documento del empleado"  maxlength ="8" value = "${dni}"/>            
                         <br>
                	
                         <button class="btn btn-default">Asignar</button>
                         </span>
                      </div>                      
                	
                	  
                	   <br></br>
                	   <br></br> 
                	  
                	  </div>
                	  
                	    <label class = "error">${errorEmpleado}</label>
                	    <label class = "confirmacion">${confirmacion}</label>
                
                 </div>                          	  
               
                 </form>
                 
                 
                 <!--  EMPLEADOS ASIGNADOS AL REQUERIMIENTO -->
                 
                  	<c:if test="${!requerimientos.isEmpty()}">	
                  	
                  	<h5> EMPLEADOS ASIGNADOS AL REQUERIMIENTO NÚMERO ${numero} </h5>				 
							
							<span class="input-group-addon">
					
							<table id="tabla" class="display" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Número</th>
										<th>Título</th>	
										<th>Empleado</th>												
																	
									</tr>
								</thead>
			
								<tfoot>
									<tr>
									    <th>Número</th>
										<th>Título</th>	
										<th>Empleado</th>									
											
									</tr>
								</tfoot>
			
								<tbody>
			
									<c:forEach items="${requerimientos}" var="requerimiento">
										<tr align = "left">
											<td>${requerimiento.requerimiento.numero}</td>
											<td>${requerimiento.requerimiento.descripcion}</td>	
											<td>${requerimiento.empleado.nombre} ${requerimiento.empleado.apellido}</td>
																
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
							</span>
								
							
						
						</c:if>
						
						<c:if test="${requerimientos.isEmpty()}">
						
						<div class="row">
							<div class="descripcion">
								
								<h5> NO HAY EMPLEADOS ASIGNADOS A ESTE REQUERIMIENTO POR EL MOMENTO</h5>
							</div>			
						</div>
							
						</c:if>
                 
                 
                 	 
                        	
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
 
