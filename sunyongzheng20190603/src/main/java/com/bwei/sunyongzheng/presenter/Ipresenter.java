package com.bwei.sunyongzheng.presenter;

import android.content.Context;

import com.bwei.sunyongzheng.model.IModel;
import com.bwei.sunyongzheng.view.IConcate;

public class Ipresenter implements IConcate.IPresenter {
    private IConcate.IView iView;
    private IModel iModel;
    private Context context;

    public Ipresenter(IConcate.IView iView, Context context) {
        this.iView = iView;
        iModel=new IModel(context);
        this.context = context;
    }

    @Override
    public void startData(String url) {
        iModel.setData(url, new IConcate.Callback() {
            @Override
            public void saveData(String json) {
                iView.setData(json);
            }
        });
    }

    @Override
    public void onDetach() {
        if(iView!=null){
            iView=null;
        }
        if(iModel!=null){
            iModel=null;
        }
    }
}
