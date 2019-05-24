package com.example.psique_mobile;

public class Medico {

        private String nome;
        private int imagem;
        private String profissao;
        private String endereco;

       public Medico(String nome, String profissao, String endereco, int imagem){
               this.endereco = endereco;
               this.nome = nome;
               this.imagem = imagem;
               this.profissao = profissao;
       }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public int getImagem() {
                return imagem;
        }

        public void setImagem(int imagem) {
                this.imagem = imagem;
        }

        public String getProfissao() {
                return profissao;
        }

        public void setProfissao(String profissao) {
                this.profissao = profissao;
        }

        public String getEndereco() {
                return endereco;
        }

        public void setEndereco(String endereco) {
                this.endereco = endereco;
        }
}
