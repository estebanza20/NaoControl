package com.example.ezamoraa.naocontrol;

import com.aldebaran.qi.DynamicCallException;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;
import com.aldebaran.qi.helper.proxies.ALVideoDevice;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private static String TAG = "NaoControl";

    private Session session = null;
    private ALMotion motion;
    private ALTextToSpeech speech;
    private ALVideoDevice video;
    private OrientationManager orientation;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
    }

    public void onConnectHandler(View view) throws InterruptedException {
        EditText mEdit = findViewById(R.id.editIP);
        EditText EditPort = findViewById(R.id.editPort);
        EditText editSentences = findViewById(R.id.editText);
        Context context = getApplicationContext();
        String url = "tcp://" + mEdit.getText().toString() + ":" + EditPort.getText().toString();

        session = new Session();
        try {
            session.connect(url).sync();
        } catch (Exception e) {
            Toast toast = Toast.makeText(context, "Connection Error : " + e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        try {
            speech = new ALTextToSpeech(session);
            motion = new ALMotion(session);
            video = new ALVideoDevice(session);
            orientation = new OrientationManager(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        orientation.start();

        VideoStreamTask videoTask = null;
        HeadAnglesTask headAnglesTask = null;
        ImageView imgView = findViewById(R.id.vid_img_view);
        try {
            videoTask = new VideoStreamTask(imgView, video, motion, orientation);
            videoTask.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            headAnglesTask = new HeadAnglesTask(orientation, motion);
            //headAnglesTask.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            speech.say("Start");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Thread.sleep(50000);

        try {
            speech.say(editSentences.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Thread.sleep(50000);


        /*
        try {
            speech.say("Finish");
            videoTask.cancel(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        //Toast toast = Toast.makeText(context, "Done", Toast.LENGTH_SHORT);
        //toast.show();
    }

  /*
    boolean headAnglesActive = false;
    HeadAnglesTask headTask;

    public void onHeadAnglesButtonClick(View view) {
        Button button = findViewById(R.id.head_angles_button);

        String text;
        Integer bgColor, textColor;

        if (!headAnglesActive) {
            orientation.start();
            try {
                headTask = new HeadAnglesTask(orientation, motion);
                headTask.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

            text = getResources().getString(R.string.headAnglesOn);
            bgColor = getResources().getColor(R.color.md_green_700);
            textColor = getResources().getColor(R.color.md_text_white);
            headAnglesActive = true;
        } else {
            headTask.cancel(false);
            orientation.stop();

            text = getResources().getString(R.string.headAnglesOff);
            bgColor = getResources().getColor(R.color.md_red_700);
            textColor = getResources().getColor(R.color.md_text_white);
            headAnglesActive = false;
        }

        button.setText(text);
        button.setTextColor(textColor);
        button.setBackgroundColor(bgColor);
    }*/

}