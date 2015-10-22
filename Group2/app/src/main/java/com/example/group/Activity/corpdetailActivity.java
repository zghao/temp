package com.example.group.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.group.R;

/**
 * Created by hhzggg on 2015/7/14.
 */
public class corpdetailActivity extends Activity implements View.OnClickListener{
    private LinearLayout ll;
    private Button btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corpmanage_detail);
        initView();
    }

    private void initView() {
        ll= (LinearLayout) findViewById(R.id.corpmanage_detail_llbt);
        ll.setVisibility(View.GONE);
        btBack= (Button) findViewById(R.id.corpmanage_detail_back);
        btBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.corpmanage_detail_back:
                finish();
                break;

        }
    }
}
