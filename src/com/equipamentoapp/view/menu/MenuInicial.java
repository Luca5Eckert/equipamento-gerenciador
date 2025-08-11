package com.equipamentoapp.view.menu;

import com.equipamentoapp.infra.Leitor;

public class MenuInicial extends Menu<String>{

    @Override
    public void chamarMenu(Leitor leitor) {
        System.out.println("teste");
    }

    @Override
    public void executarAcao() {
        System.out.println("teste");

    }

    @Override
    public Menu<?> proximoMenu() {
        System.out.println("teste");

        return null;
    }
}
