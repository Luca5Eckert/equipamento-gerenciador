package com.equipamentoapp.view.menu;

import com.equipamentoapp.controller.EstoqueController;
import com.equipamentoapp.view.Leitor;

public class MenuRelatorioEstoque extends Menu<String>{

    private final EstoqueController estoqueController;

    public MenuRelatorioEstoque(EstoqueController estoqueController) {
        this.estoqueController = estoqueController;
    }

    @Override
    public void chamarMenu(Leitor leitor) {

    }

    @Override
    public void executarAcao() {

    }

    @Override
    public Menu<?> proximoMenu() {
        return null;
    }
}
