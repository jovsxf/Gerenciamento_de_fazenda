package Plantacao;

public class Cafe extends Especie {

    public Cafe(String nome, int quantidadeDeMudas) {
        super(nome, quantidadeDeMudas);
    }

    public static void condicaoDePlantio(){
        System.out.println("Para plantio do café, o solo deve ter um Ph entre 4 e 8");
        System.out.println("Caso a condição seja verdadeira, ative o maquinário e prepare a terra, caso contrário, faça correção de Ph \n");
    }

    public static float correcaoPh(float ph){

        if(ph < 4 && ph > 0){
            float acrescimo = 0;
            acrescimo =  4 - ph;
            ph += acrescimo;
        }
        if(ph > 8 && ph < 14){
            float acrescimo = 0;
            acrescimo =  ph - 8;
            ph -= acrescimo;
        }
        else
            System.out.println("Valor de Ph inexistente, insira novamente! \n");

        return ph;
    }

}

