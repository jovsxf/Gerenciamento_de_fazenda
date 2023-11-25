package Geral;
public class Solo {

    private float nivelDePh; //pH 0 a 7 são considerados ácidos, valores em torno de 7 são neutros e valores acima de 7 são considerados solos básicos ou alcalinos.

    private int idSolo;

    public int getIdSolo() {
        return idSolo;
    }

    public Solo(float nivelDePh, int idSolo) {
        this.nivelDePh = nivelDePh;
        this.idSolo = idSolo;
    }

    public Solo(float nivelDePh) {
        this.nivelDePh = nivelDePh;
    }

    public float getNivelDePh() {
        return nivelDePh;
    }

    public void setNivelDePh(float nivelDePh) {
        this.nivelDePh = nivelDePh;
    }
}
