package com.gagum.firebaselogindansqlite.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.gagum.firebaselogindansqlite.model.Kontak;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteAssetHelper {
    private static final String DB_NAME = "dbKontak.db";
    private static final int DB_VER = 1;
    private static DBHelper instance;
    public static synchronized DBHelper getInstance(Context context){
        if (instance == null){
            instance = new DBHelper(context);
        }
        return instance;
    }
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    public List<Kontak> getAllKontak(){
        SQLiteDatabase db = instance.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM kontak LIMIT 4", null);
        List<Kontak> kontaks = new ArrayList<>();
        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                Kontak kontak = new Kontak(cursor.getInt(cursor.getColumnIndex("id_kontak")),
                        cursor.getString(cursor.getColumnIndex("nama")),
                        cursor.getInt(cursor.getColumnIndex("nomor")),
                        cursor.getString(cursor.getColumnIndex("alamat")));
                kontaks.add(kontak);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return kontaks;
    }
}
