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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/alknowledge.html#alknowledge">NAOqi APIs for ALKnowledge </a>
* NAOqi V2.4.x
*/
public class ALKnowledge extends ALProxy {

    private AsyncALKnowledge asyncProxy;

    public ALKnowledge(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALKnowledge();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALKnowledge object
	 */
    public AsyncALKnowledge async() {
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
    public void add(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException{
        call("add", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public List<String> getSubject(String param1, String param2, String param3) throws DynamicCallException, ExecutionException {
        return (List<String>)call("getSubject", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public List<String> getPredicate(String param1, String param2, String param3) throws DynamicCallException, ExecutionException {
        return (List<String>)call("getPredicate", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public List<String> getObject(String param1, String param2, String param3) throws DynamicCallException, ExecutionException {
        return (List<String>)call("getObject", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public void update(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException{
        call("update", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public List<String> query(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException {
        return (List<String>)call("query", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public List<List<String>> queryTriplet(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException {
        return (List<List<String>>)call("queryTriplet", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public void remove(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException{
        call("remove", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public Boolean contains(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException {
        return (Boolean)call("contains", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public Boolean addRule(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("addRule", param1).get();
    }

    /**
    * 
    * 
    */
    public void clearRules() throws DynamicCallException, ExecutionException{
        call("clearRules").get();
    }

    /**
    * 
    * 
    */
    public void resetKnowledge(String param1) throws DynamicCallException, ExecutionException{
        call("resetKnowledge", param1).get();
    }

    /**
    * 
    * 
    */
    public void exportModel(String param1, String param2, String param3) throws DynamicCallException, ExecutionException{
        call("exportModel", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public void importModel(String param1, String param2, String param3) throws DynamicCallException, ExecutionException{
        call("importModel", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public List<String> sparqlQuery(String param1) throws DynamicCallException, ExecutionException {
        return (List<String>)call("sparqlQuery", param1).get();
    }

    /**
    * 
    * 
    */
    public List<String> sparqlQuery(String param1, Boolean param2) throws DynamicCallException, ExecutionException {
        return (List<String>)call("sparqlQuery", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public void createBackupModel(Object param1) throws DynamicCallException, ExecutionException{
        call("createBackupModel", param1).get();
    }

    /**
    * 
    * 
    */
    public void recoverBackupModel(Object param1) throws DynamicCallException, ExecutionException{
        call("recoverBackupModel", param1).get();
    }


    public class AsyncALKnowledge extends ALProxy {

        protected AsyncALKnowledge(){
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
    public Future<Void> add(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException{
        return call("add", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getSubject(String param1, String param2, String param3) throws DynamicCallException, ExecutionException {
        return call("getSubject", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getPredicate(String param1, String param2, String param3) throws DynamicCallException, ExecutionException {
        return call("getPredicate", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getObject(String param1, String param2, String param3) throws DynamicCallException, ExecutionException {
        return call("getObject", param1, param2, param3);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> update(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException{
        return call("update", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> query(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException {
        return call("query", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    */
    public Future<List<List<String>>> queryTriplet(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException {
        return call("queryTriplet", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> remove(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException{
        return call("remove", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> contains(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException {
        return call("contains", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> addRule(String param1) throws DynamicCallException, ExecutionException {
        return call("addRule", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> clearRules() throws DynamicCallException, ExecutionException{
        return call("clearRules");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> resetKnowledge(String param1) throws DynamicCallException, ExecutionException{
        return call("resetKnowledge", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> exportModel(String param1, String param2, String param3) throws DynamicCallException, ExecutionException{
        return call("exportModel", param1, param2, param3);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> importModel(String param1, String param2, String param3) throws DynamicCallException, ExecutionException{
        return call("importModel", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> sparqlQuery(String param1) throws DynamicCallException, ExecutionException {
        return call("sparqlQuery", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> sparqlQuery(String param1, Boolean param2) throws DynamicCallException, ExecutionException {
        return call("sparqlQuery", param1, param2);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> createBackupModel(Object param1) throws DynamicCallException, ExecutionException{
        return call("createBackupModel", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> recoverBackupModel(Object param1) throws DynamicCallException, ExecutionException{
        return call("recoverBackupModel", param1);
    }

    }
}
    