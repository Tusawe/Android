package com.pmultimedia.proyectolv09;

public class Encapsulador {
    private int imagen;
    private String titulo;
    private String texto;
    private boolean dato1;
    private boolean dato2;
    public Encapsulador (int idImagen, String textoTitulo, String
            textoContenido, boolean tipopintor1, boolean tipopintor2) {
        this.imagen = idImagen;
        this.titulo = textoTitulo;
        this.texto = textoContenido;
        this.dato1=tipopintor1;
        this.dato2=tipopintor2;
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
    public boolean get_checkBox1()
    {
        return dato1;
    }
    public boolean get_checkBox2()
    {
        return dato2;
    }
}
