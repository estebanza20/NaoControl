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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/interaction/autonomousabilities/albasicawareness.html#albasicawareness">NAOqi APIs for ALBasicAwareness </a>
* NAOqi V2.4.x
*/
public class ALBasicAwareness extends ALProxy {

    private AsyncALBasicAwareness asyncProxy;

    public ALBasicAwareness(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALBasicAwareness();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALBasicAwareness object
	 */
    public AsyncALBasicAwareness async() {
        return asyncProxy;
    }

    /**
    * Pause BasicAwareness.
    * 
    */
    public void pauseAwareness() throws DynamicCallException, ExecutionException {
        call("pauseAwareness").get();
    }

    /**
    * Set the specified parameter 
    * 
    * @param paramName  "LookStimulusSpeed" : Speed of head moves when looking at a stimulus, as fraction of max speed
 "LookBackSpeed" : Speed of head moves when looking back to previous position, as fraction of max speed
 "NobodyFoundTimeOut" : timeout to send HumanLost event when no blob is found, in seconds
 "MinTimeTracking" : Minimum Time for the robot to be focused on someone, without listening to other stimuli, in seconds
 "TimeSleepBeforeResumeMS" : Slept time before automatically resuming BasicAwareness when an automatic pause has been made, in milliseconds
 "TimeOutResetHead" : Timeout to reset the head, in seconds
 "AmplitudeYawTracking" : max absolute value for head yaw in tracking, in degrees
 "FramerateTracking" : Framerate for FastPersonTracking and FindPersonHead, in frame per second
 "PeoplePerceptionPeriod" : Period for people perception, in milliseconds
 "SlowPeoplePerceptionPeriod" : Period for people perception in FullyEngaged mode, in milliseconds
 "HeadThreshold" : Yaw threshold for tracking, in degrees
 "BodyRotationThreshold" : Angular threshold for BodyRotation tracking mode, in degrees
 "BodyRotationThresholdNao" : Angular threshold for BodyRotation tracking mode on Nao, in degrees
 "MoveDistanceX" : X Distance for the Move tracking mode, in meters
 "MoveDistanceY" : Y Distance for the Move tracking mode, in meters
 "MoveAngleTheta" : Angle for the Move tracking mode, in degrees
 "MoveThresholdX" : Threshold for the Move tracking mode, in meters
 "MoveThresholdY" : Threshold for the Move tracking mode, in meters
 "MoveThresholdTheta" : Theta Threshold for the Move tracking mode, in degrees
 "MaxDistanceFullyEngaged" : Maximum distance for someone to be tracked for FullyEngaged mode, in meters
 "MaxDistanceNotFullyEngaged" : Maximum distance for someone to be tracked for modes different from FullyEngaged, in meters
 "MaxHumanSearchTime" : Maximum time to find a human after observing stimulus, in seconds
 "DeltaPitchComfortZone" : Pitch width of the comfort zone, in degree
 "CenterPitchComfortZone" : Pitch center of the confort zone, in degree
 "SoundHeight" : Default Height for sound detection, in meters
 "MoveSpeed" : Speed of the robot moves
 "MC_Interactive_MinTime" : Minimum time between 2 contextual moves (when the robot is tracking somebody)
 "MC_Interactive_MaxOffsetTime" : Maximum time that we can add to MC_Interactive_MinTime (when the robot is tracking somebody)
 "MC_Interactive_DistanceXY" : Maximum offset distance in X and Y that the robot can apply when he tracks somebody
 "MC_Interactive_MinTheta" : Minimum theta that the robot can apply when he tracks somebody
 "MC_Interactive_MaxTheta" : Maximum theta that the robot can apply when he tracks somebody
 "MC_Interactive_DistanceHumanRobot" : Distance between the human and the robot
 "MC_Interactive_MaxDistanceHumanRobot" : Maximum distance human robot to allow the robot to move (in MoveContextually mode)
 
    * @param newVal  "LookStimulusSpeed" : Float in range [0.01;1]
 "LookBackSpeed" : Float in range [0.01;1]
 "NobodyFoundTimeOut" : Float > 0
 "MinTimeTracking" : Float in range [0;20]
 "TimeSleepBeforeResumeMS" : Int > 0
 "TimeOutResetHead" : Float in range [0;30]
 "AmplitudeYawTracking" : Float in range [10;120]
 "FramerateTracking" : Int in range [1;33]
 "PeoplePerceptionPeriod" : Int > 1
 "SlowPeoplePerceptionPeriod" : Int > 1
 "HeadThreshold" : Float in range [0;180]
 "BodyRotationThreshold" : Float in range [-180;180]
 "BodyRotationThresholdNao" : Float in range [-180;180]
 "MoveDistanceX" : Float in range [-5;5]
 "MoveDistanceY" : Float in range [-5;5]
 "MoveAngleTheta" : Float in range [-180;180]
 "MoveThresholdX" : Float in range [0;5]
 "MoveThresholdY" : Float in range [0;5]
 "MoveThresholdTheta" : Float in range [-180;180]
 "MaxDistanceFullyEngaged" : Float in range [0.5;5]
 "MaxDistanceNotFullyEngaged" : Float in range [0.5;5]
 "MaxHumanSearchTime" : Float in range [0.1;10]
 "DeltaPitchComfortZone" : Float in range [0;90]
 "CenterPitchComfortZone" : Float in range [-90;90]
 "SoundHeight" : Float in range [0;2]
 "MoveSpeed" : Float in range [0.1;0.55]
 "MC_Interactive_MinTime" : Int in range [0;100]
 "MC_Interactive_MaxOffsetTime" : Int in range [0;100]
 "MC_Interactive_DistanceXY" : Float in range [0;1]
 "MC_Interactive_MinTheta" : Float in range [-40;0]
 "MC_Interactive_MaxTheta" : Float in range [0;40]
 "MC_Interactive_DistanceHumanRobot" : Float in range [0.1;2]
 "MC_Interactive_MaxDistanceHumanRobot" : Float in range [0.1;3]
 
    */
    public void setParameter(String paramName, Object newVal) throws DynamicCallException, ExecutionException{
        call("setParameter", paramName, newVal).get();
    }

    /**
    * Return whether BasicAwareness is running.
    * 
    * @return Boolean value, true if running else false
    */
    public Boolean isRunning() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isRunning").get();
    }

    /**
    * Get the specified parameter.
    * 
    * @param paramName  "LookStimulusSpeed" : Speed of head moves when looking at a stimulus, as fraction of max speed
 "LookBackSpeed" : Speed of head moves when looking back to previous position, as fraction of max speed
 "NobodyFoundTimeOut" : timeout to send HumanLost event when no blob is found, in seconds
 "MinTimeTracking" : Minimum Time for the robot to be focused on someone, without listening to other stimuli, in seconds
 "TimeSleepBeforeResumeMS" : Slept time before automatically resuming BasicAwareness when an automatic pause has been made, in milliseconds
 "TimeOutResetHead" : Timeout to reset the head, in seconds
 "AmplitudeYawTracking" : max absolute value for head yaw in tracking, in degrees
 "FramerateTracking" : Framerate for FastPersonTracking and FindPersonHead, in frame per second
 "PeoplePerceptionPeriod" : Period for people perception, in milliseconds
 "SlowPeoplePerceptionPeriod" : Period for people perception in FullyEngaged mode, in milliseconds
 "HeadThreshold" : Yaw threshold for tracking, in degrees
 "BodyRotationThreshold" : Angular threshold for BodyRotation tracking mode, in degrees
 "BodyRotationThresholdNao" : Angular threshold for BodyRotation tracking mode on Nao, in degrees
 "MoveDistanceX" : X Distance for the Move tracking mode, in meters
 "MoveDistanceY" : Y Distance for the Move tracking mode, in meters
 "MoveAngleTheta" : Angle for the Move tracking mode, in degrees
 "MoveThresholdX" : Threshold for the Move tracking mode, in meters
 "MoveThresholdY" : Threshold for the Move tracking mode, in meters
 "MoveThresholdTheta" : Theta Threshold for the Move tracking mode, in degrees
 "MaxDistanceFullyEngaged" : Maximum distance for someone to be tracked for FullyEngaged mode, in meters
 "MaxDistanceNotFullyEngaged" : Maximum distance for someone to be tracked for modes different from FullyEngaged, in meters
 "MaxHumanSearchTime" : Maximum time to find a human after observing stimulus, in seconds
 "DeltaPitchComfortZone" : Pitch width of the comfort zone, in degree
 "CenterPitchComfortZone" : Pitch center of the confort zone, in degree
 "SoundHeight" : Default Height for sound detection, in meters
 "MoveSpeed" : Speed of the robot moves
 "MC_Interactive_MinTime" : Minimum time between 2 contextual moves (when the robot is tracking somebody)
 "MC_Interactive_MaxOffsetTime" : Maximum time that we can add to MC_Interactive_MinTime (when the robot is tracking somebody)
 "MC_Interactive_DistanceXY" : Maximum offset distance in X and Y that the robot can apply when he tracks somebody
 "MC_Interactive_MinTheta" : Minimum theta that the robot can apply when he tracks somebody
 "MC_Interactive_MaxTheta" : Maximum theta that the robot can apply when he tracks somebody
 "MC_Interactive_DistanceHumanRobot" : Distance between the human and the robot
 "MC_Interactive_MaxDistanceHumanRobot" : Maximum distance human robot to allow the robot to move (in MoveContextually mode)
 
    * @return ALValue format for required parameter
    */
    public Object getParameter(String paramName) throws DynamicCallException, ExecutionException {
        return (Object)call("getParameter", paramName).get();
    }

    /**
    * Set engagement mode.
    * 
    * @param modeName  Name of the mode
    */
    public void setEngagementMode(String modeName) throws DynamicCallException, ExecutionException{
        call("setEngagementMode", modeName).get();
    }

    /**
    * DEPRECATED since 2.4: use setEnabled instead.Stop Basic Awareness.
    * 
    */
    public void stopAwareness() throws DynamicCallException, ExecutionException{
        call("stopAwareness").get();
    }

    /**
    * Set tracking mode.
    * 
    * @param modeName  Name of the mode
    */
    public void setTrackingMode(String modeName) throws DynamicCallException, ExecutionException{
        call("setTrackingMode", modeName).get();
    }

    /**
    * Set tracking mode.
    * 
    * @return Name of current tracking mode as a string
    */
    public String getTrackingMode() throws DynamicCallException, ExecutionException {
        return (String)call("getTrackingMode").get();
    }

    /**
    * Force Engage Person.
    * 
    * @param engagePerson  ID of the person as found in PeoplePerception.
    * @return true if the robot succeeded to engage the person, else false.
    */
    public Boolean engagePerson(Integer engagePerson) throws DynamicCallException, ExecutionException {
        return (Boolean)call("engagePerson", engagePerson).get();
    }

    /**
    * DEPRECATED since 2.4: use isEnabled instead.Get the status (started or not) of the module.
    * 
    * @return Boolean value, true if running else false
    */
    public Boolean isAwarenessRunning() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isAwarenessRunning").get();
    }

    /**
    * Resume BasicAwareness.
    * 
    */
    public void resumeAwareness() throws DynamicCallException, ExecutionException{
        call("resumeAwareness").get();
    }

    /**
    * Get the pause status of the module.
    * 
    */
    public Boolean isAwarenessPaused() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isAwarenessPaused").get();
    }

    /**
    * DEPRECATED since 2.4: use setEnabled instead.Start Basic Awareness.
    * 
    */
    public void startAwareness() throws DynamicCallException, ExecutionException{
        call("startAwareness").get();
    }

    /**
    * Enable/Disable Stimulus Detection.
    * 
    * @param stimulusName  Name of the stimulus to enable/disable
    * @param isStimulusDetectionEnabled  Boolean value: true to enable, false to disable.
    */
    public void setStimulusDetectionEnabled(String stimulusName, Boolean isStimulusDetectionEnabled) throws DynamicCallException, ExecutionException{
        call("setStimulusDetectionEnabled", stimulusName, isStimulusDetectionEnabled).get();
    }

    /**
    * Get status enabled/disabled for Stimulus Detection.
    * 
    * @param stimulusName  Name of the stimulus to check
    * @return Boolean value for status enabled/disabled
    */
    public Boolean isStimulusDetectionEnabled(String stimulusName) throws DynamicCallException, ExecutionException {
        return (Boolean)call("isStimulusDetectionEnabled", stimulusName).get();
    }

    /**
    * Reset all parameters, including enabled/disabled stimulus.
    * 
    */
    public void resetAllParameters() throws DynamicCallException, ExecutionException{
        call("resetAllParameters").get();
    }

    /**
    * Trigger a custom stimulus.
    * 
    * @param stimulusPosition  Position of the stimulus, in Frame World
    * @return If someone was found, return value is its ID, else it's -1
    */
    public Integer triggerStimulus(List<Float> stimulusPosition) throws DynamicCallException, ExecutionException {
        return (Integer)call("triggerStimulus", stimulusPosition).get();
    }

    /**
    * Set engagement mode.
    * 
    * @return Name of current engagement mode as a string
    */
    public String getEngagementMode() throws DynamicCallException, ExecutionException {
        return (String)call("getEngagementMode").get();
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
    * Enable/Disable BasicAwareness.
    * 
    * @param enabled  True to enable BasicAwareness, False to disable BasicAwareness.
    */
    public void setEnabled(Boolean enabled) throws DynamicCallException, ExecutionException{
        call("setEnabled", enabled).get();
    }

    /**
    * Return whether BasicAwareness is enabled or not.
    * 
    * @return Boolean value, true if enabled else false
    */
    public Boolean isEnabled() throws DynamicCallException, ExecutionException {
        return (Boolean)call("isEnabled").get();
    }


    public class AsyncALBasicAwareness extends ALProxy {

        protected AsyncALBasicAwareness(){
            super();
        }
    
    /**
    * Pause BasicAwareness.
    * 
    * @return The Future
    */
    public Future<Void> pauseAwareness() throws DynamicCallException, ExecutionException{
        return call("pauseAwareness");
    }

    /**
    * Set the specified parameter 
    * 
    * @param paramName  "LookStimulusSpeed" : Speed of head moves when looking at a stimulus, as fraction of max speed
 "LookBackSpeed" : Speed of head moves when looking back to previous position, as fraction of max speed
 "NobodyFoundTimeOut" : timeout to send HumanLost event when no blob is found, in seconds
 "MinTimeTracking" : Minimum Time for the robot to be focused on someone, without listening to other stimuli, in seconds
 "TimeSleepBeforeResumeMS" : Slept time before automatically resuming BasicAwareness when an automatic pause has been made, in milliseconds
 "TimeOutResetHead" : Timeout to reset the head, in seconds
 "AmplitudeYawTracking" : max absolute value for head yaw in tracking, in degrees
 "FramerateTracking" : Framerate for FastPersonTracking and FindPersonHead, in frame per second
 "PeoplePerceptionPeriod" : Period for people perception, in milliseconds
 "SlowPeoplePerceptionPeriod" : Period for people perception in FullyEngaged mode, in milliseconds
 "HeadThreshold" : Yaw threshold for tracking, in degrees
 "BodyRotationThreshold" : Angular threshold for BodyRotation tracking mode, in degrees
 "BodyRotationThresholdNao" : Angular threshold for BodyRotation tracking mode on Nao, in degrees
 "MoveDistanceX" : X Distance for the Move tracking mode, in meters
 "MoveDistanceY" : Y Distance for the Move tracking mode, in meters
 "MoveAngleTheta" : Angle for the Move tracking mode, in degrees
 "MoveThresholdX" : Threshold for the Move tracking mode, in meters
 "MoveThresholdY" : Threshold for the Move tracking mode, in meters
 "MoveThresholdTheta" : Theta Threshold for the Move tracking mode, in degrees
 "MaxDistanceFullyEngaged" : Maximum distance for someone to be tracked for FullyEngaged mode, in meters
 "MaxDistanceNotFullyEngaged" : Maximum distance for someone to be tracked for modes different from FullyEngaged, in meters
 "MaxHumanSearchTime" : Maximum time to find a human after observing stimulus, in seconds
 "DeltaPitchComfortZone" : Pitch width of the comfort zone, in degree
 "CenterPitchComfortZone" : Pitch center of the confort zone, in degree
 "SoundHeight" : Default Height for sound detection, in meters
 "MoveSpeed" : Speed of the robot moves
 "MC_Interactive_MinTime" : Minimum time between 2 contextual moves (when the robot is tracking somebody)
 "MC_Interactive_MaxOffsetTime" : Maximum time that we can add to MC_Interactive_MinTime (when the robot is tracking somebody)
 "MC_Interactive_DistanceXY" : Maximum offset distance in X and Y that the robot can apply when he tracks somebody
 "MC_Interactive_MinTheta" : Minimum theta that the robot can apply when he tracks somebody
 "MC_Interactive_MaxTheta" : Maximum theta that the robot can apply when he tracks somebody
 "MC_Interactive_DistanceHumanRobot" : Distance between the human and the robot
 "MC_Interactive_MaxDistanceHumanRobot" : Maximum distance human robot to allow the robot to move (in MoveContextually mode)
 
    * @param newVal  "LookStimulusSpeed" : Float in range [0.01;1]
 "LookBackSpeed" : Float in range [0.01;1]
 "NobodyFoundTimeOut" : Float > 0
 "MinTimeTracking" : Float in range [0;20]
 "TimeSleepBeforeResumeMS" : Int > 0
 "TimeOutResetHead" : Float in range [0;30]
 "AmplitudeYawTracking" : Float in range [10;120]
 "FramerateTracking" : Int in range [1;33]
 "PeoplePerceptionPeriod" : Int > 1
 "SlowPeoplePerceptionPeriod" : Int > 1
 "HeadThreshold" : Float in range [0;180]
 "BodyRotationThreshold" : Float in range [-180;180]
 "BodyRotationThresholdNao" : Float in range [-180;180]
 "MoveDistanceX" : Float in range [-5;5]
 "MoveDistanceY" : Float in range [-5;5]
 "MoveAngleTheta" : Float in range [-180;180]
 "MoveThresholdX" : Float in range [0;5]
 "MoveThresholdY" : Float in range [0;5]
 "MoveThresholdTheta" : Float in range [-180;180]
 "MaxDistanceFullyEngaged" : Float in range [0.5;5]
 "MaxDistanceNotFullyEngaged" : Float in range [0.5;5]
 "MaxHumanSearchTime" : Float in range [0.1;10]
 "DeltaPitchComfortZone" : Float in range [0;90]
 "CenterPitchComfortZone" : Float in range [-90;90]
 "SoundHeight" : Float in range [0;2]
 "MoveSpeed" : Float in range [0.1;0.55]
 "MC_Interactive_MinTime" : Int in range [0;100]
 "MC_Interactive_MaxOffsetTime" : Int in range [0;100]
 "MC_Interactive_DistanceXY" : Float in range [0;1]
 "MC_Interactive_MinTheta" : Float in range [-40;0]
 "MC_Interactive_MaxTheta" : Float in range [0;40]
 "MC_Interactive_DistanceHumanRobot" : Float in range [0.1;2]
 "MC_Interactive_MaxDistanceHumanRobot" : Float in range [0.1;3]
 
    * @return The Future
    */
    public Future<Void> setParameter(String paramName, Object newVal) throws DynamicCallException, ExecutionException{
        return call("setParameter", paramName, newVal);
    }

    /**
    * Return whether BasicAwareness is running.
    * 
    * @return Boolean value, true if running else false
    */
    public Future<Boolean> isRunning() throws DynamicCallException, ExecutionException {
        return call("isRunning");
    }

    /**
    * Get the specified parameter.
    * 
    * @param paramName  "LookStimulusSpeed" : Speed of head moves when looking at a stimulus, as fraction of max speed
 "LookBackSpeed" : Speed of head moves when looking back to previous position, as fraction of max speed
 "NobodyFoundTimeOut" : timeout to send HumanLost event when no blob is found, in seconds
 "MinTimeTracking" : Minimum Time for the robot to be focused on someone, without listening to other stimuli, in seconds
 "TimeSleepBeforeResumeMS" : Slept time before automatically resuming BasicAwareness when an automatic pause has been made, in milliseconds
 "TimeOutResetHead" : Timeout to reset the head, in seconds
 "AmplitudeYawTracking" : max absolute value for head yaw in tracking, in degrees
 "FramerateTracking" : Framerate for FastPersonTracking and FindPersonHead, in frame per second
 "PeoplePerceptionPeriod" : Period for people perception, in milliseconds
 "SlowPeoplePerceptionPeriod" : Period for people perception in FullyEngaged mode, in milliseconds
 "HeadThreshold" : Yaw threshold for tracking, in degrees
 "BodyRotationThreshold" : Angular threshold for BodyRotation tracking mode, in degrees
 "BodyRotationThresholdNao" : Angular threshold for BodyRotation tracking mode on Nao, in degrees
 "MoveDistanceX" : X Distance for the Move tracking mode, in meters
 "MoveDistanceY" : Y Distance for the Move tracking mode, in meters
 "MoveAngleTheta" : Angle for the Move tracking mode, in degrees
 "MoveThresholdX" : Threshold for the Move tracking mode, in meters
 "MoveThresholdY" : Threshold for the Move tracking mode, in meters
 "MoveThresholdTheta" : Theta Threshold for the Move tracking mode, in degrees
 "MaxDistanceFullyEngaged" : Maximum distance for someone to be tracked for FullyEngaged mode, in meters
 "MaxDistanceNotFullyEngaged" : Maximum distance for someone to be tracked for modes different from FullyEngaged, in meters
 "MaxHumanSearchTime" : Maximum time to find a human after observing stimulus, in seconds
 "DeltaPitchComfortZone" : Pitch width of the comfort zone, in degree
 "CenterPitchComfortZone" : Pitch center of the confort zone, in degree
 "SoundHeight" : Default Height for sound detection, in meters
 "MoveSpeed" : Speed of the robot moves
 "MC_Interactive_MinTime" : Minimum time between 2 contextual moves (when the robot is tracking somebody)
 "MC_Interactive_MaxOffsetTime" : Maximum time that we can add to MC_Interactive_MinTime (when the robot is tracking somebody)
 "MC_Interactive_DistanceXY" : Maximum offset distance in X and Y that the robot can apply when he tracks somebody
 "MC_Interactive_MinTheta" : Minimum theta that the robot can apply when he tracks somebody
 "MC_Interactive_MaxTheta" : Maximum theta that the robot can apply when he tracks somebody
 "MC_Interactive_DistanceHumanRobot" : Distance between the human and the robot
 "MC_Interactive_MaxDistanceHumanRobot" : Maximum distance human robot to allow the robot to move (in MoveContextually mode)
 
    * @return ALValue format for required parameter
    */
    public Future<Object> getParameter(String paramName) throws DynamicCallException, ExecutionException {
        return call("getParameter", paramName);
    }

    /**
    * Set engagement mode.
    * 
    * @param modeName  Name of the mode
    * @return The Future
    */
    public Future<Void> setEngagementMode(String modeName) throws DynamicCallException, ExecutionException{
        return call("setEngagementMode", modeName);
    }

    /**
    * DEPRECATED since 2.4: use setEnabled instead.Stop Basic Awareness.
    * 
    * @return The Future
    */
    public Future<Void> stopAwareness() throws DynamicCallException, ExecutionException{
        return call("stopAwareness");
    }

    /**
    * Set tracking mode.
    * 
    * @param modeName  Name of the mode
    * @return The Future
    */
    public Future<Void> setTrackingMode(String modeName) throws DynamicCallException, ExecutionException{
        return call("setTrackingMode", modeName);
    }

    /**
    * Set tracking mode.
    * 
    * @return Name of current tracking mode as a string
    */
    public Future<String> getTrackingMode() throws DynamicCallException, ExecutionException {
        return call("getTrackingMode");
    }

    /**
    * Force Engage Person.
    * 
    * @param engagePerson  ID of the person as found in PeoplePerception.
    * @return true if the robot succeeded to engage the person, else false.
    */
    public Future<Boolean> engagePerson(Integer engagePerson) throws DynamicCallException, ExecutionException {
        return call("engagePerson", engagePerson);
    }

    /**
    * DEPRECATED since 2.4: use isEnabled instead.Get the status (started or not) of the module.
    * 
    * @return Boolean value, true if running else false
    */
    public Future<Boolean> isAwarenessRunning() throws DynamicCallException, ExecutionException {
        return call("isAwarenessRunning");
    }

    /**
    * Resume BasicAwareness.
    * 
    * @return The Future
    */
    public Future<Void> resumeAwareness() throws DynamicCallException, ExecutionException{
        return call("resumeAwareness");
    }

    /**
    * Get the pause status of the module.
    * 
    */
    public Future<Boolean> isAwarenessPaused() throws DynamicCallException, ExecutionException {
        return call("isAwarenessPaused");
    }

    /**
    * DEPRECATED since 2.4: use setEnabled instead.Start Basic Awareness.
    * 
    * @return The Future
    */
    public Future<Void> startAwareness() throws DynamicCallException, ExecutionException{
        return call("startAwareness");
    }

    /**
    * Enable/Disable Stimulus Detection.
    * 
    * @param stimulusName  Name of the stimulus to enable/disable
    * @param isStimulusDetectionEnabled  Boolean value: true to enable, false to disable.
    * @return The Future
    */
    public Future<Void> setStimulusDetectionEnabled(String stimulusName, Boolean isStimulusDetectionEnabled) throws DynamicCallException, ExecutionException{
        return call("setStimulusDetectionEnabled", stimulusName, isStimulusDetectionEnabled);
    }

    /**
    * Get status enabled/disabled for Stimulus Detection.
    * 
    * @param stimulusName  Name of the stimulus to check
    * @return Boolean value for status enabled/disabled
    */
    public Future<Boolean> isStimulusDetectionEnabled(String stimulusName) throws DynamicCallException, ExecutionException {
        return call("isStimulusDetectionEnabled", stimulusName);
    }

    /**
    * Reset all parameters, including enabled/disabled stimulus.
    * 
    * @return The Future
    */
    public Future<Void> resetAllParameters() throws DynamicCallException, ExecutionException{
        return call("resetAllParameters");
    }

    /**
    * Trigger a custom stimulus.
    * 
    * @param stimulusPosition  Position of the stimulus, in Frame World
    * @return If someone was found, return value is its ID, else it's -1
    */
    public Future<Integer> triggerStimulus(List<Float> stimulusPosition) throws DynamicCallException, ExecutionException {
        return call("triggerStimulus", stimulusPosition);
    }

    /**
    * Set engagement mode.
    * 
    * @return Name of current engagement mode as a string
    */
    public Future<String> getEngagementMode() throws DynamicCallException, ExecutionException {
        return call("getEngagementMode");
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
    * Enable/Disable BasicAwareness.
    * 
    * @param enabled  True to enable BasicAwareness, False to disable BasicAwareness.
    * @return The Future
    */
    public Future<Void> setEnabled(Boolean enabled) throws DynamicCallException, ExecutionException{
        return call("setEnabled", enabled);
    }

    /**
    * Return whether BasicAwareness is enabled or not.
    * 
    * @return Boolean value, true if enabled else false
    */
    public Future<Boolean> isEnabled() throws DynamicCallException, ExecutionException {
        return call("isEnabled");
    }

    }
}
    