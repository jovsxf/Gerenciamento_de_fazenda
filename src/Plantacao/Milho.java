package Plantacao;

public class Milho extends Especie {

    public Milho(String nome, int quantidadeDeMudas) {
        super(nome, quantidadeDeMudas);
    }

    public static void condicaoDePlantio(){
        System.out.println("Para plantio do Milho, o solo deve ter um Ph entre 6 e 7");
        System.out.println("Caso a condição seja verdadeira, ative o maquinário e prepare a terra, caso contrário, faça correção de Ph \n");
    }
    public static float correcaoPh(float ph){
        float acrescimo = 0;
        if(ph < 6 && ph > 0){
            acrescimo =  6 - ph;
            ph += acrescimo;
            return ph;
        }
        if(ph > 7 && ph < 14){
            acrescimo =  ph - 7;
            ph -= acrescimo;
            return ph;
        }
        else
            System.out.println("Valor de Ph inexistente, insira novamente! \n");
        return acrescimo;
    }

}
