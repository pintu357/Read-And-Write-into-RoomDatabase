package com.example.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.database.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    lateinit var database: ContactDatabase
    //lateinit var contactArrayList : LiveData<ArrayList<Contact>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        //Database Created
        database = Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "ContactDBA").build()

        //Insert Data

        /*GlobalScope.launch {
            database.contactDao().insertContact(Contact("Pintu",66,"Faridabad"))
        }*/

        binding.save.setOnClickListener( object : View.OnClickListener{
            override fun onClick(view: View?) {
                val name : String = binding.name.text.toString()
                val mobile : Int = Integer.parseInt(binding.mobile.text.toString())
                val address : String = binding.address.text.toString()

                //Insert Data
                GlobalScope.launch {
                    database.contactDao().insertContact(Contact(name,mobile,address))
                }


            }
        })

        binding.read.setOnClickListener( object : View.OnClickListener{
            override fun onClick(view: View?) {
                //Read Data


                Log.d("Cheezycode1","Get Data")
                database.contactDao().getContact().observe(this@MainActivity, {
                    Log.d("Cheezycode2",it.toString())
                    val intent = Intent(this@MainActivity,ShowDatabase::class.java)

                    val contactArrayList : ArrayList<Contact> = ArrayList()
                    //for(item in it) contactArrayList.add(it.get())
                    it.forEach { contactArrayList.add(it)
                        Log.d("Cheezycode3",it.toString())
                    }

                    intent.putExtra("data",contactArrayList)
                    startActivity(intent)
                })


            }
        })

    }


}

