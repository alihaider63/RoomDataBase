package com.haider.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.RoomDatabase
import com.haider.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var contactDatabase: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contactDatabase = ContactDatabase.getDataBase(this)
        val database2 = ContactDatabase.getDataBase(this)

        GlobalScope.launch {
            Log.d("cheezy code","added")
            contactDatabase.contactDao().insertContact(Contact(0,"Ali haider","03081195231", Date(), 1))
        }
        binding.Btn.setOnClickListener {
            getData()
        }

    }

    private fun getData() {
        contactDatabase.contactDao().getContact().observe(this, Observer {
            Log.d("Ali haider",it.toString())
        })
    }


}