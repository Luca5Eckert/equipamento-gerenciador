package com.equipamentoapp.view.menu;

import com.equipamentoapp.exception.ViewException;
import com.equipamentoapp.infra.Leitor;

public class MenuInicial extends Menu<String>{

    private Menu<?> proximoMenu;

    @Override
    public void chamarMenu(Leitor leitor) {
        System.out.println("==========================================");
        System.out.println("       BEM-VINDO, DESEJA O QUE HOJE ?");
        System.out.println("==========================================");
        System.out.println(" 1- Adicionar Equipamento");
        System.out.println(" 2- Pesquisar Equipamento");
        System.out.println(" 3- Listar Equipamentos\n");
        System.out.println(" * Para deletar ou modificar é preciso ");
        System.out.println(" primeiro pesquisar");
        System.out.println("==========================================");

        setResposta(leitor.lerLinha());
    }

    @Override
    public void executarAcao() {
        System.out.println("Indo ao próximo menu");
        switch(getResposta()){
            case "1" -> proximoMenu = new MenuAdicionarEquipamento();
            case "2" -> proximoMenu = new MenuPesquisarEquipamento();
            default -> throw new ViewException("Valor digitado não possui correspondencia");
        }
    }

    @Override
    public Menu<?> proximoMenu() {
        return proximoMenu;
    }
}
