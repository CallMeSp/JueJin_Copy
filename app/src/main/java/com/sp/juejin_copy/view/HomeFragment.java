package com.sp.juejin_copy.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sp.juejin_copy.R;

/**
 * Created by my on 2016/11/22.
 */
public class HomeFragment extends Fragment {
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstance){
        View view=inflater.inflate(R.layout.home_root_layout,container,false);
        return view;
    }
}
