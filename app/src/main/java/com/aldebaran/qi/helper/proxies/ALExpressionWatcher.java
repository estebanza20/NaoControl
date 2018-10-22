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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/alexpressionwatcher.html#alexpressionwatcher">NAOqi APIs for ALExpressionWatcher </a>
* NAOqi V2.4.x
*/
public class ALExpressionWatcher extends ALProxy {

    private AsyncALExpressionWatcher asyncProxy;

    public ALExpressionWatcher(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALExpressionWatcher();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALExpressionWatcher object
	 */
    public AsyncALExpressionWatcher async() {
        return asyncProxy;
    }

    /**
    * Adds a condition expression to ALExpressionWatcher engine
    * 
    * @param expression  Condition expression in ConditionChecker language
    * @param report_mode  ALExpressionWatcher report mode, available modes: { REPORT_CHANGE = 0, REPORT_EDGE = 1, REPORT_EDGE_TRUE = 2 }
    * @return Corresponding ExpressionObject
    */
    public AnyObject add(String expression, Integer report_mode) throws DynamicCallException, ExecutionException {
        return (AnyObject)call("add", expression, report_mode).get();
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


    public class AsyncALExpressionWatcher extends ALProxy {

        protected AsyncALExpressionWatcher(){
            super();
        }
    
    /**
    * Adds a condition expression to ALExpressionWatcher engine
    * 
    * @param expression  Condition expression in ConditionChecker language
    * @param report_mode  ALExpressionWatcher report mode, available modes: { REPORT_CHANGE = 0, REPORT_EDGE = 1, REPORT_EDGE_TRUE = 2 }
    * @return Corresponding ExpressionObject
    */
    public Future<AnyObject> add(String expression, Integer report_mode) throws DynamicCallException, ExecutionException {
        return call("add", expression, report_mode);
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

    }
}
    