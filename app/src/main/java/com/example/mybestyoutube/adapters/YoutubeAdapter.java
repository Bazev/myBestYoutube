package com.example.mybestyoutube.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybestyoutube.R;
import com.example.mybestyoutube.business.YoutubeVideo;

import java.util.List;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.YoutubeHolder> {

    public interface OnItemClickListener {
        void onItemClick(YoutubeVideo item);
    }

    private List<YoutubeVideo> youtubeVideoList;
    private final OnItemClickListener listener;

    public class YoutubeHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvCategory;

        public YoutubeHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvCategory = itemView.findViewById(R.id.tvCategory);
        }
    }

    public YoutubeAdapter(List<YoutubeVideo> youtubeVideoList, OnItemClickListener listener) {
        this.youtubeVideoList = youtubeVideoList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public YoutubeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.youtube_item, parent, false);
        return new YoutubeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeHolder holder, int position) {
        YoutubeVideo youtubeVideo = youtubeVideoList.get(position);
        holder.tvTitle.setText(youtubeVideo.getTitle());
        holder.tvCategory.setText(youtubeVideo.getCategory());

        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(youtubeVideo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }

}
