package com.example.web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    ImageButton btnrefresh, btnmic, searchbtn, back;
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
                            webView.loadUrl("https://www.google.com/search?q=" + address.replace("http", "").replace("http", ""));
                        }
                    } else {
                        if (address.contains("com") || address.contains(".net") || address.contains(".in")) {
                            webView.loadUrl("http://" + address);

                        } else {
                            webView.loadUrl("https://www.google.com/search?q=" + address.replace("http", "").replace("http", ""));
                        }

                    }
                }
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog sheetDialog = new BottomSheetDialog(MainActivity.this,R.style.BottomsheetDialogTheme);
                View sheetView = LayoutInflater. from (getApplicationContext()) .inflate(R.layout.recorderdialog,(LinearLayout)findViewById(R.id.dialog_container));
                sheetView.findViewById(R.id.filemenucancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sheetDialog.dismiss();
                    }
                });
                sheetView.findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        webView.reload();
                        Toast.makeText(MainActivity.this, " history Refresh",Toast.LENGTH_SHORT).show();
                    }
                });
                sheetView.findViewById(R.id.history).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "history",Toast.LENGTH_SHORT).show();

                    }
                });
                sheetView.findViewById(R.id.setting).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "setting",Toast.LENGTH_SHORT).show();
                    }
                });
                sheetView.findViewById(R.id.Favorite).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Favorite",Toast.LENGTH_SHORT).show();

                    }
                });
                sheetView.findViewById(R.id.Download).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Download",Toast.LENGTH_SHORT).show();
                    }
                });
                sheetView.findViewById(R.id.Desktop).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Desktop Mode",Toast.LENGTH_SHORT).show();
                    }
                });
                sheetView.findViewById(R.id.Scanandbar).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Scan and Code",Toast.LENGTH_SHORT).show();
                    }
                });
                sheetView.findViewById(R.id.Exit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Exit",Toast.LENGTH_SHORT).show();
                    }
                });
                sheetView.findViewById(R.id.Developer).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Developer",Toast.LENGTH_SHORT).show();
                    }
                });
                sheetDialog.setContentView(sheetView);
                sheetDialog.show();


            }
        });
            btnTVForTab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, " btnTVForTab",Toast.LENGTH_SHORT).show();
                }
            });
            btnrefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edittexturl.selectAll();
                    edittexturl.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
                    edittexturl.requestFocus();
                }



            });

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (webView.canGoBack()){
                        webView.goBack();


                    }
                }
            });
            forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (webView.canGoForward()){
                        webView.goBack();
                    }
                }
            });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               webView.stopLoading();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://google.com");
            }
        });
        btnBookmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, " Bookmark ",Toast.LENGTH_SHORT).show();
            }
        });
    }

}