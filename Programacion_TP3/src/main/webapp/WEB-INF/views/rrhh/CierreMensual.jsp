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
                    <li>
                        <a href="menu-rq-rrhh"><i class="fa fa-fw fa-tasks"></i> Requerimientos</a>
                    </li>
                    <li class="active">
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
				
				
               
                 <form method = "post" action = "buscar-cierre-mes">     
                
	                 <div class="row">
	                    <div class="col-lg-4">           
	                
	                	  <div class="form-group">
	                         
	                         <span class="input-group-addon">
	                         
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
                 
                 <br>
                               
                 <form method = "post" action = "calcular" style="display: ${form2};">                 
                  <div class="row">
	                    <div class="col-lg-4">	                
	                	  <div class="form-group">                         
	                         <span class="input-group-addon">
	                         
	                         <label for="enable">Ingresar un valor hora:</label>
	                         <input class="form-control" name = "valor" id="valor" maxlength ="5" value = "${valor}"  />
	                         
	                         <label class = "error">${errorValor}</label>     
	                         <br>          	  
	                         <button class="btn btn-default">Calcular</button>
	                         
	                         <br>
	                         <br>
	                         <a href="descargar">Descargar informacion</a>
	                         
	                         </span>
	                         
	                      </div>   
                 		</div>
                  </div>
                 </form>
              
                 
               
                 
                     <c:if test="${!cierre.isEmpty()}">	
                     	<h3 align = "center"> CIERRE MES DE ${nombreMes} DEL AÑO ${anio}</h3>				 
							
							<span class="input-group-addon">
					
							<table id="tabla2" class="display" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>Legajo empleado</th>
										<th>Nombre</th>													
										<th>Apellido</th>	
										<th>Horas trabajadas</th>	
										<th>Horas de licencia</th>
										<th>Total</th>			
										<th>Remuneracion por horas</th>						
									</tr>
								</thead>
			
								<tfoot>
									<tr>
									  	<th>Legajo empleado</th>
										<th>Nombre</th>													
										<th>Apellido</th>	
										<th>Horas trabajadas</th>	
										<th>Horas de licencia</th>										
										<th>Total</th>			
										<th>Remuneracion por horas</th>	
									</tr>
								</tfoot>
			
								<tbody>
			
									<c:forEach items="${cierre}" var="c">
										<tr align = "center">
											<td>${c.legajo}</td>
											<td>${c.nombre}</td>
											<td>${c.apellido}</td>
											<td>${c.horas_trabajadas}</td>
											<td>${c.horas_licencia}</td>													
											<td>${c.total_horas}</td>	
											<td>${c.valor_total_horas}</td>		
													
																			
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
							</span>
								
							
						
						</c:if>
						
						
				
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
