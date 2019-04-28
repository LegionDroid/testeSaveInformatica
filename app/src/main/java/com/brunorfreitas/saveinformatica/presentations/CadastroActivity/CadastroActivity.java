package com.brunorfreitas.saveinformatica.presentations.CadastroActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.brunorfreitas.saveinformatica.Data.AppUserRepository;
import com.brunorfreitas.saveinformatica.R;
import com.brunorfreitas.saveinformatica.presentations.MainActivity.MainActivityView;

import java.util.ArrayList;

public class CadastroActivity extends AppCompatActivity implements CadastroContract.View {

    private Context context;

    private EditText et_nome;
    private Spinner sp_estado;
    private RadioGroup rg;
    private RadioButton rb_masculino, rb_feminino;
    private Button btn_enviar;

    private CadastroContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_activity);

        inicializaVariaves();
        inicializaAcoes();
    }

    private void inicializaVariaves() {
        context = getBaseContext();

        et_nome = findViewById(R.id.cadastro_activity_et_nome);
        sp_estado = findViewById(R.id.cadastro_activity_sp_estado);
        inicializaSPEstados();
        rg = findViewById(R.id.cadastro_activity_rg);
        rb_masculino = findViewById(R.id.cadastro_activity_rb_masculino);
        rb_feminino = findViewById(R.id.cadastro_activity_rb_feminino);
        btn_enviar = findViewById(R.id.cadastro_activity_btn_enviar);

        presenter = new CadastroPresenter(this, new AppUserRepository());
    }

    private void inicializaSPEstados() {
        ArrayList<String> estados = new ArrayList<>();

        estados.add("");
        estados.add("Acre");
        estados.add("Alagoas");
        estados.add("Amapá");
        estados.add("Amazonas");
        estados.add("Bahia");
        estados.add("Ceará");
        estados.add("Espírito Santo");
        estados.add("Goiás");
        estados.add("Maranhão");
        estados.add("Mato Grosso");
        estados.add("Mato Grosso do Sul");
        estados.add("Minas Gerais");
        estados.add("Pará");
        estados.add("Paraíba");
        estados.add("Paraná");
        estados.add("Pernambuco");
        estados.add("Piauí");
        estados.add("Rio de Janeiro");
        estados.add("Rio Grande do Norte");
        estados.add("Rio Grande do Sul");
        estados.add("Rondônia");
        estados.add("Roraima");
        estados.add("Santa Catarina");
        estados.add("São Paulo");
        estados.add("Sergipe");
        estados.add("Tocantins");


        ArrayAdapter<String> adapterEstados = new ArrayAdapter<>(
                context,
                android.R.layout.simple_spinner_item,
                estados
        );

        adapterEstados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_estado.setAdapter(adapterEstados);

    }

    private void inicializaAcoes() {

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = et_nome.getText().toString().trim();
                String estado = (String) sp_estado.getSelectedItem();
                String sexo;
                if (rb_masculino.isChecked()) {
                    sexo = "masculino";
                } else if (rb_feminino.isChecked()) {
                    sexo = "feminino";
                } else {
                    sexo = "";
                }
                
                presenter.validaUsuario(nome, estado, sexo);
            }
        });



    }

    @Override
    public void exibirMensagem(String mensagem) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void chamarMainActivity() {
//        Toast.makeText(context, "Chamar mainActivity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, MainActivityView.class);
        startActivity(intent);


    }
}
