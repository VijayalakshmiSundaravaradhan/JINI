package com.example.vijayalakshmi.jini;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.PowerManager;
import android.os.ResultReceiver;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    protected PowerManager.WakeLock mWakeLock;
    ImageButton mHelpButton;
    Button mTrustedContactsButton;
    Button mNightModeButton;

//    MediaSessionCompat mediaSessionCompat;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
        this.mWakeLock.acquire();

        mHelpButton = findViewById(R.id.help_button);
        mTrustedContactsButton = findViewById(R.id.trusted_contacts_button);
        mNightModeButton = findViewById(R.id.night_mode_button);

        mHelpButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ConstraintLayout.LayoutParams buttonParams = (ConstraintLayout.LayoutParams) v.getLayoutParams();
                        buttonParams.width = (int) TypedValue.applyDimension(
                                TypedValue.COMPLEX_UNIT_DIP, 170, getResources()
                                        .getDisplayMetrics());
                        buttonParams.height = (int) TypedValue.applyDimension(
                                TypedValue.COMPLEX_UNIT_DIP, 170, getResources()
                                        .getDisplayMetrics());
                        v.setLayoutParams(buttonParams);
//                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        ConstraintLayout.LayoutParams buttonParams = (ConstraintLayout.LayoutParams) v.getLayoutParams();
                        buttonParams.width = (int) TypedValue.applyDimension(
                                TypedValue.COMPLEX_UNIT_DIP, 200, getResources()
                                        .getDisplayMetrics());
                        buttonParams.height = (int) TypedValue.applyDimension(
                                TypedValue.COMPLEX_UNIT_DIP, 200, getResources()
                                        .getDisplayMetrics());
                        v.setLayoutParams(buttonParams);
//                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });


//        mHelpButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }


    @Override
    public void onDestroy() {
        this.mWakeLock.release();
        super.onDestroy();
    }

    @Override
    public void onResume(){
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause(){
        Log.d(TAG, "onPause");
        super.onPause();
    }


    @Override
    public void onStop(){
        Log.d(TAG, "onStop");
        super.onStop();
    }
    @Override
    public void onStart(){
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)){
            //Do something
            Log.d(TAG,"Volume down pressed");
        }
        return true;
    }

//    void initMediaSession() {
//        // NOTE: all this is so that when you press pause/play in the app, we can capture the
//        // media control event, so that other apps DON'T (ie, google play music, plex, etc).
//        // ideally we could do something useful with this, but for not, just eat it.
//
//        try {
//            ComponentName mediaButtonReceiver = new ComponentName(getApplicationContext(), MediaButtonReceiver.class);
//            mediaSessionCompat = new MediaSessionCompat(getApplicationContext(), "SAGETVMINICLIENT", mediaButtonReceiver, null);
//            mediaSessionCompat.setCallback(new MediaSessionCompat.Callback() {
//                @Override
//                public void onCommand(String command, Bundle extras, ResultReceiver cb) {
//                    log.debug("Audio Session Callback Handler: Command {}", command);
//                }
//            });
//            mediaSessionCompat.setFlags(MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS);
//
//            Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
//            mediaButtonIntent.setClass(this, MediaButtonReceiver.class);
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, mediaButtonIntent, 0);
//            mediaSessionCompat.setMediaButtonReceiver(pendingIntent);
//            mediaSessionCompat.setActive(true);
//            log.debug("Media Session is setup to capture pause/play. session: "+mediaSessionCompat.getSessionToken());
//        } catch (Throwable t) {
//            log.error("Failed to capture the media session", t);
//        }
//    }
}
