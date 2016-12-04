package com.sp.juejin_copy.presenter;

import com.sp.juejin_copy.bean.IteminSearch;
import com.sp.juejin_copy.models.getItemsofSearch;
import com.sp.juejin_copy.view.IActivity.iSearchFragment;

import java.util.ArrayList;

/**
 * Created by my on 2016/12/4.
 */
public class SearchFragmentPresenter {
    private iSearchFragment iSearchFragment;
    private getItemsofSearch getItemsofSearch;
    public SearchFragmentPresenter(iSearchFragment searchFragment){
        this.iSearchFragment=searchFragment;
        this.getItemsofSearch=new getItemsofSearch(this);
    }
    public void getlist(){
        getItemsofSearch.getItems();
    }
    public void update(ArrayList<IteminSearch> items){
        iSearchFragment.updateUI(items);
    }
    public void toWebActivity(){
        iSearchFragment.intenttoWeb();
    }
}
