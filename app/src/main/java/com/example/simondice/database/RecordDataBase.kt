package com.example.simondice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RecordEntity::class], version = 1)
abstract class RecordDataBase:RoomDatabase() {

    abstract fun getRecordDao():RecordDao

    companion object{
        @Volatile
        private var INSTANCE: RecordDataBase? = null

        fun getDatabase(context: Context): RecordDataBase{

            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(
                        context.applicationContext,
                        RecordDataBase::class.java,
                        "bd12.db"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE!!
        }
    }
}