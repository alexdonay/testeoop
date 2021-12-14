package views;

import controllers.Aluno;
import controllers.Pessoa;
import controllers.DataBase;

import java.util.Date;
import java.util.Scanner;

public class PedeDados {
    //Variaveis
    String nome;
    String dataNascimento;
    String telefone;
    String opNota;//String para definir a nota
    Double nota;
    //Instancia objetos
    Scanner teclado = new Scanner(System.in);
    DataBase dataBase = new DataBase();
    Date hoje = new Date();
    //Interface grafica da tela de cadastro
    public void pedeDados(){
        boolean continua = true;//Enquanto foi true o sistema irá pedir dados para cadastrar um novo aluno/pessoa
        while(continua){

                System.out.println("Digite nome do Aluno/Pessoa:");
                nome = teclado.nextLine();



            System.out.println("Digite a data de nascimento do Aluno/Pessoa (dd/mm/aaaa):");
            dataNascimento = teclado.next();
            System.out.println("Digite o número de telefone:");
            telefone = teclado.next();
            System.out.println("Digite a nota, caso seja um aluno ou N para Pessoa");
            opNota = teclado.next();

            //Passa os dados para o controler gravar os dados
            if (opNota.equalsIgnoreCase("n")){
                Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento, hoje, hoje);
                dataBase.adicionaPessoa(pessoa);
            }else{
                nota = Double.parseDouble(opNota);
                Aluno aluno = new Aluno(nome, telefone, dataNascimento, hoje, hoje, nota);
                dataBase.adicionaAluno(aluno);
            }
            System.out.println("Digite 0 para continuar ou qualquer outra tecla para voltar ao menu anterior");
            int fim = teclado.nextInt();
            teclado.nextLine();//esta linha é necessária para consumir um "/n" deixado pelo "nextInt"

            if(fim !=0){
                continua = false;
            }
        }
    }
}
