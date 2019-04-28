package com.brunorfreitas.saveinformatica.presentations.MainActivity;

import android.graphics.Color;

import com.brunorfreitas.saveinformatica.Data.UserRepository;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;
    UserRepository userRepository;

    public MainActivityPresenter(MainActivityContract.View view, UserRepository userRepository) {
        this.view = view;
        this.userRepository = userRepository;
    }

    @Override
    public void carregaGraficoDeHomensMulheres() {

        int qntUsuariasMulheres = userRepository.obterListaDeUsuariosPorSexo("feminino").size();

        int qntUsuariosHomens = userRepository.obterListaDeUsuariosPorSexo("masculino").size();

        populaDados(qntUsuariasMulheres, qntUsuariosHomens);

//        view.mostrarGrafico(series, series2);
//        graphView.addSeries(series2);

        //grafico de qnt de usuarios por sexo;(pode ser em pizza)
        //usuarios por decadas nascidas
        //contagem de usuarios po estado (barras verticais)

    }

    private void populaDados(int qntUsuariasMulheres, int qntUsuariosHomens) {
            BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                    new DataPoint(0, 0),
                    new DataPoint(1, qntUsuariosHomens)
            });
            series.setSpacing(2);
            series.setAnimated(true);

            BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[] {
                    new DataPoint(0, 0),
                    new DataPoint(1, qntUsuariasMulheres),
            });
            series2.setColor(Color.RED);
            series2.setSpacing(2);
            series2.setAnimated(true);

            // legend
            series.setTitle("Homens");
            series2.setTitle("Mulheres");

            view.mostrarGrafico(series, series2);



    }


}