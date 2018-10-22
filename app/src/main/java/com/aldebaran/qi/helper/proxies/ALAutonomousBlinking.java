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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/interaction/autonomousabilities/alautonomousblinking.html#alautonomousblinking">NAOqi APIs for ALAutonomousBlinking </a>
* NAOqi V2.4.x
*/
public class ALAutonomousBlinking extends ALProxy {

    private AsyncALAutonomousBlinking asyncProxy;

    public ALAutonomousBlinking(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALAutonomousBlinking();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALAutonomousBlinking object
	 */
    public AsyncALAutonomousBlinking async() {
        return asyncProxy;
    }

    /**
    * 
    * 
    */
    public void setEnabled(Boolean param1) throws DynamicCallException, ExecutionException {
        call("setEnabled", param1).get();
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
    public Boolean isEnabled() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isEnabled").get();
    }


    public class AsyncALAutonomousBlinking extends ALProxy {

        protected AsyncALAutonomousBlinking(){
            super();
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
    public Future<Boolean> isEnabled() throws DynamicCallException, ExecutionException {
        return call("isEnabled");
    }

    }
}
    