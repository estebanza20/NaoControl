package com.example.ezamoraa.naocontrol;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;

import static android.content.Context.SENSOR_SERVICE;

public class OrientationManager implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor accelerometer;
    private Sensor magnetometer;

    private HandlerThread sensorThread;
    private Handler sensorHandler;


    public OrientationManager(Context context) {
        mSensorManager = (SensorManager) context.getSystemService(SENSOR_SERVICE);
        accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        sensorThread = new HandlerThread("Orientation thread", Thread.MAX_PRIORITY);
        sensorThread.start();

        sensorHandler = new Handler(sensorThread.getLooper());

        mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI, sensorHandler);
        mSensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_UI, sensorHandler);
    }

    float[] mGravity;
    float[] mGeomagnetic;
    float init_pitch = 0;
    float init_yaw = 0;

    float pitch = 0;
    float yaw = 0;
    float filteredPitch = 0;
    float filteredYaw = 0;

    float[] orientation = new float[3];
    int contador = 0;
    int averageMeasures = 10;

    float maxPitch = 29.5f*(180.0f/(float)Math.PI);
    float minPitch = -38.5f*(180.0f/(float)Math.PI);
    float maxYaw = 119.5f*(180.0f/(float)Math.PI);
    float minYaw = -119.5f*(180.0f/(float)Math.PI);

    public void onAccuracyChanged(Sensor sensor, int accuracy){}

    public void onSensorChanged(SensorEvent event){
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            mGravity = event.values;
        }
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            mGeomagnetic = event.values;
        }
        if (mGravity != null && mGeomagnetic != null){
            float[] R = new float[9];
            float[] I = new float[9];
            boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);
            if (success){
                SensorManager.getOrientation(R, orientation);

                if(mGravity[2]<0) orientation[1] = (float) (Math.PI - orientation[1]);
                if (contador < averageMeasures){
                    pitch += orientation[1];
                    yaw += orientation[2];
                }
                else if (contador == averageMeasures ){
                    filteredPitch = Math.max(Math.min(pitch/averageMeasures, maxPitch), minPitch);
                    filteredYaw = Math.max(Math.min(yaw/averageMeasures, maxYaw), minYaw);
                    pitch = 0;
                    yaw = 0;
                    contador = -1;
                }
            }
            contador++;
        }
    }
}


