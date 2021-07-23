package com.example.dal.Controllador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dal.Modelo.JsonPlaceHolderApi;
import com.example.dal.Modelo.clNota;
import com.example.dal.Modelo.clNotaTaller;
import com.example.dal.Modelo.clRespuesta;
import com.example.dal.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalificaCuatro extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    private String  idUser, taller;
    private TextView lblFecha_4, res1_4, res2_4, res3_4, res4_4, res5_4, res6_4, res7_4, res8_4, res9_4, res10_4, res11_4;
    private TextView id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11;
    private EditText nota1, nota2, nota3, nota4, nota5, nota6, nota7, nota8, nota9, nota10, nota11;
    private Button btnCalificar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_califica_cuatro);

        idUser = getIntent().getStringExtra("idUser");
        taller = getIntent().getStringExtra("taller");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        mtdCargarView();

        mtdConsultaRespuesta();

        btnCalificar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clNota not = new clNota();
                int idU = Integer.parseInt(idUser);

                String not1 = nota1.getText().toString();
                String not2 = nota2.getText().toString();
                String not3 = nota3.getText().toString();
                String not4 = nota4.getText().toString();
                String not5 = nota5.getText().toString();
                String not6 = nota6.getText().toString();
                String not7 = nota7.getText().toString();
                String not8 = nota8.getText().toString();
                String not9 = nota9.getText().toString();
                String not10 = nota10.getText().toString();
                String not11 = nota11.getText().toString();

                if (not1.length() == 0 || not2.length() == 0 || not3.length() == 0 || not4.length() == 0 || not5.length() == 0 || not6.length() == 0 || not7.length() == 0 || not8.length() == 0 || not9.length() == 0 || not10.length() == 0 || not11.length() == 0){
                    Toast.makeText(getApplicationContext(), "Datos vacio en el formulario", Toast.LENGTH_LONG).show();
                }else {
                    int idRes1 = Integer.parseInt(id1.getText().toString());
                    float valNota1 = Float.parseFloat(nota1.getText().toString());

                    int idRes2 = Integer.parseInt(id2.getText().toString());
                    float valNota2 = Float.parseFloat(nota2.getText().toString());

                    int idRes3 = Integer.parseInt(id3.getText().toString());
                    float valNota3 = Float.parseFloat(nota3.getText().toString());

                    int idRes4 = Integer.parseInt(id4.getText().toString());
                    float valNota4 = Float.parseFloat(nota4.getText().toString());

                    int idRes5 = Integer.parseInt(id5.getText().toString());
                    float valNota5 = Float.parseFloat(nota5.getText().toString());

                    int idRes6 = Integer.parseInt(id6.getText().toString());
                    float valNota6 = Float.parseFloat(nota6.getText().toString());

                    int idRes7 = Integer.parseInt(id7.getText().toString());
                    float valNota7 = Float.parseFloat(nota7.getText().toString());

                    int idRes8 = Integer.parseInt(id8.getText().toString());
                    float valNota8 = Float.parseFloat(nota8.getText().toString());

                    int idRes9 = Integer.parseInt(id9.getText().toString());
                    float valNota9 = Float.parseFloat(nota9.getText().toString());

                    int idRes10 = Integer.parseInt(id10.getText().toString());
                    float valNota10 = Float.parseFloat(nota10.getText().toString());

                    int idRes11 = Integer.parseInt(id11.getText().toString());
                    float valNota11 = Float.parseFloat(nota11.getText().toString());

                    int r1 = not.mtdPostNota(valNota1, idRes1, idU);
                    int r2 = not.mtdPostNota(valNota2, idRes2, idU);
                    int r3 = not.mtdPostNota(valNota3, idRes3, idU);
                    int r4 = not.mtdPostNota(valNota4, idRes4, idU);
                    int r5 = not.mtdPostNota(valNota5, idRes5, idU);
                    int r6 = not.mtdPostNota(valNota6, idRes6, idU);
                    int r7 = not.mtdPostNota(valNota7, idRes7, idU);
                    int r8 = not.mtdPostNota(valNota8, idRes8, idU);
                    int r9 = not.mtdPostNota(valNota9, idRes9, idU);
                    int r10 = not.mtdPostNota(valNota10, idRes10, idU);
                    int r11 = not.mtdPostNota(valNota11, idRes11, idU);

                    if (r1 == 1 && r2 == 1 && r3 == 1 && r4 == 1 && r5 == 1 && r6 == 1 && r7 == 1 && r8 == 1 && r9 == 1 && r10 == 1 && r11 == 1){

                        int tall = Integer.parseInt(taller);
                        float notaFinalTaller = valNota1 + valNota2 + valNota3 + valNota4 + valNota5 + valNota6 + valNota7 + valNota8 + valNota9 + valNota10 + valNota11;
                        float valorFinalFinal = (notaFinalTaller/11);
                        clNotaTaller notaTa = new clNotaTaller();
                        notaTa.mtdPostNotaTaller(valorFinalFinal, tall, idU);

                        Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(CalificaCuatro.this, AdminTurus.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }

    private void mtdCargarView(){

        btnCalificar4 = (Button)findViewById(R.id.btn_califica_taller_4);
        lblFecha_4 = (TextView)findViewById(R.id.lblFecha4);

        res1_4 = (TextView)findViewById(R.id.lblRes1_ta4);
        res2_4 = (TextView)findViewById(R.id.lblRes2_ta4);
        res3_4 = (TextView)findViewById(R.id.lblRes3_ta4);
        res4_4 = (TextView)findViewById(R.id.lblRes4_ta4);
        res5_4 = (TextView)findViewById(R.id.lblRes5_ta4);
        res6_4 = (TextView)findViewById(R.id.lblRes6_ta4);
        res7_4 = (TextView)findViewById(R.id.lblRes7_ta4);
        res8_4 = (TextView)findViewById(R.id.lblRes8_ta4);
        res9_4 = (TextView)findViewById(R.id.lblRes9_ta4);
        res10_4 = (TextView)findViewById(R.id.lblRes10_ta4);
        res11_4 = (TextView)findViewById(R.id.lblRes11_ta4);


        id1 = (TextView)findViewById(R.id.lblResId1_ta4);
        id2 = (TextView)findViewById(R.id.lblResId2_ta4);
        id3 = (TextView)findViewById(R.id.lblResId3_ta4);
        id4 = (TextView)findViewById(R.id.lblResId4_ta4);
        id5 = (TextView)findViewById(R.id.lblResId5_ta4);
        id6 = (TextView)findViewById(R.id.lblResId6_ta4);
        id7 = (TextView)findViewById(R.id.lblResId7_ta4);
        id8 = (TextView)findViewById(R.id.lblResId8_ta4);
        id9 = (TextView)findViewById(R.id.lblResId9_ta4);
        id10 = (TextView)findViewById(R.id.lblResId10_ta4);
        id11 = (TextView)findViewById(R.id.lblResId11_ta4);


        nota1 = (EditText)findViewById(R.id.txtNota1_ta4);
        nota2 = (EditText)findViewById(R.id.txtNota2_ta4);
        nota3 = (EditText)findViewById(R.id.txtNota3_ta4);
        nota4 = (EditText)findViewById(R.id.txtNota4_ta4);
        nota5 = (EditText)findViewById(R.id.txtNota5_ta4);
        nota6 = (EditText)findViewById(R.id.txtNota6_ta4);
        nota7 = (EditText)findViewById(R.id.txtNota7_ta4);
        nota8 = (EditText)findViewById(R.id.txtNota8_ta4);
        nota9 = (EditText)findViewById(R.id.txtNota9_ta4);
        nota10 = (EditText)findViewById(R.id.txtNota10_ta4);
        nota11 = (EditText)findViewById(R.id.txtNota11_ta4);


    }

    private void mtdConsultaRespuesta(){

        int idEnvia = Integer.parseInt(idUser);

        Call<List<clRespuesta>> call = jsonPlaceHolderApi.getRespuestasTaller4(idEnvia);

        call.enqueue(new Callback<List<clRespuesta>>() {
            @Override
            public void onResponse(Call<List<clRespuesta>> call, Response<List<clRespuesta>> response) {
                if (!response.isSuccessful()){

                    return;
                }

                List<clRespuesta> resp = response.body();

                if (resp.isEmpty() == true){
                    Toast.makeText(getApplicationContext(), "Vacio", Toast.LENGTH_LONG).show();
                    return;
                }

                int idRespuesta = 0;
                String respuestaUserVal = "";
                String fecha = "";
                String pregunta = "";

                for (clRespuesta respuesta : resp){

                    idRespuesta = respuesta.getIdRespuesta();
                    respuestaUserVal = respuesta.getRespuestaUser();
                    fecha = respuesta.getFecha();
                    pregunta = respuesta.getPregunta();

                    String valSale = String.valueOf(idRespuesta);

                    mtdDatosTexViews(valSale, respuestaUserVal, fecha, pregunta);

                }

            }

            @Override
            public void onFailure(Call<List<clRespuesta>> call, Throwable t) {

            }
        });



    }

    private void mtdDatosTexViews(String idres, String res, String fecha, String pregunta) {
        String p1 = "pre1_pa1", p2 = "pre2_pa1", p3 = "pre3_pa1", p4 = "pre1_pa2", p5 = "pre2_pa2", p6 = "pre1_pa3", p7 = "pre1_pa4", p8 = "pre2_pa4", p9 = "pre3_pa4", p10 = "pre4_pa4", p11 = "pre1_pa5";

        lblFecha_4.setText(fecha);
        if (pregunta.equals(p1)){
            res1_4.setText(res);
            id1.setText(idres);
        }
        if (pregunta.equals(p2)){
            res2_4.setText(res);
            id2.setText(idres);
        }
        if (pregunta.equals(p3)){
            res3_4.setText(res);
            id3.setText(idres);
        }
        if (pregunta.equals(p4)){
            res4_4.setText(res);
            id4.setText(idres);
        }
        if (pregunta.equals(p5)){
            res5_4.setText(res);
            id5.setText(idres);
        }
        if (pregunta.equals(p6)){
            res6_4.setText(res);
            id6.setText(idres);
        }
        if (pregunta.equals(p7)){
            res7_4.setText(res);
            id7.setText(idres);
        }
        if (pregunta.equals(p8)){
            res8_4.setText(res);
            id8.setText(idres);
        }
        if (pregunta.equals(p9)){
            res9_4.setText(res);
            id9.setText(idres);
        }
        if (pregunta.equals(p10)){
            res10_4.setText(res);
            id10.setText(idres);
        }
        if (pregunta.equals(p11)){
            res11_4.setText(res);
            id11.setText(idres);
        }

    }

}