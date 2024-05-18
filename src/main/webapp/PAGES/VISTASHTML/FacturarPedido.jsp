<%-- 
    Document   : Producto
    Created on : 25 abr. 2024, 11:06:32 a. m.
    Author     : WHC2G
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
        <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>SS</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.0/font/bootstrap-icons.css" rel="stylesheet">

                <link href="PAGES/VISTASCSS/EstilosMenu.css" rel="stylesheet">
                <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
                <!-- Font Awesome para iconos -->
                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

                <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
        </head>
        <body>

                <!-- Barra de navegación -->
                <nav class="navbar ">
                        <div class="container-fluid">
                                <span class="navbar-brand mb-0 h1"><i class="fas fa-file-invoice-dollar me-2"></i> FACTURAR PEDIDO</span>
                                <a href="Controlador?menu=Principal"> MENU PRINCIPAL</a>
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
         
                <div class="col-sm-8">
                                <br>
                                <div class="text-sm-end">
                  
                                      <table class="table table-hover" >
                                                        <!-- Encabezados de la tabla aquí -->
                                                    <thead>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Cantidad</th>
        <th>Precio</th>
        <th>Subtotal</th>
        <th>Descuento</th>
        <th>Resultado</th>
    </tr>
</thead>
<tbody>
    <tr>
        <td>8</td>
        <td>9</td>
        <td>10</td>
        <td>11</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
</tbody>

                                                     

                                                </table>
                  
                                </div>
                </div>
                  
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                         <script>

                            const sidebar = document.getElementById('sidebar');
                            const sidebarToggle = document.getElementById('sidebarToggle');

                            sidebarToggle.addEventListener('click', () => {
                                sidebar.classList.toggle('active');
                            });
                            function regresarMenuPrincipal() {
                                // Redirigir al usuario a MENU PRINCIPAL
                                window.location.href = "../../MENUPRINCIPAL.jsp";
                            }
                            function cerrarSesion() {
                                // Redirigir al usuario a la página index
                                window.location.href = "../../index.html";
                            }


                        </script>    
                        
        </body>
</html>