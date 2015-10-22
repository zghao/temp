package com.example.group.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.group.R;
/**
 * Created by hhzggg on 2015/7/13.
 */
public class corpmanageActivity extends Activity implements View.OnClickListener{
    private Button btNotice,btMember,btEdit,btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corpmanage_detail);
        initView();
    }

    private void initView() {
        btNotice= (Button) findViewById(R.id.corpmanage_detail_btNotice);
        btNotice.setOnClickListener(this);
        btMember= (Button) findViewById(R.id.corpmanage_detail_btMem);
        btMember.setOnClickListener(this);
        btEdit= (Button) findViewById(R.id.corpmanage_detail_btRevise);
        btEdit.setOnClickListener(this);
        btBack= (Button) findViewById(R.id.corpmanage_detail_back);
        btBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.corpmanage_detail_btNotice:
                Intent intent=new Intent(corpmanageActivity.this,NotificationActivity.class);
                startActivity(intent);
                break;
            case R.id.corpmanage_detail_btMem:
                Intent intent1=new Intent(corpmanageActivity.this,MemberActivity.class);
                startActivity(intent1);
                break;
            case R.id.corpmanage_detail_btRevise:
                Intent intent2=new Intent(corpmanageActivity.this,corpeditActivity.class);
                startActivity(intent2);
                break;
            case R.id.corpmanage_detail_back:
                finish();
                break;
            default:
                break;
        }
    }
}
