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
                        <a href="licencias-desarrollador"><i class="fa fa-fw fa-pencil-square-o"></i> Licencias </a>
                    </li>
                    <li>
                        <a href="tareas-desarrollador"><i class="fa fa-fw fa-tasks"></i> Tareas</a>
                    </li>                  

                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
		
		 <!-- FIN - MENU NAVEGACI�N -->
		 
            <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                          Mis requerimientos asignados <small>| Desarrollador</small>
                        </h1>
                       
                    </div>
                </div>
                <!-- /.row -->

				<br></br>
                <!-- /.row -->
				

				
				<!-- INICIO - CUADROS DEL CENTRO -->
				<!--  -->
                <div class="row">
                
                 
           			                   
                      	<c:if test="${!requerimientos.isEmpty()}">					 
							
							<span class="input-group-addon">
					
							<table id="tabla" class="display" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>N�mero</th>
										<th>T�tulo</th>													
																	
									</tr>
								</thead>
			
								<tfoot>
									<tr>
									    <th>N�mero</th>
										<th>T�tulo</th>												
											
									</tr>
								</tfoot>
			
								<tbody>
			
									<c:forEach items="${requerimientos}" var="requerimiento">
										<tr align = "left">
											<td>${requerimiento.requerimiento.numero}</td>
											<td>${requerimiento.requerimiento.descripcion}</td>																	
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
							</span>
								
							
						
						</c:if>
						
						<c:if test="${requerimientos.isEmpty()}">
						
						<div class="row">
							<div class="descripcion">
								
								<h5 align = "center"> NO HAY REQUERIMIENTOS CARGADOS POR EL MOMENTO</h5>
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