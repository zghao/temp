package com.example.group.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.group.R;

/**
 * Created by hhzggg on 2015/7/14.
 */
public class LaunchActivity extends Activity implements View.OnClickListener{
    private Button btnew,btact,btcancel;
    private LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);
        ll= (LinearLayout) findViewById(R.id.launch_ll);
        btnew= (Button) findViewById(R.id.launch_new);
        btact= (Button) findViewById(R.id.launch_act);
        btcancel= (Button) findViewById(R.id.launch_cancel);
        btnew.setOnClickListener(this);
        btact.setOnClickListener(this);
        btcancel.setOnClickListener(this);
        ll.startAnimation(AnimationUtils.loadAnimation(this, R.anim.down_appear));
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.launch_new:

                break;
            case R.id.launch_act:
                break;
            case R.id.launch_cancel:
                ll.startAnimation(AnimationUtils.loadAnimation(this,R.anim.down_disappear));
                finish();
                break;
        }
    }
}
