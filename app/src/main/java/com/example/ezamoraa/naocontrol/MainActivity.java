package com.example.ezamoraa.naocontrol;

import com.aldebaran.qi.DynamicCallException;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private static String TAG = "NaoControl";

    private Session session = null;
    private ALMotion motion;
    private ALTextToSpeech speech;
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
            orientation = new OrientationManager(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true){
            HeadAnglesTask headTask = null;
            try {
                headTask = new HeadAnglesTask(orientation, motion);
                headTask.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                speech.say("Start");
            } catch (Exception e) {
                e.printStackTrace();
            }

            Thread.sleep(50);

            try {
                speech.say(editSentences.getText().toString());
                editSentences.setText("");
                editSentences.setHint("Enter sentences here");
            } catch (Exception e) {
                e.printStackTrace();
            }

            Thread.sleep(50);

            try {
                speech.say("Finish");
                headTask.cancel(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Toast toast = Toast.makeText(context, "Done", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}