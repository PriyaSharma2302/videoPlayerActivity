package com.example.correctexoplayer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;


import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;


import com.google.android.exoplayer2.ExoPlaybackException;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;

import com.google.android.exoplayer2.source.TrackGroupArray;

import com.google.android.exoplayer2.trackselection.TrackSelectionArray;

import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.StyledPlayerView;


public class MainActivity extends AppCompatActivity {
    PlayerView playerView;
    ProgressBar progressBar;
    ImageView pauseButton;
    ImageView playButton;
    SimpleExoPlayer simpleExoPlayer;
    LinearLayout location;
    boolean flag = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExoPlayer player= new ExoPlayer.Builder(this).build();

StyledPlayerView playerView;
        playerView = findViewById(R.id.video_view);

        pauseButton = findViewById(R.id.exo_pause);
        playButton = findViewById(R.id.exo_play);
        location = findViewById(R.id.location);
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);





        // LoadControl loadControl= new DefaultLoadControl();

        //  BandwidthMeter bandwidthMeter=  new DefaultBandwidthMeter();

        //   TrackSelector trackSelector= new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));


        //   simpleExoPlayer= ExoPlayerFactory.newSimpleInstance(MainActivity.this,trackSelector,loadControl);

        //   DefaultHttpDataSourceFactory factory= new DefaultHttpDataSourceFactory("exoplayer_video");

        //   ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();

        //  MediaSource mediaSource= new ExtractorMediaSource(videoUrl,factory,extractorsFactory,null,null);


//        playerView.setPlayer(simpleExoPlayer);
//        playerView.setKeepScreenOn(true);
//        simpleExoPlayer.prepare(mediaSource);
//        simpleExoPlayer.setPlayWhenReady(true);
//        playerView.setPlayer(player);
        playerView.setPlayer(player);
        MediaItem mediaItem = MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4");
        player.addMediaItem(mediaItem);
        player.prepare();
       playButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.setPlayWhenReady(true);
                pauseButton.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.GONE);
                location.setVisibility(View.GONE);

            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.setPlayWhenReady(false);
                pauseButton.setVisibility(View.GONE);
                playButton.setVisibility(View.VISIBLE);
                location.setVisibility(View.VISIBLE);


            }
        });
        player.play();
    }




}


