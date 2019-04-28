package com.brunorfreitas.saveinformatica.presentations.CadastroActivity;

public interface CadastroContract {

    interface View{
        void exibirMensagem(String mensagem);
        void chamarMainActivity();
    }

    interface Presenter{
        void validaUsuario(String nome, String estado, String sexo);
    }

}
