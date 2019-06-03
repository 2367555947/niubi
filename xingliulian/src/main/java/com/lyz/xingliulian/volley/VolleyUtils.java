package com.lyz.xingliulian.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lyz.xingliulian.view.IContect;

public class VolleyUtils {
    public VolleyUtils() {
    }
    public static class HoleyVolley{
        public static VolleyUtils volleyUtils=new VolleyUtils();
    }
    public static VolleyUtils getInstance(){
        return HoleyVolley.volleyUtils;
    }
    public void setData(String url, Context context, final IContect.Callback callback){
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
