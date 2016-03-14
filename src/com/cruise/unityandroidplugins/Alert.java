package com.cruise.unityandroidplugins;

import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;

/**
 * @author cruisechang
 * @unityUsage
 * 	public static void ShowAlertBox ( string title, string message ) {
 *		AndroidJavaClass uplayer = new AndroidJavaClass( "com.unity3d.player.UnityPlayer" ) ;			//new unityplayer
 *		AndroidJavaObject activity = uplayer.GetStatic<AndroidJavaObject>("currentActivity");			//get activity
 *		AndroidJavaObject jo = new AndroidJavaObject ("com.cruise.androidtools.Alert", activity); 	//new Alert and pass activity as parameter
 *		jo.Call("showAlert", title, message);														//call 	
	}
 */
public class Alert {
	  private Activity mActivity;
	    public Alert(Activity currentActivity)
	    {
	        Log.i("Alert", "Constructor called with currentActivity = " + currentActivity);
	        mActivity = currentActivity;
	    }
	 
	    public void showAlert( final String title, final String msg ){
	        mActivity.runOnUiThread(new Runnable() {
	            public void run() {
	                AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
	                builder.setTitle(title);
	                builder.setMessage(msg);
	                builder.setPositiveButton("OK", null);
	 
	                AlertDialog alertDialog = builder.create();
	                alertDialog.show();
	            }
	        });
	    }
}
