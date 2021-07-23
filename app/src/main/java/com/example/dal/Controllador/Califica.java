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
import com.example.dal.Modelo.clNotaTaller;
import com.example.dal.Modelo.clUsuario;
import com.example.dal.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.dal.Modelo.clRespuesta;
import com.example.dal.Modelo.clNota;


public class Califica extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    private String  idUser, taller;
    private TextView lblFecha, res1, res2, res3, res4, res5, res6, res7, res8, res9, res10, res11, res12, res13, res14, res15, res16, res17, res18;
    private TextView id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id13, id14, id15, id16, id17, id18;
    private EditText nota1, nota2, nota3, nota4, nota5, nota6, nota7, nota8, nota9, nota10, nota11, nota12, nota13, nota14, nota15, nota16, nota17, nota18;
    private Button btnCalificar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_califica);

        idUser = getIntent().getStringExtra("idUser");
        taller = getIntent().getStringExtra("taller");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        mtdCargarView();

        mtdConsultaRespuesta();

        btnCalificar1.setOnClickListener(new View.OnClickListener() {
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
                String not12 = nota12.getText().toString();
                String not13 = nota13.getText().toString();
                String not14 = nota14.getText().toString();
                String not15 = nota15.getText().toString();
                String not16 = nota16.getText().toString();
                String not17 = nota17.getText().toString();
                String not18 = nota18.getText().toString();

                if (not1.length() == 0 || not2.length() == 0 || not3.length() == 0 || not4.length() == 0 || not5.length() == 0 || not6.length() == 0 || not7.length() == 0 || not8.length() == 0 || not9.length() == 0 || not10.length() == 0 || not11.length() == 0 || not12.length() == 0 || not13.length() == 0 || not14.length() == 0 || not15.length() == 0 || not16.length() == 0 || not17.length() == 0 || not18.length() == 0){
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

                    int idRes12 = Integer.parseInt(id12.getText().toString());
                    float valNota12 = Float.parseFloat(nota12.getText().toString());

                    int idRes13 = Integer.parseInt(id13.getText().toString());
                    float valNota13 = Float.parseFloat(nota13.getText().toString());

                    int idRes14 = Integer.parseInt(id14.getText().toString());
                    float valNota14 = Float.parseFloat(nota14.getText().toString());

                    int idRes15 = Integer.parseInt(id15.getText().toString());
                    float valNota15 = Float.parseFloat(nota15.getText().toString());

                    int idRes16 = Integer.parseInt(id16.getText().toString());
                    float valNota16 = Float.parseFloat(nota16.getText().toString());

                    int idRes17 = Integer.parseInt(id17.getText().toString());
                    float valNota17 = Float.parseFloat(nota17.getText().toString());

                    int idRes18 = Integer.parseInt(id18.getText().toString());
                    float valNota18 = Float.parseFloat(nota18.getText().toString());

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
                    int r12 = not.mtdPostNota(valNota12, idRes12, idU);
                    int r13 = not.mtdPostNota(valNota13, idRes13, idU);
                    int r14 = not.mtdPostNota(valNota14, idRes14, idU);
                    int r15 = not.mtdPostNota(valNota15, idRes15, idU);
                    int r16 = not.mtdPostNota(valNota16, idRes16, idU);
                    int r17 = not.mtdPostNota(valNota17, idRes17, idU);
                    int r18 = not.mtdPostNota(valNota18, idRes18, idU);

                    if (r1 == 1 && r2 == 1 && r3 == 1 && r4 == 1 && r5 == 1 && r6 == 1 && r7 == 1 && r8 == 1 && r9 == 1 && r10 == 1 && r11 == 1 && r12 == 1 && r13 == 1 && r14 == 1 && r15 == 1 && r16 == 1 && r17 == 1 && r18 == 1){

                        int tall = Integer.parseInt(taller);
                        float notaFinalTaller = valNota1 + valNota2 + valNota3 + valNota4 + valNota5 + valNota6 + valNota7 + valNota8 + valNota9 + valNota10 + valNota11 + valNota12 + valNota13 + valNota14 + valNota15 + valNota16 + valNota17 + valNota18;
                        float valorFinalFinal = (notaFinalTaller/18);
                        clNotaTaller notaTa = new clNotaTaller();
                        notaTa.mtdPostNotaTaller(valorFinalFinal, tall, idU);

                        Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Califica.this, AdminTurus.class);
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

        btnCalificar1 = (Button)findViewById(R.id.btn_califica_taller_1);
        lblFecha = (TextView)findViewById(R.id.lblFecha);

        res1 = (TextView)findViewById(R.id.lblRes1_ta1);
        res2 = (TextView)findViewById(R.id.lblRes2_ta1);
        res3 = (TextView)findViewById(R.id.lblRes3_ta1);
        res4 = (TextView)findViewById(R.id.lblRes4_ta1);
        res5 = (TextView)findViewById(R.id.lblRes5_ta1);
        res6 = (TextView)findViewById(R.id.lblRes6_ta1);
        res7 = (TextView)findViewById(R.id.lblRes7_ta1);
        res8 = (TextView)findViewById(R.id.lblRes8_ta1);
        res9 = (TextView)findViewById(R.id.lblRes9_ta1);
        res10 = (TextView)findViewById(R.id.lblRes10_ta1);
        res11 = (TextView)findViewById(R.id.lblRes11_ta1);
        res12 = (TextView)findViewById(R.id.lblRes12_ta1);
        res13 = (TextView)findViewById(R.id.lblRes13_ta1);
        res14 = (TextView)findViewById(R.id.lblRes14_ta1);
        res15 = (TextView)findViewById(R.id.lblRes15_ta1);
        res16 = (TextView)findViewById(R.id.lblRes16_ta1);
        res17 = (TextView)findViewById(R.id.lblRes17_ta1);
        res18 = (TextView)findViewById(R.id.lblRes18_ta1);

        id1 = (TextView)findViewById(R.id.lblResId1_ta1);
        id2 = (TextView)findViewById(R.id.lblResId2_ta1);
        id3 = (TextView)findViewById(R.id.lblResId3_ta1);
        id4 = (TextView)findViewById(R.id.lblResId4_ta1);
        id5 = (TextView)findViewById(R.id.lblResId5_ta1);
        id6 = (TextView)findViewById(R.id.lblResId6_ta1);
        id7 = (TextView)findViewById(R.id.lblResId7_ta1);
        id8 = (TextView)findViewById(R.id.lblResId8_ta1);
        id9 = (TextView)findViewById(R.id.lblResId9_ta1);
        id10 = (TextView)findViewById(R.id.lblResId10_ta1);
        id11 = (TextView)findViewById(R.id.lblResId11_ta1);
        id12 = (TextView)findViewById(R.id.lblResId12_ta1);
        id13 = (TextView)findViewById(R.id.lblResId13_ta1);
        id14 = (TextView)findViewById(R.id.lblResId14_ta1);
        id15 = (TextView)findViewById(R.id.lblResId15_ta1);
        id16 = (TextView)findViewById(R.id.lblResId16_ta1);
        id17 = (TextView)findViewById(R.id.lblResId17_ta1);
        id18 = (TextView)findViewById(R.id.lblResId18_ta1);

        nota1 = (EditText)findViewById(R.id.txtNota1_ta1);
        nota2 = (EditText)findViewById(R.id.txtNota2_ta1);
        nota3 = (EditText)findViewById(R.id.txtNota3_ta1);
        nota4 = (EditText)findViewById(R.id.txtNota4_ta1);
        nota5 = (EditText)findViewById(R.id.txtNota5_ta1);
        nota6 = (EditText)findViewById(R.id.txtNota6_ta1);
        nota7 = (EditText)findViewById(R.id.txtNota7_ta1);
        nota8 = (EditText)findViewById(R.id.txtNota8_ta1);
        nota9 = (EditText)findViewById(R.id.txtNota9_ta1);
        nota10 = (EditText)findViewById(R.id.txtNota10_ta1);
        nota11 = (EditText)findViewById(R.id.txtNota11_ta1);
        nota12 = (EditText)findViewById(R.id.txtNota12_ta1);
        nota13 = (EditText)findViewById(R.id.txtNota13_ta1);
        nota14 = (EditText)findViewById(R.id.txtNota14_ta1);
        nota15 = (EditText)findViewById(R.id.txtNota15_ta1);
        nota16 = (EditText)findViewById(R.id.txtNota16_ta1);
        nota17 = (EditText)findViewById(R.id.txtNota17_ta1);
        nota18 = (EditText)findViewById(R.id.txtNota18_ta1);

    }

    private void mtdConsultaRespuesta() {

        int idEnvia = Integer.parseInt(idUser);

        Call<List<clRespuesta>> call = jsonPlaceHolderApi.getRespuestasTaller1(idEnvia);

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

    private void mtdDatosTexViews(String idres, String res, String fecha, String pregunta){
        String p1 = "2a", p2 = "2b", p3 = "2c", p4 = "2d", p5 = "3", p6 = "4_1_1", p7 = "4_1_2", p8 = "4_2_1", p9 = "4_2_2", p10 = "4_3_1", p11 = "4_3_2", p12 = "5", p13 = "6_1_1", p14 = "6_1_2", p15 = "6_1_3", p16 = "6_2_1", p17 = "6_2_2", p18 = "6_2_3";

        lblFecha.setText(fecha);
        if (pregunta.equals(p1)){
            res1.setText(res);
            id1.setText(idres);
        }
        if (pregunta.equals(p2)){
            res2.setText(res);
            id2.setText(idres);
        }
        if (pregunta.equals(p3)){
            res3.setText(res);
            id3.setText(idres);
        }
        if (pregunta.equals(p4)){
            res4.setText(res);
            id4.setText(idres);
        }
        if (pregunta.equals(p5)){
            res5.setText(res);
            id5.setText(idres);
        }
        if (pregunta.equals(p6)){
            res6.setText(res);
            id6.setText(idres);
        }
        if (pregunta.equals(p7)){
            res7.setText(res);
            id7.setText(idres);
        }
        if (pregunta.equals(p8)){
            res8.setText(res);
            id8.setText(idres);
        }
        if (pregunta.equals(p9)){
            res9.setText(res);
            id9.setText(idres);
        }
        if (pregunta.equals(p10)){
            res10.setText(res);
            id10.setText(idres);
        }
        if (pregunta.equals(p11)){
            res11.setText(res);
            id11.setText(idres);
        }
        if (pregunta.equals(p12)){
            res12.setText(res);
            id12.setText(idres);
        }
        if (pregunta.equals(p13)){
            res13.setText(res);
            id13.setText(idres);
        }
        if (pregunta.equals(p14)){
            res14.setText(res);
            id14.setText(idres);
        }
        if (pregunta.equals(p15)){
            res15.setText(res);
            id15.setText(idres);
        }
        if (pregunta.equals(p16)){
            res16.setText(res);
            id16.setText(idres);
        }
        if (pregunta.equals(p17)){
            res17.setText(res);
            id17.setText(idres);
        }
        if (pregunta.equals(p18)){
            res18.setText(res);
            id18.setText(idres);
        }
    }

}