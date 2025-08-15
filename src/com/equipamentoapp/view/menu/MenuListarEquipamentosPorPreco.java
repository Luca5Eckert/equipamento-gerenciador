package com.equipamentoapp.view.menu;

import com.equipamentoapp.controller.EstoqueController;
import com.equipamentoapp.dto.EquipamentoResponse;
import com.equipamentoapp.view.Leitor;

import java.util.List;

public class MenuListarEquipamentosPorPreco extends Menu<String>{

    private Menu<?> proximoMenu;

    private final EstoqueController estoqueController;

    public MenuListarEquipamentosPorPreco(EstoqueController estoqueController) {
        this.estoqueController = estoqueController;
    }

    @Override
    public void chamarMenu(Leitor leitor) {
        System.out.println("==========================================");
        System.out.println("            LISTAR EQUIPAMENTOS           ");
        System.out.println("==========================================");
        System.out.println(" Preço desejado: ");
        double precoDesejado = leitor.lerNumeroDouble();

        List<EquipamentoResponse> listaEquipamentos = estoqueController.listarEquipamentosPorPreco(precoDesejado);

        listarEquipamentos(listaEquipamentos);

        System.out.println("------------------------------------------");

        System.out.println(" S- Sair");
        System.out.println(" T- Tenter outro preço");
        System.out.println("==========================================");

        setResposta(leitor.lerLinha().trim());


    }

    private void listarEquipamentos(List<EquipamentoResponse> listaEquipamentos) {
        System.out.println(" EQUIPAMENTOS: ");
        if(listaEquipamentos.isEmpty()){
            System.out.println(" Estoque Vazio ");
            return;
        }
        listaEquipamentos.forEach(estoque -> {
            System.out.println("------------------------------------");
            System.out.println(estoque);
            System.out.println("------------------------------------");
        });
    }

    @Override
    public void executarAcao() {
        proximoMenu = switch (getResposta().toUpperCase()){
            case "S" -> new MenuInicial();
            case "T" -> this;
            default -> proximoMenu;
        };
    }

    @Override
    public Menu<?> proximoMenu() {
        return proximoMenu;
    }
}
