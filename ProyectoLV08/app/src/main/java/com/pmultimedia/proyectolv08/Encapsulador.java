package com.pmultimedia.proyectolv08;

public class Encapsulador {
    private int imagen;
    private String titulo;
    private String texto;
    public Encapsulador (int idImagen, String textoTitulo, String
            textoContenido) {
        this.imagen = idImagen;
        this.titulo = textoTitulo;
        this.texto = textoContenido;
    }
    public String get_textoTitulo() {
        return titulo;
    }
    public String get_textoContenido() {
        return texto;
    }
    public int get_idImagen() {
        return imagen;
    }
}
