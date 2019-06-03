package com.lyz.xingliulian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lyz.xingliulian.adapter.MyAdapter;
import com.lyz.xingliulian.bean.GsonBean;
import com.lyz.xingliulian.presenter.IPresenterImpl;
import com.lyz.xingliulian.view.IContect;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IContect.IView {

    private List<GsonBean.ResultBean> list=new ArrayList<>();
    private XRecyclerView xrecyclerview;
    private MyAdapter adapter;
    private IPresenterImpl iPresenter;
    private  int page=1;
    private boolean flag=true;
    private String path="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=1&count=5&page=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        xrecyclerview.setLayoutManager(manager);
        iPresenter=new IPresenterImpl(this,this);
        iPresenter.startData(path+page);
        adapter=new MyAdapter(list,this);
        xrecyclerview.setAdapter(adapter);
        xrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                flag=true;
                iPresenter.startData(path+page);
                xrecyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                flag=false;
                iPresenter.startData(path+page);
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
        if(flag){
            for (int i = 0; i <4 ; i++) {
                list.addAll(result);
            }
        }else{
            list.addAll(result);
        }
        adapter.notifyDataSetChanged();
    }
}
