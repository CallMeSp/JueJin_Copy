package com.sp.juejin_copy.view.IActivity;

import com.sp.juejin_copy.bean.IteminSearch;

import java.util.ArrayList;

/**
 * Created by my on 2016/12/4.
 */
public interface iSearchFragment {
    void updateUI(ArrayList<IteminSearch> items);
    void intenttoWeb();
}
