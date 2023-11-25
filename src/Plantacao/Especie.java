package Plantacao;

public class Especie {
    private String nome;
    private int quantidadeDeMudas;


    public Especie(String nome, int quantidadeDeMudas) {
        this.nome = nome;
        this.quantidadeDeMudas = quantidadeDeMudas;
    }

    public static void consultarOQuePlantar(int numeroDoMesAtual){

        switch (numeroDoMesAtual){
            case 1, 2, 3:
                System.out.println("Mês ideal para o plantio de café \n");
                break;
            case 9:
                System.out.println("Mês ideal para o plantio de soja \n");
                break;
            case 10:
                System.out.println("Mês ideal para o plantio de café, milho ou soja \n");
                break;
            case 11, 12:
                System.out.println("Mês ideal para o plantio de café ou milho \n");
                break;
            default:
                System.out.println("Não há plantas ideais para esse mês! \n");
                break;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeDeMudas() {
        return quantidadeDeMudas;
    }

    public void setQuantidadeDeMudas(int quantidadeDeMudas) {
        this.quantidadeDeMudas = quantidadeDeMudas;
    }
}
