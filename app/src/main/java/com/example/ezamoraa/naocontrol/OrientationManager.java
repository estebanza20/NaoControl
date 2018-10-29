package com.example.ezamoraa.naocontrol;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;

import static android.content.Context.SENSOR_SERVICE;

public class OrientationManager implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor magnetometer;

    private HandlerThread sensorThread;
    private Handler sensorHandler;

    private boolean running;

    float[] gravity;
    float[] geomagnetic;
    float[] orientation;

    float pitch = 0;
    float initialPitch = 0;
    float pitchSample = 0;
    private Queue<Float> pitchFifo;
    private int pitchFifoSize = 0;

    float yaw = 0;
    float yawSample = 0;
    private Queue<Float> yawFifo;
    private int yawFifoSize = 0;

    boolean start;

    private static final int FILTER_LEN = 35;
    private static final float MAX_PITCH = 29.5f*(180.0f/(float)Math.PI);
    private static final float MIN_PITCH = -38.5f*(180.0f/(float)Math.PI);
    private static final float MAX_YAW = 119.5f*(180.0f/(float)Math.PI);
    private static final float MIN_YAW = -119.5f*(180.0f/(float)Math.PI);


    public OrientationManager(Context context) {
        sensorManager = (SensorManager) context.getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    public void start() {
        sensorThread = new HandlerThread("Orientation thread", Thread.MAX_PRIORITY);
        sensorThread.start();
        sensorHandler = new Handler(sensorThread.getLooper());

        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME, sensorHandler);
        sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_GAME, sensorHandler);

        pitchFifo =  new LinkedList<>();
        yawFifo =  new LinkedList<>();
        orientation = new float[3];

        pitch = 0;
        yaw = 0;

        start = true;
        running = true;
    }

    public void stop() {
       sensorManager.unregisterListener(this, accelerometer);
       sensorManager.unregisterListener(this, magnetometer);
       if (sensorThread != null && sensorThread.isAlive()) {
           sensorThread.quit();
           running = false;
       }
    }

    public boolean isRunning() { return running; }

    public void onAccuracyChanged(Sensor sensor, int accuracy){}

    public void onSensorChanged(SensorEvent event){
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            gravity = event.values;
        }
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            geomagnetic = event.values;
        }
        if (gravity != null && geomagnetic != null){
            float[] R = new float[9];
            float[] I = new float[9];
            boolean success = SensorManager.getRotationMatrix(R, I, gravity, geomagnetic);
            if (success){
                SensorManager.getOrientation(R, orientation);

                if (gravity[2]<0) {
                    orientation[1] = (float) (Math.PI - orientation[1]);
                }

                pitchSample = Math.max(Math.min(orientation[1], MAX_PITCH), MIN_PITCH);
                yawSample = Math.max(Math.min(orientation[2], MAX_YAW), MIN_YAW);

                if (start) {
                    initialPitch = pitchSample;
                    start = false;
                }

                pitchSample -= initialPitch;

                pitchFifo.add(pitchSample);
                pitchFifoSize = pitchFifo.size();
                pitch += pitchSample/FILTER_LEN;

                yawFifo.add(yawSample);
                yawFifoSize = yawFifo.size();
                yaw += yawSample/FILTER_LEN;

                if (pitchFifoSize >= FILTER_LEN)
                    pitch -= pitchFifo.remove()/FILTER_LEN;

                if (yawFifoSize >= FILTER_LEN)
                    yaw -= yawFifo.remove()/FILTER_LEN;

            }
        }
    }
}