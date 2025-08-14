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
        int quantidadeEstoque = estoqueController.

        System.out.println("==========================================");
        System.out.println("            ESTOQUE EQUIPAMENTO           ");
        System.out.println("==========================================");
        System.out.println(" Quantidade no estoque: ");
        System.out.println();
    }

    @Override
    public void executarAcao() {

    }

    @Override
    public Menu<?> proximoMenu() {
        return null;
    }
}
