package com.equipamentoapp.dto;

import java.util.List;

public record RelatorioRequest(int quantidadeEstoque, EquipamentoResponse equipamentoMaiorPreco, EquipamentoResponse equipamentoMaiorQuantidade, List<EquipamentoResponse> equipamentosMenorPreco) {
}
