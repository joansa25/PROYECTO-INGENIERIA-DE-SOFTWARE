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
public class ClienteDao {
        Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
        
            public List listar() {
            String sql = "select CodClien,NomClien,DireClien,CorreoClien,TelClien from d_clientes";
            List<Cliente> lista = new ArrayList<>();
            try {
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Cliente cl = new Cliente();
                    cl.setCodClien(rs.getString(1));
                    cl.setNomClien(rs.getString(2));
                    cl.setDireClien(rs.getString(3));
                    cl.setCorreoClien(rs.getString(4));
                    cl.setTelClien(rs.getString(5));
                    lista.add(cl);
                }

            } catch (Exception e) {

            }
            return lista;
        }
    
}
