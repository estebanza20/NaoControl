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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;

public class VideoStreamTask extends AsyncTask<Void, Bitmap, Void> {
    private ALVideoDevice video;
    private ALMotion motion;
    private OrientationManager orientation;
    private WeakReference<ImageView> imgViewRef;
    private String vidClientName;
    private ReentrantLock sLock;
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

    private static final int SLEEP_MS = 10;

    public VideoStreamTask(ImageView imgView, ALVideoDevice videoProxy,
                           ALMotion motionProxy, OrientationManager orientManager,
                           ReentrantLock sessionLock){
        imgViewRef = new WeakReference<>(imgView);
        video = videoProxy;
        motion = motionProxy;
        orientation = orientManager;
        sLock = sessionLock;
        resolution = kQVGA;
        colorSpace = kRGB;
        fps = 30;
        kCameraSelectId = 18;
        cameraId = 0;
    }

    @Override
    protected Void doInBackground(Void... params) {
        ByteBuffer imgBuffer;
        Object imgObject;
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

        while (!this.isCancelled()) {
            if (imgViewRef == null) break;

            ArrayList<Object> imgRemote;

            sLock.lock();
            try {
                imgObject = video.getImageRemote(vidClientName);

                if (imgObject != null)
                    imgRemote = (ArrayList<Object>) imgObject;
                else
                    continue;
            } catch (Exception e) {
                e.printStackTrace();
                break;
            } finally {
                sLock.unlock();
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

            publishProgress(bmp);

            try {
                video.releaseImage(vidClientName);
                Thread.sleep(SLEEP_MS);
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
            if (!values[0].isRecycled())
                imgViewRef.get().setImageBitmap(values[0]);
        }
    }
}
