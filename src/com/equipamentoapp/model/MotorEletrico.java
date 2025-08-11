package com.equipamentoapp.model;

import com.equipamentoapp.model.enums.TipoEquipamento;

public class MotorEletrico extends Equipamento {

    private double potencia;

    public MotorEletrico(String codigo, double preco, int quantidade, String nome, double potencia) {
        super(preco, quantidade, nome, codigo);
        this.potencia = potencia;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    @Override
    public TipoEquipamento pegarTipo() {
        return TipoEquipamento.MOTOR_ELETRICO;
    }
}
