package com.example.nasa_api_astoried_radar.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AsteroidDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageOfTheDay (image : ImageOfTheDayEntity )

    @Query("SELECT * FROM image_of_the_day")
    fun getAllImageOfTheData () : LiveData<List<ImageOfTheDayEntity>>

}