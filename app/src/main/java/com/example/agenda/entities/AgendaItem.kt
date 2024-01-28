package com.example.agenda.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AgendaItem(
    @ColumnInfo("title")
    var title: String,
    @ColumnInfo("subtitle")
    var subtitle: String,
    @ColumnInfo("isCompleted")
    var isCompleted: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    var id: Int = 0
}
