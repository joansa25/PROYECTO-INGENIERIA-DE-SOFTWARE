/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author WHC2G
 */
public class Proveedor {

    String CodProv;
    String NomProv;
    String DescProv;
    String CorreoProv;
    String DireProv;
    String TelProv;
    String NitProv;

    public Proveedor() {
    }

    public Proveedor(String CodProv, String NomProv, String DescProv, String CorreoProv, String DireProv, String TelProv, String NitProv) {
        this.CodProv = CodProv;
        this.NomProv = NomProv;
        this.DescProv = DescProv;
        this.CorreoProv = CorreoProv;
        this.DireProv = DireProv;
        this.TelProv = TelProv;
        this.NitProv = NitProv;
    }

    public String getCodProv() {
        return CodProv;
    }

    public void setCodProv(String CodProv) {
        this.CodProv = CodProv;
    }

    public String getNomProv() {
        return NomProv;
    }

    public void setNomProv(String NomProv) {
        this.NomProv = NomProv;
    }

    public String getDescProv() {
        return DescProv;
    }

    public void setDescProv(String DescProv) {
        this.DescProv = DescProv;
    }

    public String getCorreoProv() {
        return CorreoProv;
    }

    public void setCorreoProv(String CorreoProv) {
        this.CorreoProv = CorreoProv;
    }

    public String getDireProv() {
        return DireProv;
    }

    public void setDireProv(String DireProv) {
        this.DireProv = DireProv;
    }

    public String getTelProv() {
        return TelProv;
    }

    public void setTelProv(String TelProv) {
        this.TelProv = TelProv;
    }

    public String getNitProv() {
        return NitProv;
    }

    public void setNitProv(String NitProv) {
        this.NitProv = NitProv;
    }
    
    
}
