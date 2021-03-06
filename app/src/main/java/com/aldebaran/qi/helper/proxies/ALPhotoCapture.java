/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.*;
import com.aldebaran.qi.helper.*;
import java.util.List;
import java.util.Map;


import java.util.List;
import java.util.concurrent.ExecutionException;

/**
* This module provides methods to take pictures and store them on disk.
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/vision/alphotocapture.html#alphotocapture">NAOqi APIs for ALPhotoCapture </a>
* NAOqi V2.4.x
*/
public class ALPhotoCapture extends ALProxy {

    private AsyncALPhotoCapture asyncProxy;

    public ALPhotoCapture(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALPhotoCapture();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALPhotoCapture object
	 */
    public AsyncALPhotoCapture async() {
        return asyncProxy;
    }

    /**
    * Returns current delay between captures.
    * 
    * @return Current delay (in ms) between two pictures.
    */
    public Integer getCaptureInterval() throws DynamicCallException, ExecutionException {
        return (Integer)call("getCaptureInterval").get();
    }

    /**
    * Returns True if the "half press" mode is on.
    * 
    * @return True or False.
    */
    public Boolean isHalfPressEnabled() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isHalfPressEnabled").get();
    }

    /**
    * Returns True if the "half press" mode is on.
    * 
    * @return True or False.
    */
    public Boolean isHalfPressed() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isHalfPressed").get();
    }

    /**
    * Returns current picture format.
    * 
    * @return Current picture format.
    */
    public String getPictureFormat() throws DynamicCallException, ExecutionException {
        return (String)call("getPictureFormat").get();
    }

    /**
    * 
    * 
    */
    public Boolean isStatsEnabled() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isStatsEnabled").get();
    }

    /**
    * 
    * 
    */
    public void clearStats() throws DynamicCallException, ExecutionException{
        call("clearStats").get();
    }

    /**
    * 
    * 
    */
    public Boolean isTraceEnabled() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isTraceEnabled").get();
    }

    /**
    * Exits and unregisters the module.
    * 
    */
    public void exit() throws DynamicCallException, ExecutionException{
        call("exit").get();
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public String version() throws DynamicCallException, ExecutionException {
        return (String)call("version").get();
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Boolean ping() throws DynamicCallException, ExecutionException {
        return (Boolean)call("ping").get();
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public List<String> getMethodList() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getMethodList").get();
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public Object getMethodHelp(String methodName) throws DynamicCallException, ExecutionException {
        return (Object)call("getMethodHelp", methodName).get();
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public Object getModuleHelp() throws DynamicCallException, ExecutionException {
        return (Object)call("getModuleHelp").get();
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Boolean wait(Integer id, Integer timeoutPeriod) throws DynamicCallException, ExecutionException {
        return (Boolean)call("wait", id, timeoutPeriod).get();
    }

    /**
    * Wait for the end of a long running method that was called using 'post', returns a cancelable future
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    */
    public void wait(Integer id) throws DynamicCallException, ExecutionException{
        call("wait", id).get();
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Boolean isRunning(Integer id) throws DynamicCallException, ExecutionException {
        return (Boolean)call("isRunning", id).get();
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    */
    public void stop(Integer id) throws DynamicCallException, ExecutionException{
        call("stop", id).get();
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public String getBrokerName() throws DynamicCallException, ExecutionException {
        return (String)call("getBrokerName").get();
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public String getUsage(String name) throws DynamicCallException, ExecutionException {
        return (String)call("getUsage", name).get();
    }

    /**
    * Enables or disables the half-press mode.
    * 
    * @param enable  True to enable, false to disable.
    */
    public void setHalfPressEnabled(Boolean enable) throws DynamicCallException, ExecutionException{
        call("setHalfPressEnabled", enable).get();
    }

    /**
    * Manually (un)subscribes to ALVideoDevice.
    * 
    * @return True if eveything went well, False otherwise.
    */
    public Boolean halfPress() throws DynamicCallException, ExecutionException {
        return (Boolean)call("halfPress").get();
    }

    /**
    * Takes one picture.
    * 
    * @param folderPath  Folder where the picture is saved.
    * @param fileName  Filename used to save the picture.
    * @return Full file name of the picture saved on the disk: [filename]
    */
    public Object takePicture(String folderPath, String fileName) throws DynamicCallException, ExecutionException {
        return (Object)call("takePicture", folderPath, fileName).get();
    }

    /**
    * Takes one picture.
    * 
    * @param folderPath  Folder where the picture is saved.
    * @param fileName  Filename used to save the picture.
    * @param overwrite  If false and the filename already exists, an error is thrown.
    * @return Full file name of the picture saved on the disk: [filename]
    */
    public Object takePicture(String folderPath, String fileName, Boolean overwrite) throws DynamicCallException, ExecutionException {
        return (Object)call("takePicture", folderPath, fileName, overwrite).get();
    }

    /**
    * Takes several pictures as quickly as possible
    * 
    * @param numberOfPictures  Number of pictures to take
    * @param folderPath  Folder where the pictures are saved.
    * @param fileName  Filename used to save the pictures.
    * @return List of all saved files: [[filename1, filename2...]]
    */
    public Object takePictures(Integer numberOfPictures, String folderPath, String fileName) throws DynamicCallException, ExecutionException {
        return (Object)call("takePictures", numberOfPictures, folderPath, fileName).get();
    }

    /**
    * Takes several pictures as quickly as possible
    * 
    * @param numberOfPictures  Number of pictures to take
    * @param folderPath  Folder where the pictures are saved.
    * @param fileName  Filename used to save the pictures.
    * @param overwrite  If false and the filename already exists, an error is thrown.
    * @return List of all saved files: [[filename1, filename2...]]
    */
    public Object takePictures(Integer numberOfPictures, String folderPath, String fileName, Boolean overwrite) throws DynamicCallException, ExecutionException {
        return (Object)call("takePictures", numberOfPictures, folderPath, fileName, overwrite).get();
    }

    /**
    * Sets camera ID.
    * 
    * @param cameraID  ID of the camera to use.
    */
    public void setCameraID(Integer cameraID) throws DynamicCallException, ExecutionException{
        call("setCameraID", cameraID).get();
    }

    /**
    * Sets resolution.
    * 
    * @param resolution  New frame resolution.
    */
    public void setResolution(Integer resolution) throws DynamicCallException, ExecutionException{
        call("setResolution", resolution).get();
    }

    /**
    * Sets color space.
    * 
    * @param colorSpace  New color space.
    */
    public void setColorSpace(Integer colorSpace) throws DynamicCallException, ExecutionException{
        call("setColorSpace", colorSpace).get();
    }

    /**
    * Sets delay between two captures.
    * 
    * @param captureInterval  New delay (in ms) between two pictures.
    */
    public void setCaptureInterval(Integer captureInterval) throws DynamicCallException, ExecutionException{
        call("setCaptureInterval", captureInterval).get();
    }

    /**
    * Sets picture extension.
    * 
    * @param pictureFormat  New extension used to save pictures.
    */
    public void setPictureFormat(String pictureFormat) throws DynamicCallException, ExecutionException{
        call("setPictureFormat", pictureFormat).get();
    }

    /**
    * Returns current camera ID.
    * 
    * @return Current camera ID.
    */
    public Integer getCameraID() throws DynamicCallException, ExecutionException {
        return (Integer)call("getCameraID").get();
    }

    /**
    * Returns current resolution.
    * 
    * @return Current frame resolution.
    */
    public Integer getResolution() throws DynamicCallException, ExecutionException {
        return (Integer)call("getResolution").get();
    }

    /**
    * Returns current color space.
    * 
    * @return Current color space.
    */
    public Integer getColorSpace() throws DynamicCallException, ExecutionException {
        return (Integer)call("getColorSpace").get();
    }


    public class AsyncALPhotoCapture extends ALProxy {

        protected AsyncALPhotoCapture(){
            super();
        }
    
    /**
    * Returns current delay between captures.
    * 
    * @return Current delay (in ms) between two pictures.
    */
    public Future<Integer> getCaptureInterval() throws DynamicCallException, ExecutionException {
        return call("getCaptureInterval");
    }

    /**
    * Returns True if the "half press" mode is on.
    * 
    * @return True or False.
    */
    public Future<Boolean> isHalfPressEnabled() throws DynamicCallException, ExecutionException {
        return call("isHalfPressEnabled");
    }

    /**
    * Returns True if the "half press" mode is on.
    * 
    * @return True or False.
    */
    public Future<Boolean> isHalfPressed() throws DynamicCallException, ExecutionException {
        return call("isHalfPressed");
    }

    /**
    * Returns current picture format.
    * 
    * @return Current picture format.
    */
    public Future<String> getPictureFormat() throws DynamicCallException, ExecutionException {
        return call("getPictureFormat");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isStatsEnabled() throws DynamicCallException, ExecutionException {
        return call("isStatsEnabled");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> clearStats() throws DynamicCallException, ExecutionException{
        return call("clearStats");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isTraceEnabled() throws DynamicCallException, ExecutionException {
        return call("isTraceEnabled");
    }

    /**
    * Exits and unregisters the module.
    * 
    * @return The Future
    */
    public Future<Void> exit() throws DynamicCallException, ExecutionException{
        return call("exit");
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public Future<String> version() throws DynamicCallException, ExecutionException {
        return call("version");
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Future<Boolean> ping() throws DynamicCallException, ExecutionException {
        return call("ping");
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public Future<List<String>> getMethodList() throws DynamicCallException, ExecutionException {
        return call("getMethodList");
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public Future<Object> getMethodHelp(String methodName) throws DynamicCallException, ExecutionException {
        return call("getMethodHelp", methodName);
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public Future<Object> getModuleHelp() throws DynamicCallException, ExecutionException {
        return call("getModuleHelp");
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Future<Boolean> wait(Integer id, Integer timeoutPeriod) throws DynamicCallException, ExecutionException {
        return call("wait", id, timeoutPeriod);
    }

    /**
    * Wait for the end of a long running method that was called using 'post', returns a cancelable future
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return The Future
    */
    public Future<Void> wait(Integer id) throws DynamicCallException, ExecutionException{
        return call("wait", id);
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Future<Boolean> isRunning(Integer id) throws DynamicCallException, ExecutionException {
        return call("isRunning", id);
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    * @return The Future
    */
    public Future<Void> stop(Integer id) throws DynamicCallException, ExecutionException{
        return call("stop", id);
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public Future<String> getBrokerName() throws DynamicCallException, ExecutionException {
        return call("getBrokerName");
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public Future<String> getUsage(String name) throws DynamicCallException, ExecutionException {
        return call("getUsage", name);
    }

    /**
    * Enables or disables the half-press mode.
    * 
    * @param enable  True to enable, false to disable.
    * @return The Future
    */
    public Future<Void> setHalfPressEnabled(Boolean enable) throws DynamicCallException, ExecutionException{
        return call("setHalfPressEnabled", enable);
    }

    /**
    * Manually (un)subscribes to ALVideoDevice.
    * 
    * @return True if eveything went well, False otherwise.
    */
    public Future<Boolean> halfPress() throws DynamicCallException, ExecutionException {
        return call("halfPress");
    }

    /**
    * Takes one picture.
    * 
    * @param folderPath  Folder where the picture is saved.
    * @param fileName  Filename used to save the picture.
    * @return Full file name of the picture saved on the disk: [filename]
    */
    public Future<Object> takePicture(String folderPath, String fileName) throws DynamicCallException, ExecutionException {
        return call("takePicture", folderPath, fileName);
    }

    /**
    * Takes one picture.
    * 
    * @param folderPath  Folder where the picture is saved.
    * @param fileName  Filename used to save the picture.
    * @param overwrite  If false and the filename already exists, an error is thrown.
    * @return Full file name of the picture saved on the disk: [filename]
    */
    public Future<Object> takePicture(String folderPath, String fileName, Boolean overwrite) throws DynamicCallException, ExecutionException {
        return call("takePicture", folderPath, fileName, overwrite);
    }

    /**
    * Takes several pictures as quickly as possible
    * 
    * @param numberOfPictures  Number of pictures to take
    * @param folderPath  Folder where the pictures are saved.
    * @param fileName  Filename used to save the pictures.
    * @return List of all saved files: [[filename1, filename2...]]
    */
    public Future<Object> takePictures(Integer numberOfPictures, String folderPath, String fileName) throws DynamicCallException, ExecutionException {
        return call("takePictures", numberOfPictures, folderPath, fileName);
    }

    /**
    * Takes several pictures as quickly as possible
    * 
    * @param numberOfPictures  Number of pictures to take
    * @param folderPath  Folder where the pictures are saved.
    * @param fileName  Filename used to save the pictures.
    * @param overwrite  If false and the filename already exists, an error is thrown.
    * @return List of all saved files: [[filename1, filename2...]]
    */
    public Future<Object> takePictures(Integer numberOfPictures, String folderPath, String fileName, Boolean overwrite) throws DynamicCallException, ExecutionException {
        return call("takePictures", numberOfPictures, folderPath, fileName, overwrite);
    }

    /**
    * Sets camera ID.
    * 
    * @param cameraID  ID of the camera to use.
    * @return The Future
    */
    public Future<Void> setCameraID(Integer cameraID) throws DynamicCallException, ExecutionException{
        return call("setCameraID", cameraID);
    }

    /**
    * Sets resolution.
    * 
    * @param resolution  New frame resolution.
    * @return The Future
    */
    public Future<Void> setResolution(Integer resolution) throws DynamicCallException, ExecutionException{
        return call("setResolution", resolution);
    }

    /**
    * Sets color space.
    * 
    * @param colorSpace  New color space.
    * @return The Future
    */
    public Future<Void> setColorSpace(Integer colorSpace) throws DynamicCallException, ExecutionException{
        return call("setColorSpace", colorSpace);
    }

    /**
    * Sets delay between two captures.
    * 
    * @param captureInterval  New delay (in ms) between two pictures.
    * @return The Future
    */
    public Future<Void> setCaptureInterval(Integer captureInterval) throws DynamicCallException, ExecutionException{
        return call("setCaptureInterval", captureInterval);
    }

    /**
    * Sets picture extension.
    * 
    * @param pictureFormat  New extension used to save pictures.
    * @return The Future
    */
    public Future<Void> setPictureFormat(String pictureFormat) throws DynamicCallException, ExecutionException{
        return call("setPictureFormat", pictureFormat);
    }

    /**
    * Returns current camera ID.
    * 
    * @return Current camera ID.
    */
    public Future<Integer> getCameraID() throws DynamicCallException, ExecutionException {
        return call("getCameraID");
    }

    /**
    * Returns current resolution.
    * 
    * @return Current frame resolution.
    */
    public Future<Integer> getResolution() throws DynamicCallException, ExecutionException {
        return call("getResolution");
    }

    /**
    * Returns current color space.
    * 
    * @return Current color space.
    */
    public Future<Integer> getColorSpace() throws DynamicCallException, ExecutionException {
        return call("getColorSpace");
    }

    }
}
    