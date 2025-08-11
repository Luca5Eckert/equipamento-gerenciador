package com.equipamentoapp.util;

import com.equipamentoapp.mapper.EquipamentoResponseMapper;

public class MapperUtils {
    private final static EquipamentoResponseMapper EQUIPAMENTO_RESPONSE_MAPPER = new EquipamentoResponseMapper();

    public static EquipamentoResponseMapper toInstanceEquipamentoResponseMapper() {
        return EQUIPAMENTO_RESPONSE_MAPPER;
    }
}
