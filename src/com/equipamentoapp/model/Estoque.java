package com.equipamentoapp.model;

import com.equipamentoapp.exception.EstoqueException;
import com.equipamentoapp.model.enums.TipoEquipamento;

import java.util.*;

public class Estoque {
    
    private static final Map<TipoEquipamento, Map<String, Equipamento>> equipamentos = new HashMap<>();

    private static int quantidadeEstoque = 0;
    private static Equipamento equipamentoMaiorEstoque;
    private static Equipamento equipamentoMaiorPreco;
    
    public void adicionarEsquipamento(TipoEquipamento tipoEquipamento, Equipamento equipamento){
        if(!existeListaPorTipo(tipoEquipamento)){
            equipamentos.put(tipoEquipamento, new HashMap<>());
        }
        verificarEquipamentoAntesAdicionar(equipamento);

        equipamentos.get(tipoEquipamento).put( equipamento.getCodigo(), equipamento);


    }
    
    public void removerEquipamento(String codigo, TipoEquipamento tipoEquipamento){
        if(!existeListaPorTipo(tipoEquipamento)){
            throw new EstoqueException("O tipo não possui equipamentos");
        }
        if(equipamentos.get(tipoEquipamento).containsKey(codigo)){
            throw new EstoqueException("Não foi possível achar o equipamento");
        }

        verificarEquipamentoAntesApagar(codigo);

        equipamentos.get(tipoEquipamento).remove(codigo);
    }

    private void verificarEquipamentoAntesAdicionar(Equipamento equipamento){
        quantidadeEstoque += equipamento.getQuantidade();

        if(equipamentoMaiorPreco == null || equipamento.getPreco() > equipamentoMaiorPreco.getPreco()){
            equipamentoMaiorPreco = equipamento;
        }
        if(equipamentoMaiorEstoque == null || equipamento.getQuantidade() > equipamentoMaiorEstoque.getQuantidade()){
            equipamentoMaiorEstoque = equipamento;
        }
    }


    private void verificarEquipamentoAntesApagar(String codigo) {
        Equipamento equipamento = pegarEquipamento(codigo);

        quantidadeEstoque -= quantidadeEstoque;

        if(equipamento == equipamentoMaiorEstoque){
            definirEquipamentoComMaiorEstoque();
        }
        if(equipamento == equipamentoMaiorPreco){
            definirEquipamentoMaisCaro();
        }

    }

    public void removerEquipamento(String codigo){
        for(Map.Entry<TipoEquipamento, Map<String, Equipamento>> entrada : equipamentos.entrySet()){
            verificarEquipamentoAntesApagar(codigo);
            entrada.getValue().remove(codigo);
            return;
        }
        throw new EstoqueException("Não foi possível achar o equipamento");
    }
    
    
    
    public Equipamento pegarEquipamento(String codigo){
        for(Map.Entry<TipoEquipamento, Map<String, Equipamento>> entrada : equipamentos.entrySet()){
            if(entrada.getValue().containsKey(codigo)){
                return entrada.getValue().get(codigo);
            }
        }
        throw new EstoqueException("Não foi possível achar o equipamento");
    }
    
    public List<Equipamento> pegarEquipamentos(TipoEquipamento tipoEquipamento){
        if(!existeListaPorTipo(tipoEquipamento)){
            throw new EstoqueException("O tipo não possui equipamentos");
        }
        return List.copyOf(equipamentos.get(tipoEquipamento).values());
    }
    
    public List<Equipamento> pegarEquipamentos(){
        List<Equipamento> lista = new ArrayList<>();
        if(equipamentos.isEmpty()){
            throw new EstoqueException("Estoque vazio");
        }
        for(Map.Entry<TipoEquipamento, Map<String, Equipamento>> entrada : equipamentos.entrySet()){
            lista.addAll(entrada.getValue().values());
        }
        return lista;
    }
    
    private boolean existeListaPorTipo(TipoEquipamento tipoEquipamento){
        return equipamentos.containsKey(tipoEquipamento);
    }

    public void definirEquipamentoMaisCaro(){
        List<Equipamento> equipamentos = pegarEquipamentos();

        equipamentoMaiorPreco = equipamentos.stream().max(Comparator.comparingDouble(Equipamento::getPreco)).orElseThrow(() -> new EstoqueException("Estoque vazio"));
        
    }
    
    public void definirEquipamentoComMaiorEstoque(){
        List<Equipamento> equipamentos = pegarEquipamentos();

        equipamentoMaiorPreco = equipamentos.stream().max(Comparator.comparingInt(Equipamento::getQuantidade)).orElseThrow(() -> new EstoqueException("Estoque vazio"));
    }


    public void alterarEstoqueQuantidade(int diferenca, Equipamento equipamento) {
        quantidadeEstoque += diferenca;
        verificarEquipamentoAntesAdicionar(equipamento);
        verificarEquipamentoAntesApagar(equipamento.getCodigo());
    }
}
