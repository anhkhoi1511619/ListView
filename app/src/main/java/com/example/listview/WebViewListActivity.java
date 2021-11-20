package com.example.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewListActivity extends AppCompatActivity {

    private boolean mIsSetting = false;

    public static class WebViewEx extends WebView {
        public WebViewEx(final Context context) {
            super(context);
        }

        public WebViewEx(final Context context, final AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public WebViewEx(final Context context, final AttributeSet attributeSet, final int defStyle) {
            super(context, attributeSet, defStyle);
        }

        private OnScrollCallBack mOnScrollCallBack;

        public void setOnScrollCallBack(final OnScrollCallBack onScrollCallBack) {
            this.mOnScrollCallBack = onScrollCallBack;
        }

        public static interface OnScrollCallBack {
            public void onScroll(int l, int t);

            public void onScrollEnd();
        }

    @Override
        protected void onScrollChanged(final int l, final int t, final int oldl, final int oldt){
            super.onScrollChanged(l, t, oldl, oldt);

            if(mOnScrollCallBack != null){
                mOnScrollCallBack.onScroll(l, t);

                int pageHeight = computeVerticalScrollRange();
                if(pageHeight <= t + computeVerticalScrollExtent()){
                    mOnScrollCallBack.onScrollEnd();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);


        Intent intent = getIntent();
        mIsSetting = intent.getBooleanExtra(MainActivity.SETTING_INTENT_FLAG,false);

        WebViewEx webViewEx = (WebViewEx) findViewById(R.id.upWebViewList);
        WebSettings settings = webViewEx.getSettings();
//        settings.setAllowFileAccess(false);
//        settings.setAllowContentAccess(false);

        String url = "https://www.howkteam.vn/course/khoa-hoc-lap-trinh-android-co-ban/listview-va-custom-adapter-119";
//        String url = "/storage/emulated/0/Android/data/com.google.android.gm/cache/web.html";
//        /sdcard/Android/data/com.google.android.gm/cache/web.html

        webViewEx.loadUrl(url);
        webViewEx.setOnScrollCallBack(new WebViewEx.OnScrollCallBack(){
            @Override
            public void onScroll(int l, int t){
            }

            @Override
            public void onScrollEnd() {

            }
        });

    }

}
