package com.example.agenda.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda.R
import com.example.agenda.adapters.AgendaAdapter
import com.example.agenda.entities.AgendaItem
import com.example.agenda.roomdb.AgendaDatabase
import com.example.agenda.viewModels.AgendaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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