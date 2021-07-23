package com.example.dal.Modelo;

import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class clUsuario {

    public int valorReturn = 0;

    private Integer idUsuario;
    private String nombre;
    private String nombreCompleto;
    private String contrasena;
    private String estado;
    private int avatar;

    //Instancias de HTTP
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    //-------------------------------------//-----------------------------------------//---------------------------------------------//---------------------------------//--------------------------------------------------------------------------------------------------------------

    public clUsuario() {

    }

    public clUsuario(String nombre, String nombreCompleto, String contrasena, String estado, int avatar) {
        this.nombre = nombre;
        this.nombreCompleto = nombreCompleto;
        this.contrasena = contrasena;
        this.estado = estado;
        this.avatar = avatar;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }


    public int mtdPostUsuario(String nombrePost, String nombreCompletoPost, String contrasenaPost, String estadoPost, int avatarPost){

        clUsuario user = new clUsuario(nombrePost, nombreCompletoPost, contrasenaPost, estadoPost, avatarPost);

        Call<Void> call = jsonPlaceHolderApi.PostUsuario(user);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                valorReturn = 1;
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                return;
            }
        });

        valorReturn = 1;

        return valorReturn;

    }

    public int mtdPutEstado(int id){

        Call<Void> call = jsonPlaceHolderApi.PutUsuarioInactivo(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                valorReturn = 1;
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                return;
            }
        });

        return valorReturn;
    }

    public int mtdPutEstadoActiva(int id){

        Call<Void> call = jsonPlaceHolderApi.PutUsuarioActivo(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                valorReturn = 1;
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                return;
            }
        });

        return valorReturn;
    }

    public int mtdElimina(int id){

        Call<Void> call = jsonPlaceHolderApi.DeleteUsuario(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                valorReturn = 1;
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                return;
            }
        });

        return valorReturn;
    }

}
