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
* 
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/motion/alrecharge.html#alrecharge">NAOqi APIs for ALRecharge </a>
* NAOqi V2.4.x
*/
public class ALRecharge extends ALProxy {

    private AsyncALRecharge asyncProxy;

    public ALRecharge(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALRecharge();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALRecharge object
	 */
    public AsyncALRecharge async() {
        return asyncProxy;
    }

    /**
    * .
    * 
    */
    public Integer adjustDockingPosition(List<List<Float>> param1) throws DynamicCallException, ExecutionException {
        return (Integer)call("adjustDockingPosition", param1).get();
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
    * .
    * 
    */
    public void goToStation() throws DynamicCallException, ExecutionException{
        call("goToStation").get();
    }

    /**
    * .
    * 
    */
    public Integer leaveStation() throws DynamicCallException, ExecutionException {
        return (Integer)call("leaveStation").get();
    }

    /**
    * .
    * 
    */
    public List<Float> getStationPosition() throws DynamicCallException, ExecutionException {
        return (List<Float>)call("getStationPosition").get();
    }

    /**
    * .
    * 
    */
    public void stopAll() throws DynamicCallException, ExecutionException{
        call("stopAll").get();
    }

    /**
    * .
    * 
    */
    public void subscribe() throws DynamicCallException, ExecutionException{
        call("subscribe").get();
    }

    /**
    * .
    * 
    */
    public void unsubscribe() throws DynamicCallException, ExecutionException{
        call("unsubscribe").get();
    }

    /**
    * .
    * 
    */
    public Integer getStatus() throws DynamicCallException, ExecutionException {
        return (Integer)call("getStatus").get();
    }

    /**
    * .
    * 
    */
    public Object lookForStation() throws DynamicCallException, ExecutionException {
        return (Object)call("lookForStation").get();
    }

    /**
    * .
    * 
    */
    public Integer moveInFrontOfStation() throws DynamicCallException, ExecutionException {
        return (Integer)call("moveInFrontOfStation").get();
    }

    /**
    * .
    * 
    */
    public Integer dockOnStation() throws DynamicCallException, ExecutionException {
        return (Integer)call("dockOnStation").get();
    }

    /**
    * .
    * 
    */
    public void setUseTrackerSearcher(Boolean param1) throws DynamicCallException, ExecutionException{
        call("setUseTrackerSearcher", param1).get();
    }

    /**
    * .
    * 
    */
    public Boolean getUseTrackerSearcher() throws DynamicCallException, ExecutionException {
        return (Boolean)call("getUseTrackerSearcher").get();
    }

    /**
    * .
    * 
    */
    public void setMaxNumberOfTries(Integer param1) throws DynamicCallException, ExecutionException{
        call("setMaxNumberOfTries", param1).get();
    }

    /**
    * .
    * 
    */
    public Integer getMaxNumberOfTries() throws DynamicCallException, ExecutionException {
        return (Integer)call("getMaxNumberOfTries").get();
    }


    public class AsyncALRecharge extends ALProxy {

        protected AsyncALRecharge(){
            super();
        }
    
    /**
    * .
    * 
    */
    public Future<Integer> adjustDockingPosition(List<List<Float>> param1) throws DynamicCallException, ExecutionException {
        return call("adjustDockingPosition", param1);
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
    * .
    * 
    * @return The Future
    */
    public Future<Void> goToStation() throws DynamicCallException, ExecutionException{
        return call("goToStation");
    }

    /**
    * .
    * 
    */
    public Future<Integer> leaveStation() throws DynamicCallException, ExecutionException {
        return call("leaveStation");
    }

    /**
    * .
    * 
    */
    public Future<List<Float>> getStationPosition() throws DynamicCallException, ExecutionException {
        return call("getStationPosition");
    }

    /**
    * .
    * 
    * @return The Future
    */
    public Future<Void> stopAll() throws DynamicCallException, ExecutionException{
        return call("stopAll");
    }

    /**
    * .
    * 
    * @return The Future
    */
    public Future<Void> subscribe() throws DynamicCallException, ExecutionException{
        return call("subscribe");
    }

    /**
    * .
    * 
    * @return The Future
    */
    public Future<Void> unsubscribe() throws DynamicCallException, ExecutionException{
        return call("unsubscribe");
    }

    /**
    * .
    * 
    */
    public Future<Integer> getStatus() throws DynamicCallException, ExecutionException {
        return call("getStatus");
    }

    /**
    * .
    * 
    */
    public Future<Object> lookForStation() throws DynamicCallException, ExecutionException {
        return call("lookForStation");
    }

    /**
    * .
    * 
    */
    public Future<Integer> moveInFrontOfStation() throws DynamicCallException, ExecutionException {
        return call("moveInFrontOfStation");
    }

    /**
    * .
    * 
    */
    public Future<Integer> dockOnStation() throws DynamicCallException, ExecutionException {
        return call("dockOnStation");
    }

    /**
    * .
    * 
    * @return The Future
    */
    public Future<Void> setUseTrackerSearcher(Boolean param1) throws DynamicCallException, ExecutionException{
        return call("setUseTrackerSearcher", param1);
    }

    /**
    * .
    * 
    */
    public Future<Boolean> getUseTrackerSearcher() throws DynamicCallException, ExecutionException {
        return call("getUseTrackerSearcher");
    }

    /**
    * .
    * 
    * @return The Future
    */
    public Future<Void> setMaxNumberOfTries(Integer param1) throws DynamicCallException, ExecutionException{
        return call("setMaxNumberOfTries", param1);
    }

    /**
    * .
    * 
    */
    public Future<Integer> getMaxNumberOfTries() throws DynamicCallException, ExecutionException {
        return call("getMaxNumberOfTries");
    }

    }
}
    