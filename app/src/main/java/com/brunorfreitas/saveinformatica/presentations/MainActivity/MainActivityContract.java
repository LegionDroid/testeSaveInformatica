package com.brunorfreitas.saveinformatica.presentations.MainActivity;

import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public interface MainActivityContract {

    interface View{
        void mostrarGrafico(BarGraphSeries<DataPoint> series, BarGraphSeries<DataPoint> series2);
        void mostrarCodigoBarras(String codigo);

    }

    interface Presenter{
        void carregaGraficoDeHomensMulheres();
    }
}
