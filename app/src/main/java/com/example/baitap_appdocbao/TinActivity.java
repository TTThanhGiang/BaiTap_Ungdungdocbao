package com.example.baitap_appdocbao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class TinActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin);

        webView = findViewById(R.id.webview);
        Intent intent = getIntent();
        String link = intent.getStringExtra("link");

        webView.loadUrl(link);
    }
}