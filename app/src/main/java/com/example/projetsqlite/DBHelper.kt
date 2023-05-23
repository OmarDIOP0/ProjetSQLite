package com.example.projetsqlite
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + TITLE_COl + " TEXT," +
                DESC_COL + " TEXT" + ")")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun insert(article:ArticleModel):Long{
        val values = ContentValues()
        values.put(TITLE_COl,article.titre )
        values.put(DESC_COL, article.description)

        val db = this.writableDatabase
        val sucess=db.insert(TABLE_NAME, null, values)
        db.close()
        return sucess;
    }
    @SuppressLint("Range")
    fun getAllArticle():ArrayList<ArticleModel>{
        val articlelist:ArrayList<ArticleModel> =ArrayList()
        val selectQuery="SELECT *FROM $TABLE_NAME";
        val db = this.readableDatabase
        val cursor:Cursor?
        try{
            cursor=db.rawQuery(selectQuery,null)
        }catch (e:Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var titre:String;
        var description:String;
        if(cursor.moveToFirst())
        {
            do {
                titre = cursor.getString(cursor.getColumnIndex("titre"));
                description = cursor.getString(cursor.getColumnIndex("description"));
                val article = ArticleModel(titre = titre, description = description)
                articlelist.add(article)
            }while (cursor.moveToNext())
        }
        return articlelist
    }

    companion object{
        private val DATABASE_NAME = "DBArticle"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "article"
        val TITLE_COl = "titre"
        val DESC_COL = "description"
    }
}
