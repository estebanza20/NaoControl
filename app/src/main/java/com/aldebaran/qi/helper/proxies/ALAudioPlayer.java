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
* This module allows to play wav and mp3 files on NAO
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/audio/alaudioplayer.html#alaudioplayer">NAOqi APIs for ALAudioPlayer </a>
* NAOqi V2.4.x
*/
public class ALAudioPlayer extends ALProxy {

    private AsyncALAudioPlayer asyncProxy;

    public ALAudioPlayer(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALAudioPlayer();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALAudioPlayer object
	 */
    public AsyncALAudioPlayer async() {
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
    * Plays a wav or mp3 file
    * 
    * @param fileName  Path of the sound file
    */
    public void playFile(String fileName) throws DynamicCallException, ExecutionException{
        call("playFile", fileName).get();
    }

    /**
    * Plays a wav or mp3 file, with specific volume and audio balance
    * 
    * @param fileName  Path of the sound file
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right / 0.0 : centered)
    */
    public void playFile(String fileName, Float volume, Float pan) throws DynamicCallException, ExecutionException{
        call("playFile", fileName, volume, pan).get();
    }

    /**
    * Plays a file contained in one of the sound sets loaded
    * 
    * @param fileName  Name of the file without extension
    */
    public void playSoundSetFile(String fileName) throws DynamicCallException, ExecutionException{
        call("playSoundSetFile", fileName).get();
    }

    /**
    * Plays a file contained in a given sound set
    * 
    * @param soundSetName  Name of the soundset
    * @param fileName  Name of the file without extension
    */
    public void playSoundSetFile(String soundSetName, String fileName) throws DynamicCallException, ExecutionException{
        call("playSoundSetFile", soundSetName, fileName).get();
    }

    /**
    * Plays a file contained in a given sound set
    * 
    * @param soundSetName  Name of the soundset
    * @param fileName  Name of the file without extension
    * @param position  Position in second where the playing has to begin
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    * @param loop  specify if the file must be played in loop
    */
    public void playSoundSetFile(String soundSetName, String fileName, Float position, Float volume, Float pan, Boolean loop) throws DynamicCallException, ExecutionException{
        call("playSoundSetFile", soundSetName, fileName, position, volume, pan, loop).get();
    }

    /**
    * Plays a file contained in a given sound set
    * 
    * @param fileName  Name of the file without extension
    * @param position  Position in second where the playing has to begin
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    * @param loop  specify if the file must be played in loop
    */
    public void playSoundSetFile(String fileName, Float position, Float volume, Float pan, Boolean loop) throws DynamicCallException, ExecutionException{
        call("playSoundSetFile", fileName, position, volume, pan, loop).get();
    }

    /**
    * Load a sound set
    * 
    * @param setName  name of the set
    */
    public void loadSoundSet(String setName) throws DynamicCallException, ExecutionException{
        call("loadSoundSet", setName).get();
    }

    /**
    * Unload a sound set
    * 
    * @param setName  name of the set
    */
    public void unloadSoundSet(String setName) throws DynamicCallException, ExecutionException{
        call("unloadSoundSet", setName).get();
    }

    /**
    * Return the list of files contained in a sound set
    * 
    * @param setName  name of the set
    */
    public List<String> getSoundSetFileNames(String setName) throws DynamicCallException, ExecutionException {
        return (List<String>)call("getSoundSetFileNames", setName).get();
    }

    /**
    * 
    * 
    */
    public List<String> getLoadedSoundSetsList() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getLoadedSoundSetsList").get();
    }

    /**
    * 
    * 
    */
    public List<String> getInstalledSoundSetsList() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getInstalledSoundSetsList").get();
    }

    /**
    * 
    * 
    * @param setName  name of the set
    */
    public Boolean isSoundSetInstalled(String setName) throws DynamicCallException, ExecutionException {
        return (Boolean)call("isSoundSetInstalled", setName).get();
    }

    /**
    * 
    * 
    * @param setName  name of the set
    * @param soundName  name of the sound
    */
    public Boolean isSoundSetFileInstalled(String setName, String soundName) throws DynamicCallException, ExecutionException {
        return (Boolean)call("isSoundSetFileInstalled", setName, soundName).get();
    }

    /**
    * Plays a wav or mp3 file in loop
    * 
    * @param fileName  Path of the sound file
    */
    public void playFileInLoop(String fileName) throws DynamicCallException, ExecutionException{
        call("playFileInLoop", fileName).get();
    }

    /**
    * Plays a wav or mp3 file in loop, with specific volume and audio balance
    * 
    * @param fileName  Path of the sound file
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    */
    public void playFileInLoop(String fileName, Float volume, Float pan) throws DynamicCallException, ExecutionException{
        call("playFileInLoop", fileName, volume, pan).get();
    }

    /**
    * Plays a wav or mp3 file from a given position in the file.
    * 
    * @param fileName  Name of the sound file
    * @param position  Position in second where the playing has to begin
    */
    public void playFileFromPosition(String fileName, Float position) throws DynamicCallException, ExecutionException{
        call("playFileFromPosition", fileName, position).get();
    }

    /**
    * Plays a wav or mp3 file from a given position in the file, with specific volume and audio balance
    * 
    * @param fileName  Name of the sound file
    * @param position  Position in second where the playing has to begin
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    */
    public void playFileFromPosition(String fileName, Float position, Float volume, Float pan) throws DynamicCallException, ExecutionException{
        call("playFileFromPosition", fileName, position, volume, pan).get();
    }

    /**
    * Goes to a given position in a file which is playing.
    * 
    * @param playId  Id of the process which is playing the file
    * @param position  Position in the file (in second)
    */
    public void goTo(Integer playId, Float position) throws DynamicCallException, ExecutionException{
        call("goTo", playId, position).get();
    }

    /**
    * Stops all the files that are currently playing.
    * 
    */
    public void stopAll() throws DynamicCallException, ExecutionException{
        call("stopAll").get();
    }

    /**
    * Pause a play back
    * 
    * @param id  Id of the process that is playing the file you want to put in pause
    */
    public void pause(Integer id) throws DynamicCallException, ExecutionException{
        call("pause", id).get();
    }

    /**
    * Sets the volume of the player
    * 
    * @param id  Id of the process that is playing the file you want to put louder or less loud
    * @param volume  Volume - range 0.0 to 1.0
    */
    public void setVolume(Integer id, Float volume) throws DynamicCallException, ExecutionException{
        call("setVolume", id, volume).get();
    }

    /**
    * Sets the master volume of the player
    * 
    * @param volume  Volume - range 0.0 to 1.0
    */
    public void setMasterVolume(Float volume) throws DynamicCallException, ExecutionException{
        call("setMasterVolume", volume).get();
    }

    /**
    * Returns the volume of the player
    * 
    * @param playId  Id of the process which is playing the file
    * @return Volume of the player - range 0.0 to 1.0.
    */
    public Float getVolume(Integer playId) throws DynamicCallException, ExecutionException {
        return (Float)call("getVolume", playId).get();
    }

    /**
    * Returns the master volume of the player
    * 
    * @return Volume of the master - range 0.0 to 1.0.
    */
    public Float getMasterVolume() throws DynamicCallException, ExecutionException {
        return (Float)call("getMasterVolume").get();
    }

    /**
    * sets the audio panorama : -1 for left speaker / 1 for right speaker
    * 
    */
    public void setPanorama(Float param1) throws DynamicCallException, ExecutionException{
        call("setPanorama", param1).get();
    }

    /**
    * Loads a file for ulterior playback
    * 
    * @param fileName  Path of the sound file (either mp3 or wav)
    * @return Id of the file which has been loaded. This file can then be played with the play function
    */
    public Integer loadFile(String fileName) throws DynamicCallException, ExecutionException {
        return (Integer)call("loadFile", fileName).get();
    }

    /**
    * unloads a file previously loaded with the loadFile function
    * 
    * @param id  Id returned by the loadFile function
    */
    public void unloadFile(Integer id) throws DynamicCallException, ExecutionException{
        call("unloadFile", id).get();
    }

    /**
    * unloads all the files already loaded.
    * 
    */
    public void unloadAllFiles() throws DynamicCallException, ExecutionException{
        call("unloadAllFiles").get();
    }

    /**
    * returns an array containing the names of the currently loaded files
    * 
    * @return Array containing the names of the files which has been loaded
    */
    public List<String> getLoadedFilesNames() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getLoadedFilesNames").get();
    }

    /**
    * returns an array containing the Ids of the currently loaded files
    * 
    * @return Array containing the Ids of the files which has been loaded
    */
    public List<String> getLoadedFilesIds() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getLoadedFilesIds").get();
    }

    /**
    * Starts the playback of a file preloaded with the loadFile function.
    * 
    * @param id  Id returned by the loadFile function
    */
    public void play(Integer id) throws DynamicCallException, ExecutionException{
        call("play", id).get();
    }

    /**
    * Starts the playback of a file preloaded with the loadFile function, with specific volume and audio balance
    * 
    * @param id  Id returned by the loadFile function
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    */
    public void play(Integer id, Float volume, Float pan) throws DynamicCallException, ExecutionException{
        call("play", id, volume, pan).get();
    }

    /**
    * Starts the playback in loop of a file preloaded with the loadFile function
    * 
    * @param id  Id returned by the loadFile function
    */
    public void playInLoop(Integer id) throws DynamicCallException, ExecutionException{
        call("playInLoop", id).get();
    }

    /**
    * Plays a wav or mp3 file in loop, with specific volume and audio balance
    * 
    * @param id  Id returned by the loadFile function
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    */
    public void playInLoop(Integer id, Float volume, Float pan) throws DynamicCallException, ExecutionException{
        call("playInLoop", id, volume, pan).get();
    }

    /**
    * Starts the playback of a wab audio stream
    * 
    * @param streamName  Path of the web audio stream
    */
    public void playWebStream(String streamName, Float param1, Float param2) throws DynamicCallException, ExecutionException{
        call("playWebStream", streamName, param1, param2).get();
    }

    /**
    * Returns the length of the file played
    * 
    * @param playId  Id of the process which is playing the file
    * @return Length of the file in seconds
    */
    public Float getFileLength(Integer playId) throws DynamicCallException, ExecutionException {
        return (Float)call("getFileLength", playId).get();
    }

    /**
    * Returns the position in the file which is currently played
    * 
    * @param playId  Id of the process which is playing the file
    * @return Position in the file in seconds
    */
    public Float getCurrentPosition(Integer playId) throws DynamicCallException, ExecutionException {
        return (Float)call("getCurrentPosition", playId).get();
    }

    /**
    * Play a sine wave which specified caracteristics.
    * 
    * @param frequence  Frequence in Hertz
    * @param gain  Volume Gain between 0 and 100
    * @param pan  Stereo Pan set to either {-1,0,+1}
    * @param duration  Duration of the sine wave in seconds
    */
    public void playSine(Integer frequence, Integer gain, Integer pan, Float duration) throws DynamicCallException, ExecutionException{
        call("playSine", frequence, gain, pan, duration).get();
    }

    /**
    * Remove pitch on the current file
    * 
    * @param id  Id returned by the loadFile function
    */
    public void disablePitch(Integer id) throws DynamicCallException, ExecutionException{
        call("disablePitch", id).get();
    }

    /**
    * Set a pith on the current playing file
    * 
    * @param id  Id returned by the loadFile function
    * @param level  Pitch shifting to apply
    */
    public void setPitch(Integer id, Float level) throws DynamicCallException, ExecutionException{
        call("setPitch", id, level).get();
    }


    public class AsyncALAudioPlayer extends ALProxy {

        protected AsyncALAudioPlayer(){
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
    * Plays a wav or mp3 file
    * 
    * @param fileName  Path of the sound file
    * @return The Future
    */
    public Future<Void> playFile(String fileName) throws DynamicCallException, ExecutionException{
        return call("playFile", fileName);
    }

    /**
    * Plays a wav or mp3 file, with specific volume and audio balance
    * 
    * @param fileName  Path of the sound file
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right / 0.0 : centered)
    * @return The Future
    */
    public Future<Void> playFile(String fileName, Float volume, Float pan) throws DynamicCallException, ExecutionException{
        return call("playFile", fileName, volume, pan);
    }

    /**
    * Plays a file contained in one of the sound sets loaded
    * 
    * @param fileName  Name of the file without extension
    * @return The Future
    */
    public Future<Void> playSoundSetFile(String fileName) throws DynamicCallException, ExecutionException{
        return call("playSoundSetFile", fileName);
    }

    /**
    * Plays a file contained in a given sound set
    * 
    * @param soundSetName  Name of the soundset
    * @param fileName  Name of the file without extension
    * @return The Future
    */
    public Future<Void> playSoundSetFile(String soundSetName, String fileName) throws DynamicCallException, ExecutionException{
        return call("playSoundSetFile", soundSetName, fileName);
    }

    /**
    * Plays a file contained in a given sound set
    * 
    * @param soundSetName  Name of the soundset
    * @param fileName  Name of the file without extension
    * @param position  Position in second where the playing has to begin
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    * @param loop  specify if the file must be played in loop
    * @return The Future
    */
    public Future<Void> playSoundSetFile(String soundSetName, String fileName, Float position, Float volume, Float pan, Boolean loop) throws DynamicCallException, ExecutionException{
        return call("playSoundSetFile", soundSetName, fileName, position, volume, pan, loop);
    }

    /**
    * Plays a file contained in a given sound set
    * 
    * @param fileName  Name of the file without extension
    * @param position  Position in second where the playing has to begin
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    * @param loop  specify if the file must be played in loop
    * @return The Future
    */
    public Future<Void> playSoundSetFile(String fileName, Float position, Float volume, Float pan, Boolean loop) throws DynamicCallException, ExecutionException{
        return call("playSoundSetFile", fileName, position, volume, pan, loop);
    }

    /**
    * Load a sound set
    * 
    * @param setName  name of the set
    * @return The Future
    */
    public Future<Void> loadSoundSet(String setName) throws DynamicCallException, ExecutionException{
        return call("loadSoundSet", setName);
    }

    /**
    * Unload a sound set
    * 
    * @param setName  name of the set
    * @return The Future
    */
    public Future<Void> unloadSoundSet(String setName) throws DynamicCallException, ExecutionException{
        return call("unloadSoundSet", setName);
    }

    /**
    * Return the list of files contained in a sound set
    * 
    * @param setName  name of the set
    */
    public Future<List<String>> getSoundSetFileNames(String setName) throws DynamicCallException, ExecutionException {
        return call("getSoundSetFileNames", setName);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getLoadedSoundSetsList() throws DynamicCallException, ExecutionException {
        return call("getLoadedSoundSetsList");
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getInstalledSoundSetsList() throws DynamicCallException, ExecutionException {
        return call("getInstalledSoundSetsList");
    }

    /**
    * 
    * 
    * @param setName  name of the set
    */
    public Future<Boolean> isSoundSetInstalled(String setName) throws DynamicCallException, ExecutionException {
        return call("isSoundSetInstalled", setName);
    }

    /**
    * 
    * 
    * @param setName  name of the set
    * @param soundName  name of the sound
    */
    public Future<Boolean> isSoundSetFileInstalled(String setName, String soundName) throws DynamicCallException, ExecutionException {
        return call("isSoundSetFileInstalled", setName, soundName);
    }

    /**
    * Plays a wav or mp3 file in loop
    * 
    * @param fileName  Path of the sound file
    * @return The Future
    */
    public Future<Void> playFileInLoop(String fileName) throws DynamicCallException, ExecutionException{
        return call("playFileInLoop", fileName);
    }

    /**
    * Plays a wav or mp3 file in loop, with specific volume and audio balance
    * 
    * @param fileName  Path of the sound file
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    * @return The Future
    */
    public Future<Void> playFileInLoop(String fileName, Float volume, Float pan) throws DynamicCallException, ExecutionException{
        return call("playFileInLoop", fileName, volume, pan);
    }

    /**
    * Plays a wav or mp3 file from a given position in the file.
    * 
    * @param fileName  Name of the sound file
    * @param position  Position in second where the playing has to begin
    * @return The Future
    */
    public Future<Void> playFileFromPosition(String fileName, Float position) throws DynamicCallException, ExecutionException{
        return call("playFileFromPosition", fileName, position);
    }

    /**
    * Plays a wav or mp3 file from a given position in the file, with specific volume and audio balance
    * 
    * @param fileName  Name of the sound file
    * @param position  Position in second where the playing has to begin
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    * @return The Future
    */
    public Future<Void> playFileFromPosition(String fileName, Float position, Float volume, Float pan) throws DynamicCallException, ExecutionException{
        return call("playFileFromPosition", fileName, position, volume, pan);
    }

    /**
    * Goes to a given position in a file which is playing.
    * 
    * @param playId  Id of the process which is playing the file
    * @param position  Position in the file (in second)
    * @return The Future
    */
    public Future<Void> goTo(Integer playId, Float position) throws DynamicCallException, ExecutionException{
        return call("goTo", playId, position);
    }

    /**
    * Stops all the files that are currently playing.
    * 
    * @return The Future
    */
    public Future<Void> stopAll() throws DynamicCallException, ExecutionException{
        return call("stopAll");
    }

    /**
    * Pause a play back
    * 
    * @param id  Id of the process that is playing the file you want to put in pause
    * @return The Future
    */
    public Future<Void> pause(Integer id) throws DynamicCallException, ExecutionException{
        return call("pause", id);
    }

    /**
    * Sets the volume of the player
    * 
    * @param id  Id of the process that is playing the file you want to put louder or less loud
    * @param volume  Volume - range 0.0 to 1.0
    * @return The Future
    */
    public Future<Void> setVolume(Integer id, Float volume) throws DynamicCallException, ExecutionException{
        return call("setVolume", id, volume);
    }

    /**
    * Sets the master volume of the player
    * 
    * @param volume  Volume - range 0.0 to 1.0
    * @return The Future
    */
    public Future<Void> setMasterVolume(Float volume) throws DynamicCallException, ExecutionException{
        return call("setMasterVolume", volume);
    }

    /**
    * Returns the volume of the player
    * 
    * @param playId  Id of the process which is playing the file
    * @return Volume of the player - range 0.0 to 1.0.
    */
    public Future<Float> getVolume(Integer playId) throws DynamicCallException, ExecutionException {
        return call("getVolume", playId);
    }

    /**
    * Returns the master volume of the player
    * 
    * @return Volume of the master - range 0.0 to 1.0.
    */
    public Future<Float> getMasterVolume() throws DynamicCallException, ExecutionException {
        return call("getMasterVolume");
    }

    /**
    * sets the audio panorama : -1 for left speaker / 1 for right speaker
    * 
    * @return The Future
    */
    public Future<Void> setPanorama(Float param1) throws DynamicCallException, ExecutionException{
        return call("setPanorama", param1);
    }

    /**
    * Loads a file for ulterior playback
    * 
    * @param fileName  Path of the sound file (either mp3 or wav)
    * @return Id of the file which has been loaded. This file can then be played with the play function
    */
    public Future<Integer> loadFile(String fileName) throws DynamicCallException, ExecutionException {
        return call("loadFile", fileName);
    }

    /**
    * unloads a file previously loaded with the loadFile function
    * 
    * @param id  Id returned by the loadFile function
    * @return The Future
    */
    public Future<Void> unloadFile(Integer id) throws DynamicCallException, ExecutionException{
        return call("unloadFile", id);
    }

    /**
    * unloads all the files already loaded.
    * 
    * @return The Future
    */
    public Future<Void> unloadAllFiles() throws DynamicCallException, ExecutionException{
        return call("unloadAllFiles");
    }

    /**
    * returns an array containing the names of the currently loaded files
    * 
    * @return Array containing the names of the files which has been loaded
    */
    public Future<List<String>> getLoadedFilesNames() throws DynamicCallException, ExecutionException {
        return call("getLoadedFilesNames");
    }

    /**
    * returns an array containing the Ids of the currently loaded files
    * 
    * @return Array containing the Ids of the files which has been loaded
    */
    public Future<List<String>> getLoadedFilesIds() throws DynamicCallException, ExecutionException {
        return call("getLoadedFilesIds");
    }

    /**
    * Starts the playback of a file preloaded with the loadFile function.
    * 
    * @param id  Id returned by the loadFile function
    * @return The Future
    */
    public Future<Void> play(Integer id) throws DynamicCallException, ExecutionException{
        return call("play", id);
    }

    /**
    * Starts the playback of a file preloaded with the loadFile function, with specific volume and audio balance
    * 
    * @param id  Id returned by the loadFile function
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    * @return The Future
    */
    public Future<Void> play(Integer id, Float volume, Float pan) throws DynamicCallException, ExecutionException{
        return call("play", id, volume, pan);
    }

    /**
    * Starts the playback in loop of a file preloaded with the loadFile function
    * 
    * @param id  Id returned by the loadFile function
    * @return The Future
    */
    public Future<Void> playInLoop(Integer id) throws DynamicCallException, ExecutionException{
        return call("playInLoop", id);
    }

    /**
    * Plays a wav or mp3 file in loop, with specific volume and audio balance
    * 
    * @param id  Id returned by the loadFile function
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    * @return The Future
    */
    public Future<Void> playInLoop(Integer id, Float volume, Float pan) throws DynamicCallException, ExecutionException{
        return call("playInLoop", id, volume, pan);
    }

    /**
    * Starts the playback of a wab audio stream
    * 
    * @param streamName  Path of the web audio stream
    * @return The Future
    */
    public Future<Void> playWebStream(String streamName, Float param1, Float param2) throws DynamicCallException, ExecutionException{
        return call("playWebStream", streamName, param1, param2);
    }

    /**
    * Returns the length of the file played
    * 
    * @param playId  Id of the process which is playing the file
    * @return Length of the file in seconds
    */
    public Future<Float> getFileLength(Integer playId) throws DynamicCallException, ExecutionException {
        return call("getFileLength", playId);
    }

    /**
    * Returns the position in the file which is currently played
    * 
    * @param playId  Id of the process which is playing the file
    * @return Position in the file in seconds
    */
    public Future<Float> getCurrentPosition(Integer playId) throws DynamicCallException, ExecutionException {
        return call("getCurrentPosition", playId);
    }

    /**
    * Play a sine wave which specified caracteristics.
    * 
    * @param frequence  Frequence in Hertz
    * @param gain  Volume Gain between 0 and 100
    * @param pan  Stereo Pan set to either {-1,0,+1}
    * @param duration  Duration of the sine wave in seconds
    * @return The Future
    */
    public Future<Void> playSine(Integer frequence, Integer gain, Integer pan, Float duration) throws DynamicCallException, ExecutionException{
        return call("playSine", frequence, gain, pan, duration);
    }

    /**
    * Remove pitch on the current file
    * 
    * @param id  Id returned by the loadFile function
    * @return The Future
    */
    public Future<Void> disablePitch(Integer id) throws DynamicCallException, ExecutionException{
        return call("disablePitch", id);
    }

    /**
    * Set a pith on the current playing file
    * 
    * @param id  Id returned by the loadFile function
    * @param level  Pitch shifting to apply
    * @return The Future
    */
    public Future<Void> setPitch(Integer id, Float level) throws DynamicCallException, ExecutionException{
        return call("setPitch", id, level);
    }

    }
}
    