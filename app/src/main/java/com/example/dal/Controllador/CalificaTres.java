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

public class CalificaTres extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    private String  idUser, taller;
    private TextView lblFecha_3, res1_2, res2_2, res3_2, res4_2, res5_2, res6_2, res7_2, res8_2, res9_2, res10_2, res11_2, res12_2, res13_2, res14_2, res15_2, res16_2, res17_2, res18_2, res19_2, res20_2, res21_2, res22_2, res23_2, res24_2, res25_2, res26_2, res27_2, res28_2, res29_2, res30_2, res31_2;
    private TextView id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id13, id14, id15, id16, id17, id18, id19, id20, id21, id22, id23, id24, id25, id26, id27, id28, id29, id30, id31;
    private EditText nota1, nota2, nota3, nota4, nota5, nota6, nota7, nota8, nota9, nota10, nota11, nota12, nota13, nota14, nota15, nota16, nota17, nota18, nota19, nota20, nota21, nota22, nota23, nota24, nota25, nota26, nota27, nota28, nota29, nota30, nota31;
    private Button btnCalificar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_califica_tres);

        idUser = getIntent().getStringExtra("idUser");
        taller = getIntent().getStringExtra("taller");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        mtdCargarView();

        mtdConsultaRespuesta();

        btnCalificar3.setOnClickListener(new View.OnClickListener() {
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
                String not19 = nota19.getText().toString();
                String not20 = nota20.getText().toString();
                String not21 = nota21.getText().toString();
                String not22 = nota22.getText().toString();
                String not23 = nota23.getText().toString();
                String not24 = nota24.getText().toString();
                String not25 = nota25.getText().toString();
                String not26 = nota26.getText().toString();
                String not27 = nota27.getText().toString();
                String not28 = nota28.getText().toString();
                String not29 = nota29.getText().toString();
                String not30 = nota30.getText().toString();
                String not31 = nota31.getText().toString();

                if (not1.length() == 0 || not2.length() == 0 || not3.length() == 0 || not4.length() == 0 || not5.length() == 0 || not6.length() == 0 || not7.length() == 0 || not8.length() == 0 || not9.length() == 0 || not10.length() == 0 || not11.length() == 0 || not12.length() == 0 || not13.length() == 0 || not14.length() == 0 || not15.length() == 0 || not16.length() == 0 || not17.length() == 0 || not18.length() == 0 || not19.length() == 0 || not20.length() == 0 || not21.length() == 0 || not22.length() == 0 || not23.length() == 0 || not24.length() == 0 || not25.length() == 0 || not26.length() == 0 || not27.length() == 0 || not28.length() == 0 || not29.length() == 0 || not30.length() == 0 || not31.length() == 0){
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

                    int idRes19 = Integer.parseInt(id19.getText().toString());
                    float valNota19 = Float.parseFloat(nota19.getText().toString());

                    int idRes20 = Integer.parseInt(id20.getText().toString());
                    float valNota20 = Float.parseFloat(nota20.getText().toString());

                    int idRes21 = Integer.parseInt(id21.getText().toString());
                    float valNota21 = Float.parseFloat(nota21.getText().toString());

                    int idRes22 = Integer.parseInt(id22.getText().toString());
                    float valNota22 = Float.parseFloat(nota22.getText().toString());

                    int idRes23 = Integer.parseInt(id23.getText().toString());
                    float valNota23 = Float.parseFloat(nota23.getText().toString());

                    int idRes24 = Integer.parseInt(id24.getText().toString());
                    float valNota24 = Float.parseFloat(nota24.getText().toString());

                    int idRes25 = Integer.parseInt(id25.getText().toString());
                    float valNota25 = Float.parseFloat(nota25.getText().toString());

                    int idRes26 = Integer.parseInt(id26.getText().toString());
                    float valNota26 = Float.parseFloat(nota26.getText().toString());

                    int idRes27 = Integer.parseInt(id27.getText().toString());
                    float valNota27 = Float.parseFloat(nota27.getText().toString());

                    int idRes28 = Integer.parseInt(id28.getText().toString());
                    float valNota28 = Float.parseFloat(nota28.getText().toString());

                    int idRes29 = Integer.parseInt(id29.getText().toString());
                    float valNota29 = Float.parseFloat(nota29.getText().toString());

                    int idRes30 = Integer.parseInt(id30.getText().toString());
                    float valNota30 = Float.parseFloat(nota30.getText().toString());

                    int idRes31 = Integer.parseInt(id31.getText().toString());
                    float valNota31 = Float.parseFloat(nota31.getText().toString());

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
                    int r19 = not.mtdPostNota(valNota19, idRes19, idU);
                    int r20 = not.mtdPostNota(valNota20, idRes20, idU);
                    int r21 = not.mtdPostNota(valNota21, idRes21, idU);
                    int r22 = not.mtdPostNota(valNota22, idRes22, idU);
                    int r23 = not.mtdPostNota(valNota23, idRes23, idU);
                    int r24 = not.mtdPostNota(valNota24, idRes24, idU);
                    int r25 = not.mtdPostNota(valNota25, idRes25, idU);
                    int r26 = not.mtdPostNota(valNota26, idRes26, idU);
                    int r27 = not.mtdPostNota(valNota27, idRes27, idU);
                    int r28 = not.mtdPostNota(valNota28, idRes28, idU);
                    int r29 = not.mtdPostNota(valNota29, idRes29, idU);
                    int r30 = not.mtdPostNota(valNota30, idRes30, idU);
                    int r31 = not.mtdPostNota(valNota31, idRes31, idU);

                    if (r1 == 1 && r2 == 1 && r3 == 1 && r4 == 1 && r5 == 1 && r6 == 1 && r7 == 1 && r8 == 1 && r9 == 1 && r10 == 1 && r11 == 1 && r12 == 1 && r13 == 1 && r14 == 1 && r15 == 1 && r16 == 1 && r17 == 1 && r18 == 1 && r19 == 1 && r20 == 1 && r21 == 1 && r22 == 1 && r23 == 1 && r24 == 1 && r25 == 1 && r26 == 1 && r27 == 1 && r28 == 1 && r29 == 1 && r30 == 1 && r31 == 1){

                        int tall = Integer.parseInt(taller);
                        float notaFinalTaller = valNota1 + valNota2 + valNota3 + valNota4 + valNota5 + valNota6 + valNota7 + valNota8 + valNota9 + valNota10 + valNota11 + valNota12 + valNota13 + valNota14 + valNota15 + valNota16 + valNota17 + valNota18 + valNota19 + valNota20 + valNota21 + valNota22 + valNota23 + valNota24 + valNota25 + valNota26 + valNota27 + valNota28 + valNota29 + valNota30 + valNota31;
                        float valorFinalFinal = (notaFinalTaller/31);
                        clNotaTaller notaTa = new clNotaTaller();
                        notaTa.mtdPostNotaTaller(valorFinalFinal, tall, idU);


                        Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(CalificaTres.this, AdminTurus.class);
                        startActivity(intent);

                        finish();

                    }else {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }



            }
        });

    }

    private void mtdCargarView() {

        btnCalificar3 = (Button)findViewById(R.id.btn_califica_taller_3);
        lblFecha_3 = (TextView)findViewById(R.id.lblFecha3);

        res1_2 = (TextView)findViewById(R.id.lblRes1_ta3);
        res2_2 = (TextView)findViewById(R.id.lblRes2_ta3);
        res3_2 = (TextView)findViewById(R.id.lblRes3_ta3);
        res4_2 = (TextView)findViewById(R.id.lblRes4_ta3);
        res5_2 = (TextView)findViewById(R.id.lblRes5_ta3);
        res6_2 = (TextView)findViewById(R.id.lblRes6_ta3);
        res7_2 = (TextView)findViewById(R.id.lblRes7_ta3);
        res8_2 = (TextView)findViewById(R.id.lblRes8_ta3);
        res9_2 = (TextView)findViewById(R.id.lblRes9_ta3);
        res10_2 = (TextView)findViewById(R.id.lblRes10_ta3);
        res11_2 = (TextView)findViewById(R.id.lblRes11_ta3);
        res12_2 = (TextView)findViewById(R.id.lblRes12_ta3);
        res13_2 = (TextView)findViewById(R.id.lblRes13_ta3);
        res14_2 = (TextView)findViewById(R.id.lblRes14_ta3);
        res15_2 = (TextView)findViewById(R.id.lblRes15_ta3);
        res16_2 = (TextView)findViewById(R.id.lblRes16_ta3);
        res17_2 = (TextView)findViewById(R.id.lblRes17_ta3);
        res18_2 = (TextView)findViewById(R.id.lblRes18_ta3);
        res19_2 = (TextView)findViewById(R.id.lblRes19_ta3);
        res20_2 = (TextView)findViewById(R.id.lblRes20_ta3);
        res21_2 = (TextView)findViewById(R.id.lblRes21_ta3);
        res22_2 = (TextView)findViewById(R.id.lblRes22_ta3);
        res23_2 = (TextView)findViewById(R.id.lblRes23_ta3);
        res24_2 = (TextView)findViewById(R.id.lblRes24_ta3);
        res25_2 = (TextView)findViewById(R.id.lblRes25_ta3);
        res26_2 = (TextView)findViewById(R.id.lblRes26_ta3);
        res27_2 = (TextView)findViewById(R.id.lblRes27_ta3);
        res28_2 = (TextView)findViewById(R.id.lblRes28_ta3);
        res29_2 = (TextView)findViewById(R.id.lblRes29_ta3);
        res30_2 = (TextView)findViewById(R.id.lblRes30_ta3);
        res31_2 = (TextView)findViewById(R.id.lblRes31_ta3);


        id1 = (TextView)findViewById(R.id.lblResId1_ta3);
        id2 = (TextView)findViewById(R.id.lblResId2_ta3);
        id3 = (TextView)findViewById(R.id.lblResId3_ta3);
        id4 = (TextView)findViewById(R.id.lblResId4_ta3);
        id5 = (TextView)findViewById(R.id.lblResId5_ta3);
        id6 = (TextView)findViewById(R.id.lblResId6_ta3);
        id7 = (TextView)findViewById(R.id.lblResId7_ta3);
        id8 = (TextView)findViewById(R.id.lblResId8_ta3);
        id9 = (TextView)findViewById(R.id.lblResId9_ta3);
        id10 = (TextView)findViewById(R.id.lblResId10_ta3);
        id11 = (TextView)findViewById(R.id.lblResId11_ta3);
        id12 = (TextView)findViewById(R.id.lblResId12_ta3);
        id13 = (TextView)findViewById(R.id.lblResId13_ta3);
        id14 = (TextView)findViewById(R.id.lblResId14_ta3);
        id15 = (TextView)findViewById(R.id.lblResId15_ta3);
        id16 = (TextView)findViewById(R.id.lblResId16_ta3);
        id17 = (TextView)findViewById(R.id.lblResId17_ta3);
        id18 = (TextView)findViewById(R.id.lblResId18_ta3);
        id19 = (TextView)findViewById(R.id.lblResId19_ta3);
        id20 = (TextView)findViewById(R.id.lblResId20_ta3);
        id21 = (TextView)findViewById(R.id.lblResId21_ta3);
        id22 = (TextView)findViewById(R.id.lblResId22_ta3);
        id23 = (TextView)findViewById(R.id.lblResId23_ta3);
        id24 = (TextView)findViewById(R.id.lblResId24_ta3);
        id25 = (TextView)findViewById(R.id.lblResId25_ta3);
        id26 = (TextView)findViewById(R.id.lblResId26_ta3);
        id27 = (TextView)findViewById(R.id.lblResId27_ta3);
        id28 = (TextView)findViewById(R.id.lblResId28_ta3);
        id29 = (TextView)findViewById(R.id.lblResId29_ta3);
        id30 = (TextView)findViewById(R.id.lblResId30_ta3);
        id31 = (TextView)findViewById(R.id.lblResId31_ta3);

        nota1 = (EditText)findViewById(R.id.txtNota1_ta3);
        nota2 = (EditText)findViewById(R.id.txtNota2_ta3);
        nota3 = (EditText)findViewById(R.id.txtNota3_ta3);
        nota4 = (EditText)findViewById(R.id.txtNota4_ta3);
        nota5 = (EditText)findViewById(R.id.txtNota5_ta3);
        nota6 = (EditText)findViewById(R.id.txtNota6_ta3);
        nota7 = (EditText)findViewById(R.id.txtNota7_ta3);
        nota8 = (EditText)findViewById(R.id.txtNota8_ta3);
        nota9 = (EditText)findViewById(R.id.txtNota9_ta3);
        nota10 = (EditText)findViewById(R.id.txtNota10_ta3);
        nota11 = (EditText)findViewById(R.id.txtNota11_ta3);
        nota12 = (EditText)findViewById(R.id.txtNota12_ta3);
        nota13 = (EditText)findViewById(R.id.txtNota13_ta3);
        nota14 = (EditText)findViewById(R.id.txtNota14_ta3);
        nota15 = (EditText)findViewById(R.id.txtNota15_ta3);
        nota16 = (EditText)findViewById(R.id.txtNota16_ta3);
        nota17 = (EditText)findViewById(R.id.txtNota17_ta3);
        nota18 = (EditText)findViewById(R.id.txtNota18_ta3);
        nota19 = (EditText)findViewById(R.id.txtNota19_ta3);
        nota20 = (EditText)findViewById(R.id.txtNota20_ta3);
        nota21 = (EditText)findViewById(R.id.txtNota21_ta3);
        nota22 = (EditText)findViewById(R.id.txtNota22_ta3);
        nota23 = (EditText)findViewById(R.id.txtNota23_ta3);
        nota24 = (EditText)findViewById(R.id.txtNota24_ta3);
        nota25 = (EditText)findViewById(R.id.txtNota25_ta3);
        nota26 = (EditText)findViewById(R.id.txtNota26_ta3);
        nota27 = (EditText)findViewById(R.id.txtNota27_ta3);
        nota28 = (EditText)findViewById(R.id.txtNota28_ta3);
        nota29 = (EditText)findViewById(R.id.txtNota29_ta3);
        nota30 = (EditText)findViewById(R.id.txtNota30_ta3);
        nota31 = (EditText)findViewById(R.id.txtNota31_ta3);

    }

    private void mtdConsultaRespuesta() {

        int idEnvia = Integer.parseInt(idUser);

        Call<List<clRespuesta>> call = jsonPlaceHolderApi.getRespuestasTaller3(idEnvia);

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

        String p1 = "2_1", p2 = "2_2", p3 = "2_3", p4 = "2_4", p5 = "2_5", p6 = "2_6", p7 = "2_7", p8 = "2_8", p9 = "3_1", p10 = "3_2", p11 = "3_3", p12 = "4_1_com", p13 = "4_2_seg", p14 = "4_3_pri", p15 = "4_4_seg", p16 = "4_5_com", p17 = "4_6_pri", p18 = "4_7_pri", p19 = "4_8_seg", p20 = "4_9_seg", p21 = "4_10_com", p22 = "4_11_com", p23 = "5", p24 = "6", p25 = "7", p26 = "8_1_dl", p27 = "8_2_di", p28 = "8_3_dc", p29 = "8_4_dl", p30 = "8_5_di", p31 = "8_6_dc";

        lblFecha_3.setText(fecha);
        if (pregunta.equals(p1)){
            res1_2.setText(res);
            id1.setText(idres);
        }
        if (pregunta.equals(p2)){
            res2_2.setText(res);
            id2.setText(idres);
        }
        if (pregunta.equals(p3)){
            res3_2.setText(res);
            id3.setText(idres);
        }
        if (pregunta.equals(p4)){
            res4_2.setText(res);
            id4.setText(idres);
        }
        if (pregunta.equals(p5)){
            res5_2.setText(res);
            id5.setText(idres);
        }
        if (pregunta.equals(p6)){
            res6_2.setText(res);
            id6.setText(idres);
        }
        if (pregunta.equals(p7)){
            res7_2.setText(res);
            id7.setText(idres);
        }
        if (pregunta.equals(p8)){
            res8_2.setText(res);
            id8.setText(idres);
        }
        if (pregunta.equals(p9)){
            res9_2.setText(res);
            id9.setText(idres);
        }
        if (pregunta.equals(p10)){
            res10_2.setText(res);
            id10.setText(idres);
        }
        if (pregunta.equals(p11)){
            res11_2.setText(res);
            id11.setText(idres);
        }
        if (pregunta.equals(p12)){
            res12_2.setText(res);
            id12.setText(idres);
        }
        if (pregunta.equals(p13)){
            res13_2.setText(res);
            id13.setText(idres);
        }
        if (pregunta.equals(p14)){
            res14_2.setText(res);
            id14.setText(idres);
        }
        if (pregunta.equals(p15)){
            res15_2.setText(res);
            id15.setText(idres);
        }
        if (pregunta.equals(p16)){
            res16_2.setText(res);
            id16.setText(idres);
        }
        if (pregunta.equals(p17)){
            res17_2.setText(res);
            id17.setText(idres);
        }
        if (pregunta.equals(p18)){
            res18_2.setText(res);
            id18.setText(idres);
        }
        if (pregunta.equals(p19)){
            res19_2.setText(res);
            id19.setText(idres);
        }
        if (pregunta.equals(p20)){
            res20_2.setText(res);
            id20.setText(idres);
        }
        if (pregunta.equals(p21)){
            res21_2.setText(res);
            id21.setText(idres);
        }
        if (pregunta.equals(p22)){
            res22_2.setText(res);
            id22.setText(idres);
        }
        if (pregunta.equals(p23)){
            res23_2.setText(res);
            id23.setText(idres);
        }
        if (pregunta.equals(p24)){
            res24_2.setText(res);
            id24.setText(idres);
        }
        if (pregunta.equals(p25)){
            res25_2.setText(res);
            id25.setText(idres);
        }
        if (pregunta.equals(p26)){
            res26_2.setText(res);
            id26.setText(idres);
        }
        if (pregunta.equals(p27)){
            res27_2.setText(res);
            id27.setText(idres);
        }
        if (pregunta.equals(p28)){
            res28_2.setText(res);
            id28.setText(idres);
        }
        if (pregunta.equals(p29)){
            res29_2.setText(res);
            id29.setText(idres);
        }
        if (pregunta.equals(p30)){
            res30_2.setText(res);
            id30.setText(idres);
        }
        if (pregunta.equals(p31)){
            res31_2.setText(res);
            id31.setText(idres);
        }
    }

}