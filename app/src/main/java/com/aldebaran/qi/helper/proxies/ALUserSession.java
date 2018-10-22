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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/alusersession.html#alusersession">NAOqi APIs for ALUserSession </a>
* NAOqi V2.4.x
*/
public class ALUserSession extends ALProxy {

    private AsyncALUserSession asyncProxy;

    public ALUserSession(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALUserSession();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALUserSession object
	 */
    public AsyncALUserSession async() {
        return asyncProxy;
    }

    /**
    * 
    * 
    */
    public Integer getUsidFromPpid(Integer param1) throws DynamicCallException, ExecutionException {
        return (Integer)call("getUsidFromPpid", param1).get();
    }

    /**
    * 
    * 
    */
    public List<String> getBindingSources() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getBindingSources").get();
    }

    /**
    * 
    * 
    */
    public Boolean doesBindingSourceExist(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("doesBindingSourceExist", param1).get();
    }

    /**
    * 
    * 
    */
    public List<String> getUserDataSources() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getUserDataSources").get();
    }

    /**
    * 
    * 
    */
    public Boolean doesUserDataSourceExist(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("doesUserDataSourceExist", param1).get();
    }

    /**
    * 
    * 
    */
    public Object getUserData(Integer param1, String param2, String param3) throws DynamicCallException, ExecutionException {
        return (Object)call("getUserData", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public Map<String, Object> getUserData(Integer param1, String param2) throws DynamicCallException, ExecutionException {
        return (Map<String, Object>)call("getUserData", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public void setUserData(Integer param1, String param2, String param3, Object param4) throws DynamicCallException, ExecutionException{
        call("setUserData", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public String getUserCreationDate(Integer param1) throws DynamicCallException, ExecutionException {
        return (String)call("getUserCreationDate", param1).get();
    }

    /**
    * 
    * 
    */
    public String getFirstEncounterDate(Integer param1) throws DynamicCallException, ExecutionException {
        return (String)call("getFirstEncounterDate", param1).get();
    }

    /**
    * 
    * 
    */
    public String getCurrentEncounterDate(Integer param1) throws DynamicCallException, ExecutionException {
        return (String)call("getCurrentEncounterDate", param1).get();
    }

    /**
    * 
    * 
    */
    public String getLastEncounterDate(Integer param1) throws DynamicCallException, ExecutionException {
        return (String)call("getLastEncounterDate", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer getSecondsSinceLastEncounter(Integer param1) throws DynamicCallException, ExecutionException {
        return (Integer)call("getSecondsSinceLastEncounter", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer getPpidFromUsid(Integer param1) throws DynamicCallException, ExecutionException {
        return (Integer)call("getPpidFromUsid", param1).get();
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
    public Boolean doesUserExist(Integer param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("doesUserExist", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean doUsersExist(List<Integer> param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("doUsersExist", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Integer> getUserList() throws DynamicCallException, ExecutionException {
        return (List<Integer>)call("getUserList").get();
    }

    /**
    * 
    * 
    */
    public Integer getNumUsers() throws DynamicCallException, ExecutionException {
        return (Integer)call("getNumUsers").get();
    }

    /**
    * 
    * 
    */
    public Integer getFocusedUser() throws DynamicCallException, ExecutionException {
        return (Integer)call("getFocusedUser").get();
    }

    /**
    * 
    * 
    */
    public List<Integer> getOpenUserSessions() throws DynamicCallException, ExecutionException {
        return (List<Integer>)call("getOpenUserSessions").get();
    }

    /**
    * 
    * 
    */
    public Boolean isUserSessionOpen(Integer param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("isUserSessionOpen", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean areUserSessionsOpen(List<Integer> param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("areUserSessionsOpen", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean isUserPermanent(Integer param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("isUserPermanent", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean areUsersPermanent(List<Integer> param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("areUsersPermanent", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Integer> getPermanentUserList() throws DynamicCallException, ExecutionException {
        return (List<Integer>)call("getPermanentUserList").get();
    }

    /**
    * 
    * 
    */
    public List<String> getBindingList() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getBindingList").get();
    }

    /**
    * 
    * 
    */
    public Boolean doesBindingExist(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("doesBindingExist", param1).get();
    }

    /**
    * 
    * 
    */
    public String getUserBinding(Integer param1, String param2) throws DynamicCallException, ExecutionException {
        return (String)call("getUserBinding", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public Map<String, String> getUserBindings(Integer param1) throws DynamicCallException, ExecutionException {
        return (Map<String, String>)call("getUserBindings", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Integer> findUsersWithBinding(String param1, String param2) throws DynamicCallException, ExecutionException {
        return (List<Integer>)call("findUsersWithBinding", param1, param2).get();
    }


    public class AsyncALUserSession extends ALProxy {

        protected AsyncALUserSession(){
            super();
        }
    
    /**
    * 
    * 
    */
    public Future<Integer> getUsidFromPpid(Integer param1) throws DynamicCallException, ExecutionException {
        return call("getUsidFromPpid", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getBindingSources() throws DynamicCallException, ExecutionException {
        return call("getBindingSources");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> doesBindingSourceExist(String param1) throws DynamicCallException, ExecutionException {
        return call("doesBindingSourceExist", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getUserDataSources() throws DynamicCallException, ExecutionException {
        return call("getUserDataSources");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> doesUserDataSourceExist(String param1) throws DynamicCallException, ExecutionException {
        return call("doesUserDataSourceExist", param1);
    }

    /**
    * 
    * 
    */
    public Future<Object> getUserData(Integer param1, String param2, String param3) throws DynamicCallException, ExecutionException {
        return call("getUserData", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<Map<String, Object>> getUserData(Integer param1, String param2) throws DynamicCallException, ExecutionException {
        return call("getUserData", param1, param2);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> setUserData(Integer param1, String param2, String param3, Object param4) throws DynamicCallException, ExecutionException{
        return call("setUserData", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    */
    public Future<String> getUserCreationDate(Integer param1) throws DynamicCallException, ExecutionException {
        return call("getUserCreationDate", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> getFirstEncounterDate(Integer param1) throws DynamicCallException, ExecutionException {
        return call("getFirstEncounterDate", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> getCurrentEncounterDate(Integer param1) throws DynamicCallException, ExecutionException {
        return call("getCurrentEncounterDate", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> getLastEncounterDate(Integer param1) throws DynamicCallException, ExecutionException {
        return call("getLastEncounterDate", param1);
    }

    /**
    * 
    * 
    */
    public Future<Integer> getSecondsSinceLastEncounter(Integer param1) throws DynamicCallException, ExecutionException {
        return call("getSecondsSinceLastEncounter", param1);
    }

    /**
    * 
    * 
    */
    public Future<Integer> getPpidFromUsid(Integer param1) throws DynamicCallException, ExecutionException {
        return call("getPpidFromUsid", param1);
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
    public Future<Boolean> doesUserExist(Integer param1) throws DynamicCallException, ExecutionException {
        return call("doesUserExist", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> doUsersExist(List<Integer> param1) throws DynamicCallException, ExecutionException {
        return call("doUsersExist", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<Integer>> getUserList() throws DynamicCallException, ExecutionException {
        return call("getUserList");
    }

    /**
    * 
    * 
    */
    public Future<Integer> getNumUsers() throws DynamicCallException, ExecutionException {
        return call("getNumUsers");
    }

    /**
    * 
    * 
    */
    public Future<Integer> getFocusedUser() throws DynamicCallException, ExecutionException {
        return call("getFocusedUser");
    }

    /**
    * 
    * 
    */
    public Future<List<Integer>> getOpenUserSessions() throws DynamicCallException, ExecutionException {
        return call("getOpenUserSessions");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isUserSessionOpen(Integer param1) throws DynamicCallException, ExecutionException {
        return call("isUserSessionOpen", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> areUserSessionsOpen(List<Integer> param1) throws DynamicCallException, ExecutionException {
        return call("areUserSessionsOpen", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isUserPermanent(Integer param1) throws DynamicCallException, ExecutionException {
        return call("isUserPermanent", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> areUsersPermanent(List<Integer> param1) throws DynamicCallException, ExecutionException {
        return call("areUsersPermanent", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<Integer>> getPermanentUserList() throws DynamicCallException, ExecutionException {
        return call("getPermanentUserList");
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getBindingList() throws DynamicCallException, ExecutionException {
        return call("getBindingList");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> doesBindingExist(String param1) throws DynamicCallException, ExecutionException {
        return call("doesBindingExist", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> getUserBinding(Integer param1, String param2) throws DynamicCallException, ExecutionException {
        return call("getUserBinding", param1, param2);
    }

    /**
    * 
    * 
    */
    public Future<Map<String, String>> getUserBindings(Integer param1) throws DynamicCallException, ExecutionException {
        return call("getUserBindings", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<Integer>> findUsersWithBinding(String param1, String param2) throws DynamicCallException, ExecutionException {
        return call("findUsersWithBinding", param1, param2);
    }

    }
}
    