package com.freed.movie_stree_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;

import java.util.List;

public class VideoPlayerActivity extends AppCompatActivity {

    private PlayerView exoVideoPlayer;
    private SimpleExoPlayer simpleExoPlayer;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        exoVideoPlayer = findViewById(R.id.exoVideoPlayer);
        progressBar = findViewById(R.id.progressBar);

        setUpExoPlayer(getIntent().getStringExtra("url"));

        simpleExoPlayer.addListener(new Player.Listener() {
            @Override
            public void onTimelineChanged(Timeline timeline, int reason) {

            }

            @Override
            public void onMediaItemTransition(@Nullable MediaItem mediaItem, int reason) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

            }

            @Override
            public void onIsLoadingChanged(boolean isLoading) {

            }

            @Override
            public void onAvailableCommandsChanged(Player.Commands availableCommands) {

            }

            @Override
            public void onPlaybackStateChanged(int playbackState) {

                if (playbackState == Player.STATE_BUFFERING) {

                    progressBar.setVisibility(View.VISIBLE);
                }
                else if (playbackState == Player.STATE_READY) {

                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {

            }

            @Override
            public void onPlaybackSuppressionReasonChanged(int playbackSuppressionReason) {

            }

            @Override
            public void onIsPlayingChanged(boolean isPlaying) {

            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {

            }

            @Override
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

            }

            @Override
            public void onPlayerError(PlaybackException error) {

            }

            @Override
            public void onPlayerErrorChanged(@Nullable PlaybackException error) {

            }

            @Override
            public void onPositionDiscontinuity(Player.PositionInfo oldPosition, Player.PositionInfo newPosition, int reason) {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

            }

            @Override
            public void onSeekForwardIncrementChanged(long seekForwardIncrementMs) {

            }

            @Override
            public void onSeekBackIncrementChanged(long seekBackIncrementMs) {

            }

            @Override
            public void onAudioSessionIdChanged(int audioSessionId) {

            }

            @Override
            public void onAudioAttributesChanged(AudioAttributes audioAttributes) {

            }

            @Override
            public void onVolumeChanged(float volume) {

            }

            @Override
            public void onSkipSilenceEnabledChanged(boolean skipSilenceEnabled) {

            }

            @Override
            public void onDeviceInfoChanged(DeviceInfo deviceInfo) {

            }

            @Override
            public void onDeviceVolumeChanged(int volume, boolean muted) {

            }

            @Override
            public void onEvents(Player player, Player.Events events) {

            }

            @Override
            public void onVideoSizeChanged(VideoSize videoSize) {

            }

            @Override
            public void onSurfaceSizeChanged(int width, int height) {

            }

            @Override
            public void onRenderedFirstFrame() {

            }

            @Override
            public void onCues(List<Cue> cues) {

            }

            @Override
            public void onMetadata(Metadata metadata) {

            }

            @Override
            public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {

            }

            @Override
            public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {

            }
        });
    }

    private void setUpExoPlayer(String fileUrl) {

        LoadControl loadControl = new DefaultLoadControl();

        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter.Builder(this).build();

        TrackSelector trackSelector = new DefaultTrackSelector(this);


        simpleExoPlayer = new SimpleExoPlayer.Builder(this)
                .setTrackSelector(trackSelector)
                .setBandwidthMeter(bandwidthMeter)
                .setLoadControl(loadControl).build();

        exoVideoPlayer.setPlayer(simpleExoPlayer);

        MediaItem mediaItem = MediaItem.fromUri(fileUrl);

        simpleExoPlayer.setMediaItem(mediaItem);
        simpleExoPlayer.prepare();
//        simpleExoPlayer.play();

        simpleExoPlayer.setPlayWhenReady(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        simpleExoPlayer.release();
    }
}