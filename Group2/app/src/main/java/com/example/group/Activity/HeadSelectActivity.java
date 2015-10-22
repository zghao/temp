package com.example.group.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.group.R;
/**
 * Created by hhzggg on 2015/7/8.
 */
public class HeadSelectActivity extends Activity implements View.OnClickListener{
    private Button btphoto,btpicture,btcancel;
    private LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_select);
        ll= (LinearLayout) findViewById(R.id.head_select_ll);
        btphoto= (Button) findViewById(R.id.head_select_photo);
        btpicture= (Button) findViewById(R.id.head_select_picture);
        btcancel= (Button) findViewById(R.id.head_select_cancel);
        btphoto.setOnClickListener(this);
        btpicture.setOnClickListener(this);
        btcancel.setOnClickListener(this);
        ll.startAnimation(AnimationUtils.loadAnimation(this,R.anim.down_appear));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head_select_photo:

                break;
            case R.id.head_select_picture:
                break;
            case R.id.head_select_cancel:
                ll.startAnimation(AnimationUtils.loadAnimation(this,R.anim.down_disappear));
                finish();
                break;
        }
    }
}
