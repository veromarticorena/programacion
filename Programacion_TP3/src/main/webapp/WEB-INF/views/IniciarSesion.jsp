<!DOCTYPE html>
<html>
<head>
   

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Software Company - Gestion de licencias </title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/sb-admin.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	</head>

    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Software Company - Gestion de licencias</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">

                <li class="dropdown">
                    <a href="./IniciarSesion.jsp" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Iniciar sesión <b class="caret"></b></a>
               
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->

        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                    <h1 class="page-header"> Iniciar sesión</h1>  
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">

						<form action = "login" method ="post">
                        
                            <br></br>
                            
                            <div id = "page-iniciar"> 
				
                            <div class="form-group">
                                <label>Legajo</label>
                                <input class="form-control" placeholder="Ingrese su legajo" name = "legajo">                               
                            </div>

                            <div class="form-group">
                                <label>Contraseña</label>
                                <input type ="password" class="form-control" placeholder="Ingrese su contraseña" name = "password">
                            </div>
                            
                            <br></br>
                            
                            <label class="error">${Message}</label>
                            
                            <br></br>

                            <button class="btn btn-default">Iniciar</button>
                            
                            
                            </div>
                            
                            <br></br>
                            <br></br>
                            <br></br>
                                      
                 

                        </form>

                    </div>
                    
                    </div>

                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
 



    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>		 


	</body>
</html>