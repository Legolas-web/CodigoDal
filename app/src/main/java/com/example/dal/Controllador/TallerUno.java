package com.example.dal.Controllador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dal.Modelo.clRespuesta;
import com.example.dal.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class TallerUno extends AppCompatActivity {

    private AnimationDrawable animationDrawable;
    private ScrollView scrollView;
    private ImageView imgRuleta;
    private EditText txtresp2a, txtresp2b, txtresp2c, txtresp2d, txtresp3, txtresp4_1_1, txtresp4_1_2, txtresp4_2_1, txtresp4_2_2, txtresp4_3_1, txtresp4_3_2, txtresp5, txtresp6_1_1, txtresp6_1_2, txtresp6_1_3, txtresp6_2_1, txtresp6_2_2, txtresp6_2_3;
    private Button btnEnvia;

    private TextView txtGira, lblIndicador, lblpalabra;

    public String nombreHomeUser, numeroAvatarUser, idUser;

    String[] sectors = {"01", "02", "03", "04", "05", "06", "07", "08"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller_uno);

        idUser = getIntent().getStringExtra("idUser");
        nombreHomeUser = getIntent().getStringExtra("datoNombre");
        numeroAvatarUser = getIntent().getStringExtra("datoAvatar");


        scrollView = findViewById(R.id.aTuno);
        txtGira = findViewById(R.id.txtGiraRuleta);
        imgRuleta = (ImageView) findViewById(R.id.imgRuleta2);
        lblIndicador = findViewById(R.id.lblIndica);
        lblpalabra = findViewById(R.id.lblPalabaraSelect);
        mtdCargarView();

        Collections.reverse(Arrays.asList(sectors));

        txtGira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtdGirar();
                btnEnvia.setVisibility(View.VISIBLE);
            }
        });


        animationDrawable = (AnimationDrawable) scrollView.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        btnEnvia = (Button)findViewById(R.id.btn_enviar_taller_1);
        btnEnvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int vali = valida();

                if (vali == 1){
                    int res = mtdPost();
                    if (res == 1){
                        Toast.makeText(getApplicationContext(), "Taller 1 enviado con exito.", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(TallerUno.this, ModuloTaller.class);
                        intent.putExtra("idUser", idUser);
                        intent.putExtra("datoNombre", nombreHomeUser);
                        intent.putExtra("datoAvatar", numeroAvatarUser);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Datos vacios en el formulario.", Toast.LENGTH_LONG).show();
                }




            }
        });

    }

    private int valida(){
        int retorna = 0;

        String r1 = "", r2 = "", r3 = "", r4 = "", r5 = "", r6 = "", r7 = "", r8 = "", r9 = "", r10 = "";
        String r11 = "", r12 = "", r13 = "", r14 = "", r15 = "", r16 = "", r17 = "", r18 = "";

        r1 = txtresp2a.getText().toString();
        r2 = txtresp2b.getText().toString();
        r3 = txtresp2c.getText().toString();
        r4 = txtresp2d.getText().toString();
        r5 = txtresp3.getText().toString();

        r6 = txtresp4_1_1.getText().toString();
        r7 = txtresp4_1_2.getText().toString();
        r8 = txtresp4_2_1.getText().toString();
        r9 = txtresp4_2_2.getText().toString();
        r10 = txtresp4_3_1.getText().toString();
        r11 = txtresp4_3_2.getText().toString();
        r12 = txtresp5.getText().toString();
        r13 = txtresp6_1_1.getText().toString();
        r14 = txtresp6_1_2.getText().toString();
        r15 = txtresp6_1_3.getText().toString();
        r16 = txtresp6_2_1.getText().toString();
        r17 = txtresp6_2_2.getText().toString();
        r18 = txtresp6_2_3.getText().toString();

        if (r1.length() == 0 || r2.length() == 0 || r3.length() == 0 || r4.length() == 0 || r5.length() == 0 || r6.length() == 0 || r7.length() == 0 || r8.length() == 0 || r9.length() == 0 || r10.length() == 0 || r11.length() == 0 || r12.length() == 0 || r13.length() == 0 || r14.length() == 0 || r15.length() == 0 || r16.length() == 0 || r17.length() == 0 || r18.length() == 0){
            retorna = 0;
        }else {
            retorna = 1;
        }

        return retorna;
    }

    private int mtdPost(){
        clRespuesta respuesta = new clRespuesta();
        int tallerr = 1;
        int tallerr2 = 5;
        int id = Integer.parseInt(idUser);
        //------------------------------------------------------------------------------------------------
        String respuesta2a = "2_a: " + txtresp2a.getText().toString();
        String pregunta2a = "2a";

        String respuesta2b = "2_b: " + txtresp2b.getText().toString();
        String pregunta2b = "2b";

        String respuesta2c = "2_c: " + txtresp2c.getText().toString();
        String pregunta2c = "2c";

        String respuesta2d = "2_d: " + txtresp2d.getText().toString();
        String pregunta2d = "2d";

        String respuesta3 = "3: " + lblpalabra.getText().toString() + ": " +  txtresp3.getText().toString();
        String pregunta3 = "3";


        String respuesta4_1_1 = "4_1_deacuerdo: " + txtresp4_1_1.getText().toString();
        String pregunta4_1_1 = "4_1_1";

        String respuesta4_1_2 = "4_2_no_deacuerdo: " + txtresp4_1_2.getText().toString();
        String pregunta4_1_2 = "4_1_2";

        String respuesta4_2_1 = "4_3_deacuerdo: " +  txtresp4_2_1.getText().toString();
        String pregunta4_2_1 = "4_2_1";

        String respuesta4_2_2 = "4_4_no_deacuerdo: " + txtresp4_2_2.getText().toString();
        String pregunta4_2_2 = "4_2_2";

        String respuesta4_3_1 = "4_5_deacuerdo: " + txtresp4_3_1.getText().toString();
        String pregunta4_3_1 = "4_3_1";

        String respuesta4_3_2 = "4_6_no_deacuerdo: " + txtresp4_3_2.getText().toString();
        String pregunta4_3_2 =  "4_3_2";

        String respuesta5 = "5: " + txtresp5.getText().toString();
        String pregunta5 = "5";

        String respuesta6_1_1 = "6_1_D_Literal: " + txtresp6_1_1.getText().toString();
        String pregunta6_1_1 = "6_1_1";

        String respuesta6_1_2 = "6_2_D_Inferencial: " + txtresp6_1_2.getText().toString();
        String pregunta6_1_2 = "6_1_2";

        String respuesta6_1_3 = "6_3_D_Critica: " + txtresp6_1_3.getText().toString();
        String pregunta6_1_3 = "6_1_3";

        String respuesta6_2_1 = "6_4_D_Literal: " + txtresp6_2_1.getText().toString();
        String pregunta6_2_1 = "6_2_1";

        String respuesta6_2_2 = "6_5_D_Inferencial: " + txtresp6_2_2.getText().toString();
        String pregunta6_2_2 = "6_2_2";

        String respuesta6_2_3 = "6_6_D_Critica: " + txtresp6_2_3.getText().toString();
        String pregunta6_2_3 = "6_2_3";


        //------------------------------------------------------------------------------------------------
        int res = respuesta.mtdPostRespuesta(respuesta2a, pregunta2a, tallerr, id );
        int res2 = respuesta.mtdPostRespuesta(respuesta2b, pregunta2b, tallerr, id);
        int res3 = respuesta.mtdPostRespuesta(respuesta2c, pregunta2c, tallerr, id );
        int res4 = respuesta.mtdPostRespuesta(respuesta2d, pregunta2d, tallerr, id);
        int res5 = respuesta.mtdPostRespuesta(respuesta3, pregunta3, tallerr, id );
        int res6 = respuesta.mtdPostRespuesta(respuesta4_1_1, pregunta4_1_1, tallerr, id);
        int res7 = respuesta.mtdPostRespuesta(respuesta4_1_2, pregunta4_1_2, tallerr, id );
        int res8 = respuesta.mtdPostRespuesta(respuesta4_2_1, pregunta4_2_1, tallerr, id);
        int res9 = respuesta.mtdPostRespuesta(respuesta4_2_2, pregunta4_2_2, tallerr, id );
        int res10 = respuesta.mtdPostRespuesta(respuesta4_3_1, pregunta4_3_1, tallerr, id);
        int res11 = respuesta.mtdPostRespuesta(respuesta4_3_2, pregunta4_3_2, tallerr, id );
        int res12 = respuesta.mtdPostRespuesta(respuesta5, pregunta5, tallerr, id);
        int res13 = respuesta.mtdPostRespuesta(respuesta6_1_1, pregunta6_1_1, tallerr, id );
        int res14 = respuesta.mtdPostRespuesta(respuesta6_1_2, pregunta6_1_2, tallerr, id);
        int res15 = respuesta.mtdPostRespuesta(respuesta6_1_3, pregunta6_1_3, tallerr, id );
        int res16 = respuesta.mtdPostRespuesta(respuesta6_2_1, pregunta6_2_1, tallerr, id);
        int res17 = respuesta.mtdPostRespuesta(respuesta6_2_2, pregunta6_2_2, tallerr, id );
        int res18 = respuesta.mtdPostRespuesta(respuesta6_2_3, pregunta6_2_3, tallerr, id);

        if (res == 1 && res2 == 1 && res3 == 1 && res4 == 1 && res5 == 1 && res6 == 1 && res7 == 1 && res8 == 1 && res9 == 1 && res10 == 1 && res11 == 1 && res12 == 1 && res13 == 1 && res14 == 1 && res15 == 1 && res16 == 1 && res17 == 1 && res18 == 1){
            return 1;
        }else {
            return 0;
        }

    }

    private void mtdCargarView(){

        txtresp2a = (EditText)findViewById(R.id.txtresp_2a);
        txtresp2b = (EditText)findViewById(R.id.txtresp_2b);
        txtresp2c = (EditText)findViewById(R.id.txtresp_2c);
        txtresp2d = (EditText)findViewById(R.id.txtresp_2d);
        txtresp3 = (EditText)findViewById(R.id.txtresp_3);
        txtresp4_1_1 = (EditText)findViewById(R.id.txtresp_4_1_1);
        txtresp4_1_2 = (EditText)findViewById(R.id.txtresp_4_1_2);
        txtresp4_2_1 = (EditText)findViewById(R.id.txtresp_4_2_1);
        txtresp4_2_2 = (EditText)findViewById(R.id.txtresp_4_2_2);
        txtresp4_3_1 = (EditText)findViewById(R.id.txtresp_4_3_1);
        txtresp4_3_2 = (EditText)findViewById(R.id.txtresp_4_3_2);
        txtresp5 = (EditText)findViewById(R.id.txtresp_5);
        txtresp6_1_1 = (EditText)findViewById(R.id.txtresp_6_1_1);
        txtresp6_1_2 = (EditText)findViewById(R.id.txtresp_6_1_2);
        txtresp6_1_3 = (EditText)findViewById(R.id.txtresp_6_1_3);
        txtresp6_2_1 = (EditText)findViewById(R.id.txtresp_6_2_1);
        txtresp6_2_2 = (EditText)findViewById(R.id.txtresp_6_2_2);
        txtresp6_2_3 = (EditText)findViewById(R.id.txtresp_6_2_3);

    }

    public void mtdGirar(){
        Random rr = new Random();
        final int degree = rr.nextInt(360);

        RotateAnimation rotateAnimation = new RotateAnimation(0, degree + 720, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f );

        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                CalculatePoint(degree);
            }

            @Override
            public void onAnimationEnd(Animation animation) {


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imgRuleta.startAnimation(rotateAnimation);

    }

    private void CalculatePoint(int degree) {
        int initialPoint = 0;
        int endPoint = 45;
        int i = 0;

        String res = null;

        do {
            if (degree > initialPoint && degree < endPoint){
                res = sectors[i];
            }
            initialPoint += 45;
            endPoint += 45;
            i++;
        }while (res == null);

        lblIndicador.setText(res);

        int val = Integer.parseInt(lblIndicador.getText().toString());

        if(val == 1){
            lblpalabra.setText("RAZONAMIENTO");
        }else if (val == 2){
            lblpalabra.setText("FÈ");
        }else if (val == 3){
            lblpalabra.setText("LUCHA");
        }else if (val == 4){
            lblpalabra.setText("LIBERTAD");
        }else if (val == 5){
            lblpalabra.setText("RELIGIONES PROTESTANTES");
        }else if (val == 6){
            lblpalabra.setText("ESPÌRITU PEREZOSO");
        }else if (val == 7){
            lblpalabra.setText("ESCEPTICISMO");
        }else if (val == 8){
            lblpalabra.setText("RELIGIÒN");
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}