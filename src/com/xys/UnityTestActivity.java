package com.xys;
 
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
 
import com.unity3d.player.UnityPlayerActivity;
 
public class UnityTestActivity extends UnityPlayerActivity {
    /** Called when the activity is first created. */
 
	Context mContext = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }
 
    public void StartActivity0(String name)
    {
    	Intent intent = new Intent(mContext,TestActivity0.class);
    	intent.putExtra("name", name);
    	this.startActivity(intent);
    }
 
    public void StartActivity1(String name)
    {
    	Intent intent = new Intent(mContext,TestCordovaActivity.class);
    	//intent.putExtra("name", name);
    	this.startActivity(intent);
    }
}