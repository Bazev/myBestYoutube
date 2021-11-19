package com.example.mybestyoutube;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mybestyoutube.adapters.YoutubeAdapter;
import com.example.mybestyoutube.business.YoutubeVideo;
import com.example.mybestyoutube.dao.VideoDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;
    public YoutubeAdapter youtubeAdapter;
    private VideoDao videoDao;

    public static final String KEY_VIDEO = "youtubeVideo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_main);

        context = getApplicationContext();
        recyclerView = findViewById(R.id.rvYoutube);
        videoDao = new VideoDao(context);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        YoutubeAsyncTasks youtubeAsyncTasks = new YoutubeAsyncTasks();
        youtubeAsyncTasks.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuYoutube:
                Intent intent = new Intent(context, AddVideo.class);
                startActivity(intent);
                return true;
            case R.id.menuPlaylist:
                Intent intentPl = new Intent(context, Playlist.class);
                startActivity(intentPl);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class YoutubeAsyncTasks extends AsyncTask<Nullable, Nullable, List<YoutubeVideo>> {

        @Override
        protected List<YoutubeVideo> doInBackground(Nullable... nullables) {

            List<YoutubeVideo> responseYoutubeVideo = new ArrayList<>();
            try {
                responseYoutubeVideo = videoDao.list();
            }catch (Exception exception) {
                exception.printStackTrace();
            }
            return responseYoutubeVideo;
        }

        @Override
        protected void onPostExecute(List<YoutubeVideo> youtubeVideoList) {

            youtubeAdapter = new YoutubeAdapter(youtubeVideoList, new YoutubeAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(YoutubeVideo item) {
                    Intent intent = new Intent(context, DetailActivity.class );
                    intent.putExtra(KEY_VIDEO, item);
                    startActivity(intent);
                }
            });
            recyclerView.setAdapter(youtubeAdapter);
        }
    }
}