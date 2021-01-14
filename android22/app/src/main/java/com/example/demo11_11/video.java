package com.example.demo11_11;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.demo11_11.chitietphim.chitietphimMain;

public class video extends AppCompatActivity {
    Button button;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

         button=(Button)findViewById(R.id.idBatDau);
        videoView=(VideoView)findViewById(R.id.videoView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.GONE);
                videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.phim_rom));
                videoView.start();
                MediaController mediaController=new MediaController(video.this);
                mediaController.setMediaPlayer(videoView);
                videoView.setMediaController(mediaController);
            }

        });

    }

    public void tv(View view) {

            Intent intent = new Intent(video.this, chitietphimMain.class);
            startActivity(intent);

    }


}