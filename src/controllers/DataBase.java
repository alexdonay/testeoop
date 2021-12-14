package controllers;

import database.Db;
import java.util.ArrayList;

/*
*Esta classe é responsável por controlar o banco de dados
* Nela estão os métodos CRUD
 */
public class DataBase {
    Db data = Db.getInstance();
    //Variáveis auxiliares
    private ArrayList<Pessoa> pessoas= new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();

    //Construtor
    public DataBase() {}

    //Método para manipular o banco de dados
    //Métodos para aluno
    public void adicionaAluno(Aluno aluno) { //metodo create
        aluno.setId(data.alunos.size());
        aluno.setTipo(Aluno.tipoPessoa.ALUNO);
        System.out.println("aluno incluido com sucesso");
        data.alunos.add(aluno);
    }

    public Aluno pesquisaAlunoID(int id){ //metodo read
        if(data.alunos.get(id)!= null){
            Aluno aluno = data.alunos.get(id);
            return aluno;
        }
        return null;

    }

    public void excluiAlunoID(int id){ //metodo delete
        if(data.alunos.get(id)!=null){
            data.alunos.remove(id);
            System.out.println("Aluno excluido com sucesso");
        }
    }
    public void atualizaAluno(int id, Aluno aluno){ //metodo update
        if(data.alunos.get(id)!=null){
            data.alunos.set(id,aluno);
        }
    }
    public ArrayList<Aluno> listaAluno(){
        return data.alunos;
    }
    //Retorna o it da proximo id de pessoas
    public int alunoUltimo(){
        return data.alunos.size();
    }
    public void adicionaPessoa(Pessoa pessoa) { //metodo create
        pessoa.setId(data.pessoas.size());
        pessoa.setTipo(Pessoa.tipoPessoa.PESSOA);
        System.out.println("pessoa incluido com sucesso");
        data.pessoas.add(pessoa);
    }
    public Pessoa pesquisaPessoaID(int id){ //metodo read
        if(data.pessoas.get(id)!= null){
            Pessoa pessoa = data.pessoas.get(id);
            return pessoa;
        }
        return null;
    }
    public void excluiPessoaID(int id){ //metodo delete
        if(data.pessoas.get(id)!=null){
            data.pessoas.remove(id);
            System.out.println("pessoa excluido com sucesso");
        }
    }
    public void atualizaPessoa(int id, Pessoa pessoa){ //metodo update
        if(data.alunos.get(id)!=null){
            data.pessoas.set(id,pessoa);
        }
    }
    public ArrayList<Pessoa> listaPessoa(){
        return data.pessoas;
    }
    //Retorna o it da proximo id de pessoas
    public int pessoaUltimo(){
        return data.pessoas.size();
    }
}
