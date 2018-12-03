 <%@ include file="../Header.jsp"%> 
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="inicio-desarrollador"><i class="fa fa-fw fa-home"></i> Inicio</a>
                    </li>
					<li class="active">
                        <a href="requerimientos-desarrollador"><i class="fa fa-fw fa-book"></i> Requerimientos </a>
                    </li>
                    <li>
                        <a href="licencias"><i class="fa fa-fw fa-pencil-square-o"></i> Licencias </a>
                    </li>
                    <li>
                        <a href="tareas"><i class="fa fa-fw fa-tasks"></i> Tareas</a>
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
                           Software Company - Gestion de licencias <small>| Desarrollador</small>
                        </h1>
                       
                    </div>
                </div>
                <!-- /.row -->

				<br></br>
                <!-- /.row -->
				

				
				<!-- INICIO - CUADROS DEL CENTRO -->
				<!--  -->
                <div class="row">
                
                <form method = "post" action = "cargar-rq">     
                
                <div class="row">
                    <div class="col-lg-4">           
                
                	  <div class="form-group">
                         
                         <span class="input-group-addon">
                         <label for="enable">Número de requerimiento</label>
                         <input class="form-control" name = "numero" id="disabledInput" type="text"  placeholder="Ingrese un número" maxlength ="5" value = "${numero}" />                                
                         
                         <br>
                         <label for="enable">Titulo</label>
                         <input class="form-control" name = "titulo" id="disabledInput" type="text"  placeholder="Ingrese un titulo"  maxlength ="100" value = "${titulo}"/>            
                         </span>
                      </div>            
                
                	  <button class="btn btn-default">Cargar nuevo requerimiento</button>
                	  
                	  <br></br>
                	   <br></br> 
                	  
                	  </div>
                	  
                	   <label class = "error">${error}</label>
                	  <label class = "confirmacion">${confirmacion}</label>
                 </div>    
                 
                       	  
               
                 </form>
                 
           				<label class = "confirmacion">${mensaje}</label>
                    
                      	<c:if test="${!requerimientos.isEmpty()}">					 
							
							<span class="input-group-addon">
					
							<table id="tabla" class="display" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Número</th>
										<th>Título</th>													
										<th>Eliminar</th>									
									</tr>
								</thead>
			
								<tfoot>
									<tr>
									    <th>Número</th>
										<th>Título</th>												
										<th>Eliminar</th>	
									</tr>
								</tfoot>
			
								<tbody>
			
									<c:forEach items="${requerimientos}" var="requerimiento">
										<tr align = "left">
											<td>${requerimiento.numero}</td>
											<td>${requerimiento.descripcion}</td>							
											<td>											
											<button class="btn btn-default"
								                onclick="window.location.href='<%=request.getContextPath() %>/eliminar-${requerimiento.idRequerimiento}'">
								                Eliminar
							  					</button>										
											</td>								
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
							</span>
								
							
						
						</c:if>
						
						<c:if test="${requerimientos.isEmpty()}">
						
						<div class="row">
							<div class="descripcion">
								
								<h5> NO HAY REQUERIMIENTOS CARGADOS POR EL MOMENTO</h5>
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