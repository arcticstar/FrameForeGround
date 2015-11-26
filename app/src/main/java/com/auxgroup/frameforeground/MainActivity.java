package com.auxgroup.frameforeground;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Switch;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl = (FrameLayout) findViewById(R.id.myfl);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 170);

    }

    Handler handler = new Handler() {
        int i = 0;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x123) {
                i++;
                move(i % 8);
            }
        }
    };

    private void move(int i) {
        Drawable a = null;
        Drawable b = null;
        Drawable c = null;
        Drawable d = null;
        Drawable e = null;
        Drawable f = null;
        Drawable g = null;
        Drawable h = null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            a = getResources().getDrawable(R.drawable.walk1, null);
            b = getResources().getDrawable(R.drawable.walk2, null);
            c = getResources().getDrawable(R.drawable.walk3, null);
            d = getResources().getDrawable(R.drawable.walk4, null);
            e = getResources().getDrawable(R.drawable.walk5, null);
            f = getResources().getDrawable(R.drawable.walk6, null);
            g = getResources().getDrawable(R.drawable.walk7, null);
            h = getResources().getDrawable(R.drawable.walk8, null);


            switch (i) {
                case 0:
                    fl.setForeground(a);
                    break;
                case 1:
                    fl.setForeground(b);
                    break;
                case 2:
                    fl.setForeground(c);
                    break;
                case 3:
                    fl.setForeground(d);
                    break;
                case 4:
                    fl.setForeground(e);
                    break;
                case 5:
                    fl.setForeground(f);
                    break;
                case 6:
                    fl.setForeground(g);
                    break;
                case 7:
                    fl.setForeground(h);
                    break;
            }
        }
    }
    }
