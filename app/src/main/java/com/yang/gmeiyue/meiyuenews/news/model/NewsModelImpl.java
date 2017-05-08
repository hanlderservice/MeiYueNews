package com.yang.gmeiyue.meiyuenews.news.model;

import com.yang.gmeiyue.meiyuenews.bean.NewsBean;
import com.yang.gmeiyue.meiyuenews.bean.NewsDetailBean;
import com.yang.gmeiyue.meiyuenews.utils.OkHttpUtils;

import java.util.List;

/**
 * Description:
 * Created by Administrator on 2017/5/8.
 */

public class NewsModelImpl implements NewsModel {

    private OkHttpUtils.ResultCallback loadnewsCallback;

    @Override
    public void loadNews(String url, int type, NewsModelImpl.OnLoadNewsListListener listener) {

        loadnewsCallback = new OkHttpUtils.ResultCallback() {
            @Override
            public void onSuccess(Object response) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        };
        OkHttpUtils.get(url, loadnewsCallback);
    }

    @Override
    public void loadNewsDetails(String docid, NewsModelImpl.OnLoadNewsDetailListener listener) {

    }

    public interface OnLoadNewsListListener {
        void onSeccess(List<NewsBean> list);

        void onFailure(String msg, Exception e);
    }

    public interface OnLoadNewsDetailListener {
        void onSeccess(NewsDetailBean newsDetailBean);

        void onFailure(String msg, Exception e);
    }

}
