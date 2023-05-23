package com.example.projetsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddArticle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_article)

        val floatingCloseButton=findViewById<FloatingActionButton>(R.id.floatingCloseButton);
        floatingCloseButton.setOnClickListener {
           val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        val title=findViewById<EditText>(R.id.title);
        val description=findViewById<EditText>(R.id.description);
        val insertArticle=findViewById<Button>(R.id.add_button);
        val lister=findViewById<Button>(R.id.list_button);

        insertArticle.setOnClickListener {
            val db=DBHelper(this);
            val titles=title.text.toString();
            val descriptions=description.text.toString();

            db.insertArticle(titles,descriptions);
            Toast.makeText(this, "$titles ajouté à la base!", Toast.LENGTH_LONG).show()
            title.text.clear();
            description.text.clear();
        }
        lister.setOnClickListener {
            val db=DBHelper(this);
            val cursor=db.getData();
            cursor!!.moveToFirst()
            //title.append(cursor.getString(cursor.getColumnIndex(DBHelper.title)))
        }

    }
}