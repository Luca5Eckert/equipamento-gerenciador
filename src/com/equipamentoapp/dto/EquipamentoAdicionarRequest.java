package com.equipamentoapp.dto;

import com.equipamentoapp.model.enums.TipoEquipamento;

public record EquipamentoAdicionarRequest(TipoEquipamento tipoEquipamento, String nome, int quantidade, double preco, double potencia, String tensao) {


}
