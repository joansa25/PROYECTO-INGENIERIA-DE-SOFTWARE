package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WHC2G
 */
public class ArticuloDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public List listar() {
        String sql = "select ArtCod,ArtNom,MarNom,ArtCan from inv_articulo";
        List<Articulo> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Articulo ar = new Articulo();
                ar.setArtCod(rs.getString(1));
                ar.setArNom(rs.getString(2));
                ar.setMarNom(rs.getString(3));
                ar.setArtCan(rs.getInt(4));

                lista.add(ar);
            }

        } catch (Exception e) {

        }
        return lista;
    }

    public int agregar(Articulo ar) {
        String sql = "insert into inv_articulo(ArtCod,ArtNom,MarNom,ArtCan) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ar.getArtCod());
            ps.setString(2, ar.getArNom());
            ps.setString(3, ar.getMarNom());
            ps.setInt(4, ar.getArtCan());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al insertar el artículo: " + e.getMessage());
        }
        return r;
    }

    public Articulo listaracod(String acod) {
        Articulo art = new Articulo();
        String sql = "SELECT ArtCod,ArtNom,MarNom,ArtCan FROM inv_articulo WHERE ArtCod=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, acod); // Establecer el código del artículo como parámetro en la consulta SQL
            rs = ps.executeQuery();
            while (rs.next()) {
                art.setArtCod(rs.getString(1)); // Establecer el código del artículo
                art.setArNom(rs.getString(2)); // Establecer el nombre del artículo
                art.setMarNom(rs.getString(3)); // Establecer la marca del artículo
                art.setArtCan(rs.getInt(4)); // Establecer la cantidad del artículo
            }
        } catch (Exception e) {
            // Manejar la excepción apropiadamente, por ejemplo, imprimir la traza de la excepción
            e.printStackTrace();
        } finally {
            // Cerrar la conexión, PreparedStatement y ResultSet en el bloque finally
            // para asegurar que se liberen los recursos correctamente
            // Ejemplo: closeResources(con, ps, rs);
        }
        return art;
    }

    public int actualizar(Articulo ar) {
        String sql = "update inv_articulo set ArtNom=?,MarNom=?,ArtCan=? where ArtCod=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ar.getArNom());
            ps.setString(2, ar.getMarNom());
            ps.setInt(3, ar.getArtCan());
            ps.setString(4, ar.getArtCod());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al actualizar  el artículo: " + e.getMessage());
        }
        return r;
    }

    public void delete(String aCod) {
        String sql = "DELETE FROM inv_articulo WHERE ArtCod=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, aCod); // Establecer el código del artículo como parámetro en la consulta SQL
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el artículo: " + e.getMessage());
        }
    }

    public List<Articulo> listar(int pagina) {
        int registrosPorPagina = 7; // Cambia esto según tus necesidades
        int offset = (pagina - 1) * registrosPorPagina;
        String sql = "SELECT ArtCod, ArtNom, MarNom, ArtCan FROM inv_articulo LIMIT ?, ?";
        List<Articulo> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);
            ps.setInt(2, registrosPorPagina);
            rs = ps.executeQuery();
            while (rs.next()) {
                Articulo ar = new Articulo();
                ar.setArtCod(rs.getString(1));
                ar.setArNom(rs.getString(2));
                ar.setMarNom(rs.getString(3));
                ar.setArtCan(rs.getInt(4));
                lista.add(ar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Articulo> buscarPorCodigo(String codigo) {
        String sql = "SELECT ArtCod, ArtNom, MarNom, ArtCan FROM inv_articulo WHERE ArtCod LIKE ?";
        List<Articulo> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + codigo + "%"); // Buscar cualquier código que contenga el término de búsqueda
            rs = ps.executeQuery();
            while (rs.next()) {
                Articulo ar = new Articulo();
                ar.setArtCod(rs.getString(1));
                ar.setArNom(rs.getString(2));
                ar.setMarNom(rs.getString(3));
                ar.setArtCan(rs.getInt(4));
                lista.add(ar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    
    //por nombre
    
       public List<Articulo> buscarPorNombre(String nombre) {
        String sql = "SELECT ArtCod, ArtNom, MarNom, ArtCan FROM inv_articulo WHERE ArtNom LIKE ?";
        List<Articulo> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nombre + "%"); // Buscar cualquier código que contenga el término de búsqueda
            rs = ps.executeQuery();
            while (rs.next()) {
                Articulo ar = new Articulo();
                ar.setArtCod(rs.getString(1));
                ar.setArNom(rs.getString(2));
                ar.setMarNom(rs.getString(3));
                ar.setArtCan(rs.getInt(4));
                lista.add(ar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}
