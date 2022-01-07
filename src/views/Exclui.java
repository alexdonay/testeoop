package views;

import controllers.DataBase;

import java.util.Scanner;

public class Exclui {
    final DataBase dataBase = new DataBase();
    final Scanner teclado = new Scanner(System.in);
    public void exclui(){
        System.out.println("Digite 1 para excluir um Aluno e 2 para excluir uma Pessoa");
        int opcaoExclusao = teclado.nextInt();
        if(opcaoExclusao == 1){
            excluiAluno();
        }else {
            excluiPessoa();
        }
    }

    private void excluiAluno(){
        int id;
        boolean valida = false;
        while (!valida){
            try{
                System.out.println("Digite o ID do Aluno para excluir do cadastro");
                teclado.nextLine();
                id = teclado.nextInt();
                dataBase.excluiAlunoID(id);
                valida = true;
                }catch (Exception e){
                System.out.println("Aluno inexistente");
            }
        }
    }

    private void excluiPessoa(){
        int id;
        boolean valida = false;
        while (!valida ){
            try{
                System.out.println("Digite o ID da Pessoa para excluir do cadastro");
                teclado.nextLine();
                id = teclado.nextInt();
                dataBase.excluiPessoaID(id);
                valida = true;
            }catch (Exception e){
                System.out.println("Pessoa inexistente");
            }
        }
    }
}
