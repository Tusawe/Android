package com.dinterfaces.examen_gomez_joseluis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(private val eventos: List<Event>, val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_event, parent, false)
        return EventViewHolder(view)
    }

    override fun getItemCount() = eventos.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val evento = eventos[position]
        holder.bind(evento, itemClickListener)
    }

    inner class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nameTextView = itemView.findViewById<TextView>(R.id.nameItem)
        val datetimeTextView = itemView.findViewById<TextView>(R.id.datetimeItem)
        val speakerTextView = itemView.findViewById<TextView>(R.id.speakerItem)

        fun bind(event: Event, clickListener: OnItemClickListener) {

            nameTextView.text = event.name
            datetimeTextView.text = event.datetime
            speakerTextView.text = event.speaker

            itemView.setOnClickListener{
                clickListener.onClicked(event)
            }
        }
    }

    interface OnItemClickListener {
        fun onClicked(event: Event)
    }

}