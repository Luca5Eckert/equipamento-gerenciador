package com.equipamentoapp.service;

import com.equipamentoapp.dto.EquipamentoAdicionarRequest;
import com.equipamentoapp.dto.EquipamentoRequest;
import com.equipamentoapp.dto.EquipamentoResponse;
import com.equipamentoapp.infra.MapperFactory;
import com.equipamentoapp.mapper.EquipamentoMapper;
import com.equipamentoapp.mapper.EquipamentoResponseMapper;
import com.equipamentoapp.model.Equipamento;
import com.equipamentoapp.model.Estoque;
import com.equipamentoapp.model.enums.TipoEquipamento;
import com.equipamentoapp.util.MapperUtils;

import java.util.ArrayList;
import java.util.List;

public class EstoqueServiceImpl implements EstoqueService {

    private final Estoque estoque;

    public EstoqueServiceImpl(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public void cadastrarEquipamento(EquipamentoAdicionarRequest equipamentoDto) {
        EquipamentoMapper equipamentoMapper = MapperFactory.toInstance(equipamentoDto.tipoEquipamento());

        Equipamento equipamento =  equipamentoMapper.toEntity(equipamentoDto);

        estoque.adicionarEsquipamento(equipamento.pegarTipo(), equipamento);
    }

    @Override
    public List<EquipamentoResponse> listarEquipamentos() {
        EquipamentoResponseMapper equipamentoResponseMapper = MapperUtils.toInstanceEquipamentoResponseMapper();
        var listaEntidades = estoque.pegarEquipamentos();

        List<EquipamentoResponse> equipamentoResponseList = new ArrayList<>();
        listaEntidades.forEach(item -> equipamentoResponseList.add(equipamentoResponseMapper.toResponse(item)));
        return equipamentoResponseList;
    }

    @Override
    public List<EquipamentoResponse> listarEquipamentosPorTipo(TipoEquipamento tipoEquipamento) {
        EquipamentoResponseMapper equipamentoResponseMapper = MapperUtils.toInstanceEquipamentoResponseMapper();
        var listaEntidades = estoque.pegarEquipamentos(tipoEquipamento);

        List<EquipamentoResponse> equipamentoResponseList = new ArrayList<>();
        listaEntidades.forEach(item -> equipamentoResponseList.add(equipamentoResponseMapper.toResponse(item)));
        return equipamentoResponseList;
    }

    @Override
    public EquipamentoResponse listarPorCodigo(String codigo) {
        EquipamentoResponseMapper equipamentoResponseMapper = MapperUtils.toInstanceEquipamentoResponseMapper();
        Equipamento equipamento = estoque.pegarEquipamento(codigo);
        return equipamentoResponseMapper.toResponse(equipamento);
    }

    @Override
    public void removerPorCodigo(String codigo) {
        estoque.removerEquipamento(codigo);
    }

    @Override
    public void alterarEstoque(EquipamentoRequest equipamentoRequest, int diferenca) {
        Equipamento equipamento = estoque.pegarEquipamento(equipamentoRequest.codigo());
        equipamento.alterarQuantidade(diferenca);
        estoque.alterarEstoqueQuantidade(diferenca, equipamento);
    }

    @Override
    public void visualizarEquipamento(String codigo) {
        System.out.println(estoque.pegarEquipamento(codigo));
    }

    @Override
    public int pegarQuantidadeEmEstoque() {
        return Estoque.getQuantidadeEstoque();
    }

    @Override
    public EquipamentoResponse pegarEquipamentoComMaiorPreco() {
        EquipamentoResponseMapper equipamentoResponseMapper = MapperUtils.toInstanceEquipamentoResponseMapper();
        return equipamentoResponseMapper.toResponse(Estoque.getEquipamentoMaiorPreco());
    }

    @Override
    public EquipamentoResponse pegarEquipamentoComMaiorQuantidade() {
        EquipamentoResponseMapper equipamentoResponseMapper = MapperUtils.toInstanceEquipamentoResponseMapper();
        return equipamentoResponseMapper.toResponse(Estoque.getEquipamentoMaiorPreco());
    }

    @Override
    public List<EquipamentoResponse> pegarEquipamentosComMenorQuantidade() {
        EquipamentoResponseMapper equipamentoResponseMapper = MapperUtils.toInstanceEquipamentoResponseMapper();
        var listaEntidades = estoque.pegarEquipamentosComMenorQuantidades();

        List<EquipamentoResponse> equipamentoResponseList = new ArrayList<>();
        listaEntidades.forEach(item -> equipamentoResponseList.add(equipamentoResponseMapper.toResponse(item)));
        return equipamentoResponseList;
    }

    @Override
    public List<EquipamentoResponse> listarEquipamentosPorPreco(double precoDesejado) {
        EquipamentoResponseMapper equipamentoResponseMapper = MapperUtils.toInstanceEquipamentoResponseMapper();
        var listaEntidades = estoque.listarEquipamentosPorPreco(precoDesejado);

        List<EquipamentoResponse> equipamentoResponseList = new ArrayList<>();
        listaEntidades.forEach(item -> equipamentoResponseList.add(equipamentoResponseMapper.toResponse(item)));
        return equipamentoResponseList;
    }

    @Override
    public List<EquipamentoResponse> listarEquipamentosPorNome(String nomeDesejado) {
        EquipamentoResponseMapper equipamentoResponseMapper = MapperUtils.toInstanceEquipamentoResponseMapper();
        var listaEntidades = estoque.listarEquipamentosPorNome(nomeDesejado);

        List<EquipamentoResponse> equipamentoResponseList = new ArrayList<>();
        listaEntidades.forEach(item -> equipamentoResponseList.add(equipamentoResponseMapper.toResponse(item)));
        return equipamentoResponseList;
    }


}
