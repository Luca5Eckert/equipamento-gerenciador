package com.equipamentoapp.view.menu;

import com.equipamentoapp.controller.EstoqueController;
import com.equipamentoapp.dto.EquipamentoResponse;
import com.equipamentoapp.view.Leitor;

import java.util.List;

public class MenuListarEquipamentosPorNome extends Menu<String> {

    private final EstoqueController estoqueController;
    private Menu<?> proximoMenu;

    public MenuListarEquipamentosPorNome(EstoqueController estoqueController) {
        this.estoqueController = estoqueController;
    }

    @Override
    public void chamarMenu(Leitor leitor) {
        System.out.println("==========================================");
        System.out.println("            LISTAR EQUIPAMENTOS           ");
        System.out.println("==========================================");
        System.out.println(" Nome desejado: ");
        String nomeDesejado = leitor.lerLinha();

        List<EquipamentoResponse> listaEquipamentos = estoqueController.listarEquipamentosPorNome(nomeDesejado);

        listarEquipamentos(listaEquipamentos);

        System.out.println("------------------------------------------");

        System.out.println(" S- Sair");
        System.out.println(" T- Tenter outro Nome");
        System.out.println("==========================================");

        setResposta(leitor.lerLinha());


    }

    private void listarEquipamentos(List<EquipamentoResponse> listaEquipamentos) {
        System.out.println(" EQUIPAMENTOS: ");
        if(listaEquipamentos.isEmpty()){
            System.out.println(" Estoque Vazio ");
            return;
        }
        listaEquipamentos.forEach(System.out::println);
    }

    @Override
    public void executarAcao() {
        proximoMenu = switch (getResposta()){
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
