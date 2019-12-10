package com.pmultimedia.proyectolv06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Listas06 extends AppCompatActivity {

    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas06);
        ArrayList<Encapsulador> datos = new ArrayList<Encapsulador>();
        datos.add(new Encapsulador(R.drawable.caravaggio, "CARAVAGGIO", "Pintor italiano entre los años de 1593 y 1610. Es considerado como el primer gran exponente de la pintura del Barroco."));
        datos.add(new Encapsulador(R.drawable.rafael, "RAFAEL SANZIO", "Pintor y arquitecto italiano del Renacimiento, realizó importantes aportes en la arquitectura y, como inspector de antigüedades."));
        datos.add(new Encapsulador(R.drawable.velazquez, "VELAZQUEZ", "Pintor Barroco nacido en Sevilla en 1599, es considerado uno de los máximos exponentes de la pintura española y maestro de la pintura universal."));
        datos.add(new Encapsulador(R.drawable.miguelangel, "MIGUEL ANGEL", "Arquitecto, escultor y pintor italiano renacentista, considerado uno de los más grandes artistas de la historia."));
        datos.add(new Encapsulador(R.drawable.rembrant, "REMBRANDT", "Pintor y grabador holandés. La historia del arte le considera uno de los mayores maestros barrocos de la pintura y el grabado."));
        datos.add(new Encapsulador(R.drawable.boticelli, "BOTICELLI", "Apodado Sandro Botticelli, fue un pintor cuatrocentista italiano.su obra se ha considerado representativa de la pintura del primer Renacimiento."));
        datos.add(new Encapsulador(R.drawable.leonardo, "LEONARDO DA VINCI", "Notable polímata del Renacimiento italiano (a la vez anatomista, arquitecto, artista, botánico, científico, escritor, escultor, filósofo, ingeniero...)"));
        datos.add(new Encapsulador(R.drawable.renoir, "RENOIR", "Pintor francés impresionista, interesado por la pintura de cuerpos femeninos en paisajes, inspirados a menudo en pinturas clásicas renacentistas y barrocas."));
        lista = (ListView) findViewById(R.id.Ejemplo_listado);
        lista.setAdapter(new Adaptador(this, R.layout.entrada, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView)
                            view.findViewById(R.id.texto_titulo);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Encapsulador)
                                entrada).get_textoTitulo());
                    TextView texto_inferior_entrada = (TextView)
                            view.findViewById(R.id.texto_datos);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((Encapsulador)
                                entrada).get_textoContenido());
                    ImageView imagen_entrada = (ImageView)
                            view.findViewById(R.id.cara_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Encapsulador)
                                entrada).get_idImagen());
                }
            }
        });
    }
}
