package com.example.group.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.group.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hhzggg on 2015/7/11.
 */
public class LeftSettingActivity extends Activity{
    Button btBack;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.left_setting);
        initView();
    }

    private void initView() {
        String[] arr= new String[]{"账号管理", "提醒与通知", "意见反馈", "新版本检查", "关于我们", "退出"};
        btBack= (Button) findViewById(R.id.left_setting_back);
        lv= (ListView) findViewById(R.id.left_setting_lv);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.lv_item03,R.id.lvitem03_text,arr);
        lv.setAdapter(arrayAdapter);
    }
}
