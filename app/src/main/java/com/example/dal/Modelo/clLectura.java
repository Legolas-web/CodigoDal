package com.example.dal.Modelo;

public class clLectura {

    private Integer IdLectura;
    private String Titulo;
    private String Texto;
    private String Tipo;
    private int Img;

    public clLectura(){

    }

    public clLectura(Integer idLectura, String titulo, String texto, String tipo, Integer img) {
        IdLectura = idLectura;
        Titulo = titulo;
        Texto = texto;
        Tipo = tipo;
        Img = img;
    }

    public Integer getIdLectura() {
        return IdLectura;
    }

    public void setIdLectura(Integer idLectura) {
        IdLectura = idLectura;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }


}
