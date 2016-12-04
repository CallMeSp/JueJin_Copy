package com.sp.juejin_copy.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sp.juejin_copy.R;

/**
 * Created by my on 2016/12/4.
 */
public class MessageFragment extends Fragment{
    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstance){
        View view=inflater.inflate(R.layout.message_root_layout,container,false);
        return view;
    }
}
