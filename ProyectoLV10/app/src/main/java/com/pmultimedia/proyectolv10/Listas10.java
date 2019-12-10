package com.pmultimedia.proyectolv10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listas10 extends AppCompatActivity {

    private ListView lista;
    private RadioButton radioButton_pulsado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas10);
        ArrayList<Encapsulador> datos = new ArrayList<Encapsulador>();
        datos.add(new Encapsulador(R.drawable.caravaggio, "CARAVAGGIO", "Pintor italiano entre los años de 1593 y 1610. Es considerado como el primer gran exponente de la pintura del Barroco.",true));
        datos.add(new Encapsulador(R.drawable.rafael, "RAFAEL SANZIO", "Pintor y arquitecto italiano del Renacimiento, realizó importantes aportes en la arquitectura y, como inspector de antigüedades.", false));
        datos.add(new Encapsulador(R.drawable.velazquez, "VELAZQUEZ", "Pintor Barroco nacido en Sevilla en 1599, es considerado uno de los máximos exponentes de la pintura española y maestro de la pintura universal.",false));
        datos.add(new Encapsulador(R.drawable.miguelangel, "MIGUEL ANGEL", "Arquitecto, escultor y pintor italiano renacentista, considerado uno de los más grandes artistas de la historia.", false));
        datos.add(new Encapsulador(R.drawable.rembrant, "REMBRANDT", "Pintor y grabador holandés. La historia del arte le considera uno de los mayores maestros barrocos de la pintura y el grabado.",false));
        datos.add(new Encapsulador(R.drawable.boticelli, "BOTICELLI", "Apodado Sandro Botticelli, fue un pintor cuatrocentista italiano.su obra se ha considerado representativa de la pintura del primer Renacimiento.", false));
        datos.add(new Encapsulador(R.drawable.leonardo, "LEONARDO DA VINCI", "Notable polímata del Renacimiento italiano (a la vez anatomista, arquitecto, artista, botánico, científico, escritor, escultor, filósofo, ingeniero...)", false));
        datos.add(new Encapsulador(R.drawable.renoir, "RENOIR", "Pintor francés impresionista, interesado por la pintura de cuerpos femeninos en paisajes, inspirados a menudo en pinturas clásicas renacentistas y barrocas.",false));
        lista = (ListView) findViewById(R.id.Ejemplo_listado);

        lista.setAdapter(new Adaptador(this, R.layout.entrada, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {

                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.texto_titulo);
                    texto_superior_entrada.setText(((Encapsulador) entrada).get_textoTitulo());
                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.texto_datos);
                    texto_inferior_entrada.setText(((Encapsulador) entrada).get_textoContenido());
                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.cara_imagen);
                    imagen_entrada.setImageResource(((Encapsulador) entrada).get_idImagen());
                    RadioButton gusta = (RadioButton) view.findViewById(R.id.boton);

                    gusta.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (radioButton_pulsado!=null)
                                radioButton_pulsado.setChecked(false);
                                radioButton_pulsado = (RadioButton) v;
                                Toast toast = Toast.makeText(Listas10.this, "ME GUSTA", Toast.LENGTH_LONG);
                                toast.show();
                        }
                    });
                }
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Encapsulador elegido = (Encapsulador) pariente.getItemAtPosition(posicion);
                CharSequence texto = "Seleccionado: " + elegido.get_textoContenido();
                Toast toast = Toast.makeText(Listas10.this, texto, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
