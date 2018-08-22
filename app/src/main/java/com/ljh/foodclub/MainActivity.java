package com.ljh.foodclub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ljh.foodclub.base.BaseActivity;
import com.ljh.foodclub.fragment.GalleryFragment;
import com.ljh.foodclub.fragment.HomeFragment;
import com.ljh.foodclub.fragment.MineFragment;
import com.ljh.foodclub.fragment.NavigateFragment;
import com.ljh.foodclub.utils.AnimUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_main_fragment)
    FrameLayout flMainFragment;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.iv_tab_home)
    ImageView ivTabHome;
    @BindView(R.id.tv_tab_home)
    TextView tvTabHome;
    @BindView(R.id.ll_tab_home)
    LinearLayout llTabHome;
    @BindView(R.id.iv_tab_gallery)
    ImageView ivTabGallery;
    @BindView(R.id.tv_tab_gallery)
    TextView tvTabGallery;
    @BindView(R.id.ll_tab_gallery)
    LinearLayout llTabGallery;
    @BindView(R.id.iv_tab_navigate)
    ImageView ivTabNavigate;
    @BindView(R.id.tv_tab_navigate)
    TextView tvTabNavigate;
    @BindView(R.id.ll_tab_navigate)
    LinearLayout llTabNavigate;
    @BindView(R.id.iv_tab_mine)
    ImageView ivTabMine;
    @BindView(R.id.tv_tab_mine)
    TextView tvTabMine;
    @BindView(R.id.ll_tab_mine)
    LinearLayout llTabMine;
    private HomeFragment homeFragment;
    private GalleryFragment galleryFragment;
    private NavigateFragment navigationFragment;
    private MineFragment mineFragment;
    //双击退出的firstTime
    private long firstTime = 0;
    private List<Fragment> fragmentList = new ArrayList<>();
    private static final String HOME_FRAGMENT_KEY = "homeFragment";
    private static final String GALLERY_FRAGMENT_KEY = "galleryFragment";
    private static final String NAVIGATION_FRAGMENT_KEY = "navigationFragment";
    private static final String MINE_FRAGMENT_KEY = "mineFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            /*获取保存的fragment  没有的话返回null*/
            homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag(HOME_FRAGMENT_KEY);
            galleryFragment = (GalleryFragment) getSupportFragmentManager().findFragmentByTag(GALLERY_FRAGMENT_KEY);
            navigationFragment = (NavigateFragment) getSupportFragmentManager().findFragmentByTag(NAVIGATION_FRAGMENT_KEY);
            mineFragment = (MineFragment) getSupportFragmentManager().findFragmentByTag(MINE_FRAGMENT_KEY);

            addToList(homeFragment);
            addToList(galleryFragment);
            addToList(navigationFragment);
            addToList(mineFragment);

        } else {
            //默认显示homeFragment
            homeFragment = new HomeFragment();
            addFragment(homeFragment,HOME_FRAGMENT_KEY);
            showFragment(homeFragment);
            setTab(1);
        }
    }

    private void addToList(Fragment fragment) {
        if (fragment != null) {
            fragmentList.add(fragment);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void loadData() {
    }

    @OnClick({R.id.ll_tab_home, R.id.ll_tab_gallery, R.id.ll_tab_navigate, R.id.ll_tab_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_tab_home:
                AnimUtils.startAnim(ivTabHome);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                addFragment(homeFragment,HOME_FRAGMENT_KEY);
                showFragment(homeFragment);
                setTab(1);
                break;
            case R.id.ll_tab_gallery:
                AnimUtils.startAnim(ivTabGallery);
                if (galleryFragment == null) {
                    galleryFragment = new GalleryFragment();
                }
                addFragment(galleryFragment,GALLERY_FRAGMENT_KEY);
                showFragment(galleryFragment);
                setTab(2);
                break;
            case R.id.ll_tab_navigate:
                AnimUtils.startAnim(ivTabNavigate);
                if (navigationFragment == null) {
                    navigationFragment = new NavigateFragment();
                }
                addFragment(navigationFragment,NAVIGATION_FRAGMENT_KEY);
                showFragment(navigationFragment);
                setTab(3);
                break;
            case R.id.ll_tab_mine:
                AnimUtils.startAnim(ivTabMine);
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                }
                addFragment(mineFragment,MINE_FRAGMENT_KEY);
                showFragment(mineFragment);
                setTab(4);
                break;
        }
    }

    //选择tab
    private void setTab(int position) {
        //全部状态置为false
        tvTabHome.setSelected(false);
        tvTabGallery.setSelected(false);
        tvTabNavigate.setSelected(false);
        tvTabMine.setSelected(false);
        ivTabHome.setSelected(false);
        ivTabGallery.setSelected(false);
        ivTabNavigate.setSelected(false);
        ivTabMine.setSelected(false);
        //根据选中的置为true
        switch (position) {
            case 1:
                tvTabHome.setSelected(true);
                ivTabHome.setSelected(true);
                break;
            case 2:
                tvTabGallery.setSelected(true);
                ivTabGallery.setSelected(true);
                break;
            case 3:
                tvTabNavigate.setSelected(true);
                ivTabNavigate.setSelected(true);
                break;
            case 4:
                tvTabMine.setSelected(true);
                ivTabMine.setSelected(true);
                break;
        }
    }

    /*添加fragment*/
    private void addFragment(Fragment fragment,String tag) {
        /*判断该fragment是否已经被添加过  如果没有被添加  则添加*/
        if (!fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(R.id.fl_main_fragment, fragment,tag).commit();
            /*添加到 fragmentList*/
            fragmentList.add(fragment);
        }
    }

    //展示fragment并隐藏所有的fragment
    private void showFragment(Fragment fragment) {
        for (Fragment frag : fragmentList) {
            if (frag != fragment) {
                /*先隐藏其他fragment*/
                getSupportFragmentManager().beginTransaction().hide(frag).commit();
            }
        }
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    /**
     * 双击退出
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(this, R.string.double_click_exit, Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ivTabHome.clearAnimation();
        ivTabGallery.clearAnimation();
        ivTabNavigate.clearAnimation();
        ivTabMine.clearAnimation();
    }
}
