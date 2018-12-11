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
                          Cargar y asignar requerimiento | <small>Recursos Humanos</small>
                        </h1>
                       
                    </div>
                </div>
                <!-- /.row -->

                <form method = "post" action = "cargar-rq">     
                
                <div class="row">
                    <div class="col-lg-4">           
                
                	  <div class="form-group">
                         
                         <span class="input-group-addon">
                         <label for="enable">Número de requerimiento</label>
                         <input class="form-control" name = "numero" id="numero" type="text"  placeholder="Ingrese un número" maxlength ="5" value = "${numero}" />                                
                         
                         <br>
                         <label for="enable">Titulo</label>
                         <input class="form-control" name = "titulo" id="titulo" type="text"  placeholder="Ingrese un titulo"  maxlength ="100" value = "${titulo}"/> 
                         
                         <br>
                                    
                          <button class="btn btn-default">Cargar requerimiento</button>
                         </span>
                      </div>                      
                	
                	  
                	   <br></br>
                	   <br></br> 
                	  
                	  </div>
                	  
                	   <label class = "error">${error}</label>
                	   <label class = "confirmacion">${confirmacion}</label>
                
                 </div>    
                 
                       	  
               
                 </form>
                 
               
                 	 
                        	
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
 
