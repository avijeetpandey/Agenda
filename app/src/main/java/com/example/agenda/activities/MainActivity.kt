package com.example.agenda.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda.R
import com.example.agenda.adapters.AgendaAdapter
import com.example.agenda.viewModels.AgendaViewModel

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(this)

        var dataSet = ArrayList<AgendaViewModel>()

        for(i in 1..10) {
            val agendaViewModel = AgendaViewModel(title = "Dinner",
                                                subtitle = "Please have dinner on time",
                                                isCompleted = false)
            dataSet.add(agendaViewModel)
        }

        val adapter = AgendaAdapter(dataSet)

        recyclerView?.adapter = adapter
    }
}