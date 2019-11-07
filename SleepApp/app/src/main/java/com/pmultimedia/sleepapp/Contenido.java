package com.pmultimedia.sleepapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Contenido {

    public static ArrayList<Lista_entrada> ENT_LISTA = new ArrayList<Lista_entrada>();
    public static Map<String, Lista_entrada> ENT_LISTA_HASHMAP = new HashMap<String, Lista_entrada>();

    private static void aniadirEntrada(Lista_entrada entrada){

        ENT_LISTA.add(entrada);
        ENT_LISTA_HASHMAP.put(entrada.id, entrada);

    }

    public static class Lista_entrada {

        public String id;
        public int idImagen;
        public String textoEncima;
        public String textoDebajo;
        public String subtitulo;

        public Lista_entrada(String id, int idImagen, String textoEncima, String textoDebajo, String subtitulo) {
            this.id = id;
            this.idImagen = idImagen;
            this.textoEncima = textoEncima;
            this.textoDebajo = textoDebajo;
            this.subtitulo = subtitulo;
        }

    }

    static {

        aniadirEntrada(new Lista_entrada("0", R.drawable.postura11, "POSICION FETAL", "Si quieres sentirte como en el mismísimo vientre de tus santísima madre, esta es tu postura. Duerme como un bebé haciendo la posición fetal.", "\"Agugu-tata...\""));
        aniadirEntrada(new Lista_entrada("1", R.drawable.postura2, "EL CHIQUITO", "Si quieres soñar que haces reír a todo el mundo pero realmente no tienes ni pizca de gracia y le gente se ríe de ti, como el \"El Chiquito\" , esta es tu postura.", "\"¡Por la gloria de mi madre!\""));
        aniadirEntrada(new Lista_entrada("2", R.drawable.postura3, "LA PLANCHA", "Si quieres un vientre plano y una espalda destrozada, si quieres levantarte como si te hubiera arrollado una manada de ñus o un grupo de niños que salen del colegio, esta es tu postura.", "\"Uff, me duele la espalda...\""));
        aniadirEntrada(new Lista_entrada("3", R.drawable.postura4, "EL BORRACHO", "¿Llegas más ciego a casa que Stevie Wonder y no eres capaz ni de acostarte? Duerme de esta manera, no es para nada segura, pero con el ciego que llevas no puedes aspirar a nada mejor.", "\"Lo jurro, la jultima y nosh vamo\""));
        aniadirEntrada(new Lista_entrada("4", R.drawable.postura5, "EL MUERTO", "Si quieres descansar en paz como si no hubiera un mañana, cual fallecido, esta sin duda es tu postura. No te arrepentirás, sobre todo si de verdad estás en el otro mundo.", "\"...\""));
        aniadirEntrada(new Lista_entrada("5", R.drawable.postura6, "EL MUERTO PRO", "Ahora sí que sí, si quieres parecer que estas en mitad de un funeral, amortajado cual difunto, así debes dormir. Eso sí, debes ser muy amigo de tus amigos. DEP", "\"......\""));
        aniadirEntrada(new Lista_entrada("6", R.drawable.postura7, "HAMLET", "Ser, o no ser, esa es la cuestión. Donde no hay cuestión es en que, si quieres dormir imitando el mismísimo Hamlet de Shakespeare, esta es tu postura. Esperemos que tu sueño no tenga el mismo final que esta popular obra.", "\"Ser, o no ser\""));
        aniadirEntrada(new Lista_entrada("7", R.drawable.postura8, "LA MALDITA LUZ", "¿No puedes dormir por una odiosa luz que ilumina tus sueños impidiendo tu descanso sin cesar? Sin duda, esta es tu postura, eso sí, intenta respirar de vez en cuando.", "\"¿Pero de donde viene?\""));
        aniadirEntrada(new Lista_entrada("8", R.drawable.postura9, "KARATE KID", "Dar cera, pulir cera. Un clásico de las peliculas de artes marciales. Si quieres sentirte como el verdadero protagonista de esta honorable película, esta es tu técnica final.", "\"Dal sela, pulil sela\""));
        aniadirEntrada(new Lista_entrada("9", R.drawable.postura10, "EL HAMBRIENTO", "¿Pasas más hambre durmiendo que el dueño de un videoclub? Esta es tu postura, no soluciona nada, pero así el que te vea sabrá que estas hambriento.", "\"Como me comía un kebab de mortadela...\""));

    }

}
