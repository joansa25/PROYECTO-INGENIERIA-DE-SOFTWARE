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
<button class="btn btn-primary btn-custom btn-custom-left mx-3" onclick="tomarPedido()">
    <i class="fas fa-shopping-cart me-2"></i> Tomar Pedido
</button>
<button class="btn btn-success btn-custom btn-custom-left mx-3" onclick="facturar()">
    <i class="fas fa-file-invoice-dollar me-2"></i> Facturar
</button>

            </div>
        </div>
        <div class="col-md-12">
            <div class="footer">
                <p><i class="fas fa-code"></i> Desarrollado Por</p>
                <p><i class="fas fa-globe"></i> www.SystemsServicesM.net</p>
                <p><i class="fas fa-phone"></i> (+502) 37622971</p>
                <p><i class="fas fa-mobile-alt"></i> (+502) 30398654</p>
            </div>
        </div>
    </div>
</div>
<!-- Botón para mostrar/ocultar la barra lateral -->
<button class="sidebar-toggle" id="sidebarToggle">☰</button>

<!-- Barra lateral -->
<div class="sidebar" id="sidebar">
    <ul>
        <li><a href="Controlador?menu=Empleado"><i class="fas fa-box"></i> Productos</a></li>
        <li><a href="Controlador?menu=Cliente"><i class="fas fa-users"></i> Clientes</a></li>
        <li><a href="Controlador?menu=Marca"><i class="fas fa-truck"></i> Proveedores</a></li>
        <li><a href="Controlador?menu=Proveedores"><i class="fas fa-tags"></i> Marcas</a></li>
    </ul>
</div>

<!-- Scripts de Bootstrap y jQuery -->
<!-- Scripts de Bootstrap y jQuery -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<script src="PAGES/SCRIPTS/JSmenu.js"></script>



</body>
</html>
