package com.example.group.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.group.Fragment.MyFocusCorpFragment;
import com.example.group.Fragment.MyFocusPersonFragment;
import com.example.group.R;

import java.util.AbstractCollection;

/**
 * Created by hhzggg on 2015/7/11.
 */
public class LeftMyfocusActivity extends Activity implements View.OnClickListener{
    private Button btBack,btCorp,btPerson;
    private Boolean Flag_Button=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.left_myfocus);
        initView();
    }

    private void initView() {
        btBack= (Button) findViewById(R.id.left_myfocus_btback);
        btCorp= (Button) findViewById(R.id.left_myfocus_btcorp);
        btPerson= (Button) findViewById(R.id.left_myfocus_btperson);
        btBack.setOnClickListener(this);
        btCorp.setOnClickListener(this);
        btPerson.setOnClickListener(this);
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.left_myfocus_fl, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_myfocus_btback:
                finish();
                break;
            case R.id.left_myfocus_btcorp:
                if(!Flag_Button){
                    btCorp.setBackgroundResource(R.drawable.round_left_selected);
                    btCorp.setTextColor(Color.parseColor("#FF18B4EC"));
                    btPerson.setBackgroundResource(R.drawable.round_right_notselected);
                    btPerson.setTextColor(Color.parseColor("#FFFFFFFF"));
                    MyFocusCorpFragment fragment=new MyFocusCorpFragment();
                    setFragment(fragment);
                    Flag_Button=true;
                }
                break;
            case R.id.left_myfocus_btperson:
                if(Flag_Button){
                    btPerson.setBackgroundResource(R.drawable.round_right_selected);
                    btPerson.setTextColor(Color.parseColor("#FF18B4EC"));
                    btCorp.setBackgroundResource(R.drawable.round_left_notselected);
                    btCorp.setTextColor(Color.parseColor("#FFFFFFFF"));
                    MyFocusPersonFragment fragment=new MyFocusPersonFragment();
                    setFragment(fragment);
                    Flag_Button=false;

                }
                break;
            default:
                break;
        }
    }
}
