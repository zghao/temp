package com.example.group.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.group.R;


public class SplashActivity extends Activity implements View.OnClickListener {
    private ImageButton btlogin, btreg;
    private LinearLayout ll;
    public int WAIT_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        btlogin = (ImageButton) findViewById(R.id.splash_btlogin);
        btreg = (ImageButton) findViewById(R.id.splash_btreg);
        ll= (LinearLayout) findViewById(R.id.splash_ll);
        btlogin.setOnClickListener(this);
        btreg.setOnClickListener(this);
        AlphaAnimation alphaAnimation =new AlphaAnimation(0.01f,1.0f);
        TranslateAnimation translateAnimation=new TranslateAnimation(0,0,300,0);
        AnimationSet animation=new AnimationSet(true);
        animation.addAnimation(alphaAnimation);
        animation.addAnimation(translateAnimation);
        animation.setDuration(800);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        ll.setAnimation(animation);
        animation.startNow();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.splash_btlogin:
                Intent intent01=new Intent(SplashActivity.this,loginActicity.class);
                startActivity(intent01);
                finish();
                break;
            case R.id.splash_btreg:
                Intent intent02=new Intent(SplashActivity.this,RegisterActivity.class);
                startActivity(intent02);
                break;
        }
    }
}
