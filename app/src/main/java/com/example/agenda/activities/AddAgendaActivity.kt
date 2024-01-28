package com.example.agenda.activities
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda.R
import com.example.agenda.entities.AgendaItem
import com.example.agenda.roomdb.AgendaDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class AddAgendaActivity : AppCompatActivity() {

    private var submitButton: Button? = null
    private var agendaTitleTextField: EditText? = null
    private var agendaSubtitleTextField: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_agenda)

        setupViews()
    }

    private fun setupViews() {
        submitButton = findViewById(R.id.addButton)
        agendaSubtitleTextField = findViewById(R.id.agendaSubtitle)
        agendaTitleTextField = findViewById(R.id.agendaTitle)


        submitButton?.setOnClickListener {
            insertDataIntoRoomDB()
        }
    }

    private fun insertDataIntoRoomDB() {
        GlobalScope.launch {
            this?.let {
               if((agendaTitleTextField?.text?.isNotEmpty() == true) && (agendaSubtitleTextField?.text?.isNotEmpty() == true)) {
                   val agendaItem = AgendaItem(title = agendaTitleTextField!!.text.toString(),
                       subtitle = agendaTitleTextField!!.text.toString(),
                       isCompleted = false)

                   AgendaDatabase(this@AddAgendaActivity).AgendaItemDao().insertAgendaItem(agendaItem)

               }
            }
        }
    }
}
