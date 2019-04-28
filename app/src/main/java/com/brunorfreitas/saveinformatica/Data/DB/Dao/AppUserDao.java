package com.brunorfreitas.saveinformatica.Data.DB.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.brunorfreitas.saveinformatica.Data.DB.banco.Dao;
import com.brunorfreitas.saveinformatica.Data.Model.Usuario;

import java.util.ArrayList;
import java.util.List;


public class AppUserDao extends Dao implements UserDaoHelper {

    public static final String TABELA = "tb_users";
    public static final String IDUSER = "iduser";
    public static final String NOME = "nome";
    public static final String ESTADO = "estado";
    public static final String SEXO = "sexo";
    //

    public AppUserDao(Context context) {
        super(context);
    }

    @Override
    public List<Usuario> obterListaDeUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try {
            StringBuilder comando = new StringBuilder();
            comando.append(" select * from ")
                    .append(TABELA)
                    .append(" order by ")
                    .append(NOME + " desc");


            cursor = db.rawQuery(comando.toString().toLowerCase(), null);
            //
            while (cursor.moveToNext()) {
                Usuario item;
                //
                String idUser = cursor.getString(cursor.getColumnIndex(IDUSER));
                String nome = cursor.getString(cursor.getColumnIndex(NOME));
                String estado = cursor.getString(cursor.getColumnIndex(ESTADO));
                String sexo = cursor.getString(cursor.getColumnIndex(SEXO));
                //

                item = new Usuario(idUser, nome, estado, sexo);
                Log.d("UserList", item.getNome()+"+"+item.getId());
                usuarios.add(item);
            }

            cursor.close();

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("EXCEPTION", "AppUserDao- obterListaDeUsuarios()");
        }
        //
        fecharBanco();
        //
        return usuarios;
    }

    @Override
    public void inserirListaUsuarios(List<Usuario> usuarios) {
        abrirBanco();
        //
        db.beginTransaction();
        //
        try {
            db.delete(TABELA, null, null);
            //
            ContentValues cv = new ContentValues();
            //
            for (Usuario userAux : usuarios) {
                cv.clear();
                //
                cv.put(IDUSER, userAux.getId());
                cv.put(NOME, userAux.getNome());
                cv.put(ESTADO, userAux.getEstado());
                cv.put(SEXO, userAux.getSexo());
                //
                db.insert(TABELA, null, cv);
            }

            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("EXCEPTION", "AppUserDao- inserirListaUsuarios()");
        } finally {
            db.endTransaction();// Mamute
        }
        //
        fecharBanco();
    }

    @Override
    public void inserirUsuario(Usuario usuario) {
        abrirBanco();
        //
        ContentValues cv = new ContentValues();
        cv.put(IDUSER, usuario.getId());
        cv.put(NOME, usuario.getNome());
        cv.put(ESTADO, usuario.getEstado());
        cv.put(SEXO, usuario.getSexo());
        //
        db.insert(TABELA, null, cv);
        //
        fecharBanco();

        Log.d("AppUserDao", "Usuario inserido:"+ usuario.getNome()+", id="+ usuario.getId());
    }

    @Override
    public boolean verificaInclusaoDB(String userID) {
        boolean incluso = false;
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try {
            //String comando = " select * from " + TABELA + " where idcontato = ? ";
            StringBuilder comando = new StringBuilder();
            comando
                    .append(" select * from ")
                    .append(TABELA)
                    .append(" where iduser = ")
                    .append("'"+userID+"'");

            cursor = db.rawQuery(comando.toString().toLowerCase(), null);
            //
            if(cursor.moveToNext()){
                incluso = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("EXCEPTION", "AppUserDao- verificaInclusaoDB()");
        }
        //
        fecharBanco();
        //
        return incluso;
    }

    @Override
    public long proximoID() {
        long proID = 1L;
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try {
            //String comando = " select * from " + TABELA + " where idUser = ? ";
            StringBuilder comando = new StringBuilder();
            comando
                    .append(" select max(iduser) + 2 as id from tb_users ");


            cursor = db.rawQuery(comando.toString().toLowerCase(), null);
            //
            while (cursor.moveToNext()) {
                proID = cursor.getLong(cursor.getColumnIndex("id"));
            }
            //
            if (proID == 0){
                proID = 1L;
            }
            //
            cursor.close();

        } catch (Exception e) {
        }
        //
        fecharBanco();
        //
        return proID;

    }

    @Override
    public List<Usuario> obterListaDeUsuariosPorSexo(String sexo) {
        List<Usuario> users = new ArrayList<>();
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try {
            //String comando = " select * from " + TABELA + " where sexo = ? ";
            StringBuilder comando = new StringBuilder();
            comando
                    .append(" select * from ")
                    .append(TABELA)
                    .append(" where sexo = ")
                    .append("'"+sexo+"'");

            cursor = db.rawQuery(comando.toString().toLowerCase(), null);
            //
            while (cursor.moveToNext()) {
                Usuario item;
                //
                String idUser = cursor.getString(cursor.getColumnIndex(IDUSER));
                String nome = cursor.getString(cursor.getColumnIndex(NOME));
                String estado = cursor.getString(cursor.getColumnIndex(ESTADO));
                String sexo1 = cursor.getString(cursor.getColumnIndex(SEXO));
                //

                item = new Usuario(idUser, nome, estado, sexo1);
                Log.d("UserDao", "sexo adicionado:"+item.getNome()+" + "+item.getSexo());
                users.add(item);
            }

            cursor.close();

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("EXCEPTION", "AppUserDao- obterListaDeUsuariosSexoMasculino())");
        }
        //
        fecharBanco();
        //
        return users;
    }
}
