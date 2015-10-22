package com.example.group.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.group.Activity.MainActivity;
import com.example.group.Activity.PersonInfoActicity;
import com.example.group.Activity.corpdetailActivity;
import com.example.group.R;

/**
 * Created by hhzggg on 2015/7/14.
 */
public class PersonshowNewFragment extends Fragment{
    private ImageView iv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.image,container,false);
        iv= (ImageView) view.findViewById(R.id.iv);
        iv.setImageResource(R.drawable.m32);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonInfoActicity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }
}
