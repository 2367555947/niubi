package com.bwei.sunyongzheng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;

import com.bwei.sunyongzheng.adapter.MyAdapter;
import com.bwei.sunyongzheng.bean.GsonBean;
import com.bwei.sunyongzheng.presenter.Ipresenter;
import com.bwei.sunyongzheng.view.IConcate;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IConcate.IView {
    private Ipresenter ipresenter;
    private List<GsonBean.ResultBean> list=new ArrayList<>();
    private String path = "http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList?page=1&count=20";
    private XRecyclerView xrecyclerview;
    private MyAdapter adapter;
    private boolean aBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        xrecyclerview.setLayoutManager(manager);
        ipresenter=new Ipresenter(this,this);
        ipresenter.startData(path);
        adapter=new MyAdapter(list,this);
        xrecyclerview.setAdapter(adapter);
        xrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                aBoolean=true;
                list.clear();
                ipresenter.startData(path);
                xrecyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                aBoolean=false;
                ipresenter.startData(path);
                xrecyclerview.loadMoreComplete();
            }
        });

    }

    private void initView() {
        xrecyclerview = (XRecyclerView) findViewById(R.id.xrecyclerview);
    }

    @Override
    public void setData(String json) {
        Gson gson=new Gson();
        GsonBean gsonBean = gson.fromJson(json, GsonBean.class);
        List<GsonBean.ResultBean> result = gsonBean.getResult();
        if(aBoolean){
            list.addAll(result);
        }else {
            list.addAll(result);
        }
        adapter.notifyDataSetChanged();
    }
}
