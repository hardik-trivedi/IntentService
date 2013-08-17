package com.example.intentservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;

public class MyQueue extends IntentService {
	String name;

	public MyQueue() {
		super("MyService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		String img_url = intent.getStringExtra(MainActivity.KEY_URL);
		String fileName = intent.getStringExtra(MainActivity.KEY_NAME);
		try {
			URL url = new URL(img_url);
			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setDoOutput(true);
			urlConnection.connect();
			File SDCardRoot = Environment.getExternalStorageDirectory();
			File file = new File(SDCardRoot, fileName);
			FileOutputStream fileOutput = new FileOutputStream(file);
			InputStream inputStream = urlConnection.getInputStream();
			byte[] buffer = new byte[1024];
			int bufferLength = 0;
			while ((bufferLength = inputStream.read(buffer)) > 0) {
				fileOutput.write(buffer, 0, bufferLength);
			}
			fileOutput.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
