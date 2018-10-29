package com.example.ezamoraa.naocontrol;


import com.aldebaran.qi.DynamicCallException;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;
import com.aldebaran.qi.helper.proxies.ALVideoDevice;

import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends FragmentActivity
{
    private static String TAG = "NaoControl";

    private Session session = null;
    public ALMotion motionProxy;
    private ALTextToSpeech speechProxy;
    private ALVideoDevice videoProxy;

    ImageView videoImg;

    private OrientationManager orientation;
    private HeadAnglesTask headTask;
    private VideoStreamTask videoTask;

    private LogInFragment logIn = new LogInFragment();
    private ControlFragment control = new ControlFragment();
    private VideoFragment video = new VideoFragment();

    private boolean headAnglesActive = false;
    private boolean videoStreamActive = false;

    private ReentrantLock sessionLock;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
        if (savedInstanceState == null) {
            orientation = new OrientationManager(this);
            sessionLock = new ReentrantLock();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.allLayout, this.control)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.allLayout, this.logIn)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.allLayout, this.video)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .hide(this.control)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .hide(this.video)
                    .commit();
            configureMoveButtons();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public void Connect(View view)
    {
        EditText editIp = findViewById(R.id.editTextIp);
        EditText editPort = findViewById(R.id.editTextPort);
        Context context = getApplicationContext();
        String url = "tcp://" + editIp.getText().toString() + ":" + editPort.getText().toString();
        session = new Session();
        try
        {
            if (((Button) findViewById(R.id.buttonConnect)).getText() == getString(R.string.button_connect)) {
                session.connect(url).sync();

                speechProxy = new ALTextToSpeech(session);
                motionProxy = new ALMotion(session);
                videoProxy = new ALVideoDevice(session);

                ((Button) findViewById(R.id.buttonConnect)).setText(getString(R.string.button_disconnect));
                this.showControlWindow();
            } else {

            }
        } catch (Exception e) {
            Toast toast = Toast.makeText(context, "Connection Error : " + e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
    }

    public void speakTask(View view)
    {
        EditText newMessage = findViewById(R.id.editTextSpeak);
        try {
            speechProxy.say(newMessage.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void configureMoveButtons()
    {
        Button rightButton = findViewById(R.id.button_right);
        Button leftButton = findViewById(R.id.button_left);
        Button upButton = findViewById(R.id.button_up);
        Button downButton = findViewById(R.id.button_down);
        Button sitButton = findViewById(R.id.sitButton);
        Button standUpButton = findViewById(R.id.standUpButton);

        try {
            motionProxy.wakeUp();

            rightButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP){
                        new WalkTask(motionProxy).execute(0.0f,-0.2f);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_DOWN){
                        new WalkTask(motionProxy).execute(0.0f,0.0f);
                        return true;
                    }
                    return false;
                }
            });

            leftButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP){
                        new WalkTask(motionProxy).execute(0.0f,0.2f);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_DOWN){
                        new WalkTask(motionProxy).execute(0.0f,0.0f);
                        return true;
                    }
                    return false;
                }
            });

            upButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP){
                        new WalkTask(motionProxy).execute(0.2f, 0.0f);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_DOWN){
                        new WalkTask(motionProxy).execute(0.0f, 0.0f);
                        return true;
                    }
                    return false;
                }
            });

            downButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP){
                        new WalkTask(motionProxy).execute(-0.2f, 0.0f);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_DOWN){
                        new WalkTask(motionProxy).execute(0.0f, 0.0f);
                        return true;
                    }
                    return false;
                }
            });

            standUpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        motionProxy.wakeUp();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });

            sitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        motionProxy.rest();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static class LogInFragment extends Fragment {

        public LogInFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.connectfragment, container, false);
            return rootView;
        }
    }

    public static class ControlFragment extends Fragment {

        public ControlFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.controlfragment, container, false);
            return rootView;
        }
    }

    public static class VideoFragment extends Fragment {

        public VideoFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.videofragment, container, false);
            return rootView;
        }
    }

    public void BackControlWindow(View view) {
        Log.v("Main", "Call back control window");
        if (((Button) findViewById(R.id.buttonConnect)).getText() == getString(R.string.button_disconnect)) {
            if (videoStreamActive) {
                videoTask.cancel(false);
                videoImg.setImageBitmap(null);
                videoStreamActive = false;
            }

            this.showControlWindow();
        }
    }

    public void showControlWindow(){
        if (session != null) {
            Log.i(TAG, "showing control fragment");
            try {
                getSupportFragmentManager().beginTransaction()
                        .hide(this.logIn)
                        .commit();
                getSupportFragmentManager().beginTransaction()
                        .hide(this.video)
                        .commit();
                getSupportFragmentManager().beginTransaction()
                        .show(this.control)
                        .commit();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void showLogInWindow(View view)
    {
        if (session != null) {
            Log.i(TAG, "showing video fragment");
            try {
                getSupportFragmentManager().beginTransaction()
                        .hide(this.control)
                        .commit();
                getSupportFragmentManager().beginTransaction()
                        .hide(this.video)
                        .commit();
                getSupportFragmentManager().beginTransaction()
                        .show(this.logIn)
                        .commit();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void showVideoWindow(View view)
    {
        if (session != null) {
            Log.i(TAG, "showing video fragment");
            try {
                getSupportFragmentManager().beginTransaction()
                        .hide(this.control)
                        .commit();
                getSupportFragmentManager().beginTransaction()
                        .hide(this.logIn)
                        .commit();
                getSupportFragmentManager().beginTransaction()
                        .show(this.video)
                        .commit();

                videoImg = findViewById(R.id.video_image);
                videoTask = new VideoStreamTask(videoImg, videoProxy, motionProxy, orientation, sessionLock);
                videoStreamActive = true;
                videoTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void onHeadAnglesButtonClick(View view) {
        Button button1 = findViewById(R.id.button_control_head);
        Button button2 = findViewById(R.id.button_video_head);
        String text;
        Integer bgColor, textColor;
        if (!headAnglesActive) {
            orientation.start();
            try {
                headTask = new HeadAnglesTask(orientation, motionProxy, sessionLock);
                headTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text = getResources().getString(R.string.head_control_on);
            bgColor = getResources().getColor(R.color.md_green_700);
            textColor = getResources().getColor(R.color.md_text_white);
            headAnglesActive = true;
        } else {
            headTask.cancel(false);
            orientation.stop();
            text = getResources().getString(R.string.head_control_off);
            bgColor = getResources().getColor(R.color.md_red_700);
            textColor = getResources().getColor(R.color.md_text_white);
            headAnglesActive = false;
        }

        button1.setText(text);
        button1.setTextColor(textColor);
        button1.setBackgroundColor(bgColor);

        button2.setText(text);
        button2.setTextColor(textColor);
        button2.setBackgroundColor(bgColor);
    }
}