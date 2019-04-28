package com.brunorfreitas.saveinformatica.Data.Firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.brunorfreitas.saveinformatica.Data.Model.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AppFirebaseHelper implements FirebaseHelper {

    private final String USER_PATH = "User";

    @Override
    public void salvarUsuarioFirebase(Usuario usuario) {
        ConfiguracaoFirebase.getConfiguracaoFirebase().getDatabaseReference()
                .child(USER_PATH).child(usuario.getId()).setValue(usuario);
    }

    @Override
    public List<Usuario> getListaUsuariosFirebase() {
        final List<Usuario> usuarios = new ArrayList<>();

        ConfiguracaoFirebase.getConfiguracaoFirebase().getDatabaseReference().child(USER_PATH)
                .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usuarios.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Usuario usuario = snapshot.getValue(Usuario.class);
                    usuarios.add(usuario);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("ConfiguracaoFirebase", databaseError.getMessage().toString());

                //Todo - Pesquisar como implementar, talvez seja essa a funcao do eventbus
//                ....onFailure(databaseError.getMessage().toString());
            }
        });

        return usuarios;
    }
}
