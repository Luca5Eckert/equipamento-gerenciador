package com.equipamentoapp.view.menu;

import com.equipamentoapp.view.Leitor;

public abstract class Menu<T> {
    private T resposta;

    T getResposta(){
        return resposta;
    }

    void setResposta(T resposta){
        this.resposta = resposta;
    }

    public abstract void chamarMenu(Leitor leitor);

    public abstract void executarAcao();

    public abstract Menu<?> proximoMenu();


}
