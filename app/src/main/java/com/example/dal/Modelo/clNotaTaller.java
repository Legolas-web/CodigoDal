package com.example.dal.Modelo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class clNotaTaller {

    private Integer idNotaTaller;
    private float notaFinal;
    private int taller;
    private int idUsuario;

    public clNotaTaller() {

    }

    public clNotaTaller(float notaFinal, int taller, int idUsuario) {
        this.notaFinal = notaFinal;
        this.taller = taller;
        this.idUsuario = idUsuario;
    }

    public Integer getIdNotaTaller() {
        return idNotaTaller;
    }

    public void setIdNotaTaller(Integer idNotaTaller) {
        this.idNotaTaller = idNotaTaller;
    }

    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getTaller() {
        return taller;
    }

    public void setTaller(int taller) {
        this.taller = taller;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    public int valorReturn = 0;

    public int mtdPostNotaTaller(float notaFin, int tall, int idUsu){

        clNotaTaller noTa = new clNotaTaller(notaFin, tall, idUsu);



        Call<Void> call = jsonPlaceHolderApi.PostNotaTaller(noTa);

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
