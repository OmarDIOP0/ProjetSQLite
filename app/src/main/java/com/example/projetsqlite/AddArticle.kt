package com.example.projetsqlite

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddArticle : AppCompatActivity() {
    @SuppressLint("Range", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_article)

        val floatingCloseButton = findViewById<FloatingActionButton>(R.id.floatingCloseButton);
        floatingCloseButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val titleA = findViewById<EditText>(R.id.title);
        val descriptionA = findViewById<EditText>(R.id.description);
        val insertArticle = findViewById<Button>(R.id.add_button);


        insertArticle.setOnClickListener {
            val titles = titleA.text.toString();
            val descriptions = descriptionA.text.toString();
            val article=ArticleModel(titre=titles,description=descriptions);
            Toast.makeText(this, "$titles ajouté à la base!", Toast.LENGTH_LONG).show()
            titleA.text.clear();
            descriptionA.text.clear();
        }
    }
}