package com.equipamentoapp.model.enums;

public enum TipoEquipamento {

    MOTOR_ELETRICO,
    PAINEL_CONTROLE;

    public static void listarTodos(){
        int i = 0;
        for (TipoEquipamento tipoEquipamento : TipoEquipamento.values()){
            System.out.println(" " + i + " - " + tipoEquipamento);
            i++;
        }
    }


}
