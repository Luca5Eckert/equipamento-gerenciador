package com.equipamentoapp.infra;

public final class GeradorDeCodigo {

    private static int numero = 0;

    public synchronized static String gerarCodigo(){
        numero++;
        return String.valueOf(numero);
    }

}
