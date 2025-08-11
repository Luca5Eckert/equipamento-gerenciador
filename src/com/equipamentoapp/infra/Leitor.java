package com.equipamentoapp.infra;

import java.util.Scanner;

public class Leitor {

    private final Scanner scanner = new Scanner(System.in);

    public String lerLinha(){
        try{
            return scanner.nextLine();
        } catch (RuntimeException e) {
            tratarErro(e);
            return lerLinha();
        }
    }

    public int lerNumero(){
        try{
            return scanner.nextInt();
        } catch (RuntimeException e) {
            tratarErro(e);
            return lerNumero();
        }
    }

    private void tratarErro(RuntimeException re){
        System.out.println("Algum erro aconteceu ao ler a linha");
        System.out.println("Tente novamente");
    }

}
