package com.example.mybestyoutube;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mybestyoutube.business.YoutubeVideo;
import com.example.mybestyoutube.dao.VideoDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddVideo extends AppCompatActivity {

    private EditText etTitle;
    private EditText etUrl;
    private EditText etDescription;
    private Spinner spCategory;
    private Button btnAdd;
    private YoutubeVideo youtubeVideo;
    private VideoDao videoDao;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_add);

        btnAdd = findViewById(R.id.btnAdd);
        etTitle = findViewById(R.id.etTitle);
        etUrl = findViewById(R.id.etUrl);
        etDescription = findViewById(R.id.etDescription);
        spCategory = findViewById(R.id.spVideo);
        context = getApplicationContext();
        videoDao = new VideoDao(context);

        Spinner spinner = (Spinner) findViewById(R.id.spVideo);
        String[] category = new String[] {
                "films et animations",
                "auto/moto",
                "musique",
                "animaux",
                "sport",
                "voyages et événements",
                "jeux vidéo",
                "people et blogs",
                "humour",
                "divertissement",
                "actualités et politique",
                "vie pratique et style",
                "education",
                "sciene et technologie",
                "associations et engagement",
        };

        final List<String> categoryList = new ArrayList<>(Arrays.asList(category));

        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(
                this, R.layout.spinner_item, categoryList);

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtubeVideo = new YoutubeVideo(etTitle.getText().toString(),
                        etDescription.getText().toString(),
                        etUrl.getText().toString(),spinner.getSelectedItem().toString(), null);
                finish();
                videoDao.add(youtubeVideo);
            }

        });
    }
}
