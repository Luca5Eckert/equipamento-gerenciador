package com.equipamentoapp.mapper;

import com.equipamentoapp.dto.EquipamentoAdicionarRequest;
import com.equipamentoapp.model.Equipamento;

public interface EquipamentoMapper {

    public Equipamento toEntity(EquipamentoAdicionarRequest equipamento);

}
