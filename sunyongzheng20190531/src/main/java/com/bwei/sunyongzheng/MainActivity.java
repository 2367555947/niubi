package com.bwei.sunyongzheng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bwei.sunyongzheng.adapter.MyAdapter;
import com.bwei.sunyongzheng.bean.GsonBean;
import com.bwei.sunyongzheng.presenter.IPresenterlmpl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IConcate.IView {

    private RecyclerView recyclerview;
    private MyAdapter adapter;
    private IPresenterlmpl ipresenter;
    private List<GsonBean.ResultBean> list=new ArrayList<>();
    private String path="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=1&page=1&count=10";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        GridLayoutManager manager=new GridLayoutManager(this,2);
        recyclerview.setLayoutManager(manager);
        ipresenter=new IPresenterlmpl(this,this);

        ipresenter.startTach(path);

    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
    }

    @Override
    public void setData(String json) {
        Gson gson=new Gson();
        GsonBean gsonBean = gson.fromJson(json,GsonBean.class);
        List<GsonBean.ResultBean> result = gsonBean.getResult();
        Log.i("TAG",result.size()+"");
        list.addAll(result);
        adapter=new MyAdapter(list,this);
        Log.i("TAG",list.size()+"");
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
