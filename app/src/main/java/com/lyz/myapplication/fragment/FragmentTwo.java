package com.lyz.myapplication.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lyz.myapplication.R;

public class FragmentTwo extends Fragment {
    private WebView webview;
    private String url="file:///android_asset/about.html";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmenttwo, container, false);
        initView(inflate);
        return inflate;
    }

    @SuppressLint("JavascriptInterface")
    private void initView(View inflate) {
        webview = (WebView) inflate.findViewById(R.id.webview);
        webview.loadUrl(url);
        WebSettings settings=webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        webview.addJavascriptInterface(new TextTwo(),"android");
        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
    }
    class TextTwo{
        public void show(){
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    webview.loadUrl("javascript:toast()");
                }
            });
        }
    }

}
