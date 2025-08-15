package com.equipamentoapp.view.menu;

import com.equipamentoapp.controller.EstoqueController;
import com.equipamentoapp.dto.EquipamentoResponse;
import com.equipamentoapp.model.enums.TipoEquipamento;
import com.equipamentoapp.view.Leitor;

import java.util.ArrayList;
import java.util.List;

public class MenuListarEquipamentosPorTipo extends Menu<TipoEquipamento[]>{

    private final EstoqueController estoqueController;

    private Menu<?> proximoMenu;

    private Leitor leitor;

    public MenuListarEquipamentosPorTipo(EstoqueController estoqueController) {
        this.estoqueController = estoqueController;
    }

    @Override
    public void chamarMenu(Leitor leitor) {
        this.leitor = leitor;

        System.out.println("==========================================");
        System.out.println("            LISTAR EQUIPAMENTOS           ");
        System.out.println("==========================================");
        System.out.println(" S - SAIR ");
        System.out.println("------------------------------------------");
        TipoEquipamento[] tipoEquipamentos = selecionarTipoEspecifico(leitor);
        setResposta(tipoEquipamentos);



    }

    private void listarEquipamentos(List<EquipamentoResponse> listaEquipamentos) {
        System.out.println("====================================");
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

    private TipoEquipamento[] selecionarTipoEspecifico(Leitor leitor) {
        System.out.println(" T- Todos os tipos ");
        TipoEquipamento.listarTodos();
        String opcao = leitor.lerLinha().toUpperCase().trim();
        System.out.println("------------------------------------------");

        return switch(opcao){
            case "T" -> TipoEquipamento.values();
            case "S" -> null;
            default -> new TipoEquipamento[]{TipoEquipamento.values()[Integer.parseInt(opcao)]};
        };
    }

    @Override
    public void executarAcao() {
        if(getResposta() == null){
            proximoMenu = new MenuInicial();
            return;
        }

        List<EquipamentoResponse> listaUsuarios = new ArrayList<>();
        if(getResposta().length == TipoEquipamento.values().length){
            listaUsuarios.addAll(estoqueController.listarEquipamentos());
        } else {
            listaUsuarios.addAll(estoqueController.listarEquipamentosPorTipo(getResposta()[0]));
        }

        listarEquipamentos(listaUsuarios);
        System.out.println("S - Sair");
        System.out.println("A - Atualizar");
        String inputFinal = leitor.lerLinha().trim();

        if(inputFinal.equalsIgnoreCase("S")){
            proximoMenu = new MenuInicial();
            return;
        }
        proximoMenu = this;

    }

    @Override
    public Menu<?> proximoMenu() {
        return proximoMenu;
    }
}
