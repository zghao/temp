package com.example.group.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.group.Fragment.MyActFocusFragment;
import com.example.group.Fragment.MyActJoinFragment;
import com.example.group.R;

/**
 * Created by hhzggg on 2015/7/11.
 */
public class LeftMyactActivity extends Activity implements View.OnClickListener{

    private Button btBack,btFocus,btJoin;
    private boolean Flag_Button=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.left_myactivity);
        initView();
    }

    private void initView() {
        btBack= (Button) findViewById(R.id.left_myactivity_btback);
        btFocus= (Button) findViewById(R.id.left_myactivity_btfocus);
        btJoin= (Button) findViewById(R.id.left_myactivity_btjoin);
        btBack.setOnClickListener(this);
        btFocus.setOnClickListener(this);
        btJoin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_myactivity_btback:
                finish();
                break;
            case R.id.left_myactivity_btfocus:
                if(!Flag_Button){
                    btFocus.setBackgroundResource(R.drawable.round_left_selected);
                    btFocus.setTextColor(Color.parseColor("#FF18B4EC"));
                    btJoin.setBackgroundResource(R.drawable.round_right_notselected);
                    btJoin.setTextColor(Color.parseColor("#FFFFFFFF"));
                    MyActFocusFragment fragment=new MyActFocusFragment();
                    setFragment(fragment);
                    Flag_Button=true;
                }
                break;
            case R.id.left_myactivity_btjoin:
                if(Flag_Button){
                    btJoin.setBackgroundResource(R.drawable.round_right_selected);
                    btJoin.setTextColor(Color.parseColor("#FF18B4EC"));
                    btFocus.setBackgroundResource(R.drawable.round_left_notselected);
                    btFocus.setTextColor(Color.parseColor("#FFFFFFFF"));
                    MyActJoinFragment fragment=new MyActJoinFragment();
                    setFragment(fragment);
                    Flag_Button=false;
                }
                break;
            default:
                break;
        }
    }
    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.left_myactivity_fl, fragment);
        fragmentTransaction.commit();
    }
}
