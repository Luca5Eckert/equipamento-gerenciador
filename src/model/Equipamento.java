package model;

public abstract class Equipamento {

    private final String codigo;
    private String nome;
    private int quantidade;
    private double preco;

    protected Equipamento(double preco, int quantidade, String nome, String codigo) {
        this.preco = preco;
        this.quantidade = quantidade;
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
