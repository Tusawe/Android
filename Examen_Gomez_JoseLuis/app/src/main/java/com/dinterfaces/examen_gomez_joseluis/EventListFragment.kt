package com.dinterfaces.examen_gomez_joseluis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EventListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val eventRecyclerView = view.findViewById<RecyclerView>(R.id.listaEventos).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = EventAdapter(EventSingleton.eventos, object : EventAdapter.OnItemClickListener {
                override fun onClicked(event: Event) {
                    val detailFragment = EventDetailFragment()
                    val bundle = Bundle()
                    bundle.putParcelable("event", event)
                    detailFragment.arguments = bundle

                    fragmentManager!!.beginTransaction().replace(R.id.container, detailFragment).addToBackStack(null).commit()

                }

            })
        }

    }

}
