package com.example.ezamoraa.naocontrol;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.aldebaran.qi.helper.proxies.ALMotion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class HeadAnglesTask extends AsyncTask<Void, Void, Void> {
    private ALMotion motion;
    private OrientationManager orientation;
    private static final int SLEEP_MS = 100;

    public HeadAnglesTask(OrientationManager orientation, ALMotion motion){
        this.motion = motion;
        this.orientation = orientation;
    }

    @Override
    protected Void doInBackground(Void... params) {
        List<String> names = new ArrayList<>();
        names.add("HeadYaw");
        names.add("HeadPitch");

        List<Float> angles = new ArrayList<>();
        angles.add(0f);
        angles.add(0f);

        List<Float> array = new ArrayList <>();
        array.add(1.0f);
        array.add(1.0f);

        while(!this.isCancelled()) {
            try {
                angles.set(0, orientation.filteredYaw);
                angles.set(1, orientation.filteredPitch);
                Log.v("HeadAngles", "pitch:" + Float.toString(orientation.filteredPitch));
                Log.v("HeadAngles", "yaw:" + Float.toString(orientation.filteredYaw));
                this.motion.setStiffnesses(names, array);
                this.motion.setAngles(names, angles, 0.5f);
                Thread.sleep(SLEEP_MS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}

