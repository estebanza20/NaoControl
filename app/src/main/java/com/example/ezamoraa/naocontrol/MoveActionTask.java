package com.example.ezamoraa.naocontrol;


import android.os.AsyncTask;

import com.aldebaran.qi.helper.proxies.ALMotion;

import java.util.concurrent.ExecutionException;

public class MoveActionTask extends AsyncTask<String, Void, Boolean > {
    ALMotion motion;

    public MoveActionTask(ALMotion motionProxy){
        motion = motionProxy;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        try {
            switch(params[0]) {
                case "sitDown":
                    motion.rest();
                    break;
                case "standUp":
                    motion.wakeUp();
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

