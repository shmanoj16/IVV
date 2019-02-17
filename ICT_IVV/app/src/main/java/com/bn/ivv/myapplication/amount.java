package com.bn.ivv.myapplication;


import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class amount extends AppCompatActivity {
    EditText et1;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bclr, bnext, bbk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);
        MediaPlayer mysong = MediaPlayer.create(amount.this,R.raw.amt_atm);
        mysong.start();
        et1 = (EditText) findViewById(R.id.pin);
        b1 = (Button) findViewById(R.id.one);
        b2 = (Button) findViewById(R.id.two);
        b3 = (Button) findViewById(R.id.three);
        b4 = (Button) findViewById(R.id.four);
        b5 = (Button) findViewById(R.id.five);
        b6 = (Button) findViewById(R.id.six);
        b7 = (Button) findViewById(R.id.seven);
        b8 = (Button) findViewById(R.id.eight);
        b9 = (Button) findViewById(R.id.nine);
        b0 = (Button) findViewById(R.id.zero);
        bclr = (Button) findViewById(R.id.clear);
        bnext = (Button) findViewById(R.id.next);
        bbk = (Button) findViewById(R.id.backspace);
        Button	back = (Button) findViewById(R.id.back);
        Button	home = (Button) findViewById(R.id.home);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.back);
                mysong.start();
            }
        });
        back.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent i = new Intent(amount.this,option.class);
                startActivityForResult(i, 0);
                return true;
            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.home);
                mysong.start();
            }
        });
        home.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                Intent i = new Intent(amount.this,SwipeScreen.class);
                startActivityForResult(i, 0);
                return true;
            }
        });

        et1 = (EditText) findViewById(R.id.pin);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.one);
                mysong.start();
            }
        });
        b1.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                et1.setText(et1.getText().toString() + "1");
                return true;
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.two);
                mysong.start();
            }
        });
        b2.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                et1.setText(et1.getText().toString() + "2");
                return true;
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.three);
                mysong.start();
            }
        });
        b3.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                et1.setText(et1.getText().toString() + "3");

                return true;
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.four);
                mysong.start();
            }
        });
        b4.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                et1.setText(et1.getText().toString() + "4");

                return true;
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.five);
                mysong.start();
            }
        });
        b5.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                et1.setText(et1.getText().toString() + "5");

                return true;
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.six);
                mysong.start();
            }
        });
        b6.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                et1.setText(et1.getText().toString() + "6");

                return true;
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.seven);
                mysong.start();
            }
        });
        b7.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                et1.setText(et1.getText().toString() + "7");

                return true;
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.eight);
                mysong.start();
            }
        });
        b8.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                et1.setText(et1.getText().toString() + "8");

                return true;
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.nine);
                mysong.start();
            }
        });
        b9.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                et1.setText(et1.getText().toString() + "9");

                return true;
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.zero);
                mysong.start();
            }
        });
        b0.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                et1.setText(et1.getText().toString() + "0");

                return true;
            }
        });
        bbk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.bk);
                mysong.start();
            }
        });
        bbk.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                String str = et1.getText().toString();
                if (str.length() > 1) {
                    str = str.substring(0, str.length() - 1);
                    et1.setText(str);
                } else if (str.length() <= 1) {
                    et1.setText("");
                }


                return true;
            }
        });

        bclr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.longtap);
                mysong.start();
            }
        });
        bclr.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                et1.setText("");


                return true;
            }
        });
        bnext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer mysong = MediaPlayer.create(amount.this,
                        R.raw.finish);
                mysong.start();
            }
        });
        bnext.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                EditText et1 = (EditText) findViewById(R.id.pin);

                String ed_text = et1.getText().toString().trim();
                if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
                {
                    MediaPlayer mysong = MediaPlayer.create(amount.this,
                            R.raw.amt);
                    mysong.start();
                }
                else {
                    Intent i = new Intent(amount.this,completed.class);
                    startActivityForResult(i, 0);
                }
                return true;
            }
        });


    }

}






