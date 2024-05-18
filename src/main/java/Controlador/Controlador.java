package Controlador;

import Modelo.Articulo;
import Modelo.ArticuloDao;
import Modelo.Cliente;
import Modelo.ClienteDao;
import Modelo.DetPedido;
import Modelo.DetPedidoDao;
import Modelo.Empleado;
import Modelo.EmpleadoDao;
import Modelo.Marca;
import Modelo.MarcaDao;
import Modelo.Proveedor;
import Modelo.ProveedorDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author WHC2G
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDao edao = new EmpleadoDao();
    Articulo ar = new Articulo();
    ArticuloDao adao = new ArticuloDao();
    Marca ma = new Marca();
    MarcaDao madao = new MarcaDao();
    Proveedor pr = new Proveedor();
    ProveedorDao prdao = new ProveedorDao();
    Cliente cl = new Cliente();
    ClienteDao cldao = new ClienteDao();
    int ide;
    int acan;
    String acod;
    DetPedido dp = new DetPedido();
    DetPedidoDao dpdao = new DetPedidoDao();
    int numeroSerie;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        System.out.println("Valor de 'menu': " + menu);
        System.out.println("Valor de 'accion': " + accion);
        ArticuloDao articuloDao = null;
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("PAGES/VISTASHTML/MENUPRINCIPAL.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    return;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    return;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    return;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    return;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("PAGES/VISTASHTML/Empleados.jsp").forward(request, response);
        }
        if (menu.equals("Articulos")) {
            switch (accion) {
                case "Listar":
                    articuloDao = new ArticuloDao();
                    int registrosPorPagina = 5; // Cambia esto según tus necesidades
                    int paginaActual = 1; // Página predeterminada si no se proporciona ninguna en la solicitud
                    String paginaParam = request.getParameter("pagina");

                    // Verificar si se proporciona el parámetro de la página
                    if (paginaParam != null && !paginaParam.isEmpty()) {
                        paginaActual = Integer.parseInt(paginaParam);
                    }

                    // Obtener el total de páginas
                    List<Articulo> totalArticulos = articuloDao.listar();
                    int totalPaginas = (int) Math.ceil((double) totalArticulos.size() / registrosPorPagina);

                    // Obtener la lista de artículos para la página actual
                    List<Articulo> articulos = articuloDao.listar(paginaActual);

                    // Establecer atributos para enviar al JSP
                    request.setAttribute("articulos", articulos);
                    request.setAttribute("totalPaginas", totalPaginas);
                    request.setAttribute("paginaActual", paginaActual);
                    break;
                case "agregar":
                    String ArtCod = request.getParameter("txtArtCod");
                    String ArNom = request.getParameter("txtArNom");
                    String MarNom = request.getParameter("txtMarNom");
                    acan = Integer.parseInt(request.getParameter("txtArtCan"));

                    ar.setArtCod(ArtCod);
                    ar.setArNom(ArNom);
                    ar.setMarNom(MarNom);
                    ar.setArtCan(acan);

                    adao.agregar(ar);
                    request.getRequestDispatcher("Controlador?menu=Articulos&accion=Listar").forward(request, response);
                    return;
                case "Editar":

                    String aCod = request.getParameter("artCod");
                    System.out.println("Valor de 'artCod': " + aCod); // Agregar esta línea

                    Articulo a = adao.listaracod(aCod);
                    request.setAttribute("articulo", a);

                    System.out.println("Código de Producto: " + a.getArtCod());
                    System.out.println("Nombre de Producto: " + a.getArNom());
                    System.out.println("Marca: " + a.getMarNom());
                    System.out.println("Cantidad: " + a.getArtCan());
                    System.out.println(aCod);
                    request.getRequestDispatcher("Controlador?menu=Articulos&accion=Listar").forward(request, response);
                    return;
                case "Actualizar":
                    String ArtCod1 = request.getParameter("txtArtCod");
                    String ArNom1 = request.getParameter("txtArNom");
                    String MarNom1 = request.getParameter("txtMarNom");
                    acan = Integer.parseInt(request.getParameter("txtArtCan"));

                    ar.setArtCod(ArtCod1);
                    ar.setArNom(ArNom1);
                    ar.setMarNom(MarNom1);
                    ar.setArtCan(acan);

                    adao.actualizar(ar);
                    request.getRequestDispatcher("Controlador?menu=Articulos&accion=Listar").forward(request, response);
                    return;
                case "Delete":
                    aCod = request.getParameter("artCod");
                    adao.delete(aCod);
                    request.getRequestDispatcher("Controlador?menu=Articulos&accion=Listar").forward(request, response);
                    return;
                case "BuscarPorCodigo":
                    String codigo = request.getParameter("codigo");
                    articuloDao = new ArticuloDao();
                    articulos = articuloDao.buscarPorCodigo(codigo);

// Convertir la lista de artículos a HTML
                    StringBuilder htmlBuilder = new StringBuilder();
                    htmlBuilder.append("<form action='Controlador?menu=Articulos' method='POST'>"); // Formulario fuera del bucle
                    htmlBuilder.append("<table>");
                    for (Articulo articulo : articulos) {
                        htmlBuilder.append("<tr>");
                        htmlBuilder.append("<td>").append(articulo.getArtCod()).append("</td>");
                        htmlBuilder.append("<td>").append(articulo.getArNom()).append("</td>");
                        htmlBuilder.append("<td>").append(articulo.getMarNom()).append("</td>");
                        htmlBuilder.append("<td>").append(articulo.getArtCan()).append("</td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtArtCod' value='").append(articulo.getArtCod()).append("'></td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtArNom' value='").append(articulo.getArNom()).append("'></td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtMarNom' value='").append(articulo.getMarNom()).append("'></td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtArtCan' value='").append(articulo.getArtCan()).append("'></td>");

                        htmlBuilder.append("<a class=\"btn btn-warning\" href=\"Controlador?menu=Articulos&accion=Editar&artCod=").append(articulo.getArtCod()).append("\">Editar</a>");
                        htmlBuilder.append("<a class=\"btn btn-danger\" href=\"Controlador?menu=Articulos&accion=Delete&artCod=").append(articulo.getArtCod()).append("\">Delete</a>");

                        htmlBuilder.append("</tr>");
                    }
                    htmlBuilder.append("</table>");
                    htmlBuilder.append("</form>"); // Cerrar el formulario al final del bucle

                    String htmlResponse = htmlBuilder.toString();
// Enviar la respuesta al cliente
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(htmlResponse);
                    return;

                // buscar por nombre
                case "BuscarPorNombre":
                    String nombre = request.getParameter("nombre");
                    articuloDao = new ArticuloDao();
                    articulos = articuloDao.buscarPorNombre(nombre);
                    // Convertir la lista de artículos a HTML

                    htmlBuilder = new StringBuilder();
                    htmlBuilder.append("<form action='Controlador?menu=Articulos' method='POST'>"); // Formulario fuera del bucle
                    htmlBuilder.append("<table>");

                    for (Articulo articulo : articulos) {
                        htmlBuilder.append("<tr>");
                        htmlBuilder.append("<td>").append(articulo.getArtCod()).append("</td>");
                        htmlBuilder.append("<td>").append(articulo.getArNom()).append("</td>");
                        htmlBuilder.append("<td>").append(articulo.getMarNom()).append("</td>");
                        htmlBuilder.append("<td>").append(articulo.getArtCan()).append("</td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtArtCod' value='").append(articulo.getArtCod()).append("'></td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtArNom' value='").append(articulo.getArNom()).append("'></td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtMarNom' value='").append(articulo.getMarNom()).append("'></td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtArtCan' value='").append(articulo.getArtCan()).append("'></td>");
                        htmlBuilder.append("<a class=\"btn btn-warning\" href=\"Controlador?menu=Articulos&accion=Editar&artCod=").append(articulo.getArtCod()).append("\">Editar</a>");
                        htmlBuilder.append("<a class=\"btn btn-danger\" href=\"Controlador?menu=Articulos&accion=Delete&artCod=").append(articulo.getArtCod()).append("\">Delete</a>");

                        htmlBuilder.append("</tr>");
                    }
                    htmlBuilder.append("</table>");
                    htmlBuilder.append("</form>"); // Cerrar el formulario al final del bucle
                    htmlResponse = htmlBuilder.toString();
                    // Enviar la respuesta AJAX al cliente
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(htmlResponse);
                    return;

                default:
                    throw new AssertionError();

            }
            List lista = madao.listar();
            request.setAttribute("marcas", lista);
            request.getRequestDispatcher("PAGES/VISTASHTML/Articulos.jsp").forward(request, response);
            return;
        }
        if (menu.equals("Marcas")) {
            switch (accion) {
                case "Listar":
                    List lista = madao.listar();
                    request.setAttribute("marcas", lista);
                    break;
                case "Agregar":
                    String marCod = request.getParameter("txtMarCod"); // Obtener el código de la marca
                    String marNom = request.getParameter("txtMarNom"); // Obtener el nombre de la marca
                    // Crear una instancia de Marca y configurar los atributos
                    ma.setMarCod(marCod);
                    ma.setMarNom(marNom);
                    madao.agregar(ma);

                    request.getRequestDispatcher("Controlador?menu=Marcas&accion=Listar").forward(request, response); // Redirigir a la lista de marcas después de agregar
                    break;

                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("PAGES/VISTASHTML/Marcas.jsp").forward(request, response);
            List lista = madao.listar();
            request.setAttribute("marcas", lista);
        }
        if (menu.equals("Proveedores")) {
            switch (accion) {
                case "Listar":
                    List lista = prdao.listar();
                    request.setAttribute("proveedores", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("PAGES/VISTASHTML/Proveedores.jsp").forward(request, response);
        }

        if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":
                    List lista = cldao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("PAGES/VISTASHTML/Clientes.jsp").forward(request, response);
        }
        if (menu.equals("TomarPedido")) {

            switch (accion) {
                case "Listar":

                    numeroSerie = dpdao.numeroSerie();
                    request.setAttribute("nserie", numeroSerie);

                    double desc = dp.getDesc();
                    request.setAttribute("desc", desc);
                    System.out.println("descuento = " + desc);
                    System.out.println(numeroSerie);

                    // Obtener los subtotales de la solicitud
                    String[] subtotalesStr = request.getParameterValues("subtotal");

// Verificar si se encontraron subtotales en la solicitud
                    if (subtotalesStr != null) {
                        // Iterar sobre los subtotales y convertirlos a valores numéricos
                        for (String subtotalStr : subtotalesStr) {
                            double subtotal = Double.parseDouble(subtotalStr);
                            // Imprimir cada subtotal en la consola
                            System.out.println("Subtotal: " + subtotal);
                        }
                    } else {
                        // Si no se encontraron subtotales en la solicitud, imprimir un mensaje
                        System.out.println("despues de actualizar.");
                    }

                    articuloDao = new ArticuloDao();

                    int registrosPorPagina = 5; // Cambia esto según tus necesidades
                    int paginaActual = 1; // Página predeterminada si no se proporciona ninguna en la solicitud
                    String paginaParam = request.getParameter("pagina");

                    // Verificar si se proporciona el parámetro de la página
                    if (paginaParam != null && !paginaParam.isEmpty()) {
                        paginaActual = Integer.parseInt(paginaParam);
                    }

                    // Obtener el total de páginas
                    List<Articulo> totalArticulos = articuloDao.listar();
                    int totalPaginas = (int) Math.ceil((double) totalArticulos.size() / registrosPorPagina);

                    // Obtener la lista de artículos para la página actual
                    List<Articulo> articulos = articuloDao.listar(paginaActual);

                    // Establecer atributos para enviar al JSP
                    request.setAttribute("articulos", articulos);
                    request.setAttribute("totalPaginas", totalPaginas);
                    request.setAttribute("paginaActual", paginaActual);

                    request.getRequestDispatcher("PAGES/VISTASHTML/TomarPedido.jsp").forward(request, response);

                    return;

                case "BuscarPorCodigo":
                    String codigo = request.getParameter("codigo");
                    articuloDao = new ArticuloDao();
                    articulos = articuloDao.buscarPorCodigo(codigo);

// Convertir la lista de artículos a HTML
                    StringBuilder htmlBuilder = new StringBuilder();
                    htmlBuilder.append("<form action='Controlador?menu=TomarPedido' method='POST'>"); // Formulario fuera del bucle
                    htmlBuilder.append("<table>");
                    for (Articulo articulo : articulos) {
                        htmlBuilder.append("<tr>");
                        htmlBuilder.append("<td>").append(articulo.getArtCod()).append("</td>");
                        htmlBuilder.append("<td>").append(articulo.getArNom()).append("</td>");
                        htmlBuilder.append("<td>").append(articulo.getMarNom()).append("</td>");
                        htmlBuilder.append("<td>").append(articulo.getArtCan()).append("</td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtArtCod' value='").append(articulo.getArtCod()).append("'></td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtArNom' value='").append(articulo.getArNom()).append("'></td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtMarNom' value='").append(articulo.getMarNom()).append("'></td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtArtCan' value='").append(articulo.getArtCan()).append("'></td>");
                        htmlBuilder.append("<td><a class=\"btn btn-info\" href=\"Controlador?menu=TomarPedido&accion=ag&txtArNom=").append(articulo.getArNom()).append("&txtArtCod=").append(articulo.getArtCod()).append("&txtArtCan=").append(articulo.getArtCan()).append("\" >+</a></td>");

                        htmlBuilder.append("</tr>");
                    }
                    htmlBuilder.append("</table>");
                    htmlBuilder.append("</form>"); // Cerrar el formulario al final del bucle

                    String htmlResponse = htmlBuilder.toString();
// Enviar la respuesta al cliente
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(htmlResponse);
                    break;

                // buscar por nombre
                case "BuscarPorNombre":
                    String nombre = request.getParameter("nombre");
                    articuloDao = new ArticuloDao();
                    articulos = articuloDao.buscarPorNombre(nombre);
                    // Convertir la lista de artículos a HTML

                    htmlBuilder = new StringBuilder();
                    htmlBuilder.append("<form action='Controlador?menu=TomarPedido' method='POST'>"); // Formulario fuera del bucle
                    htmlBuilder.append("<table>");

                    for (Articulo articulo : articulos) {
                        htmlBuilder.append("<tr>");
                        htmlBuilder.append("<td>").append(articulo.getArtCod()).append("</td>");
                        htmlBuilder.append("<td>").append(articulo.getArNom()).append("</td>");
                        htmlBuilder.append("<td>").append(articulo.getMarNom()).append("</td>");
                        htmlBuilder.append("<td>").append(articulo.getArtCan()).append("</td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtArtCod' value='").append(articulo.getArtCod()).append("'></td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtArNom' value='").append(articulo.getArNom()).append("'></td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtMarNom' value='").append(articulo.getMarNom()).append("'></td>");
                        htmlBuilder.append("<td><input type='hidden' name='txtArtCan' value='").append(articulo.getArtCan()).append("'></td>");
                        htmlBuilder.append("<td><a class=\"btn btn-info\" href=\"Controlador?menu=TomarPedido&accion=ag&txtArNom=").append(articulo.getArNom()).append("&txtArtCod=").append(articulo.getArtCod()).append("&txtArtCan=").append(articulo.getArtCan()).append("\" >+</a></td>");

                        htmlBuilder.append("</tr>");
                    }
                    htmlBuilder.append("</table>");
                    htmlBuilder.append("</form>"); // Cerrar el formulario al final del bucle
                    htmlResponse = htmlBuilder.toString();
                    // Enviar la respuesta AJAX al cliente
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(htmlResponse);
                    return;

                case "ag":
                    String txtArtNom = request.getParameter("txtArNom");
                    String txtArtCod = request.getParameter("txtArtCod");
                    String txtArtCan = request.getParameter("txtArtCan");
                    String txtArtC = request.getParameter("txtArtC");

                    // Imprimir el valor del parámetro en la consola del servidor
                    System.out.println("Valor de txtArNom: " + txtArtNom + "cod =" + txtArtCod);
                    request.setAttribute("txtArNom", txtArtNom);
                    request.setAttribute("txtArtCan", txtArtCan);
                    request.setAttribute("txtArtCod", txtArtCod);
                    request.setAttribute("txtArtC", txtArtC);
                    System.out.println(txtArtNom + txtArtCod + txtArtCan);
                    request.getRequestDispatcher("Controlador?menu=TomarPedido&accion=Listar").forward(request, response);
                    return;

                case "ad":
                
//d
                    String ArtNom = request.getParameter("ArtNom");
                    String ArtCod = request.getParameter("ArtCod");
                    int ArtCantd = Integer.parseInt(request.getParameter("ArtCantd"));
                    double ArtPre = Double.parseDouble(request.getParameter("ArtPre"));

                    request.setAttribute("ArtNom", ArtNom);
                    request.setAttribute("ArtCod", ArtCod);
                    request.setAttribute("ArtCantd", ArtCantd);
                    request.setAttribute("ArtPre", ArtPre);
                    DetPedido nuevoDetPedido = new DetPedido(ArtNom, ArtCod, ArtCantd, ArtNom, ArtPre);
                    List<DetPedido> listaDetPedidos = (List<DetPedido>) request.getSession().getAttribute("listaDetPedidos");

                    // Si la lista no existe en la sesión, crear una nueva lista
                    if (listaDetPedidos == null) {
                        listaDetPedidos = new ArrayList<>();
                    }

                    // Agregar el nuevo detalle de pedido a la lista
                    listaDetPedidos.add(nuevoDetPedido);
                    
             

                    // Guardar la lista de detalles de pedido en el contexto de la sesión
                    request.getSession().setAttribute("listaDetPedidos", listaDetPedidos);
                    // Redireccionar al caso "Listar" para mostrar la lista paginada
                //paginacion 
                    
                    


                    request.getRequestDispatcher("Controlador?menu=TomarPedido&accion=Listar").forward(request, response);
                    return;
                case "agregar":
                    // Obtener los arreglos de datos del formulario
                    // Obtener los arreglos de datos del formulario
//String[] comtx = request.getParameterValues("comtx");
                    String[] cArtCod = request.getParameterValues("ArtCod[]"); // Corregir el nombre del campo
                    String[] cantidades = request.getParameterValues("ArtCantd[]"); // Corregir el nombre del campo
                    String[] nomArt = request.getParameterValues("ArtNom[]"); // Corregir el nombre del campo
                    String[] precios = request.getParameterValues("ArtPre[]"); // Corregir el nombre del campo
                    String[] subtotales = request.getParameterValues("subtotales[]"); // Agregar este arreglo para los subtotales
                    String[] resultado = request.getParameterValues("Resultado[]");
                    Double totalPagar = Double.parseDouble(request.getParameter("totalaPagar"));
// Crear una lista de objetos DetPedido
                    listaDetPedidos = new ArrayList<>();

// Iterar sobre los datos recibidos y crear un objeto DetPedido para cada conjunto de datos
                    for (int i = 0; i < cArtCod.length; i++) {
                        DetPedido dp = new DetPedido(); // Crear un nuevo objeto DetPedido en cada iteración
                        // dp.setComtx(comtx[i]);
                        dp.setcArtCod(cArtCod[i]);
                        dp.setNomArt(nomArt[i]);
                        dp.setCant(Integer.parseInt(cantidades[i]));
                        dp.setPrecio(Double.parseDouble(precios[i]));
                        dp.setSubtotal(Double.parseDouble(subtotales[i])); // Establecer el subtotal para cada detalle del pedido
                        dp.setResultado(Double.parseDouble(resultado[i]));

                        // Agregar cada objeto DetPedido a la lista
                        listaDetPedidos.add(dp);
                    }
                    dp.setTotalPagar(totalPagar);

// Llamar al método agregar de DetPedidoDao y pasar la lista de DetPedido
                    dpdao.agregar(listaDetPedidos);

                    for (DetPedido detalle : listaDetPedidos) {
                        System.out.println("cArtCod: " + detalle.getcArtCod());
                        System.out.println("nomArt: " + detalle.getNomArt());
                        System.out.println("cant: " + detalle.getCant());
                        System.out.println("precio: " + detalle.getPrecio());
                        System.out.println("subtotal : " + detalle.getSubtotal());
                        System.out.println("descuento :" + detalle.getDesc());
                        System.out.println("resultado : " + detalle.getResultado());
                    }
                    System.out.println("Total a pagar cag: " + totalPagar);
                    listaDetPedidos.clear();

                    System.out.println("La listaDetPedidos se ha limpiado correctamente.");

                    request.getSession().setAttribute("listaDetPedidos", listaDetPedidos);

                    // Redireccionar después de la inserción
                    request.getRequestDispatcher("Controlador?menu=TomarPedido&accion=Listar").forward(request, response);
                    // Opcionalmente, puedes redirigir a otra página después de la inserción
                    return;

                case "eliminar":
                    // Obtener el código de artículo a eliminar desde los parámetros de la solicitud
                    String cArtCodEliminar = request.getParameter("cArtCodEliminar");

                    // Obtener la lista de detalles de pedidos de la sesión
                    listaDetPedidos = (List<DetPedido>) request.getSession().getAttribute("listaDetPedidos");

                    // Verificar si la lista existe y no está vacía
                    if (listaDetPedidos != null && !listaDetPedidos.isEmpty()) {
                        // Iterar sobre la lista para buscar el elemento con el código de artículo a eliminar
                        Iterator<DetPedido> iterator = listaDetPedidos.iterator();
                        while (iterator.hasNext()) {
                            DetPedido detalle = iterator.next();
                            if (detalle.getcArtCod().equals(cArtCodEliminar)) {
                                // Eliminar el elemento de la lista
                                iterator.remove();
                            }
                        }
                    }

                    // Actualizar la lista en el contexto de la sesión
                    request.getSession().setAttribute("listaDetPedidos", listaDetPedidos);

                    // Redirigir a la página de listado nuevamente
                    request.getRequestDispatcher("Controlador?menu=TomarPedido&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    return;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    return;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    return;
                default:
                    numeroSerie = dpdao.numeroSerie();
                    request.setAttribute("nserie", numeroSerie);
                    throw new AssertionError();
            }
        }
          if (menu.equals("FacturarPedido")) {
            switch (accion) {
                case "Listar":
                    
                                request.getRequestDispatcher("PAGES/VISTASHTML/FacturarPedido.jsp").forward(request, response);

                    break;
                
                default:
                    throw new AssertionError();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
