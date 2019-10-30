package com.example.psique_mobile;

public class Medico {

    private String id;
    private String nome;
    private String profissao;
    private String endereco;
    private int imagem;
   // private String email;
 //   private String crm;
  //  private String telefone;
  //  private String cpf;

    //@androidx.annotation.NonNull
        @Override
    public String toString() {
        return nome;
    }

    public Medico(){

    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public Medico(String nome, String profissao, String endereco, int imagem){
               this.endereco = endereco;
               this.nome = nome;
               this.profissao = profissao;
               this.id = id;
               this.imagem = imagem;


       }

        public String getNome() {
                return nome;
        }



    public void setNome(String nome) {
                this.nome = nome;
        }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
                return profissao;
        }

        public void setProfissao(String profissao) {
                this.profissao = profissao;
        }



        public String getId() {
        return id;
    }

        public void setId(String id) { this.id = id; }


}
