package com.example.web;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ImageButton btnrefresh,  btnmic,searchbtn, back;
    ImageButton more, forward, stop, refbtn, home, btnBookmarks;
    Button btnTVForTab;
    EditText edittexturl;
    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        btnmic = findViewById(R.id.btnmic);
        btnrefresh = findViewById(R.id.btnrefresh);
        edittexturl = findViewById(R.id.edittexturl);
        searchbtn = findViewById(R.id.searchbtn);
        back = (ImageButton) findViewById(R.id.back);
        forward = (ImageButton) findViewById(R.id.forward);
        stop = (ImageButton) findViewById(R.id.stop);
        refbtn = (ImageButton) findViewById(R.id.refbtn);
        home = (ImageButton) findViewById(R.id.home);
        more = (ImageButton) findViewById(R.id.more);
        btnTVForTab = findViewById(R.id.btnTextViewForTab);
        btnBookmarks = findViewById(R.id.btnAddToBookmarks);
        progressBar = findViewById(R.id.progressBar);


        progressBar.setMax(100);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.loadUrl("https://google.com");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

        /*
        progressBar.setProgress(0);
        webView.setWebViewClient( new WebChromeClient(){
        */
        //@Override
        //public void onProgressChanged(WebView view, int newProgress) {
        // progressBar.setProgress (newProgress);
        //  if (newProgress == 100)
        //progressBar.setVisibility(view.INVISIBLE);
        //else
        //progressBar.setVisibility(view.VISIBLE);

        //super.onProgressChanged( view, newProgress);
        // }
        //});

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edittexturl.getText().toString().isEmpty()) {
                    String address = edittexturl.getText().toString();
                    if (address.contains("http") || address.contains("http")) {
                        if (address.contains(".com") || address.contains(".net") || address.contains(".in")) {
                            webView.loadUrl(address);
                        } else {
                            webView.loadUrl("https://www.google.com/search?q="+address.replace("http","").replace("http",""));
                        }
                    }else {
                        if (address.contains("com")|| address.contains(".net") ||address.contains(".in")){
                            webView.loadUrl("http://"+address);

                    }else {
                        webView.loadUrl("https://www.google.com/search?q="+address.replace("http","").replace("http",""));
                    }

                }
                }
            }
        });

    }
}