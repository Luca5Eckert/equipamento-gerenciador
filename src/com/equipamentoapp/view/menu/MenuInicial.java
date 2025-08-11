package com.equipamentoapp.view.menu;

import com.equipamentoapp.controller.EstoqueController;
import com.equipamentoapp.exception.ViewException;
import com.equipamentoapp.view.Leitor;
import com.equipamentoapp.model.Estoque;
import com.equipamentoapp.service.EstoqueServiceImpl;

public class MenuInicial extends Menu<String>{

    private Menu<?> proximoMenu;

    @Override
    public void chamarMenu(Leitor leitor) {
        System.out.println("==========================================");
        System.out.println("       BEM-VINDO, DESEJA O QUE HOJE ?");
        System.out.println("==========================================");
        System.out.println(" 1- Adicionar Equipamento");
        System.out.println(" 2- Pesquisar Equipamento");
        System.out.println(" 3- Listar Equipamentos");
        System.out.println(" 4- Sair \n");
        System.out.println(" * Para deletar ou modificar é preciso ");
        System.out.println(" primeiro pesquisar");
        System.out.println("==========================================");

        setResposta(leitor.lerLinha());
    }

    @Override
    public void executarAcao() {
        EstoqueController estoqueController = new EstoqueController(new EstoqueServiceImpl(new Estoque()));
        switch(getResposta()){
            case "1" -> proximoMenu = new MenuAdicionarEquipamento(estoqueController);
            case "2" -> proximoMenu = new MenuPesquisarEquipamento(estoqueController);
            case "4" -> proximoMenu = null;
            default -> throw new ViewException("Valor digitado não possui correspondencia");
        }
    }

    @Override
    public Menu<?> proximoMenu() {
        return proximoMenu;
    }
}
