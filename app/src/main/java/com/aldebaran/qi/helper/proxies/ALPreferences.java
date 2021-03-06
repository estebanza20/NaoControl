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
* ALPreferences allows access to xml preference files. 
A preference is defined as follows : 
pParams[0] Name of the preference; 
pParams[1] Description of the preference; 
pParams[2] The value of the preference (can contain other preferences); 
pParams[3] (optional) The name of the data when inserted into memory.
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/alpreferences.html#alpreferences">NAOqi APIs for ALPreferences </a>
* NAOqi V2.4.x
*/
public class ALPreferences extends ALProxy {

    private AsyncALPreferences asyncProxy;

    public ALPreferences(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALPreferences();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALPreferences object
	 */
    public AsyncALPreferences async() {
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
    * Reads all preferences from an xml files and stores them in an ALValue.
    * 
    * @param fileName  Name of the module associated to the preference.
    * @param autoGenerateMemoryNames  If true a memory name will be generated for each non-array preference.
    * @return array reprenting the whole file.
    */
    public Object readPrefFile(String fileName, Boolean autoGenerateMemoryNames) throws DynamicCallException, ExecutionException {
        return (Object)call("readPrefFile", fileName, autoGenerateMemoryNames).get();
    }

    /**
    * Writes all preferences from ALValue to an xml file.
    * 
    * @param fileName  Name of the module associated to the preference.
    * @param prefs  array reprenting the whole file.
    * @param ignoreMemoryNames  If true all memory names will be removed before saving.
    */
    public void writePrefFile(String fileName, Object prefs, Boolean ignoreMemoryNames) throws DynamicCallException, ExecutionException{
        call("writePrefFile", fileName, prefs, ignoreMemoryNames).get();
    }

    /**
    * Remove the xml file.
    * 
    * @param fileName  Name of the module associated to the preference.
    */
    public void removePrefFile(String fileName) throws DynamicCallException, ExecutionException{
        call("removePrefFile", fileName).get();
    }

    /**
    * Writes all preferences from ALValue to an xml file.
    * 
    * @param prefs  array representing the whole file.
    * @return True upon success.
    */
    public Boolean saveToMemory(Object prefs) throws DynamicCallException, ExecutionException {
        return (Boolean)call("saveToMemory", prefs).get();
    }


    public class AsyncALPreferences extends ALProxy {

        protected AsyncALPreferences(){
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
    * Reads all preferences from an xml files and stores them in an ALValue.
    * 
    * @param fileName  Name of the module associated to the preference.
    * @param autoGenerateMemoryNames  If true a memory name will be generated for each non-array preference.
    * @return array reprenting the whole file.
    */
    public Future<Object> readPrefFile(String fileName, Boolean autoGenerateMemoryNames) throws DynamicCallException, ExecutionException {
        return call("readPrefFile", fileName, autoGenerateMemoryNames);
    }

    /**
    * Writes all preferences from ALValue to an xml file.
    * 
    * @param fileName  Name of the module associated to the preference.
    * @param prefs  array reprenting the whole file.
    * @param ignoreMemoryNames  If true all memory names will be removed before saving.
    * @return The Future
    */
    public Future<Void> writePrefFile(String fileName, Object prefs, Boolean ignoreMemoryNames) throws DynamicCallException, ExecutionException{
        return call("writePrefFile", fileName, prefs, ignoreMemoryNames);
    }

    /**
    * Remove the xml file.
    * 
    * @param fileName  Name of the module associated to the preference.
    * @return The Future
    */
    public Future<Void> removePrefFile(String fileName) throws DynamicCallException, ExecutionException{
        return call("removePrefFile", fileName);
    }

    /**
    * Writes all preferences from ALValue to an xml file.
    * 
    * @param prefs  array representing the whole file.
    * @return True upon success.
    */
    public Future<Boolean> saveToMemory(Object prefs) throws DynamicCallException, ExecutionException {
        return call("saveToMemory", prefs);
    }

    }
}
    