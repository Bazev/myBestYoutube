package com.example.mybestyoutube.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class VideoDbHelper extends SQLiteOpenHelper {

    private static final int VERSION = 2;
    private static final String DATABASE_NAME = "youtubeVideo_db";

    public static final String VIDEO_KEY = "id";
    public static final String VIDEO_TITLE = "title";
    public static final String VIDEO_DESCRIPTION = "description";
    public static final String VIDEO_CATEGORY = "category";
    public static final String VIDEO_URL = "url";
    public static final String VIDEO_TEXT_PICTURE_URL = "picture";
    public static final String VIDEO_TABLE_NAME = "youtubeVideo";

    public static final int VIDEO_KEY_COLUMN_INDEX = 0;
    public static final int VIDEO_TITLE_COLUMN_INDEX = 1;
    public static final int VIDEO_DESCRIPTION_COLUMN_INDEX = 2;
    public static final int VIDEO_CATEGORY_COLUMN_INDEX = 3;
    public static final int VIDEO_URL_COLUMN_INDEX = 4;
    public static final int VIDEO_TEXT_PICTURE_URL_COLUMN_INDEX = 5;

    private static final String VIDEO_TABLE_CREATE =
            "CREATE TABLE " + VIDEO_TABLE_NAME + " (" +
                    VIDEO_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    VIDEO_TITLE + " TEXT, " +
                    VIDEO_DESCRIPTION + " TEXT, " +
                    VIDEO_CATEGORY + " TEXT," +
                    VIDEO_URL + " TEXT, " +
                    VIDEO_TEXT_PICTURE_URL + " TEXT) ";

    private static final String VIDEO_TABLE_DROP = "DROP TABLE IF EXISTS " + VIDEO_TABLE_NAME + ";";

    public VideoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(VIDEO_TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(VIDEO_TABLE_DROP);
        onCreate(db);
    }
}
