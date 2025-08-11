package com.equipamentoapp.dto;

import com.equipamentoapp.model.enums.TipoEquipamento;

public record EquipamentoAdicionarRequest(TipoEquipamento tipoEquipamento, String nome, int quantidade, double preco, double potencia, String tensao) {

    public EquipamentoAdicionarRequest(TipoEquipamento tipoEquipamento,String nome,int quantidade, double preco,double  potencia){
        this(tipoEquipamento,nome, quantidade, preco, potencia, null);
    }

    public EquipamentoAdicionarRequest(TipoEquipamento tipoEquipamento,String nome,int quantidade, double preco, String tensao){
        this(tipoEquipamento,nome, quantidade, preco, -1, tensao);
    }



}
