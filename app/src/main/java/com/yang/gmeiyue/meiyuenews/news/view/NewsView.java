package com.yang.gmeiyue.meiyuenews.news.view;

import com.yang.gmeiyue.meiyuenews.bean.NewsBean;

import java.util.List;

/**
 * Description:
 * Created by Administrator on 2017/5/8.
 */

public interface NewsView {
    void  showProgress();
    void  addNews(List<NewsBean> newsList);
    void  hideProgress();
    void  showLoadFailMsg();
}
