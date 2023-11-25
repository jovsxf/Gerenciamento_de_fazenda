package Maquinario;
import Interfaces.AtivarMaquinario;

public class Colheitadeira extends Maquinario implements AtivarMaquinario {
    public Colheitadeira(String numerodeserie) {
        super(numerodeserie);
    }


    @Override
    public void ativarMaquinario() {
        System.out.println("Colheita concluída! \n");
    }
}
