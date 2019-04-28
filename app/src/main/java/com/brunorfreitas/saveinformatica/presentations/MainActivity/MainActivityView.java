package com.brunorfreitas.saveinformatica.presentations.MainActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.brunorfreitas.saveinformatica.Data.AppUserRepository;
import com.brunorfreitas.saveinformatica.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class MainActivityView extends AppCompatActivity implements MainActivityContract.View {

    private Context context;
    private GraphView graphView;
    private Button btn_cb;
    private TextView tv_cb;

    private MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity1);


        inicializaVariaves();
        inicializaAcoes();
    }

    private void inicializaVariaves() {
        context = getBaseContext();
        presenter = new MainActivityPresenter(this, new AppUserRepository());
        graphView = findViewById(R.id.main_activity1_grapghview);
        btn_cb = findViewById(R.id.main_activity_btn_cb);
        tv_cb = findViewById(R.id.main_activity_tv_cb);

////        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
////                new DataPoint(0, -2),
////                new DataPoint(1, 5),
////                new DataPoint(2, 3),
////                new DataPoint(3, 2),
////                new DataPoint(4, 6)
////        });
////        graphView.addSeries(series);
//
//        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, 3),
//                new DataPoint(1, 3),
//                new DataPoint(2, 6),
//                new DataPoint(3, 2),
//                new DataPoint(4, 5)
//        });
//        graphView.addSeries(series2);

//        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
//                new DataPoint(1, 5),
//                new DataPoint(2, -3),
//                new DataPoint(3, 2)
//        });
//        series.setSpacing(50); // 50% spacing between bars
//        series.setAnimated(true);
//        graphView.addSeries(series);
//
//        // set the viewport wider than the data, to have a nice view
//        graphView.getViewport().setMinX(0d);
//        graphView.getViewport().setMaxX(4d);
//        graphView.getViewport().setXAxisBoundsManual(true);

//        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {

        //Aki
//        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
//
//        new DataPoint(0, 0),
//                new DataPoint(1, 8),
//                new DataPoint(2, 5)
//        });
//        graphView.addSeries(series);
//
//        // use static labels for horizontal and vertical labels
//        graphView.getViewport().setMinX(0d);
//        graphView.getViewport().setMaxX(4d);
//        graphView.getViewport().setXAxisBoundsManual(true);
//        series.setSpacing(50); // 50% spacing between bars
//        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graphView);
//        staticLabelsFormatter.setHorizontalLabels(new String[] {"", "Masculino","Feminino"}
////        staticLabelsFormatter.setVerticalLabels(new); String[] {"low", "middle", "high"});
//        graphView.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);


//        graficoFooEBar();
//        testeHomemMulher();
    }

    private void testeHomemMulher() {
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 8)
        });
        series.setSpacing(2);
        series.setAnimated(true);
        graphView.addSeries(series);

        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 0),
                new DataPoint(2, 6)
        });
        series2.setColor(Color.RED);
        series2.setSpacing(2);
        series2.setAnimated(true);
        graphView.addSeries(series2);

        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setMinX(0);
        graphView.getViewport().setMaxX(3);

        // legend
        series.setTitle("Homens");
        series2.setTitle("Mulheres");
        graphView.getLegendRenderer().setVisible(true);
        graphView.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);


        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graphView);
        staticLabelsFormatter.setHorizontalLabels(new String[] {"X1", "X2"});
//        staticLabelsFormatter.setVerticalLabels(new); String[] {"low", "middle", "high"});
        graphView.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

    }
    private void graficoFooEBar() {
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -2),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        series.setSpacing(30);
        series.setAnimated(true);
        graphView.addSeries(series);

        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -5),
                new DataPoint(1, 3),
                new DataPoint(2, 4),
                new DataPoint(3, 4),
                new DataPoint(4, 1)
        });
        series2.setColor(Color.RED);
        series2.setSpacing(30);
        series2.setAnimated(true);
        graphView.addSeries(series2);

        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setMinX(-2);
        graphView.getViewport().setMaxX(6);

        // legend
        series.setTitle("foo");
        series2.setTitle("bar");
        graphView.getLegendRenderer().setVisible(true);
        graphView.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

    }


    private void inicializaAcoes() {
        presenter.carregaGraficoDeHomensMulheres();

        btn_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escanear();
            }
        });
    }

    private void escanear() {

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES);

        integrator.setPrompt("Escanear Codigo");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result!=null){

            if (result.getContents() == null){
                Toast.makeText(context, "scanner cancelado", Toast.LENGTH_SHORT).show();
            }else{
                tv_cb.setText(result.getContents().toString());
            }
        }else{
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void mostrarGrafico(BarGraphSeries<DataPoint> series, BarGraphSeries<DataPoint> series2) {
        graphView.addSeries(series2);
        graphView.addSeries(series);

        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setMinX(0);
        graphView.getViewport().setMaxX(3);
        graphView.getLegendRenderer().setVisible(true);
        graphView.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graphView);
        staticLabelsFormatter.setHorizontalLabels(new String[] {"X1", "X2"});
//        staticLabelsFormatter.setVerticalLabels(new); String[] {"low", "middle", "high"});
        graphView.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

    }

    @Override
    public void mostrarCodigoBarras(String codigo) {
        tv_cb.setText(codigo);
    }
}
