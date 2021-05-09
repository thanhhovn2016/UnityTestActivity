package com.xys;
import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.PluginResult;

import com.unity3d.player.UnityPlayer;
public class Cutestcordova extends CordovaActivity implements PluginAdapterDelegate{
	private static RelativeLayout rootLayout = null;
	private static View	mainView = null;
	Context mContext = null;
	
	@Override
	public Activity getActivity() {
		return UnityPlayer.currentActivity;
	}

	@Override
	public View getView() {
		Activity act = getActivity();
		// mock Cordova's webView and the layout container
		if(rootLayout == null) {
			rootLayout = new RelativeLayout(act);
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			getActivity().addContentView(rootLayout, params);
		}
		if(mainView == null) {
			mainView = new RelativeLayout(act);
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			rootLayout.addView(mainView, params);
		}
		return mainView;
	}

	@Override
	public void fireEvent(String obj, String eventName, String jsonData) {
		UnityPlayer.UnitySendMessage(obj, eventName, jsonData);
	}

	@Override
	public void sendPluginResult(PluginResult result, CallbackContext context) {
		String jsonData = "{\"callbackId\":\"" + context.getCallbackId() + 
				"\",\"status\":" + result.getStatus() + 
				",\"keepCallback\":" + (result.getKeepCallback()?1:0)  + 
				",\"data\":" + result.getMessage() + 
				"}";
		UnityPlayer.UnitySendMessage("Cordova", "onExecuteCallback", jsonData);
	}
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.init();
        // Load your application
         //launchUrl = getClass().getClassLoader().getResource("/assets/index.html").toString();
        launchUrl = "file:///android_asset/index.html";
        //String sAssets = "http://93.115.97.151/cv//index.html";
        loadUrl(launchUrl);
   }
}
