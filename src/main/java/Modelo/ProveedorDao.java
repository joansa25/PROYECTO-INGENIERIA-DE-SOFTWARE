/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class ProveedorDao {
        Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
                public List listar() {
            String sql = " select CodProv,NomProv,DescProv,CorreoProv,DireProv,TelProv,NitProv from d_proveedores";
            List<Proveedor> lista = new ArrayList<>();
            try {
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Proveedor pr = new Proveedor();
                    
                    pr.setCodProv(rs.getString(1));
                    pr.setNomProv(rs.getString(2));
                    pr.setDescProv(rs.getString(3));
                    pr.setCorreoProv(rs.getString(4));
                    pr.setDireProv(rs.getString(5));
                    pr.setTelProv(rs.getString(6));
                    pr.setNitProv(rs.getString(7));
                    
                    lista.add(pr);
                }

            } catch (Exception e) {

            }
            return lista;
        }
}
