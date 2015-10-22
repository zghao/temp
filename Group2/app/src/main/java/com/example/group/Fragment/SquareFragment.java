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

public class SquareFragment extends Fragment implements View.OnClickListener {
    private Button btOpen, btNew, btHot;
    private View view;
    private boolean flag_button = false;
    private SquareNewFragment squareNewFragment;
    private SquareHotFragment squareHotFragment;
    private FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.square, container, false);
        initView();
        return view;
    }

    private void initView() {
        btOpen = (Button) view.findViewById(R.id.square_btopen);
        btNew = (Button) view.findViewById(R.id.square_btnew);
        btHot = (Button) view.findViewById(R.id.square_bthot);
        btOpen.setOnClickListener(this);
        btNew.setOnClickListener(this);
        btHot.setOnClickListener(this);
        fragmentManager=getFragmentManager();
        SwitchFragment(flag_button);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.square_btopen:
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.OpenDrawer();
                break;
            case R.id.square_bthot:
                if (!flag_button) {
                    btHot.setBackgroundResource(R.drawable.round_left_selected);
                    btHot.setTextColor(Color.parseColor("#FF18B4EC"));
                    btNew.setBackgroundResource(R.drawable.round_right_notselected);
                    btNew.setTextColor(Color.parseColor("#FFFFFFFF"));
                    SwitchFragment(flag_button);
                    flag_button = true;
                }
                break;
            case R.id.square_btnew:
                if (flag_button) {
                    btNew.setBackgroundResource(R.drawable.round_right_selected);
                    btNew.setTextColor(Color.parseColor("#FF18B4EC"));
                    btHot.setBackgroundResource(R.drawable.round_left_notselected);
                    btHot.setTextColor(Color.parseColor("#FFFFFFFF"));
                    SquareNewFragment fragment = new SquareNewFragment();
                    SwitchFragment(flag_button);
                    flag_button = false;
                }
                break;
            default:
                break;
        }
    }

    private void SwitchFragment(boolean flag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(!flag){//切换到hot
            if (squareHotFragment!=null)
                fragmentTransaction.hide(squareNewFragment).show(squareHotFragment);
            else
                fragmentTransaction.hide(squareNewFragment).add(R.id.square_fl,squareHotFragment);
        }else{//切换到new
            if (squareNewFragment!=null)
                fragmentTransaction.hide(squareHotFragment).show(squareNewFragment);
            else
                fragmentTransaction.hide(squareHotFragment).add(R.id.square_fl,squareNewFragment);
        }
        fragmentTransaction.commit();
    }
}
