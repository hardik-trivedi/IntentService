package com.example.intentservice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	public final String IMAGE_URL_1 = "http://t2.gstatic.com/images?q=tbn:ANd9GcSL0o05J2kX0aNGBTrHUiOOOJ7Js7vehTd2KTelY9PVP1JJXaiZ_A";
	public final String IMAGE_URL_2 = "http://www.hdwallpapersbest.com/wp-content/uploads/2012/12/android-wallpaper.jpg";
	public final String IMAGE_URL_3 = "http://t2.gstatic.com/images?q=tbn:ANd9GcR-ku_J_IfvDGT9Ck6OUFZyJgocRihcRWiBMKBGR6WS79i4Wbfy";

	public static final String KEY_URL = "image_url";
	public static final String KEY_NAME = "file_name";

	public static final String file_1 = "file_1.jpg";
	public static final String file_2 = "file_2.jpg";
	public static final String file_3 = "file_3.jpg";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent intent = new Intent(this, MyQueue.class);
		intent.putExtra(KEY_URL, IMAGE_URL_1);
		intent.putExtra(KEY_NAME, file_1);
		startService(intent);

		intent = new Intent(this, MyQueue.class);
		intent.putExtra(KEY_URL, IMAGE_URL_2);
		intent.putExtra(KEY_NAME, file_2);
		startService(intent);

		intent = new Intent(this, MyQueue.class);
		intent.putExtra(KEY_URL, IMAGE_URL_3);
		intent.putExtra(KEY_NAME, file_3);
		startService(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
