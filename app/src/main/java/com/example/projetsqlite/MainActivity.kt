package com.example.projetsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var taskAdapter:TaskAdapter


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

    }

    inner class TaskAdapter(private val taskList: List<String>) :
        RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

        inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
            return TaskViewHolder(view)
        }

        override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
            val task = taskList[position]
            holder.itemView.apply {
                findViewById<TextView>(android.R.id.text1).text = task
            }
        }


        override fun getItemCount(): Int {
            return taskList.size
        }
    }
}