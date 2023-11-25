package Maquinario;

import Interfaces.AtivarMaquinario;

public class Pulverizador extends Maquinario implements AtivarMaquinario {

    public Pulverizador(String numerodeserie) {
        super(numerodeserie);
    }

    @Override
    public void ativarMaquinario() {
        System.out.println("Pragas combatidas! \n");
    }
}
