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
* ALlauncher allows to link dynamicaly with library, run executable, unload library, check if module is loaded...
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/allauncher.html#allauncher">NAOqi APIs for ALLauncher </a>
* NAOqi V2.4.x
*/
public class ALLauncher extends ALProxy {

    private AsyncALLauncher asyncProxy;

    public ALLauncher(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALLauncher();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALLauncher object
	 */
    public AsyncALLauncher async() {
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
    * Loads dynamicaly a module
    * 
    * @param moduleName  the name of the module to launch or the name of the python script to evaluate
    * @return list of modules loaded
    */
    public List<String> launchLocal(String moduleName) throws DynamicCallException, ExecutionException {
        return (List<String>)call("launchLocal", moduleName).get();
    }

    /**
    * runs an executable and connect it to current broker (executable)
    * 
    * @param moduleName  the name of the module to launch or the name of the script file to execute
    * @return true if ok
    */
    public Boolean launchExecutable(String moduleName) throws DynamicCallException, ExecutionException {
        return (Boolean)call("launchExecutable", moduleName).get();
    }

    /**
    * runs a script connected the current broker
    * 
    * @param moduleName  the name of the script to launch (python)
    * @return true if ok
    */
    public Boolean launchScript(String moduleName) throws DynamicCallException, ExecutionException {
        return (Boolean)call("launchScript", moduleName).get();
    }

    /**
    * Import a python module
    * 
    * @param moduleName  the name of the module to launch
    * @return true if ok
    */
    public Boolean launchPythonModule(String moduleName) throws DynamicCallException, ExecutionException {
        return (Boolean)call("launchPythonModule", moduleName).get();
    }

    /**
    * Tests the existence of an active module in the global system (in same executable or in another executable of the distributed system)
    * 
    * @param strPartOfModuleName  a part of the name of the module to test existence
    * @return the returned value is true if this module is present
    */
    public Boolean isModulePresent(String strPartOfModuleName) throws DynamicCallException, ExecutionException {
        return (Boolean)call("isModulePresent", strPartOfModuleName).get();
    }

    /**
    * get the list of modules loaded on the robot and connected on the robot
    * 
    * @return array of present modules
    */
    public List<String> getGlobalModuleList() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getGlobalModuleList").get();
    }


    public class AsyncALLauncher extends ALProxy {

        protected AsyncALLauncher(){
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
    * Loads dynamicaly a module
    * 
    * @param moduleName  the name of the module to launch or the name of the python script to evaluate
    * @return list of modules loaded
    */
    public Future<List<String>> launchLocal(String moduleName) throws DynamicCallException, ExecutionException {
        return call("launchLocal", moduleName);
    }

    /**
    * runs an executable and connect it to current broker (executable)
    * 
    * @param moduleName  the name of the module to launch or the name of the script file to execute
    * @return true if ok
    */
    public Future<Boolean> launchExecutable(String moduleName) throws DynamicCallException, ExecutionException {
        return call("launchExecutable", moduleName);
    }

    /**
    * runs a script connected the current broker
    * 
    * @param moduleName  the name of the script to launch (python)
    * @return true if ok
    */
    public Future<Boolean> launchScript(String moduleName) throws DynamicCallException, ExecutionException {
        return call("launchScript", moduleName);
    }

    /**
    * Import a python module
    * 
    * @param moduleName  the name of the module to launch
    * @return true if ok
    */
    public Future<Boolean> launchPythonModule(String moduleName) throws DynamicCallException, ExecutionException {
        return call("launchPythonModule", moduleName);
    }

    /**
    * Tests the existence of an active module in the global system (in same executable or in another executable of the distributed system)
    * 
    * @param strPartOfModuleName  a part of the name of the module to test existence
    * @return the returned value is true if this module is present
    */
    public Future<Boolean> isModulePresent(String strPartOfModuleName) throws DynamicCallException, ExecutionException {
        return call("isModulePresent", strPartOfModuleName);
    }

    /**
    * get the list of modules loaded on the robot and connected on the robot
    * 
    * @return array of present modules
    */
    public Future<List<String>> getGlobalModuleList() throws DynamicCallException, ExecutionException {
        return call("getGlobalModuleList");
    }

    }
}
    