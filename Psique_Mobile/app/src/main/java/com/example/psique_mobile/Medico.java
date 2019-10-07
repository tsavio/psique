package com.example.psique_mobile;

public class Medico {

    private String id;
    private String nome;
    private String profissao;
    private String email;
    private String crp;
    private String telefone;
    private String cpf;

    //@androidx.annotation.NonNull
        @Override
    public String toString() {
        return nome;
    }

    public Medico(){

    }

   public Medico(String nome, String profissao, String email, String crp, String id, String telefone, String cpf){
           this.email = email;
           this.nome = nome;
           this.profissao = profissao;
           this.crp = crp;
           this.id = id;
           this.telefone = telefone;
           this.cpf = cpf;
   }

    public String getNome() {
            return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
                this.nome = nome;
        }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String nome) {
        this.crp = crp;
    }

    public String getProfissao() {
                return profissao;
        }

    public void setProfissao(String profissao) {
                this.profissao = profissao;
        }

    public String getEmail() {
                return email;
        }

    public void setEmail(String endereco) {
                this.email = email;
        }

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
