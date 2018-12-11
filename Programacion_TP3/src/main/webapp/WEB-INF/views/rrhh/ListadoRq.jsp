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
                           Requerimientos | <small>Recursos Humanos</small>
                        </h1>
                       
                    </div>
                </div>
                <!-- /.row -->

           
                 
                          <c:if test="${!requerimientos.isEmpty()}">		
                          
                          <h5 align = "center"> LISTADO DE REQUERIMIENTOS VIGENTES</h5>			 
							
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
								                onclick="window.location.href='<%=request.getContextPath() %>/eliminar-requerimiento?numero=${requerimiento.numero}'">
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
								
								<h5 align = "center"> NO HAY REQUERIMIENTOS CARGADOS POR EL MOMENTO</h5>
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
 
