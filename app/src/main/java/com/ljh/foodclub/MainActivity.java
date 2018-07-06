package com.ljh.foodclub;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        if(homeFragment!=null){
//            getSupportFragmentManager().putFragment(outState,"1",homeFragment);
//        }
//        if(galleryFragment!=null){
//            getSupportFragmentManager().putFragment(outState,"2",galleryFragment);
//        }
//        if(navigationFragment!=null){
//            getSupportFragmentManager().putFragment(outState,"3",navigationFragment);
//        }
//        if(mineFragment!=null){
//            getSupportFragmentManager().putFragment(outState,"4",mineFragment);
//        }
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState!=null){
//            homeFragment = (HomeFragment) getSupportFragmentManager().getFragment(savedInstanceState,"1");
//            galleryFragment = (GalleryFragment) getSupportFragmentManager().getFragment(savedInstanceState,"2");
//            navigationFragment = (NavigateFragment) getSupportFragmentManager().getFragment(savedInstanceState,"3");
//            mineFragment = (MineFragment) getSupportFragmentManager().getFragment(savedInstanceState,"4");
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }



    @Override
    protected void initView() {
        initHomeFragment();
        setTab(1);
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
                initHomeFragment();
                setTab(1);
                break;
            case R.id.ll_tab_gallery:
                initGalleryFragment();
                setTab(2);
                break;
            case R.id.ll_tab_navigate:
                initNavigationFragment();
                setTab(3);
                break;
            case R.id.ll_tab_mine:
                initMineFragment();
                setTab(4);
                break;
        }
    }

    //选择tab
    private void setTab(int position){
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
        switch (position){
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

    //显示HomeFragment
    private void initHomeFragment(){
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(homeFragment == null){
            homeFragment = new HomeFragment();
            transaction.add(R.id.fl_main_fragment, homeFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(homeFragment);

        //提交事务
        transaction.commit();
    }

    //显示GalleryFragment
    private void initGalleryFragment(){
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(galleryFragment == null){
            galleryFragment = new GalleryFragment();
            transaction.add(R.id.fl_main_fragment,galleryFragment);
        }
        hideFragment(transaction);
        transaction.show(galleryFragment);

        transaction.commit();
    }

    //显示NavigationFragment
    private void initNavigationFragment(){
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(navigationFragment == null){
            navigationFragment = new NavigateFragment();
            transaction.add(R.id.fl_main_fragment,navigationFragment);
        }
        hideFragment(transaction);
        transaction.show(navigationFragment);

        transaction.commit();
    }

    //显示第MineFragment
    private void initMineFragment(){
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(mineFragment == null){
            mineFragment = new MineFragment();
            transaction.add(R.id.fl_main_fragment,mineFragment);
        }
        hideFragment(transaction);
        transaction.show(mineFragment);

        transaction.commit();
    }

    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){
        if(homeFragment != null){
            transaction.hide(homeFragment);
        }
        if(galleryFragment != null){
            transaction.hide(galleryFragment);
        }
        if(navigationFragment != null){
            transaction.hide(navigationFragment);
        }
        if(mineFragment != null){
            transaction.hide(mineFragment);
        }
    }

    /**
     * 双击退出
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            long secondTime = System.currentTimeMillis();
            if (secondTime-firstTime>2000){
                Toast.makeText(this, R.string.double_click_exit,Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
                return true;
            }else {
                finish();
            }
        }
        return super.onKeyUp(keyCode, event);
    }

}
