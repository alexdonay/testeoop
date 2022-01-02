package controllers;

import database.Db;
import java.util.ArrayList;
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
        System.out.println("aluno incluido com sucesso");
        data.alunos.add(aluno);
    }

    public Aluno pesquisaAlunoID(int id){

        for(Aluno i : data.alunos){
            if(i.getId()== id){
                return i;
            }
        }
        return null;
    }

    public void excluiAlunoID(int id){
        String frase = "";

        for(int i = 0; i < data.alunos.size(); i++){
            if(data.alunos.get(i).getId() == id){
                data.alunos.remove(i);
                frase ="Aluno excluido com sucesso";
            }else{
                frase = "Aluno não encontrado";
            }
        }
        System.out.println(frase);
    }
    public void atualizaAluno(int id, Aluno aluno){ //metodo update
        if(data.alunos.get(id)!=null){
            data.alunos.set(id,aluno);
        }
    }
    public ArrayList<Aluno> listaAluno(){
        return data.alunos;
    }

    public void adicionaPessoa(Pessoa pessoa) { //metodo create
        pessoa.setId(data.pessoas.size());
        pessoa.setTipo(Pessoa.tipoPessoa.PESSOA);
        System.out.println("pessoa incluido com sucesso");
        data.pessoas.add(pessoa);
    }
    public Pessoa pesquisaPessoaID(int id){
        for(Pessoa i : data.pessoas){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }
    public void excluiPessoaID(int id){
        String frase = "";
        for(int i = 0; i < data.pessoas.size(); i++){
            if(data.pessoas.get(i).getId()==id){
                data.pessoas.remove(i);
                frase = "Pessoa Removida com sucesso";
            }else{
                frase ="Pessoa não encontrada";
            }
        }
        System.out.println(frase);
    }
    public void atualizaPessoa(int id, Pessoa pessoa){
            data.pessoas.set(id,pessoa);
    }
    public ArrayList<Pessoa> listaPessoa(){
        return data.pessoas;
    }
}