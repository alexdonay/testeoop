package controllers;

import database.Db;
import java.util.List;
/*
*Esta classe é responsável por controlar o banco de dados
* Nela estão os métodos CRUD
 */

public class DataBase {
    final Db data = Db.getInstance();
    public DataBase() {}
     public void adicionaAluno(Aluno aluno) { //metodo create
        aluno.setId(data.alunos.size());
        aluno.setTipo(Aluno.tipoPessoa.ALUNO);
        System.out.println("Aluno incluido com sucesso");
        data.alunos.add(aluno);
    }

    public Aluno pesquisaAlunoID(int id){
        return data.alunos.get(id);
    }

    public void excluiAlunoID(int id){
        if(data.alunos.get(id) != null){
            data.alunos.remove(id);
            System.out.println("Aluno excluido com sucesso");
        }else{
            System.out.println("Aluno não encontrado");
        }
    }

    public void atualizaAluno(int id, Aluno aluno){ //metodo update
        if(data.alunos.get(id)!=null){
            data.alunos.set(id,aluno);
        }
    }

    public List<Aluno> listaAluno(){
        return data.alunos;
    }

    public void adicionaPessoa(Pessoa pessoa) { //metodo create
        pessoa.setId(data.pessoas.size());
        pessoa.setTipo(Pessoa.tipoPessoa.PESSOA);
        System.out.println("pessoa incluido com sucesso");
        data.pessoas.add(pessoa);
    }

    public Pessoa pesquisaPessoaID(int id){
        return data.pessoas.get(id);
    }

    public void excluiPessoaID(int id){
        if(data.pessoas.get(id)!=null){
            data.pessoas.remove(id);
            System.out.println("Pessoa Removida com sucesso");
        }else{
            System.out.println("Pessoa não encontrada");
        }
    }

    public void atualizaPessoa(int id, Pessoa pessoa){
            data.pessoas.set(id,pessoa);
    }

    public List<Pessoa> listaPessoa(){
        return data.pessoas;
    }
}