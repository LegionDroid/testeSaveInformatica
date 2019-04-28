package com.brunorfreitas.saveinformatica.presentations.CadastroActivity;

import android.widget.Toast;

import com.brunorfreitas.saveinformatica.Data.UserRepository;
import com.brunorfreitas.saveinformatica.Data.Model.Usuario;

public class CadastroPresenter implements CadastroContract.Presenter{

    CadastroContract.View view;
    UserRepository userRepository1;

    public CadastroPresenter(CadastroContract.View view, UserRepository userRepository1) {
        this.view = view;
        this.userRepository1 = userRepository1;
    }

    @Override
    public void validaUsuario(String nome, String estado, String sexo) {
        if (nome.trim().isEmpty()){
            view.exibirMensagem("Erro: Nome é obrigatório!!");
            return;
        }

        if (estado.trim().isEmpty()){
            view.exibirMensagem("Erro: Estado é obrigatório!!");
            return;
        }

        if (sexo.trim().isEmpty()){
            view.exibirMensagem("Erro: Sexo é obrigatório!!");
            return;
        }

        userRepository1.obterListaDeUsuarios();
        userRepository1.salvarUsuario(new Usuario(nome, estado, sexo));

        view.chamarMainActivity();
    }


}
