package com.bn.ivv.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class objectidentifier extends Activity {
    /**
     * Called when the activity is first created.
     */


Button b1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectidentifier);
        b1 = (Button) findViewById(R.id.obj);
        MediaPlayer mysong = MediaPlayer.create(objectidentifier.this,R.raw.object);
        mysong.start();

        Button	back = (Button) findViewById(R.id.back);
        Button	home = (Button) findViewById(R.id.home);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(objectidentifier.this,
                        R.raw.back);
                mysong.start();
            }
        });
        back.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent i = new Intent(objectidentifier.this,SwipeScreen.class);
                startActivityForResult(i, 0);
                return true;
            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(objectidentifier.this,
                        R.raw.home);
                mysong.start();
            }
        });
        home.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                Intent i = new Intent(objectidentifier.this,SwipeScreen.class);
                startActivityForResult(i, 0);
                return true;
            }
        });




        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i;
                PackageManager manager = getPackageManager();
                try {
                    i = manager.getLaunchIntentForPackage("com.bn.ivv");
                    if (i == null)
                        throw new PackageManager.NameNotFoundException();
                    i.addCategory(Intent.CATEGORY_LAUNCHER);
                    startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {
                    MediaPlayer mysong2 = MediaPlayer.create(objectidentifier.this,R.raw.notice);
                    mysong2.start();
                }
            }
        });

    }


    }
