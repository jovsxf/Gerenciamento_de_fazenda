import Geral.*;
import Plantacao.*;
import Maquinario.*;
import database.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner entrada;
        entrada = new Scanner(System.in);

        int a;
        int tipoMaquinario;

        SoloBD soloBD = new SoloBD();
        Solo solo = new Solo(4, 0);
        soloBD.insertSolo(solo);

        //Maquinário que já existem na fazenda
        Maquinario maquinario = new Maquinario("44323");
        MaquinarioBD maquinarioBD = new MaquinarioBD();

        Trator trator = new Trator("55554");
        Colheitadeira colheitadeira = new Colheitadeira("78654");
        Plantadeira plantadeira = new Plantadeira("98742");
        Pulverizador pulverizador = new Pulverizador("17685");
        maquinarioBD.insertMaquinario(maquinario);

        FazendaBD fazendaBD = new FazendaBD();
        Fazenda fazenda = new Fazenda("Fazenda da Primavera", 100, 50, 10, solo, 5, 4); // Capacidade para 5 pragas e 4 funcionarios

        fazendaBD.insertFazenda(fazenda);

        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("(1) Adicionar Praga");
            System.out.println("(2) Adicionar Especie");
            System.out.println("(3) Adicionar Funcionário");
            System.out.println("(4) Checar condição de plantio de uma espécie");
            System.out.println("(5) Checar o que plantar no mês atual");
            System.out.println("(6) Fazer correção de Ph para o plantio de:");
            System.out.println("(7) Ativar maquinário");
            System.out.println("(8) Ver pragas cadastradas");
            System.out.println("(0) Sair");

            a = entrada.nextInt();

            switch (a) {
                case 1 -> {
                    // Adicionar praga
                    PragasBD pragasBD = new PragasBD();
                    Praga novaPraga = new Praga();

                    pragasBD.insertPragas(novaPraga);

                    System.out.println("Digite o tipo da praga:");
                    entrada.nextLine(); // Consumir a quebra de linha pendente
                    novaPraga.setTipo(entrada.nextLine());
                    System.out.println("Digite a força da praga:");
                    novaPraga.setForca(entrada.nextInt());

                    // Verificar se a praga já foi adicionada
                    if (!fazenda.contemPraga(novaPraga)) {
                        fazenda.adicionarPraga(novaPraga);
                        System.out.println("Praga adicionada com sucesso!");
                    } else {
                        System.out.println("Essa praga já foi adicionada à fazenda.");
                    }
                }
                case 2 -> {
                    // Adicionar espécie
                    System.out.println("(1) Café \n(2) Milho \n(3) Soja");
                    int tipoEspecie = entrada.nextInt();
                    String nomeespecie;
                    int quantmudas;
                    int total = 0;

                    switch (tipoEspecie) {
                        case 1 -> {
                            System.out.println("Digite o nome da espécie:");
                            nomeespecie = entrada.nextLine();
                            System.out.println("Digite a quantidade de mudas:");
                            entrada.nextLine(); // Limpar o buffer2
                            quantmudas = entrada.nextInt();
                            Especie cafe = new Cafe(nomeespecie, quantmudas);
                            total += cafe.getQuantidadeDeMudas();
                            EspecieBD especieBD = new EspecieBD();
                            especieBD.insertEspecie(cafe);
                            especieBD.buscarEspecie();
                        }
                        case 2 -> {
                            System.out.println("Digite o nome da espécie:");
                            entrada.nextLine();
                            nomeespecie = entrada.nextLine();
                            System.out.println("Digite a quantidade de mudas:");
                            entrada.nextLine(); // Limpar o buffer
                            quantmudas = entrada.nextInt();
                            Especie milho = new Milho(nomeespecie, quantmudas);
                            total += milho.getQuantidadeDeMudas();
                            EspecieBD especieBD = new EspecieBD();
                            especieBD.insertEspecie(milho);
                            especieBD.buscarEspecie();
                        }
                        case 3 -> {
                            System.out.println("Digite o nome da espécie:");
                            nomeespecie = entrada.nextLine();
                            System.out.println("Digite a quantidade de mudas:");
                            entrada.nextLine(); // Limpar o buffer
                            quantmudas = entrada.nextInt();
                            Especie soja = new Soja(nomeespecie, quantmudas);
                            total += soja.getQuantidadeDeMudas();
                            EspecieBD especieBD = new EspecieBD();
                            especieBD.insertEspecie(soja);
                            especieBD.buscarEspecie();
                        }
                        default -> System.out.println("Opção inválida.");
                    }

                    System.out.println("Quantidade de mudas totais: " + total);

                }
                case 3 -> { //adicionar funcionario e alocar a uma maquina
                    Funcionarios novoFuncionario = new Funcionarios();
                    FuncionariosBD funcionariosBD = new FuncionariosBD();
                    System.out.println("Digite o nome do funcionário:");
                    entrada.nextLine(); // Consumir a quebra de linha pendente
                    novoFuncionario.setNome(entrada.nextLine());
                    System.out.println("Digite o CPF do funcionário:");
                    novoFuncionario.setCpf(entrada.nextLine());
                    System.out.println("Digite a idade do funcionário:");
                    novoFuncionario.setIdade(entrada.nextInt());
                    funcionariosBD.insertFuncionarios(novoFuncionario);

                    // Verificar se o funcionário já foi adicionado
                    if (fazenda.contemFunc(novoFuncionario)) {
                        fazenda.adicionarFuncionario(novoFuncionario);
                        System.out.println("Funcionário adicionado com sucesso!");
                    } else {
                        System.out.println("Essa funcionário já foi adicionado.");
                    }
                    Alocacoes aloc = new Alocacoes();
                    aloc.setFuncionario(novoFuncionario);
                    System.out.println("\n Escolha um maquinário para atribuir ao funcionário:");
                    System.out.println("(1) Trator \n(2) Plantadeira \n(3) Pulverizador \n(4) Colheitadeira");
                    tipoMaquinario = entrada.nextInt();
                    switch (tipoMaquinario) {
                        case 1 -> aloc.setMaquinario(trator);
                        case 2 -> aloc.setMaquinario(plantadeira);
                        case 3 -> aloc.setMaquinario(pulverizador);
                        case 4 -> aloc.setMaquinario(colheitadeira);
                    }
                }
                case 4 -> {
                    // Lógica para checar condição de plantio de uma espécie
                    System.out.println("(1) Café \n(2) Milho \n(3) Soja");
                    int tipoEspecie = entrada.nextInt();
                    switch (tipoEspecie) {
                        case 1 -> Cafe.condicaoDePlantio();
                        case 2 -> Milho.condicaoDePlantio();
                        case 3 -> Soja.condicaoDePlantio();
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 5 ->
                    // Lógica para checar o que plantar no mês atual
                        Especie.consultarOQuePlantar(fazenda.getNumeroDoMesAtual());
                case 6 -> {
                    // Lógica para fazer correção de Ph para o plantio
                    System.out.println("(1) Café\n(2) Milho\n(3) Soja");
                    int tipoCorrecao = entrada.nextInt();
                    switch (tipoCorrecao) {
                        case 1 -> {
                            if (solo.getNivelDePh() > 4 && solo.getNivelDePh() < 8) {
                                System.out.println("Seu ph está correto!");
                            }
                            if (solo.getNivelDePh() == 4 || solo.getNivelDePh() == 8) {
                                System.out.println("Seu ph está correto!");
                            } else {
                                solo.setNivelDePh(Cafe.correcaoPh(solo.getNivelDePh()));
                                System.out.println("Seu ph foi corrigido!");
                            }
                        }
                        case 2 -> {
                            if (solo.getNivelDePh() > 6 && solo.getNivelDePh() < 7) {
                                System.out.println("Seu ph está correto!");
                            }
                            if (solo.getNivelDePh() == 6 || solo.getNivelDePh() == 7) {
                                System.out.println("Seu ph está correto!");
                            } else {
                                solo.setNivelDePh(Milho.correcaoPh(solo.getNivelDePh()));
                                System.out.println("Seu ph foi corrigido!");
                            }
                        }
                        case 3 -> {
                            if (solo.getNivelDePh() > 5 && solo.getNivelDePh() < 6) {
                                System.out.println("Seu ph está correto!");
                            }
                            if (solo.getNivelDePh() == 5 || solo.getNivelDePh() == 6) {
                                System.out.println("Seu ph está correto!");
                            } else {
                                solo.setNivelDePh(Soja.correcaoPh(solo.getNivelDePh()));
                                System.out.println("Seu ph foi corrigido!");
                            }

                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 7 -> {
                    // Lógica para ativar maquinário
                    System.out.println("(1) Trator \n(2) Plantadeira \n(3) Pulverizador \n(4) Colheitadeira");
                    tipoMaquinario = entrada.nextInt();
                    switch (tipoMaquinario) {
                        case 1 -> {
                            trator.ativarMaquinario();
                            trator.setUso(true);
                        }
                        case 2 -> {
                            if (trator.isUso()) {
                                plantadeira.ativarMaquinario();
                                plantadeira.setUso(true);
                            } else
                                System.out.println("Terra não preparada para plantio");
                        }
                        case 3 -> {
                            if (trator.isUso() && plantadeira.isUso()) {
                                pulverizador.ativarMaquinario();
                                pulverizador.setUso(true);
                            } else
                                System.out.println("Terra não preparada para plantio e nenhuma espécie foi plantada");
                        }
                        case 4 -> {
                            if (trator.isUso() && plantadeira.isUso() && pulverizador.isUso()) {
                                colheitadeira.ativarMaquinario();
                                colheitadeira.setUso(true);
                            } else
                                System.out.println("Terra não preparada para plantio, nenhuma espécie foi plantada e as pragas não foram combatidas");
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
                case 8 -> {
                    for (Praga praga : fazenda.getPragas()) {
                        if (praga != null) {
                            System.out.println("Tipo: " + praga.getTipo() + ", Força: " + praga.getForca());
                        }
                    }
                }
                case 0 -> System.out.println("Saindo do programa.");
                default -> System.out.println("Opção inválida.");
            }

        } while (a != 0);

        fazendaBD.updateFazenda(fazenda, 5);
        maquinarioBD.deleteMaquinario(maquinario);

    }
}