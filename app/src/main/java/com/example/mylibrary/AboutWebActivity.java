package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutWebActivity extends AppCompatActivity {

    private WebView _webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_web);

        _webView = findViewById(R.id.webView);

        //by this line, program do not open external web browser, web is shown in te same page of the program
        _webView.setWebViewClient(new WebViewClient());
        _webView.getSettings().setJavaScriptEnabled(true);
        _webView.loadUrl("https://google.com.tr");
    }

    @Override
    public void onBackPressed() {
        //if there are browsing history, by pressing back button; program do not close the web view, instead it
        //go previous page of the web. When program come to first page, it closes web view
        if (_webView.canGoBack()){
            _webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}