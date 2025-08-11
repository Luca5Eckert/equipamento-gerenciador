package com.equipamentoapp;

import com.equipamentoapp.infra.Leitor;
import com.equipamentoapp.view.MenuManager;
import com.equipamentoapp.view.MenuProvider;
import com.equipamentoapp.view.menu.MenuInicial;

public class Main {
    public static void main(String[] args) {

        try {
            MenuManager menuManager = new MenuManager(new MenuProvider(new MenuInicial(), new Leitor()));
            menuManager.iniciarMenu();
        } catch (Exception e){
            System.err.println("ERRO!!!");
        }

    }
}