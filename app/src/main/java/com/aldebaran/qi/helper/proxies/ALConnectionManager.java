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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/connectionmanager/index.html#alconnectionmanager">NAOqi APIs for ALConnectionManager </a>
* NAOqi V2.4.x
*/
public class ALConnectionManager extends ALProxy {

    private AsyncALConnectionManager asyncProxy;

    public ALConnectionManager(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALConnectionManager();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALConnectionManager object
	 */
    public AsyncALConnectionManager async() {
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
    public Object services() throws DynamicCallException, ExecutionException {
        return (Object)call("services").get();
    }

    /**
    * 
    * 
    */
    public Object service(String param1) throws DynamicCallException, ExecutionException {
        return (Object)call("service", param1).get();
    }

    /**
    * 
    * 
    */
    public void scan(String param1) throws DynamicCallException, ExecutionException{
        call("scan", param1).get();
    }

    /**
    * 
    * 
    */
    public void scan() throws DynamicCallException, ExecutionException{
        call("scan").get();
    }

    /**
    * 
    * 
    */
    public void setServiceConfiguration(Object param1) throws DynamicCallException, ExecutionException{
        call("setServiceConfiguration", param1).get();
    }

    /**
    * 
    * 
    */
    public void setServiceInput(Object param1) throws DynamicCallException, ExecutionException{
        call("setServiceInput", param1).get();
    }

    /**
    * 
    * 
    */
    public String state() throws DynamicCallException, ExecutionException {
        return (String)call("state").get();
    }

    /**
    * 
    * 
    */
    public void forget(String param1) throws DynamicCallException, ExecutionException{
        call("forget", param1).get();
    }

    /**
    * 
    * 
    */
    public void connect(String param1) throws DynamicCallException, ExecutionException{
        call("connect", param1).get();
    }

    /**
    * 
    * 
    */
    public void disconnect(String param1) throws DynamicCallException, ExecutionException{
        call("disconnect", param1).get();
    }

    /**
    * 
    * 
    */
    public Object technologies() throws DynamicCallException, ExecutionException {
        return (Object)call("technologies").get();
    }

    /**
    * 
    * 
    */
    public void enableTethering(String param1, String param2, String param3) throws DynamicCallException, ExecutionException{
        call("enableTethering", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public void enableTethering(String param1) throws DynamicCallException, ExecutionException{
        call("enableTethering", param1).get();
    }

    /**
    * 
    * 
    */
    public void disableTethering(String param1) throws DynamicCallException, ExecutionException{
        call("disableTethering", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean getTetheringEnable(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("getTetheringEnable", param1).get();
    }

    /**
    * 
    * 
    */
    public String tetheringName(String param1) throws DynamicCallException, ExecutionException {
        return (String)call("tetheringName", param1).get();
    }

    /**
    * 
    * 
    */
    public String tetheringPassphrase(String param1) throws DynamicCallException, ExecutionException {
        return (String)call("tetheringPassphrase", param1).get();
    }

    /**
    * 
    * 
    */
    public List<String> countries() throws DynamicCallException, ExecutionException {
        return (List<String>)call("countries").get();
    }

    /**
    * 
    * 
    */
    public void setCountry(String param1) throws DynamicCallException, ExecutionException{
        call("setCountry", param1).get();
    }

    /**
    * 
    * 
    */
    public String country() throws DynamicCallException, ExecutionException {
        return (String)call("country").get();
    }

    /**
    * 
    * 
    */
    public Object interfaces() throws DynamicCallException, ExecutionException {
        return (Object)call("interfaces").get();
    }

    /**
    * 
    * 
    */
    public void provisionService(Map<String, String> param1) throws DynamicCallException, ExecutionException{
        call("provisionService", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Map<String, String>> provisionedServices() throws DynamicCallException, ExecutionException {
        return (List<Map<String, String>>)call("provisionedServices").get();
    }

    /**
    * 
    * 
    */
    public void removeProvisionedService(String param1) throws DynamicCallException, ExecutionException{
        call("removeProvisionedService", param1).get();
    }


    public class AsyncALConnectionManager extends ALProxy {

        protected AsyncALConnectionManager(){
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
    */
    public Future<Object> services() throws DynamicCallException, ExecutionException {
        return call("services");
    }

    /**
    * 
    * 
    */
    public Future<Object> service(String param1) throws DynamicCallException, ExecutionException {
        return call("service", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> scan(String param1) throws DynamicCallException, ExecutionException{
        return call("scan", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> scan() throws DynamicCallException, ExecutionException{
        return call("scan");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> setServiceConfiguration(Object param1) throws DynamicCallException, ExecutionException{
        return call("setServiceConfiguration", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> setServiceInput(Object param1) throws DynamicCallException, ExecutionException{
        return call("setServiceInput", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> state() throws DynamicCallException, ExecutionException {
        return call("state");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> forget(String param1) throws DynamicCallException, ExecutionException{
        return call("forget", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> connect(String param1) throws DynamicCallException, ExecutionException{
        return call("connect", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> disconnect(String param1) throws DynamicCallException, ExecutionException{
        return call("disconnect", param1);
    }

    /**
    * 
    * 
    */
    public Future<Object> technologies() throws DynamicCallException, ExecutionException {
        return call("technologies");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> enableTethering(String param1, String param2, String param3) throws DynamicCallException, ExecutionException{
        return call("enableTethering", param1, param2, param3);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> enableTethering(String param1) throws DynamicCallException, ExecutionException{
        return call("enableTethering", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> disableTethering(String param1) throws DynamicCallException, ExecutionException{
        return call("disableTethering", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> getTetheringEnable(String param1) throws DynamicCallException, ExecutionException {
        return call("getTetheringEnable", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> tetheringName(String param1) throws DynamicCallException, ExecutionException {
        return call("tetheringName", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> tetheringPassphrase(String param1) throws DynamicCallException, ExecutionException {
        return call("tetheringPassphrase", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> countries() throws DynamicCallException, ExecutionException {
        return call("countries");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> setCountry(String param1) throws DynamicCallException, ExecutionException{
        return call("setCountry", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> country() throws DynamicCallException, ExecutionException {
        return call("country");
    }

    /**
    * 
    * 
    */
    public Future<Object> interfaces() throws DynamicCallException, ExecutionException {
        return call("interfaces");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> provisionService(Map<String, String> param1) throws DynamicCallException, ExecutionException{
        return call("provisionService", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<Map<String, String>>> provisionedServices() throws DynamicCallException, ExecutionException {
        return call("provisionedServices");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> removeProvisionedService(String param1) throws DynamicCallException, ExecutionException{
        return call("removeProvisionedService", param1);
    }

    }
}
    