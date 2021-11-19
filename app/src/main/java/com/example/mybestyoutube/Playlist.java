package com.example.mybestyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mybestyoutube.business.YoutubeItemPlaylist;
import com.example.mybestyoutube.business.YoutubeItemSnippet;
import com.example.mybestyoutube.business.YoutubeItemSnippetThumbnail;
import com.example.mybestyoutube.business.YoutubePlaylist;
import com.example.mybestyoutube.business.YoutubeVideo;
import com.example.mybestyoutube.dao.VideoDao;
import com.example.mybestyoutube.service.YoutubePlaylistService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Playlist extends AppCompatActivity {

    private Button btnAddPlaylist;
    private Button btnCancelPlaylist;
    private EditText etPlaylistId;
    private VideoDao videoDao;
    private Context context;
    YoutubePlaylist youtubePlaylist = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        btnAddPlaylist = findViewById(R.id.btnAddPlaylist);
        btnCancelPlaylist = findViewById(R.id.btnCancelPLaylist);
        etPlaylistId = findViewById(R.id.etPlaylistId);
        context = getApplicationContext();
        videoDao = new VideoDao(context);

        btnAddPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idPlaylit = etPlaylistId.getText().toString();
                YoutubePlaylistService youtubePlaylistService = new Retrofit.Builder()
                        .baseUrl(YoutubePlaylistService.ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(YoutubePlaylistService.class);
                youtubePlaylistService.getYoutubePlaylists(
                        YoutubePlaylistService.API_KEY,
                        "snippet,contentDetails",
                        idPlaylit,
                        20).enqueue(new Callback<YoutubePlaylist>() {
                    @Override
                    public void onResponse(Call<YoutubePlaylist> call, Response<YoutubePlaylist> response) {
                        youtubePlaylist = response.body();

                        for (YoutubeItemPlaylist item : youtubePlaylist.getItems()) {
                            YoutubeVideo youtubeVideo = new YoutubeVideo();

                            youtubeVideo.setDescription(item.getSnippet().getDescription());
                            youtubeVideo.setTitle(item.getSnippet().getTitle());
                            youtubeVideo.setUrl(item.getContentDetails().getVideoId());
                            youtubeVideo.setCategory("");
                            youtubeVideo.setUrlPicture(item.getSnippet().getThumbnails().get("default").getUrl());

                            videoDao.add(youtubeVideo);

                        }
                    }

                    @Override
                    public void onFailure(Call<YoutubePlaylist> call, Throwable t) {

                    }
                });
            }
        });

    }


}