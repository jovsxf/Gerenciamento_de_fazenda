package Plantacao;

public class Soja extends Especie {

    public Soja(String nome, int quantidadeDeMudas) {
        super(nome, quantidadeDeMudas);
    }

    public static void condicaoDePlantio(){
        System.out.println("Para plantio da Soja, o solo deve ter um Ph entre 5 e 6");
        System.out.println("Caso a condição seja verdadeira, ative o maquinário e prepare a terra, caso contrário, faça correção de Ph \n");
    }

    public static float correcaoPh(float ph){
        float acrescimo = 0;
        if(ph < 5 && ph > 0){
            acrescimo =  5 - ph;
            ph += acrescimo;
            return ph;
        }
        if(ph > 6 && ph < 14){
            acrescimo =  ph - 6;
            ph -= acrescimo;
            return ph;
        }
        else
            System.out.println("Valor de Ph inexistente, insira novamente! \n");
        return acrescimo;
    }

    //Setembro a outubro
}
