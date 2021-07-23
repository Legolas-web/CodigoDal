package com.example.dal.Controllador;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dal.Modelo.JsonPlaceHolderApi;
import com.example.dal.Modelo.clUsuario;
import com.example.dal.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class formRegistrarUsuario extends AppCompatActivity {

    private ScrollView layout;
    private AnimationDrawable animationDrawable;

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    private String ESTADO = "ACTIVO";

    Integer avatar;


    CardView cardAnonimo, cardAmaDeCasa, cardArana, cardAstronauta, cardAuriculares, cardBestia, cardCaballero, cardPrincipe, cardCaperucitaRoja, cardContinuar, cardDuende, cardEnano, cardEspantaPajaros, cardEstudiante, cardExtraterrestre, cardFantasma, cardGerente, cardHacker, cardHada, cardIncognito, cardInsecto, cardJudio, cardLadron, cardMujer, cardMurcielago, cardNativo, cardNinja, cardPlayer, cardPolicia, cardPricesa, cradPrincipe, cardPrisionero, cardRealidadAumentada, cardSospechar, cardTiroles, cardTirolesHombre, cardVampiro;

    Button cancelar;

    EditText nombreCompleto, usuario, contrasena1, contrasena2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_form_registrar_usuario);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        layout = findViewById(R.id.layoutFormUsuario);

        cancelar = (Button)findViewById(R.id.btnRegistrarUsu);

        nombreCompleto = (EditText)findViewById(R.id.txtNombreUsuario);
        usuario = (EditText)findViewById(R.id.txtNombreUser);
        contrasena1 = (EditText) findViewById(R.id.txtContrasena);
        contrasena2 = (EditText) findViewById(R.id.txtRepContrasena);

        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        activarCrads();
        viewActionCards();

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(formRegistrarUsuario.this, InicioSesion.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void mostrarVentanaModal(String nombreAvatar, final Integer avat){
        AlertDialog.Builder builder= new AlertDialog.Builder(formRegistrarUsuario.this);
        LayoutInflater inflater = getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.emergente_registrar_usuarios, null);

        builder.setView(view1);

        AlertDialog dialog = builder.create();
        dialog.show();

        Button btnConfirmarRegistro = (Button)view1.findViewById(R.id.btnRegistrarConfirmar);
        ImageView img = (ImageView)view1.findViewById(R.id.ivImg);
        TextView labelUusrio = (TextView)view1.findViewById(R.id.lblUsuario);
        TextView labelAvatar = (TextView)view1.findViewById(R.id.lblAvatar);

        labelUusrio.setText(usuario.getText());
        labelAvatar.setText("Alias: "+nombreAvatar);
        img.setImageResource(avat);

        btnConfirmarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = usuario.getText().toString();
                String contra = contrasena1.getText().toString();
                String nomCom = nombreCompleto.getText().toString();

                Call<List<clUsuario>> call =jsonPlaceHolderApi.getLoginUser(nom);

                call.enqueue(new Callback<List<clUsuario>>() {
                    @Override
                    public void onResponse(Call<List<clUsuario>> call, Response<List<clUsuario>> response) {

                        if (!response.isSuccessful()){
                            return;
                        }

                        List<clUsuario> user = response.body();

                        if (user.isEmpty() == true){

                            /*
                            Intent intent1 = new Intent(formRegistrarUsuario.this, PruebaCorreo.class);
                            intent1.putExtra("username", nom);
                            intent1.putExtra("namefull", nomCom);
                            intent1.putExtra("pass", contra);
                            intent1.putExtra("avat", avat.toString());
                            startActivity(intent1);
                            finish();

                             */

                            clUsuario classUser = new clUsuario();

                            int resVal = classUser.mtdPostUsuario(nom, nomCom, contra, ESTADO, avat);

                            if (resVal == 1){
                                Toast.makeText(getApplicationContext(), "Exitoso", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(formRegistrarUsuario.this, InicioSesion.class);
                                startActivity(intent);
                                finish();
                            }else {
                                Toast.makeText(getApplicationContext(), "Error, intentelo de nuevo", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(formRegistrarUsuario.this, formRegistrarUsuario.class);
                                startActivity(intent);
                                finish();
                            }


                        }else {
                            Toast.makeText(getApplicationContext(), "Usuario ya registrado en la BD", Toast.LENGTH_LONG).show();
                            Toast.makeText(getApplicationContext(), "Ingrese otro nombre de usuario", Toast.LENGTH_LONG).show();
                            return;
                        }

                    }

                    @Override
                    public void onFailure(Call<List<clUsuario>> call, Throwable t) {

                    }
                });



            }
        });

    }

    /**
     * Called when the activity has detected the user's press of the back
     * key. The {@link #getOnBackPressedDispatcher() OnBackPressedDispatcher} will be given a
     * chance to handle the back button before the default behavior of
     * {@link Activity#onBackPressed()} is invoked.
     *
     * @see #getOnBackPressedDispatcher()
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void activarCrads(){
        cardAnonimo = (CardView)findViewById(R.id.imgAnonimo);
        cardAmaDeCasa = (CardView)findViewById(R.id.imgAmaDeCasa);
        cardArana = (CardView)findViewById(R.id.imgArana);
        cardAstronauta = (CardView)findViewById(R.id.imgAstronauta);
        cardAuriculares = (CardView)findViewById(R.id.imgAuriculares);
        cardBestia = (CardView)findViewById(R.id.imgBestia);
        cardCaballero = (CardView)findViewById(R.id.imgCaballero);
        cardCaperucitaRoja= (CardView)findViewById(R.id.imgCaperucita);
        cardContinuar = (CardView)findViewById(R.id.imgContinuar);
        cardDuende = (CardView)findViewById(R.id.imgDuende);
        cardEnano = (CardView)findViewById(R.id.imgEnano);
        cardEspantaPajaros = (CardView)findViewById(R.id.imgEspantapajaros);
        cardEstudiante = (CardView)findViewById(R.id.imgEstudiante);
        cardExtraterrestre = (CardView)findViewById(R.id.imgExtraterrestre);
        cardFantasma = (CardView)findViewById(R.id.imgFantasma);
        cardGerente = (CardView)findViewById(R.id.imgGerente);
        cardHacker = (CardView)findViewById(R.id.imgHacker);
        cardHada = (CardView)findViewById(R.id.imgHada);
        cardIncognito = (CardView)findViewById(R.id.imgIncognito);
        cardInsecto = (CardView)findViewById(R.id.imgInsecto);
        cardJudio = (CardView)findViewById(R.id.imgJudio);
        cardLadron = (CardView)findViewById(R.id.imgLadron);
        cardMujer = (CardView)findViewById(R.id.imgMujer);
        cardMurcielago = (CardView)findViewById(R.id.imgMurcielago);
        cardNativo = (CardView)findViewById(R.id.imgNativo);
        cardNinja = (CardView)findViewById(R.id.imgNinja);
        cardPlayer = (CardView)findViewById(R.id.imgPlayer);
        cardPolicia = (CardView)findViewById(R.id.imgPolicia);
        cardPricesa = (CardView)findViewById(R.id.imgPrincesa);
        cardPrincipe = (CardView)findViewById(R.id.imgPrincipe);
        cardPrisionero = (CardView)findViewById(R.id.imgPrisionero);
        cardRealidadAumentada = (CardView)findViewById(R.id.imgRealidad_Aumentada);
        cardSospechar = (CardView)findViewById(R.id.imgSospechar);
        cardTiroles = (CardView)findViewById(R.id.imgTiroles);
        cardTirolesHombre = (CardView)findViewById(R.id.imgTirolesHombre);
        cardVampiro = (CardView)findViewById(R.id.imgVampiro);
    }

    public void mtdCarga(String nombreAvatar, Integer avat){

        String Usuario = usuario.getText().toString();
        String Contrasena = contrasena1.getText().toString();
        String Contrasena2 = contrasena2.getText().toString();
        String NombreCom = nombreCompleto.getText().toString();
        if (Usuario.length() == 0 || Contrasena.length() == 0 || Contrasena2.length() == 0 || NombreCom.length() == 0){
            Toast.makeText(getApplicationContext(), "DATOS BASIOS EN EL FORMULARIO", Toast.LENGTH_LONG).show();
        }else if(Contrasena.length() != Contrasena2.length()){
            Toast.makeText(getApplicationContext(), "LAS CONTRASEÑAS NO COINCIDEN", Toast.LENGTH_LONG).show();
        }else {
            mostrarVentanaModal(nombreAvatar, avat);
        }
    }

    private void viewActionCards() {

        cardAnonimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Anonimo";
                avatar = R.drawable.anonimo;
                mtdCarga(nombreAvatar, avatar);
            }
        });

        cardAmaDeCasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Sonia";
                avatar = R.drawable.ama_de_casa;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardArana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Omi";
                avatar = R.drawable.arana;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardAstronauta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Strongg";
                avatar = R.drawable.astronauta;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardAuriculares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Stick";
                avatar = R.drawable.auriculares;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardBestia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Leonidas";
                avatar = R.drawable.bestia;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardCaballero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Aquiles";
                avatar = R.drawable.caballero;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardCaperucitaRoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Caperucita";
                avatar = R.drawable.caperucita_roja;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Torin";
                avatar = R.drawable.continuar;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardDuende.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Mondry";
                avatar = R.drawable.duende;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardEnano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Eenngg";
                avatar = R.drawable.enano;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardEspantaPajaros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Saaw";
                avatar = R.drawable.espantapajaros;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Sammy";
                avatar = R.drawable.estudiante;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardExtraterrestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Root";
                avatar = R.drawable.extraterrestre;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardFantasma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Smit";
                avatar = R.drawable.fantasma;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardGerente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Max";
                avatar = R.drawable.gerente;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardHacker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Miste";
                avatar = R.drawable.hacker;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardHada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Spirita";
                avatar = R.drawable.hada;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardIncognito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Mizu";
                avatar = R.drawable.incognito;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardInsecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Drump";
                avatar = R.drawable.insecto;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardJudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Salomondri";
                avatar = R.drawable.judio;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardLadron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Lukas";
                avatar = R.drawable.ladron;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardMujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Maria";
                avatar = R.drawable.mujer;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardMurcielago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Sott";
                avatar = R.drawable.murcielago;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardNinja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Ricke";
                avatar = R.drawable.ninja;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Tato";
                avatar = R.drawable.player;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardPolicia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Sheri";
                avatar = R.drawable.policia;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardPricesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Hullian";
                avatar = R.drawable.princesa;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardPrincipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Arturo";
                avatar = R.drawable.principe;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardPrisionero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Sornn";
                avatar = R.drawable.prisionero;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardRealidadAumentada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Mononoke";
                avatar = R.drawable.realidad_aumentada;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardSospechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Maik";
                avatar = R.drawable.sospechar;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardTiroles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Satt";
                avatar = R.drawable.tiroles;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardTirolesHombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Mammuu";
                avatar = R.drawable.tiroleshombre;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardVampiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Vamp";
                avatar = R.drawable.vampiro;
                mtdCarga(nombreAvatar, avatar);
            }
        });
        cardNativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreAvatar = "Ita";
                avatar = R.drawable.nativo;
                mtdCarga(nombreAvatar, avatar);
            }
        });

    }



}
