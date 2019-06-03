package com.bwei.sunyongzheng.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwei.sunyongzheng.Main2Activity;
import com.bwei.sunyongzheng.R;
import com.bwei.sunyongzheng.adapter.MyAdapter;
import com.bwei.sunyongzheng.bean.GsonBean;
import com.bwei.sunyongzheng.presenter.IPresenterlmpl;
import com.bwei.sunyongzheng.view.IConcate;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment implements IConcate.IView, View.OnClickListener {
    private RecyclerView recyclerview;
    private IPresenterlmpl iPresenterlmpl;
    private MyAdapter adapter;
    private List<String> lists=new ArrayList<>();
    private List<GsonBean.ResultBean> list = new ArrayList<>();
    private String path = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=1&page=1&count=10";
    private Button btn_cha;
    private EditText edit_shangp;
    private Banner banner_one;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmentone, container, false);
        initView(inflate);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(manager);
        iPresenterlmpl = new IPresenterlmpl(getContext(), this);
        iPresenterlmpl.stsartData(path);
        edit_shangp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getContext(), Main2Activity.class);
                startActivity(it);
            }
        });

        return inflate;
    }

    private void initView(View inflate) {
        recyclerview = (RecyclerView) inflate.findViewById(R.id.recyclerview);
        btn_cha = (Button) inflate.findViewById(R.id.btn_cha);
        btn_cha.setOnClickListener(this);
        edit_shangp = (EditText) inflate.findViewById(R.id.edit_shangp);
        edit_shangp.setOnClickListener(this);
        banner_one = (Banner) inflate.findViewById(R.id.banner_one);
        banner_one.setOnClickListener(this);
    }

    @Override
    public void setData(String json) {
        Gson gson = new Gson();
        GsonBean gsonBean = gson.fromJson(json, GsonBean.class);
        List<GsonBean.ResultBean> result = gsonBean.getResult();
        list.addAll(result);
        adapter = new MyAdapter(list, getContext());
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        lists=new ArrayList<>();
        for (int i = 0; i <result.size() ; i++) {
            lists.add(result.get(i).getMasterPic());
        }
        banner_one.setImages(lists);
        banner_one.setDelayTime(2000);
        banner_one.isAutoPlay(true);
        banner_one.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cha:
                Intent it = new Intent(getContext(), Main2Activity.class);
                startActivity(it);
                break;
        }
    }

}
