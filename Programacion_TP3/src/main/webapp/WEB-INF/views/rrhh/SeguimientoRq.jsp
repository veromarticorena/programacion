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
                    <li class = "active">
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
                           Software Company - Gestion de licencias | <small>Recursos Humanos</small>
                        </h1>
                       
                    </div>
                </div>
                <!-- /.row -->
                
                <form method = "post" action = "buscar-tareas-rq">     
                
	                <div class="row">
	                    <div class="col-lg-4">           
	                
	                	  <div class="form-group">
	                         
	                         <span class="input-group-addon">
	                          <label for="enable">Ingrese un número de requerimiento:</label>
                        	  <input class="form-control" name = "numero" id="numero" maxlength ="5" value = "${numero}"  />                	  
                        	 
	                                                 
	                         </span>
	                      </div>            
	                
	                	  <button class="btn btn-default">Buscar</button>
	                	  
	                	  <label class = "error">${error}</label>
	                	  
	                	  <br></br>
	                	  
	                	  </div>            	                 	  
	                	  
	                 </div>           	  
               
                 </form>           
                 
                          <c:if test="${!tareas.isEmpty()}">		
                          
                          <h5 align = "center"> SEGUIMIENTO DEL REQUERIMIENTO: ${numero}</h5>			 
							
							<span class="input-group-addon">
					
							<table id="tabla" class="display" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Numero</th>
										<th>Título</th>	
										<th>Empleado</th>	
										<th>Fecha</th>
										<th>Horas asignadas</th>													
																
									</tr>
								</thead>
			
								<tfoot>
									<tr>
									   <th>Numero</th>
									   <th>Título</th>	
									   <th>Empleado</th>
									   <th>Fecha</th>	
									   <th>Horas asignadas</th>									
									
									</tr>
								</tfoot>
			
								<tbody>
			
									<c:forEach items="${tareas}" var="t">
										<tr align = "left">
											<td>${t.requerimiento.numero}</td>
											<td>${t.requerimiento.descripcion}</td>	
											<td>${t.empleado.nombre} ${t.empleado.apellido}</td>		
											<td>${t.fecha}</td>	
											<td>${t.horas}</td>			
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
							</span>
							
							
							<h3>TOTAL DE HORAS ASIGNADAS AL REQUERIMIENTO INDICADO: ${total}</h3>	
							
						
						</c:if>
						
						<c:if test="${tareas.isEmpty()}">
						
						<div class="row">
							<div class="descripcion">
								
								<h5 align = "center"> NO HAY TAREAS CARGADAS PARA EL REQUERIMIENTO INDICADO O EL MISMO NO EXISTE</h5>
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
 
