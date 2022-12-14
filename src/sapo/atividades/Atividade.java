package sapo.atividades;

import sapo.pessoa.PessoaRepository;
import sapo.tarefas.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Atividade extends PessoaRepository {

    private String nome;
    private String descricao;
    private String cpf;

    private List<Tarefa> tarefas = new ArrayList<Tarefa>();
    private String id;
    private String estado = "ATIVO";


    public Atividade(String nome , String descricao, String cpf, String id){
        this.nome = nome;
        this.descricao = descricao;
        this.cpf = cpf;
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNomeAtividade(){
        return this.nome;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getCpf(){
        return this.cpf;
    }
    public String getId(){
        return this.id;
    }

    public int getNumero(){
        String[] resposta = id.split("-");
        return parseInt(resposta[1]);
    }
    public List<Tarefa> getTarefas(){
        return this.tarefas;
    }
    public void setTarefas(){
        if (this.estado.toUpperCase().equals("ATIVO")){
            this.tarefas = tarefas;
        }else{
            throw new IllegalStateException("A atividade não está ATIVA");
        }
    }

    public String tarefasFormatoExibicao(){
        String retornoLoop = "";
        for(Tarefa a: tarefas){retornoLoop += a.toStringFormatoAtividades();}
        return retornoLoop;
    }

    public void setEstado(String estado){
        if(this.estado.toUpperCase().equals(estado.toUpperCase())){
            throw new IllegalStateException("Já está no estado: " + estado);
        }else{
            this.estado = estado;
        }
    }
    public String getEstado(){
        return this.estado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade that = (Atividade) o;
        return nome.equals(that.nome) && descricao.equals(that.descricao) && cpf.equals(that.cpf) && id.equals(that.id) && estado.equals(that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, cpf, id, estado);
    }

    public void nameCpf(){

    }

    public void addTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }
}
