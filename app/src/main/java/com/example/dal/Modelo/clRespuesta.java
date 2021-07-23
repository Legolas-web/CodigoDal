package com.example.dal.Modelo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class clRespuesta {

    public int valorReturn = 0;

    private Integer idRespuesta;
    private String respuestaUser;
    private String fecha;
    private String pregunta;
    private int taller;
    private int idUsuario;

    //Instancias de HTTP
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://mysterious-journey-17387.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    public clRespuesta() {

    }

    public clRespuesta(String respuestaUser, String pregunta, int taller, int idUsuario) {
        this.respuestaUser = respuestaUser;
        this.pregunta = pregunta;
        this.taller = taller;
        this.idUsuario = idUsuario;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuestaUser() {
        return respuestaUser;
    }

    public void setRespuestaUser(String respuestaUser) {
        this.respuestaUser = respuestaUser;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
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

    public int mtdPostRespuesta(String resUser, String pregun, int talle, int iduser){

        clRespuesta res = new clRespuesta(resUser, pregun, talle, iduser);

        Call<Void> callPost = jsonPlaceHolderApi.PostRespuesta(res);

        callPost.enqueue(new Callback<Void>() {
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
