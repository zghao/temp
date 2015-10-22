package com.example.group.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.group.Fragment.CorpshowFragment;
import com.example.group.Fragment.NestFragment;
import com.example.group.Fragment.PersonshowFragment;
import com.example.group.Fragment.SquareFragment;
import com.example.group.R;
import com.nineoldandroids.view.ViewHelper;


public class MainActivity extends Activity implements View.OnClickListener {
    private int CURRENT_BUTTON = 0;
    private DrawerLayout dl;
    private Button btSquare, btCorpshow, btPershow, btNest;
    private ImageButton btLaunch;
    private SquareFragment squareFragment;
    private CorpshowFragment corpshowFragment;
    private PersonshowFragment personshowFragment;
    private NestFragment nestFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        fragmentManager = getFragmentManager();
        initView();
    }

    private void initView() {
        dl = (DrawerLayout) findViewById(R.id.main_drawer);
        dl.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View mContent = dl.getChildAt(0);
                View LeftMenu = drawerView;
                float scale = 1 - slideOffset;
                float rightScale = 0.8f + 0.2f * scale;
                float leftScale = 1 - 0.3f * scale;
                ViewHelper.setScaleX(LeftMenu, leftScale);
                ViewHelper.setScaleY(LeftMenu, leftScale);
                ViewHelper.setPivotX(mContent, 0);
                ViewHelper.setPivotY(mContent, mContent.getMeasuredHeight() / 2);
                mContent.invalidate();
                ViewHelper.setScaleX(mContent, rightScale);
                ViewHelper.setScaleY(mContent, rightScale);
                ViewHelper.setTranslationX(mContent, LeftMenu.getMeasuredWidth() * slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        btSquare = (Button) findViewById(R.id.main_btsquare);

        btCorpshow = (Button) findViewById(R.id.main_btcorpshow);

        btPershow = (Button) findViewById(R.id.main_btpershow);

        btNest = (Button) findViewById(R.id.main_btnest);

        btLaunch = (ImageButton) findViewById(R.id.main_btlaunch);

        btSquare.setOnClickListener(this);
        btCorpshow.setOnClickListener(this);
        btPershow.setOnClickListener(this);
        btNest.setOnClickListener(this);
        btLaunch.setOnClickListener(this);
        SwitchFragment(CURRENT_BUTTON,1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btsquare:
                if (CURRENT_BUTTON != 1) {
                    Drawable d1 = getResources().getDrawable(R.drawable.square);
                    d1.setBounds(0, 0, d1.getMinimumWidth(), d1.getMinimumHeight());
                    btSquare.setCompoundDrawables(null, d1, null, null);
                    btSquare.setTextColor(Color.parseColor("#FF18B4EC"));
                    setButtonIcon(CURRENT_BUTTON);
                    SwitchFragment(CURRENT_BUTTON, 1);
                    CURRENT_BUTTON = 1;
                }
                break;
            case R.id.main_btcorpshow:
                if (CURRENT_BUTTON != 2) {
                    Drawable d2 = getResources().getDrawable(R.drawable.show);
                    d2.setBounds(0, 0, d2.getMinimumWidth(), d2.getMinimumHeight());
                    btCorpshow.setCompoundDrawables(null, d2, null, null);
                    btCorpshow.setTextColor(Color.parseColor("#FF18B4EC"));
                    setButtonIcon(CURRENT_BUTTON);
                    SwitchFragment(CURRENT_BUTTON, 2);
                    CURRENT_BUTTON = 2;
                }
                break;
            case R.id.main_btpershow:
                if (CURRENT_BUTTON != 3) {
                    Drawable d3 = getResources().getDrawable(R.drawable.person);
                    d3.setBounds(0, 0, d3.getMinimumWidth(), d3.getMinimumHeight());
                    btPershow.setCompoundDrawables(null, d3, null, null);
                    btPershow.setTextColor(Color.parseColor("#FF18B4EC"));
                    setButtonIcon(CURRENT_BUTTON);
                    SwitchFragment(CURRENT_BUTTON, 3);
                    CURRENT_BUTTON = 3;
                }
                break;
            case R.id.main_btnest:
                if (CURRENT_BUTTON != 4) {
                    Drawable d4 = getResources().getDrawable(R.drawable.nest);
                    d4.setBounds(0, 0, d4.getMinimumWidth(), d4.getMinimumHeight());
                    btNest.setCompoundDrawables(null, d4, null, null);
                    btNest.setTextColor(Color.parseColor("#FF18B4EC"));
                    setButtonIcon(CURRENT_BUTTON);
                    SwitchFragment(CURRENT_BUTTON,4);
                    CURRENT_BUTTON = 4;
                }
                break;
            case R.id.main_btlaunch:
                Intent intent = new Intent(MainActivity.this, LaunchActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void SwitchFragment(int LastFragment, int CURRENT_FRAGMENT) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (CURRENT_FRAGMENT) {
            case 1:
                if (squareFragment != null) {
                    hideFragment(fragmentTransaction,LastFragment);
                    fragmentTransaction.show(squareFragment);
                } else {
                    squareFragment = new SquareFragment();
                    hideFragment(fragmentTransaction,LastFragment);
                    fragmentTransaction.add(R.id.main_fl, squareFragment);
                }
                break;
            case 2:
                if (corpshowFragment != null) {
                    hideFragment(fragmentTransaction,LastFragment);
                    fragmentTransaction.show(corpshowFragment);
                } else {
                    corpshowFragment = new CorpshowFragment();
                    hideFragment(fragmentTransaction,LastFragment);
                    fragmentTransaction.add(R.id.main_fl, corpshowFragment);
                }
                break;
            case 3:
                if (personshowFragment != null) {
                    hideFragment(fragmentTransaction,LastFragment);
                    fragmentTransaction.show(personshowFragment);
                } else {
                    personshowFragment = new PersonshowFragment();
                    hideFragment(fragmentTransaction,LastFragment);
                    fragmentTransaction.add(R.id.main_fl, personshowFragment);
                }
                break;
            case 4:
                if (nestFragment != null) {
                    hideFragment(fragmentTransaction,LastFragment);
                    fragmentTransaction.show(nestFragment);
                } else {
                    nestFragment = new NestFragment();
                    hideFragment(fragmentTransaction,LastFragment);
                    fragmentTransaction.add(R.id.main_fl, nestFragment);
                }
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction ft,int LastFragment) {
        switch (LastFragment){
            case 1:
                ft.hide(squareFragment);
                break;
            case 2:
                ft.hide(corpshowFragment);
                break;
            case 3:
                ft.hide(personshowFragment);
                break;
            case 4:
                ft.hide(nestFragment);
                break;
            default:
                break;
        }
    }

    private void setButtonIcon(int buttonId) {
        switch (buttonId) {
            case 1:
                Drawable d1 = getResources().getDrawable(R.drawable.square2);
                d1.setBounds(0, 0, d1.getMinimumWidth(), d1.getMinimumHeight());
                btSquare.setCompoundDrawables(null, d1, null, null);
                btSquare.setTextColor(Color.parseColor("#FFABABAB"));
                break;
            case 2:
                Drawable d2 = getResources().getDrawable(R.drawable.show2);
                d2.setBounds(0, 0, d2.getMinimumWidth(), d2.getMinimumHeight());
                btCorpshow.setCompoundDrawables(null, d2, null, null);
                btCorpshow.setTextColor(Color.parseColor("#FFABABAB"));
                break;
            case 3:
                Drawable d3 = getResources().getDrawable(R.drawable.person2);
                d3.setBounds(0, 0, d3.getMinimumWidth(), d3.getMinimumHeight());
                btPershow.setCompoundDrawables(null, d3, null, null);
                btPershow.setTextColor(Color.parseColor("#FFABABAB"));
                break;
            case 4:
                Drawable d4 = getResources().getDrawable(R.drawable.nest2);
                d4.setBounds(0, 0, d4.getMinimumWidth(), d4.getMinimumHeight());
                btNest.setCompoundDrawables(null, d4, null, null);
                btNest.setTextColor(Color.parseColor("#FFABABAB"));
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (dl.isDrawerOpen(Gravity.LEFT)) {
            dl.closeDrawers();
        } else
            super.onBackPressed();
    }

    public void OpenDrawer() {
        if (!dl.isDrawerOpen(Gravity.LEFT)) {
            dl.openDrawer(Gravity.LEFT);
        }
    }
}
