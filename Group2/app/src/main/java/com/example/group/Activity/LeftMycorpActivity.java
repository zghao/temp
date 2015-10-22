package com.example.group.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.group.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hhzggg on 2015/7/11.
 */
public class LeftMycorpActivity extends Activity implements AdapterView.OnItemClickListener{
    private Button btNew,btBack;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.left_corpmanage);
        initView();
        initEvent();
    }

    private void initEvent() {
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LeftMycorpActivity.this,corpbuildActivity.class);
                startActivity(intent);
            }
        });
        lv.setOnItemClickListener(this);
    }

    private void initView() {
        btBack= (Button) findViewById(R.id.left_corpmanage_btback);
        btNew= (Button) findViewById(R.id.left_corpmanage_btNew);
        lv= (ListView) findViewById(R.id.left_corpmanage_lv);
        SimpleAdapter adapter =new SimpleAdapter(this,getItem(),R.layout.lv_item04,
                new String[]{"image","item"},new int[]{R.id.lvitem04_icon,R.id.lvitem04_text});
        lv.setAdapter(adapter);
    }

    private List<Map<String, Object>> getItem() {
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("image",R.drawable.image_hint);
        map.put("item", "文学社");
        list.add(map);
        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(LeftMycorpActivity.this,corpmanageActivity.class);
        startActivity(intent);
    }
}
