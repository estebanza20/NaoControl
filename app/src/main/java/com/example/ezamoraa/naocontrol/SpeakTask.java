package com.example.ezamoraa.naocontrol;

import android.os.AsyncTask;

import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class SpeakTask extends AsyncTask<String, Void, Boolean> {
    ALTextToSpeech speech;

    public SpeakTask(ALTextToSpeech speechProxy){
        speech = speechProxy;
    }
    @Override
    protected Boolean doInBackground(String... params) {
        try {
            speech.say(params[0]);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}