package com.tongchengtianqi.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.tongchengtianqi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String[]title={"推荐","热点","娱乐","电影","游戏","社会","笑话","军事","科技","汽车","体育","财经"};
    private List<Fragment> list;
    private ImageView logo_button;
    private ImageView login_button;
    private EditText search_ed;
    private ImageView more_channer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.home_page,null);

        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout =  view.findViewById(R.id.home_tab);
        viewPager =  view.findViewById(R.id.home_vp);
        logo_button =  view.findViewById(R.id.logo_button);
        login_button = view.findViewById(R.id.login_button);
        search_ed = view.findViewById(R.id.search_ed);
        more_channer = view.findViewById(R.id.more_channer);
        initListener();
        initData();

        viewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initListener() {
        logo_button.setOnClickListener(this);
        login_button.setOnClickListener(this);
        search_ed.setOnClickListener(this);
        more_channer.setOnClickListener(this);
    }

    private void initData() {
        list = new ArrayList<>();
        for(int i=0;i<title.length;i++) {
            Bundle bundle= new Bundle();
            bundle.putInt("id",i);
            TitleFragment titleFragment = new TitleFragment();
            titleFragment.setArguments(bundle);
            list.add(titleFragment);
        }
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //跳转登录页面
            case R.id.login_button:
                Toast.makeText(getContext(),"跳转登录页面",Toast.LENGTH_SHORT).show();
                break;
            //Logo
            case R.id.logo_button:
                Toast.makeText(getContext(),"Logo",Toast.LENGTH_SHORT).show();
                break;
            //输入框
            case R.id.search_ed:
                Toast.makeText(getContext(),"输入框",Toast.LENGTH_SHORT).show();
                break;
            //跳转频道管理页面
            case R.id.more_channer:
                Toast.makeText(getContext(),"跳转频道管理页面",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}



