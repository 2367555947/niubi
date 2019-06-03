package com.bwei.sunyongzheng.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwei.sunyongzheng.R;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class FragmentTwo extends Fragment {
    private android.webkit.WebView WebView;
    private List<Integer> list=new ArrayList<>();
    private String path = "https://abnerming8.github.io/abnerming.html";
    private Banner banner;

    @SuppressLint("JavascriptInterface")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmenttwo, container, false);
        initView(inflate);
        WebView.loadUrl(path);
        WebView.setWebViewClient(new WebViewClient());
        WebView.setWebChromeClient(new WebChromeClient());
        WebSettings settings = WebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        WebView.addJavascriptInterface(new TextTwo(), "android");
        WebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(android.webkit.WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });

        list.add(R.mipmap.ic_launcher);
        list.add(R.drawable.ic_launcher_background);
        list.add(R.mipmap.ic_launcher_round);

        banner.setImages(list);
        banner.setDelayTime(2000);
        banner.isAutoPlay(true);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
        return inflate;
    }

    private void initView(View inflate) {
        WebView = (WebView) inflate.findViewById(R.id.WebView);
        banner = (Banner) inflate.findViewById(R.id.banner);

    }

    class TextTwo {
        public void show() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    WebView.loadUrl("javascript:toast()");
                }
            });
        }
    }
}
