import views.*;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean continua = true;
        int opcao;
        System.out.println("+----------------------------------------------------+");
        System.out.println("|Bem Vindo ao Sistema de Cadastro de Alunos e Pessoas|");
        System.out.println("+----------------------------------------------------+");

        while (continua){
            System.out.println("Digite: 1 para cadastrar, 2 para listar cadastros, 3 para excluir, 4 para atualizar ou 0 para sair:"); //tela iniicial do programa
            opcao = teclado.nextInt();
            switch (opcao) {
                case 0 -> continua = false;
                case 1 -> {
                    PedeDados pedeDados = new PedeDados();
                    pedeDados.pedeDados();
                }
                case 2 -> {
                    ExibeDados exibeDados = new ExibeDados();
                    exibeDados.exibeDadosAluno();
                    exibeDados.exibeDadosPessoa();
                }
                case 3 -> {
                    Exclui exclui = new Exclui();
                    exclui.exclui();
                }
                case 4 -> {
                    Atualiza atualiza = new Atualiza();
                    atualiza.atualiza();
                }
                default -> throw new IllegalStateException("Valor inválido: " + opcao);
            }
        }
    }
}
