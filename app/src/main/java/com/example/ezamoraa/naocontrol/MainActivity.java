package com.example.ezamoraa.naocontrol;


import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import java.util.concurrent.ExecutionException;

public class MainActivity extends FragmentActivity
{
    private static String TAG = "NaoControl";

    private Session session = null;
    private ALMotion motion;
    private ALTextToSpeech speech;
    private OrientationManager orientation;


    private LogInFragment logIn = new LogInFragment();
    private ControlFragment control = new ControlFragment();
    private VideoFragment video = new VideoFragment();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        this.setListeners();
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
        if (savedInstanceState == null) {
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

    public void ConnectActivity(View view)
    {
        EditText editIp = findViewById(R.id.editTextIp);
        EditText editPort = findViewById(R.id.editTextPort);
        Context context = getApplicationContext();
        String url = "tcp://" + editIp.getText().toString() + ":" + editPort.getText().toString();
        session = new Session();
        try
        {
            if (((Button) findViewById(R.id.buttonConnect)).getText() == getString(R.string.button_connect)) {
                //session.connect(url).sync();
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
            speech = new ALTextToSpeech(session);
            speech.say(newMessage.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setListeners()
    {
        Button rightButton = findViewById(R.id.button_right);
        Button leftButton = findViewById(R.id.button_left);
        Button upButton = findViewById(R.id.button_up);
        Button downButton = findViewById(R.id.button_down);
        Button sitButton = findViewById(R.id.sitButton);
        Button standUpButton = findViewById(R.id.standUpButton);

        try {

            motion = new ALMotion(session);
            motion.wakeUp(); //robot will wake up and go to initial position
            rightButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP){
                        try {
                            motion.moveToward(0.0f,-0.2f,0.0f);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_DOWN){
                        try {
                            motion.moveToward(0.0f, 0.0f, 0.0f);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    return false;
                }
            });
            leftButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP){
                        try {
                            motion.moveToward(0.0f,0.2f,0.0f);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_DOWN){
                        try {
                            motion.moveToward(0.0f, 0.0f, 0.0f);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    return false;
                }
            });
            upButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP){
                        try {
                            motion.moveToward(0.2f,0.0f,0.0f);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_DOWN){
                        try {
                            motion.moveToward(0.0f, 0.0f, 0.0f);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    return false;
                }
            });
            downButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP){
                        try {
                            motion.moveToward(-0.2f,0.0f,0.0f);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_DOWN){
                        try {
                            motion.moveToward(0.0f, 0.0f, 0.0f);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    return false;
                }
            });
            standUpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        motion.wakeUp(); //robot will wake up and go to initial position
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });

            sitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        motion.rest();//The robot will rest and go to a relax and safe position
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
        if (((Button) findViewById(R.id.buttonConnect)).getText() == getString(R.string.button_disconnect)) {
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
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}