package com.example.projetsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailArticle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_article)

        var btn_update = findViewById<Button>(R.id.update)
        var btn_delete = findViewById<Button>(R.id.delete)

        var titre_article = intent.getStringExtra("titre_article")

        var db = DBHelper(this,null);

        btn_delete.setOnClickListener {
            var retour = db.deleteArticle(titre_article.toString())

            if(retour){
                Toast.makeText(this, "Article bien supprimé", Toast.LENGTH_LONG).show()
            }

        }


        var floatingBackButton = findViewById<FloatingActionButton>(R.id.floatingBackButton)

        floatingBackButton.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}