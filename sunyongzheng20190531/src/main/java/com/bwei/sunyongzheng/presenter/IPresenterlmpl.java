package com.bwei.sunyongzheng.presenter;

import android.content.Context;

import com.bwei.sunyongzheng.IConcate;
import com.bwei.sunyongzheng.model.IModel;

public class IPresenterlmpl implements IConcate.Ipresenter {
    private IConcate.IView iView;
    private Context context;
    private IModel miModel;
    public IPresenterlmpl(IConcate.IView iView, Context context) {
        this.iView = iView;
        this.context = context;
        miModel=new IModel(context);
    }

    @Override
    public void startTach(String json) {
        miModel.setData(json, new IConcate.Callback() {
            @Override
            public void saveData(String json) {
                iView.setData(json);
            }
        });
    }

    @Override
    public void onDeatch() {
        if(iView!=null){
            iView=null;
        }
        if(miModel!=null){
            miModel=null;
        }
    }
}
