package Maquinario;

import Interfaces.AtivarMaquinario;

public class Maquinario{
    String numerodeserie;
    private boolean uso = false;

    public Maquinario() {
    }

    public boolean isUso() {
        return uso;
    }

    public void setUso(boolean uso) {
        this.uso = uso;
    }

    public String getNumeroDeSerie() {
        return numerodeserie;
    }

    public Maquinario(String numerodeserie) {
        this.numerodeserie = numerodeserie;
    }
}
