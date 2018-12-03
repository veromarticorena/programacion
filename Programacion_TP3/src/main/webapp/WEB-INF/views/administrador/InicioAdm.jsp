 <%@ include file="../Header.jsp"%> 
 
 
 
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="inicio-rrhh"><i class="fa fa-fw fa-home"></i> Inicio</a>
                    </li>
					<li>
                        <a href="menu-empleados-adm"><i class="fa fa-fw fa-book"></i> Empleados </a>
                    </li>
                    <li>
                        <a href="menu-licencias-adm"><i class="fa fa-fw fa-pencil-square-o"></i> Licencias </a>
                    </li>
                    <li>
                        <a href="menu-tareas-adm"><i class="fa fa-fw fa-tasks"></i> Tareas</a>
                    </li>
                    <li>
                        <a href="menu-cierre-adm"><i class="fa fa-fw fa-tasks"></i> Restablecer saldos </a>
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
                           Software Company - Gestion de licencias | <small>Administrador</small>
                        </h1>
                       
                    </div>
                </div>
                <!-- /.row -->

				<br></br>
                <!-- /.row -->
				
				
				<!-- INICIO - CUADROS DEL CENTRO -->
				<!--  -->
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-book fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${cantidadAlumnos}</div>
                                        <div>Alumnos</div>
                                    </div>
                                </div>
                            </div>
                            <a href="ListaAlumnos">
                                <div class="panel-footer">
                                    <span class="pull-left">Ver lista</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
					
					
                    <div class="col-lg-6 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-plane fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${cantidadDocentes}</div>
                                        <div>Profesores</div>
                                    </div>
                                </div>
                            </div>
                            <a href="ListaDocentes">
                                <div class="panel-footer">
                                    <span class="pull-left">Ver lista</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div> 
                </div>
                <!-- /.row -->
				
				<br></br>

				
				<!-- FIN - CUADROS DEL CENTRO -->
				
				
				
                

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
	
    
 <%@ include file="../Footer.jsp"%> 
