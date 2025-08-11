package com.equipamentoapp.controller;

import com.equipamentoapp.service.EstoqueService;

public class EquipamentoController {

    private final EstoqueService estoqueService;

    public EquipamentoController(EstoqueService estoqueService){
        this.estoqueService = estoqueService;
    }


}
