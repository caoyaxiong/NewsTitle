package com.tongchengtianqi.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tongchengtianqi.R;
import com.tongchengtianqi.fragment.AttentionFragment;
import com.tongchengtianqi.fragment.HomeFragment;
import com.tongchengtianqi.fragment.MineFragment;
import com.tongchengtianqi.fragment.VedioFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private long clickTime = 0;
    private RadioButton home;
    private RadioButton vedio;
    private RadioButton attention;
    private RadioButton mine;
    private HomeFragment homeFragment;
    private VedioFragment vedioFragment;
    private AttentionFragment attentionFragment;
    private MineFragment mineFragment;
    private Fragment fragment;
    private FrameLayout fl;
    private RadioGroup rg;
    private List<RadioButton> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //默认选中首页
        home.setChecked(true);
        radioButtonColor();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl, homeFragment).show(homeFragment)
                .add(R.id.fl, vedioFragment).hide(vedioFragment)
                .add(R.id.fl, attentionFragment).hide(attentionFragment)
                .add(R.id.fl, mineFragment).hide(mineFragment)
                .commit();
    }
    private void radioButtonColor() {
        for (RadioButton rb : list) {
            if (rb.isChecked()) {
                rb.setChecked(true);
            } else {
                rb.setChecked(false);
            }
        }
    }
    private void initView() {
        fl = (FrameLayout) findViewById(R.id.fl);
        rg = (RadioGroup) findViewById(R.id.rg);
        home = (RadioButton) findViewById(R.id.home_page);
        vedio = (RadioButton) findViewById(R.id.vedio_page);
        attention = (RadioButton) findViewById(R.id.attention_page);
        mine = (RadioButton) findViewById(R.id.mine_page);
        rg.setOnCheckedChangeListener(this);
        list = new ArrayList<>();
        list.add(home);
        list.add(vedio);
        list.add(attention);
        list.add(mine);
        homeFragment = new HomeFragment();
        vedioFragment = new VedioFragment();
        attentionFragment = new AttentionFragment();
        mineFragment = new MineFragment();
        fragment = new Fragment();
    }




    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i){
            case R.id.home_page:
                getSupportFragmentManager().beginTransaction().show(homeFragment)
                        .hide(fragment).commit();
                fragment = homeFragment;
                radioButtonColor();
                break;
            case R.id.vedio_page:
                getSupportFragmentManager().beginTransaction().show(vedioFragment)
                        .hide(fragment).commit();
                fragment = vedioFragment;
                radioButtonColor();
                break;
            case R.id.attention_page:
                getSupportFragmentManager().beginTransaction().show(attentionFragment)
                        .hide(fragment).commit();
                fragment = attentionFragment;
                radioButtonColor();
                break;
            case R.id.mine_page:
                getSupportFragmentManager().beginTransaction().show(mineFragment)
                        .hide(fragment).commit();
                fragment = mineFragment;
                radioButtonColor();
                break;
        }
    }
//    //点击返回键时调用
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            exit();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    //退出应用程序
//    private void exit() {
//        if ((System.currentTimeMillis() - clickTime) > 2000) {
//            Toast.makeText(getApplicationContext(), "再次点击退出", Toast.LENGTH_SHORT).show();
//            clickTime = System.currentTimeMillis();
//        } else {
//            this.finish();
//            System.exit(0);
//        }
//
//    }
}
