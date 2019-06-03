package com.bwei.sunyongzheng.model;

import android.content.Context;

import com.bwei.sunyongzheng.IConcate;
import com.bwei.sunyongzheng.volley.VolleyUtils;

public class IModel implements IConcate.IModel {
    private Context context;

    public IModel(Context context) {
        this.context = context;
    }

    @Override
    public void setData(String url, IConcate.Callback callback) {
        VolleyUtils.HoleyVolley.volleyUtils.setData(url,context,callback);
    }
}
