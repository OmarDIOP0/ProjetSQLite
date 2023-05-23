package com.example.projetsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val floatingAddButton=findViewById<FloatingActionButton>(R.id.floatingAddButton);
        floatingAddButton.setOnClickListener {
            val intent=Intent(this,AddArticle::class.java)
            startActivity(intent)
        }
        val db=DBHelper(this);
        val cursor=db.getData();
        print("Donnee du cursor==============");
        print(cursor);






    }
}