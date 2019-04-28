package com.brunorfreitas.saveinformatica.Data.Firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFirebase {

    public static ConfiguracaoFirebase INSTANCE;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myReference;


    public static ConfiguracaoFirebase getConfiguracaoFirebase(){

        if(INSTANCE == null){
            INSTANCE = new ConfiguracaoFirebase();
        }
        return INSTANCE;
    }

    public FirebaseDatabase getDatabaseInstace() {
        if (firebaseDatabase == null){
            firebaseDatabase = FirebaseDatabase.getInstance();
        }
        return firebaseDatabase;
    }

    public DatabaseReference getDatabaseReference() {
        if (myReference == null){
            myReference = getDatabaseInstace().getReference();
        }
        return myReference;
    }
}
