package com.equipamentoapp.view.menu;

import com.equipamentoapp.model.enums.TipoEquipamento;
import com.equipamentoapp.view.Leitor;

public class MenuListarEquipamentos extends Menu<String>{


    @Override
    public void chamarMenu(Leitor leitor) {
        System.out.println("==========================================");
        System.out.println("            LISTAR EQUIPAMENTOS           ");
        System.out.println("==========================================");
        TipoEquipamento[] tipoEquipamentos = selecionarTipoEspecifico(leitor);
    }

    private TipoEquipamento[] selecionarTipoEspecifico(Leitor leitor) {
        System.out.println(" T- Todos os tipos ");
        System.out.println(" Ou selecionar tipo especifico:");
        TipoEquipamento.listarTodos();
        String opcao = leitor.lerLinha();

        return switch(opcao){
            case "T" -> TipoEquipamento.values();
            default -> new TipoEquipamento[]{TipoEquipamento.values()[Integer.parseInt(opcao)]};
        };
    }

    @Override
    public void executarAcao() {

    }

    @Override
    public Menu<?> proximoMenu() {
        return null;
    }
}
