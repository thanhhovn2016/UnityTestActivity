package com.xys;

import java.io.File;
import java.io.InputStream;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.PluginResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xys.PluginAdapterDelegate;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;


public class PluginAdapterUnity extends UnityPlayerActivity implements PluginAdapterDelegate {

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

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		mContext = this;
	}
	   public void StartWebView(String str)  
	   {  
	       Intent intent = new Intent(mContext,Cutestcordova.class);  
	       this.startActivity(intent);  
	   }  
	
    public static void ShowMobFox() {
        final Activity activity =UnityPlayer.currentActivity;
        
        Log.i("Unity", "Call mobfox aaaa");
       
       
      
        activity.runOnUiThread(new Runnable() {
           
            public void run(){
            	//Toast.makeText(activity, "TEST", Toast.LENGTH_LONG).show();
            	Resources resources =  activity.getResources();
            	LayoutInflater inflater = activity.getLayoutInflater();	
            	String pkgName = activity.getPackageName();
            	//int id = resources.getIdentifier("android_layout", "layout", pkgName);
            	int id = resources.getIdentifier("overlay", "layout", pkgName);
            	View view = inflater.inflate(id, null);
        	    

        	  

                LinearLayout layout = new LinearLayout(activity);
                Log.i("Unity", "Call mobfox bbbb");
                //2b62f52ddb925685cdcbfa098b21b3c6
                //fed5ae7d80eb8378ddd8fd1b85e305ab
                String publisherId = "2b62f52ddb925685cdcbfa098b21b3c6";
                boolean includeLocation = false; 
                boolean animation = true;
                               
                TextView v=new TextView(activity);
                v.setText("My Text");
                layout.addView(v);
                               
                //activity.addContentView(layout,  new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
                
                activity.addContentView(view,  new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
                Button button = (Button)activity.findViewById(resources.getIdentifier("button_id", "id", pkgName));
                button.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View arg0) {
        				Intent intent = new Intent(UnityPlayer.currentActivity.getApplicationContext(), Cutestcordova.class);
        				UnityPlayer.currentActivity.startActivity(intent);

                    	//Toast.makeText(activity, "TEST", Toast.LENGTH_LONG).show();
                    	//UnityPlayer.UnitySendMessage("Main Camera", "SetJavaLog", "HelloWorld Thanh Ho Thanh Ho Thanh Ho Thanh Ho Thanh Ho Thanh Ho Thanh Ho Thanh Ho Thanh Ho Thanh Ho ");
                    }
                });
            }
        });
    }	
	
}
