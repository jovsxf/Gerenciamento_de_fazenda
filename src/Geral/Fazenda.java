package Geral;

import Plantacao.Especie;

public class Fazenda {
    private String nome;
    private int hectaresTotais;
    private int hectaresParaPlantio;
    private int numeroDoMesAtual;
    private Praga[] pragas;
    private int numPragas; // Contador para acompanhar o número de pragas adicionadas
    private int numFunc; // Contador para acompanhar o número de funcionarios adicionados

    private Solo solo; //assossiando o solo
    private Especie[] especies;

    private Alocacoes[] alocacoes;

    private Funcionarios[] funcionarios;


    public Fazenda(String nome, int hectaresTotais, int hectaresParaPlantio, int numeroDoMesAtual, Solo solo, int capacidadePragas, int quantFuncionarios) {
        this.nome = nome;
        this.hectaresTotais = hectaresTotais;
        this.hectaresParaPlantio = hectaresParaPlantio;
        this.numeroDoMesAtual = numeroDoMesAtual;
        this.solo = solo; // Inicializando a referência para a instância de Solo
        this.pragas = new Praga[capacidadePragas];
        this.numPragas = 0; // Inicializa o contador
        this.funcionarios = new Funcionarios[quantFuncionarios];
        this.numFunc = 0; // Inicializa o contador
        this.alocacoes = new Alocacoes[quantFuncionarios];
    }

    public void adicionarPraga(Praga praga) {
        // Verifica se há espaço no array e se a praga ainda não foi adicionada
        if (numPragas < pragas.length && !contemPraga(praga)) {
            pragas[numPragas] = praga;
            numPragas++;
        }
    }

    // Métodos auxiliares para verificar se uma praga/maquinário já está no array
    public boolean contemPraga(Praga praga) {
        for (Praga p : pragas) {
            if (p != null && p.equals(praga)) {
                return true; // A praga já está no array
            }
        }
        return false;
    }

    public void adicionarFuncionario(Funcionarios funcionario) {
        // Verifica se há espaço no array e se o funcionario não foi adicionado
        if (numFunc < funcionarios.length && contemFunc(funcionario)) {
            funcionarios[numFunc] = funcionario;
            numFunc++;
        }
    }

    // Métodos auxiliares para verificar se um funcionário já está no array
    public boolean contemFunc(Funcionarios funcionario) {
        for (Funcionarios p : funcionarios) {
            if (p != null && p.equals(funcionario)) {
                return true; // O funcionário já está no array
            }
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public int getHectaresTotais() {
        return hectaresTotais;
    }

    public int getHectaresParaPlantio() {
        return hectaresParaPlantio;
    }

    public int getNumeroDoMesAtual() {
        return numeroDoMesAtual;
    }

    public int getNumPragas() {
        return numPragas;
    }

    public int getNumFunc() {
        return numFunc;
    }

    //get criado para acessar a lista de pragas da fazenda
    public Praga[] getPragas() {
        return pragas;
    }

    public Alocacoes[] getAlocacoes() {
        return alocacoes;
    }
}
