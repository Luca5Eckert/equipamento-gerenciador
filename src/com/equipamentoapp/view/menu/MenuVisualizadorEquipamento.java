package com.equipamentoapp.view.menu;

import com.equipamentoapp.controller.EstoqueController;
import com.equipamentoapp.dto.EquipamentoRequest;
import com.equipamentoapp.dto.EquipamentoResponse;
import com.equipamentoapp.view.Leitor;

public class MenuVisualizadorEquipamento extends Menu<String>{

    private Menu<?> proximoMenu;

    private final EstoqueController estoqueController;

    private final EquipamentoResponse equipamentoResponse;

    private Leitor leitor;

    public MenuVisualizadorEquipamento(EstoqueController estoqueController, EquipamentoResponse equipamentoResponse) {
        this.estoqueController = estoqueController;
        this.equipamentoResponse = equipamentoResponse;
    }

    @Override
    public void chamarMenu(Leitor leitorAntigo) {
        this.leitor = leitorAntigo;

        System.out.println("==========================================");
        System.out.println("           VISUALIZAR EQUIPAMENTO         ");
        System.out.println("==========================================");
        estoqueController.visualizarEquipamento(equipamentoResponse);
        System.out.println(" 1- Remover             2- Sair ");
        System.out.println(" 3- Adicionar Unidades  4- Remover Unidades");
        setResposta(leitor.lerLinha());
    }

    @Override
    public void executarAcao() {
        switch (getResposta()){
            case "1" -> removerEquipamento();
            case "2" -> proximoMenu = new MenuInicial();
            case "3" -> adicionarUnidades();
            case "4" -> removerUnidades();
        }
    }

    private void removerUnidades() {
        System.out.println(" Quantidade a remover: ");
        int remover = leitor.lerNumero();
        estoqueController.alterarEstoque(new EquipamentoRequest(equipamentoResponse.codigo()), -remover);
        proximoMenu = this;
    }

    private void adicionarUnidades() {
        System.out.println(" Quantidade a adicionar: ");
        int adicionar = leitor.lerNumero();
        estoqueController.alterarEstoque(new EquipamentoRequest(equipamentoResponse.codigo()), adicionar);
        proximoMenu = this;
    }

    private void removerEquipamento() {
        estoqueController.removerPorCodigo(equipamentoResponse.codigo());
        System.out.println("Apagado com sucesso");
        proximoMenu = new MenuInicial();
    }

    @Override
    public Menu<?> proximoMenu() {
        return proximoMenu;
    }
}
