package com.bn.ivv.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class option extends AppCompatActivity {
    Button b1, b2, b3, b4, b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        MediaPlayer mysong = MediaPlayer.create(option.this,R.raw.trans_atm);
        mysong.start();
        b1 = (Button) findViewById(R.id.wd);
        b2 = (Button) findViewById(R.id.fc);
        b3 = (Button) findViewById(R.id.pc);
        b4 = (Button) findViewById(R.id.eq);
        b5 = (Button) findViewById(R.id.ca);
        Button	back = (Button) findViewById(R.id.back);
        Button	home = (Button) findViewById(R.id.home);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(option.this,
                        R.raw.back);
                mysong.start();
            }
        });
        back.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent i = new Intent(option.this,pin.class);
                startActivityForResult(i, 0);
                return true;
            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(option.this,
                        R.raw.home);
                mysong.start();
            }
        });
        home.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                Intent i = new Intent(option.this,SwipeScreen.class);
                startActivityForResult(i, 0);
                return true;
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(option.this,
                        R.raw.wd);
                mysong.start();
            }
        });
        b1.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent myintent = new Intent(option.this,amount.class);
                startActivityForResult(myintent,0);


                return true;
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(option.this,
                        R.raw.fc);
                mysong.start();
            }
        });
        b2.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                return true;
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(option.this,
                        R.raw.pc);
                mysong.start();
            }
        });
        b3.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                return true;
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(option.this,
                        R.raw.eq);
                mysong.start();
            }
        });
        b4.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                return true;
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(option.this,
                        R.raw.ct);
                mysong.start();
            }
        });
        b5.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                return true;
            }
        });



    }
}
