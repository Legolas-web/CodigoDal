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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

public class AdminUsuario extends AppCompatActivity {

    private String idUser, nombreUser, avatarUser;
    private String idEntra = "", nombreEntra = "", NombreFullEntra = "", passwordEntra = "", avatarEntra = "";
    private RelativeLayout layout;
    private AnimationDrawable animationDrawable;
    private EditText txtname, txtnamefull, txtpassword, txtconfirmapass;
    private ImageView imgAvat;
    private TextView nameAvat;
    private Button btnActualizar;
    private int avatarr = 0;

    private JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_usuario);

        layout = (RelativeLayout) findViewById(R.id.LayoutAdmin);
        txtname = (EditText) findViewById(R.id.txtNameAdminUser);
        txtnamefull = (EditText) findViewById(R.id.txtNameFullAdminUser);
        txtpassword = (EditText) findViewById(R.id.txtPasswordAdminUser);
        txtconfirmapass = (EditText) findViewById(R.id.txtConfirmaPasswordAdminUser);
        imgAvat = (ImageView) findViewById(R.id.imgAdminUser);
        nameAvat = (TextView) findViewById(R.id.lblNombreAvatar);
        btnActualizar = (Button) findViewById(R.id.buttonActualizaUser);

        //RECIBE DATOS DE INICIOSESION----------------------------------------------------------------------------------

        idUser = getIntent().getStringExtra("id");
        nombreUser = getIntent().getStringExtra("nombre");
        avatarUser = getIntent().getStringExtra("avatar");

        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        mtdTomaDatos(nombreUser);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String contra1 = txtpassword.getText().toString(), contra2 = txtconfirmapass.getText().toString();

                if (contra1.length() == contra2.length()){
                    mtdPutUser();
                }else {
                    txtconfirmapass.setText("");
                }

            }
        });


    }

    private void mtdPutUser() {

        int ava = Integer.parseInt(avatarUser);
        int idInt = Integer.parseInt(idUser);
        clUsuario user = new clUsuario(txtname.getText().toString(), txtnamefull.getText().toString(), txtpassword.getText().toString(), "ACTIVO", ava);

        Call<Void> call = jsonPlaceHolderApi.PutUsuario(idInt, user);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Intent intent = new Intent(AdminUsuario.this, InicioSesion.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }

    private void mtdTomaDatos(String name) {
        Call<List<clUsuario>> call = jsonPlaceHolderApi.getLoginUser(name);

        call.enqueue(new Callback<List<clUsuario>>() {
            @Override
            public void onResponse(Call<List<clUsuario>> call, Response<List<clUsuario>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Codigo: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                List<clUsuario> user = response.body();

                if (user.isEmpty() == true){
                    Toast.makeText(getApplicationContext(), "Usuario no encontrado", Toast.LENGTH_LONG).show();
                    return;
                }

                for (clUsuario usuario : user){

                    idEntra += usuario.getIdUsuario();
                    nombreEntra += usuario.getNombre();
                    NombreFullEntra += usuario.getNombreCompleto();
                    avatarEntra += usuario.getAvatar();
                    passwordEntra += usuario.getContrasena();

                    avatarr = Integer.parseInt(avatarEntra);
                    txtname.setText(nombreEntra);
                    txtnamefull.setText(NombreFullEntra);
                    txtpassword.setText(passwordEntra);
                    imgAvat.setImageResource(avatarr);

                    mtdPutNameInCard();


                }

            }

            @Override
            public void onFailure(Call<List<clUsuario>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void mtdPutNameInCard() {
        if(avatarr == R.drawable.anonimo){
            nameAvat.setText("Mental");
        }
        if(avatarr == R.drawable.hacker){
            nameAvat.setText("Miste");
        }
        if(avatarr == R.drawable.arana){
            nameAvat.setText("Omi");
        }
        if(avatarr == R.drawable.ama_de_casa){
            nameAvat.setText("Sonia");
        }
        if(avatarr == R.drawable.astronauta){
            nameAvat.setText("Strongg");
        }
        if(avatarr == R.drawable.auriculares){
            nameAvat.setText("Stick");
        }
        if(avatarr == R.drawable.bestia){
            nameAvat.setText("Leonidas");
        }
        if(avatarr == R.drawable.caballero){
            nameAvat.setText("Aquiles");
        }
        if(avatarr == R.drawable.caperucita_roja){
            nameAvat.setText("Caperucita");
        }
        if(avatarr == R.drawable.continuar){
            nameAvat.setText("Torin");
        }
        if(avatarr == R.drawable.duende){
            nameAvat.setText("Mondry");
        }
        if(avatarr == R.drawable.enano){
            nameAvat.setText("Eenngg");
        }
        if(avatarr == R.drawable.espantapajaros){
            nameAvat.setText("Saaw");
        }
        if(avatarr == R.drawable.estudiante){
            nameAvat.setText("Sammy");
        }
        if(avatarr == R.drawable.extraterrestre){
            nameAvat.setText("Root");
        }
        if(avatarr == R.drawable.fantasma){
            nameAvat.setText("Smilt");
        }
        if(avatarr == R.drawable.gerente){
            nameAvat.setText("Max");
        }
        if(avatarr == R.drawable.hada){
            nameAvat.setText("Spirita");
        }
        if(avatarr == R.drawable.incognito){
            nameAvat.setText("Mizu");
        }
        if(avatarr == R.drawable.insecto){
            nameAvat.setText("Drump");
        }
        if(avatarr == R.drawable.judio){
            nameAvat.setText("Salomondri");
        }
        if(avatarr == R.drawable.ladron){
            nameAvat.setText("Lukas");
        }
        if(avatarr == R.drawable.mujer){
            nameAvat.setText("Maria");
        }
        if(avatarr == R.drawable.murcielago){
            nameAvat.setText("Sott");
        }
        if(avatarr == R.drawable.ninja){
            nameAvat.setText("Ricke");
        }
        if(avatarr == R.drawable.player){
            nameAvat.setText("Tato");
        }
        if(avatarr == R.drawable.policia){
            nameAvat.setText("Sheri");
        }
        if(avatarr == R.drawable.princesa){
            nameAvat.setText("Hullian");
        }
        if(avatarr == R.drawable.principe){
            nameAvat.setText("Arturo");
        }
        if(avatarr == R.drawable.prisionero){
            nameAvat.setText("Sornn");
        }
        if(avatarr == R.drawable.realidad_aumentada){
            nameAvat.setText("Mononoke");
        }
        if(avatarr == R.drawable.sospechar){
            nameAvat.setText("Maik");
        }
        if(avatarr == R.drawable.tiroles){
            nameAvat.setText("Satt");
        }
        if(avatarr == R.drawable.tiroleshombre){
            nameAvat.setText("Mamuu");
        }
        if(avatarr == R.drawable.vampiro){
            nameAvat.setText("Vamp");
        }
        if(avatarr == R.drawable.nativo){
            nameAvat.setText("Ita");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}