package com.equipamentoapp.view.menu;

import com.equipamentoapp.infra.Leitor;

import java.util.Scanner;

public abstract class Menu<T> {
    T resposta;

    public abstract void chamarMenu(Leitor leitor);

    public abstract void executarAcao();

    public abstract Menu proximoMenu();


}
