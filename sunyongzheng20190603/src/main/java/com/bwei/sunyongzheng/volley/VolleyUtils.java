package com.bwei.sunyongzheng.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bwei.sunyongzheng.view.IConcate;

public class VolleyUtils {
    public VolleyUtils() {
    }

    public static class HolleyVolley{
        public static VolleyUtils volleyUtils=new VolleyUtils();
    }
    public static VolleyUtils getInstance(){
        return HolleyVolley.volleyUtils;
    }
    public void setData(String path, Context context, final IConcate.Callback callback){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.saveData(response);
            }
        },null);
        requestQueue.add(stringRequest);
    }
}
