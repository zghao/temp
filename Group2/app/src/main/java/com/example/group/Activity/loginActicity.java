package com.example.group.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.group.R;

/**
 * Created by hhzggg on 2015/5/9.
 */
public class loginActicity extends Activity implements View.OnClickListener{
    EditText user_name;
    EditText user_pwd;
    CheckBox save_pwd;
    Button user_login,user_reg,user_Forgetpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);
        user_name= (EditText) findViewById(R.id.user_login_name);
        user_pwd= (EditText) findViewById(R.id.user_login_password);
        save_pwd= (CheckBox) findViewById(R.id.user_login_savepwd);
        user_login= (Button) findViewById(R.id.user_login_btLogin);
        user_reg= (Button) findViewById(R.id.user_login_btRegister);
        user_Forgetpwd= (Button) findViewById(R.id.user_login_btForgetpwd);
        user_login.setOnClickListener(this);
        user_reg.setOnClickListener(this);
        user_Forgetpwd.setOnClickListener(this);
    }
    private boolean userCheck(){
        boolean flag=true;

        return flag;
    }

    public void setUsername(String username){
        user_name.setText(username);

    }

    public String getUsername(){
        return String.valueOf(user_name.getText());
    }

    public void setPassword(String password){
        user_pwd.setText(password);
    }

    private String getPassword(){
        return String.valueOf(user_pwd.getText());
    }

    public boolean saveChecked() {
        return save_pwd.isChecked();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.user_login_btLogin:
                if(userCheck()){
                    Intent intent01=new Intent(loginActicity.this,MainActivity.class);
                    startActivity(intent01);
                    finish();
                }
                break;
            case R.id.user_login_btRegister:
                Intent intent02=new Intent(loginActicity.this,RegisterActivity.class);
                startActivityForResult(intent02,1);
                break;
        }
    }

}
