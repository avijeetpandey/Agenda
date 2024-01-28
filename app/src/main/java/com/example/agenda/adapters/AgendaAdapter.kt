package com.example.agenda.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda.R
import com.example.agenda.viewModels.AgendaViewModel

class AgendaAdapter(private val dataSet: ArrayList<AgendaViewModel>) : RecyclerView.Adapter<AgendaAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val titleTextView: TextView
        val subtitleTextView: TextView

        init {
            titleTextView =  view.findViewById(R.id.agendaTitle)
            subtitleTextView = view.findViewById(R.id.agendaSubtitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.agenda_card_view, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = dataSet[position].title
        holder.subtitleTextView.text = dataSet[position].subtitle
    }
}