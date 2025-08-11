package com.equipamentoapp.view;

import java.util.Scanner;

public abstract class Menu<T> {
    T resposta;

    abstract void chamarMenu(Scanner scanner);

    abstract void executarAcao();

    abstract void proximoMenu();


}
