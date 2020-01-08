package com.dinterfaces.examen_gomez_joseluis


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class EventDetailFragment : Fragment() {

    lateinit var name : TextView
    lateinit var place : TextView
    lateinit var datetime : TextView
    lateinit var description : TextView
    lateinit var speaker : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        name = view.findViewById(R.id.nameDetail)
        place = view.findViewById(R.id.placeDetail)
        datetime = view.findViewById(R.id.datetimeDetail)
        description = view.findViewById(R.id.descriptionDetail)
        speaker = view.findViewById(R.id.speakerDetail)

        val evento = arguments?.get("event") as Event

        name.text = evento.name
        place.text = evento.place
        datetime.text = evento.datetime
        description.text = evento.description
        speaker.text = evento.speaker

    }

}
