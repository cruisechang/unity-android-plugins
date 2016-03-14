# unity-android-plugins
An unity android plugins project.
Now we have 2 plugins in this project.

1. Show native alert
2. AES encrypt and decrype

Usage:

Put unityandroidplugins.jar into unity Plugins folder.


Show native alert c#

	public void ShowAlertBox ( string title, string message ) {
		AndroidJavaClass uplayer = new AndroidJavaClass( "com.unity3d.player.UnityPlayer" ) ;
		
		AndroidJavaObject activity = uplayer.GetStatic<AndroidJavaObject>("currentActivity");
		AndroidJavaObject javaClass = new AndroidJavaObject ("com.cruise.androidtools.Alert", activity);  
		
		javaClass.Call("showAlert", title, message);
	}


Get AES key c#

	public static byte[] GetAESKey()
	{
		AndroidJavaObject javaObj = new AndroidJavaObject ("com.cruise.androidtools.AESTools");  
		return javaObj.Call<byte[]> ("initKey");
	}
	</html>
