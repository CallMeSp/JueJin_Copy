package com.sp.juejin_copy.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sp.juejin_copy.R;
import com.sp.juejin_copy.bean.IteminSearch;
import com.sp.juejin_copy.bean.IteminSearch;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by my on 2016/11/14.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.Myholder>{
    private LayoutInflater inflater;
    private Context mcontext;
    private ArrayList<IteminSearch> myItem=new ArrayList<IteminSearch>();
    private InsearchClickListener mitemlistener;
    public SearchAdapter(Context context,ArrayList<IteminSearch> mbook){
        myItem=mbook;
        mcontext=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getItemCount(){
        return myItem.size();
    }
    class Myholder extends RecyclerView.ViewHolder{
        TextView t_title,t_writter,t_num,t_time;
        ImageView itemcover;
        public Myholder(View view){
            super(view);
            t_title=(TextView)view.findViewById(R.id.insearch_title);
            t_writter=(TextView)view.findViewById(R.id.insearch_writter);
            t_time=(TextView)view.findViewById(R.id.insearch_time);
            t_num=(TextView)view.findViewById(R.id.insearch_num) ;
            itemcover=(ImageView)view.findViewById(R.id.insearch_img);
        }
    }
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent,int type){
        View view=inflater.inflate(R.layout.search_list_item,parent,false);
        Myholder myholder=new Myholder(view);
        return myholder;
    }
    @Override
    public void onBindViewHolder(Myholder myholder,final int position){
        myholder.t_title.setText(myItem.get(position).gettitle());
        myholder.t_writter.setText(myItem.get(position).getwritter()+"·");
        myholder.t_num.setText(myItem.get(position).getnum()+"人收藏·");
        myholder.t_time.setText(myItem.get(position).gettime());
        Picasso.with(myholder.itemView.getContext())
                .load(myItem.get(position).getimgurl())
                .centerInside()
                .fit()
                .into(myholder.itemcover);
        if(mitemlistener!= null){
            myholder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mitemlistener.onChoose(position);
                }
            });
        }
    }
    public interface InsearchClickListener{
        public void onChoose(int position);
    }
    public void setInsearchClickListener(InsearchClickListener bookClickListener){
        this.mitemlistener=bookClickListener;
    }
}
