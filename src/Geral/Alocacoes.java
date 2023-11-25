package Geral;

import Maquinario.*;

// Classe intermediária para representar a relação M:N entre Funcionários e Maquinarios
public class Alocacoes {
    private Funcionarios funcionario;
    private Maquinario maquinario;

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }

    public Maquinario getMaquinario() {
        return maquinario;
    }

    public void setMaquinario(Maquinario maquinario) {
        this.maquinario = maquinario;
    }


}
