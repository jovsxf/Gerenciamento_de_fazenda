package Maquinario;

import Interfaces.AtivarMaquinario;

public class Trator extends Maquinario implements AtivarMaquinario {

    public Trator(String numerodeserie) {
        super(numerodeserie);
    }

    @Override
    public void ativarMaquinario() {
        System.out.println("Terra preparada com sucesso! \n");
    }

}
