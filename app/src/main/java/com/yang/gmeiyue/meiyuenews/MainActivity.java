package com.yang.gmeiyue.meiyuenews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.yang.gmeiyue.meiyuenews.about.AboutFragment;
import com.yang.gmeiyue.meiyuenews.image.ImagesFragment;
import com.yang.gmeiyue.meiyuenews.main.presenter.MainPresenter;
import com.yang.gmeiyue.meiyuenews.main.presenter.MainPresenterImpl;
import com.yang.gmeiyue.meiyuenews.main.view.MainView;
import com.yang.gmeiyue.meiyuenews.news.NewsFragment;
import com.yang.gmeiyue.meiyuenews.weather.WeatherFragment;

public class MainActivity extends AppCompatActivity implements MainView {

    private Toolbar mToolbar;
    private AppBarLayout mAppbar;
    private FrameLayout mFrameContent;
    private CoordinatorLayout mMainContent;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mUpDrawerContent;
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mFrameContent = (FrameLayout) findViewById(R.id.frame_content);
        mMainContent = (CoordinatorLayout) findViewById(R.id.main_content);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawerContent(mNavigationView);
        mPresenter = new MainPresenterImpl(this);
        switch2News();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mPresenter.switchNavigation(item.getItemId());
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;

            }
        });
    }

    @Override
    public void switch2News() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();
        mToolbar.setTitle(R.string.navigation_news);
    }

    @Override
    public void switch2Images() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new ImagesFragment()).commit();
        mToolbar.setTitle(R.string.navigation_images);
    }

    @Override
    public void switch2Weather() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new WeatherFragment()).commit();
        mToolbar.setTitle(R.string.navigation_weather);
    }

    @Override
    public void switch2About() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new AboutFragment()).commit();
        mToolbar.setTitle(R.string.navigation_about);
    }
}
