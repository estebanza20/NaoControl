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
* Module that manage the background moves automatically started by the robot.
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/interaction/autonomousmoves.html#autonomousmoves">NAOqi APIs for ALAutonomousMoves </a>
* NAOqi V2.4.x
*/
public class ALAutonomousMoves extends ALProxy {

    private AsyncALAutonomousMoves asyncProxy;

    public ALAutonomousMoves(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALAutonomousMoves();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALAutonomousMoves object
	 */
    public AsyncALAutonomousMoves async() {
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
    * DEPRECATED since 2.0: do ALBasicAwareness.setTrackingMode("MoveContextually") instead.Start small base moves.
    * 
    */
    public void startSmallDisplacements() throws DynamicCallException, ExecutionException{
        call("startSmallDisplacements").get();
    }

    /**
    * DEPRECATED since 2.0: do ALBasicAwareness.setTrackingMode instead.Stop small base moves.
    * 
    */
    public void stopSmallDisplacements() throws DynamicCallException, ExecutionException{
        call("stopSmallDisplacements").get();
    }

    /**
    * DEPRECATED since 2.4: Call ALListeningMovement.setEnabled(bool) instead.Enable or disable the listening movements.
    * 
    * @param enable  The boolean value: true to enable, false to disable.
    */
    public void setExpressiveListeningEnabled(Boolean enable) throws DynamicCallException, ExecutionException{
        call("setExpressiveListeningEnabled", enable).get();
    }

    /**
    * DEPRECATED since 2.4: Call ALListeningMovement.isEnabled() instead.If listening movements are enabled.
    * 
    * @return The boolean value: true means it is enabled, false means it is disabled.
    */
    public Boolean getExpressiveListeningEnabled() throws DynamicCallException, ExecutionException {
        return (Boolean)call("getExpressiveListeningEnabled").get();
    }

    /**
    * The background strategy.
    * 
    * @param strategy  The autonomous background posture strategy. ("none" or "backToNeutral")
    */
    public void setBackgroundStrategy(String strategy) throws DynamicCallException, ExecutionException{
        call("setBackgroundStrategy", strategy).get();
    }

    /**
    * Gets the background strategy.
    * 
    * @return The autonomous background posture strategy. ("none" or "backToNeutral")
    */
    public String getBackgroundStrategy() throws DynamicCallException, ExecutionException {
        return (String)call("getBackgroundStrategy").get();
    }


    public class AsyncALAutonomousMoves extends ALProxy {

        protected AsyncALAutonomousMoves(){
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
    * DEPRECATED since 2.0: do ALBasicAwareness.setTrackingMode("MoveContextually") instead.Start small base moves.
    * 
    * @return The Future
    */
    public Future<Void> startSmallDisplacements() throws DynamicCallException, ExecutionException{
        return call("startSmallDisplacements");
    }

    /**
    * DEPRECATED since 2.0: do ALBasicAwareness.setTrackingMode instead.Stop small base moves.
    * 
    * @return The Future
    */
    public Future<Void> stopSmallDisplacements() throws DynamicCallException, ExecutionException{
        return call("stopSmallDisplacements");
    }

    /**
    * DEPRECATED since 2.4: Call ALListeningMovement.setEnabled(bool) instead.Enable or disable the listening movements.
    * 
    * @param enable  The boolean value: true to enable, false to disable.
    * @return The Future
    */
    public Future<Void> setExpressiveListeningEnabled(Boolean enable) throws DynamicCallException, ExecutionException{
        return call("setExpressiveListeningEnabled", enable);
    }

    /**
    * DEPRECATED since 2.4: Call ALListeningMovement.isEnabled() instead.If listening movements are enabled.
    * 
    * @return The boolean value: true means it is enabled, false means it is disabled.
    */
    public Future<Boolean> getExpressiveListeningEnabled() throws DynamicCallException, ExecutionException {
        return call("getExpressiveListeningEnabled");
    }

    /**
    * The background strategy.
    * 
    * @param strategy  The autonomous background posture strategy. ("none" or "backToNeutral")
    * @return The Future
    */
    public Future<Void> setBackgroundStrategy(String strategy) throws DynamicCallException, ExecutionException{
        return call("setBackgroundStrategy", strategy);
    }

    /**
    * Gets the background strategy.
    * 
    * @return The autonomous background posture strategy. ("none" or "backToNeutral")
    */
    public Future<String> getBackgroundStrategy() throws DynamicCallException, ExecutionException {
        return call("getBackgroundStrategy");
    }

    }
}
    