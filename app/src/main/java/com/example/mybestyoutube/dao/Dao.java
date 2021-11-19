package com.example.mybestyoutube.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dao {

    protected SQLiteDatabase database = null;
    protected SQLiteOpenHelper sqLiteOpenHelper = null;

    public Dao(SQLiteOpenHelper sqLiteOpenHelper) {
        this.sqLiteOpenHelper = sqLiteOpenHelper;
    }

    public SQLiteDatabase open() {
        database = sqLiteOpenHelper.getReadableDatabase();
        return database;
    }

    public void close() {
        database.close();
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }
}
