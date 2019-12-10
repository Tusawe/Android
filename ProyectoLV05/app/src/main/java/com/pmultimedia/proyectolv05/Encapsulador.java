package com.pmultimedia.proyectolv05;

public class Encapsulador {
    private String titulo;
    private String texto;
    public Encapsulador (String textoTitulo, String textoContenido) {
        this.titulo = textoTitulo;
        this.texto = textoContenido;
    }
    public String get_textoTitulo() {
        return titulo;
    }
    public String get_textoContenido() {
        return texto; }
}
