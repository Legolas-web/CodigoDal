package com.example.dal.Controllador;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.dal.Modelo.clRespuesta;
import com.example.dal.R;

public class TallerTres extends AppCompatActivity {

    private AnimationDrawable animationDrawable;
    private ScrollView scrollView;
    private EditText txtres1, txtres2, txtres3, txtres4, txtres5, txtres6, txtres7, txtres8, txtres9, txtres10, txtres11, txtres4_1_com, txtres4_3_seg, txtres4_9_pri, txtres4_4_seg, txtres4_2_com;
    private EditText txtres4_7_pri, txtres4_5_pri, txtres4_8_seg, txtres4_6_seg, txtres4_11_com, txtres4_10_com, txtres23, txtres24, txtres25, txtres26, txtres27, txtres28, txtres29, txtres30, txtres31;
    private Button btnEnvia3;
    public String nombreHomeUser, numeroAvatarUser, idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller_tres);

        idUser = getIntent().getStringExtra("idUser");
        nombreHomeUser = getIntent().getStringExtra("datoNombre");
        numeroAvatarUser = getIntent().getStringExtra("datoAvatar");

        scrollView = findViewById(R.id.SCTtres);
        btnEnvia3 = (Button)findViewById(R.id.btn_enviar_taller_3);

        animationDrawable = (AnimationDrawable) scrollView.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        mtdCargarView();

        btnEnvia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtdCargarView();

                int va = mtdvalida();

                if (va == 1 ){
                    int res = mtdPost();
                    if (res == 1){
                        Toast.makeText(getApplicationContext(), "Taller 3 enviado con exito.", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(TallerTres.this, ModuloTaller.class);
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
                    Toast.makeText(getApplicationContext(), "Datos vacios en el formulario", Toast.LENGTH_LONG).show();
                }


            }
        });

    }

    private int mtdvalida(){
        int retorna = 0;

        String r1 = "", r2 = "", r3 = "", r4 = "", r5 = "", r6 = "", r7 = "", r8 = "", r9 = "", r10 = "";
        String r11 = "", r12 = "", r13 = "", r14 = "", r15 = "", r16 = "", r17 = "", r18 = "", r19 = "", r20 = "";
        String r21 = "", r22 = "", r23 = "", r24 = "", r25 = "", r26 = "", r27 = "", r28 = "", r29 = "", r30 = "", r31 = "";

        r1 = txtres1.getText().toString();
        r2 = txtres1.getText().toString();
        r3 = txtres3.getText().toString();
        r4 = txtres4.getText().toString();
        r5 = txtres5.getText().toString();
        r6 = txtres6.getText().toString();
        r7 = txtres7.getText().toString();
        r8 = txtres8.getText().toString();
        r9 = txtres9.getText().toString();
        r10 = txtres10.getText().toString();
        r11 = txtres11.getText().toString();
        r12 = txtres4_1_com.getText().toString();
        r13 = txtres4_3_seg.getText().toString();
        r14 = txtres4_9_pri.getText().toString();
        r15 = txtres4_4_seg.getText().toString();
        r16 = txtres4_2_com.getText().toString();
        r17 = txtres4_7_pri.getText().toString();
        r18 = txtres4_5_pri.getText().toString();
        r19 = txtres4_8_seg.getText().toString();
        r20 = txtres4_6_seg.getText().toString();
        r21 = txtres4_11_com.getText().toString();
        r22 = txtres4_10_com.getText().toString();
        r23 = txtres23.getText().toString();
        r24 = txtres24.getText().toString();
        r25 = txtres25.getText().toString();
        r26 = txtres26.getText().toString();
        r27 = txtres27.getText().toString();
        r28 = txtres28.getText().toString();
        r29 = txtres29.getText().toString();
        r30 = txtres30.getText().toString();
        r31 = txtres31.getText().toString();

        if (r1.length() == 0 || r2.length() == 0 || r3.length() == 0 || r4.length() == 0 || r5.length() == 0 || r6.length() == 0 || r7.length() == 0 || r8.length() == 0 || r9.length() == 0 || r10.length() == 0 || r11.length() == 0 || r12.length() == 0 || r13.length() == 0 || r14.length() == 0 || r15.length() == 0 || r16.length() == 0 || r17.length() == 0 || r18.length() == 0 || r19.length() == 0 || r20.length() == 0 || r21.length() == 0 || r22.length() == 0 || r23.length() == 0 || r24.length() == 0 || r25.length() == 0 || r26.length() == 0 || r27.length() == 0 || r28.length() == 0 || r29.length() == 0 || r30.length() == 0 || r31.length() == 0 ){
            retorna = 0;
        }else {
            retorna = 1;
        }

        return retorna;
    }

    private int mtdPost() {

        clRespuesta respuesta = new clRespuesta();
        int tallerr = 3;
        int id = Integer.parseInt(idUser);

        String res1 = "Febril: " + txtres1.getText().toString();
        String pre1 = "2_1";
        String res2 = "Atusa: " +  txtres2.getText().toString();
        String pre2 = "2_2";
        String res3 = "Flaccidos: " +  txtres3.getText().toString();
        String pre3 = "2_3";
        String res4 = "Exangües: " +  txtres4.getText().toString();
        String pre4 = "2_4";
        String res5 = "Plañidos: " +  txtres5.getText().toString();
        String pre5 = "2_5";
        String res6 = "Someramente: " +  txtres6.getText().toString();
        String pre6 = "2_6";
        String res7 = "Hoscamente: " +  txtres7.getText().toString();
        String pre7 = "2_7";
        String res8 = "Corolario: " +  txtres8.getText().toString();
        String pre8 = "2_8";

        String res9 = "3_1: " + txtres9.getText().toString();
        String pre9 = "3_1";
        String res10 = "3_2: " + txtres10.getText().toString();
        String pre10 = "3_2";
        String res11 = "3_3: " + txtres11.getText().toString();
        String pre11 = "3_3";

        String res12 = "Idea complementaria: " + txtres4_1_com.getText().toString();
        String pre12 = "4_1_com";
        String res13 = "Idea secundaria: " + txtres4_3_seg.getText().toString();
        String pre13 = "4_2_seg";
        String res14 = "Idea primaria: " + txtres4_9_pri.getText().toString();
        String pre14 = "4_3_pri";
        String res15 = "Idea secundaria: " + txtres4_4_seg.getText().toString();
        String pre15 = "4_4_seg";
        String res16 = "Idea complementaria: " + txtres4_2_com.getText().toString();
        String pre16 = "4_5_com";
        String res17 = "Idea primaria: " + txtres4_7_pri.getText().toString();
        String pre17 = "4_6_pri";
        String res18 = "Idea primaria: " + txtres4_5_pri.getText().toString();
        String pre18 = "4_7_pri";
        String res19 = "Idea secundaria: " + txtres4_8_seg.getText().toString();
        String pre19 = "4_8_seg";
        String res20 = "Idea secundaria: " + txtres4_6_seg.getText().toString();
        String pre20 = "4_9_seg";
        String res21 = "Idea complementaria: " + txtres4_11_com.getText().toString();
        String pre21 = "4_10_com";
        String res22 = "Idea complementaria: " + txtres4_10_com.getText().toString();
        String pre22 = "4_11_com";

        String res23 = "5: " + txtres23.getText().toString();
        String pre23 = "5";
        String res24 = "6: " + txtres24.getText().toString();
        String pre24 = "6";
        String res25 = "7: " + txtres25.getText().toString();
        String pre25 = "7";
        String res26 = "8_1_D_DL: " + txtres26.getText().toString();
        String pre26 = "8_1_dl";
        String res27 = "8_2_D_DI: " + txtres27.getText().toString();
        String pre27 = "8_2_di";
        String res28 = "8_3_D_DC: " + txtres28.getText().toString();
        String pre28 = "8_3_dc";
        String res29 = "8_4_D_DL: " + txtres29.getText().toString();
        String pre29 = "8_4_dl";
        String res30 = "8_1_D_DI: " + txtres30.getText().toString();
        String pre30 = "8_5_di";
        String res31 = "8_1_D_DC: " + txtres31.getText().toString();
        String pre31 = "8_6_dc";

        int ress = respuesta.mtdPostRespuesta(res1, pre1, tallerr, id );
        int ress2 = respuesta.mtdPostRespuesta(res2, pre2, tallerr, id );
        int ress3 = respuesta.mtdPostRespuesta(res3, pre3, tallerr, id );
        int ress4 = respuesta.mtdPostRespuesta(res4, pre4, tallerr, id );
        int ress5 = respuesta.mtdPostRespuesta(res5, pre5, tallerr, id );
        int ress6 = respuesta.mtdPostRespuesta(res6, pre6, tallerr, id );
        int ress7 = respuesta.mtdPostRespuesta(res7, pre7, tallerr, id );
        int ress8 = respuesta.mtdPostRespuesta(res8, pre8, tallerr, id );
        int ress9 = respuesta.mtdPostRespuesta(res9, pre9, tallerr, id );
        int ress10 = respuesta.mtdPostRespuesta(res10, pre10, tallerr, id );
        int ress11 = respuesta.mtdPostRespuesta(res11, pre11, tallerr, id );
        int ress12 = respuesta.mtdPostRespuesta(res12, pre12, tallerr, id );
        int ress13 = respuesta.mtdPostRespuesta(res13, pre13, tallerr, id );
        int ress14 = respuesta.mtdPostRespuesta(res14, pre14, tallerr, id );
        int ress15 = respuesta.mtdPostRespuesta(res15, pre15, tallerr, id );
        int ress16 = respuesta.mtdPostRespuesta(res16, pre16, tallerr, id );
        int ress17 = respuesta.mtdPostRespuesta(res17, pre17, tallerr, id );
        int ress18 = respuesta.mtdPostRespuesta(res18, pre18, tallerr, id );
        int ress19 = respuesta.mtdPostRespuesta(res19, pre19, tallerr, id );
        int ress20 = respuesta.mtdPostRespuesta(res20, pre20, tallerr, id );
        int ress21 = respuesta.mtdPostRespuesta(res21, pre21, tallerr, id );
        int ress22 = respuesta.mtdPostRespuesta(res22, pre22, tallerr, id );
        int ress23 = respuesta.mtdPostRespuesta(res23, pre23, tallerr, id );
        int ress24 = respuesta.mtdPostRespuesta(res24, pre24, tallerr, id );
        int ress25 = respuesta.mtdPostRespuesta(res25, pre25, tallerr, id );
        int ress26 = respuesta.mtdPostRespuesta(res26, pre26, tallerr, id );
        int ress27 = respuesta.mtdPostRespuesta(res27, pre27, tallerr, id );
        int ress28 = respuesta.mtdPostRespuesta(res28, pre28, tallerr, id );
        int ress29 = respuesta.mtdPostRespuesta(res29, pre29, tallerr, id );
        int ress30 = respuesta.mtdPostRespuesta(res30, pre30, tallerr, id );
        int ress31 = respuesta.mtdPostRespuesta(res31, pre31, tallerr, id );

        if (ress == 1 && ress2 == 1 && ress3 == 1 && ress4 == 1 && ress5 == 1 && ress6 == 1 && ress7 == 1 && ress8 == 1 && ress9 == 1 && ress10 == 1 && ress11 == 1 && ress12 == 1 && ress13 == 1 && ress14 == 1 && ress15 == 1 && ress16 == 1 && ress17 == 1 && ress18 == 1 && ress19 == 1 && ress20 == 1 && ress21 == 1 && ress22 == 1 && ress23 == 1 && ress24 == 1 && ress25 == 1 && ress26 == 1 && ress27 == 1 && ress28 == 1 && ress29 == 1 && ress30 == 1 && ress31 == 1){
            return 1;
        }else {
            return 0;
        }

    }


    private void mtdCargarView() {

        txtres1 = (EditText)findViewById(R.id.txt2_1_ta3);
        txtres2 = (EditText)findViewById(R.id.txt2_2_ta3);
        txtres3 = (EditText)findViewById(R.id.txt2_3_ta3);
        txtres4 = (EditText)findViewById(R.id.txt2_4_ta3);
        txtres5 = (EditText)findViewById(R.id.txt2_5_ta3);
        txtres6 = (EditText)findViewById(R.id.txt2_6_ta3);
        txtres7 = (EditText)findViewById(R.id.txt2_7_ta3);
        txtres8 = (EditText)findViewById(R.id.txt2_8_ta3);

        txtres9 = (EditText)findViewById(R.id.txt3_1_ta3);
        txtres10 = (EditText)findViewById(R.id.txt3_2_ta3);
        txtres11 = (EditText)findViewById(R.id.txt3_3_ta3);

        txtres4_1_com = (EditText)findViewById(R.id.txtComple4_1_ta3);
        txtres4_3_seg = (EditText)findViewById(R.id.txtSegun4_2_ta3);
        txtres4_9_pri = (EditText)findViewById(R.id.txtPri4_3_ta3);
        txtres4_4_seg = (EditText)findViewById(R.id.txtSegun4_4_ta3);
        txtres4_2_com = (EditText)findViewById(R.id.txtComple4_5_ta3);
        txtres4_7_pri = (EditText)findViewById(R.id.txtPri4_6_ta3);
        txtres4_5_pri = (EditText)findViewById(R.id.txtPri4_7_ta3);
        txtres4_8_seg = (EditText)findViewById(R.id.txtSegun4_7_ta3);
        txtres4_6_seg = (EditText)findViewById(R.id.txtSegun4_10_ta3);
        txtres4_11_com = (EditText)findViewById(R.id.txtComple4_8_ta3);
        txtres4_10_com = (EditText)findViewById(R.id.txtComple4_11_ta3);

        txtres23 = (EditText)findViewById(R.id.txt7_ta3);
        txtres24 = (EditText)findViewById(R.id.txt8_ta3);
        txtres25 = (EditText)findViewById(R.id.txt9_ta3);
        txtres26 = (EditText)findViewById(R.id.txt10_1_1_ta3);
        txtres27 = (EditText)findViewById(R.id.txt10_1_2_ta3);
        txtres28 = (EditText)findViewById(R.id.txt10_1_3_ta3);
        txtres29 = (EditText)findViewById(R.id.txt10_2_1_ta3);
        txtres30 = (EditText)findViewById(R.id.txt10_2_2_ta3);
        txtres31 = (EditText)findViewById(R.id.txt10_2_3_ta3);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}