package com.example.ezamoraa.naocontrol;


import android.os.AsyncTask;

import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;

import java.util.concurrent.ExecutionException;

public class MoveActionTask extends AsyncTask<String, Void, Boolean > {
    ALMotion motion;
    ALRobotPosture posture;

    public MoveActionTask(ALMotion motionProxy, ALRobotPosture postureProxy){
        motion = motionProxy;
        posture = postureProxy;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        try {
            switch(params[0]) {
                case "sitDown":
                    motion.rest();
                    break;
                case "standUp":
                    posture.goToPosture("Stand", 0.5f);
                    break;
                default:
                    return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

