package com.yang.gmeiyue.meiyuenews.main.presenter;

import com.yang.gmeiyue.meiyuenews.R;
import com.yang.gmeiyue.meiyuenews.main.view.MainView;

/**
 * Description:
 * Created by Administrator on 2017/5/8.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void switchNavigation(int id) {
        switch (id) {
            case R.id.navigation_item_news:
                mainView.switch2News();
                break;
            case R.id.navigation_item_images:
                mainView.switch2Images();
                break;
            case R.id.navigation_item_weather:
                mainView.switch2Weather();
                break;
            case R.id.navigation_item_about:
                mainView.switch2About();
                break;
        }
    }
}
