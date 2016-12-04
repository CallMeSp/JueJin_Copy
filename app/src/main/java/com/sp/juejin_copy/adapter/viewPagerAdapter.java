package com.sp.juejin_copy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sp.juejin_copy.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/11/21.
 */
public class viewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    private ArrayList<String> title=new ArrayList<String>();

    public viewPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        title.add("首页");
    }
    public void addtitle(String title, Fragment fragment){
        fragments.add(fragment);
        this.title.add(title);
        notifyDataSetChanged();
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
