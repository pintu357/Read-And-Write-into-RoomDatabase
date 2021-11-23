package com.example.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {

    @Insert
    suspend fun insertContact(contact : Contact)

    @Query("SELECT * FROM contact")
    fun getContact() : LiveData<List<Contact>>


}