package com.example.group.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.group.R;


public class RegisterActivity extends Activity {
    ImageView head;
    EditText nickname,phone,pwd,repwd;
    Button btnext;
    Boolean flag1,flag2,flag3,flag4=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register);
        head= (ImageView) findViewById(R.id.user_reg_head);
        nickname= (EditText) findViewById(R.id.user_reg_nickname);
        phone= (EditText) findViewById(R.id.user_reg_phone);
        pwd= (EditText) findViewById(R.id.user_reg_pwd);
        repwd= (EditText) findViewById(R.id.user_reg_repwd);
        btnext= (Button) findViewById(R.id.user_reg_next);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegisterActivity.this,RegNextActivity.class);
                startActivity(intent);
            }
        });
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegisterActivity.this,HeadSelectActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }
    private void checkNickname(){
        String name=nickname.getText().toString();
    }
    private void checkPhone(){
        String p=phone.getText().toString();
    }
    private void checkPwd(){
        String password=pwd.getText().toString();
    }
    private void checkRepwd(){
        String rep=repwd.getText().toString();
    }
}
