package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.database.databinding.ActivityShowDatabaseBinding

class ShowDatabase : AppCompatActivity() {
    lateinit var activityShowDatabaseBinding: ActivityShowDatabaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityShowDatabaseBinding = DataBindingUtil.setContentView(this,R.layout.activity_show_database)

        val contactArrayList : ArrayList<Contact> = intent.getStringArrayListExtra("data") as ArrayList<Contact>
        Log.d("Cheezycode4",contactArrayList.toString())
        /*val contactArrayList : ArrayList<Contact> = ArrayList()
        contactArrayList.add(Contact("Pintu",12,"Faridabad"))
        contactArrayList.add(Contact("Montu",23,"Haryana"))*/

        activityShowDatabaseBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        activityShowDatabaseBinding.recyclerView.adapter = MyAdapter(contactArrayList)
    }
}