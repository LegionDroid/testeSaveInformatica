package com.brunorfreitas.saveinformatica.Data.Prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.brunorfreitas.saveinformatica.ExploreApp;

public class AppPreferenciasHelper implements PreferencesHelper {

    private Context context;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "saveinformatica.preferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private static final String CHAVE_IDENTIFICADOR = "identificarUsuarioLogado";
    private static final String CHAVE_NOME = "NomeUsuarioLogado";

    public AppPreferenciasHelper() {
//        this.context = ExploreApp.getContext();
        preferences = ExploreApp.getContext().getSharedPreferences(NOME_ARQUIVO, MODE);

        editor = preferences.edit();
    }

    @Override
    public void salvarUsuarioPreferencias(String identificadorUsuario, String nomeUsuario){
        editor.putString(CHAVE_IDENTIFICADOR, identificadorUsuario);
        editor.putString(CHAVE_NOME, nomeUsuario);
        editor.commit();
    }

    @Override
    public String getIdentificador(){
        return preferences.getString(CHAVE_IDENTIFICADOR, null);
    }

    @Override
    public String getNome(){
        return preferences.getString(CHAVE_NOME, null);
    }
}
