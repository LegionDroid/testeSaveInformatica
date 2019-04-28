package com.brunorfreitas.saveinformatica.Data.DB.Dao;

import com.brunorfreitas.saveinformatica.Data.Model.Usuario;

import java.util.List;

public interface UserDaoHelper {
    List<Usuario> obterListaDeUsuarios();

    void inserirListaUsuarios(List<Usuario> usuarios);

    void inserirUsuario(Usuario usuario);

    boolean verificaInclusaoDB(String userID);

    long proximoID();

    List<Usuario> obterListaDeUsuariosPorSexo(String sexo);
}
