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
* Use ALNavigation module to make the robot go safely to the asked pose2D.
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/motion/alnavigation.html#alnavigation">NAOqi APIs for ALNavigation </a>
* NAOqi V2.4.x
*/
public class ALNavigation extends ALProxy {

    private AsyncALNavigation asyncProxy;

    public ALNavigation(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALNavigation();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALNavigation object
	 */
    public AsyncALNavigation async() {
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
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    */
    public Boolean navigateTo(Float x, Float y) throws DynamicCallException, ExecutionException {
        return (Boolean)call("navigateTo", x, y).get();
    }

    /**
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param config  Configuration ALValue. For example, [["SpeedFactor", 0.5]] sets speedFactor to 0.5
    */
    public Boolean navigateTo(Float x, Float y, Object config) throws DynamicCallException, ExecutionException {
        return (Boolean)call("navigateTo", x, y, config).get();
    }

    /**
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  Orientation of the robot (rad).
    */
    public Boolean navigateTo(Float x, Float y, Float theta) throws DynamicCallException, ExecutionException {
        return (Boolean)call("navigateTo", x, y, theta).get();
    }

    /**
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  Orientation of the robot (rad).
    * @param config  Configuration ALValue. For example, [["SpeedFactor", 0.5]] sets speedFactor to 0.5
    */
    public Boolean navigateTo(Float x, Float y, Float theta, Object config) throws DynamicCallException, ExecutionException {
        return (Boolean)call("navigateTo", x, y, theta, config).get();
    }

    /**
    * Makes the robot move at the given position.This is a blocking call.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The angle around z axis [rad].
    */
    public void moveTo(Float x, Float y, Float theta) throws DynamicCallException, ExecutionException{
        call("moveTo", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given position.This is a blocking call.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The angle around z axis [rad].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveTo(Float x, Float y, Float theta, Object moveConfig) throws DynamicCallException, ExecutionException{
        call("moveTo", x, y, theta, moveConfig).get();
    }

    /**
    * Makes the robot move at the given speed in S.I. units. This is a blocking call.
    * 
    * @param x  The speed along x axis [m.s-1].
    * @param y  The speed along y axis [m.s-1].
    * @param theta  The anglular speed around z axis [rad.s-1].
    */
    public void move(Float x, Float y, Float theta) throws DynamicCallException, ExecutionException{
        call("move", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given speed in S.I. units. This is a blocking call.
    * 
    * @param x  The speed along x axis [m.s-1].
    * @param y  The speed along y axis [m.s-1].
    * @param theta  The anglular speed around z axis [rad.s-1].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void move(Float x, Float y, Float theta, Object moveConfig) throws DynamicCallException, ExecutionException{
        call("move", x, y, theta, moveConfig).get();
    }

    /**
    * Makes the robot move at the given speed in normalized speed fraction. This is a blocking call.
    * 
    * @param x  The speed along x axis [0.0-1.0].
    * @param y  The speed along y axis [0.0-1.0].
    * @param theta  The anglular speed around z axis [0.0-1.0].
    */
    public void moveToward(Float x, Float y, Float theta) throws DynamicCallException, ExecutionException{
        call("moveToward", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given speed in normalized speed fraction. This is a blocking call.
    * 
    * @param x  The speed along x axis [0.0-1.0].
    * @param y  The speed along y axis [0.0-1.0].
    * @param theta  The anglular speed around z axis [0.0-1.0].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveToward(Float x, Float y, Float theta, Object moveConfig) throws DynamicCallException, ExecutionException{
        call("moveToward", x, y, theta, moveConfig).get();
    }

    /**
    * Distance in meters fromwhich the robot should stop if there is an obstacle.
    * 
    */
    public void setSecurityDistance(Float param1) throws DynamicCallException, ExecutionException{
        call("setSecurityDistance", param1).get();
    }

    /**
    * Distance in meters fromwhich the robot should stop if there is an obstacle.
    * 
    */
    public Float getSecurityDistance() throws DynamicCallException, ExecutionException {
        return (Float)call("getSecurityDistance").get();
    }

    /**
    * Stops the navigateTo.
    * 
    */
    public void stopNavigateTo() throws DynamicCallException, ExecutionException{
        call("stopNavigateTo").get();
    }

    /**
    * .
    * 
    * @param trajectory  An ALValue describing a trajectory.
    */
    public Boolean moveAlong(Object trajectory) throws DynamicCallException, ExecutionException {
        return (Boolean)call("moveAlong", trajectory).get();
    }

    /**
    *  Starts a loop to update the mapping of the free space around the robot. 
    * 
    */
    public void startFreeZoneUpdate() throws DynamicCallException, ExecutionException{
        call("startFreeZoneUpdate").get();
    }

    /**
    * Stops and returns free zone.
    * 
    * @param desiredRadius  The radius of the space we want in meters [m].
    * @param maximumDisplacement  The max distance we accept to move toreach the found place [m].
    * @return Returns [errorCode, result radius (m), [worldMotionToRobotCenterX (m), worldMotionToRobotCenterY (m)]]
    */
    public Object stopAndComputeFreeZone(Float desiredRadius, Float maximumDisplacement) throws DynamicCallException, ExecutionException {
        return (Object)call("stopAndComputeFreeZone", desiredRadius, maximumDisplacement).get();
    }

    /**
    * Returns [errorCode, result radius[centerWorldMotionX, centerWorldMotionY]]
    * 
    * @param desiredRadius  The radius of the space we want in meters [m].
    * @param maximumDisplacement  The max distance we accept to move toreach the found place [m].
    * @return Returns [errorCode, result radius (m), [worldMotionToRobotCenterX (m), worldMotionToRobotCenterY (m)]]
    */
    public Object findFreeZone(Float desiredRadius, Float maximumDisplacement) throws DynamicCallException, ExecutionException {
        return (Object)call("findFreeZone", desiredRadius, maximumDisplacement).get();
    }


    public class AsyncALNavigation extends ALProxy {

        protected AsyncALNavigation(){
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
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    */
    public Future<Boolean> navigateTo(Float x, Float y) throws DynamicCallException, ExecutionException {
        return call("navigateTo", x, y);
    }

    /**
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param config  Configuration ALValue. For example, [["SpeedFactor", 0.5]] sets speedFactor to 0.5
    */
    public Future<Boolean> navigateTo(Float x, Float y, Object config) throws DynamicCallException, ExecutionException {
        return call("navigateTo", x, y, config);
    }

    /**
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  Orientation of the robot (rad).
    */
    public Future<Boolean> navigateTo(Float x, Float y, Float theta) throws DynamicCallException, ExecutionException {
        return call("navigateTo", x, y, theta);
    }

    /**
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  Orientation of the robot (rad).
    * @param config  Configuration ALValue. For example, [["SpeedFactor", 0.5]] sets speedFactor to 0.5
    */
    public Future<Boolean> navigateTo(Float x, Float y, Float theta, Object config) throws DynamicCallException, ExecutionException {
        return call("navigateTo", x, y, theta, config);
    }

    /**
    * Makes the robot move at the given position.This is a blocking call.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The angle around z axis [rad].
    * @return The Future
    */
    public Future<Void> moveTo(Float x, Float y, Float theta) throws DynamicCallException, ExecutionException{
        return call("moveTo", x, y, theta);
    }

    /**
    * Makes the robot move at the given position.This is a blocking call.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The angle around z axis [rad].
    * @param moveConfig  An ALValue with custom move configuration.
    * @return The Future
    */
    public Future<Void> moveTo(Float x, Float y, Float theta, Object moveConfig) throws DynamicCallException, ExecutionException{
        return call("moveTo", x, y, theta, moveConfig);
    }

    /**
    * Makes the robot move at the given speed in S.I. units. This is a blocking call.
    * 
    * @param x  The speed along x axis [m.s-1].
    * @param y  The speed along y axis [m.s-1].
    * @param theta  The anglular speed around z axis [rad.s-1].
    * @return The Future
    */
    public Future<Void> move(Float x, Float y, Float theta) throws DynamicCallException, ExecutionException{
        return call("move", x, y, theta);
    }

    /**
    * Makes the robot move at the given speed in S.I. units. This is a blocking call.
    * 
    * @param x  The speed along x axis [m.s-1].
    * @param y  The speed along y axis [m.s-1].
    * @param theta  The anglular speed around z axis [rad.s-1].
    * @param moveConfig  An ALValue with custom move configuration.
    * @return The Future
    */
    public Future<Void> move(Float x, Float y, Float theta, Object moveConfig) throws DynamicCallException, ExecutionException{
        return call("move", x, y, theta, moveConfig);
    }

    /**
    * Makes the robot move at the given speed in normalized speed fraction. This is a blocking call.
    * 
    * @param x  The speed along x axis [0.0-1.0].
    * @param y  The speed along y axis [0.0-1.0].
    * @param theta  The anglular speed around z axis [0.0-1.0].
    * @return The Future
    */
    public Future<Void> moveToward(Float x, Float y, Float theta) throws DynamicCallException, ExecutionException{
        return call("moveToward", x, y, theta);
    }

    /**
    * Makes the robot move at the given speed in normalized speed fraction. This is a blocking call.
    * 
    * @param x  The speed along x axis [0.0-1.0].
    * @param y  The speed along y axis [0.0-1.0].
    * @param theta  The anglular speed around z axis [0.0-1.0].
    * @param moveConfig  An ALValue with custom move configuration.
    * @return The Future
    */
    public Future<Void> moveToward(Float x, Float y, Float theta, Object moveConfig) throws DynamicCallException, ExecutionException{
        return call("moveToward", x, y, theta, moveConfig);
    }

    /**
    * Distance in meters fromwhich the robot should stop if there is an obstacle.
    * 
    * @return The Future
    */
    public Future<Void> setSecurityDistance(Float param1) throws DynamicCallException, ExecutionException{
        return call("setSecurityDistance", param1);
    }

    /**
    * Distance in meters fromwhich the robot should stop if there is an obstacle.
    * 
    */
    public Future<Float> getSecurityDistance() throws DynamicCallException, ExecutionException {
        return call("getSecurityDistance");
    }

    /**
    * Stops the navigateTo.
    * 
    * @return The Future
    */
    public Future<Void> stopNavigateTo() throws DynamicCallException, ExecutionException{
        return call("stopNavigateTo");
    }

    /**
    * .
    * 
    * @param trajectory  An ALValue describing a trajectory.
    */
    public Future<Boolean> moveAlong(Object trajectory) throws DynamicCallException, ExecutionException {
        return call("moveAlong", trajectory);
    }

    /**
    *  Starts a loop to update the mapping of the free space around the robot. 
    * 
    * @return The Future
    */
    public Future<Void> startFreeZoneUpdate() throws DynamicCallException, ExecutionException{
        return call("startFreeZoneUpdate");
    }

    /**
    * Stops and returns free zone.
    * 
    * @param desiredRadius  The radius of the space we want in meters [m].
    * @param maximumDisplacement  The max distance we accept to move toreach the found place [m].
    * @return Returns [errorCode, result radius (m), [worldMotionToRobotCenterX (m), worldMotionToRobotCenterY (m)]]
    */
    public Future<Object> stopAndComputeFreeZone(Float desiredRadius, Float maximumDisplacement) throws DynamicCallException, ExecutionException {
        return call("stopAndComputeFreeZone", desiredRadius, maximumDisplacement);
    }

    /**
    * Returns [errorCode, result radius[centerWorldMotionX, centerWorldMotionY]]
    * 
    * @param desiredRadius  The radius of the space we want in meters [m].
    * @param maximumDisplacement  The max distance we accept to move toreach the found place [m].
    * @return Returns [errorCode, result radius (m), [worldMotionToRobotCenterX (m), worldMotionToRobotCenterY (m)]]
    */
    public Future<Object> findFreeZone(Float desiredRadius, Float maximumDisplacement) throws DynamicCallException, ExecutionException {
        return call("findFreeZone", desiredRadius, maximumDisplacement);
    }

    }
}
    