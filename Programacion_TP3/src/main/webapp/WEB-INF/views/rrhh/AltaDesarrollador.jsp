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
                    <div class="col-lg-6">

                        <form action = "<%=request.getContextPath() %>/guardar-empleado?rol=${1}" method ="post">
						
						    <div class="form-group">
                               <label for="enable">Legajo</label>
                               <input class="form-control" id="disabledInput" type="text" placeholder="${empleado.legajo.idLegajo}" disabled>
                                
                            </div>
								
							<div class="form-group">
                                <label>* Documento de identidad</label>
                                <input class="form-control" name = "dni" value = "${dni}">     
                                <label class="error">${validacion.dniError}</label>                             
                            </div>	

                            <div class="form-group">
                                <label> * Nombre</label>
                                <input class="form-control" name = "nombre" value = "${nombre}">  
                                <label class="error">${validacion.nombreError}</label>                             
                            </div>

                            <div class="form-group">
                                <label>* Apellido</label>
                                <input class="form-control" name = "apellido" value = "${apellido}">    
                                <label class="error">${validacion.apellidoError}</label>                                  
                                                  
                            </div>
                            
                            <div class="form-group">
                                <label>* Fecha de Nacimiento</label>
                                <input class="form-control" name = "fechaNac" id = "fechaNac" value = "${fechaNac}">                                                                
                                                              
                            </div>
                            
                            <div class="form-group">
                                <label>* Fecha de Ingreso</label>
                                <input class="form-control" name = "fechaIng" id = "fechaIng" value = "${fechaIng}">                                                                
                                                              
                            </div>
                            
                            <div class="form-group">
                                <label>* Telefono</label>
                                <input class="form-control" name = "telefono" value = "${telefono}">
                                <p class="help-block">02320443439</p>
                                <label class="error">${validacion.telefonoError}</label>
                            </div>

                            <div class="form-group">
                                <label>* E-Mail</label>
                                <input class="form-control" name = "email" value = "${email}">
                                <p class="help-block">email@example.com</p>
                                <label class="error">${validacion.emailError}</label>
                            </div>
                            
                             <div class="form-group">
                                <label>* Ingrese una contraseña: </label>
                                <input class="form-control" name = "contrasenia" value = "${contrasenia}">
                                
                            </div>
                                                                      
                                <label class="error" align = "right">${validacion.camposObligatorios}</label>
                                <label class="error" align = "right">${error}</label>
                                <label class="confirmacion" align = "right">${mensaje}</label>
                          
												
							<br></br>
									
							<button type="submit" class="btn btn-default">Guardar empleado</button>
							
							<br></br>


						</form>	
                           
                    </div>

                </div>
                
                
                
                
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
	
    
 <%@ include file="../Footer.jsp"%> 
 
 <!-- Calendario -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="js/jquery.ui.datepicker-es.js"></script>
	<script>
		$(function() {
			$.datepicker.setDefaults($.datepicker.regional["es"]);
			$("#fechaNac").datepicker({
				firstDay : 1,
				dateFormat : 'yy-mm-dd',
				changeMonth : true,
				changeYear : true,
				maxDate : "-18Y",
				yearRange: '-100:+0'
			});
		});
	</script>
	
	<script>
		$(function() {
			$.datepicker.setDefaults($.datepicker.regional["es"]);
			$("#fechaIng").datepicker({
				firstDay : 1,
				dateFormat : 'yy-mm-dd',
				changeMonth : true,
				changeYear : true,
				yearRange: '-1:+0'
			});
		});
	</script>
                