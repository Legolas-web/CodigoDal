package com.example.dal.Modelo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class clNota {

    private Integer idNota;
    private float valorNota;
    private int idRespuesta;
    private int idUsuario;

    public clNota() {

    }

    public clNota(float valorNota, int idRespuesta, int idUsuario) {
        this.valorNota = valorNota;
        this.idRespuesta = idRespuesta;
        this.idUsuario = idUsuario;
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public float getValorNota() {
        return valorNota;
    }

    public void setValorNota(float valorNota) {
        this.valorNota = valorNota;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static void setRetrofit(Retrofit retrofit) {
        clNota.retrofit = retrofit;
    }

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    public int valorReturn = 0;

    public int mtdPostNota(float notaVal, int idRes, int idUsu){

        clNota not = new clNota(notaVal, idRes, idUsu);

        Call<Void> call = jsonPlaceHolderApi.PostNota(not);

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

}
