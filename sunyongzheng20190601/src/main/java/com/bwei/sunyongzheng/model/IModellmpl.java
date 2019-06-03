package com.bwei.sunyongzheng.model;

import android.content.Context;

import com.bwei.sunyongzheng.view.IConcate;
import com.bwei.sunyongzheng.volley.VolleyUtils;

public class IModellmpl implements IConcate.IModel {
    private Context context;

    public IModellmpl(Context context) {
        this.context = context;
    }

    @Override
    public void setData(String url, IConcate.Callback callback) {
        VolleyUtils.HoleyVolley.volleyUtils.setData(url,context,callback);
    }
}
