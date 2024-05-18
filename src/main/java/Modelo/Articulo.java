/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author WHC2G
 */
public class Articulo {
    
        String ArtCod;
    String ArNom;
    String MarNom;
    int ArtCan;

    public Articulo() {
    }

    public Articulo(String ArtCod, String ArNom, String MarNom, int ArtCan) {
        this.ArtCod = ArtCod;
        this.ArNom = ArNom;
        this.MarNom = MarNom;
        this.ArtCan = ArtCan;
    }
    
    

    public String getArtCod() {
        return ArtCod;
    }

    public void setArtCod(String ArtCod) {
        this.ArtCod = ArtCod;
    }

    public String getArNom() {
        return ArNom;
    }

    public void setArNom(String ArNom) {
        this.ArNom = ArNom;
    }

    public String getMarNom() {
        return MarNom;
    }

    public void setMarNom(String MarNom) {
        this.MarNom = MarNom;
    }

    public int getArtCan() {
        return ArtCan;
    }

    public void setArtCan(int ArtCan) {
        this.ArtCan = ArtCan;
    }

}


