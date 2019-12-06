package com.pmultimedia.proyectolv04;

public class Encapsulador {
    private String texto;
    public Encapsulador (String textoContenido) {
        this.texto = textoContenido;
    }
    public String get_textoContenido() {
        return texto;
    }
}
