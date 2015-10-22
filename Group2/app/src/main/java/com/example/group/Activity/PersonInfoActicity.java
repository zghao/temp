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
public class PersonInfoActicity extends Activity implements View.OnClickListener {
    private Button btedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_info);
        initView();
    }

    private void initView() {
        btedit = (Button) findViewById(R.id.person_info_btedit);
        btedit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.person_info_btedit:
                Intent intent = new Intent(PersonInfoActicity.this, PersonInfoEditActivity.class);
                startActivity(intent);
                break;
        }
    }
}
