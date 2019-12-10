package com.dinterfaces.sleepapprecyclerview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class PosturaAdapter(private val posturas: List<Postura>, val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<PosturaAdapter.PosturaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosturaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.posturas_list_item, parent, false)
        return PosturaViewHolder(view)
    }

    override fun getItemCount() = posturas.size

    override fun onBindViewHolder(holder: PosturaViewHolder, position: Int) {
        val postura = posturas[position]
        holder.bind(postura, itemClickListener)
    }

    inner class PosturaViewHolder(view: View) :RecyclerView.ViewHolder(view) {

        val nameTextView = itemView.findViewById<TextView>(R.id.postura_name)
        val descriptionTextView = itemView.findViewById<TextView>(R.id.postura_descrption)
        val photoImageView = itemView.findViewById<ImageView>(R.id.postura_photo)

        fun bind(postura: Postura, clickListener: OnItemClickListener) {
            nameTextView.text = postura.name
            descriptionTextView.text = postura.description
            Glide
                .with(itemView.context)
                .load(postura.photo)
                .centerInside()
                .into(photoImageView)

            itemView.setOnClickListener{
                clickListener.onClicked(postura)
            }
        }
    }

    interface OnItemClickListener {
        fun onClicked(postura: Postura)
    }

}