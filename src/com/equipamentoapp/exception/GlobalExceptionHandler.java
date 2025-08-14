package com.equipamentoapp.exception;

public class GlobalExceptionHandler {

    public static String tratarExceção(Exception e){
        if(e instanceof SystemException){
            return e.getMessage();
        }
        if( e instanceof RuntimeException){
            return "Ocorreu um pequeno erro, tente novamente: " + e.getMessage();
        }
        return e.getMessage();
    }

}
