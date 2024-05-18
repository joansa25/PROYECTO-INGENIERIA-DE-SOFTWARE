<%-- 
    Document   : Producto
    Created on : 25 abr. 2024, 11:06:32 a. m.
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
                <link href="PAGES/VISTASCSS/EstilosMenu.css?v=2" rel="stylesheet">
                <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
                <!-- Font Awesome para iconos -->
                <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
        </head>
        <body>

                <!-- Barra de navegación -->
                <nav class="navbar ">
                        <div class="container-fluid">
                                <span class="navbar-brand mb-0 h1">PROVEEDORES</span>
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
                </div>
                <div class="d-flex">
                        <div class="card col-sm-3 form-control-no-border">
                                <div class="card-body">
                                        <form action="Controlador?menu=Empleado" method="POST">
                                                <div class="form-group">
                                                        <label>Dni</label>
                                                        <input type="text" value="${empleado.getDni()}" name="txtDni" class="form-control">

                                                </div>
                                                <div class="form-group">
                                                        <label>Nombres</label>
                                                        <input type="text" value="${empleado.getNom()}" name="txtNombres" class="form-control">
                                                </div>                                <div class="form-group">
                                                        <label>Telefono</label>
                                                        <input type="text" value="${empleado.getTel()}" name="txtTel" class="form-control">
                                                </div>                                <div class="form-group">
                                                        <label>Estado</label>
                                                        <input type="text" value="${empleado.getEstado()}" name="txtEstado" class="form-control">
                                                </div>                                <div class="form-group">
                                                        <label>Usuario</label>
                                                        <input type="text" value="${empleado.getUser()}" name="txtUser" class="form-control">
                                                </div>
                                                <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                                                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">

                                        </form>
                                </div>
                        </div>
                        <div class="col-sm-8">
                                <table class="table table-hover">
                                        <thead>
                                                <tr>
                                                        <th>CODIGO </th>
                                                        <th>NOMBRE</th>
                                                        <th>DESCRIPCION</th>
                                                        <th>CORREO</th>
                                                        <th>DIRECCION</th>
                                                        <th>TELEFONO</th>
                                                        <th>NIT</th>

                                                </tr>
                                        </thead>
                                        <tbody>
                                                <c:forEach var="pr" items="${proveedores}">
                                                    <tr>
                                                            <td>${pr.getCodProv()}</td>
                                                            <td>${pr.getNomProv()}</td>
                                                            <td>${pr.getDescProv()}</td>
                                                            <td>${pr.getCorreoProv()}</td>
                                                            <td>${pr.getDireProv()}</td>
                                                            <td>${pr.getTelProv()}</td>
                                                            <td>${pr.getNitProv()}</td>
                                                            <td>
                                                                    <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}" >Editar</a>
                                                                    <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Delete&id=${em.getId()}" >Delete</a>
                                                            </td>
                                                    </tr>
                                                </c:forEach>
                                        </tbody>
                                </table>
                        </div>
                </div>

                <!-- Scripts de Bootstrap y jQuery -->
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
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
                <!-- /* <script src="../JS/.js"></script>*/-->


        </body>
</html>
