package com.equipamentoapp.mapper;

import com.equipamentoapp.dto.EquipamentoAdicionarRequest;
import com.equipamentoapp.infra.GeradorDeCodigo;
import com.equipamentoapp.model.Equipamento;
import com.equipamentoapp.model.PainelControle;

public class PainelControleMapper implements EquipamentoMapper {


    @Override
    public Equipamento toEntity(EquipamentoAdicionarRequest equipamento) {
        return new PainelControle(GeradorDeCodigo.gerarCodigo(), equipamento.preco(), equipamento.quantidade(), equipamento.nome(), equipamento.tensao());
    }
}
