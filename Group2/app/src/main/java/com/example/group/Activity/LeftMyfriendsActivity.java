package com.example.group.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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
public class LeftMyfriendsActivity extends Activity {
    private Button btBack;
    private ListView lv;
    private List<Map<String,Object>> MemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.left_myfriends);
        initView();
    }

    private void initView() {
        btBack= (Button) findViewById(R.id.left_myfriends_back);
        lv= (ListView) findViewById(R.id.left_myfriends_lv);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SimpleAdapter adapter=new SimpleAdapter(this,getData(),R.layout.lv_item05,
                new String[]{"head","nickname"},new int[]{R.id.lvitem05_icon,R.id.lvitem05_text});
        lv.setAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {
        MemList=new ArrayList<Map<String,Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("head",R.drawable.image_hint);
        map.put("nickname", "小红");
        MemList.add(map);

        map.put("head",R.drawable.image_hint);
        map.put("nickname", "小丽");
        MemList.add(map);

        map.put("head",R.drawable.image_hint);
        map.put("nickname", "小花");
        MemList.add(map);

        return MemList;
    }

}
