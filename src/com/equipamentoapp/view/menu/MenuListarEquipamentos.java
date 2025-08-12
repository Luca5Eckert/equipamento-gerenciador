package com.equipamentoapp.view.menu;

import com.equipamentoapp.view.Leitor;

public class MenuListarEquipamentos extends Menu<String>{


    @Override
    public void chamarMenu(Leitor leitor) {
        System.out.println("==========================================");
        System.out.println("            LISTAR EQUIPAMENTOS           ");
        System.out.println("==========================================");
    }

    @Override
    public void executarAcao() {

    }

    @Override
    public Menu<?> proximoMenu() {
        return null;
    }
}
