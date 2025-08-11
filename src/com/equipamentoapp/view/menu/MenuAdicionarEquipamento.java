package com.equipamentoapp.view.menu;

import com.equipamentoapp.controller.EstoqueController;
import com.equipamentoapp.dto.EquipamentoAdicionarRequest;
import com.equipamentoapp.view.Leitor;
import com.equipamentoapp.model.enums.TipoEquipamento;

public class MenuAdicionarEquipamento extends Menu<EquipamentoAdicionarRequest>{

    private final EstoqueController estoqueController;

    public MenuAdicionarEquipamento(EstoqueController estoqueController) {
        this.estoqueController = estoqueController;
    }

    @Override
    public void chamarMenu(Leitor leitor) {
        System.out.println("==========================================");
        System.out.println("            ADICIONAR EQUIPAMENTO         ");
        System.out.println("==========================================");
        System.out.println(" Qual tipo deseja adicionar ? ");
        TipoEquipamento.listarTodos();
        TipoEquipamento tipoEquipamento = TipoEquipamento.values()[leitor.lerNumero()];

        System.out.println(" Nome do equipamento: ");
        String nome = leitor.lerLinha();

        System.out.println(" Quantidade em estoque: ");
        int quantidade = leitor.lerNumero();

        System.out.println(" Preço do equipamento: ");
        double preco = leitor.lerNumeroDouble();

        setResposta(switch(tipoEquipamento){
            case MOTOR_ELETRICO -> adicionarMotorEletrico(leitor, nome, quantidade, preco, tipoEquipamento);
            case PAINEL_CONTROLE -> adicionarPainelControle(leitor, nome, quantidade, preco, tipoEquipamento);
        });

        System.out.println("==========================================");
    }


    @Override
    public void executarAcao() {
        estoqueController.cadastrarEquipamento(getResposta());
        System.out.println("Adicionado com sucesso");
    }

    @Override
    public Menu<?> proximoMenu() {
        return new MenuInicial();
    }


    private EquipamentoAdicionarRequest adicionarMotorEletrico(Leitor leitor, String nome, int quantidade, double preco, TipoEquipamento tipoEquipamento){
        System.out.println(" Potencia: ");
        double potencia = leitor.lerNumeroDouble();
        return new EquipamentoAdicionarRequest(tipoEquipamento, nome, quantidade, preco, potencia);
    }

    private EquipamentoAdicionarRequest adicionarPainelControle(Leitor leitor, String nome, int quantidade, double preco, TipoEquipamento tipoEquipamento){
        System.out.println(" Tensão: ");
        String tensao = leitor.lerLinha();
        return new EquipamentoAdicionarRequest(tipoEquipamento, nome, quantidade, preco, tensao);
    }
}
