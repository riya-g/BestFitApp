package com.example.bestfit;

import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.support.v4.app.CoreComponentFactory;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class AboutUs extends YouTubeBaseActivity {

    YouTubePlayerView myouTubePlayerView;
    Button play;
    YouTubePlayer.OnInitializedListener monInitializedListener;

    private  int[] images = new int[]{
         R.drawable.dt2img,R.drawable.dietimg2,R.drawable.dt3img,R.drawable.dt4img,R.drawable.dt5img
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        CarouselView carouselView1 = findViewById(R.id.carouselView1);

        carouselView1.setPageCount(images.length);
        carouselView1.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(images[position]);
            }
        });

        play = (Button) findViewById(R.id.play);
        myouTubePlayerView = (YouTubePlayerView)findViewById(R.id.youTubePlay);
        monInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d("tag","On clicking initialize success.");
                youTubePlayer.loadPlaylist("PLvP8YsX0ebXY08XG7Gg9KFlnZNtlq8j7s");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("tag","On clicking initialize failure.");
            }
        };

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tag","On clicking initialize.");
                myouTubePlayerView.initialize(YouTubeConfig.getAPIKey(),monInitializedListener);
            }
        });
    }
}

