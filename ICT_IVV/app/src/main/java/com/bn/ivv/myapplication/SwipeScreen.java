package com.bn.ivv.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.bn.ivv.myapplication.SimpleGestureFilter.SimpleGestureListener;

import static android.view.View.IMPORTANT_FOR_ACCESSIBILITY_NO;

public class SwipeScreen extends Activity implements
		SimpleGestureListener {
	private boolean doubleBackToExitPressedOnce = false;
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mysong.stop();
	}
	
	MediaPlayer mysong;
	
	
	private SimpleGestureFilter detector;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.swipe_screen);
		MediaPlayer mysong = MediaPlayer.create(SwipeScreen.this,R.raw.instru);
		mysong.start();

		// Detect touched area
		detector = new SimpleGestureFilter(this, this);
		this.doubleBackToExitPressedOnce = false;
	}
	@Override
	public void onBackPressed() {
		System.exit(0);
	}


	@Override
	public boolean dispatchTouchEvent(MotionEvent me) {
		// Call onTouchEvent of SimpleGestureFilter class
		this.detector.onTouchEvent(me);
		return super.dispatchTouchEvent(me);
	}

	@Override

	public void onSwipe(int direction) {
		String str = "";
		switch (direction) 
{

		case SimpleGestureFilter.SWIPE_RIGHT:
			try {
				Class classtts = Class.forName("com.bn.ivv.myapplication.busnav");
				Intent intenttts = new Intent(SwipeScreen.this, classtts);
				startActivity(intenttts);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			android.os.Process.killProcess(android.os.Process.myPid());
			break;

		case SimpleGestureFilter.SWIPE_LEFT:
			try {
				Class atm = Class.forName("com.bn.ivv.myapplication.atm");
				Intent intenttts = new Intent(SwipeScreen.this, atm);
				startActivity(intenttts);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			android.os.Process.killProcess(android.os.Process.myPid());
			break;
		case SimpleGestureFilter.SWIPE_DOWN:
			try {
				Class ourclass = Class
						.forName("com.bn.ivv.myapplication.objectidentifier");
				Intent ourIntent = new Intent(SwipeScreen.this, ourclass);
				startActivity(ourIntent);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			android.os.Process.killProcess(android.os.Process.myPid());
			break;
		case SimpleGestureFilter.SWIPE_UP:
			try {
				Class ourclass = Class
						.forName("com.bn.ivv.myapplication.NoiseAlert");
				Intent ourIntent = new Intent(SwipeScreen.this, ourclass);
				startActivity(ourIntent);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			android.os.Process.killProcess(android.os.Process.myPid());
			break;

		}
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onDoubleTap() {
		try {
			Class ourclass = Class
					.forName("com.bn.ivv.myapplication.NoiseAlert");
			Intent ourIntent = new Intent(SwipeScreen.this, ourclass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


	}


	public void onSingleTapUp() {
		Toast.makeText(this, "Single Tap", Toast.LENGTH_SHORT).show();
	}
}