package com.example.ezamoraa.naocontrol;

import android.os.AsyncTask;

import com.aldebaran.qi.helper.proxies.ALMotion;

import java.util.concurrent.ExecutionException;

public class WalkTask extends AsyncTask<Float, Void, Boolean > {
    ALMotion motion;

    public WalkTask(ALMotion motion){
        this.motion = motion;
    }

    @Override
    protected Boolean doInBackground(Float... params) {
        float Xmovement = params[0];
        float Ymovement = params[1];
        try {
            this.motion.moveToward(Xmovement, Ymovement, 0f);
            return true;
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }
}
