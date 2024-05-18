/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author WHC2G
 */
public class DetPedido {

    String comtx;
    String cArtCod;
    int Cant;
    String NomArt;
    double Precio;
    double Desc = 10;
    double Subtotal ;
    double Resultado ; 
    double TotalPagar;
    
    public DetPedido() {
    }

    public DetPedido(String comtx, String cArtCod, int Cant, String NomArt, double Precio) {
        this.comtx = comtx;
        this.cArtCod = cArtCod;
        this.Cant = Cant;
        this.NomArt = NomArt;
        this.Precio = Precio;
        this.Subtotal = Subtotal;
        this.Resultado = Resultado;
        this.TotalPagar = TotalPagar;
    }

    public double getTotalPagar() {
        return TotalPagar;
    }

    public void setTotalPagar(double TotalPagar) {
        this.TotalPagar = TotalPagar;
    }

   

    public String getComtx() {
        return comtx;
    }

    public void setComtx(String comtx) {
        this.comtx = comtx;
    }

    public String getcArtCod() {
        return cArtCod;
    }

    public void setcArtCod(String cArtCod) {
        this.cArtCod = cArtCod;
    }

    public int getCant() {
        return Cant;
    }

    public void setCant(int Cant) {
        this.Cant = Cant;
    }

    public String getNomArt() {
        return NomArt;
    }

    public void setNomArt(String NomArt) {
        this.NomArt = NomArt;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public double getDesc() {
        return Desc;
    }

    public void setDesc(double Desc) {
        this.Desc = Desc;
    }

    public double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(double Subtotal) {
        this.Subtotal = Subtotal;
    }

    public double getResultado() {
        return Resultado;
    }

    public void setResultado(double Resultado) {
        this.Resultado = Resultado;
    }

    
       


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetPedido detPedido = (DetPedido) o;
        return Objects.equals(cArtCod, detPedido.cArtCod);
    }

@Override
public int hashCode() {
    return Objects.hash(cArtCod != null ? cArtCod : 0);
}

}
