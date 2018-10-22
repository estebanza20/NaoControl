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
* This module controls the People Perception flow and pushes information about detected people in ALMemory.
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/peopleperception/alpeopleperception.html#alpeopleperception">NAOqi APIs for ALPeoplePerception </a>
* NAOqi V2.4.x
*/
public class ALPeoplePerception extends ALProxy {

    private AsyncALPeoplePerception asyncProxy;

    public ALPeoplePerception(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALPeoplePerception();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALPeoplePerception object
	 */
    public AsyncALPeoplePerception async() {
        return asyncProxy;
    }

    /**
    * Gets the current maximum body height used for human detection (3D mode only).
    * 
    * @return Maximum height in meters.
    */
    public Float getMaximumBodyHeight() throws DynamicCallException, ExecutionException {
        return (Float)call("getMaximumBodyHeight").get();
    }

    /**
    * Gets the current status of graphical display in Choregraphe.
    * 
    * @return True if graphical display is enabled, False otherwise.
    */
    public Boolean isGraphicalDisplayEnabled() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isGraphicalDisplayEnabled").get();
    }

    /**
    * Changes the pause status of the extractor
    * 
    * @param status  New pause satus
    */
    public void pause(Boolean status) throws DynamicCallException, ExecutionException{
        call("pause", status).get();
    }

    /**
    * Empties the tracked population.
    * 
    */
    public void resetPopulation() throws DynamicCallException, ExecutionException{
        call("resetPopulation").get();
    }

    /**
    * Turns fast mode on or off.
    * 
    * @param enable  True to turn it on, False to turn it off.
    */
    public void setFastModeEnabled(Boolean enable) throws DynamicCallException, ExecutionException{
        call("setFastModeEnabled", enable).get();
    }

    /**
    * Gets the current maximum detection and tracking range.
    * 
    * @return Maximum range in meters.
    */
    public Float getMaximumDetectionRange() throws DynamicCallException, ExecutionException {
        return (Float)call("getMaximumDetectionRange").get();
    }

    /**
    * Sets the maximum range for human detection and tracking.
    * 
    * @param range  Maximum range in meters.
    */
    public void setMaximumDetectionRange(Float range) throws DynamicCallException, ExecutionException{
        call("setMaximumDetectionRange", range).get();
    }

    /**
    * Sets the minimum human body height (3D mode only).
    * 
    * @param height  Minimum height in meters.
    */
    public void setMinimumBodyHeight(Float height) throws DynamicCallException, ExecutionException{
        call("setMinimumBodyHeight", height).get();
    }

    /**
    * Sets the maximum human body height (3D mode only).
    * 
    * @param height  Maximum height in meters.
    */
    public void setMaximumBodyHeight(Float height) throws DynamicCallException, ExecutionException{
        call("setMaximumBodyHeight", height).get();
    }

    /**
    * Turns movement detection on or off.
    * 
    * @param enable  True to turn it on, False to turn it off.
    */
    public void setMovementDetectionEnabled(Boolean enable) throws DynamicCallException, ExecutionException{
        call("setMovementDetectionEnabled", enable).get();
    }

    /**
    * Sets the time after which a person, supposed not to be in the field of view of the camera disappears if it has not been detected.
    * 
    * @param seconds  Time in seconds.
    */
    public void setTimeBeforePersonDisappears(Float seconds) throws DynamicCallException, ExecutionException{
        call("setTimeBeforePersonDisappears", seconds).get();
    }

    /**
    * Gets the current minimum body height used for human detection (3D mode only).
    * 
    * @return Minimum height in meters.
    */
    public Float getMinimumBodyHeight() throws DynamicCallException, ExecutionException {
        return (Float)call("getMinimumBodyHeight").get();
    }

    /**
    * Turns face detection on or off.
    * 
    * @param enable  True to turn it on, False to turn it off.
    */
    public void setFaceDetectionEnabled(Boolean enable) throws DynamicCallException, ExecutionException{
        call("setFaceDetectionEnabled", enable).get();
    }

    /**
    * Gets the time after which a person, supposed not to be in the field of view of the camera disappears if it has not been detected.
    * 
    * @return Time in seconds.
    */
    public Float getTimeBeforePersonDisappears() throws DynamicCallException, ExecutionException {
        return (Float)call("getTimeBeforePersonDisappears").get();
    }

    /**
    * Gets the time after which a person, supposed to be in the field of view of the camera disappears if it has not been detected.
    * 
    * @return Time in seconds.
    */
    public Float getTimeBeforeVisiblePersonDisappears() throws DynamicCallException, ExecutionException {
        return (Float)call("getTimeBeforeVisiblePersonDisappears").get();
    }

    /**
    * Gets extractor running status
    * 
    * @return True if the extractor is currently processing images, False if not
    */
    public Boolean isProcessing() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isProcessing").get();
    }

    /**
    * Gets the current status of face detection.
    * 
    * @return True if face detection is enabled, False otherwise.
    */
    public Boolean isFaceDetectionEnabled() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isFaceDetectionEnabled").get();
    }

    /**
    * Gets the current status of fast mode.
    * 
    * @return True if fast mode is enabled, False otherwise.
    */
    public Boolean isFastModeEnabled() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isFastModeEnabled").get();
    }

    /**
    * Gets the current status of movement detection in Choregraphe.
    * 
    * @return True if movement detection is enabled, False otherwise.
    */
    public Boolean isMovementDetectionEnabled() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isMovementDetectionEnabled").get();
    }

    /**
    * Sets the time after which a person, supposed to be in the field of view of the camera disappears if it has not been detected.
    * 
    * @param seconds  Time in seconds.
    */
    public void setTimeBeforeVisiblePersonDisappears(Float seconds) throws DynamicCallException, ExecutionException{
        call("setTimeBeforeVisiblePersonDisappears", seconds).get();
    }

    /**
    * Turns graphical display in Choregraphe on or off.
    * 
    * @param enable  True to turn it on, False to turn it off.
    */
    public void setGraphicalDisplayEnabled(Boolean enable) throws DynamicCallException, ExecutionException{
        call("setGraphicalDisplayEnabled", enable).get();
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
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @param period  Refresh period (in milliseconds) if relevant.
    * @param precision  Precision of the extractor if relevant.
    */
    public void subscribe(String name, Integer period, Float precision) throws DynamicCallException, ExecutionException{
        call("subscribe", name, period, precision).get();
    }

    /**
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    */
    public void subscribe(String name) throws DynamicCallException, ExecutionException{
        call("subscribe", name).get();
    }

    /**
    * Unsubscribes from the extractor.
    * 
    * @param name  Name of the module which had subscribed.
    */
    public void unsubscribe(String name) throws DynamicCallException, ExecutionException{
        call("unsubscribe", name).get();
    }

    /**
    * Updates the period if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param period  Refresh period (in milliseconds).
    */
    public void updatePeriod(String name, Integer period) throws DynamicCallException, ExecutionException{
        call("updatePeriod", name, period).get();
    }

    /**
    * Updates the precision if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param precision  Precision of the extractor.
    */
    public void updatePrecision(String name, Float precision) throws DynamicCallException, ExecutionException{
        call("updatePrecision", name, precision).get();
    }

    /**
    * Gets the current period.
    * 
    * @return Refresh period (in milliseconds).
    */
    public Integer getCurrentPeriod() throws DynamicCallException, ExecutionException {
        return (Integer)call("getCurrentPeriod").get();
    }

    /**
    * Gets the current precision.
    * 
    * @return Precision of the extractor.
    */
    public Float getCurrentPrecision() throws DynamicCallException, ExecutionException {
        return (Float)call("getCurrentPrecision").get();
    }

    /**
    * Gets the period for a specific subscription.
    * 
    * @param name  Name of the module which has subscribed.
    * @return Refresh period (in milliseconds).
    */
    public Integer getMyPeriod(String name) throws DynamicCallException, ExecutionException {
        return (Integer)call("getMyPeriod", name).get();
    }

    /**
    * Gets the precision for a specific subscription.
    * 
    * @param name  name of the module which has subscribed
    * @return precision of the extractor
    */
    public Float getMyPrecision(String name) throws DynamicCallException, ExecutionException {
        return (Float)call("getMyPrecision", name).get();
    }

    /**
    * Gets the parameters given by the module.
    * 
    * @return Array of names and parameters of all subscribers.
    */
    public Object getSubscribersInfo() throws DynamicCallException, ExecutionException {
        return (Object)call("getSubscribersInfo").get();
    }

    /**
    * Get the list of values updated in ALMemory.
    * 
    * @return Array of values updated by this extractor in ALMemory
    */
    public List<String> getOutputNames() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getOutputNames").get();
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public List<String> getEventList() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getEventList").get();
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public List<String> getMemoryKeyList() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getMemoryKeyList").get();
    }

    /**
    * Gets extractor pause status
    * 
    * @return True if the extractor is paused, False if not
    */
    public Boolean isPaused() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isPaused").get();
    }


    public class AsyncALPeoplePerception extends ALProxy {

        protected AsyncALPeoplePerception(){
            super();
        }
    
    /**
    * Gets the current maximum body height used for human detection (3D mode only).
    * 
    * @return Maximum height in meters.
    */
    public Future<Float> getMaximumBodyHeight() throws DynamicCallException, ExecutionException {
        return call("getMaximumBodyHeight");
    }

    /**
    * Gets the current status of graphical display in Choregraphe.
    * 
    * @return True if graphical display is enabled, False otherwise.
    */
    public Future<Boolean> isGraphicalDisplayEnabled() throws DynamicCallException, ExecutionException {
        return call("isGraphicalDisplayEnabled");
    }

    /**
    * Changes the pause status of the extractor
    * 
    * @param status  New pause satus
    * @return The Future
    */
    public Future<Void> pause(Boolean status) throws DynamicCallException, ExecutionException{
        return call("pause", status);
    }

    /**
    * Empties the tracked population.
    * 
    * @return The Future
    */
    public Future<Void> resetPopulation() throws DynamicCallException, ExecutionException{
        return call("resetPopulation");
    }

    /**
    * Turns fast mode on or off.
    * 
    * @param enable  True to turn it on, False to turn it off.
    * @return The Future
    */
    public Future<Void> setFastModeEnabled(Boolean enable) throws DynamicCallException, ExecutionException{
        return call("setFastModeEnabled", enable);
    }

    /**
    * Gets the current maximum detection and tracking range.
    * 
    * @return Maximum range in meters.
    */
    public Future<Float> getMaximumDetectionRange() throws DynamicCallException, ExecutionException {
        return call("getMaximumDetectionRange");
    }

    /**
    * Sets the maximum range for human detection and tracking.
    * 
    * @param range  Maximum range in meters.
    * @return The Future
    */
    public Future<Void> setMaximumDetectionRange(Float range) throws DynamicCallException, ExecutionException{
        return call("setMaximumDetectionRange", range);
    }

    /**
    * Sets the minimum human body height (3D mode only).
    * 
    * @param height  Minimum height in meters.
    * @return The Future
    */
    public Future<Void> setMinimumBodyHeight(Float height) throws DynamicCallException, ExecutionException{
        return call("setMinimumBodyHeight", height);
    }

    /**
    * Sets the maximum human body height (3D mode only).
    * 
    * @param height  Maximum height in meters.
    * @return The Future
    */
    public Future<Void> setMaximumBodyHeight(Float height) throws DynamicCallException, ExecutionException{
        return call("setMaximumBodyHeight", height);
    }

    /**
    * Turns movement detection on or off.
    * 
    * @param enable  True to turn it on, False to turn it off.
    * @return The Future
    */
    public Future<Void> setMovementDetectionEnabled(Boolean enable) throws DynamicCallException, ExecutionException{
        return call("setMovementDetectionEnabled", enable);
    }

    /**
    * Sets the time after which a person, supposed not to be in the field of view of the camera disappears if it has not been detected.
    * 
    * @param seconds  Time in seconds.
    * @return The Future
    */
    public Future<Void> setTimeBeforePersonDisappears(Float seconds) throws DynamicCallException, ExecutionException{
        return call("setTimeBeforePersonDisappears", seconds);
    }

    /**
    * Gets the current minimum body height used for human detection (3D mode only).
    * 
    * @return Minimum height in meters.
    */
    public Future<Float> getMinimumBodyHeight() throws DynamicCallException, ExecutionException {
        return call("getMinimumBodyHeight");
    }

    /**
    * Turns face detection on or off.
    * 
    * @param enable  True to turn it on, False to turn it off.
    * @return The Future
    */
    public Future<Void> setFaceDetectionEnabled(Boolean enable) throws DynamicCallException, ExecutionException{
        return call("setFaceDetectionEnabled", enable);
    }

    /**
    * Gets the time after which a person, supposed not to be in the field of view of the camera disappears if it has not been detected.
    * 
    * @return Time in seconds.
    */
    public Future<Float> getTimeBeforePersonDisappears() throws DynamicCallException, ExecutionException {
        return call("getTimeBeforePersonDisappears");
    }

    /**
    * Gets the time after which a person, supposed to be in the field of view of the camera disappears if it has not been detected.
    * 
    * @return Time in seconds.
    */
    public Future<Float> getTimeBeforeVisiblePersonDisappears() throws DynamicCallException, ExecutionException {
        return call("getTimeBeforeVisiblePersonDisappears");
    }

    /**
    * Gets extractor running status
    * 
    * @return True if the extractor is currently processing images, False if not
    */
    public Future<Boolean> isProcessing() throws DynamicCallException, ExecutionException {
        return call("isProcessing");
    }

    /**
    * Gets the current status of face detection.
    * 
    * @return True if face detection is enabled, False otherwise.
    */
    public Future<Boolean> isFaceDetectionEnabled() throws DynamicCallException, ExecutionException {
        return call("isFaceDetectionEnabled");
    }

    /**
    * Gets the current status of fast mode.
    * 
    * @return True if fast mode is enabled, False otherwise.
    */
    public Future<Boolean> isFastModeEnabled() throws DynamicCallException, ExecutionException {
        return call("isFastModeEnabled");
    }

    /**
    * Gets the current status of movement detection in Choregraphe.
    * 
    * @return True if movement detection is enabled, False otherwise.
    */
    public Future<Boolean> isMovementDetectionEnabled() throws DynamicCallException, ExecutionException {
        return call("isMovementDetectionEnabled");
    }

    /**
    * Sets the time after which a person, supposed to be in the field of view of the camera disappears if it has not been detected.
    * 
    * @param seconds  Time in seconds.
    * @return The Future
    */
    public Future<Void> setTimeBeforeVisiblePersonDisappears(Float seconds) throws DynamicCallException, ExecutionException{
        return call("setTimeBeforeVisiblePersonDisappears", seconds);
    }

    /**
    * Turns graphical display in Choregraphe on or off.
    * 
    * @param enable  True to turn it on, False to turn it off.
    * @return The Future
    */
    public Future<Void> setGraphicalDisplayEnabled(Boolean enable) throws DynamicCallException, ExecutionException{
        return call("setGraphicalDisplayEnabled", enable);
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
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @param period  Refresh period (in milliseconds) if relevant.
    * @param precision  Precision of the extractor if relevant.
    * @return The Future
    */
    public Future<Void> subscribe(String name, Integer period, Float precision) throws DynamicCallException, ExecutionException{
        return call("subscribe", name, period, precision);
    }

    /**
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @return The Future
    */
    public Future<Void> subscribe(String name) throws DynamicCallException, ExecutionException{
        return call("subscribe", name);
    }

    /**
    * Unsubscribes from the extractor.
    * 
    * @param name  Name of the module which had subscribed.
    * @return The Future
    */
    public Future<Void> unsubscribe(String name) throws DynamicCallException, ExecutionException{
        return call("unsubscribe", name);
    }

    /**
    * Updates the period if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param period  Refresh period (in milliseconds).
    * @return The Future
    */
    public Future<Void> updatePeriod(String name, Integer period) throws DynamicCallException, ExecutionException{
        return call("updatePeriod", name, period);
    }

    /**
    * Updates the precision if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param precision  Precision of the extractor.
    * @return The Future
    */
    public Future<Void> updatePrecision(String name, Float precision) throws DynamicCallException, ExecutionException{
        return call("updatePrecision", name, precision);
    }

    /**
    * Gets the current period.
    * 
    * @return Refresh period (in milliseconds).
    */
    public Future<Integer> getCurrentPeriod() throws DynamicCallException, ExecutionException {
        return call("getCurrentPeriod");
    }

    /**
    * Gets the current precision.
    * 
    * @return Precision of the extractor.
    */
    public Future<Float> getCurrentPrecision() throws DynamicCallException, ExecutionException {
        return call("getCurrentPrecision");
    }

    /**
    * Gets the period for a specific subscription.
    * 
    * @param name  Name of the module which has subscribed.
    * @return Refresh period (in milliseconds).
    */
    public Future<Integer> getMyPeriod(String name) throws DynamicCallException, ExecutionException {
        return call("getMyPeriod", name);
    }

    /**
    * Gets the precision for a specific subscription.
    * 
    * @param name  name of the module which has subscribed
    * @return precision of the extractor
    */
    public Future<Float> getMyPrecision(String name) throws DynamicCallException, ExecutionException {
        return call("getMyPrecision", name);
    }

    /**
    * Gets the parameters given by the module.
    * 
    * @return Array of names and parameters of all subscribers.
    */
    public Future<Object> getSubscribersInfo() throws DynamicCallException, ExecutionException {
        return call("getSubscribersInfo");
    }

    /**
    * Get the list of values updated in ALMemory.
    * 
    * @return Array of values updated by this extractor in ALMemory
    */
    public Future<List<String>> getOutputNames() throws DynamicCallException, ExecutionException {
        return call("getOutputNames");
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public Future<List<String>> getEventList() throws DynamicCallException, ExecutionException {
        return call("getEventList");
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public Future<List<String>> getMemoryKeyList() throws DynamicCallException, ExecutionException {
        return call("getMemoryKeyList");
    }

    /**
    * Gets extractor pause status
    * 
    * @return True if the extractor is paused, False if not
    */
    public Future<Boolean> isPaused() throws DynamicCallException, ExecutionException {
        return call("isPaused");
    }

    }
}
    