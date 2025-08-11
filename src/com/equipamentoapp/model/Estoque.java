package com.equipamentoapp.model;

import com.equipamentoapp.exception.EstoqueException;
import com.equipamentoapp.model.enums.TipoEquipamento;

import java.util.*;

public class Estoque {
    
    private static final Map<TipoEquipamento, Map<String, Equipamento>> equipamentos = new HashMap<>();
    
    public void adicionarEsquipamento(TipoEquipamento tipoEquipamento, Equipamento equipamento){
        if(!existeListaPorTipo(tipoEquipamento)){
            equipamentos.put(tipoEquipamento, new HashMap<>());
        }
        equipamentos.get(tipoEquipamento).put( equipamento.getCodigo(), equipamento);
    }
    
    public void apagarEquipamento(String codigo, TipoEquipamento tipoEquipamento){
        if(!existeListaPorTipo(tipoEquipamento)){
            throw new EstoqueException("O tipo não possui equipamentos");
        }
        if(equipamentos.get(tipoEquipamento).containsKey(codigo)){
            throw new EstoqueException("Não foi possível achar o equipamento");
        }
        equipamentos.get(tipoEquipamento).remove(codigo);
    }

    public void apagarEquipamento(String codigo){
        for(Map.Entry<TipoEquipamento, Map<String, Equipamento>> entrada : equipamentos.entrySet()){
            entrada.getValue().remove(codigo);
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
    
    
    
}
