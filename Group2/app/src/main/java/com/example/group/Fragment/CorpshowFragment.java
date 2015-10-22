package com.example.group.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.group.Activity.MainActivity;
import com.example.group.R;


public class CorpshowFragment extends Fragment implements View.OnClickListener{
    private Button btOpen,btNew,btHot;
    private View view;
    private boolean flag_button=true;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.corp_show,container,false);
        initView();
        return view;
    }

    private void initView() {
        btOpen= (Button) view.findViewById(R.id.corp_show_btopen);
        btNew= (Button) view.findViewById(R.id.corp_show_btnew);
        btHot= (Button) view.findViewById(R.id.corp_show_bthot);
        btOpen.setOnClickListener(this);
        btNew.setOnClickListener(this);
        btHot.setOnClickListener(this);
        CorpshowHotFragment fragment=new CorpshowHotFragment();
        setFragment(fragment);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.corp_show_btopen:
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.OpenDrawer();
                break;
            case R.id.corp_show_bthot:
                if(!flag_button){
                    btHot.setBackgroundResource(R.drawable.round_left_selected);
                    btHot.setTextColor(Color.parseColor("#FF18B4EC"));
                    btNew.setBackgroundResource(R.drawable.round_right_notselected);
                    btNew.setTextColor(Color.parseColor("#FFFFFFFF"));
                    CorpshowHotFragment fragment=new CorpshowHotFragment();
                    setFragment(fragment);
                    flag_button=true;
                }
                break;
            case R.id.corp_show_btnew:
                if(flag_button){
                    btNew.setBackgroundResource(R.drawable.round_right_selected);
                    btNew.setTextColor(Color.parseColor("#FF18B4EC"));
                    btHot.setBackgroundResource(R.drawable.round_left_notselected);
                    btHot.setTextColor(Color.parseColor("#FFFFFFFF"));
                    CorpshowNewFragment fragment=new CorpshowNewFragment();
                    setFragment(fragment);
                    flag_button=false;
                }
                break;
            default:
                break;
        }
    }
    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.corp_show_fl, fragment);
        fragmentTransaction.commit();
    }
}
