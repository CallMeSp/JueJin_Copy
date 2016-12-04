package com.sp.juejin_copy.bean;

/**
 * Created by my on 2016/11/30.
 */
public class IteminSearch {
    String title,num,writter,time,imgurl,contenturl;
    public void settitle(String s){this.title=s;}
    public void setnum(String s){this.num=s;}
    public void setwritter(String s){this.writter=s;}
    public void settime(String s){this.time=s;}
    public void setimgurl(String s){this.imgurl=s;}
    public void setcontenturl(String s){this.contenturl=s;}
    public String gettitle(){return title;}
    public String getnum(){return num;}
    public String getwritter(){return writter;}
    public String gettime(){return time;}
    public String getimgurl(){return imgurl;}
    public String getcontenturl(){return contenturl;}
}
