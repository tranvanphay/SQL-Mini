package com.example.hades.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    public MyDatabase(Context context) {
        super(context, "quanlycongviec" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            /*
            create table congviec(
            _id integer primary key autoincrement,
            noidung text,
            thoigian text
            )
             */
            String sql="create table congviec"+
                    "("+
        "_id integer primary key autoincrement," +
                    "noidung text,"+
                    "thoigian text" +
                    ")";
            sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists congviec");
        onCreate(sqLiteDatabase);
    }
    //Them du lieu vao database
    public void themcongviec(String noidung,String thoigian){
       SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("noidung",noidung);
        values.put("thoigian",thoigian);
       sqLiteDatabase.insert("congviec",null,values);

    }
    //xem du lieu
    public ArrayList<String> xemCongViec(){
        ArrayList<String> dulieu= new ArrayList<String>();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor c= sqLiteDatabase.query("congviec",null,null,null,null,null,null);
        if(c.moveToFirst()) {
            do {
                int _id = c.getInt(0);
                String noidung = c.getString(1);
                String thoigian = c.getString(2);
                dulieu.add(_id + " " + noidung + " " + thoigian);

            } while (c.moveToNext());
        }
        return dulieu;
    }
}
