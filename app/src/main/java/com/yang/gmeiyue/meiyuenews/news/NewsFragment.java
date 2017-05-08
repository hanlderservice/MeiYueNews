package com.yang.gmeiyue.meiyuenews.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yang.gmeiyue.meiyuenews.R;
import com.yang.gmeiyue.meiyuenews.adapter.MyPagerAdapter;

/**
 * Description:
 * Created by Administrator on 2017/5/8.
 */

public class NewsFragment extends Fragment {

    public static final int NEWS_TYPE_TOP = 0;
    public static final int NEWS_TYPE_NBA = 1;
    public static final int NEWS_TYPE_CARS = 2;
    public static final int NEWS_TYPE_JOKES = 3;
    private TabLayout mTabLayout;
    private ViewPager mViewpager;
    private ViewPager mUpViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, null);


        initView(view);
        return view;

    }

    private void initView(View view) {
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewpager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewpager.setOffscreenPageLimit(3);
        setupViewPager(mViewpager);
        //上面标题添加标题
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.top));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.nba));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.cars));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.jokes));
        mTabLayout.setupWithViewPager(mViewpager);
    }

    public void setupViewPager(ViewPager viewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_TOP), getString(R.string.top));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_NBA), getString(R.string.nba));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_CARS), getString(R.string.cars));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_JOKES), getString(R.string.jokes));
        viewPager.setAdapter(adapter);
    }
}
