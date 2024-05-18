/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WHC2G
 */
public class DetPedidoDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    DetPedido dp = new DetPedido();

    public int agregar(List<DetPedido> listaDetPedidos) {
        String sql = "INSERT INTO com_detpedido (comTx, ComArtCod, ComDetArtNom, ComCanLin, ComPreLin,ComPreDeslin,ComPreLinOri,ComDetLin,ComPreNet) VALUES (?, ?, ?, ?, ?,?,?,?,?)";
        int totalFilasInsertadas = 0;

        int nSerie = numeroSerie();
        double desc = dp.getDesc();

        System.out.println("el numero de serie a insertar es : " + nSerie);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            // Iterar sobre la lista de detalles de pedido y agregarlos uno por uno
            for (DetPedido dp : listaDetPedidos) {
                ps.setInt(1, nSerie);
                ps.setString(2, dp.getcArtCod());
                ps.setString(3, dp.getNomArt());
                ps.setInt(4, dp.getCant());
                ps.setDouble(5, dp.getPrecio());
                ps.setDouble(6, desc);
                ps.setDouble(7, dp.getSubtotal()); // Subtotal
                ps.setDouble(8, dp.getResultado()); // resultado, ComDetLin
                ps.setDouble(9, dp.getTotalPagar());
            System.out.println("total a PAGAR : "+dp.getTotalPagar());

                // Ejecutar la inserción para cada detalle de pedido
                int filasInsertadas = ps.executeUpdate();

                // Sumar el número de filas insertadas en total
                totalFilasInsertadas += filasInsertadas;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar los detalles de pedido: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }

        return totalFilasInsertadas;
    }

    public int numeroSerie() {
        String sql = "SELECT MAX(ComTx) AS UltimoNumeroSerie FROM com_detpedido";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                int ultimoNumeroSerie = rs.getInt("UltimoNumeroSerie");
                return ultimoNumeroSerie + 1; // Devuelve el número mayor + 1
            } else {
                // Si no hay registros, devuelve 1
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el último número de serie: " + e.getMessage());
            return -1; // Retorna un valor negativo en caso de error
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }

    }
    




    
    

}
