package com.example.dal.Controllador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dal.Modelo.JsonPlaceHolderApi;
import com.example.dal.Modelo.clRespuesta;
import com.example.dal.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RespuestasNuevo extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private String  idUser;
    private TextView lblFecha, res1, res2, res3, res4, res5, res6, res7, res8, res9, res10, res11, res12, res13, res14, res15, res16, res17, res18, res19, res20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuestas_nuevo);

        idUser = getIntent().getStringExtra("idUser");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        mtdCargarView();

        mtdConsultaRespuesta();

    }

    private void mtdCargarView(){

        lblFecha = (TextView)findViewById(R.id.lblFechaNuevo);

        res1 = (TextView)findViewById(R.id.lblRes1_ta5);
        res2 = (TextView)findViewById(R.id.lblRes2_ta5);
        res3 = (TextView)findViewById(R.id.lblRes3_ta5);
        res4 = (TextView)findViewById(R.id.lblRes4_ta5);
        res5 = (TextView)findViewById(R.id.lblRes5_ta5);
        res6 = (TextView)findViewById(R.id.lblRes6_ta5);
        res7 = (TextView)findViewById(R.id.lblRes7_ta5);
        res8 = (TextView)findViewById(R.id.lblRes8_ta5);
        res9 = (TextView)findViewById(R.id.lblRes9_ta5);
        res10 = (TextView)findViewById(R.id.lblRes10_ta5);
        res11 = (TextView)findViewById(R.id.lblRes11_ta5);
        res12 = (TextView)findViewById(R.id.lblRes12_ta5);
        res13 = (TextView)findViewById(R.id.lblRes13_ta5);
        res14 = (TextView)findViewById(R.id.lblRes14_ta5);
        res15 = (TextView)findViewById(R.id.lblRes15_ta5);
        res16 = (TextView)findViewById(R.id.lblRes16_ta5);
        res17 = (TextView)findViewById(R.id.lblRes17_ta5);
        res18 = (TextView)findViewById(R.id.lblRes18_ta5);
        res19 = (TextView)findViewById(R.id.lblRes19_ta5);
        res20 = (TextView)findViewById(R.id.lblRes20_ta5);
    }

    private void mtdConsultaRespuesta() {

        int idEnvia = Integer.parseInt(idUser);

        Call<List<clRespuesta>> call = jsonPlaceHolderApi.getUsuarioNuevo(idEnvia);

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

                String respuestaUserVal = "";
                String fecha = "";
                String pregunta = "";

                for (clRespuesta respuesta : resp){

                    respuestaUserVal = respuesta.getRespuestaUser();
                    fecha = respuesta.getFecha();
                    pregunta = respuesta.getPregunta();


                    mtdDatosTexViews(respuestaUserVal, fecha, pregunta);

                }

            }

            @Override
            public void onFailure(Call<List<clRespuesta>> call, Throwable t) {

            }
        });

    }

    private void mtdDatosTexViews(String res, String fecha, String pregunta){

        String p1 = "1", p2 = "2", p3 = "3", p4 = "4", p5 = "5", p6 = "6", p7 = "7", p8 = "8", p9 = "9", p10 = "10", p11 = "11", p12 = "12", p13 = "13", p14 = "14", p15 = "15", p16 = "16", p17 = "17", p18 = "18", p19 = "19", p20 = "20";

        lblFecha.setText(fecha);
        if (pregunta.equals(p1)){
            res1.setText(res);
        }
        if (pregunta.equals(p2)){
            res2.setText(res);
        }
        if (pregunta.equals(p3)){
            res3.setText(res);
        }
        if (pregunta.equals(p4)){
            res4.setText(res);
        }
        if (pregunta.equals(p5)){
            res5.setText(res);
        }
        if (pregunta.equals(p6)){
            res6.setText(res);
        }
        if (pregunta.equals(p7)){
            res7.setText(res);
        }
        if (pregunta.equals(p8)){
            res8.setText(res);
        }
        if (pregunta.equals(p9)){
            res9.setText(res);
        }
        if (pregunta.equals(p10)){
            res10.setText(res);
        }
        if (pregunta.equals(p11)){
            res11.setText(res);
        }
        if (pregunta.equals(p12)){
            res12.setText(res);
        }
        if (pregunta.equals(p13)){
            res13.setText(res);
        }
        if (pregunta.equals(p14)){
            res14.setText(res);
        }
        if (pregunta.equals(p15)){
            res15.setText(res);
        }
        if (pregunta.equals(p16)){
            res16.setText(res);
        }
        if (pregunta.equals(p17)){
            res17.setText(res);
        }
        if (pregunta.equals(p18)){
            res18.setText(res);
        }
        if (pregunta.equals(p19)){
            res19.setText(res);
        }
        if (pregunta.equals(p20)){
            res20.setText(res);
        }
    }

}