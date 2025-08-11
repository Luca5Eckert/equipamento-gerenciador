package com.equipamentoapp.infra;

import com.equipamentoapp.mapper.EquipamentoMapper;
import com.equipamentoapp.mapper.MotorEletricoMapper;
import com.equipamentoapp.mapper.PainelControleMapper;
import com.equipamentoapp.model.enums.TipoEquipamento;

public class MapperFactory {
    private static final MotorEletricoMapper motorEletricoMapper = new MotorEletricoMapper();
    private static final PainelControleMapper painelControleMapper = new PainelControleMapper();

    public static EquipamentoMapper toInstance(TipoEquipamento tipoEquipamento){
        return switch(tipoEquipamento){
            case MOTOR_ELETRICO -> motorEletricoMapper;
            case PAINEL_CONTROLE -> painelControleMapper;
        };
    }

}
