package com.brunorfreitas.saveinformatica.Data.Prefs;

public interface PreferencesHelper {

    void salvarUsuarioPreferencias(String identificadorUsuario, String nomeUsuario);

    String getIdentificador();

    String getNome();
}
