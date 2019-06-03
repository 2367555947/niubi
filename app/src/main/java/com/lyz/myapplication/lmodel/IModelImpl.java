package com.lyz.myapplication.lmodel;

import android.content.Context;

import com.android.volley.toolbox.Volley;
import com.lyz.myapplication.utils.VolleyUtils;
import com.lyz.myapplication.view.IContact;
public class IModelImpl implements IContact.IMolde {
    private Context context;
    public IModelImpl(Context context) {
        this.context = context;
    }

    @Override
    public void getData(String url, IContact.Callback callback) {
        VolleyUtils.HoleyVolley.volleyUtils.setData(url,context,callback);
    }
}
