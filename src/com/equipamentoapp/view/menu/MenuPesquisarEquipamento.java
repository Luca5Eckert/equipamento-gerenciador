package com.equipamentoapp.view.menu;

import com.equipamentoapp.controller.EstoqueController;
import com.equipamentoapp.dto.EquipamentoRequest;
import com.equipamentoapp.dto.EquipamentoResponse;
import com.equipamentoapp.view.Leitor;

public class MenuPesquisarEquipamento extends Menu<EquipamentoRequest>{

    private Menu<?> proximoMenu;

    private final EstoqueController estoqueController;

    public MenuPesquisarEquipamento(EstoqueController estoqueController) {
        this.estoqueController = estoqueController;
    }


    @Override
    public void chamarMenu(Leitor leitor) {
        System.out.println("==========================================");
        System.out.println("           PESQUISAR EQUIPAMENTO          ");
        System.out.println("==========================================");
        System.out.println(" S - Sair");
        System.out.println(" Digite o código do equipamento: ");
        String codigoEquipamento = leitor.lerLinha();

        setResposta(new EquipamentoRequest(codigoEquipamento));
    }

    @Override
    public void executarAcao() {
        switch ()
        EquipamentoResponse equipamentoResponse = estoqueController.listarPorCodigo(getResposta().codigo());
        proximoMenu = new MenuVisualizadorEquipamento(estoqueController, equipamentoResponse);
    }

    @Override
    public Menu<?> proximoMenu() {
        return proximoMenu;
    }
}
