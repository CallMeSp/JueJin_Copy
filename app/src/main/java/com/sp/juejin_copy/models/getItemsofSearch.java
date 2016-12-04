package com.sp.juejin_copy.models;

import android.util.Log;

import com.sp.juejin_copy.bean.IteminSearch;
import com.sp.juejin_copy.presenter.MainPresenter;
import com.sp.juejin_copy.presenter.SearchFragmentPresenter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by my on 2016/12/1.
 */
public class getItemsofSearch implements IgetItemsofSearch{
    String title,num,writter,time,contenturl,imgurl;
    ArrayList<IteminSearch> myitems=new ArrayList<IteminSearch>();
    SearchFragmentPresenter searchFragmentPresenter;
    public getItemsofSearch(SearchFragmentPresenter presenter){
        this.searchFragmentPresenter=presenter;
    }
    public void getItems(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect("http://gold.xitu.io")
                            .get();
                    Elements items=doc.select("div.entry").select(".clearfix");
                    Log.e("Size", "" + items.size());
                    for (Element Item : items) {
                        title=Item.select("div.entry-title").text();
                        num=Item.select("div.action").get(0).text();
                        writter=Item.select("div.action").get(1).text();
                        time=Item.select("div.action").get(3).text();
                        try {
                            contenturl=Item.select("a").get(3).attr("href");
                            imgurl=Item.select("img").attr("v-lazy");
                            imgurl=imgurl.substring(1,imgurl.length()-1);
                        }catch (IndexOutOfBoundsException e){
                            Log.e("catch","...");//跳转
                            break;
                            //e.printStackTrace();
                        }
                        Log.e("0","Title="+title+"   Num="+num+"   writter="+writter+"   time="+time+"   url="+contenturl+"   img="+imgurl);
                        IteminSearch iteminSearch=new IteminSearch();
                        iteminSearch.settitle(title);
                        iteminSearch.setnum(num);
                        iteminSearch.settime(time);
                        iteminSearch.setcontenturl(contenturl);
                        iteminSearch.setimgurl(imgurl);
                        iteminSearch.setwritter(writter);
                        myitems.add(iteminSearch);
                    }
                    searchFragmentPresenter.update(myitems);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
