package com.xys;

import org.apache.cordova.CordovaActivity;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

import android.content.Intent;
import android.os.Bundle;

public class Cutest extends UnityPlayerActivity{
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
	}
	
	public void showAndroidView() 
	{
		
		UnityPlayer.currentActivity.runOnUiThread(new Runnable() 
		{
			public void run()
			{
				
				Intent intent = new Intent(UnityPlayer.currentActivity.getApplicationContext(), Cutestcordova.class);
				UnityPlayer.currentActivity.startActivity(intent);
			}
		});
	}	
}
