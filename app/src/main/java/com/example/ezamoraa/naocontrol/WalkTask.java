package com.example.ezamoraa.naocontrol;

import android.os.AsyncTask;

import com.aldebaran.qi.helper.proxies.ALMotion;

import java.util.concurrent.ExecutionException;

public class WalkTask extends AsyncTask<Float, Void, Boolean > {
    ALMotion motion;

    public WalkTask(ALMotion motionProxy){
        motion = motionProxy;
    }

    @Override
    protected Boolean doInBackground(Float... params) {
        float Xmovement = params[0];
        float Ymovement = params[1];
        float Amovement = params[2];
        try {
            motion.moveToward(Xmovement, Ymovement, Amovement);
            return true;
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }
}

