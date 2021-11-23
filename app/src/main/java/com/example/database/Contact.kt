package com.example.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "contact")
data class Contact(
    @PrimaryKey
    val name : String,
    val mobile : Int,
    val address : String
)
