package com.example.projetsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "ArticleBloc.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Article(id INT primary key,title TEXT,description TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
         DB.execSQL("drop Table if exists Article");
    }


    public Boolean insertArticle (String title,String description){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("title",title);
        contentValues.put("description",description);
        long result=DB.insert("Article",null,contentValues);
         if(result==-1){
             return false;
         }
         return true;
    }
    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from Article",null);
        return cursor;
    }


}
