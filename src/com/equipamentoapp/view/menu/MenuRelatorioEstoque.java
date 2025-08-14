package com.equipamentoapp.view.menu;

import com.equipamentoapp.controller.EstoqueController;
import com.equipamentoapp.dto.RelatorioRequest;
import com.equipamentoapp.view.Leitor;

public class MenuRelatorioEstoque extends Menu<String>{

    private final EstoqueController estoqueController;

    private Menu<?> proximoMenu;

    public MenuRelatorioEstoque(EstoqueController estoqueController) {
        this.estoqueController = estoqueController;
    }

    @Override
    public void chamarMenu(Leitor leitor) {
        RelatorioRequest relatorioRequest = estoqueController.pegarRelatorioEstoque();

        System.out.println("==========================================");
        System.out.println("            ESTOQUE EQUIPAMENTO           ");
        System.out.println("==========================================");
        System.out.println(" Quantidade no estoque: " + relatorioRequest.quantidadeEstoque() );
        System.out.println(" Equipamento com maior preço: ");
        System.out.print(" " + relatorioRequest.equipamentoMaiorPreco().codigo() + " - " + relatorioRequest.equipamentoMaiorPreco().preco());

        System.out.println(" Equipamento com maior quantidade: ");
        System.out.println(" " + relatorioRequest.equipamentoMaiorQuantidade().codigo() + " - " + relatorioRequest.equipamentoMaiorQuantidade().quantidade());

        System.out.println(" Equipamentos com menos de 5 unidades: ");
        relatorioRequest.equipamentosMenorPreco().forEach(e -> System.out.println(" " + e.codigo() + " - "  + e.quantidade()));

        System.out.println("------------------------------------------");
        System.out.println(" S - Sair");
        System.out.println(" A - Atualizar");
        System.out.println("==========================================");
        setResposta(leitor.lerLinha().trim());
    }

    @Override
    public void executarAcao() {
        proximoMenu = switch(getResposta().toUpperCase()){
            case "S" -> new MenuInicial();
            case "A" -> this;
            default -> this;
        };
    }

    @Override
    public Menu<?> proximoMenu() {
        return proximoMenu;
    }
}
