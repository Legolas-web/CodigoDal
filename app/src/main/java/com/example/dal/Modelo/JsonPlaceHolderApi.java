package com.example.dal.Modelo;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    //________________________________________________________________________________________________________________________________________________________________________
    //--USUARIO--
    @GET("usuarios")
    Call<List<clUsuario>> getUsuario();

    @GET("usuariosCalificar")
    Call<List<clUsuario>> getUsuarioCalificar();

    @GET("usuariosInactivar")
    Call<List<clUsuario>> getUsuarioInactivar();

    @GET("usuario/{id}/")
    Call<List<clUsuario>> getIdUsuario(@Path("id") int idUsuario);

    @GET("usuarioLogin/{nombre}")
    Call<List<clUsuario>> getLoginUser(@Path("nombre") String nombre);

    @POST("usuario")
    Call<Void> PostUsuario(@Body clUsuario usuario);

    @PUT("usuario/{id}/")
    Call<Void> PutUsuario(@Path("id") int idUsuario, @Body clUsuario usuario);

    @PUT("usuarioInactivar/{id}/")
    Call<Void> PutUsuarioInactivo(@Path("id") int idUsuario);

    @PUT("usuarioActivar/{id}/")
    Call<Void> PutUsuarioActivo(@Path("id") int idUsuario);

    @DELETE("usuario/{id}/")
    Call<Void> DeleteUsuario(@Path("id") int idUsuario);

    //________________________________________________________________________________________________________________________________________________________________________
    //--RESPUESTA--

    @POST("respuesta")
    Call<Void> PostRespuesta(@Body clRespuesta respuesta);

    @GET("respuestasTaller1/{id}")
    Call<List<clRespuesta>> getRespuestasTaller1(@Path("id") int idUsuario);

    @GET("respuestasTaller2/{id}")
    Call<List<clRespuesta>> getRespuestasTaller2(@Path("id") int idUsuario);

    @GET("respuestasTaller3/{id}")
    Call<List<clRespuesta>> getRespuestasTaller3(@Path("id") int idUsuario);

    @GET("respuestasTaller4/{id}")
    Call<List<clRespuesta>> getRespuestasTaller4(@Path("id") int idUsuario);

    @GET("respuestasTaller5/{id}")
    Call<List<clRespuesta>> getUsuarioNuevo(@Path("id") int idUsuario);

    //________________________________________________________________________________________________________________________________________________________________________
    //--NOTA--

    @POST("nota")
    Call<Void> PostNota(@Body clNota nota);

    //________________________________________________________________________________________________________________________________________________________________________
    //--NOTA_TALLER--

    @POST("notaTaller")
    Call<Void> PostNotaTaller(@Body clNotaTaller notaTaller);

    @GET("notasTalleres/{id}")
    Call<List<clNotaTaller>> getNotaFinal(@Path("id") int idUsuario);

}
