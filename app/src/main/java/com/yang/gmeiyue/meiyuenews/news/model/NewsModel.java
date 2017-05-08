package com.yang.gmeiyue.meiyuenews.news.model;

/**
 * Description:
 * Created by Administrator on 2017/5/8.
 */

public interface NewsModel {
    void  loadNews(String url,int type,NewsModelImpl.OnLoadNewsListListener listener);

    void  loadNewsDetails(String docid, NewsModelImpl.OnLoadNewsDetailListener listener);
}
