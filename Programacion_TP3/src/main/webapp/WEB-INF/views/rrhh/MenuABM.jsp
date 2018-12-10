<%@ include file="../Header.jsp"%> 
 
 
 
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="inicio-rrhh"><i class="fa fa-fw fa-home"></i> Inicio</a>
                    </li>
					<li class="active">
                        <a href="menu-empleados-rrhh"><i class="fa fa-fw fa-book"></i> Empleados </a>
                    </li>
                    <li>
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
                
                 <div class="col-lg-8 col-md-8">
                        <div class="panel panel-primary">
                            
                            <a href="alta-desarrollador".jsp>
                                <div class="panel-footer">
                                    <span class="pull-left">Nuevo empleado</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                  </div>
                  
                   <div class="col-lg-8 col-md-8">
                        <div class="panel panel-primary">
                            
                            <a href="baja-desarrollador".jsp>
                                <div class="panel-footer">
                                    <span class="pull-left">Eliminar empleado</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                  </div>
                  
                   <div class="col-lg-8 col-md-8">
                        <div class="panel panel-primary">
                            
                            <a href="modificar-desarrollador">
                                <div class="panel-footer">
                                    <span class="pull-left">Modificar empleado</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                   </div>
                   
                    <div class="col-lg-8 col-md-8">
                        <div class="panel panel-primary">
                            
                            <a href="listado-rrhh".jsp>
                                <div class="panel-footer">
                                    <span class="pull-left">Ver listado</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                  </div>
                
                </div>
                
                <br></br>
				<br></br>
				<br></br>
                
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
	
    
 <%@ include file="../Footer.jsp"%> 
 
 
                