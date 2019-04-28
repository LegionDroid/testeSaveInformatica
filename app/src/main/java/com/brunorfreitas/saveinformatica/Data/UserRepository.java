package com.brunorfreitas.saveinformatica.Data;

import com.brunorfreitas.saveinformatica.Data.Model.Usuario;

import java.util.List;

public interface UserRepository {

    void salvarUsuario(Usuario usuario);
    List<Usuario> obterListaDeUsuarios();
    List<Usuario> obterListaDeUsuariosPorSexo(String sexo);
    List<Usuario> obterListaDeUsuariosPorEstado();

}

