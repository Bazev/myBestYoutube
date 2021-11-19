package com.example.mybestyoutube;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mybestyoutube.business.YoutubeVideo;
import com.squareup.picasso.Picasso;
public class DetailActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvCategory;
    private TextView tvUrl;
    private TextView tvDescription;
    private Button btnShow;
    private ImageView imageView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        context = getApplicationContext();
        tvTitle = findViewById(R.id.tvTitleDetail);
        tvCategory = findViewById(R.id.tvCategoryDetail);
        tvUrl = findViewById(R.id.tvUrlDetail);
        tvDescription = findViewById(R.id.tvDescriptionDetail);
        btnShow = findViewById(R.id.btnShow);
        imageView = findViewById(R.id.ivPicture);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        YoutubeVideo youtubeVideo = (YoutubeVideo) intent.getSerializableExtra(MainActivity.KEY_VIDEO);

        Picasso.get().load(youtubeVideo.getUrlPicture()).into(imageView);
        tvTitle.setText(youtubeVideo.getTitle());
        tvCategory.setText(youtubeVideo.getCategory());
        tvUrl.setText(youtubeVideo.getUrl());
        tvDescription.setText(youtubeVideo.getDescription());

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = youtubeVideo.getUrl();
                System.out.println(id);
                watchYoutubeVideo(id);
            }
        });
    }

    public void watchYoutubeVideo(String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;

    }
}