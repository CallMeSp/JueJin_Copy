package com.sp.juejin_copy;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.sp.juejin_copy.adapter.viewPagerAdapter;
import com.sp.juejin_copy.bean.IteminSearch;
import com.sp.juejin_copy.view.AnimationView;
import com.sp.juejin_copy.view.HomeFragment;
import com.sp.juejin_copy.view.IActivity.ImainActivity;
import com.sp.juejin_copy.view.MineFragment;
import com.sp.juejin_copy.view.SearchFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ImainActivity,View.OnClickListener{
    private AnimationView animationView=new AnimationView();
    private viewPagerAdapter adapter;
    private ArrayList<Fragment> Fragments=new ArrayList<Fragment>();
    private ViewPager viewPager;
    private Button HOME,SEARCH,MESSAGE,MINE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        Fragments.add(HomeFragment.newInstance());
        Fragments.add(SearchFragment.newInstance());
        Fragments.add(MineFragment.newInstance());
        Fragments.add(MineFragment.newInstance());
        adapter=new viewPagerAdapter(getSupportFragmentManager(),Fragments);
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("0", event.getY() + "");
                return false;
            }
        });
        HOME=(Button)findViewById(R.id.btn_home);
        SEARCH=(Button)findViewById(R.id.btn_search);
        MESSAGE=(Button)findViewById(R.id.btn_search);
        MINE=(Button)findViewById(R.id.btn_mine);
        HOME.setOnClickListener(this);
        SEARCH.setOnClickListener(this);
        MESSAGE.setOnClickListener(this);
        MINE.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId()){
            case R.id.btn_home:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.btn_search:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.btn_message:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.btn_mine:
                viewPager.setCurrentItem(3,false);
                break;
        }
    }
    @Override
    public void updateUI(ArrayList<IteminSearch> items){
    }
}
