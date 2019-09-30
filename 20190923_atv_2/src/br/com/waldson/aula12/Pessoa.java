package br.com.waldson.aula12;

public class Pessoa {
    private String nome;
    private int idade;

    private FilaBanco fila;

    public Pessoa(String nome, int idade) {
        this.nome  = nome;
        this.idade = idade;
    }

    public void setFila(FilaBanco fila) {
        this.fila = fila;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        //Se a idade informada for igual a idade atual, não é necessário fazer atualização
        if (idade == getIdade()) {
            return;
        }

        int idadeAnterior = getIdade();
        this.idade = idade;
        fila.update(this, idadeAnterior);
    }
}
