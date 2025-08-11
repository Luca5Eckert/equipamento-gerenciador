package com.equipamentoapp.mapper;

import com.equipamentoapp.dto.EquipamentoAdicionarRequest;
import com.equipamentoapp.infra.GeradorDeCodigo;
import com.equipamentoapp.model.Equipamento;
import com.equipamentoapp.model.MotorEletrico;

public class MotorEletricoMapper implements EquipamentoMapper {

    @Override
    public Equipamento toEntity(EquipamentoAdicionarRequest equipamento) {
        return new MotorEletrico(GeradorDeCodigo.gerarCodigo(), equipamento.preco(), equipamento.quantidade(), equipamento.nome(),equipamento.potencia());
    }
}

