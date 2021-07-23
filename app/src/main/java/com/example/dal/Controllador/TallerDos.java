package com.example.dal.Controllador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.dal.Modelo.clRespuesta;
import com.example.dal.R;

public class TallerDos extends AppCompatActivity {

    private AnimationDrawable animationDrawable;
    private ScrollView scrollView;

    private RadioButton rb7_1_1, rb7_1_2, rb7_1_3, rb7_1_4, rb7_2_1, rb7_2_2, rb7_2_3, rb7_2_4, rb7_3_1, rb7_3_2, rb7_3_3, rb7_3_4;
    public String nombreHomeUser, numeroAvatarUser, idUser;
    private EditText txtres1, txtres2, txtres3, txtres4, txtres5, txtres6, txtres7, txtres8, txtres12, txtres13, txtres14, txtres15, txtres16, txtres17, txtres18;
    public String res7_1 = "", res7_2 = "", res7_3 = "";
    private Button btnEnviaTaller2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller_dos);

        idUser = getIntent().getStringExtra("idUser");
        nombreHomeUser = getIntent().getStringExtra("datoNombre");
        numeroAvatarUser = getIntent().getStringExtra("datoAvatar");

        scrollView = findViewById(R.id.SCTdos);
        btnEnviaTaller2 = (Button)findViewById(R.id.btn_enviar_taller_2);

        mtdCargarView();

        animationDrawable = (AnimationDrawable) scrollView.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        btnEnviaTaller2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int val1 = valida();
                int val2 = validaCheck();

                if (val1 == 1 && val2 == 1){
                    int res = mtdPost();
                    if (res == 1){
                        Toast.makeText(getApplicationContext(), "Taller 2 enviado con exito.", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(TallerDos.this, ModuloTaller.class);
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
                    Toast.makeText(getApplicationContext(), "Datos vacios en el formularios.", Toast.LENGTH_LONG).show();
                }


            }
        });

    }

    private int valida(){
        int retorna = 0;

        String r1 = "", r2 = "", r3 = "", r4 = "", r5 = "", r6 = "", r7 = "", r8 = "", r9 = "", r10 = "";
        String r11 = "", r12 = "", r13 = "", r14 = "", r15 = "", r16 = "", r17 = "", r18 = "";

        r1 = txtres1.getText().toString();
        r2 = txtres2.getText().toString();
        r3 = txtres3.getText().toString();
        r4 = txtres4.getText().toString();
        r5 = txtres5.getText().toString();
        r6 = txtres6.getText().toString();
        r7 = txtres7.getText().toString();
        r8 = txtres8.getText().toString();
        r9 = txtres12.getText().toString();
        r10 = txtres13.getText().toString();
        r11 = txtres14.getText().toString();
        r12 = txtres15.getText().toString();
        r13 = txtres16.getText().toString();

        if (r1.length() == 0 || r2.length() == 0 || r3.length() == 0 || r4.length() == 0 || r5.length() == 0 || r6.length() == 0 || r7.length() == 0 || r8.length() == 0 || r9.length() == 0 || r10.length() == 0 || r11.length() == 0 || r12.length() == 0 || r13.length() == 0){
            retorna = 0;
        }else {
            retorna = 1;
        }

        return retorna;
    }

    private int validaCheck(){

        int retorna = 0;

        if (rb7_1_1.isChecked()==false && rb7_1_2.isChecked() == false && rb7_1_3.isChecked() == false && rb7_1_4.isChecked() == false || rb7_2_1.isChecked()==false && rb7_2_2.isChecked() == false && rb7_2_3.isChecked() == false && rb7_2_4.isChecked() == false || rb7_3_1.isChecked()==false && rb7_3_2.isChecked() == false && rb7_3_3.isChecked() == false && rb7_3_4.isChecked() == false){
            retorna = 0;
        }else {
            retorna = 1;
        }
        return retorna;
    }

    private void mtdCargarView() {

        rb7_1_1 = (RadioButton)findViewById(R.id.rg_rb_7one_1_ta2);
        rb7_1_2 = (RadioButton)findViewById(R.id.rg_rb_7one_2_ta2);
        rb7_1_3 = (RadioButton)findViewById(R.id.rg_rb_7one_3_ta2);
        rb7_1_4 = (RadioButton)findViewById(R.id.rg_rb_7one_4_ta2);
        rb7_2_1 = (RadioButton)findViewById(R.id.rg_rb_7two_1_ta2);
        rb7_2_2 = (RadioButton)findViewById(R.id.rg_rb_7two_2_ta2);
        rb7_2_3 = (RadioButton)findViewById(R.id.rg_rb_7two_3_ta2);
        rb7_2_4 = (RadioButton)findViewById(R.id.rg_rb_7two_4_ta2);
        rb7_3_1 = (RadioButton)findViewById(R.id.rg_rb_7three_1_ta2);
        rb7_3_2 = (RadioButton)findViewById(R.id.rg_rb_7three_2_ta2);
        rb7_3_3 = (RadioButton)findViewById(R.id.rg_rb_7three_3_ta2);
        rb7_3_4 = (RadioButton)findViewById(R.id.rg_rb_7three_4_ta2);

        txtres1 = (EditText)findViewById(R.id.txtres2_ta2);
        txtres2 = (EditText)findViewById(R.id.txtres3_1_ta2);
        txtres3 = (EditText)findViewById(R.id.txtres3_2_ta2);
        txtres4 = (EditText)findViewById(R.id.txtres3_3_ta2);
        txtres5 = (EditText)findViewById(R.id.txtres3_4_ta2);
        txtres6 = (EditText)findViewById(R.id.txtres4_ta2);
        txtres7 = (EditText)findViewById(R.id.txtres5_ta2);
        txtres8 = (EditText)findViewById(R.id.txtres6_ta2);
        txtres12 = (EditText)findViewById(R.id.txtres8_ta2);
        txtres13 = (EditText)findViewById(R.id.txtres9_1_1_ta2);
        txtres14 = (EditText)findViewById(R.id.txtres9_1_2_ta2);
        txtres15 = (EditText)findViewById(R.id.txtres9_1_3_ta2);
        txtres16 = (EditText)findViewById(R.id.txtres9_2_1_ta2);
        txtres17 = (EditText)findViewById(R.id.txtres9_2_2_ta2);
        txtres18 = (EditText)findViewById(R.id.txtres9_2_3_ta2);
    }

    private void cargaResRadio(){

        if (rb7_1_1.isChecked()==true){
            res7_1 = "a.La palabra más importante de la clase obrera es “solidaridad” (Harry Bridge).";
        }else if (rb7_1_2.isChecked() == true){
            res7_1 = "b.El obrero no lucha por si mismo, sino por toda la clase obrera” (Nicolás Berdiaeff).";
        }else if (rb7_1_3.isChecked() == true){
            res7_1 = "c.La clase obrera se va aburguesando cada vez más” (Friedrich Engels).";
        }else if (rb7_1_4.isChecked() == true){
            res7_1 = "d.El obrero tiene más necesidad de respeto que de pan” (Anónimo).";
        }

        if (rb7_2_1.isChecked()==true){
            res7_2 = "a.Los obreros deben trabajar más duro para ganar mejor.";
        }else if (rb7_2_2.isChecked() == true){
            res7_2 = "b.Existen muchas injusticias con la clase trabajadora.";
        }else if (rb7_2_3.isChecked() == true){
            res7_2 = "c.El Estado no tiene las suficientes tierras para todas las personas. ";
        }else if (rb7_2_4.isChecked() == true){
            res7_2 = "d.Los trabajadores deben gastar menos en mercado para que les alcance el dinero.";
        }

        if (rb7_3_1.isChecked()==true){
            res7_3 = "a.Se encuentra bastante feliz por haberse reunido con sus amigos.";
        }else if (rb7_3_2.isChecked() == true){
            res7_3 = "b.Juzga a los personajes por no ser más fuertes ante las situaciones difíciles.";
        }else if (rb7_3_3.isChecked() == true){
            res7_3 = "c.No se encuentra conforme con la situación de injusticia que están pasando los obreros.";
        }else if (rb7_3_4.isChecked() == true){
            res7_3 = "d.Está convencido que puede cambiar los sentimientos de las personas con quienes habla.";
        }
    }

    private int mtdPost(){

        cargaResRadio();

        clRespuesta respuesta = new clRespuesta();
        int tallerr = 2;
        int id = Integer.parseInt(idUser);

        String respuesta2 = "2: " + txtres1.getText().toString();
        String pregunta2 = "2";

        String respuesta3_1 = "Quienes participan: " + txtres2.getText().toString();
        String pregunta3_1 = "3_1";

        String respuesta3_2 = "Donde se desarrollo: " + txtres3.getText().toString();
        String pregunta3_2 = "3_2";

        String respuesta3_3 = "Por que eran timidos: " + txtres4.getText().toString();
        String pregunta3_3 = "3_3";

        String respuesta3_4 = "cual problema existe: " + txtres5.getText().toString();
        String pregunta3_4 = "3_4";

        String respuesta4 = "4: " + txtres6.getText().toString();
        String pregunta4 = "4";

        String respuesta5 = "5: " + txtres7.getText().toString();
        String pregunta5 = "5";

        String respuesta6 = "6: " + txtres8.getText().toString();
        String pregunta6 = "6";

        String respuesta7_1 = "7_1: " + res7_1;
        String pregunta7_1 = "7_1";

        String respuesta7_2 = "7_2: " + res7_2;
        String pregunta7_2 = "7_2";

        String respuesta7_3 = "7_3: " + res7_3;
        String pregunta7_3 = "7_3";

        String respuesta8 =  "8: " + txtres12.getText().toString();
        String pregunta8 = "8";

        String respuesta9_1_1 = "9_1_D_DL: " + txtres13.getText().toString();
        String pregunta9_1_1 = "9_1_1";

        String respuesta9_1_2 = "9_2_D_DI: " + txtres14.getText().toString();
        String pregunta9_1_2 = "9_1_2";

        String respuesta9_1_3 = "9_3_D_DC: " + txtres15.getText().toString();
        String pregunta9_1_3 = "9_1_3";

        String respuesta9_2_1 = "9_4_D_DL: " + txtres16.getText().toString();
        String pregunta9_2_1 = "9_2_1";

        String respuesta9_2_2 = "9_5_D_DI: " + txtres17.getText().toString();
        String pregunta9_2_2 = "9_2_2";

        String respuesta9_2_3 = "9_6_D_DC: " + txtres18.getText().toString();
        String pregunta9_2_3 = "9_2_3";


        int res = respuesta.mtdPostRespuesta(respuesta2, pregunta2, tallerr, id );
        int res2 = respuesta.mtdPostRespuesta(respuesta3_1, pregunta3_1, tallerr, id);
        int res3 = respuesta.mtdPostRespuesta(respuesta3_2, pregunta3_2, tallerr, id );
        int res4 = respuesta.mtdPostRespuesta(respuesta3_3, pregunta3_3, tallerr, id);
        int res5 = respuesta.mtdPostRespuesta(respuesta3_4, pregunta3_4, tallerr, id );
        int res6 = respuesta.mtdPostRespuesta(respuesta4, pregunta4, tallerr, id);
        int res7 = respuesta.mtdPostRespuesta(respuesta5, pregunta5, tallerr, id );
        int res8 = respuesta.mtdPostRespuesta(respuesta6, pregunta6, tallerr, id);
        int res9 = respuesta.mtdPostRespuesta(respuesta7_1, pregunta7_1, tallerr, id );
        int res10 = respuesta.mtdPostRespuesta(respuesta7_2, pregunta7_2, tallerr, id);
        int res11 = respuesta.mtdPostRespuesta(respuesta7_3, pregunta7_3, tallerr, id );
        int res12 = respuesta.mtdPostRespuesta(respuesta8, pregunta8, tallerr, id);
        int res13 = respuesta.mtdPostRespuesta(respuesta9_1_1, pregunta9_1_1, tallerr, id );
        int res14 = respuesta.mtdPostRespuesta(respuesta9_1_2, pregunta9_1_2, tallerr, id);
        int res15 = respuesta.mtdPostRespuesta(respuesta9_1_3, pregunta9_1_3, tallerr, id );
        int res16 = respuesta.mtdPostRespuesta(respuesta9_2_1, pregunta9_2_1, tallerr, id);
        int res17 = respuesta.mtdPostRespuesta(respuesta9_2_2, pregunta9_2_2, tallerr, id );
        int res18 = respuesta.mtdPostRespuesta(respuesta9_2_3, pregunta9_2_3, tallerr, id);

        if (res == 1 && res2 == 1 && res3 == 1 && res4 == 1 && res5 == 1 && res6 == 1 && res7 == 1 && res8 == 1 && res9 == 1 && res10 == 1 && res11 == 1 && res12 == 1 && res13 == 1 && res14 == 1 && res15 == 1 && res16 == 1 && res17 == 1 && res18 == 1){
            return 1;
        }else {
            return 0;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}