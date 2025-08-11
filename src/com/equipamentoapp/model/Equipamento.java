package com.equipamentoapp.model;

import com.equipamentoapp.exception.EquipamentoException;
import com.equipamentoapp.model.enums.TipoEquipamento;

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

    public abstract TipoEquipamento pegarTipo();

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
        if(quantidade < 0){
            throw new EquipamentoException("A quantidade não pode ser negativa");
        }
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void alterarQuantidade(int diferenca) {
        setQuantidade(quantidade+diferenca);
    }
}
