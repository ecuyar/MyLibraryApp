package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutWebActivity extends AppCompatActivity {
    private static final String TAG = "AboutWebActivity";

    private WebView _webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_web);

        _webView = findViewById(R.id.webView);
        String myUrl = "";
        try {
            myUrl = getIntent().getStringExtra("URL");

            //by this line, program do not open external web browser, web is shown in te same page of the program
            _webView.setWebViewClient(new WebViewClient());

            //this line gives warning because of js attacks can be made when scripts are enabled
            _webView.getSettings().setJavaScriptEnabled(true);
            _webView.loadUrl(myUrl);
        } catch (Exception e) {
            Log.d(TAG, "onCreate: No intent reveived.");
        }


    }

    @Override
    public void onBackPressed() {
        //if there are browsing history, by pressing back button; program do not close the web view, instead it
        //go previous page of the web. When program come to first page, it closes web view
        if (_webView.canGoBack()) {
            _webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}