package com.example.group.View;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.group.Activity.LeftMyLaunchActivity;
import com.example.group.Activity.LeftMyactActivity;
import com.example.group.Activity.LeftMycollectionActivity;
import com.example.group.Activity.LeftMycorpActivity;
import com.example.group.Activity.LeftMyfocusActivity;
import com.example.group.Activity.LeftMyfriendsActivity;
import com.example.group.Activity.LeftSettingActivity;
import com.example.group.Activity.PersonInfoActicity;
import com.example.group.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hhzggg on 2015/5/16.
 */
public class leftmenu extends RelativeLayout implements AdapterView.OnItemClickListener{

    private RelativeLayout layout = null;
    private LinearLayout ll;
    private ImageView userimage;
    private TextView tvName,tvHot;
    private ListView lvmenu;
    private Context mContext;
    private Button btSetting;

    public leftmenu(Context context) {
        super(context);
        initView(context);
        mContext=context;
    }
    public leftmenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        mContext=context;
    }

    public leftmenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        mContext=context;
    }
    private void initView(Context context){
        if(layout==null){
            LayoutInflater layoutInflater=
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout=(RelativeLayout)layoutInflater.inflate(R.layout.main_left,this);
        }
        ll= (LinearLayout) layout.findViewById(R.id.main_left_ll);
        userimage= (ImageView) layout.findViewById(R.id.main_left_userimage);
        tvName= (TextView) layout.findViewById(R.id.main_left_tvname);
        tvHot= (TextView) layout.findViewById(R.id.main_left_tvhot);
        lvmenu= (ListView) layout.findViewById(R.id.main_left_lvmenu);
        btSetting= (Button) findViewById(R.id.main_left_setting);

        SimpleAdapter lvmenuAdapter =new SimpleAdapter(context,getlvData(),R.layout.lv_item01,
                new String[]{"image","item"},new int[]{R.id.lvitem01_icon,R.id.lvitem01_text});
        lvmenu.setAdapter(lvmenuAdapter);
        lvmenu.setOnItemClickListener(this);
        lvmenu.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });

        ll.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, PersonInfoActicity.class);
                mContext.startActivity(intent);
            }
        });

        btSetting.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, LeftSettingActivity.class);
                mContext.startActivity(intent);
            }
        });
    }
    private List<Map<String,Object>> getlvData(){
        List<Map<String,Object>> lvmenu_items=new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("image",R.drawable.main_left_lv01);
        map.put("item", "我的关注");
        lvmenu_items.add(map);

        map = new HashMap<String, Object>();
        map.put("image",R.drawable.main_left_lv02);
        map.put("item", "我的好友");
        lvmenu_items.add(map);

        map = new HashMap<String, Object>();
        map.put("image", R.drawable.main_left_lv03);
        map.put("item", "我的活动");
        lvmenu_items.add(map);

        map = new HashMap<String, Object>();
        map.put("image",R.drawable.main_left_lv04);
        map.put("item", "社团管理");
        lvmenu_items.add(map);

        map = new HashMap<String, Object>();
        map.put("image",R.drawable.main_left_lv05);
        map.put("item", "我的发布");
        lvmenu_items.add(map);

        map = new HashMap<String, Object>();
        map.put("image",R.drawable.main_left_lv06);
        map.put("item", "我的收藏");
        lvmenu_items.add(map);

        return lvmenu_items;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Intent intent1=new Intent(mContext, LeftMyfocusActivity.class);
                mContext.startActivity(intent1);
                break;
            case 1:
                Intent intent2=new Intent(mContext, LeftMyfriendsActivity.class);
                mContext.startActivity(intent2);
                break;
            case 2:
                Intent intent3=new Intent(mContext, LeftMyactActivity.class);
                mContext.startActivity(intent3);
                break;
            case 3:
                Intent intent4=new Intent(mContext, LeftMycorpActivity.class);
                mContext.startActivity(intent4);
                break;
            case 4:
                Intent intent5=new Intent(mContext, LeftMyLaunchActivity.class);
                mContext.startActivity(intent5);
                break;
            case 5:
                Intent intent6=new Intent(mContext, LeftMycollectionActivity.class);
                mContext.startActivity(intent6);
                break;
            default:
                break;
        }

    }
}
