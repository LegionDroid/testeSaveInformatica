package com.brunorfreitas.saveinformatica.Data;

import android.content.Context;

import com.brunorfreitas.saveinformatica.Data.DB.Dao.AppUserDao;
import com.brunorfreitas.saveinformatica.Data.DB.Dao.UserDaoHelper;
import com.brunorfreitas.saveinformatica.Data.Firebase.AppFirebaseHelper;
import com.brunorfreitas.saveinformatica.Data.Firebase.FirebaseHelper;
import com.brunorfreitas.saveinformatica.Data.Prefs.AppPreferenciasHelper;
import com.brunorfreitas.saveinformatica.Data.Prefs.PreferencesHelper;
import com.brunorfreitas.saveinformatica.Data.Model.Usuario;
import com.brunorfreitas.saveinformatica.ExploreApp;

import java.util.List;
import java.util.UUID;

public class AppUserRepository implements UserRepository {

    PreferencesHelper preferencesHelper;
    FirebaseHelper firebaseHelper;
    UserDaoHelper userDaoHelper;

    private String idAtual;

    public AppUserRepository() {
        Context context = ExploreApp.getContext();
        this.preferencesHelper = new AppPreferenciasHelper();
        this.firebaseHelper = new AppFirebaseHelper();
        this.userDaoHelper = new AppUserDao(context);
    }

    boolean conexao = false;


    @Override
    public void salvarUsuario(Usuario usuario) {
        if (usuario.getId().equals("-1")){
            idAtual = UUID.randomUUID().toString();
            usuario.setId(idAtual);
        }
        userDaoHelper.inserirUsuario(usuario);
        preferencesHelper.salvarUsuarioPreferencias(usuario.getId(), usuario.getNome());

        if(conexao){
            firebaseHelper.salvarUsuarioFirebase(usuario);
        }
    }

    @Override
    public List<Usuario> obterListaDeUsuarios() {
        if(conexao){
            return firebaseHelper.getListaUsuariosFirebase();
        }else{
            return userDaoHelper.obterListaDeUsuarios();
        }

    }

    @Override
    public List<Usuario> obterListaDeUsuariosPorSexo(String sexo) {
        return userDaoHelper.obterListaDeUsuariosPorSexo(sexo);
    }


    @Override
    public List<Usuario> obterListaDeUsuariosPorEstado() {
        return null;
    }


}
