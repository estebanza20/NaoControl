package com.example.ezamoraa.naocontrol;


import com.aldebaran.qi.DynamicCallException;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;
import com.aldebaran.qi.helper.proxies.ALVideoDevice;

import android.app.ProgressDialog;
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

import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends FragmentActivity
{
    private static String TAG = "NaoControl";

    private Session session = null;
    public ALMotion motionProxy;
    private ALTextToSpeech speechProxy;
    public ALRobotPosture postureProxy;
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
            headAnglesActive = false;
            videoStreamActive = false;

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
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
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

                setupWalkButtonsOnTouch();

                if (videoStreamActive) {
                    videoTask.cancel(false);
                    videoImg.setImageBitmap(null);
                    videoStreamActive = false;
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void showLogInWindow()
    {
        if (session != null) {
            Log.i(TAG, "showing LogIn fragment");
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
                if (((Button) findViewById(R.id.buttonConnect)).getText()
                        == getString(R.string.button_connect)) {
                    findViewById(R.id.back_control).setVisibility(View.INVISIBLE);
                } else {
                    findViewById(R.id.back_control).setVisibility(View.VISIBLE);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void showVideoWindow()
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

    public void setupWalkButtonsOnTouch()
    {
        Button rightButton = findViewById(R.id.button_right);
        Button leftButton = findViewById(R.id.button_left);
        Button upButton = findViewById(R.id.button_up);
        Button downButton = findViewById(R.id.button_down);

        try {
            rightButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        Log.v("Main", "Called right button onTouch DOWN");
                        v.setAlpha(0.5f);
                        new WalkTask(motionProxy).execute(0.0f, 0.0f, -0.2f);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP){
                        Log.v("Main", "Called right button onTouch UP");
                        v.setAlpha(1f);
                        new WalkTask(motionProxy).execute(0.0f, 0.0f, 0.0f);
                        return true;
                    }
                    return false;
                }
            });

            leftButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        Log.v("Main", "Called left button onTouch DOWN");
                        new WalkTask(motionProxy).execute(0.0f, 0.0f, 0.2f);
                        v.setAlpha(0.5f);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP){
                        Log.v("Main", "Called left button onTouch UP");
                        new WalkTask(motionProxy).execute(0.0f, 0.0f, 0.0f);
                        v.setAlpha(1f);
                        return true;
                    }
                    return false;
                }
            });

            upButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        Log.v("Main", "Called up button onTouch DOWN");
                        new WalkTask(motionProxy).execute(0.2f, 0.0f, 0.0f);
                        v.setAlpha(0.5f);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP){
                        Log.v("Main", "Called up button onTouch UP");
                        new WalkTask(motionProxy).execute(0.0f, 0.0f, 0.0f);
                        v.setAlpha(1f);
                        return true;
                    }
                    return false;
                }
            });

            downButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        Log.v("Main", "Called down button onTouch DOWN");
                        new WalkTask(motionProxy).execute(-0.2f, 0.0f, 0.0f);
                        v.setAlpha(0.5f);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP){
                        Log.v("Main", "Called down button onTouch UP");
                        new WalkTask(motionProxy).execute(0.0f, 0.0f, 0.0f);
                        v.setAlpha(1f);
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onDisconnected(String message){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (videoStreamActive) {
                    videoStreamActive = false;
                    if (videoTask != null && !videoTask.isCancelled())
                        videoTask.cancel(true);
                }
                if (headTask != null && !headTask.isCancelled()) {
                    headTask.cancel(true);
                    headAnglesActive = false;
                    setHeadButtonStyle(false);
                }

                if (orientation != null && orientation.isRunning())
                    orientation.stop();

                ((Button) findViewById(R.id.buttonConnect)).setText(getString(R.string.button_connect));
                showLogInWindow();
                Toast.makeText(getApplicationContext(), getString(R.string.disconnect), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onConnectButtonClick(View view)
    {
        EditText editIp = findViewById(R.id.editTextIp);
        EditText editPort = findViewById(R.id.editTextPort);
        Context context = getApplicationContext();
        String url = "tcp://" + editIp.getText().toString() + ":" + editPort.getText().toString();
        try {
            if (((Button) findViewById(R.id.buttonConnect)).getText() == getString(R.string.button_connect)) {
                session = new Session();
                ConnectionTask connectionTask = new ConnectionTask();
                connectionTask.execute(url);
            } else {
                if (session != null && session.isConnected())
                    session.close();
            }
        } catch (Exception e) {
            Toast toast = Toast.makeText(context, "Connection Error : " + e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private class ConnectionTask extends AsyncTask<String, Void, Session> {

        private ProgressDialog dialog;

        public ConnectionTask(){
            dialog = new ProgressDialog(MainActivity.this);
        }

        @Override
        protected void onPreExecute() {
            this.dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            this.dialog.setMessage("Trying to connect...");
            this.dialog.show();
        }

        @Override
        protected Session doInBackground(String... url) {
            try {
                System.out.println(url[0]);
                session.connect(url[0]).sync();
                session.onDisconnected("onDisconnected", MainActivity.this);
                return session;
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Session retSession) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            if (retSession != null && retSession.isConnected()){
                try {
                    speechProxy = new ALTextToSpeech(retSession);
                    motionProxy = new ALMotion(retSession);
                    postureProxy = new ALRobotPosture(retSession);
                    videoProxy = new ALVideoDevice(retSession);

                    ((Button) findViewById(R.id.buttonConnect)).setText(getString(R.string.button_disconnect));
                    showControlWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast toast = Toast.makeText(MainActivity.this, "Connection Error", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    public void onControlBackButtonClick(View view) {
        showLogInWindow();
    }

    public void onConnectControlButtonClick(View view) {
        showControlWindow();
    }

    public void onVideoBackButtonClick(View view) {
        showControlWindow();
    }

    public void onControlVideoButtonClick(View view) {
        showVideoWindow();
    }

    public void onStandUpButtonClick(View view) {
        try {
            new MoveActionTask(motionProxy, postureProxy).execute("standUp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onSitDownButtonClick(View view) {
        try {
            new MoveActionTask(motionProxy, postureProxy).execute("sitDown");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHeadButtonStyle(Boolean setOn) {
        Button button1 = findViewById(R.id.button_control_head);
        Button button2 = findViewById(R.id.button_video_head);
        String text;
        Integer bgColor, textColor;

        if (setOn) {
            text = getResources().getString(R.string.head_control_on);
            bgColor = getResources().getColor(R.color.md_green_700);
            textColor = getResources().getColor(R.color.md_text_white);
        } else {
            text = getResources().getString(R.string.head_control_off);
            bgColor = getResources().getColor(R.color.md_red_300);
            textColor = getResources().getColor(R.color.md_text_white);
        }

        button1.setText(text);
        button1.setTextColor(textColor);
        button1.setBackgroundColor(bgColor);

        button2.setText(text);
        button2.setTextColor(textColor);
        button2.setBackgroundColor(bgColor);
    }

    public void onHeadAnglesButtonClick(View view) {
        if (!headAnglesActive) {
            orientation.start();
            try {
                headTask = new HeadAnglesTask(orientation, motionProxy, sessionLock);
                headTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            } catch (Exception e) {
                e.printStackTrace();
            }
            headAnglesActive = true;
        } else {
            headTask.cancel(false);
            orientation.stop();
            headAnglesActive = false;
        }

        setHeadButtonStyle(headAnglesActive);
    }

    public void onSpeakButtonClick(View view)
    {
        EditText newMessage = findViewById(R.id.editTextSpeak);
        String message = newMessage.getText().toString();
        try {
            new SpeakTask(speechProxy).execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


