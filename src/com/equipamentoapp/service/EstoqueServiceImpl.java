package com.equipamentoapp.service;

import com.equipamentoapp.dto.EquipamentoAdicionarRequest;
import com.equipamentoapp.dto.EquipamentoRequest;
import com.equipamentoapp.dto.EquipamentoResponse;
import com.equipamentoapp.infra.MapperFactory;
import com.equipamentoapp.mapper.EquipamentoMapper;
import com.equipamentoapp.model.Estoque;
import com.equipamentoapp.model.enums.TipoEquipamento;

import java.util.List;

public class EstoqueServiceImpl implements EstoqueService {

    private final Estoque estoque;

    public EstoqueServiceImpl(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public void cadastrarEquipamento(EquipamentoAdicionarRequest equipamentoDto) {
        EquipamentoMapper<?> equipamentoMapper = MapperFactory.toInstance(equipamentoDto.tipoEquipamento());
        equipamentoMapper.toEntity(equipamentoDto);
    }

    @Override
    public List<EquipamentoResponse> listarEquipamentos() {
        return List.of();
    }

    @Override
    public List<EquipamentoResponse> listarEquipamentosPorTipo(TipoEquipamento tipoEquipamento) {
        return List.of();
    }

    @Override
    public EquipamentoResponse listarPorCodigo(String codigo) {
        return null;
    }

    @Override
    public void removerPorCodigo(String codigo) {

    }

    @Override
    public void alterarEstoque(EquipamentoRequest equipamentoRequest, int diferenca) {

    }
}
