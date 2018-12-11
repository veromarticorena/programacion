 <%@ include file="../Header.jsp"%> 
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="inicio-desarrollador"><i class="fa fa-fw fa-home"></i> Inicio</a>
                    </li>
					<li>
                        <a href="requerimientos-desarrollador"><i class="fa fa-fw fa-book"></i> Requerimientos </a>
                    </li>
                    <li class = "active">
                        <a href="licencias-desarrollador"><i class="fa fa-fw fa-pencil-square-o"></i> Licencias </a>
                    </li>
                    <li>
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
                           Mis licencias <small>| Desarrollador</small>
                        </h1>
                       
                    </div>
                </div>
                <!-- /.row -->

				<br></br>
                <!-- /.row -->
				

				
				<!-- INICIO - CUADROS DEL CENTRO -->
				<!--  -->
                <div class="row">
                
                   
                      	<c:if test="${!licencias.isEmpty()}">					 
							
							<span class="input-group-addon">
					
							<table id="tabla" class="display" cellspacing="0" width="100%">
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
			
									<c:forEach items="${licencias}" var="licencia">
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
						
						<c:if test="${licencias.isEmpty()}">
						
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