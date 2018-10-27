package com.example.ezamoraa.naocontrol;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALVideoDevice;

import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class VideoStreamTask extends AsyncTask<Void, Bitmap, Void> {
    private ALVideoDevice video;
    private ALMotion motion;
    private OrientationManager orientation;
    private WeakReference<ImageView> imgViewRef;
    private String vidClientName;
    private int resolution, colorSpace, fps, kCameraSelectId, cameraId;

    // Video resolution
    public static final int kQQVGA = 0;
    public static final int kQVGA = 1;
    public static final int kVGA = 2;

    // Colorspace
    public static final int kYuv = 0;
    public static final int kYUV422 = 9;
    public static final int kYUV = 10;
    public static final int kRGB = 11;
    public static final int kHSY = 12;
    public static final int kBGR = 13;

    public VideoStreamTask(ImageView imgView, ALVideoDevice videoProxy,
                           ALMotion motionProxy, OrientationManager orientManager){
        imgViewRef = new WeakReference<>(imgView);
        video = videoProxy;
        motion = motionProxy;
        orientation = orientManager;
        resolution = kQVGA;
        colorSpace = kRGB;
        fps = 30;
        kCameraSelectId = 18;
        cameraId = 0;
    }

    @Override
    protected Void doInBackground(Void... params) {
        ByteBuffer imgBuffer;
        Bitmap bmp = null;
        int width = 0, height = 0;

        try {
            vidClientName = video.subscribe("_client", resolution, colorSpace, fps);
            video.setParam(kCameraSelectId, cameraId);
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }

        byte[] imgARGB_8888 = null;

        // --------------------------------------------
        List<String> names = new ArrayList<>();
        names.add("HeadYaw");
        names.add("HeadPitch");

        List<Float> angles = new ArrayList<>();
        angles.add(0f);
        angles.add(0f);
        // --------------------------------------------

        while (!this.isCancelled()) {
            angles.set(0, orientation.filteredYaw);
            angles.set(1, orientation.filteredPitch);
            Log.v("HeadAngles", "pitch:" + Float.toString(orientation.filteredPitch));
            Log.v("HeadAngles", "yaw:" + Float.toString(orientation.filteredYaw));
            try {
                motion.setAngles(names, angles, 0.5f);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (imgViewRef == null) break;

            ArrayList<Object> imgRemote;

            try {
                 imgRemote = (ArrayList<Object>) video.getImageRemote(vidClientName);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }

            imgBuffer = (ByteBuffer)imgRemote.get(6);

            if (imgARGB_8888 == null) {
                width = (int)imgRemote.get(0);
                height = (int)imgRemote.get(1);
                imgARGB_8888 = new byte[4 * width * height];
            }

            imgBuffer.rewind();
            for (int i = 0; i < width * height; i++) {
                // R
                imgARGB_8888[4*i] = imgBuffer.array()[3*i];
                // G
                imgARGB_8888[4*i+1] = imgBuffer.array()[3*i+1];
                // B
                imgARGB_8888[4*i+2] = imgBuffer.array()[3*i+2];
                // A
                imgARGB_8888[4*i+3] = (byte)255;
            }

            if (bmp != null && !bmp.isRecycled()) bmp.recycle();
            bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bmp.copyPixelsFromBuffer(ByteBuffer.wrap(imgARGB_8888));

            //publishProgress(Bitmap.createScaledBitmap(bmp, width, height, true));
            publishProgress(bmp);

            try {
                video.releaseImage(vidClientName);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

        try {
            video.unsubscribe(vidClientName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Bitmap... values) {
        super.onProgressUpdate(values);

        if (values != null && values.length > 0) {
            imgViewRef.get().setImageBitmap(values[0]);
        }
    }
}
