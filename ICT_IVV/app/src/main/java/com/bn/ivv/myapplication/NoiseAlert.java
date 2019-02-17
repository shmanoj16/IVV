package com.bn.ivv.myapplication;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class NoiseAlert extends Activity {
	/* constants */
	private static final int POLL_INTERVAL = 300;

	/** running state **/
	private boolean mRunning = false;

	/** config state **/
	private double mThreshold;


	private MediaPlayer mysong;

	private PowerManager.WakeLock mWakeLock;

	private Handler mHandler = new Handler();

	/* References to view elements */
	private TextView mStatusView, tv_noice;

	/* sound data source */
	private Detect_noise mSensor;
	ProgressBar bar;
	/****************** Define runnable thread again and again detect noise *********/

	private Runnable mSleepTask = new Runnable() {
		public void run() {
			// Log.i("Noise", "runnable mSleepTask");

			start();
		}
	};

	// Create runnable thread to Monitor Voice
	private Runnable mPollTask = new Runnable() {
		public void run() {
			double amp = mSensor.getAmplitude();
			// Log.i("Noise", "runnable mPollTask");
			updateDisplay("Detecting Obstacle...", amp);

			if ((amp > mThreshold)) {
				callForHelp(amp);
				// Log.i("Noise", "==== onCreate ===");
			}
			// Runnable(mPollTask) will again execute after POLL_INTERVAL
			mHandler.postDelayed(mPollTask, POLL_INTERVAL);
		}
	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.noise_main);
		mStatusView = (TextView) findViewById(R.id.status);
		tv_noice = (TextView) findViewById(R.id.tv_noice);
		bar = (ProgressBar) findViewById(R.id.progressBar1);
		// Used to record voice IVV
		mSensor = new Detect_noise();
		MediaPlayer mediaplayer = MediaPlayer.create(NoiseAlert.this,
				R.raw.ultra);
		mediaplayer.start();

		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK,
				"NoiseAlert");
		Button	back = (Button) findViewById(R.id.back);
		Button	home = (Button) findViewById(R.id.home);
		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				MediaPlayer mysong = MediaPlayer.create(NoiseAlert.this,
						R.raw.back);
				mysong.start();
			}
		});
		back.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				System.exit(0);
				Intent i = new Intent(NoiseAlert.this,SwipeScreen.class);
				startActivityForResult(i, 0);
				return true;
			}
		});
		home.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				MediaPlayer mysong = MediaPlayer.create(NoiseAlert.this,
						R.raw.home);
				mysong.start();
			}
		});
		home.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {

				Intent i = new Intent(NoiseAlert.this,SwipeScreen.class);
				startActivityForResult(i, 0);
				return true;
			}
		});
	}

	@Override
	public void onResume() {
		super.onResume();
		// Log.i("Noise", "==== onResume ===");

		initializeApplicationConstants();
		if (!mRunning) {
			mRunning = true;
			start();
		}
	}
    
	@Override
	public void onStop() {
		super.onStop();
		// Log.i("Noise", "==== onStop ===");
		// Stop noise monitoring
		stop();
	}

	private void start() {
		// Log.i("Noise", "==== start ===");
		mSensor.start();
		if (!mWakeLock.isHeld()) {
			mWakeLock.acquire();
		}
		// Noise monitoring start
		// Runnable(mPollTask) will execute after POLL_INTERVAL
		mHandler.postDelayed(mPollTask, POLL_INTERVAL);
	}

	private void stop() {
		Log.i("Noise", "==== Stop Noise Monitoring===");
		if (mWakeLock.isHeld()) {
			mWakeLock.release();
		}
		mHandler.removeCallbacks(mSleepTask);
		mHandler.removeCallbacks(mPollTask);
		mSensor.stop();
		bar.setProgress(0);
		updateDisplay("stopped...", 0.0);
		mRunning = false;

	}


////////////////////////////////SET OBSTACLE DETECTION VALUE HERE!!!!!!////////////////////////////////////
	//constant sound wave value=17 to 18
	private void initializeApplicationConstants() {
		// Set Noise Threshold
		mThreshold = 18.9;

	}

	private void updateDisplay(String status, double signalEMA) {
		mStatusView.setText(status);
		//
		bar.setProgress((int) signalEMA);
		Log.d("SONUND", String.valueOf(signalEMA));
		tv_noice.setText(signalEMA + "dB");
	}
	public void onBackPressed() {
		android.os.Process.killProcess(android.os.Process.myPid());
		Intent intent = new Intent(NoiseAlert.this, SwipeScreen.class);
		startActivity(intent);
	}

	private void callForHelp(double signalEMA) {

		// stop();

		// Show alert when noise thersold crossed
		Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		v.vibrate(50);
		Log.d("SONUND", String.valueOf(signalEMA));
		tv_noice.setText(signalEMA + "dB");
	}

};
