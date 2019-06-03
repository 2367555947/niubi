package com.lyz.xingliulian.model;

import android.content.Context;

import com.lyz.xingliulian.view.IContect;
import com.lyz.xingliulian.volley.VolleyUtils;

public class IModelImpl implements IContect.IModel {
    private Context context;

    public IModelImpl(Context context) {
        this.context = context;
    }

    @Override
    public void setData(String url, IContect.Callback callback) {
        VolleyUtils.HoleyVolley.volleyUtils.setData(url,context,callback);
    }
}
