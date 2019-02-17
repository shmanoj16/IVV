package com.bn.ivv.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class busnav extends AppCompatActivity {
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busnav_startup);
        MediaPlayer mysong = MediaPlayer.create(busnav.this,R.raw.busnavact);
        mysong.start();
        b1=(Button)findViewById(R.id.caretkreg);
        b2=(Button)findViewById(R.id.usertrker);
        b3=(Button)findViewById(R.id.busstop);
        Button	back = (Button) findViewById(R.id.back);
        Button	home = (Button) findViewById(R.id.home);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(busnav.this,
                        R.raw.back);
                mysong.start();
            }
        });
        back.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent i = new Intent(busnav.this,SwipeScreen.class);
                startActivityForResult(i, 0);
                return true;
            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(busnav.this,
                        R.raw.home);
                mysong.start();
            }
        });
        home.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                Intent i = new Intent(busnav.this,SwipeScreen.class);
                startActivityForResult(i, 0);
                return true;
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mysong = MediaPlayer.create(busnav.this,
                        R.raw.caretkcr);
                mysong.start();
            }
        });

        b1.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                Intent i = new Intent(busnav.this,GpsTrackerActivity.class);
                startActivityForResult(i, 0);
                return true;
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mysong = MediaPlayer.create(busnav.this,
                        R.raw.caretkcr);
                mysong.start();
            }
        });

        b2.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                Intent i = new Intent(busnav.this,TrackerView.class);
                startActivityForResult(i, 0);
                return true;
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mysong = MediaPlayer.create(busnav.this,
                        R.raw.busstopnav);
                mysong.start();
            }
        });

        b3.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent i;
                PackageManager manager = getPackageManager();
                try {
                    i = manager.getLaunchIntentForPackage("com.techacademy.demomaps");
                    if (i == null)
                        throw new PackageManager.NameNotFoundException();
                    i.addCategory(Intent.CATEGORY_LAUNCHER);
                    startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {
                    MediaPlayer mysong2 = MediaPlayer.create(busnav.this,R.raw.notice2);
                    mysong2.start();
                }
                return true;
            }

        });
    }
}
