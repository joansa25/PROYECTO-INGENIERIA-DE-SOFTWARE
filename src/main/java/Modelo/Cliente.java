
package Modelo;


public class Cliente {

    String CodClien;
    String NomClien;
    String DireClien;
    String CorreoClien;
    String TelClien;

    public Cliente() {
    }

    public Cliente(String CodClien, String NomClien, String DireClien, String CorreoClien, String TelClien) {
        this.CodClien = CodClien;
        this.NomClien = NomClien;
        this.DireClien = DireClien;
        this.CorreoClien = CorreoClien;
        this.TelClien = TelClien;
    }

    public String getCodClien() {
        return CodClien;
    }

    public void setCodClien(String CodClien) {
        this.CodClien = CodClien;
    }

    public String getNomClien() {
        return NomClien;
    }

    public void setNomClien(String NomClien) {
        this.NomClien = NomClien;
    }

    public String getDireClien() {
        return DireClien;
    }

    public void setDireClien(String DireClien) {
        this.DireClien = DireClien;
    }

    public String getCorreoClien() {
        return CorreoClien;
    }

    public void setCorreoClien(String CorreoClien) {
        this.CorreoClien = CorreoClien;
    }

    public String getTelClien() {
        return TelClien;
    }

    public void setTelClien(String TelClien) {
        this.TelClien = TelClien;
    }

}
