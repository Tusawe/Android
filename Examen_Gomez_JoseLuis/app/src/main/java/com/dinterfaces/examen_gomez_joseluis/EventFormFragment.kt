package com.dinterfaces.examen_gomez_joseluis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast


class EventFormFragment : Fragment() {

    lateinit var name : EditText
    lateinit var place : EditText
    lateinit var datetime : EditText
    lateinit var description : EditText
    lateinit var speaker : Spinner
    lateinit var insertar : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        name = view.findViewById(R.id.nameEvent)
        place = view.findViewById(R.id.placeEvent)
        datetime = view.findViewById(R.id.datetimeEvent)
        description = view.findViewById(R.id.descriptionEvent)
        speaker = view.findViewById(R.id.speakerEvent)

        insertar = view.findViewById(R.id.insertar)
        insertar.setOnClickListener {

            insertarEvento()

        }

    }

    private fun insertarEvento() {

        if(validar()) {

            val evento = Event(
                name.text.toString(),
                place.text.toString(),
                datetime.text.toString(),
                description.text.toString(),
                speaker.getItemAtPosition(speaker.selectedItemPosition).toString()
            )

            EventSingleton.eventos.add(evento)

        }

    }

    private fun validar(): Boolean {

        if(name.text.toString() == "") {
            Toast.makeText(context, "Campo NOMBRE obligatorio", Toast.LENGTH_SHORT).show()
            return false
        } else if (place.text.toString() == "") {
            Toast.makeText(context, "Campo LUGAR obligatorio", Toast.LENGTH_SHORT).show()
            return false
        } else if (datetime.text.toString() == "") {
            Toast.makeText(context, "Campo FECHA Y HORA obligatorio", Toast.LENGTH_SHORT).show()
            return false
        } else if (speaker.getItemAtPosition(speaker.selectedItemPosition).toString() == "-- Seleccione un ponente --") {
            Toast.makeText(context, "Seleccione un PONENTE", Toast.LENGTH_SHORT).show()
            return false
        }

        return true

    }


}
