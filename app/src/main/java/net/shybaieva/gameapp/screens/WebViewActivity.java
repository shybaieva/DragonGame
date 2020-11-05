package net.shybaieva.gameapp.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

import net.shybaieva.gameapp.R;
import net.shybaieva.gameapp.service.MyWebViewClient;

public class WebViewActivity extends AppCompatActivity implements View.OnClickListener {

    WebView webView;
    CardView topLine;
    ImageButton back, forward, refreshPage;
    String url = "https://html5test.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        init();

        webView.setWebViewClient(new MyWebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        webView.loadUrl(url);

        back.setOnClickListener(this);

        forward.setOnClickListener(this);

        refreshPage.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    private void init(){
        webView = findViewById(R.id.webView);
        back = findViewById(R.id.backBtn);
        forward = findViewById(R.id.forwardBtn);
        refreshPage = findViewById(R.id.refreshBtn);
        topLine = findViewById(R.id.topLine);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backBtn:{
                if(webView.canGoBack())
                    webView.goBack();
                break;
            }
            case R.id.forwardBtn:{
                if(webView.canGoForward())
                    webView.goForward();
                break;
            }
            case R.id.refreshBtn:{
                webView.reload();
                break;
            }
        }
    }
}