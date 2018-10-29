package com.example.ezamoraa.naocontrol;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.aldebaran.qi.helper.proxies.ALMotion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class HeadAnglesTask extends AsyncTask<Void, Void, Void> {
    private ALMotion motion;
    private OrientationManager orientation;
    private static final int SLEEP_MS = 50;
    private ReentrantLock sLock;

    public HeadAnglesTask(OrientationManager orientationManager,
                          ALMotion motionProxy,
                          ReentrantLock sessionLock){
        motion = motionProxy;
        orientation = orientationManager;
        sLock = sessionLock;
    }

    @Override
    protected Void doInBackground(Void... params) {
        List<String> names = new ArrayList<>();
        names.add("HeadYaw");
        names.add("HeadPitch");

        List<Float> angles = new ArrayList<>();
        angles.add(0f);
        angles.add(0f);

        List<Float> stiffness = new ArrayList<>();
        stiffness.add(1f);
        stiffness.add(1f);

        sLock.lock();
        try {
            motion.setStiffnesses(names, stiffness);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sLock.unlock();
        }

        while(!this.isCancelled()) {
            try {
                angles.set(0, orientation.yaw);
                angles.set(1, orientation.pitch);
                Log.v("HeadAngles", "pitch:" + Float.toString(orientation.pitch));
                Log.v("HeadAngles", "yaw:" + Float.toString(orientation.yaw));
                sLock.lock();
                try {
                    motion.setAngles(names, angles, 0.8f);
                } finally {
                    sLock.unlock();
                }
                Thread.sleep(SLEEP_MS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}

