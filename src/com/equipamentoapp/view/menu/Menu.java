package com.equipamentoapp.view.menu;

import com.equipamentoapp.infra.Leitor;

public abstract class Menu<T> {
    private T resposta;

    public T getResposta(){
        return resposta;
    }

    public void setResposta(T resposta){
        this.resposta = resposta;
    }

    public abstract void chamarMenu(Leitor leitor);

    public abstract void executarAcao();

    public abstract Menu proximoMenu();


}
