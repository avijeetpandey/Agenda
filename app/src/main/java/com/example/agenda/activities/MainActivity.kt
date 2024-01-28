package com.example.agenda.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda.R
import com.example.agenda.adapters.AgendaAdapter
import com.example.agenda.roomdb.AgendaDatabase
import com.example.agenda.viewModels.AgendaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var dataSet = ArrayList<AgendaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        
        val adapter = AgendaAdapter(dataSet)
        recyclerView?.adapter = adapter

        fetchDataFromTheRoomDB()
    }

    private fun fetchDataFromTheRoomDB() {
        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                this@MainActivity?.let {
                    if(AgendaDatabase(it).AgendaItemDao().getAllAgendaItems().isNotEmpty()) {
                        val agendaFromDB = AgendaDatabase(it).AgendaItemDao().getAllAgendaItems()
                        
                        agendaFromDB.forEach {
                            val agendaViewModel = AgendaViewModel(it.title,
                                                                it.subtitle,
                                                                it.isCompleted)

                            dataSet.add(agendaViewModel)
                        }

                        recyclerView?.adapter?.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    private fun insertDataIntoDB() {

    }
}