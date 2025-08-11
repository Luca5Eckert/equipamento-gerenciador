package com.equipamentoapp.model;

import com.equipamentoapp.model.enums.TipoEquipamento;

public class PainelControle extends Equipamento {

    private String tensao;

    public PainelControle(String codigo, double preco, int quantidade, String nome, String tensao) {
        super(preco, quantidade, nome, codigo);
        this.tensao = tensao;
    }

    @Override
    public String toString() {
        String string = super.toString();
        string = string + "\nTensão: " + tensao;
        return string;
    }

    public String getTensao() {
        return tensao;
    }

    public void setTensao(String tensao) {
        this.tensao = tensao;
    }

    @Override
    public TipoEquipamento pegarTipo() {
        return TipoEquipamento.PAINEL_CONTROLE;
    }
}
