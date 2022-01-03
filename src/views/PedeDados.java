package views;

import controllers.Aluno;
import controllers.Pessoa;
import controllers.DataBase;

import java.util.Date;
import java.util.Scanner;

public class PedeDados {
    String nome;
    String dataNascimento;
    String telefone;
    String opNota;//String para definir a nota
    Double nota;
    final Scanner teclado = new Scanner(System.in);
    final DataBase dataBase = new DataBase();
    final Date hoje = new Date();

    public void pedeDados(){
        boolean continua = true;
        while(continua){
            System.out.println("Digite nome do Aluno/Pessoa:");
            nome = teclado.nextLine();
            do{
                System.out.println("Digite a data de nascimento do Aluno/Pessoa (dd/mm/aaaa):");
                dataNascimento = teclado.next();
            }while (!validaData(dataNascimento));
            System.out.println("Digite o número de telefone:");
            telefone = teclado.next();
            System.out.println("Digite a nota, caso seja um aluno ou N para Pessoa");
            opNota = teclado.next();
            if (opNota.equalsIgnoreCase("n")){
                Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento, hoje, hoje);
                dataBase.adicionaPessoa(pessoa);
            }else{
                nota = Double.parseDouble(opNota);
                while(nota>10||nota<0){
                    System.out.println("A nota não pode ser menor Zero ou maior que 10");
                    System.out.println("Digite uma nota válida");
                    opNota = teclado.next();
                    nota = Double.parseDouble(opNota);
                }
                Aluno aluno = new Aluno(nome, telefone, dataNascimento, hoje, hoje, nota);
                dataBase.adicionaAluno(aluno);
            }
            continua = false;
        }
    }
    public boolean validaData(String data) {
        int dia;
        int mes;
        int ano;
        String separador = "/";
        try{
            dia = Integer.parseInt(data.substring(0,2));
            mes = Integer.parseInt(data.substring(3,5));
            ano = Integer.parseInt(data.substring(6,10));
        }catch (Exception e){
            System.out.println("Data inválida");
            return false;
        }
        boolean validaDia = false;
        boolean validaSeparador1 = (data.substring(2,3).equalsIgnoreCase(separador));
        boolean validaSeparador2 = (data.substring(5,6).equalsIgnoreCase(separador));
        boolean validaTamanhoTotal = (data.length()==10);
        switch (mes) {
            case 1,3,5,7,8,10,12:
                validaDia = dia <= 31;
                break;
            case 4,6,9,11:
                validaDia = dia <= 30;
                break;
            case 2:
                if(bisexto(ano)){
                    validaDia = dia <= 29;
                }else{
                    validaDia = dia <= 28;
                }
                break;
        }
        if(validaDia&validaSeparador1&validaSeparador2&validaTamanhoTotal){
            return true;
        }else{
            System.out.println("Data Inválida");
            return false;
        }
    }
    public boolean bisexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
}