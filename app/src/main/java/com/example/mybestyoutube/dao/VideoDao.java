package com.example.mybestyoutube.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.example.mybestyoutube.business.YoutubeVideo;
import com.example.mybestyoutube.database.VideoDbHelper;

import java.util.ArrayList;
import java.util.List;

public class VideoDao extends Dao {

    public VideoDao(Context context) {
        super(new VideoDbHelper(context));
    }

    public YoutubeVideo find(int id) {
        YoutubeVideo youtubeVideo = null;
        open();
        Cursor cursor = database.rawQuery("select * from " + VideoDbHelper.VIDEO_TABLE_NAME +
                        " WHERE " + VideoDbHelper.VIDEO_KEY + " = ?",
                new String[]{String.valueOf(id)});

        if (cursor != null && cursor.moveToFirst()) {
            youtubeVideo = new YoutubeVideo();
            youtubeVideo.setId(cursor.getLong(VideoDbHelper.VIDEO_KEY_COLUMN_INDEX));
            youtubeVideo.setCategory(cursor.getString(VideoDbHelper.VIDEO_CATEGORY_COLUMN_INDEX));
            youtubeVideo.setTitle(cursor.getString(VideoDbHelper.VIDEO_TITLE_COLUMN_INDEX));
            youtubeVideo.setDescription(cursor.getString(VideoDbHelper.VIDEO_DESCRIPTION_COLUMN_INDEX));
            youtubeVideo.setUrl(cursor.getString(VideoDbHelper.VIDEO_URL_COLUMN_INDEX));
            youtubeVideo.setUrl(cursor.getString(VideoDbHelper.VIDEO_TEXT_PICTURE_URL_COLUMN_INDEX));
            cursor.close();
        }
        close();
        return youtubeVideo;
    }

    public List<YoutubeVideo> list() {
        List<YoutubeVideo> youtubeVideoList = new ArrayList<>();
        open();
        Cursor cursor = database.rawQuery("select * from " +  VideoDbHelper.VIDEO_TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                YoutubeVideo youtubeVideo = new YoutubeVideo();
                youtubeVideo.setId(cursor.getLong(VideoDbHelper.VIDEO_KEY_COLUMN_INDEX));
                youtubeVideo.setCategory(cursor.getString(VideoDbHelper.VIDEO_CATEGORY_COLUMN_INDEX));
                youtubeVideo.setTitle(cursor.getString(VideoDbHelper.VIDEO_TITLE_COLUMN_INDEX));
                youtubeVideo.setDescription(cursor.getString(VideoDbHelper.VIDEO_DESCRIPTION_COLUMN_INDEX));
                youtubeVideo.setUrl(cursor.getString(VideoDbHelper.VIDEO_URL_COLUMN_INDEX));
                youtubeVideo.setUrlPicture(cursor.getString(VideoDbHelper.VIDEO_TEXT_PICTURE_URL_COLUMN_INDEX));

                youtubeVideoList.add(youtubeVideo);
                cursor.moveToNext();
            }
            cursor.close();
        }
        close();
        return youtubeVideoList;
    }

    public void add(YoutubeVideo youtubeVideo) {
        open();
        ContentValues values = new ContentValues();
        values.put(VideoDbHelper.VIDEO_TITLE, youtubeVideo.getTitle());
        values.put(VideoDbHelper.VIDEO_CATEGORY, youtubeVideo.getCategory());
        values.put(VideoDbHelper.VIDEO_URL, youtubeVideo.getUrl());
        values.put(VideoDbHelper.VIDEO_DESCRIPTION, youtubeVideo.getDescription());
        values.put(VideoDbHelper.VIDEO_TEXT_PICTURE_URL, youtubeVideo.getUrlPicture());
        long id = database.insert(VideoDbHelper.VIDEO_TABLE_NAME, null, values);
        youtubeVideo.setId(id);
        close();
    }

    public void update(YoutubeVideo youtubeVideo) {
        open();
        ContentValues values = new ContentValues();
        values.put(VideoDbHelper.VIDEO_TITLE, youtubeVideo.getTitle());
        values.put(VideoDbHelper.VIDEO_CATEGORY, youtubeVideo.getCategory());
        values.put(VideoDbHelper.VIDEO_URL, youtubeVideo.getUrl());
        values.put(VideoDbHelper.VIDEO_DESCRIPTION, youtubeVideo.getDescription());
        values.put(VideoDbHelper.VIDEO_TEXT_PICTURE_URL, youtubeVideo.getUrlPicture());

        database.update(VideoDbHelper.VIDEO_TABLE_NAME, values, VideoDbHelper.VIDEO_KEY + " = ? ",
                new String[]{String.valueOf(youtubeVideo.getId())});
        close();
    }

    public void delete(YoutubeVideo youtubeVideo) {
        open();
        database.delete(VideoDbHelper.VIDEO_TABLE_NAME, VideoDbHelper.VIDEO_KEY + " = ? ",
                new String[] {String.valueOf(youtubeVideo.getId())});
        close();
    }


}
