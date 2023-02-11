package com.example.passkeep

import androidx.room.*

@Dao
interface DAO {
    @Insert
    suspend fun insertTask(entity: Entity)

    @Update
    suspend fun updateTask(entity: Entity)

    @Delete
    suspend fun deleteTask(entity: Entity)

    @Query("Delete from Pwd_Manager")
    suspend fun deleteAll()

    @Query("Select * from Pwd_Manager")
    suspend fun getTasks():List<CardInfo>

}