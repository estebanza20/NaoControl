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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/alpreferencemanager.html#alpreferencemanager">NAOqi APIs for ALPreferenceManager </a>
* NAOqi V2.4.x
*/
public class ALPreferenceManager extends ALProxy {

    private AsyncALPreferenceManager asyncProxy;

    public ALPreferenceManager(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALPreferenceManager();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALPreferenceManager object
	 */
    public AsyncALPreferenceManager async() {
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
    * Get specified preference
    * 
    * @param domain  Preference domain
    * @param setting  Preference setting
    * @return corresponding preferences value
    */
    public Object getValue(String domain, String setting) throws DynamicCallException, ExecutionException {
        return (Object)call("getValue", domain, setting).get();
    }

    /**
    * Set specified preference
    * 
    * @param domain  Preference domain
    * @param setting  Preference setting
    * @param value  Preference value
    */
    public void setValue(String domain, String setting, Object value) throws DynamicCallException, ExecutionException{
        call("setValue", domain, setting, value).get();
    }

    /**
    * Get preferences names and values for a given domain
    * 
    * @param domain  Preference domain
    * @return a list of preferences names and values associated to the domain
    */
    public List<List<Object>> getValueList(String domain) throws DynamicCallException, ExecutionException {
        return (List<List<Object>>)call("getValueList", domain).get();
    }

    /**
    * Get available preferences domain
    * 
    * @return a list containing all the available domain names
    */
    public List<String> getDomainList() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getDomainList").get();
    }

    /**
    * Remove specified preference
    * 
    * @param domain  Preference domain
    * @param setting  Preference setting
    */
    public void removeValue(String domain, String setting) throws DynamicCallException, ExecutionException{
        call("removeValue", domain, setting).get();
    }

    /**
    * Add many values at once.
    * 
    * @param values  A map (domain as index) of map (setting name as index) of values.
    */
    public void setValues(Map<String, Map<String, Object>> values) throws DynamicCallException, ExecutionException{
        call("setValues", values).get();
    }

    /**
    * Remove an entire preference domain
    * 
    * @param domain  Preference domain
    */
    public void removeDomainValues(String domain) throws DynamicCallException, ExecutionException{
        call("removeDomainValues", domain).get();
    }

    /**
    * Import a preferences XML file
    * 
    * @param domain  Preference domain: all preferences values found in XML file will be imported in that domain.
    * @param applicationName  Application name: will be used to search for preference file on disk (in location of type <configurationdirectory>/applicationName/filename).
    * @param filename  Preference XML filename
    * @param override  Set this to true if you want to override preferences that already exist with preferences in imported XML file
    */
    public void importPrefFile(String domain, String applicationName, String filename, Boolean override) throws DynamicCallException, ExecutionException{
        call("importPrefFile", domain, applicationName, filename, override).get();
    }

    /**
    * Synchronizes local preferences with preferences stored on a server.
    * 
    */
    public void update() throws DynamicCallException, ExecutionException{
        call("update").get();
    }


    public class AsyncALPreferenceManager extends ALProxy {

        protected AsyncALPreferenceManager(){
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
    * Get specified preference
    * 
    * @param domain  Preference domain
    * @param setting  Preference setting
    * @return corresponding preferences value
    */
    public Future<Object> getValue(String domain, String setting) throws DynamicCallException, ExecutionException {
        return call("getValue", domain, setting);
    }

    /**
    * Set specified preference
    * 
    * @param domain  Preference domain
    * @param setting  Preference setting
    * @param value  Preference value
    * @return The Future
    */
    public Future<Void> setValue(String domain, String setting, Object value) throws DynamicCallException, ExecutionException{
        return call("setValue", domain, setting, value);
    }

    /**
    * Get preferences names and values for a given domain
    * 
    * @param domain  Preference domain
    * @return a list of preferences names and values associated to the domain
    */
    public Future<List<List<Object>>> getValueList(String domain) throws DynamicCallException, ExecutionException {
        return call("getValueList", domain);
    }

    /**
    * Get available preferences domain
    * 
    * @return a list containing all the available domain names
    */
    public Future<List<String>> getDomainList() throws DynamicCallException, ExecutionException {
        return call("getDomainList");
    }

    /**
    * Remove specified preference
    * 
    * @param domain  Preference domain
    * @param setting  Preference setting
    * @return The Future
    */
    public Future<Void> removeValue(String domain, String setting) throws DynamicCallException, ExecutionException{
        return call("removeValue", domain, setting);
    }

    /**
    * Add many values at once.
    * 
    * @param values  A map (domain as index) of map (setting name as index) of values.
    * @return The Future
    */
    public Future<Void> setValues(Map<String, Map<String, Object>> values) throws DynamicCallException, ExecutionException{
        return call("setValues", values);
    }

    /**
    * Remove an entire preference domain
    * 
    * @param domain  Preference domain
    * @return The Future
    */
    public Future<Void> removeDomainValues(String domain) throws DynamicCallException, ExecutionException{
        return call("removeDomainValues", domain);
    }

    /**
    * Import a preferences XML file
    * 
    * @param domain  Preference domain: all preferences values found in XML file will be imported in that domain.
    * @param applicationName  Application name: will be used to search for preference file on disk (in location of type <configurationdirectory>/applicationName/filename).
    * @param filename  Preference XML filename
    * @param override  Set this to true if you want to override preferences that already exist with preferences in imported XML file
    * @return The Future
    */
    public Future<Void> importPrefFile(String domain, String applicationName, String filename, Boolean override) throws DynamicCallException, ExecutionException{
        return call("importPrefFile", domain, applicationName, filename, override);
    }

    /**
    * Synchronizes local preferences with preferences stored on a server.
    * 
    * @return The Future
    */
    public Future<Void> update() throws DynamicCallException, ExecutionException{
        return call("update");
    }

    }
}
    