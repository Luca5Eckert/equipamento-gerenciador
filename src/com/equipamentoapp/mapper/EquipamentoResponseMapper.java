package com.equipamentoapp.mapper;

import com.equipamentoapp.dto.EquipamentoResponse;
import com.equipamentoapp.model.Equipamento;

public class EquipamentoResponseMapper {

    public EquipamentoResponse toResponse(Equipamento equipamento){
        return new EquipamentoResponse(equipamento.getCodigo(), equipamento.getNome(), equipamento.getQuantidade(), equipamento.getPreco());
    }

}

