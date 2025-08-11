package com.equipamentoapp.view;

import com.equipamentoapp.view.menu.Menu;

public class MenuProvider {

    private Menu<?> menu;

    private final Leitor leitor;

    public MenuProvider(Menu<?> menu, Leitor leitor){
        this.menu = menu;
        this.leitor = leitor;
    }

    public void iniciarFluxo(){
        try {
            menu.chamarMenu(leitor);
            menu.executarAcao();
            menu = menu.proximoMenu();
        } catch ( RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
        }
    }

    public boolean verificarContinuedade(){
        return menu != null;
    }

}
