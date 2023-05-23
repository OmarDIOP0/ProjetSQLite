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

        floatingAddButton.setOnClickListener {
            val intent=Intent(this,AddArticle::class.java)
            startActivity(intent)
        }
        val db=DBHelper(this);
        val cursor=db.getData();
        print("Donnee du cursor==============");
        print(cursor);
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