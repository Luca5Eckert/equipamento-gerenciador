package com.equipamentoapp.view;

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
            int numero = scanner.nextInt();
            scanner.nextLine();
            return numero;
        } catch (RuntimeException e) {
            tratarErro(e);
            return lerNumero();
        }
    }

    public double lerNumeroDouble(){
        try{
            double numero = scanner.nextDouble();
            scanner.nextLine();
            return numero;
        } catch (RuntimeException e) {
            tratarErro(e);
            return lerNumeroDouble();
        }
    }


    private void tratarErro(RuntimeException re){
        scanner.nextLine();
        System.out.println("Algum erro aconteceu ao ler a linha");
        System.out.println("Tente novamente");
    }

}
