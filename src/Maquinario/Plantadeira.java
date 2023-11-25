package Maquinario;

import Interfaces.AtivarMaquinario;

public class Plantadeira extends Maquinario implements AtivarMaquinario {

    public Plantadeira(String numerodeserie) {
        super(numerodeserie);
    }

    @Override
    public void ativarMaquinario() {
        System.out.println("Mudas plantadas! \n");
    }
}
