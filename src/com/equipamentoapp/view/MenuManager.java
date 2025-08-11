package com.equipamentoapp.view;

public class MenuManager {

    private final MenuProvider menuProvider;

    public MenuManager(MenuProvider menuProvider) {
        this.menuProvider = menuProvider;
    }

    public void iniciarMenu(){
        while(menuProvider.verificarContinuedade()){
            menuProvider.iniciarFluxo();
        }
    }
}
