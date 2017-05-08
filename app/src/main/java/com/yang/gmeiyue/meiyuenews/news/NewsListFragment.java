package com.yang.gmeiyue.meiyuenews.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yang.gmeiyue.meiyuenews.R;
import com.yang.gmeiyue.meiyuenews.adapter.NewsAdapter;

/**
 * Description:
 * Created by Administrator on 2017/5/8.
 */

public class NewsListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRecycleView;
    private SwipeRefreshLayout mSwipeRefreshWidget;
    private LinearLayoutManager mLayoutManager;
    private NewsAdapter mAdapter;


    public static NewsListFragment newInstance(int type) {
        Bundle bundle = new Bundle();
        NewsListFragment fragment = new NewsListFragment();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newslist, null);
        initView(view);
        return view;

    }


    private void initView(View view) {
        mRecycleView = (RecyclerView) view.findViewById(R.id.recycle_view);
        mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setColorSchemeResources(R.color.primary,
                R.color.primary_dark, R.color.primary_light,
                R.color.accent);//设置下拉圈的颜色
        mSwipeRefreshWidget.setOnRefreshListener(this);//设置下拉刷新
        //设置RecycleView
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
        //设置adapter
        mAdapter = new NewsAdapter(getActivity().getApplicationContext());
        mRecycleView.setAdapter(mAdapter);

        mRecycleView.addOnScrollListener(mOnScrollListener);
        //TODO 设置mRecycleView点击事件

        onRefresh();
    }

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        private int lastVisibleItem;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
        }
    };

    @Override
    public void onRefresh() {

    }
}
