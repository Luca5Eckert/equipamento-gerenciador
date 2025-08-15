package com.equipamentoapp.service;

import com.equipamentoapp.dto.EquipamentoAdicionarRequest;
import com.equipamentoapp.dto.EquipamentoRequest;
import com.equipamentoapp.dto.EquipamentoResponse;
import com.equipamentoapp.model.Equipamento;
import com.equipamentoapp.model.enums.TipoEquipamento;

import java.util.List;

public interface EstoqueService {

    void cadastrarEquipamento(EquipamentoAdicionarRequest equipamentoDto);

    List<EquipamentoResponse> listarEquipamentos();

    List<EquipamentoResponse> listarEquipamentosPorTipo(TipoEquipamento tipoEquipamento);

    EquipamentoResponse listarPorCodigo(String codigo);

    void removerPorCodigo(String codigo);

    void alterarEstoque(EquipamentoRequest equipamentoRequest, int diferenca);

    void visualizarEquipamento(String codigo);

    int pegarQuantidadeEmEstoque();

    EquipamentoResponse pegarEquipamentoComMaiorPreco();

    EquipamentoResponse pegarEquipamentoComMaiorQuantidade();

    List<EquipamentoResponse> pegarEquipamentosComMenorQuantidade();

    List<EquipamentoResponse> listarEquipamentosPorPreco(double precoDesejado);

    List<EquipamentoResponse> listarEquipamentosPorNome(String nomeDesejado);
}
