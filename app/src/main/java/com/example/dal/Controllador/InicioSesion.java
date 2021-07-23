package com.example.dal.Controllador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dal.Modelo.JsonPlaceHolderApi;
import com.example.dal.Modelo.clUsuario;
import com.example.dal.R;

import java.util.IllegalFormatCodePointException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InicioSesion extends AppCompatActivity {

    private RelativeLayout layout;
    private AnimationDrawable animationDrawable;

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    EditText usario, contrasena;
    TextView dal, registrase;
    Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inicio_sesion);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        layout = (RelativeLayout) findViewById(R.id.layoutLogin);
        usario = (EditText)findViewById(R.id.txtUsuario);
        contrasena = (EditText)findViewById(R.id.txtContrasena);
        dal = (TextView)findViewById(R.id.lblDAL);
        registrase = (TextView)findViewById(R.id.lblRegistrar);
        ingresar = (Button)findViewById(R.id.button);

        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        registrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InicioSesion.this, formRegistrarUsuario.class);
                startActivity(intent);
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = usario.getText().toString();
                String contra = contrasena.getText().toString();

                if (usario.getText().length() == 0){
                    Toast.makeText(getApplicationContext(), "Escriba el Nombre de usuario", Toast.LENGTH_LONG).show();
                }else if (contrasena.getText().length() == 0){
                    Toast.makeText(getApplicationContext(), "Escriba la Contraseña", Toast.LENGTH_LONG).show();
                }else if (name.equals("ADMIN") && contra.equals("TURUS")) {
                    mtdActualizarUsers();
                    Intent intent = new Intent(InicioSesion.this, AdminTurus.class);
                    startActivity(intent);
                    usario.setText("");
                    contrasena.setText("");
                }else {
                    mtdLoginName();
                }


            }
        });

    }

    private void mtdLoginName() {
        String name = usario.getText().toString();

        Call<List<clUsuario>> call =jsonPlaceHolderApi.getLoginUser(name);

        call.enqueue(new Callback<List<clUsuario>>() {
            @Override
            public void onResponse(Call<List<clUsuario>> call, Response<List<clUsuario>> response) {
                if (!response.isSuccessful()){
                    contrasena.setText("code: " + response.code());
                    return;
                }

                List<clUsuario> user = response.body();

                if (user.isEmpty() == true){
                    Toast.makeText(getApplicationContext(), "Usuario no encontrado", Toast.LENGTH_LONG).show();
                    contrasena.setText("");
                    usario.setText("");
                    return;
                }

                String content = "";
                String NombreLogueo = "";
                String NombreFullLogueo = "";
                String ContraLogueo = "";
                String AvatarLogueo = "";

                for (clUsuario usuario : user){

                    content += usuario.getIdUsuario();
                    NombreLogueo += usuario.getNombre();
                    NombreFullLogueo += usuario.getNombreCompleto();
                    AvatarLogueo += usuario.getAvatar();
                    ContraLogueo += usuario.getContrasena();

                }

                if (content == ""){
                    Toast.makeText(getApplicationContext(), "Usuario no encontrado", Toast.LENGTH_LONG).show();
                    usario.setText("");
                }else {

                    String contPrueba = contrasena.getText().toString();

                    if (contPrueba.equals(ContraLogueo)){
                        Intent intent = new Intent(InicioSesion.this, Inicio.class);
                        intent.putExtra("datoNombre", NombreLogueo);
                        intent.putExtra("datoAvatar", AvatarLogueo);
                        intent.putExtra("nameFull", NombreFullLogueo);
                        intent.putExtra("idUser", content);
                        startActivity(intent);
                        usario.setText("");
                        contrasena.setText("");
                    }else {
                        Toast.makeText(getApplicationContext(), "La Contraseña es incorrecta", Toast.LENGTH_LONG).show();
                        contrasena.setText("");
                    }

                }

            }

            @Override
            public void onFailure(Call<List<clUsuario>> call, Throwable t) {
                contrasena.setText(t.getMessage());
            }
        });

    }

    public void mtdActualizarUsers(){

        Call<List<clUsuario>> call =jsonPlaceHolderApi.getUsuarioInactivar();

        call.enqueue(new Callback<List<clUsuario>>() {
            @Override
            public void onResponse(Call<List<clUsuario>> call, Response<List<clUsuario>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "code: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                List<clUsuario> user = response.body();

                if (user.isEmpty() == true){
                    //Toast.makeText(getApplicationContext(), "Usuario no encontrado", Toast.LENGTH_LONG).show();
                    return;
                }

                int id = 0;
                String NombreLogueo = "";
                String ContraLogueo = "";
                String AvatarLogueo = "";

                clUsuario us = new clUsuario();

                for (clUsuario usuario : user){

                    id = usuario.getIdUsuario();
                    NombreLogueo += usuario.getNombre();
                    AvatarLogueo += usuario.getAvatar();
                    ContraLogueo += usuario.getContrasena();

                    us.mtdPutEstado(id);


                }


            }

            @Override
            public void onFailure(Call<List<clUsuario>> call, Throwable t) {
                return;
            }
        });


    }

    public void ventanaModal(){
        AlertDialog.Builder builder= new AlertDialog.Builder(InicioSesion.this);
        LayoutInflater inflater = getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.emergente_salir, null);

        builder.setView(view1);

        AlertDialog dialog = builder.create();
        dialog.show();

        Button btnConfirmarRegistro = (Button)view1.findViewById(R.id.btnConfirmarSalir);
        Button btnCamcelarSalida = (Button) view1.findViewById(R.id.btnCancelarSalir);

        btnConfirmarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnCamcelarSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioSesion.this, InicioSesion.class);
                startActivity(intent);
                finish();
            }
        });

    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        ventanaModal();
    }


}
