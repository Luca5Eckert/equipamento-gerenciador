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
        System.out.println("==========================================");
        System.out.println("            ESTOQUE EQUIPAMENTO           ");
        System.out.println("==========================================");
        
        RelatorioRequest relatorioRequest = null;
        try{
            relatorioRequest = estoqueController.pegarRelatorioEstoque();

            System.out.println(" Quantidade no estoque: " + relatorioRequest.quantidadeEstoque() );
            System.out.println("\n Equipamento com maior preço: ");
            System.out.println(" Código: " + relatorioRequest.equipamentoMaiorPreco().codigo() + " - Preço: " + relatorioRequest.equipamentoMaiorPreco().preco());

            System.out.println("\n Equipamento com maior quantidade: ");
            System.out.println(" Código: " + relatorioRequest.equipamentoMaiorQuantidade().codigo() + " - Preço: " + relatorioRequest.equipamentoMaiorQuantidade().quantidade());

            System.out.println("\n Equipamentos com menos de 5 unidades: ");
            relatorioRequest.equipamentosMenorPreco().forEach(e -> System.out.println(" Código: " + e.codigo() + " - Quantidade:"  + e.quantidade()));

        } catch (RuntimeException e) {
            System.out.println( e.getMessage());
        }


        System.out.println("\n------------------------------------------");
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
            default -> proximoMenu;
        };
    }

    @Override
    public Menu<?> proximoMenu() {
        return proximoMenu;
    }
}
