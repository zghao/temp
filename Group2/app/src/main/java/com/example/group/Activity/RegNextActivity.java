package com.example.group.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.group.R;

/**
 * Created by hhzggg on 2015/7/8.
 */
public class RegNextActivity extends Activity{
    ImageView head;
    EditText etName,etCollege,etCampus,etAcademy,etGrade,etMajor,etStuID;
    Button btComplete;
    RadioGroup sex;
    RadioButton male,female,sexnone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_reg_next);
        initView();
        initEvent();
    }
    private void initView() {
        head= (ImageView) findViewById(R.id.user_reg_next_head);
        etName= (EditText) findViewById(R.id.user_reg_name);
        etCollege= (EditText) findViewById(R.id.user_reg_college);
        etCampus= (EditText) findViewById(R.id.user_reg_campus);
        etAcademy= (EditText) findViewById(R.id.user_reg_academy);
        etGrade= (EditText) findViewById(R.id.user_reg_grade);
        etMajor= (EditText) findViewById(R.id.user_reg_major);
        etStuID= (EditText) findViewById(R.id.user_reg_stuID);
        btComplete= (Button) findViewById(R.id.user_reg_btcomplete);
        male= (RadioButton) findViewById(R.id.user_reg_male);
        female= (RadioButton) findViewById(R.id.user_reg_female);
        sexnone= (RadioButton) findViewById(R.id.user_reg_sexnone);
        sex= (RadioGroup) findViewById(R.id.user_reg_sex);

    }
    private void initEvent() {
        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.user_reg_male:
                        break;
                    case R.id.user_reg_female:
                        break;
                    case R.id.user_reg_sexnone:
                        break;
                    default:
                        break;
                }
            }
        });
    }

}
