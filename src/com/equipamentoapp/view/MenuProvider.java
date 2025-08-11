package com.equipamentoapp.view;

import com.equipamentoapp.infra.Leitor;
import com.equipamentoapp.view.menu.Menu;

public class MenuProvider {

    private Menu<?> menu;

    private final Leitor leitor;

    public MenuProvider(Menu<?> menu, Leitor leitor){
        this.menu = menu;
        this.leitor = leitor;
    }

    public void iniciarFluxo(){
        menu.chamarMenu(leitor);
        menu.executarAcao();
        menu = menu.proximoMenu();
    }

    public boolean verificarContinuedade(){
        return menu != null;
    }

}
