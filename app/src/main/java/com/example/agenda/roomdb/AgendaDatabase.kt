package com.example.agenda.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.agenda.entities.AgendaItem
import com.example.agenda.entities.AgendaItemDao

@Database(entities = [AgendaItem::class], version = 1)
abstract class AgendaDatabase: RoomDatabase() {
    abstract fun AgendaItemDao(): AgendaItemDao

    companion object {
        @Volatile private var instance: AgendaDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context): AgendaDatabase {
            return instance ?: synchronized(LOCK) {
                instance ?: BuildDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun BuildDatabase(context: Context)= Room.databaseBuilder(context.applicationContext,
                                                                            AgendaDatabase::class.java,
                                                                            "AgendaDB").build()
    }
}