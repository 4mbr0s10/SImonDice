package com.example.simondice.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "record_table")
data class RecordEntity (
    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name ="id")   val id: Int,
    @ColumnInfo(name ="puntos")   val puntos: Int
)