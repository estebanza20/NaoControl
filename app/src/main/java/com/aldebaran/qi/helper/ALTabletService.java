/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper;

import com.aldebaran.qi.DynamicCallException;
import com.aldebaran.qi.Future;
import com.aldebaran.qi.Session;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
* 
* @see <a href="http://doc.aldebaran.lan/doc/release-2.3/aldeb-doc/naoqi/core/altabletservice.html#altabletservice">NAOqi APIs for ALTabletService </a>
* NAOqi V2.3.x
*/
public class ALTabletService extends ALProxy {

    private AsyncALTabletService asyncProxy;

    public ALTabletService(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALTabletService();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALTabletService object
	 */
    public AsyncALTabletService async() {
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
    * Show Webview (with app-specific content)
    * 
    */
    public Boolean showWebview() throws DynamicCallException, ExecutionException {
        return (Boolean)call("showWebview").get();
    }

    /**
    * Show Webview and load the url
    * 
    */
    public Boolean showWebview(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("showWebview", param1).get();
    }

    /**
    * Load URL on tablet
    * 
    */
    public Boolean loadUrl(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("loadUrl", param1).get();
    }

    /**
    * Reload current displayed web page
    * 
    */
    public void reloadPage(Boolean param1) throws DynamicCallException, ExecutionException{
        call("reloadPage", param1).get();
    }

    /**
    * Start application on tablet
    * 
    */
    public Boolean loadApplication(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("loadApplication", param1).get();
    }

    /**
    * Hide Webview 
    * 
    */
    public Boolean hideWebview() throws DynamicCallException, ExecutionException {
        return (Boolean)call("hideWebview").get();
    }

    /**
    * Clean Webview 
    * 
    */
    public void cleanWebview() throws DynamicCallException, ExecutionException{
        call("cleanWebview").get();
    }

    /**
    * Execute javascript 
    * 
    */
    public void executeJS(String param1) throws DynamicCallException, ExecutionException{
        call("executeJS", param1).get();
    }

    /**
    * Change the onTouch webview scale factor. Default is 1.34 so the viewport is 1707 √ó 1067
    * 
    */
    public void setOnTouchWebviewScaleFactor(Float param1) throws DynamicCallException, ExecutionException{
        call("setOnTouchWebviewScaleFactor", param1).get();
    }

    /**
    * get the onTouch scale factor for current view, by default 1.34 for the webview and 1 for the other views
    * 
    */
    public Float getOnTouchScaleFactor() throws DynamicCallException, ExecutionException {
        return (Float)call("getOnTouchScaleFactor").get();
    }

    /**
    * Play video on tablet
    * 
    */
    public Boolean playVideo(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("playVideo", param1).get();
    }

    /**
    * Resume video on tablet
    * 
    */
    public Boolean resumeVideo() throws DynamicCallException, ExecutionException {
        return (Boolean)call("resumeVideo").get();
    }

    /**
    * Pause video activity on tablet
    * 
    */
    public Boolean pauseVideo() throws DynamicCallException, ExecutionException {
        return (Boolean)call("pauseVideo").get();
    }

    /**
    * Stop video activity on tablet
    * 
    */
    public Boolean stopVideo() throws DynamicCallException, ExecutionException {
        return (Boolean)call("stopVideo").get();
    }

    /**
    * Get video position (in ms from beginning)
    * 
    */
    public Integer getVideoPosition() throws DynamicCallException, ExecutionException {
        return (Integer)call("getVideoPosition").get();
    }

    /**
    * Get video length (in ms)
    * 
    */
    public Integer getVideoLength() throws DynamicCallException, ExecutionException {
        return (Integer)call("getVideoLength").get();
    }

    /**
    * preload an image
    * 
    */
    public Boolean preLoadImage(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("preLoadImage", param1).get();
    }

    /**
    * show an image
    * 
    */
    public Boolean showImage(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("showImage", param1).get();
    }

    /**
    * show an image, disable tablet cache
    * 
    */
    public Boolean showImageNoCache(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("showImageNoCache", param1).get();
    }

    /**
    * Hide an image
    * 
    */
    public void hideImage() throws DynamicCallException, ExecutionException{
        call("hideImage").get();
    }

    /**
    * resume the gif
    * 
    */
    public void resumeGif() throws DynamicCallException, ExecutionException{
        call("resumeGif").get();
    }

    /**
    * pause the gif
    * 
    */
    public void pauseGif() throws DynamicCallException, ExecutionException{
        call("pauseGif").get();
    }

    /**
    * Set the background color for image
    * 
    */
    public Boolean setBackgroundColor(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("setBackgroundColor", param1).get();
    }

    /**
    * hide the top view
    * 
    */
    public void hide() throws DynamicCallException, ExecutionException{
        call("hide").get();
    }

    /**
    * Change screen brightness
    * 
    */
    public Boolean setBrightness(Float param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("setBrightness", param1).get();
    }

    /**
    * Change screen brightness
    * 
    */
    public Float getBrightness() throws DynamicCallException, ExecutionException {
        return (Float)call("getBrightness").get();
    }

    /**
    * Turn on (true) / off (false)  the screen
    * 
    */
    public void turnScreenOn(Boolean param1) throws DynamicCallException, ExecutionException{
        call("turnScreenOn", param1).get();
    }

    /**
    * Put the tablet in sleep mode (standby mode)
    * 
    */
    public void goToSleep() throws DynamicCallException, ExecutionException{
        call("goToSleep").get();
    }

    /**
    * Put the tablet in wake mode (standby mode)
    * 
    */
    public void wakeUp() throws DynamicCallException, ExecutionException{
        call("wakeUp").get();
    }

    /**
    * Check the WIFI on the tablet : IDLE, SCANNING, DISCONNECTED, CONNECTED
    * 
    */
    public String getWifiStatus() throws DynamicCallException, ExecutionException {
        return (String)call("getWifiStatus").get();
    }

    /**
    * Enable the wifi on the tablet
    * 
    */
    public void enableWifi() throws DynamicCallException, ExecutionException{
        call("enableWifi").get();
    }

    /**
    * Disable the wifi on the tablet
    * 
    */
    public void disableWifi() throws DynamicCallException, ExecutionException{
        call("disableWifi").get();
    }

    /**
    * Forget the wifi : 1) SSID
    * 
    */
    public Boolean forgetWifi(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("forgetWifi", param1).get();
    }

    /**
    * Try to connect to the wifi by is SSID
    * 
    */
    public Boolean connectWifi(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("connectWifi", param1).get();
    }

    /**
    * Disconnect current wifi
    * 
    */
    public Boolean disconnectWifi() throws DynamicCallException, ExecutionException {
        return (Boolean)call("disconnectWifi").get();
    }

    /**
    * Configure the WIFI, arguments: 
       1) is type among (wep, wpa, open) 
       2) is the wifi SSID 
       3) is wep or wap passphrase 

    * 
    */
    public Boolean configureWifi(String param1, String param2, String param3) throws DynamicCallException, ExecutionException {
        return (Boolean)call("configureWifi", param1, param2, param3).get();
    }

    /**
    * Show a input text dialog, arguments 
       1) the title 
       2) is the ok text  
       3) the cancel text 
    * 
    */
    public void showInputTextDialog(String param1, String param2, String param3) throws DynamicCallException, ExecutionException{
        call("showInputTextDialog", param1, param2, param3).get();
    }

    /**
    * Show a input text dialog, arguments 
       1) the title 
       2) is the ok text  
       3) the cancel text 
       4) the pre-filled text of the input field 
       5) input characters limit
    * 
    */
    public void showInputTextDialog(String param1, String param2, String param3, String param4, Integer param5) throws DynamicCallException, ExecutionException{
        call("showInputTextDialog", param1, param2, param3, param4, param5).get();
    }

    /**
    * Show a input text dialog, arguments : 
       1) is type among text, password, email, url, number 
       2) the title 
       3) is the ok text 
       4) the cancel text
    * 
    */
    public void showInputDialog(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException{
        call("showInputDialog", param1, param2, param3, param4).get();
    }

    /**
    * Show a input text dialog, arguments 
       1) is type among text, password, email, url, number 
       2) the title 
       3) is the ok text 
       4) the cancel text 
       5) the pre-filled text of the input field, use '' if you don't want any 
       6) input characters limit, use -1 if you don't want a limit
    * 
    */
    public void showInputDialog(String param1, String param2, String param3, String param4, String param5, Integer param6) throws DynamicCallException, ExecutionException{
        call("showInputDialog", param1, param2, param3, param4, param5, param6).get();
    }

    /**
    * Test debug function
    * 
    */
    public void showAlertView(Float param1, String param2, Integer param3) throws DynamicCallException, ExecutionException{
        call("showAlertView", param1, param2, param3).get();
    }

    /**
    * Hide the dialog view
    * 
    */
    public void hideDialog() throws DynamicCallException, ExecutionException{
        call("hideDialog").get();
    }

    /**
    * Set keyboard using is keyboard id from getAvailableKeyboards
    * 
    */
    public Boolean setKeyboard(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("setKeyboard", param1).get();
    }

    /**
    * get available keyboards
    * 
    */
    public List<String> getAvailableKeyboards() throws DynamicCallException, ExecutionException {
        return (List<String>)call("getAvailableKeyboards").get();
    }

    /**
    * Change the tablet language: fr, fr_FR, en, us, it, ja ... 
    * 
    */
    public Boolean setTabletLanguage(String param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("setTabletLanguage", param1).get();
    }

    /**
    * Set the volume of the tablet between 0 and 15
    * 
    */
    public Boolean setVolume(Integer param1) throws DynamicCallException, ExecutionException {
        return (Boolean)call("setVolume", param1).get();
    }

    /**
    * Get IP of connected robot
    * 
    */
    public String robotIp() throws DynamicCallException, ExecutionException {
        return (String)call("robotIp").get();
    }

    /**
    * Return the current life activity running
    * 
    */
    public String getCurrentLifeActivity() throws DynamicCallException, ExecutionException {
        return (String)call("getCurrentLifeActivity").get();
    }

    /**
    * Return service version
    * 
    */
    public String version() throws DynamicCallException, ExecutionException {
        return (String)call("version").get();
    }

    /**
    * reset the tablet (get back to the bubble views and clear everything)
    * 
    */
    public void resetTablet() throws DynamicCallException, ExecutionException{
        call("resetTablet").get();
    }

    /**
    * Get last video played error log [DEPRECATED]
    * 
    */
    public String getLastVideoErrorLog() throws DynamicCallException, ExecutionException {
        return (String)call("getLastVideoErrorLog").get();
    }

    /**
    * Enable touch signal on webview [DEPRECATED]
    * 
    */
    public void enableWebviewTouch() throws DynamicCallException, ExecutionException{
        call("enableWebviewTouch").get();
    }

    /**
    * Disable touch signal on webview [DEPRECATED]
    * 
    */
    public void disableWebviewTouch() throws DynamicCallException, ExecutionException{
        call("disableWebviewTouch").get();
    }

    /**
    * reset to default value [DEPRECATED]
    * 
    */
    public void resetToDefaultValue() throws DynamicCallException, ExecutionException{
        call("resetToDefaultValue").get();
    }


    public class AsyncALTabletService extends ALProxy {

        protected AsyncALTabletService(){
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
    * Show Webview (with app-specific content)
    * 
    */
    public Future<Boolean> showWebview() throws DynamicCallException, ExecutionException {
        return call("showWebview");
    }

    /**
    * Show Webview and load the url
    * 
    */
    public Future<Boolean> showWebview(String param1) throws DynamicCallException, ExecutionException {
        return call("showWebview", param1);
    }

    /**
    * Load URL on tablet
    * 
    */
    public Future<Boolean> loadUrl(String param1) throws DynamicCallException, ExecutionException {
        return call("loadUrl", param1);
    }

    /**
    * Reload current displayed web page
    * 
    * @return The Future
    */
    public Future<Void> reloadPage(Boolean param1) throws DynamicCallException, ExecutionException{
        return call("reloadPage", param1);
    }

    /**
    * Start application on tablet
    * 
    */
    public Future<Boolean> loadApplication(String param1) throws DynamicCallException, ExecutionException {
        return call("loadApplication", param1);
    }

    /**
    * Hide Webview 
    * 
    */
    public Future<Boolean> hideWebview() throws DynamicCallException, ExecutionException {
        return call("hideWebview");
    }

    /**
    * Clean Webview 
    * 
    * @return The Future
    */
    public Future<Void> cleanWebview() throws DynamicCallException, ExecutionException{
        return call("cleanWebview");
    }

    /**
    * Execute javascript 
    * 
    * @return The Future
    */
    public Future<Void> executeJS(String param1) throws DynamicCallException, ExecutionException{
        return call("executeJS", param1);
    }

    /**
    * Change the onTouch webview scale factor. Default is 1.34 so the viewport is 1707 √ó 1067
    * 
    * @return The Future
    */
    public Future<Void> setOnTouchWebviewScaleFactor(Float param1) throws DynamicCallException, ExecutionException{
        return call("setOnTouchWebviewScaleFactor", param1);
    }

    /**
    * get the onTouch scale factor for current view, by default 1.34 for the webview and 1 for the other views
    * 
    */
    public Future<Float> getOnTouchScaleFactor() throws DynamicCallException, ExecutionException {
        return call("getOnTouchScaleFactor");
    }

    /**
    * Play video on tablet
    * 
    */
    public Future<Boolean> playVideo(String param1) throws DynamicCallException, ExecutionException {
        return call("playVideo", param1);
    }

    /**
    * Resume video on tablet
    * 
    */
    public Future<Boolean> resumeVideo() throws DynamicCallException, ExecutionException {
        return call("resumeVideo");
    }

    /**
    * Pause video activity on tablet
    * 
    */
    public Future<Boolean> pauseVideo() throws DynamicCallException, ExecutionException {
        return call("pauseVideo");
    }

    /**
    * Stop video activity on tablet
    * 
    */
    public Future<Boolean> stopVideo() throws DynamicCallException, ExecutionException {
        return call("stopVideo");
    }

    /**
    * Get video position (in ms from beginning)
    * 
    */
    public Future<Integer> getVideoPosition() throws DynamicCallException, ExecutionException {
        return call("getVideoPosition");
    }

    /**
    * Get video length (in ms)
    * 
    */
    public Future<Integer> getVideoLength() throws DynamicCallException, ExecutionException {
        return call("getVideoLength");
    }

    /**
    * preload an image
    * 
    */
    public Future<Boolean> preLoadImage(String param1) throws DynamicCallException, ExecutionException {
        return call("preLoadImage", param1);
    }

    /**
    * show an image
    * 
    */
    public Future<Boolean> showImage(String param1) throws DynamicCallException, ExecutionException {
        return call("showImage", param1);
    }

    /**
    * show an image, disable tablet cache
    * 
    */
    public Future<Boolean> showImageNoCache(String param1) throws DynamicCallException, ExecutionException {
        return call("showImageNoCache", param1);
    }

    /**
    * Hide an image
    * 
    * @return The Future
    */
    public Future<Void> hideImage() throws DynamicCallException, ExecutionException{
        return call("hideImage");
    }

    /**
    * resume the gif
    * 
    * @return The Future
    */
    public Future<Void> resumeGif() throws DynamicCallException, ExecutionException{
        return call("resumeGif");
    }

    /**
    * pause the gif
    * 
    * @return The Future
    */
    public Future<Void> pauseGif() throws DynamicCallException, ExecutionException{
        return call("pauseGif");
    }

    /**
    * Set the background color for image
    * 
    */
    public Future<Boolean> setBackgroundColor(String param1) throws DynamicCallException, ExecutionException {
        return call("setBackgroundColor", param1);
    }

    /**
    * hide the top view
    * 
    * @return The Future
    */
    public Future<Void> hide() throws DynamicCallException, ExecutionException{
        return call("hide");
    }

    /**
    * Change screen brightness
    * 
    */
    public Future<Boolean> setBrightness(Float param1) throws DynamicCallException, ExecutionException {
        return call("setBrightness", param1);
    }

    /**
    * Change screen brightness
    * 
    */
    public Future<Float> getBrightness() throws DynamicCallException, ExecutionException {
        return call("getBrightness");
    }

    /**
    * Turn on (true) / off (false)  the screen
    * 
    * @return The Future
    */
    public Future<Void> turnScreenOn(Boolean param1) throws DynamicCallException, ExecutionException{
        return call("turnScreenOn", param1);
    }

    /**
    * Put the tablet in sleep mode (standby mode)
    * 
    * @return The Future
    */
    public Future<Void> goToSleep() throws DynamicCallException, ExecutionException{
        return call("goToSleep");
    }

    /**
    * Put the tablet in wake mode (standby mode)
    * 
    * @return The Future
    */
    public Future<Void> wakeUp() throws DynamicCallException, ExecutionException{
        return call("wakeUp");
    }

    /**
    * Check the WIFI on the tablet : IDLE, SCANNING, DISCONNECTED, CONNECTED
    * 
    */
    public Future<String> getWifiStatus() throws DynamicCallException, ExecutionException {
        return call("getWifiStatus");
    }

    /**
    * Enable the wifi on the tablet
    * 
    * @return The Future
    */
    public Future<Void> enableWifi() throws DynamicCallException, ExecutionException{
        return call("enableWifi");
    }

    /**
    * Disable the wifi on the tablet
    * 
    * @return The Future
    */
    public Future<Void> disableWifi() throws DynamicCallException, ExecutionException{
        return call("disableWifi");
    }

    /**
    * Forget the wifi : 1) SSID
    * 
    */
    public Future<Boolean> forgetWifi(String param1) throws DynamicCallException, ExecutionException {
        return call("forgetWifi", param1);
    }

    /**
    * Try to connect to the wifi by is SSID
    * 
    */
    public Future<Boolean> connectWifi(String param1) throws DynamicCallException, ExecutionException {
        return call("connectWifi", param1);
    }

    /**
    * Disconnect current wifi
    * 
    */
    public Future<Boolean> disconnectWifi() throws DynamicCallException, ExecutionException {
        return call("disconnectWifi");
    }

    /**
    * Configure the WIFI, arguments: 
       1) is type among (wep, wpa, open) 
       2) is the wifi SSID 
       3) is wep or wap passphrase 

    * 
    */
    public Future<Boolean> configureWifi(String param1, String param2, String param3) throws DynamicCallException, ExecutionException {
        return call("configureWifi", param1, param2, param3);
    }

    /**
    * Show a input text dialog, arguments 
       1) the title 
       2) is the ok text  
       3) the cancel text 
    * 
    * @return The Future
    */
    public Future<Void> showInputTextDialog(String param1, String param2, String param3) throws DynamicCallException, ExecutionException{
        return call("showInputTextDialog", param1, param2, param3);
    }

    /**
    * Show a input text dialog, arguments 
       1) the title 
       2) is the ok text  
       3) the cancel text 
       4) the pre-filled text of the input field 
       5) input characters limit
    * 
    * @return The Future
    */
    public Future<Void> showInputTextDialog(String param1, String param2, String param3, String param4, Integer param5) throws DynamicCallException, ExecutionException{
        return call("showInputTextDialog", param1, param2, param3, param4, param5);
    }

    /**
    * Show a input text dialog, arguments : 
       1) is type among text, password, email, url, number 
       2) the title 
       3) is the ok text 
       4) the cancel text
    * 
    * @return The Future
    */
    public Future<Void> showInputDialog(String param1, String param2, String param3, String param4) throws DynamicCallException, ExecutionException{
        return call("showInputDialog", param1, param2, param3, param4);
    }

    /**
    * Show a input text dialog, arguments 
       1) is type among text, password, email, url, number 
       2) the title 
       3) is the ok text 
       4) the cancel text 
       5) the pre-filled text of the input field, use '' if you don't want any 
       6) input characters limit, use -1 if you don't want a limit
    * 
    * @return The Future
    */
    public Future<Void> showInputDialog(String param1, String param2, String param3, String param4, String param5, Integer param6) throws DynamicCallException, ExecutionException{
        return call("showInputDialog", param1, param2, param3, param4, param5, param6);
    }

    /**
    * Test debug function
    * 
    * @return The Future
    */
    public Future<Void> showAlertView(Float param1, String param2, Integer param3) throws DynamicCallException, ExecutionException{
        return call("showAlertView", param1, param2, param3);
    }

    /**
    * Hide the dialog view
    * 
    * @return The Future
    */
    public Future<Void> hideDialog() throws DynamicCallException, ExecutionException{
        return call("hideDialog");
    }

    /**
    * Set keyboard using is keyboard id from getAvailableKeyboards
    * 
    */
    public Future<Boolean> setKeyboard(String param1) throws DynamicCallException, ExecutionException {
        return call("setKeyboard", param1);
    }

    /**
    * get available keyboards
    * 
    */
    public Future<List<String>> getAvailableKeyboards() throws DynamicCallException, ExecutionException {
        return call("getAvailableKeyboards");
    }

    /**
    * Change the tablet language: fr, fr_FR, en, us, it, ja ... 
    * 
    */
    public Future<Boolean> setTabletLanguage(String param1) throws DynamicCallException, ExecutionException {
        return call("setTabletLanguage", param1);
    }

    /**
    * Set the volume of the tablet between 0 and 15
    * 
    */
    public Future<Boolean> setVolume(Integer param1) throws DynamicCallException, ExecutionException {
        return call("setVolume", param1);
    }

    /**
    * Get IP of connected robot
    * 
    */
    public Future<String> robotIp() throws DynamicCallException, ExecutionException {
        return call("robotIp");
    }

    /**
    * Return the current life activity running
    * 
    */
    public Future<String> getCurrentLifeActivity() throws DynamicCallException, ExecutionException {
        return call("getCurrentLifeActivity");
    }

    /**
    * Return service version
    * 
    */
    public Future<String> version() throws DynamicCallException, ExecutionException {
        return call("version");
    }

    /**
    * reset the tablet (get back to the bubble views and clear everything)
    * 
    * @return The Future
    */
    public Future<Void> resetTablet() throws DynamicCallException, ExecutionException{
        return call("resetTablet");
    }

    /**
    * Get last video played error log [DEPRECATED]
    * 
    */
    public Future<String> getLastVideoErrorLog() throws DynamicCallException, ExecutionException {
        return call("getLastVideoErrorLog");
    }

    /**
    * Enable touch signal on webview [DEPRECATED]
    * 
    * @return The Future
    */
    public Future<Void> enableWebviewTouch() throws DynamicCallException, ExecutionException{
        return call("enableWebviewTouch");
    }

    /**
    * Disable touch signal on webview [DEPRECATED]
    * 
    * @return The Future
    */
    public Future<Void> disableWebviewTouch() throws DynamicCallException, ExecutionException{
        return call("disableWebviewTouch");
    }

    /**
    * reset to default value [DEPRECATED]
    * 
    * @return The Future
    */
    public Future<Void> resetToDefaultValue() throws DynamicCallException, ExecutionException{
        return call("resetToDefaultValue");
    }

    }
}
    