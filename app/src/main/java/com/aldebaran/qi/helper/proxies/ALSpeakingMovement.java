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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/interaction/autonomousabilities/alspeakingmovement.html#alspeakingmovement">NAOqi APIs for ALSpeakingMovement </a>
* NAOqi V2.4.x
*/
public class ALSpeakingMovement extends ALProxy {

    private AsyncALSpeakingMovement asyncProxy;

    public ALSpeakingMovement(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALSpeakingMovement();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALSpeakingMovement object
	 */
    public AsyncALSpeakingMovement async() {
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
    * 
    * 
    */
    public void setEnabled(Boolean param1) throws DynamicCallException, ExecutionException{
        call("setEnabled", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean isEnabled() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isEnabled").get();
    }

    /**
    * 
    * 
    */
    public Boolean isRunning() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isRunning").get();
    }

    /**
    * 
    * 
    */
    public void setMode(String param1) throws DynamicCallException, ExecutionException{
        call("setMode", param1).get();
    }

    /**
    * 
    * 
    */
    public String getMode() throws DynamicCallException, ExecutionException {
        return (String)call("getMode").get();
    }

    /**
    * 
    * 
    */
    public void addTagsToWords(Object param1) throws DynamicCallException, ExecutionException{
        call("addTagsToWords", param1).get();
    }

    /**
    * 
    * 
    */
    public void resetTagsToWords() throws DynamicCallException, ExecutionException{
        call("resetTagsToWords").get();
    }


    public class AsyncALSpeakingMovement extends ALProxy {

        protected AsyncALSpeakingMovement(){
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
    * 
    * 
    * @return The Future
    */
    public Future<Void> setEnabled(Boolean param1) throws DynamicCallException, ExecutionException{
        return call("setEnabled", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isEnabled() throws DynamicCallException, ExecutionException {
        return call("isEnabled");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isRunning() throws DynamicCallException, ExecutionException {
        return call("isRunning");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> setMode(String param1) throws DynamicCallException, ExecutionException{
        return call("setMode", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> getMode() throws DynamicCallException, ExecutionException {
        return call("getMode");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> addTagsToWords(Object param1) throws DynamicCallException, ExecutionException{
        return call("addTagsToWords", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> resetTagsToWords() throws DynamicCallException, ExecutionException{
        return call("resetTagsToWords");
    }

    }
}
    