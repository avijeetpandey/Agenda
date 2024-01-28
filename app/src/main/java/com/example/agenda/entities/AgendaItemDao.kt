package com.example.agenda.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AgendaItemDao {
    @Insert
    suspend fun insertAgendaItem(agendaItem: AgendaItem)

    @Query("SELECT * from agendaItem ORDER BY id DESC")
    suspend fun getAllAgendaItems(): List<AgendaItem>

    @Delete
    suspend fun deleteItem(item: AgendaItem)

    @Update
    suspend fun updateItem(item: AgendaItem)
}