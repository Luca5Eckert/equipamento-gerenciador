package com.equipamentoapp.dto;

public record EquipamentoResponse(String codigo, String nome, int quantidade) {

    @Override
    public String toString() {
        return " " + codigo + " - " + nome;
    }
}
