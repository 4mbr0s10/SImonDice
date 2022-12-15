package com.example.simondice.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecordDao {
    @Query("SELECT * FROM record_table order by puntos")
 fun selectAllRecords():List<RecordEntity>
@Query("INSERT INTO record_table(puntos) values(:puntos)")
 fun insertRecord(puntos:Int)

@Insert(onConflict = OnConflictStrategy.REPLACE)
 fun insertAll(records:List<RecordEntity>)
}