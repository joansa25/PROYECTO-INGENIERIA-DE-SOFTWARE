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

                <link href="PAGES/VISTASCSS/EstilosMenu.css?v=2" rel="stylesheet">
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
                                <span class="navbar-brand mb-0 h1">TOMAR PEDIDO</span>
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
                                        <form action="Controlador?menu=TomarPedido" method="POST">

                                                <div class="form-group">

                                                        <button type="button" value="${articulo.arNom}" name="txtArNom" class="form-control" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                                                Seleccionar Articulo
                                                        </button>
                                                        <br>

                                                        <input type="text" name="ArtNom" value="${requestScope.txtArNom}" class="form-control text-center" readonly>
                                                        <input type="hidden" name="ArtCod" value="${requestScope.txtArtCod}">
                                                        <input type="hidden" name="ArtPre" value="${requestScope.txtArtCan}">

                                                </div>  


                                                <div class="form-group">
                                                        <label>Cantidad</label>
                                                        <input type="text"  name="ArtCantd" class="form-control text-center">
                                                </div>      
                                                <br>

                                                <button type="submit" name="accion" value="ad" class="btn btn-info">
                                                        <i class="fas fa-plus-circle"></i> Añadir
                                                </button>


                                        </form>
                                </div>
                        </div>



                        <!-- Ventana Modal -->
                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                        <div class="modal-content">
                                                <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Seleccione Articulo</h5>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                        <table class="table table-hover">
                                                                <thead>
                                                                        <!-- Barra de búsqueda -->

                                                                        <tr>
                                                                <input type="text" id="searchInput" placeholder="Buscar por ID">
                                                                <input type="text" id="searchInputN" placeholder="Buscar por nombre">
                                                                <th>ID</th>
                                                                <th>Nombre</th>
                                                                <th>Marca</th>
                                                                <th>Cantidad</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody id="articulosTable">
                                                                        <!-- Aquí se mostrarán los resultados de búsqueda -->
                                                                        <c:forEach var="articulo" items="${articulos}">
                                                                        <form action="Controlador?menu=TomarPedido"  method="POST">
                                                                                <tr>

                                                                                        <td>${articulo.artCod}</td>
                                                                                        <td>${articulo.arNom}</td>
                                                                                        <td>${articulo.marNom}</td>
                                                                                        <td>${articulo.artCan}</td>
                                                                                        <td>
                                                                                                <input type="hidden" name="txtArtCod" value="${articulo.artCod}">
                                                                                                <input type="hidden" name="txtArNom" value="${articulo.arNom}">
                                                                                                <input type="hidden" name="txtMarNom" value="${articulo.marNom}">
                                                                                                <input type="hidden" name="txtArtCan" value="${articulo.artCan}">

                                                                                        <td>
                                                                                                <a class="btn btn-info" href="Controlador?menu=TomarPedido&accion=ag&txtArNom=${articulo.getArNom()}&txtArtCod=${articulo.getArtCod()}&txtArtCan=${articulo.getArtCan()}">+</a>
                                                                                        </td>



                                                                                        </td>
                                                                                </tr>
                                                                        </form>

                                                                </c:forEach>
                                                                </tbody>
                                                        </table>
                                                </div>
                                                <style>#searchInput
                                                        {
                                                            max-width: 125px; /* Ajusta el ancho máximo según tus necesidades */
                                                        }
                                                        #searchInputN{
                                                            max-width: 200px;
                                                        }
                                                </style>

                                                <div class="modal-footer">
                                                        <nav aria-label="Page navigation example">
                                                                <ul class="pagination custom-pagination">
                                                                        <li class="page-item ${paginaActual == 1 ? 'disabled' : ''}">
                                                                                <a class="page-link" href="Controlador?menu=TomarPedido&accion=Listar&pagina=${paginaActual - 1}" tabindex="-1">Anterior</a>
                                                                        </li>
                                                                        <c:forEach begin="1" end="${totalPaginas}" var="i">
                                                                            <li class="page-item ${paginaActual == i ? 'active' : ''}">
                                                                                    <a class="page-link" href="Controlador?menu=TomarPedido&accion=Listar&pagina=${i}">${i}</a>
                                                                            </li>
                                                                        </c:forEach>
                                                                        <li class="page-item ${paginaActual == totalPaginas ? 'disabled' : ''}">
                                                                                <a class="page-link" href="Controlador?menu=TomarPedido&accion=Listar&pagina=${paginaActual + 1}">Siguiente</a>
                                                                        </li>
                                                                </ul>
                                                        </nav>

                                                </div>




                                        </div>
                                </div>
                        </div>

                        <div class="col-sm-8">
                                <br>
                                <div class="text-sm-end">

                                        <label>Nro. Transaccion</label> <input type="text" value="${nserie}"  readonly>
                                        <br><!-- comment -->
                                        <form action="Controlador?menu=TomarPedido" method="POST">
                                                <input type="hidden" name="cArtCodEliminar" value="" >

                                                <table class="table table-hover">
                                                        <!-- Encabezados de la tabla aquí -->
                                                        <tbody>
                                                        <th>ID</th>
                                                        <th>Nombre</th>
                                                        <th>Cantidad</th>
                                                        <th>Precio</th>
                                                        <th>Subtotal </th>
                                                        <th>Descuento</th>
                                                        <th>Resultado</th>
                                                                <c:forEach items="${listaDetPedidos}" var="detalle">
                                                                <tr>
                                                                        <td>${detalle.cArtCod}</td>
                                                                        <td>${detalle.nomArt}</td>
                                                                        <td>${detalle.cant}</td>
                                                                        <td>${detalle.precio}</td>
                                                                        <c:set var="subtotal" value="${detalle.cant * detalle.precio}" />
                                                                        <td>${subtotal}</td> <!-- Muestra el subtotal -->


                                                                        <td> ${desc}</td>
                                                                        <c:set var="Resultado" value="${subtotal-desc}" />
                                                                        <td>${Resultado}</td> <!-- Muestra el subtotal -->                                                                        <td>
                                                                                <!-- Campos ocultos para cada fila -->
                                                                                <input type="hidden" name="ArtCod[]" value="${detalle.cArtCod}">
                                                                                <input type="hidden" name="ArtNom[]" value="${detalle.nomArt}">
                                                                                <input type="hidden" name="ArtCantd[]" value="${detalle.cant}">
                                                                                <input type="hidden" name="ArtPre[]" value="${detalle.precio}">
                                                                                <input type="hidden" name="subtotales[]" value="${subtotal}">
                                                                                <input type="hidden" name="Resultado[]" value="${Resultado}">


                                                                                <a href="Controlador?menu=TomarPedido&accion=eliminar&cArtCodEliminar=${detalle.cArtCod}&subtotal=${subtotal}" class="btn btn-danger">
                                                                                        <i class="fas fa-trash-alt"></i>
                                                                                </a>



                                                                        </td>
                                                                </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                        <c:set var="totalPagar" value="0" />
<c:forEach items="${listaDetPedidos}" var="detalle">
    <c:set var="subtotal" value="${detalle.cant * detalle.precio}" />
    <c:set var="descuento" value="${detalle.desc}" />
    <c:set var="resultado" value="${subtotal - descuento}" />
    <c:set var="totalPagar" value="${totalPagar + resultado}" />
</c:forEach>
                                                </table>
                                </div>
                        </div>

                                                        

                                                <!-- Botón de agregar -->
                                                <div class="position-fixed bottom-0 end-0 mb-3 me-3">
                                                          <label>TOTAL A PAGAR</label>     <input type="text" name="totalaPagar" value="${totalPagar}" readonly>

                                                        <button type="submit" name="accion" value="agregar" class="btn btn-success" data-toggle="modal" data-target="#modalExito">
                                                                <i class="fas fa-check"></i>Agregar</button>
                                                                
                                                                                                      

                                                </div>
                                        </form>


                        <script>
                            $(document).ready(function () {
                                // Elimina el código existente que maneja los clics en los enlaces de paginación
                                $('#exampleModal').off('click', '.pagination a');

                                // Escucha los clics en los enlaces de paginación dentro de la ventana modal
                                $('#exampleModal').on('click', '.pagination a', function (e) {
                                    e.preventDefault(); // Evita que se ejecute el comportamiento predeterminado del enlace
                                    var url = $(this).attr('href'); // Obtiene la URL del enlace
                                    $.get(url, function (data) {
                                        $('#articulosTable').html($(data).find('#articulosTable').html()); // Actualiza solo el contenido de la tabla
                                        // Vuelve a asociar el evento de clic en el botón de agregar
                                        $('#exampleModal').on('click', '[name="accion"][value="ag"]', function (e) {
                                            e.preventDefault(); // Evita que se envíe el formulario
                                            var rowIndex = $(this).closest('tr').index(); // Obtiene el índice de la fila
                                            submitForm(rowIndex); // Llama a la función para enviar el formulario
                                        });
                                    });
                                });

                                // Función para enviar el formulario
                                function submitForm(rowIndex) {
                                    var selectedRowIndexElement = document.getElementById('selectedRowIndex');
                                    if (selectedRowIndexElement !== null) { // Verifica si el elemento existe
                                        selectedRowIndexElement.value = rowIndex; // Establece el índice de la fila seleccionada en el campo oculto
                                        document.getElementById('articulosForm').submit(); // Envía el formulario
                                    }
                                }
                            });
                        </script>



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
                                        url: "Controlador?menu=TomarPedido&accion=BuscarPorCodigo",
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
                                        url: "Controlador?menu=TomarPedido&accion=BuscarPorNombre",
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


                            // para que funcione el boton de agregar en el boton de paginacion : 
                            $(document).ready(function () {
                                // Elimina el código existente que maneja los clics en los enlaces de paginación

                                // Escucha los clics en los enlaces de paginación dentro de la ventana modal
                                $('#exampleModal').on('click', '.pagination a', function (e) {
                                    e.preventDefault(); // Evita que se ejecute el comportamiento predeterminado del enlace
                                    var url = $(this).attr('href'); // Obtiene la URL del enlace
                                    $.get(url, function (data) {
                                        $('#articulosTable').html($(data).find('#articulosTable').html()); // Actualiza solo el contenido de la tabla
                                    });
                                });
                            });

                        </script>




                        <!-- Scripts de Bootstrap y jQuery -->
                        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>

                        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

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