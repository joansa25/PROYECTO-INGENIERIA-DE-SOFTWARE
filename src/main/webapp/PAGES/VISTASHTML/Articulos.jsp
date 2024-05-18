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
                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

                <!-- Font Awesome para iconos --> 
                <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
        </head>
        <body>

                <!-- Barra de navegación -->
                <nav class="navbar ">
                        <div class="container-fluid">
                                <span class="navbar-brand mb-0 h1">Productos</span>
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
                                        <form action="Controlador?menu=Articulos" method="POST">
                                                <div class="form-group">
                                                        <label>Cod Producto</label>
                                                        <input type="text" value="${articulo.getArtCod()}" name="txtArtCod" class="form-control">


                                                </div>
                                                <div class="form-group">
                                                        <label>Nombre Producto</label>
                                                        <input type="text" value="${articulo.arNom}" name="txtArNom" class="form-control">
                                                </div>                    <div class="form-group">
                                                        <label>Marca</label>
                                                        <label>Marca</label>
                                                        <select name="txtMarNom" class="form-control">
                                                                <c:forEach var="ma" items="${marcas}">
                                                                    <option value="${ma.marNom}"> ${ma.marNom}</option>
                                                                </c:forEach>
                                                        </select>


                                                </div>
                                                <div class="form-group">
                                                        <label>Cantidad</label>
                                                        <input type="text" value="${articulo.artCan}" name="txtArtCan" class="form-control">
                                                </div>                          
                                                <input type="submit" name="accion" value="agregar" class="btn btn-info">
                                                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">

                                        </form>
                                </div>
                        </div>
                        <div class="col-sm-8">
                                <br>
                                <table class="table table-hover">
                                        <thead>
                                                <tr>
                                        <input type="text" id="searchInput" placeholder="Buscar por ID">
                                        <input type="text" id="searchInputN" placeholder="Buscar por nombre">
                                        <th>Cod</th>
                                        <th>NOMBRE ARTICULO</th>
                                        <th>MARCA</th>
                                        <th>CANTIDAD</th>


                                        </tr>
                                        </thead>
                                        <tbody id="articulosTable">
                                                <c:forEach var="ar" items="${articulos}">
                                                    <tr>
                                                            <td>${ar.getArtCod()}</td>
                                                            <td>${ar.getArNom()}</td>
                                                            <td>${ar.getMarNom()}</td>
                                                            <td>${ar.getArtCan()}</td>
                                                            <td>
                                                                    <a class="btn btn-warning" href="Controlador?menu=Articulos&accion=Editar&artCod=${ar.getArtCod()}" >Editar</a>
                                                                    <a class="btn btn-danger" href="Controlador?menu=Articulos&accion=Delete&artCod=${ar.getArtCod()}" >Delete</a>
                                                            </td>
                                                    </tr>
                                                </c:forEach>
                                        </tbody>
                                </table>
                                <nav aria-label="Page navigation example">
                                        <ul class="pagination custom-pagination">
                                                <li class="page-item ${paginaActual == 1 ? 'disabled' : ''}">
                                                        <a class="page-link" href="Controlador?menu=Articulos&accion=Listar&pagina=${paginaActual - 1}" tabindex="-1">Anterior</a>
                                                </li>
                                                <c:forEach begin="1" end="${totalPaginas}" var="i">
                                                    <li class="page-item ${paginaActual == i ? 'active' : ''}">
                                                            <a class="page-link" href="Controlador?menu=Articulos&accion=Listar&pagina=${i}">${i}</a>
                                                    </li>
                                                </c:forEach>
                                                <li class="page-item ${paginaActual == totalPaginas ? 'disabled' : ''}">
                                                        <a class="page-link" href="Controlador?menu=Articulos&accion=Listar&pagina=${paginaActual + 1}">Siguiente</a>
                                                </li>
                                        </ul>
                                </nav>
                        </div>
                </div>
                                                      <script>
                    function submitForm(rowIndex) {
                        document.getElementById('selectedRowIndex').value = rowIndex; // Establece el índice de la fila seleccionada en el campo oculto
                        document.getElementById('articulosForm').submit(); // Envía el formulario
                    }
                </script>
                <script>
                    // Define la variable searchText
                    // Define la variable searchText
                    var searchText = "";

                    // Variable para almacenar los datos originales de la tabla
                    var originalTableData;

                    // Lógica para cargar los datos originales de la tabla al cargar la página
                    $(document).ready(function () {
                        originalTableData = $('#articulosTable').html();
                    });

                    // Escuchar el evento keyup en el campo de búsqueda utilizando delegación de eventos
                    $(document).on('keyup', '#searchInput', function () {
                        // Obtener el valor del campo de búsqueda
                        var searchText = $(this).val();

                        // Realizar la solicitud AJAX solo si hay un texto de búsqueda
                        if (searchText.trim() !== '') {
                            // Realizar la solicitud AJAX con el criterio de búsqueda definido
                            $.ajax({
                                type: "GET",
                                url: "Controlador?menu=Articulos&accion=BuscarPorCodigo",
                                data: {codigo: searchText},
                                success: function (data) {
                                    console.log("Respuesta del servidor:", data); // Muestra la respuesta del servidor en la consola

                                  

                                    // Agregar las nuevas filas a la tabla
                                    $('#articulosTable').html(data);

                                    // Verificar si se encontraron resultados en la respuesta
                                    if ($('#articulosTable tr').length === 0) {
                                        console.log("No se encontraron resultados en la base de datos.");
                                    } else {
                                        console.log("Se encontraron resultados en la base de datos.");
                                    }
                                },
                                error: function (xhr, status, error) {
                                    console.error(xhr.responseText);
                                    console.error("Error al realizar la petición AJAX:", error); // Muestra el error en la consola
                                }
                            });
                        } else {
                            // Restaurar la tabla a su estado original
                            $('#articulosTable').html(originalTableData);
                        }
                    });

                    // para buscar por nombre
                    $(document).on('keyup', '#searchInputN', function () {
                        // Obtener el valor del campo de búsqueda
                        var searchText = $(this).val();

                        // Realizar la solicitud AJAX solo si hay un texto de búsqueda
                        if (searchText.trim() !== '') {
                            // Realizar la solicitud AJAX con el criterio de búsqueda definido
                            $.ajax({
                                type: "GET",
                                url: "Controlador?menu=Articulos&accion=BuscarPorNombre",
                                data: {nombre: searchText},
                                success: function (data) {
                                    console.log("Respuesta del servidor:", data); // Muestra la respuesta del servidor en la consola

                                    // Vaciar la tabla de resultados antes de agregar las nuevas filas
                                    $('#articulosTable').empty();

                                    // Agregar las nuevas filas a la tabla
                                    $('#articulosTable').html(data);

                                    // Verificar si se encontraron resultados en la respuesta
                                    if ($('#articulosTable tr').length === 0) {
                                        console.log("No se encontraron resultados en la base de datos.");
                                    } else {
                                        console.log("Se encontraron resultados en la base de datos.");
                                    }
                                },
                                error: function (xhr, status, error) {
                                    console.error(xhr.responseText);
                                    console.error("Error al realizar la petición AJAX:", error); // Muestra el error en la consola
                                }
                            });
                        } else {
                            // Restaurar la tabla a su estado original
                            $('#articulosTable').html(originalTableData);
                        }
                    });



                </script>
                <!-- Scripts de Bootstrap y jQuery -->
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
                   </script>    <script>

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
