package com.equipamentoapp.dto;

import com.equipamentoapp.model.Equipamento;

import java.util.List;

public record RelatorioRequest(int quantidadeEstoque, EquipamentoResponse equipamentoMaiorPreco, EquipamentoResponse equipamentoMenorPreco, List<EquipamentoResponse> equipamentosMenorPreco) {
}
