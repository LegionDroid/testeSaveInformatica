package com.brunorfreitas.saveinformatica.Data.Firebase;

import com.brunorfreitas.saveinformatica.Data.Model.Usuario;

import java.util.List;

public interface FirebaseHelper {

    void salvarUsuarioFirebase(Usuario usuario);
    List<Usuario> getListaUsuariosFirebase();

}
