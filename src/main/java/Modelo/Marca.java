/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author WHC2G
 */
public class Marca {

    String MarCod;
    String MarNom;

    public Marca() {
    }

    public Marca(String MarCod, String MarNom) {
        this.MarCod = MarCod;
        this.MarNom = MarNom;
    }

    public String getMarCod() {
        return MarCod;
    }

    public void setMarCod(String MarCod) {
        this.MarCod = MarCod;
    }

    public String getMarNom() {
        return MarNom;
    }

    public void setMarNom(String MarNom) {
        this.MarNom = MarNom;
    }

}
