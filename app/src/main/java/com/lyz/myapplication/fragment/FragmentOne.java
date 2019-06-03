package com.lyz.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lyz.myapplication.R;
import com.lyz.myapplication.adapter.MyAdapter;
import com.lyz.myapplication.adapter.MyAdapters;
import com.lyz.myapplication.bean.GsonBean;
import com.lyz.myapplication.bean.GsonBeans;
import com.lyz.myapplication.lpresenter.IpresenterImpl;
import com.lyz.myapplication.view.IContact;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment implements IContact.IView {
    private RecyclerView recyclerview_one;
    private RecyclerView recyclerview_two;
    private MyAdapter adapter;
    private MyAdapters adapters;
    private IpresenterImpl ipresenter;
    private List<GsonBean.ResultBean> list;
    private List<GsonBeans.ResultBean> lists=new ArrayList<>();
    private String path="http://172.17.8.100/small/commodity/v1/findSecondCategory?firstCategoryId=1001002";
    private String paths="http://172.17.8.100/small/commodity/v1/findCommodityByCategory?categoryId=";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmentone, container, false);
        initView(inflate);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        recyclerview_one.setLayoutManager(manager);
        ipresenter=new IpresenterImpl(getActivity(),this);
        ipresenter.startRequest(path);
        GridLayoutManager manager1=new GridLayoutManager(getActivity(),2);
        recyclerview_two.setLayoutManager(manager1);
        return inflate;

    }

    private void initView(View inflate) {
        recyclerview_one = (RecyclerView) inflate.findViewById(R.id.recyclerview_one);
        recyclerview_two = (RecyclerView) inflate.findViewById(R.id.recyclerview_two);
    }

    @Override
    public void setData(String json) {
        Gson gson=new Gson();
        GsonBean gsonBean = gson.fromJson(json, GsonBean.class);
        List<GsonBean.ResultBean> result = gsonBean.getResult();
        list=new ArrayList<>();
        list.addAll(result);
        adapter=new MyAdapter(list,getActivity());
        recyclerview_one.setAdapter(adapter);
        adapter.setOnItemClick(new MyAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(View view, int position) {
                lists.clear();
                String id = list.get(position).getId();
                String parmes=paths+id+"&page=1&count=10";
                Log.i("TAG",parmes);
                ipresenter.getjson(parmes);
            }
        });
    }

    @Override
    public void setDataa(String s) {
        Gson gson=new Gson();
        GsonBeans gsonBeans = gson.fromJson(s, GsonBeans.class);
        List<GsonBeans.ResultBean> result = gsonBeans.getResult();
        lists.addAll(result);
        adapters=new MyAdapters(lists,getActivity());
        recyclerview_two.setAdapter(adapters);
        adapters.OnItemClick(new MyAdapters.OnItemClick() {
            @Override
            public void setOnItemClick(View view, int position) {
                Toast.makeText(getContext(),lists.get(position).getCommodityName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
