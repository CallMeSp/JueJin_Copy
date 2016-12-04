package com.sp.juejin_copy.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sp.juejin_copy.R;
import com.sp.juejin_copy.WebActivity;
import com.sp.juejin_copy.adapter.SearchAdapter;
import com.sp.juejin_copy.bean.IteminSearch;
import com.sp.juejin_copy.presenter.SearchFragmentPresenter;
import com.sp.juejin_copy.view.IActivity.iSearchFragment;

import java.util.ArrayList;

/**
 * Created by my on 2016/12/4.
 */
public class SearchFragment extends Fragment implements iSearchFragment {
    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private IteminSearch iteminSearch=new IteminSearch();
    private SearchFragmentPresenter presenter;
    private ArrayList<IteminSearch> myItems=new ArrayList<IteminSearch>();
    private String url,name,imgurl;
    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        presenter=new SearchFragmentPresenter(this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        presenter.getlist();
        View view=inflater.inflate(R.layout.search_root_layout,container,false);

        recyclerView=(RecyclerView)view.findViewById(R.id.Recycler_insearch);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        searchAdapter=new SearchAdapter(getActivity(),myItems);
        searchAdapter.setInsearchClickListener(new SearchAdapter.InsearchClickListener() {
            @Override
            public void onChoose(int position) {
                Log.e("0","onchoose");
                url=myItems.get(position).getcontenturl();
                name=myItems.get(position).getwritter();
                imgurl=myItems.get(position).getimgurl();
                presenter.toWebActivity();
            }
        });
        recyclerView.setAdapter(searchAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }
    @Override
    public void updateUI(ArrayList<IteminSearch> Items){
        myItems.clear();
        myItems.addAll(Items);
        Message.obtain(mhandeler,0).sendToTarget();
    }
    @Override
    public void intenttoWeb(){
        Intent intent=new Intent(getActivity(), WebActivity.class);
        intent.putExtra("url",url);
        intent.putExtra("writter",name);
        intent.putExtra("imgurl",imgurl);
        startActivity(intent);
    }
    Handler mhandeler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Log.e("0", "hhhhhhhhhhhhhh");
                    searchAdapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }
    };
}
