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
* Manage link with devices (sensors and actuators). See specific documentation.
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/sensors/dcm.html#dcm">NAOqi APIs for DCM </a>
* NAOqi V2.4.x
*/
public class DCM extends ALProxy {

    private AsyncDCM asyncProxy;

    public DCM(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncDCM();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncDCM object
	 */
    public AsyncDCM async() {
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
    * Call this function to send a timed-command list to an actuator
    * 
    * @param commands  AL::ALValue with all data
    */
    public void set(Object commands) throws DynamicCallException, ExecutionException{
        call("set", commands).get();
    }

    /**
    * Call this function to send timed-command list to an alias (list of actuators)
    * 
    * @param commands  AL::ALValue with all data
    */
    public void setAlias(Object commands) throws DynamicCallException, ExecutionException{
        call("setAlias", commands).get();
    }

    /**
    * Call this function to send timed-command list to an alias (list of actuators) with "ClearAll" merge startegy
    * 
    * @param name  alias name
    * @param time  time for the timed command
    * @param commands  std::vector<float> with all commands
    */
    public void setAlias(String name, Integer time, List<Float> commands) throws DynamicCallException, ExecutionException{
        call("setAlias", name, time, commands).get();
    }

    /**
    * Return the DCM time
    * 
    * @param offset  optional time in ms (signed) to add/remove
    * @return An integer (could be signed) with the DCM time
    */
    public Integer getTime(Integer offset) throws DynamicCallException, ExecutionException {
        return (Integer)call("getTime", offset).get();
    }

    /**
    * Create or change an alias (list of actuators)
    * 
    * @param alias  Alias name and description
    * @return Same as pParams, but with the name removed if the actuator is not found
    */
    public Object createAlias(Object alias) throws DynamicCallException, ExecutionException {
        return (Object)call("createAlias", alias).get();
    }

    /**
    * Return the STM base name
    * 
    * @return the STM base name for all device/sensors (1st string in the array) and all devices (2nd string in the array)
    */
    public Object getPrefix() throws DynamicCallException, ExecutionException {
        return (Object)call("getPrefix").get();
    }

    /**
    * Special DCM commands
    * 
    * @param result  one string and could be Reset, Version, Chain, Diagnostic, Config
    */
    public void special(String result) throws DynamicCallException, ExecutionException{
        call("special", result).get();
    }

    /**
    * Calibration of a joint
    * 
    * @param calibrationInput  A complex ALValue. See red documentation
    */
    public void calibration(Object calibrationInput) throws DynamicCallException, ExecutionException{
        call("calibration", calibrationInput).get();
    }

    /**
    * Save updated value from DCM in XML pref file
    * 
    * @param action  string : 'Save' 'Load' 'Add'
    * @param target  string : 'Chest' 'Head' 'Main' 'All' 
    * @param keyName  The name of the key if action = 'Add'.
    * @param keyValue  The ALVAlue of the key to add
    * @return Nothing
    */
    public Integer preferences(String action, String target, String keyName, Object keyValue) throws DynamicCallException, ExecutionException {
        return (Integer)call("preferences", action, target, keyName, keyValue).get();
    }


    public class AsyncDCM extends ALProxy {

        protected AsyncDCM(){
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
    * Call this function to send a timed-command list to an actuator
    * 
    * @param commands  AL::ALValue with all data
    * @return The Future
    */
    public Future<Void> set(Object commands) throws DynamicCallException, ExecutionException{
        return call("set", commands);
    }

    /**
    * Call this function to send timed-command list to an alias (list of actuators)
    * 
    * @param commands  AL::ALValue with all data
    * @return The Future
    */
    public Future<Void> setAlias(Object commands) throws DynamicCallException, ExecutionException{
        return call("setAlias", commands);
    }

    /**
    * Call this function to send timed-command list to an alias (list of actuators) with "ClearAll" merge startegy
    * 
    * @param name  alias name
    * @param time  time for the timed command
    * @param commands  std::vector<float> with all commands
    * @return The Future
    */
    public Future<Void> setAlias(String name, Integer time, List<Float> commands) throws DynamicCallException, ExecutionException{
        return call("setAlias", name, time, commands);
    }

    /**
    * Return the DCM time
    * 
    * @param offset  optional time in ms (signed) to add/remove
    * @return An integer (could be signed) with the DCM time
    */
    public Future<Integer> getTime(Integer offset) throws DynamicCallException, ExecutionException {
        return call("getTime", offset);
    }

    /**
    * Create or change an alias (list of actuators)
    * 
    * @param alias  Alias name and description
    * @return Same as pParams, but with the name removed if the actuator is not found
    */
    public Future<Object> createAlias(Object alias) throws DynamicCallException, ExecutionException {
        return call("createAlias", alias);
    }

    /**
    * Return the STM base name
    * 
    * @return the STM base name for all device/sensors (1st string in the array) and all devices (2nd string in the array)
    */
    public Future<Object> getPrefix() throws DynamicCallException, ExecutionException {
        return call("getPrefix");
    }

    /**
    * Special DCM commands
    * 
    * @param result  one string and could be Reset, Version, Chain, Diagnostic, Config
    * @return The Future
    */
    public Future<Void> special(String result) throws DynamicCallException, ExecutionException{
        return call("special", result);
    }

    /**
    * Calibration of a joint
    * 
    * @param calibrationInput  A complex ALValue. See red documentation
    * @return The Future
    */
    public Future<Void> calibration(Object calibrationInput) throws DynamicCallException, ExecutionException{
        return call("calibration", calibrationInput);
    }

    /**
    * Save updated value from DCM in XML pref file
    * 
    * @param action  string : 'Save' 'Load' 'Add'
    * @param target  string : 'Chest' 'Head' 'Main' 'All' 
    * @param keyName  The name of the key if action = 'Add'.
    * @param keyValue  The ALVAlue of the key to add
    * @return Nothing
    */
    public Future<Integer> preferences(String action, String target, String keyName, Object keyValue) throws DynamicCallException, ExecutionException {
        return call("preferences", action, target, keyName, keyValue);
    }

    }
}
    