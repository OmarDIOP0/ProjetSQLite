package com.example.projetsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val floatingAddButton=findViewById<FloatingActionButton>(R.id.floatingAddButton);
        var recycleView=findViewById<RecyclerView>(R.id.recycleView);
        val taskList = ArrayList<String>();
        val titleA = findViewById<EditText>(R.id.title);
        val descriptionA = findViewById<EditText>(R.id.description);

        floatingAddButton.setOnClickListener {
            val intent=Intent(this,AddArticle::class.java)
            startActivity(intent)
        }
        fun getArticle(){
            val db = DBHelper(this, null)
            val artclelist=db.getAllArticle();

        }
        recycleView = findViewById(R.id.recycleView)
        var title = intent.getStringExtra("title").toString()
        var description = intent.getStringExtra("content").toString()

        val db = DBHelper(this,null)
        var items = ArrayList<ArticleModel>()
        recycleView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ArticleAdapter(items)
        }
    }

    }