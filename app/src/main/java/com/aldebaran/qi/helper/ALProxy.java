/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */

package com.aldebaran.qi.helper;

import com.aldebaran.qi.AnyObject;
import com.aldebaran.qi.DynamicCallException;
import com.aldebaran.qi.Future;
import com.aldebaran.qi.Session;

import java.util.concurrent.ExecutionException;

/**
 * Generic class to manage a proxy
 * */
public abstract class ALProxy {

	/** Naoqi Service proxy */
    protected AnyObject service;

	/** Naoqi Service name */
	protected String name;

	/**
	 * Create a new proxy using the class name as the service name
	 * @param session session connect to a robot
	 * */
    public ALProxy(Session session) throws Exception {
        name = getClass().getSimpleName();
        service = session.service(name).get();

    }

	/**
	 * Create a new proxy
	 * */
	public ALProxy() {
	}

	/**
	 * Create a new proxy
	 * @param session session connect to a robot
	 * @param serviceName name of the service you want to get proxy on
	 * */
	public ALProxy(Session session, String serviceName) throws Exception {
		name = serviceName;
		service = session.service(serviceName).get();
	}


	/**
	 * Connect to a Signal (Naoqi 2)
	 * @param signal name of the signal you want to subscribe (you can get those name in the module NAOqi APIs doc)
	 * @param signature naoqi signature of the signal
	 * @param callback object where the callback function is located
	 * @return id to identify the signal subscription
	 * */
	public long connect(String signal, String signature, Object callback) throws Exception {
		if (service == null)
			throw new DynamicCallException();
		return service.connect(signal,signature, callback);
	}


	/**
	 * Connect to a Signal with signal callback helper (Naoqi 2)
	 * @param signal name of the signal you want to subscribe (you can get those name in the module NAOqi APIs doc)
	 * @param callback object where the callback function is located
	 * @return id to identify the event subscription
	 * */
	public long connect(String signal, Class<?> theClass, SignalCallback callback) throws Exception {
		if (service == null)
			throw new DynamicCallException();
		return service.connect(signal, "onSignal::("+getNaoqiType(theClass)+")", callback);
	}

	/**
	 * Get the equivalence between Java type and naoqi type
	 * @param tClass The java class of type you want to convert
	 * @return the Naoqi type
	 * */
	public String getNaoqiType(Class<?> tClass) {

		if(tClass == String.class)
			return "s";
		if(tClass == Integer.class)
			return "i";
		if(tClass == Character.class)
			return "c";
		if(tClass == Void.class)
			return "v";
		if(tClass == AnyObject.class)
			return "o";
		if(tClass == Boolean.class)
			return "b";
		if(tClass == Float.class)
			return "f";
		if(tClass == Long.class)
			return "l";
		else return "m";
	}

	/**
	 * Disconnect to a signal giving is subscription id
	 * @param eventID id of the signal subscription
	 * */
	public void disconnect(long eventID) throws InterruptedException, DynamicCallException {
		if (service == null)
			throw new DynamicCallException();
		service.disconnect(eventID);
	}


	/** Call a method with arguments
	 * @param method name of the method to call
	 * @param args args to give to this method
	 * @return a Future, use get on it to have the result */
	public <T> Future<T> call(String method, Object... args) throws DynamicCallException, ExecutionException {
		if (service == null)
			throw new DynamicCallException();
		return service.call(method, args);
	}

	public AnyObject getService() {
		return service;
	}

	public void setService(AnyObject service) {
		this.service = service;
	}

	/**Is proxy create and ready*/
	public boolean isProxyReady() {
		return service != null;
	}

}
