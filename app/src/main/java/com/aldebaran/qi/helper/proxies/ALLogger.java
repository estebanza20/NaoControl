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
* This module allows you log errors, warnings, and info stdout or a file. The verbosity level allow you to  customize the output.
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/allogger.html#allogger">NAOqi APIs for ALLogger </a>
* NAOqi V2.4.x
*/
public class ALLogger extends ALProxy {

    private AsyncALLogger asyncProxy;

    public ALLogger(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALLogger();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALLogger object
	 */
    public AsyncALLogger async() {
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
    * DEPRECATED. Use qiLogFatal instead. 
 Log a fatal error.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void fatal(String moduleName, String message) throws DynamicCallException, ExecutionException{
        call("fatal", moduleName, message).get();
    }

    /**
    * DEPRECATED. Use qiLogError instead. 
 Log an error.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void error(String moduleName, String message) throws DynamicCallException, ExecutionException{
        call("error", moduleName, message).get();
    }

    /**
    * DEPRECATED: use qiLogWarning instead. Log a warning.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void warn(String moduleName, String message) throws DynamicCallException, ExecutionException{
        call("warn", moduleName, message).get();
    }

    /**
    * DEPRECATED. Use qiLogInfo instead. 
 Log a info message.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void info(String moduleName, String message) throws DynamicCallException, ExecutionException{
        call("info", moduleName, message).get();
    }

    /**
    * DEPRECATED. Use qiLogDebug instead. 
 Log a debug message.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void debug(String moduleName, String message) throws DynamicCallException, ExecutionException{
        call("debug", moduleName, message).get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public void setVerbosity(String param1) throws DynamicCallException, ExecutionException{
        call("setVerbosity", param1).get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public Integer verbosity() throws DynamicCallException, ExecutionException {
        return (Integer)call("verbosity").get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public void logInFile(String param1) throws DynamicCallException, ExecutionException{
        call("logInFile", param1).get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public void logInForwarder(String param1) throws DynamicCallException, ExecutionException{
        call("logInForwarder", param1).get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public void removeHandler(String param1) throws DynamicCallException, ExecutionException{
        call("removeHandler", param1).get();
    }


    public class AsyncALLogger extends ALProxy {

        protected AsyncALLogger(){
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
    * DEPRECATED. Use qiLogFatal instead. 
 Log a fatal error.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    * @return The Future
    */
    public Future<Void> fatal(String moduleName, String message) throws DynamicCallException, ExecutionException{
        return call("fatal", moduleName, message);
    }

    /**
    * DEPRECATED. Use qiLogError instead. 
 Log an error.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    * @return The Future
    */
    public Future<Void> error(String moduleName, String message) throws DynamicCallException, ExecutionException{
        return call("error", moduleName, message);
    }

    /**
    * DEPRECATED: use qiLogWarning instead. Log a warning.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    * @return The Future
    */
    public Future<Void> warn(String moduleName, String message) throws DynamicCallException, ExecutionException{
        return call("warn", moduleName, message);
    }

    /**
    * DEPRECATED. Use qiLogInfo instead. 
 Log a info message.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    * @return The Future
    */
    public Future<Void> info(String moduleName, String message) throws DynamicCallException, ExecutionException{
        return call("info", moduleName, message);
    }

    /**
    * DEPRECATED. Use qiLogDebug instead. 
 Log a debug message.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    * @return The Future
    */
    public Future<Void> debug(String moduleName, String message) throws DynamicCallException, ExecutionException{
        return call("debug", moduleName, message);
    }

    /**
    * Removed: not implemented anymore.
    * 
    * @return The Future
    */
    public Future<Void> setVerbosity(String param1) throws DynamicCallException, ExecutionException{
        return call("setVerbosity", param1);
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public Future<Integer> verbosity() throws DynamicCallException, ExecutionException {
        return call("verbosity");
    }

    /**
    * Removed: not implemented anymore.
    * 
    * @return The Future
    */
    public Future<Void> logInFile(String param1) throws DynamicCallException, ExecutionException{
        return call("logInFile", param1);
    }

    /**
    * Removed: not implemented anymore.
    * 
    * @return The Future
    */
    public Future<Void> logInForwarder(String param1) throws DynamicCallException, ExecutionException{
        return call("logInForwarder", param1);
    }

    /**
    * Removed: not implemented anymore.
    * 
    * @return The Future
    */
    public Future<Void> removeHandler(String param1) throws DynamicCallException, ExecutionException{
        return call("removeHandler", param1);
    }

    }
}
    