package com.example.ezamoraa.naocontrol;

import android.os.AsyncTask;
import com.aldebaran.qi.helper.proxies.ALMotion;

import java.util.ArrayList;
import java.util.List;

public class HeadAnglesTask extends AsyncTask<Void, Void, Void> {
    private ALMotion motion;
    private static final int SLEEP_MS = 100;

    public HeadAnglesTask(ALMotion motion){
        this.motion = motion;
    }

    @Override
    protected Void doInBackground(Void... params) {
        List<String> names = new ArrayList<>();
        names.add("HeadYaw");
        names.add("HeadPitch");

        List<Float> angles = new ArrayList<>();
        angles.add(0f);
        angles.add(0f);

        int i = 0;
        float step = 0.01f;

        while(!this.isCancelled()) {
            try {
                if (step > 0) {
                    if (angles.get(0) < 1.5f) {
                        angles.set(0, angles.get(0)+step*i);
                    } else {
                        step *= -1;
                        i = 0;
                    }
                } else {
                    if (angles.get(0) > -1.5f) {
                        angles.set(0, angles.get(0)+step*i);
                    } else {
                        step *= -1;
                        i = 0;
                    }
                }
                i++;
                this.motion.setAngles(names, angles, 0.5f);
                Thread.sleep(SLEEP_MS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
