package com.equipamentoapp.controller;

import com.equipamentoapp.dto.EquipamentoAdicionarRequest;
import com.equipamentoapp.dto.EquipamentoRequest;
import com.equipamentoapp.dto.EquipamentoResponse;
import com.equipamentoapp.model.enums.TipoEquipamento;
import com.equipamentoapp.service.EstoqueService;

import java.util.List;

public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService){
        this.estoqueService = estoqueService;
    }

    public void cadastrarEquipamento(EquipamentoAdicionarRequest equipamentoDto) {
        estoqueService.cadastrarEquipamento(equipamentoDto);
    }

    public List<EquipamentoResponse> listarEquipamentos() {
        return estoqueService.listarEquipamentos();
    }

    public List<EquipamentoResponse> listarEquipamentosPorTipo(TipoEquipamento tipoEquipamento) {
        return estoqueService.listarEquipamentosPorTipo(tipoEquipamento);
    }

    public EquipamentoResponse listarPorCodigo(String codigo){
        return estoqueService.listarPorCodigo(codigo);
    }


    public void removerPorCodigo(String codigo){
        estoqueService.removerPorCodigo(codigo);
    }

    public void alterarEstoque(EquipamentoRequest equipamentoRequest, int diferenca){
        estoqueService.alterarEstoque(equipamentoRequest, diferenca);
    }



}
