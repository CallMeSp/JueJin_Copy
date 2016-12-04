package com.sp.juejin_copy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by my on 2016/12/4.
 */
public class WebActivity extends Activity{
    private WebView webView;
    private String url,writter,imgurl;
    private Toolbar toolbar;
    private CircleImageView circleImageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.webview_layout);
        circleImageView=(CircleImageView)findViewById(R.id.circle_image);
        textView=(TextView)findViewById(R.id.inweb_writter);
        toolbar=(Toolbar)findViewById(R.id.web_toolbar);
        toolbar.setEnabled(true);
        webView=(WebView)findViewById(R.id.web_view_page);
        Intent intent=getIntent();
        url=intent.getStringExtra("url");
        writter=intent.getStringExtra("writter");
        imgurl=intent.getStringExtra("imgurl");
        textView.setText(writter);
        Picasso.with(this)
                .load(imgurl)
                .centerInside()
                .fit()
                .into(circleImageView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.e("0",id+" is choosen");
        //noinspection SimplifiableIfStatement
        if (true) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
