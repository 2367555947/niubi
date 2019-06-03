package com.lyz.myapplication.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lyz.myapplication.view.IContact;

public class VolleyUtils {
    public VolleyUtils() {

    }
    public static class  HoleyVolley{
        public static VolleyUtils volleyUtils=new VolleyUtils();
    }
    private static VolleyUtils getInstance(){
        return HoleyVolley.volleyUtils;
    }
    public void setData(String url, final Context context, final IContact.Callback callback){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.saveData(response);
            }
        },null);
        requestQueue.add(stringRequest);
    }
}
