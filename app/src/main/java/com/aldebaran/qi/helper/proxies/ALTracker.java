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
* Use ALTracker module to make the robot track an object or a person with head and arms or not.
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/trackers/index.html#altracker">NAOqi APIs for ALTracker </a>
* NAOqi V2.4.x
*/
public class ALTracker extends ALProxy {

    private AsyncALTracker asyncProxy;

    public ALTracker(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALTracker();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALTracker object
	 */
    public AsyncALTracker async() {
        return asyncProxy;
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
    * Returns the [x, y, z] position of the target in FRAME_TORSO. This is done assuming an average target size, so it might not be very accurate.
    * 
    * @param pFrame  target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @return Vector of 3 floats corresponding to the target position 3D. 
    */
    public List<Float> getTargetPosition(Integer pFrame) throws DynamicCallException, ExecutionException {
        return (List<Float>)call("getTargetPosition", pFrame).get();
    }

    /**
    * Only work with LandMarks target name. Returns the [x, y, z, wx, wy, wz] position of the robot in coordinate system setted with setMap API. This is done assuming an average target size, so it might not be very accurate.
    * 
    * @return Vector of 6 floats corresponding to the robot position 6D.
    */
    public List<Float> getRobotPosition() throws DynamicCallException, ExecutionException {
        return (List<Float>)call("getRobotPosition").get();
    }

    /**
    * Return true if Tracker is running.
    * 
    * @return True if Tracker is running.
    */
    public Boolean isActive() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isActive").get();
    }

    /**
    * Return true if a new target was detected.
    * 
    * @return True if a new target was detected since the last getTargetPosition().
    */
    public Boolean isNewTargetDetected() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isNewTargetDetected").get();
    }

    /**
    * Set the robot position relative to target in Move mode.
    * 
    * @param target  Set the final goal of the tracking. Could be [distance, thresholdX, thresholdY] or with LandMarks target name [coordX, coordY, coordWz, thresholdX, thresholdY, thresholdWz].
    */
    public void setRelativePosition(Object target) throws DynamicCallException, ExecutionException{
        call("setRelativePosition", target).get();
    }

    /**
    * Get the robot position relative to target in Move mode.
    * 
    * @return The final goal of the tracking. Could be [distance, thresholdX, thresholdY] or with LandMarks target name [coordX, coordY, coordWz, thresholdX, thresholdY, thresholdWz].
    */
    public Object getRelativePosition() throws DynamicCallException, ExecutionException {
        return (Object)call("getRelativePosition").get();
    }

    /**
    * Only work with LandMarks target name. Set objects coordinates. Could be [[first object coordinate], [second object coordinate]] [[x1, y1, z1], [x2, y2, z2]]
    * 
    * @param pCoord  objects coordinates.
    */
    public void setTargetCoordinates(Object pCoord) throws DynamicCallException, ExecutionException{
        call("setTargetCoordinates", pCoord).get();
    }

    /**
    * Only work with LandMarks target name. Get objects coordinates. Could be [[first object coordinate], [second object coordinate]] [[x1, y1, z1], [x2, y2, z2]]
    * 
    * @return objects coordinates.
    */
    public Object getTargetCoordinates() throws DynamicCallException, ExecutionException {
        return (Object)call("getTargetCoordinates").get();
    }

    /**
    * Set the tracker in the predefined mode.Could be "Head", "WholeBody" or "Move".
    * 
    * @param pMode  a predefined mode.
    */
    public void setMode(String pMode) throws DynamicCallException, ExecutionException{
        call("setMode", pMode).get();
    }

    /**
    * Get the tracker current mode.
    * 
    * @return The current tracker mode.
    */
    public String getMode() throws DynamicCallException, ExecutionException {
        return (String)call("getMode").get();
    }

    /**
    * Get the list of predefined mode.
    * 
    * @return List of predefined mode.
    */
    public List<String> getAvailableModes() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getAvailableModes").get();
    }

    /**
    * Enables/disables the target search process. Target search process occurs only when the target is lost.
    * 
    * @param pSearch  If true and if the target is lost, the robot moves the head in order to find the target. If false and if the target is lost the robot does not move.
    */
    public void toggleSearch(Boolean pSearch) throws DynamicCallException, ExecutionException{
        call("toggleSearch", pSearch).get();
    }

    /**
    * Set search process fraction max speed.
    * 
    * @param pFractionMaxSpeed  a fraction max speed.
    */
    public void setSearchFractionMaxSpeed(Float pFractionMaxSpeed) throws DynamicCallException, ExecutionException{
        call("setSearchFractionMaxSpeed", pFractionMaxSpeed).get();
    }

    /**
    * Get search process fraction max speed.
    * 
    * @return a fraction max speed.
    */
    public Float getSearchFractionMaxSpeed() throws DynamicCallException, ExecutionException {
        return (Float)call("getSearchFractionMaxSpeed").get();
    }

    /**
    * Return true if the target search process is enabled.
    * 
    * @return If true the target search process is enabled.
    */
    public Boolean isSearchEnabled() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isSearchEnabled").get();
    }

    /**
    * Stop the tracker.
    * 
    */
    public void stopTracker() throws DynamicCallException, ExecutionException{
        call("stopTracker").get();
    }

    /**
    * Return true if the target was lost.
    * 
    * @return True if the target was lost.
    */
    public Boolean isTargetLost() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isTargetLost").get();
    }

    /**
    * Set the predefided target to track and start the tracking process if not started.
    * 
    * @param pTarget  a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    */
    public void track(String pTarget) throws DynamicCallException, ExecutionException{
        call("track", pTarget).get();
    }

    /**
    * Track event and start the tracking process if not started.
    * 
    * @param pEventName  a event name to track.
    */
    public void trackEvent(String pEventName) throws DynamicCallException, ExecutionException{
        call("trackEvent", pEventName).get();
    }

    /**
    * Register a predefined target. Subscribe to corresponding extractor if Tracker is running..
    * 
    * @param pTarget  a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @param pParams  a target parameters. (RedBall : set diameter of ball.
    */
    public void registerTarget(String pTarget, Object pParams) throws DynamicCallException, ExecutionException{
        call("registerTarget", pTarget, pParams).get();
    }

    /**
    * Set a period for the corresponding target name extractor.
    * 
    * @param pTarget  a predefined target name.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @param pPeriod  a period in milliseconds
    */
    public void setExtractorPeriod(String pTarget, Integer pPeriod) throws DynamicCallException, ExecutionException{
        call("setExtractorPeriod", pTarget, pPeriod).get();
    }

    /**
    * Get the period of corresponding target name extractor.
    * 
    * @param pTarget  a predefined target name.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return a period in milliseconds
    */
    public Integer getExtractorPeriod(String pTarget) throws DynamicCallException, ExecutionException {
        return (Integer)call("getExtractorPeriod", pTarget).get();
    }

    /**
    * Unregister target name and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    */
    public void unregisterTarget(String pTarget) throws DynamicCallException, ExecutionException{
        call("unregisterTarget", pTarget).get();
    }

    /**
    * Unregister a list of target names and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target list to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    */
    public void unregisterTargets(List<String> pTarget) throws DynamicCallException, ExecutionException{
        call("unregisterTargets", pTarget).get();
    }

    /**
    * Unregister all targets except active target and stop corresponding extractor.
    * 
    */
    public void unregisterAllTargets() throws DynamicCallException, ExecutionException{
        call("unregisterAllTargets").get();
    }

    /**
    * Return active target name.
    * 
    * @return Tracked target name.
    */
    public String getActiveTarget() throws DynamicCallException, ExecutionException {
        return (String)call("getActiveTarget").get();
    }

    /**
    * Return a list of supported targets names.
    * 
    * @return Supported targets names.
    */
    public List<String> getSupportedTargets() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getSupportedTargets").get();
    }

    /**
    * Return a list of registered targets names.
    * 
    * @return Registered targets names.
    */
    public List<String> getRegisteredTargets() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getRegisteredTargets").get();
    }

    /**
    * Look at the target position with head.

    * 
    * @param pPosition  position 3D [x, y, z] x position must be striclty positif.
    * @param pFrame  target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    * @param pUseWholeBody  If true, use whole body constraints.
    */
    public void lookAt(List<Float> pPosition, Integer pFrame, Float pFractionMaxSpeed, Boolean pUseWholeBody) throws DynamicCallException, ExecutionException{
        call("lookAt", pPosition, pFrame, pFractionMaxSpeed, pUseWholeBody).get();
    }

    /**
    * Point at the target position with arms.

    * 
    * @param pEffector  effector name. Could be "Arms", "LArm", "RArm".
    * @param pPosition  position 3D [x, y, z] to point in FRAME_TORSO. x position must be striclty positif.
    * @param pFrame  target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    */
    public void pointAt(String pEffector, List<Float> pPosition, Integer pFrame, Float pFractionMaxSpeed) throws DynamicCallException, ExecutionException{
        call("pointAt", pEffector, pPosition, pFrame, pFractionMaxSpeed).get();
    }

    /**
    * Get the config for move modes.
    * 
    * @return ALMotion GaitConfig
    */
    public Object getMoveConfig() throws DynamicCallException, ExecutionException {
        return (Object)call("getMoveConfig").get();
    }

    /**
    * set a config for move modes.
    * 
    * @param config  ALMotion GaitConfig
    */
    public void setMoveConfig(Object config) throws DynamicCallException, ExecutionException{
        call("setMoveConfig", config).get();
    }

    /**
    * get the timeout parameter for target lost.
    * 
    * @return time in milliseconds.
    */
    public Integer getTimeOut() throws DynamicCallException, ExecutionException {
        return (Integer)call("getTimeOut").get();
    }

    /**
    * set the timeout parameter for target lost.
    * 
    * @param pTimeMs  time in milliseconds.
    */
    public void setTimeOut(Integer pTimeMs) throws DynamicCallException, ExecutionException{
        call("setTimeOut", pTimeMs).get();
    }

    /**
    * get the maximum distance for target detection in meter.
    * 
    * @return The maximum distance for target detection in meter.
    */
    public Float getMaximumDistanceDetection() throws DynamicCallException, ExecutionException {
        return (Float)call("getMaximumDistanceDetection").get();
    }

    /**
    * set the maximum target detection distance in meter.
    * 
    * @param pMaxDistance  The maximum distance for target detection in meter.
    */
    public void setMaximumDistanceDetection(Float pMaxDistance) throws DynamicCallException, ExecutionException{
        call("setMaximumDistanceDetection", pMaxDistance).get();
    }

    /**
    * Get active effector.
    * 
    * @return Active effector name. Could be: "Arms", "LArm", "RArm" or "None". 
    */
    public String getEffector() throws DynamicCallException, ExecutionException {
        return (String)call("getEffector").get();
    }

    /**
    * Set an end-effector to move for tracking.
    * 
    * @param pEffector  Name of effector. Could be: "Arms", "LArm", "RArm" or "None". 
    */
    public void setEffector(String pEffector) throws DynamicCallException, ExecutionException{
        call("setEffector", pEffector).get();
    }

    /**
    * Initialize tracker parameters with default values.
    * 
    */
    public void initialize() throws DynamicCallException, ExecutionException{
        call("initialize").get();
    }

    /**
    * Set the maximum velocity for tracking.
    * 
    * @param pVelocity  The maximum velocity in rad.s-1 .
    */
    public void setMaximumVelocity(Float pVelocity) throws DynamicCallException, ExecutionException{
        call("setMaximumVelocity", pVelocity).get();
    }

    /**
    * Get the maximum velocity for tracking.
    * 
    * @return The maximum velocity in rad.s-1 .
    */
    public Float getMaximumVelocity() throws DynamicCallException, ExecutionException {
        return (Float)call("getMaximumVelocity").get();
    }

    /**
    * Set the maximum acceleration for tracking.
    * 
    * @param pAcceleration  The maximum acceleration in rad.s-2 .
    */
    public void setMaximumAcceleration(Float pAcceleration) throws DynamicCallException, ExecutionException{
        call("setMaximumAcceleration", pAcceleration).get();
    }

    /**
    * Get the maximum acceleration for tracking.
    * 
    * @return The maximum acceleration in rad.s-2 .
    */
    public Float getMaximumAcceleration() throws DynamicCallException, ExecutionException {
        return (Float)call("getMaximumAcceleration").get();
    }

    /**
    * DEPRECATED. Use lookAt with frame instead. Look at the target position with head.

    * 
    * @param pPosition  position 3D [x, y, z] to look in FRAME_TORSO. x position must be striclty positif.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    * @param pUseWholeBody  If true, use whole body constraints.
    */
    public void lookAt(List<Float> pPosition, Float pFractionMaxSpeed, Boolean pUseWholeBody) throws DynamicCallException, ExecutionException{
        call("lookAt", pPosition, pFractionMaxSpeed, pUseWholeBody).get();
    }

    /**
    * DEPRECATED. Use pointAt with frame instead. Point at the target position with arms.

    * 
    * @param pEffector  effector name. Could be "Arms", "LArm", "RArm".
    * @param pPosition  position 3D [x, y, z] to point in FRAME_TORSO. x position must be striclty positif.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    */
    public void pointAt(String pEffector, List<Float> pPosition, Float pFractionMaxSpeed) throws DynamicCallException, ExecutionException{
        call("pointAt", pEffector, pPosition, pFractionMaxSpeed).get();
    }

    /**
    * DEPRECATED. Use pointAt with frame instead. Returns the [x, y, z] position of the target in FRAME_TORSO. This is done assuming an average target size, so it might not be very accurate.
    * 
    * @return Vector of 3 floats corresponding to the target position 3D. 
    */
    public List<Float> getTargetPosition() throws DynamicCallException, ExecutionException {
        return (List<Float>)call("getTargetPosition").get();
    }

    /**
    * DEPRECATED. Use getSupportedTargets() instead. Return a list of targets names.
    * 
    * @return Valid targets names.
    */
    public List<String> getTargetNames() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getTargetNames").get();
    }

    /**
    * DEPRECATED. Use getRegisteredTargets() instead. Return a list of managed targets names.
    * 
    * @return Managed targets names.
    */
    public List<String> getManagedTargets() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getManagedTargets").get();
    }

    /**
    * DEPRECATED. Use registerTarget() instead. Add a predefined target. Subscribe to corresponding extractor if Tracker is running..
    * 
    * @param pTarget  a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @param pParams  a target parameters. (RedBall : set diameter of ball.
    */
    public void addTarget(String pTarget, Object pParams) throws DynamicCallException, ExecutionException{
        call("addTarget", pTarget, pParams).get();
    }

    /**
    * DEPRECATED. Use unregisterTarget() instead. Remove target name and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    */
    public void removeTarget(String pTarget) throws DynamicCallException, ExecutionException{
        call("removeTarget", pTarget).get();
    }

    /**
    * DEPRECATED. Use unregisterTargets() instead. Remove a list of target names and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target list to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    */
    public void removeTargets(List<String> pTarget) throws DynamicCallException, ExecutionException{
        call("removeTargets", pTarget).get();
    }

    /**
    * DEPRECATED. Use unregisterAllTargets() instead. Remove all managed targets except active target and stop corresponding extractor.
    * 
    */
    public void removeAllTargets() throws DynamicCallException, ExecutionException{
        call("removeAllTargets").get();
    }

    /**
    * DEPRECATED. Use setEffector instead. Add an end-effector to move for tracking.
    * 
    * @param pEffector  Name of effector. Could be: "Arms", "LArm" or "RArm". 
    */
    public void addEffector(String pEffector) throws DynamicCallException, ExecutionException{
        call("addEffector", pEffector).get();
    }

    /**
    * DEPRECATED. Use setEffector("None") instead. Remove an end-effector from tracking.
    * 
    * @param pEffector  Name of effector. Could be: "Arms", "LArm" or "RArm". 
    */
    public void removeEffector(String pEffector) throws DynamicCallException, ExecutionException{
        call("removeEffector", pEffector).get();
    }


    public class AsyncALTracker extends ALProxy {

        protected AsyncALTracker(){
            super();
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
    * Returns the [x, y, z] position of the target in FRAME_TORSO. This is done assuming an average target size, so it might not be very accurate.
    * 
    * @param pFrame  target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @return Vector of 3 floats corresponding to the target position 3D. 
    */
    public Future<List<Float>> getTargetPosition(Integer pFrame) throws DynamicCallException, ExecutionException {
        return call("getTargetPosition", pFrame);
    }

    /**
    * Only work with LandMarks target name. Returns the [x, y, z, wx, wy, wz] position of the robot in coordinate system setted with setMap API. This is done assuming an average target size, so it might not be very accurate.
    * 
    * @return Vector of 6 floats corresponding to the robot position 6D.
    */
    public Future<List<Float>> getRobotPosition() throws DynamicCallException, ExecutionException {
        return call("getRobotPosition");
    }

    /**
    * Return true if Tracker is running.
    * 
    * @return True if Tracker is running.
    */
    public Future<Boolean> isActive() throws DynamicCallException, ExecutionException {
        return call("isActive");
    }

    /**
    * Return true if a new target was detected.
    * 
    * @return True if a new target was detected since the last getTargetPosition().
    */
    public Future<Boolean> isNewTargetDetected() throws DynamicCallException, ExecutionException {
        return call("isNewTargetDetected");
    }

    /**
    * Set the robot position relative to target in Move mode.
    * 
    * @param target  Set the final goal of the tracking. Could be [distance, thresholdX, thresholdY] or with LandMarks target name [coordX, coordY, coordWz, thresholdX, thresholdY, thresholdWz].
    * @return The Future
    */
    public Future<Void> setRelativePosition(Object target) throws DynamicCallException, ExecutionException{
        return call("setRelativePosition", target);
    }

    /**
    * Get the robot position relative to target in Move mode.
    * 
    * @return The final goal of the tracking. Could be [distance, thresholdX, thresholdY] or with LandMarks target name [coordX, coordY, coordWz, thresholdX, thresholdY, thresholdWz].
    */
    public Future<Object> getRelativePosition() throws DynamicCallException, ExecutionException {
        return call("getRelativePosition");
    }

    /**
    * Only work with LandMarks target name. Set objects coordinates. Could be [[first object coordinate], [second object coordinate]] [[x1, y1, z1], [x2, y2, z2]]
    * 
    * @param pCoord  objects coordinates.
    * @return The Future
    */
    public Future<Void> setTargetCoordinates(Object pCoord) throws DynamicCallException, ExecutionException{
        return call("setTargetCoordinates", pCoord);
    }

    /**
    * Only work with LandMarks target name. Get objects coordinates. Could be [[first object coordinate], [second object coordinate]] [[x1, y1, z1], [x2, y2, z2]]
    * 
    * @return objects coordinates.
    */
    public Future<Object> getTargetCoordinates() throws DynamicCallException, ExecutionException {
        return call("getTargetCoordinates");
    }

    /**
    * Set the tracker in the predefined mode.Could be "Head", "WholeBody" or "Move".
    * 
    * @param pMode  a predefined mode.
    * @return The Future
    */
    public Future<Void> setMode(String pMode) throws DynamicCallException, ExecutionException{
        return call("setMode", pMode);
    }

    /**
    * Get the tracker current mode.
    * 
    * @return The current tracker mode.
    */
    public Future<String> getMode() throws DynamicCallException, ExecutionException {
        return call("getMode");
    }

    /**
    * Get the list of predefined mode.
    * 
    * @return List of predefined mode.
    */
    public Future<List<String>> getAvailableModes() throws DynamicCallException, ExecutionException {
        return call("getAvailableModes");
    }

    /**
    * Enables/disables the target search process. Target search process occurs only when the target is lost.
    * 
    * @param pSearch  If true and if the target is lost, the robot moves the head in order to find the target. If false and if the target is lost the robot does not move.
    * @return The Future
    */
    public Future<Void> toggleSearch(Boolean pSearch) throws DynamicCallException, ExecutionException{
        return call("toggleSearch", pSearch);
    }

    /**
    * Set search process fraction max speed.
    * 
    * @param pFractionMaxSpeed  a fraction max speed.
    * @return The Future
    */
    public Future<Void> setSearchFractionMaxSpeed(Float pFractionMaxSpeed) throws DynamicCallException, ExecutionException{
        return call("setSearchFractionMaxSpeed", pFractionMaxSpeed);
    }

    /**
    * Get search process fraction max speed.
    * 
    * @return a fraction max speed.
    */
    public Future<Float> getSearchFractionMaxSpeed() throws DynamicCallException, ExecutionException {
        return call("getSearchFractionMaxSpeed");
    }

    /**
    * Return true if the target search process is enabled.
    * 
    * @return If true the target search process is enabled.
    */
    public Future<Boolean> isSearchEnabled() throws DynamicCallException, ExecutionException {
        return call("isSearchEnabled");
    }

    /**
    * Stop the tracker.
    * 
    * @return The Future
    */
    public Future<Void> stopTracker() throws DynamicCallException, ExecutionException{
        return call("stopTracker");
    }

    /**
    * Return true if the target was lost.
    * 
    * @return True if the target was lost.
    */
    public Future<Boolean> isTargetLost() throws DynamicCallException, ExecutionException {
        return call("isTargetLost");
    }

    /**
    * Set the predefided target to track and start the tracking process if not started.
    * 
    * @param pTarget  a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return The Future
    */
    public Future<Void> track(String pTarget) throws DynamicCallException, ExecutionException{
        return call("track", pTarget);
    }

    /**
    * Track event and start the tracking process if not started.
    * 
    * @param pEventName  a event name to track.
    * @return The Future
    */
    public Future<Void> trackEvent(String pEventName) throws DynamicCallException, ExecutionException{
        return call("trackEvent", pEventName);
    }

    /**
    * Register a predefined target. Subscribe to corresponding extractor if Tracker is running..
    * 
    * @param pTarget  a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @param pParams  a target parameters. (RedBall : set diameter of ball.
    * @return The Future
    */
    public Future<Void> registerTarget(String pTarget, Object pParams) throws DynamicCallException, ExecutionException{
        return call("registerTarget", pTarget, pParams);
    }

    /**
    * Set a period for the corresponding target name extractor.
    * 
    * @param pTarget  a predefined target name.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @param pPeriod  a period in milliseconds
    * @return The Future
    */
    public Future<Void> setExtractorPeriod(String pTarget, Integer pPeriod) throws DynamicCallException, ExecutionException{
        return call("setExtractorPeriod", pTarget, pPeriod);
    }

    /**
    * Get the period of corresponding target name extractor.
    * 
    * @param pTarget  a predefined target name.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return a period in milliseconds
    */
    public Future<Integer> getExtractorPeriod(String pTarget) throws DynamicCallException, ExecutionException {
        return call("getExtractorPeriod", pTarget);
    }

    /**
    * Unregister target name and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return The Future
    */
    public Future<Void> unregisterTarget(String pTarget) throws DynamicCallException, ExecutionException{
        return call("unregisterTarget", pTarget);
    }

    /**
    * Unregister a list of target names and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target list to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return The Future
    */
    public Future<Void> unregisterTargets(List<String> pTarget) throws DynamicCallException, ExecutionException{
        return call("unregisterTargets", pTarget);
    }

    /**
    * Unregister all targets except active target and stop corresponding extractor.
    * 
    * @return The Future
    */
    public Future<Void> unregisterAllTargets() throws DynamicCallException, ExecutionException{
        return call("unregisterAllTargets");
    }

    /**
    * Return active target name.
    * 
    * @return Tracked target name.
    */
    public Future<String> getActiveTarget() throws DynamicCallException, ExecutionException {
        return call("getActiveTarget");
    }

    /**
    * Return a list of supported targets names.
    * 
    * @return Supported targets names.
    */
    public Future<List<String>> getSupportedTargets() throws DynamicCallException, ExecutionException {
        return call("getSupportedTargets");
    }

    /**
    * Return a list of registered targets names.
    * 
    * @return Registered targets names.
    */
    public Future<List<String>> getRegisteredTargets() throws DynamicCallException, ExecutionException {
        return call("getRegisteredTargets");
    }

    /**
    * Look at the target position with head.

    * 
    * @param pPosition  position 3D [x, y, z] x position must be striclty positif.
    * @param pFrame  target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    * @param pUseWholeBody  If true, use whole body constraints.
    * @return The Future
    */
    public Future<Void> lookAt(List<Float> pPosition, Integer pFrame, Float pFractionMaxSpeed, Boolean pUseWholeBody) throws DynamicCallException, ExecutionException{
        return call("lookAt", pPosition, pFrame, pFractionMaxSpeed, pUseWholeBody);
    }

    /**
    * Point at the target position with arms.

    * 
    * @param pEffector  effector name. Could be "Arms", "LArm", "RArm".
    * @param pPosition  position 3D [x, y, z] to point in FRAME_TORSO. x position must be striclty positif.
    * @param pFrame  target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    * @return The Future
    */
    public Future<Void> pointAt(String pEffector, List<Float> pPosition, Integer pFrame, Float pFractionMaxSpeed) throws DynamicCallException, ExecutionException{
        return call("pointAt", pEffector, pPosition, pFrame, pFractionMaxSpeed);
    }

    /**
    * Get the config for move modes.
    * 
    * @return ALMotion GaitConfig
    */
    public Future<Object> getMoveConfig() throws DynamicCallException, ExecutionException {
        return call("getMoveConfig");
    }

    /**
    * set a config for move modes.
    * 
    * @param config  ALMotion GaitConfig
    * @return The Future
    */
    public Future<Void> setMoveConfig(Object config) throws DynamicCallException, ExecutionException{
        return call("setMoveConfig", config);
    }

    /**
    * get the timeout parameter for target lost.
    * 
    * @return time in milliseconds.
    */
    public Future<Integer> getTimeOut() throws DynamicCallException, ExecutionException {
        return call("getTimeOut");
    }

    /**
    * set the timeout parameter for target lost.
    * 
    * @param pTimeMs  time in milliseconds.
    * @return The Future
    */
    public Future<Void> setTimeOut(Integer pTimeMs) throws DynamicCallException, ExecutionException{
        return call("setTimeOut", pTimeMs);
    }

    /**
    * get the maximum distance for target detection in meter.
    * 
    * @return The maximum distance for target detection in meter.
    */
    public Future<Float> getMaximumDistanceDetection() throws DynamicCallException, ExecutionException {
        return call("getMaximumDistanceDetection");
    }

    /**
    * set the maximum target detection distance in meter.
    * 
    * @param pMaxDistance  The maximum distance for target detection in meter.
    * @return The Future
    */
    public Future<Void> setMaximumDistanceDetection(Float pMaxDistance) throws DynamicCallException, ExecutionException{
        return call("setMaximumDistanceDetection", pMaxDistance);
    }

    /**
    * Get active effector.
    * 
    * @return Active effector name. Could be: "Arms", "LArm", "RArm" or "None". 
    */
    public Future<String> getEffector() throws DynamicCallException, ExecutionException {
        return call("getEffector");
    }

    /**
    * Set an end-effector to move for tracking.
    * 
    * @param pEffector  Name of effector. Could be: "Arms", "LArm", "RArm" or "None". 
    * @return The Future
    */
    public Future<Void> setEffector(String pEffector) throws DynamicCallException, ExecutionException{
        return call("setEffector", pEffector);
    }

    /**
    * Initialize tracker parameters with default values.
    * 
    * @return The Future
    */
    public Future<Void> initialize() throws DynamicCallException, ExecutionException{
        return call("initialize");
    }

    /**
    * Set the maximum velocity for tracking.
    * 
    * @param pVelocity  The maximum velocity in rad.s-1 .
    * @return The Future
    */
    public Future<Void> setMaximumVelocity(Float pVelocity) throws DynamicCallException, ExecutionException{
        return call("setMaximumVelocity", pVelocity);
    }

    /**
    * Get the maximum velocity for tracking.
    * 
    * @return The maximum velocity in rad.s-1 .
    */
    public Future<Float> getMaximumVelocity() throws DynamicCallException, ExecutionException {
        return call("getMaximumVelocity");
    }

    /**
    * Set the maximum acceleration for tracking.
    * 
    * @param pAcceleration  The maximum acceleration in rad.s-2 .
    * @return The Future
    */
    public Future<Void> setMaximumAcceleration(Float pAcceleration) throws DynamicCallException, ExecutionException{
        return call("setMaximumAcceleration", pAcceleration);
    }

    /**
    * Get the maximum acceleration for tracking.
    * 
    * @return The maximum acceleration in rad.s-2 .
    */
    public Future<Float> getMaximumAcceleration() throws DynamicCallException, ExecutionException {
        return call("getMaximumAcceleration");
    }

    /**
    * DEPRECATED. Use lookAt with frame instead. Look at the target position with head.

    * 
    * @param pPosition  position 3D [x, y, z] to look in FRAME_TORSO. x position must be striclty positif.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    * @param pUseWholeBody  If true, use whole body constraints.
    * @return The Future
    */
    public Future<Void> lookAt(List<Float> pPosition, Float pFractionMaxSpeed, Boolean pUseWholeBody) throws DynamicCallException, ExecutionException{
        return call("lookAt", pPosition, pFractionMaxSpeed, pUseWholeBody);
    }

    /**
    * DEPRECATED. Use pointAt with frame instead. Point at the target position with arms.

    * 
    * @param pEffector  effector name. Could be "Arms", "LArm", "RArm".
    * @param pPosition  position 3D [x, y, z] to point in FRAME_TORSO. x position must be striclty positif.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    * @return The Future
    */
    public Future<Void> pointAt(String pEffector, List<Float> pPosition, Float pFractionMaxSpeed) throws DynamicCallException, ExecutionException{
        return call("pointAt", pEffector, pPosition, pFractionMaxSpeed);
    }

    /**
    * DEPRECATED. Use pointAt with frame instead. Returns the [x, y, z] position of the target in FRAME_TORSO. This is done assuming an average target size, so it might not be very accurate.
    * 
    * @return Vector of 3 floats corresponding to the target position 3D. 
    */
    public Future<List<Float>> getTargetPosition() throws DynamicCallException, ExecutionException {
        return call("getTargetPosition");
    }

    /**
    * DEPRECATED. Use getSupportedTargets() instead. Return a list of targets names.
    * 
    * @return Valid targets names.
    */
    public Future<List<String>> getTargetNames() throws DynamicCallException, ExecutionException {
        return call("getTargetNames");
    }

    /**
    * DEPRECATED. Use getRegisteredTargets() instead. Return a list of managed targets names.
    * 
    * @return Managed targets names.
    */
    public Future<List<String>> getManagedTargets() throws DynamicCallException, ExecutionException {
        return call("getManagedTargets");
    }

    /**
    * DEPRECATED. Use registerTarget() instead. Add a predefined target. Subscribe to corresponding extractor if Tracker is running..
    * 
    * @param pTarget  a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @param pParams  a target parameters. (RedBall : set diameter of ball.
    * @return The Future
    */
    public Future<Void> addTarget(String pTarget, Object pParams) throws DynamicCallException, ExecutionException{
        return call("addTarget", pTarget, pParams);
    }

    /**
    * DEPRECATED. Use unregisterTarget() instead. Remove target name and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return The Future
    */
    public Future<Void> removeTarget(String pTarget) throws DynamicCallException, ExecutionException{
        return call("removeTarget", pTarget);
    }

    /**
    * DEPRECATED. Use unregisterTargets() instead. Remove a list of target names and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target list to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return The Future
    */
    public Future<Void> removeTargets(List<String> pTarget) throws DynamicCallException, ExecutionException{
        return call("removeTargets", pTarget);
    }

    /**
    * DEPRECATED. Use unregisterAllTargets() instead. Remove all managed targets except active target and stop corresponding extractor.
    * 
    * @return The Future
    */
    public Future<Void> removeAllTargets() throws DynamicCallException, ExecutionException{
        return call("removeAllTargets");
    }

    /**
    * DEPRECATED. Use setEffector instead. Add an end-effector to move for tracking.
    * 
    * @param pEffector  Name of effector. Could be: "Arms", "LArm" or "RArm". 
    * @return The Future
    */
    public Future<Void> addEffector(String pEffector) throws DynamicCallException, ExecutionException{
        return call("addEffector", pEffector);
    }

    /**
    * DEPRECATED. Use setEffector("None") instead. Remove an end-effector from tracking.
    * 
    * @param pEffector  Name of effector. Could be: "Arms", "LArm" or "RArm". 
    * @return The Future
    */
    public Future<Void> removeEffector(String pEffector) throws DynamicCallException, ExecutionException{
        return call("removeEffector", pEffector);
    }

    }
}
    