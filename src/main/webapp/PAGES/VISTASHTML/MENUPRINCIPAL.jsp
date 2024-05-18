<%-- 
    Document   : MENUPRINCIPAL
    Created on : 25 abr. 2024, 10:34:57 a. m.
    Author     : WHC2G
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
        <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>DESPENSA IS</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
                <link href="PAGES/VISTASCSS/EstilosMenu.css" rel="stylesheet">
                <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
                <!-- Font Awesome para iconos -->
                <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">

        </head>
        <body>

                <!-- Barra de navegación -->
                <nav class="navbar ">
                        <div class="container-fluid">
                                <span class="navbar-brand mb-0 h1">BIENVENIDO USUARIO</span>

                                <div class="dropdown">
                                        <button class="btn btn-purple dropdown-toggle btn-outline-light" type="button" id="dropdown" data-bs-toggle="dropdown" aria-expanded="false">
                                                ${usuario.getNom()}
                                        </button>
                                        <ul class="dropdown-menu text-center">
                                                <li>
                                                        <a class="dropdown-item" href="#"><img src="PAGES/img/usuario.png" alt="60" width="60"> </a>
                                                </li>
                                                <li><a class="dropdown-item" href="#">${usuario.getUser()}</a></li>
                                                <li><a class="dropdown-item" href="#">usuario@gmail.com</a></li>
                                                <li><hr class="dropdown-divider"></li>
                                                <li>
                                                        <form action="Validar" method="POST">
                                                                <button name="accion" value="Salir" class="dropdown-item">Salir</button>
                                                        </form>
                                                </li>
                                        </ul>
                                </div>
                        </div>
                </nav>

                <!-- Contenido principal -->
                <div class="container container-custom">
                        <div class="row">
                                <!-- Botones -->
                                <div class="col-md-8">
                                        <div class="text-center">
                                                <a href="Controlador?menu=TomarPedido&accion=Listar" class="btn btn-primary btn-custom btn-custom-left mx-3">
                                                        <i class="fas fa-shopping-cart me-2"></i> Tomar Pedido
                                                </a>

                                                <a href="Controlador?menu=FacturarPedido&accion=Listar" class="btn btn-primary btn-custom btn-custom-left mx-3">
                                                        <i class="fas fa-file-invoice-dollar me-2"></i> Facturar

                                                </a>

                                        </div>
                                </div>
                                <div class="col-md-12">

                                </div>
                        </div>
                </div>
                <!-- Botón para mostrar/ocultar la barra lateral -->
                <button class="sidebar-toggle" id="sidebarToggle">☰</button>

                <!-- Barra lateral -->
                <div class="sidebar" id="sidebar">
                        <ul>
                                <li><a href="Controlador?menu=Empleado&accion=Listar"><i class="fas fa-box"></i> Empleados</a></li>
                                <li><a href="Controlador?menu=Articulos&accion=Listar"><i class="fas fa-users"></i> Articulos</a></li>
                                <li><a href="Controlador?menu=Proveedores&accion=Listar"><i class="fas fa-truck"></i> Proveedores</a></li>
                                <li><a href="Controlador?menu=Marcas&accion=Listar"><i class="fas fa-tags"></i> Marcas</a></li>
                                <li><a href="Controlador?menu=Clientes&accion=Listar"><i class="fas fa-tags"></i> Clientes</a></li>

                        </ul>
                </div>

                <!-- Scripts de Bootstrap y jQuery -->
                <!-- Scripts de Bootstrap y jQuery -->
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

                <script src="PAGES/SCRIPTS/JSmenu.js"></script>



        </body>
</html>
