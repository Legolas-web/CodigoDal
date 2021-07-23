package com.example.dal.Controllador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dal.Modelo.clRespuesta;
import com.example.dal.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ModuloPractico extends AppCompatActivity {

    private RelativeLayout layout;
    private Button btnGirar;
    private ImageView imgRuleta;
    private TextView txtIndicador;

    String resRadio1 = "";
    String resRadio2 = "";
    String resRadio3 = "";
    String resRadio4 = "";

    private AnimationDrawable animationDrawable;

    String[] sectors = {"01", "02", "03", "04", "05"};

    private static int TIME_OPEN = 1000;

    public String nombreHomeUser, numeroAvatarUser, idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_practico);

        layout = (RelativeLayout) findViewById(R.id.layoutPractico);
        btnGirar = (Button) findViewById(R.id.btnGirar);
        imgRuleta = (ImageView) findViewById(R.id.imgRuleta);
        txtIndicador = (TextView) findViewById(R.id.txtIndicador);

        Collections.reverse(Arrays.asList(sectors));


        //fondo animación
        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        btnGirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtdGirar();
            }
        });

        //--------------------------------------------------------------------------------------------------

        nombreHomeUser = getIntent().getStringExtra("datoNombre");
        numeroAvatarUser = getIntent().getStringExtra("datoAvatar");
        idUser = getIntent().getStringExtra("idUser");


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

                String pra = txtIndicador.getText().toString();

                if (pra == "01"){
                    LecturaUno();
                }
                if (pra == "02"){
                    LecturaDos();
                }
                if (pra == "03"){
                    LecturaTres();
                }
                if (pra == "04"){
                    ventanaModal4();
                }
                if (pra == "05"){
                    LecturaCinco();
                }


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imgRuleta.startAnimation(rotateAnimation);

    }

    private void LecturaCinco() {
        AlertDialog.Builder builder= new AlertDialog.Builder(ModuloPractico.this);
        LayoutInflater inflater = getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.emergente_taller_cinco_cuarto, null);

        builder.setView(view1);

        AlertDialog dialog = builder.create();
        dialog.show();

        TextView txtTitulo = (TextView)view1.findViewById(R.id.txtTituloPractica);
        TextView txtTexto = (TextView)view1.findViewById(R.id.txtTextoPractico);

        txtTitulo.setText("EL ENSAYO");
        txtTexto.setText(R.string.el_ensayo);

        Button envia = (Button)view1.findViewById(R.id.btnEnvia_ta4_5);

        RadioButton rbresa = (RadioButton)view1.findViewById(R.id.res1a_pa5_ta4);
        RadioButton rbresb = (RadioButton)view1.findViewById(R.id.res1b_pa5_ta4);
        RadioButton rbresc = (RadioButton)view1.findViewById(R.id.res1c_pa5_ta4);
        RadioButton rbresd = (RadioButton)view1.findViewById(R.id.res1d_pa5_ta4);


        envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rbresa.isChecked() == true){
                    resRadio1 = "a. El ensayo es una mezcla de disciplinas que hace parte de la escritura científica.";
                }
                if (rbresb.isChecked() == true){
                    resRadio1 = "b. El ensayo es un texto académico que pretende convencer al lector de la postura del autor.";
                }
                if (rbresc.isChecked() == true){
                    resRadio1 = "c. El ensayo e s un texto largo que pretende contar una historia que incluye personajes y un narrador.";
                }
                if (rbresd.isChecked() == true){
                    resRadio1 = "d. El ensayo es un texto de carácter crítico que pretende dar argumentos para defender una tesis. ";
                }

                clRespuesta respuesta = new clRespuesta();

                String pre1 = "pre1_pa5";

                int tall = 4;
                int id = Integer.parseInt(idUser);

                String resFinal = "EL_ENSAYO: " + resRadio1;

                int res = respuesta.mtdPostRespuesta(resFinal, pre1, tall, id );

                if (res == 1){
                    Toast.makeText(getApplicationContext(), "TALLER EL ENSAYO, ENVIADO", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ModuloPractico.this, ModuloPractico.class);
                    intent.putExtra("datoNombre", nombreHomeUser);
                    intent.putExtra("datoNombre", nombreHomeUser);
                    intent.putExtra("idUser", idUser);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }

    private void LecturaTres() {
        AlertDialog.Builder builder= new AlertDialog.Builder(ModuloPractico.this);
        LayoutInflater inflater = getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.emergente_taller_tres_cuarto, null);

        builder.setView(view1);

        AlertDialog dialog = builder.create();
        dialog.show();

        TextView txtTitulo = (TextView)view1.findViewById(R.id.txtTituloPractica);
        TextView txtTexto = (TextView)view1.findViewById(R.id.txtTextoPractico);

        txtTitulo.setText("LA LECTURA");
        txtTexto.setText(R.string.la_lectura);

        Button envia = (Button)view1.findViewById(R.id.btnEnvia_ta4_3);

        RadioButton rbresa = (RadioButton)view1.findViewById(R.id.res1a_pa3_ta4);
        RadioButton rbresb = (RadioButton)view1.findViewById(R.id.res1b_pa3_ta4);
        RadioButton rbresc = (RadioButton)view1.findViewById(R.id.res1c_pa3_ta4);
        RadioButton rbresd = (RadioButton)view1.findViewById(R.id.res1d_pa3_ta4);


        envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rbresa.isChecked() == true){
                    resRadio1 = "a. Explica la razón por la cual leer es importante.";
                }
                if (rbresb.isChecked() == true){
                    resRadio1 = "b. Ejemplifica las ideas que debe tener un lector.";
                }
                if (rbresc.isChecked() == true){
                    resRadio1 = "c. Demuestra la importancia de reconocer la lectura como una necesidad.";
                }
                if (rbresd.isChecked() == true){
                    resRadio1 = "d. Ilustra las condiciones para que la lectura sea fuente de conocimiento.";
                }

                clRespuesta respuesta = new clRespuesta();

                String pre1 = "pre1_pa3";

                int tall = 4;
                int id = Integer.parseInt(idUser);

                String resFinal = "LA_LECTURA: " + resRadio1;

                int res = respuesta.mtdPostRespuesta(resFinal, pre1, tall, id );

                if (res == 1){
                    Toast.makeText(getApplicationContext(), "TALLER LA LECTURA, ENVIADO", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ModuloPractico.this, ModuloPractico.class);
                    intent.putExtra("datoNombre", nombreHomeUser);
                    intent.putExtra("datoNombre", nombreHomeUser);
                    intent.putExtra("idUser", idUser);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }

    private void LecturaDos() {
        AlertDialog.Builder builder= new AlertDialog.Builder(ModuloPractico.this);
        LayoutInflater inflater = getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.emergente_taller_dos_cuarto, null);

        builder.setView(view1);

        AlertDialog dialog = builder.create();
        dialog.show();

        TextView txtTitulo = (TextView)view1.findViewById(R.id.txtTituloPractica);
        TextView txtTexto = (TextView)view1.findViewById(R.id.txtTextoPractico);

        txtTitulo.setText("AZORÍN Y UNAMUNO");
        txtTexto.setText(R.string.autores);

        Button envia = (Button)view1.findViewById(R.id.btnEnvia_ta4_2);

        RadioButton rbresa = (RadioButton)view1.findViewById(R.id.res1a_pa2_ta4);
        RadioButton rbresb = (RadioButton)view1.findViewById(R.id.res1b_pa2_ta4);
        RadioButton rbresc = (RadioButton)view1.findViewById(R.id.res1c_pa2_ta4);
        RadioButton rbresd = (RadioButton)view1.findViewById(R.id.res1d_pa2_ta4);

        RadioButton rbres2a = (RadioButton)view1.findViewById(R.id.rb_res2a_pa2);
        RadioButton rbres2b = (RadioButton)view1.findViewById(R.id.rb_res2b_pa2);
        RadioButton rbres2c = (RadioButton)view1.findViewById(R.id.rb_res2c_pa2);
        RadioButton rbres2d = (RadioButton)view1.findViewById(R.id.rb_res2d_pa2);



        if (rbresa.isChecked() == true){
            resRadio1 = "a. El constante desprecio que recibían los escritores de la época por parte de la comunidad.";
        }
        if (rbresb.isChecked() == true){
            resRadio1 = "b. El inconformismo ante las condiciones precarias de salud en España.";
        }
        if (rbresc.isChecked() == true){
            resRadio1 = "c. El desacuerdo con el maltrato a los campesinos.";
        }
        if (rbresd.isChecked() == true){
            resRadio1 = "d. La desconfianza que le generaban los políticos.";
        }
        if (rbres2a.isChecked() == true){
            resRadio2 = "a. Entusiasta y sentimental.";
        }
        if (rbres2b.isChecked() == true){
            resRadio2 = "b. Reflexivo y con angustias.";
        }
        if (rbres2c.isChecked() == true){
            resRadio2 = "c. Miedoso y pasivo.";
        }
        if (rbres2d.isChecked() == true){
            resRadio2 = "d. Seguro y fuerte.";
        }

        envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rbresa.isChecked() == true){
                    resRadio1 = "a. El constante desprecio que recibían los escritores de la época por parte de la comunidad.";
                }
                if (rbresb.isChecked() == true){
                    resRadio1 = "b. El inconformismo ante las condiciones precarias de salud en España.";
                }
                if (rbresc.isChecked() == true){
                    resRadio1 = "c. El desacuerdo con el maltrato a los campesinos.";
                }
                if (rbresd.isChecked() == true){
                    resRadio1 = "d. La desconfianza que le generaban los políticos.";
                }
                if (rbres2a.isChecked() == true){
                    resRadio2 = "a. Entusiasta y sentimental.";
                }
                if (rbres2b.isChecked() == true){
                    resRadio2 = "b. Reflexivo y con angustias.";
                }
                if (rbres2c.isChecked() == true){
                    resRadio2 = "c. Miedoso y pasivo.";
                }
                if (rbres2d.isChecked() == true){
                    resRadio2 = "d. Seguro y fuerte.";
                }

                clRespuesta respuesta = new clRespuesta();

                String pre1 = "pre1_pa2";
                String pre2 = "pre2_pa2";

                int tall = 4;
                int id = Integer.parseInt(idUser);

                String resFinal = "AZORÍN_Y_UNAMUNO: " + resRadio1;
                String resFinal2 = "AZORÍN_Y_UNAMUNO: " + resRadio2;

                int res = respuesta.mtdPostRespuesta(resFinal, pre1, tall, id );
                int res2 = respuesta.mtdPostRespuesta(resFinal2, pre2, tall, id);

                if (res == 1 && res2 == 1){
                    Toast.makeText(getApplicationContext(), "TALLER AZORÍN Y UNAMUNO, ENVIADO", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ModuloPractico.this, ModuloPractico.class);
                    intent.putExtra("datoNombre", nombreHomeUser);
                    intent.putExtra("datoNombre", nombreHomeUser);
                    intent.putExtra("idUser", idUser);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    public void ventanaModal4(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder builder= new AlertDialog.Builder(ModuloPractico.this);
                LayoutInflater inflater = getLayoutInflater();
                final View view1 = inflater.inflate(R.layout.emergente_taller_cuatro_cuatro, null);

                builder.setView(view1);

                AlertDialog dialog = builder.create();
                dialog.show();

                TextView txtTitulo = (TextView)view1.findViewById(R.id.txtTituloPractica);
                TextView txtTexto = (TextView)view1.findViewById(R.id.txtTextoPractico);

                Button envia = (Button)view1.findViewById(R.id.btnEnvia_ta4_4);

                txtTitulo.setText("DIMENSIONES DE LA LECTURA");
                txtTexto.setText(R.string.dimensiones_de_la_lectura);

                RadioButton rbresa = (RadioButton)view1.findViewById(R.id.rb_resa_pa4);
                RadioButton rbresb = (RadioButton)view1.findViewById(R.id.rb_resb_pa4);
                RadioButton rbresc = (RadioButton)view1.findViewById(R.id.rb_resc_pa4);
                RadioButton rbresd = (RadioButton)view1.findViewById(R.id.rb_resd_pa4);

                RadioButton rbres2a = (RadioButton)view1.findViewById(R.id.rb_res2a_pa4);
                RadioButton rbres2b = (RadioButton)view1.findViewById(R.id.rb_res2b_pa4);
                RadioButton rbres2c = (RadioButton)view1.findViewById(R.id.rb_res2c_pa4);
                RadioButton rbres2d = (RadioButton)view1.findViewById(R.id.rb_res2d_pa4);

                RadioButton rbres3a = (RadioButton)view1.findViewById(R.id.rb_res3a_pa4);
                RadioButton rbres3b = (RadioButton)view1.findViewById(R.id.rb_res3b_pa4);
                RadioButton rbres3c = (RadioButton)view1.findViewById(R.id.rb_res3c_pa4);
                RadioButton rbres3d = (RadioButton)view1.findViewById(R.id.rb_res3d_pa4);

                RadioButton rbres4a = (RadioButton)view1.findViewById(R.id.rb_res4a_pa4);
                RadioButton rbres4b = (RadioButton)view1.findViewById(R.id.rb_res4b_pa4);
                RadioButton rbres4c = (RadioButton)view1.findViewById(R.id.rb_res4c_pa4);
                RadioButton rbres4d = (RadioButton)view1.findViewById(R.id.rb_res4d_pa4);



                envia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (rbresa.isChecked() == true){
                            resRadio1 = "a. Una serie de recursos a los cuales acude el lector para comprender un texto.";
                        }
                        if (rbresb.isChecked() == true){
                            resRadio1 = "b. Las partes que debe tener un texto para que el lector pueda comprenderlo.";
                        }
                        if (rbresc.isChecked() == true){
                            resRadio1 = "c. Las características del proceso lector.";
                        }
                        if (rbresd.isChecked() == true){
                            resRadio1 = "d. Los niveles básicos para conseguir la comprensión lectora.";
                        }

                        if (rbres2a.isChecked() == true){
                            resRadio2 = "a. Reconocer una frase que tiene doble sentido";
                        }
                        if (rbres2b.isChecked() == true){
                            resRadio2 = "b. Identificar cuál es la idea principal del texto.";
                        }
                        if (rbres2c.isChecked() == true){
                            resRadio2 = "c. Dar su opinión acerca del texto.";
                        }
                        if (rbres2d.isChecked() == true){
                            resRadio2 = "d. Saber cuál era la intensión del autor al escribir el texto.";
                        }

                        if (rbres3a.isChecked() == true){
                            resRadio3 = "a. Reconocer una frase que tiene doble sentido.";
                        }
                        if (rbres3b.isChecked() == true){
                            resRadio3 = "b. Identificar cuál es la idea principal del texto.";
                        }
                        if (rbres3c.isChecked() == true){
                            resRadio3 = "c. Dar su opinión acerca del texto.";
                        }
                        if (rbres3d.isChecked() == true){
                            resRadio3 = "d. Todas las anteriores.";
                        }

                        if (rbres4a.isChecked() == true){
                            resRadio4 = "a. Reconocer una frase que tiene doble sentido.";
                        }
                        if (rbres4b.isChecked() == true){
                            resRadio4 = "b. Identificar cuál es la idea principal del texto.";
                        }
                        if (rbres4c.isChecked() == true){
                            resRadio4 = "c. Dar su opinión acerca del texto.";
                        }
                        if (rbres4d.isChecked() == true){
                            resRadio4= "d. Saber cuál era la intensión del autor al escribir el texto.";
                        }

                        clRespuesta respuesta = new clRespuesta();

                        String pre1 = "pre1_pa4";
                        String pre2 = "pre2_pa4";
                        String pre3 = "pre3_pa4";
                        String pre4 = "pre4_pa4";

                        int tall = 4;
                        int id = Integer.parseInt(idUser);

                        String resFinal = "DIMENSIONES_DE_LA_LECTURA: " + resRadio1;
                        String resFinal2 = "DIMENSIONES_DE_LA_LECTURA: " + resRadio2;
                        String resFinal3 = "DIMENSIONES_DE_LA_LECTURA: " + resRadio3;
                        String resFinal4= "DIMENSIONES_DE_LA_LECTURA: " + resRadio4;

                        int res = respuesta.mtdPostRespuesta(resFinal, pre1, tall, id );
                        int res2 = respuesta.mtdPostRespuesta(resFinal2, pre2, tall, id);
                        int res3 = respuesta.mtdPostRespuesta(resFinal3, pre3, tall, id );
                        int res4 = respuesta.mtdPostRespuesta(resFinal4, pre4, tall, id );

                        if (res == 1 && res2 == 1 && res3 == 1 && res4 == 1){
                            Toast.makeText(getApplicationContext(), "TALLER DIMENSIONES DE LA LECTURA, ENVIADO", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ModuloPractico.this, ModuloPractico.class);
                            intent.putExtra("datoNombre", nombreHomeUser);
                            intent.putExtra("datoNombre", nombreHomeUser);
                            intent.putExtra("idUser", idUser);
                            startActivity(intent);
                            finish();
                        }

                    }
                });

            }
        }, TIME_OPEN);

    }

    private void LecturaUno() {

        AlertDialog.Builder builder= new AlertDialog.Builder(ModuloPractico.this);
        LayoutInflater inflater = getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.emergente_taller_uno_cuarto, null);

        builder.setView(view1);

        AlertDialog dialog = builder.create();
        dialog.show();

        TextView txtTitulo = (TextView)view1.findViewById(R.id.txtTituloPractica);
        TextView txtTexto = (TextView)view1.findViewById(R.id.txtTextoPractico);

        txtTitulo.setText("LA GENERACIÓN DEL 98");
        txtTexto.setText(R.string.la_generacion_del_98);

        Button envia = (Button)view1.findViewById(R.id.btnEnvia_ta4_1);

        RadioButton rbresa = (RadioButton)view1.findViewById(R.id.rb_resa);
        RadioButton rbresb = (RadioButton)view1.findViewById(R.id.rb_resb);
        RadioButton rbresc = (RadioButton)view1.findViewById(R.id.rb_resc);
        RadioButton rbresd = (RadioButton)view1.findViewById(R.id.rb_resd);

        RadioButton rbres2a = (RadioButton)view1.findViewById(R.id.rb_res2a);
        RadioButton rbres2b = (RadioButton)view1.findViewById(R.id.rb_res2b);
        RadioButton rbres2c = (RadioButton)view1.findViewById(R.id.rb_res2c);
        RadioButton rbres2d = (RadioButton)view1.findViewById(R.id.rb_res2d);

        RadioButton rbres3a = (RadioButton)view1.findViewById(R.id.rb_res3a);
        RadioButton rbres3b = (RadioButton)view1.findViewById(R.id.rb_res3b);
        RadioButton rbres3c = (RadioButton)view1.findViewById(R.id.rb_res3c);
        RadioButton rbres3d = (RadioButton)view1.findViewById(R.id.rb_res3d);


        envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rbresa.isChecked() == true){
                    resRadio1 = "a. La generación del 98 nació como una celebración al gran momento histórico que estaba atravesando España.";
                }
                if (rbresb.isChecked() == true){
                    resRadio1 = "b. La generación del 98 pretendía crear un movimiento social con el fin de recuperar el poder en Cuba, Puerto Rico y Filipinas.";
                }
                if (rbresc.isChecked() == true){
                    resRadio1 = "c. El nacimiento de La generación de 98 se dio como una estrategia del gobierno para que la población española no entrara en pánico durante la crisis.";
                }
                if (rbresd.isChecked() == true){
                    resRadio1 = "d. La generación del 98 surgió a través de la literatura como una manera revolucionaria de demostrar la inconformidad de algunos pensadores.";
                }

                if (rbres2a.isChecked() == true){
                    resRadio2 = "a. Aparentemente el país se encontraba muy estable, pero en realidad estaba sufriendo una crisis de carácter político, social y económico.";
                }
                if (rbres2b.isChecked() == true){
                    resRadio2 = "b. La generación del 98 pretendía crear un movimiento social con el fin de recuperar el poder en Cuba, Puerto Rico y Filipinas.";
                }
                if (rbres2c.isChecked() == true){
                    resRadio2 = "c. El nacimiento de La generación de 98 se dio como una estrategia del gobierno para que la población española no entrara en pánico durante la crisis.";
                }
                if (rbres2d.isChecked() == true){
                    resRadio2 = "d. La generación del 98 surgió a través de la literatura como una manera revolucionaria de demostrar la inconformidad de algunos pensadores.";
                }

                if (rbres3a.isChecked() == true){
                    resRadio3 = "a. Necesitaban despistar al enemigo.";
                }
                if (rbres3b.isChecked() == true){
                    resRadio3 = "b. Pretendían que sus textos fueran muy claros para que todas las personas los comprendieran.";
                }
                if (rbres3c.isChecked() == true){
                    resRadio3 = "c. No estaban suficientemente educados para usar un léxico más complicado y formal.";
                }
                if (rbres3d.isChecked() == true){
                    resRadio3 = "d. Debían utilizar muy poco papel ya que por la situación del país debían ahorrar.";
                }

                clRespuesta respuesta = new clRespuesta();

                String pre1 = "pre1_pa1";
                String pre2 = "pre2_pa1";
                String pre3 = "pre3_pa1";

                int tall = 4;
                int id = Integer.parseInt(idUser);

                String resFinal = "LA_GENERACIÓN_DEL_98: " + resRadio1;
                String resFinal2 = "LA_GENERACIÓN_DEL_98: " + resRadio2;
                String resFinal3 = "LA_GENERACIÓN_DEL_98: " + resRadio3;

                int res = respuesta.mtdPostRespuesta(resFinal, pre1, tall, id );
                int res2 = respuesta.mtdPostRespuesta(resFinal2, pre2, tall, id);
                int res3 = respuesta.mtdPostRespuesta(resFinal3, pre3, tall, id );

                if (res == 1 && res2 == 1 && res3 == 1){
                    Toast.makeText(getApplicationContext(), "TALLER LA GENERACIÓN DEL 98, ENVIADO", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ModuloPractico.this, ModuloPractico.class);
                    intent.putExtra("datoNombre", nombreHomeUser);
                    intent.putExtra("datoNombre", nombreHomeUser);
                    intent.putExtra("idUser", idUser);
                    startActivity(intent);
                    finish();
                }

            }
        });


    }

    private void CalculatePoint(int degree) {
        int initialPoint = 0;
        int endPoint = 72;
        int i = 0;

        String res = null;

        do {
            if (degree > initialPoint && degree < endPoint){
                res = sectors[i];
            }
            initialPoint += 72;
            endPoint += 72;
            i++;
        }while (res == null);

        txtIndicador.setText(res);
    }

    @Override
    public void onBackPressed() {
        //ventanaModalSalir();
        super.onBackPressed();
        finish();
    }

}