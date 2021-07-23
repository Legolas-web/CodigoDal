package com.example.dal.Controllador;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dal.Modelo.clRespuesta;
import com.example.dal.R;

import javax.mail.Session;

public class FormUsuarioNuevo extends AppCompatActivity {


    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    String datoAvatar, datoName, nameFullUser, idUser;

    Integer txtval20 = 0, txtval19 = 0, txtval18 = 0;

    private AnimationDrawable animationDrawable;
    private ScrollView layouScroll;

    RadioButton rbsi3, rbno3, rbsi7, rbno7, rbsi8, rbno8, rbsi9, rbno9, rbsi11, rbno11, rbsi12, rbno12, rbsi13, rbno13, rbsi14, rbno14, rb161, rb162, rb163, rb164, rb165, rb166;
    EditText txtEntrada, txtres4, txtres9, txtres10, txtres14, txtres17hc, txtres18, txtres19, txtres20;
    Spinner spn1, spn2, spn5, spn6, spn10,spn15, spn18, spn19, spn20;
    String res1, res2, res3, res4, res5, res6, res7, res8, res91, res92, res101, res102, res11, res12, res13, res141, res142, res15, res161, res172, res181, res182, res191, res192, res201, res202;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_usuario_nuevo);

        context = this;

        layouScroll = (ScrollView) findViewById(R.id.usuarioNuevo_act);

        animationDrawable = (AnimationDrawable) layouScroll.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        rbsi3 = (RadioButton) findViewById(R.id.rg_rb_si3);
        rbno3 = (RadioButton) findViewById(R.id.rg_rb_no3);
        rbsi7 = (RadioButton) findViewById(R.id.rg_rb_si7);
        rbno7 = (RadioButton) findViewById(R.id.rg_rb_si7);
        rbsi8 = (RadioButton) findViewById(R.id.rg_rb_si8);
        rbno8 = (RadioButton) findViewById(R.id.rg_rb_no8);
        rbsi9 = (RadioButton) findViewById(R.id.rg_rb_si9);
        rbno9 = (RadioButton) findViewById(R.id.rg_rb_no9);
        rbsi11 = (RadioButton) findViewById(R.id.rg_rb_si11);
        rbno11 = (RadioButton) findViewById(R.id.rg_rb_no11);
        rbsi12 = (RadioButton) findViewById(R.id.rg_rb_si12);
        rbno12 = (RadioButton) findViewById(R.id.rg_rb_si12);
        rbsi13 = (RadioButton) findViewById(R.id.rg_rb_si13);
        rbno13 = (RadioButton) findViewById(R.id.rg_rb_no13);
        rbsi14 = (RadioButton) findViewById(R.id.rg_rb_si14);
        rbno14 = (RadioButton) findViewById(R.id.rg_rb_no14);
        rb161 = (RadioButton) findViewById(R.id.rg_rb_16_1);
        rb162 = (RadioButton) findViewById(R.id.rg_rb_16_2);
        rb163 = (RadioButton) findViewById(R.id.rg_rb_16_3);
        rb164 = (RadioButton) findViewById(R.id.rg_rb_16_4);
        rb165 = (RadioButton) findViewById(R.id.rg_rb_16_5);
        rb166 = (RadioButton) findViewById(R.id.rg_rb_16_6);


        Button envia = (Button) findViewById(R.id.btn_submit);

        txtEntrada = (EditText) findViewById(R.id.txtEntradaP);
        spn1 = (Spinner) findViewById(R.id.SpinnerFeedbackType);
        spn2 = (Spinner) findViewById(R.id.SpinnerFeedbackType2);
        txtres4 = (EditText)findViewById(R.id.txt4);
        spn5 = (Spinner) findViewById(R.id.SpinnerFeedbackType5);
        spn6 = (Spinner) findViewById(R.id.SpinnerFeedbackType6);
        txtres9 = (EditText)findViewById(R.id.txt9);
        spn10 = (Spinner) findViewById(R.id.SpinnerFeedbackType10);
        txtres10 = (EditText)findViewById(R.id.txt10);
        txtres14 = (EditText)findViewById(R.id.txt14);
        spn15 = (Spinner) findViewById(R.id.SpinnerFeedbackType15);
        txtres17hc = (EditText)findViewById(R.id.txt172);
        spn18 = (Spinner) findViewById(R.id.SpinnerFeedbackType18);
        txtres18 = (EditText)findViewById(R.id.txt18);
        spn19 = (Spinner) findViewById(R.id.SpinnerFeedbackType19);
        txtres19 = (EditText)findViewById(R.id.txt19);
        spn20 = (Spinner) findViewById(R.id.SpinnerFeedbackType20);
        txtres20 = (EditText)findViewById(R.id.txt20);

        idUser = getIntent().getStringExtra("idUser");
        nameFullUser = getIntent().getStringExtra("NombreUser");
        datoAvatar = getIntent().getStringExtra("datoAvatar");
        datoName = getIntent().getStringExtra("datoNombre");

        txtEntrada.setText("¡HOLA! " + nameFullUser + " A continuación, te voy a hacer unas preguntas que me van a ayudar a conocer tus hábitos de lectura y de ese modo, juntos haremos que leer sea más agradable para ti. Por favor selecciona la respuesta a cada una de las preguntas y responda las casillas a rellenar sinceramente.");

        //Spinner Events--------------------------------------------------------------------------------------------------------------------------------------
        spn20.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 5){
                    txtres20.setVisibility(View.VISIBLE);
                    txtres20.setEnabled(true);
                    txtval20 = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spn19.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 5){
                    txtres19.setVisibility(View.VISIBLE);
                    txtres19.setEnabled(true);
                    txtval19 = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spn18.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 5){
                    txtres18.setVisibility(View.VISIBLE);
                    txtres18.setEnabled(true);
                    txtval18 = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mtdCargarDatos();

                int valida = validaForm();

                if (valida == 0){
                    clRespuesta respuesta = new clRespuesta();
                    int tallerr = 5;
                    int id = Integer.parseInt(idUser);


                    int resp = respuesta.mtdPostRespuesta(res1, "1", tallerr, id);
                    int resp2 = respuesta.mtdPostRespuesta(res2, "2", tallerr, id);
                    int resp3 = respuesta.mtdPostRespuesta(res3, "3", tallerr, id);
                    int resp4 = respuesta.mtdPostRespuesta(res4, "4", tallerr, id);
                    int resp5 = respuesta.mtdPostRespuesta(res5, "5", tallerr, id);
                    int resp6 = respuesta.mtdPostRespuesta(res6, "6", tallerr, id);
                    int resp7 = respuesta.mtdPostRespuesta(res7, "7", tallerr, id);
                    int resp8 = respuesta.mtdPostRespuesta(res8, "8", tallerr, id);
                    int resp9 = respuesta.mtdPostRespuesta(res91 + " " + res92, "9", tallerr, id);
                    int resp10 = respuesta.mtdPostRespuesta(res101 + " " + res102, "10", tallerr, id);
                    int resp11 = respuesta.mtdPostRespuesta(res11, "11", tallerr, id);
                    int resp12 = respuesta.mtdPostRespuesta(res12, "12", tallerr, id);
                    int resp13 = respuesta.mtdPostRespuesta(res13, "13", tallerr, id);
                    int resp14 = respuesta.mtdPostRespuesta(res141 + " " + res142, "14", tallerr, id);
                    int resp15 = respuesta.mtdPostRespuesta(res15, "15", tallerr, id);
                    int resp16 = respuesta.mtdPostRespuesta(res161, "16", tallerr, id);
                    int resp17 = respuesta.mtdPostRespuesta(res172, "17", tallerr, id);
                    int resp18 = respuesta.mtdPostRespuesta(res181 + " " + res182, "18", tallerr, id);
                    int resp19 = respuesta.mtdPostRespuesta(res191 + " " + res192, "19", tallerr, id);
                    int resp20 = respuesta.mtdPostRespuesta(res201 + " " + res202, "20", tallerr, id);

                    if (resp == 1 && resp2 == 1 && resp3 == 1 && resp4 == 1 && resp5 == 1 && resp6 == 1 && resp7 == 1 && resp8 == 1 && resp9 == 1 && resp10 == 1 && resp11 == 1 && resp12 == 1 && resp13 == 1 && resp14 == 1 && resp15 == 1 && resp16 == 1 && resp17 == 1 && resp18 == 1 && resp19 == 1 && resp20 == 1){
                        Toast.makeText(getApplicationContext(), "Todo listo...", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "Ya puedes disfrutar de DAL", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(FormUsuarioNuevo.this, Inicio.class);
                        intent.putExtra("idUser", idUser);
                        intent.putExtra("nameFull", nameFullUser);
                        intent.putExtra("datoNombre", datoName);
                        intent.putExtra("datoAvatar", datoAvatar);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Formulario incompleto", Toast.LENGTH_LONG).show();
                }


            }
        });

    }

    private void mtdCargarDatos() {

        //validaForm();
        res161 = "";
        if (rb161.isChecked()==true){
            res161 = "FALTA DE CONCENTRACION ";
        }
        if (rb162.isChecked()==true){
            res161 += " NO COMPRENDER EL VOCABULARIO";
        }
        if (rb163.isChecked()==true){
            res161 += " NO IDENTIFICAR EL TEMA DEL TEXTO";
        }
        if (rb164.isChecked()==true){
            res161 += " NO IDENTIFICAR LAS IDEAS PRINCIPALES O SECUNDARIAS";
        }
        if (rb165.isChecked()==true){
            res161 += " LA FALTA DE MOTIVACION";
        }
        if (rb166.isChecked()==true){
            res161 += " FALTA DE COMPRENSION DE ORTOGRAFIA Y PUNTUACION";
        }

        if (rbsi3.isChecked()==true){
            res3 = "SI";
        }else if (rbno3.isChecked()==true){
            res3 = "NO";
        }

        if (rbsi7.isChecked()==true){
            res7 = "SI";
        }else if (rbno7.isChecked()==true){
            res7 = "NO";
        }

        if (rbsi8.isChecked()==true){
            res8 = "SI";
        }else if (rbno8.isChecked()==true){
            res8 = "NO";
        }

        if (rbsi9.isChecked()==true){
            res91 = "SI";
        }else if (rbno9.isChecked()==true){
            res91 = "NO";
        }

        if (rbsi11.isChecked()==true){
            res11 = "SI";
        }else if (rbno11.isChecked()==true){
            res11 = "NO";
        }

        if (rbsi12.isChecked()==true){
            res12 = "SI";
        }else if (rbno12.isChecked()==true){
            res12 = "NO";
        }

        if (rbsi13.isChecked()==true){
            res13 = "SI";
        }else if (rbno13.isChecked()==true){
            res13 = "NO";
        }

        if (rbsi14.isChecked()==true){
            res141 = "SI";
        }else if (rbno14.isChecked()==true){
            res142 = "NO";
        }

        res1 = spn1.getSelectedItem().toString();
        res2 = spn2.getSelectedItem().toString();

        res4 = txtres4.getText().toString();
        res5 = spn5.getSelectedItem().toString();
        res6 = spn6.getSelectedItem().toString();


        res92 = txtres9.getText().toString();
        res101 = spn10.getSelectedItem().toString();
        res102 = txtres10.getText().toString();


        res142 = txtres14.getText().toString();
        res15 = spn15.getSelectedItem().toString();

        res172 = txtres17hc.getText().toString();
        res181 = spn18.getSelectedItem().toString();
        res182 = txtres18.getText().toString();
        res191 = spn19.getSelectedItem().toString();
        res192 = txtres19.getText().toString();
        res201 = spn20.getSelectedItem().toString();
        res202 = txtres20.getText().toString();
    }

    private Integer validaForm() {

        //valida cada RadioBoton para que no este vacio

        if (rbsi3.isChecked()==false && rbno3.isChecked()==false){
            Toast.makeText(getApplicationContext(), "Responda a la pregunta 3", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (rbsi7.isChecked()==false && rbno7.isChecked()==false){
            Toast.makeText(getApplicationContext(), "Responda a la pregunta 7", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (rbsi8.isChecked()==false && rbno8.isChecked()==false){
            Toast.makeText(getApplicationContext(), "Responda a la pregunta 8", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (rbsi9.isChecked()==false && rbno9.isChecked()==false){
            Toast.makeText(getApplicationContext(), "Responda a la pregunta 9", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (rbsi11.isChecked()==false && rbno11.isChecked()==false){
            Toast.makeText(getApplicationContext(), "Responda a la pregunta 11", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (rbsi12.isChecked()==false && rbno12.isChecked()==false){
            Toast.makeText(getApplicationContext(), "Responda a la pregunta 12", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (rbsi13.isChecked()==false && rbno13.isChecked()==false){
            Toast.makeText(getApplicationContext(), "Responda a la pregunta 13", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (rbsi14.isChecked()==false && rbno14.isChecked()==false){
            Toast.makeText(getApplicationContext(), "Responda a la pregunta 14", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (rb161.isChecked()==false && rb162.isChecked()==false && rb163.isChecked()==false && rb164.isChecked()==false && rb165.isChecked()==false && rb166.isChecked()==false){
            Toast.makeText(getApplicationContext(), "Responda a la pregunta 16", Toast.LENGTH_SHORT).show();
            return 1;
        }

        //valida los spinner para que no esten vacios

        if (spn1.getSelectedItem().toString() == "..."){
            Toast.makeText(getApplicationContext(), "Seleccione respuesta 1", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (spn2.getSelectedItem().toString() == "..."){
            Toast.makeText(getApplicationContext(), "Seleccione respuesta 2", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (spn5.getSelectedItem().toString() == "..."){
            Toast.makeText(getApplicationContext(), "Seleccione respuesta 5", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (spn6.getSelectedItem().toString() == "..."){
            Toast.makeText(getApplicationContext(), "Seleccione respuesta 6", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (spn10.getSelectedItem().toString() == "..."){
            Toast.makeText(getApplicationContext(), "Seleccione respuesta 10", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (spn15.getSelectedItem().toString() == "..."){
            Toast.makeText(getApplicationContext(), "Seleccione respuesta 15", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (spn18.getSelectedItem().toString() == "..."){
            Toast.makeText(getApplicationContext(), "Seleccione respuesta 18", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (spn19.getSelectedItem().toString() == "..."){
            Toast.makeText(getApplicationContext(), "Seleccione respuesta 19", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if (spn20.getSelectedItem().toString() == "..."){
            Toast.makeText(getApplicationContext(), "Seleccione respuesta 20", Toast.LENGTH_SHORT).show();
            return 1;
        }

        //valida lascajas de texto para que no esten vacias

        if(txtres4.getText().toString() == ""){
            Toast.makeText(getApplicationContext(), "Rellene la caja de texto de la pregunta 4", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if(txtres9.getText().toString() == ""){
            Toast.makeText(getApplicationContext(), "Rellene la caja de texto de la pregunta 9", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if(txtres10.getText().toString() == ""){
            Toast.makeText(getApplicationContext(), "Rellene la caja de texto de la pregunta 10", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if(txtres14.getText().toString() == ""){
            Toast.makeText(getApplicationContext(), "Rellene la caja de texto de la pregunta 14", Toast.LENGTH_SHORT).show();
            return 1;
        }
        if(txtres17hc.getText().toString() == ""){
            Toast.makeText(getApplicationContext(), "Rellene la caja de texto de la pregunta 17 HORAS EN EL CELULAR", Toast.LENGTH_SHORT).show();
            return 1;
        }
        return 0;

    }

}