package com.example.passkeep

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Pwd_Manager")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var website:String,
    var email:String,
    var password:String
)