package com.bwei.sunyongzheng.presenter;

import android.content.Context;

import com.bwei.sunyongzheng.model.IModellmpl;
import com.bwei.sunyongzheng.view.IConcate;

public class IPresenterlmpl implements IConcate.IPresenter {
    private Context context;
    private IConcate.IView iView;
    private IModellmpl iModellmpl;
    public IPresenterlmpl(Context context, IConcate.IView iView) {
        this.context = context;
        this.iView = iView;
        iModellmpl=new IModellmpl(context);
    }

    @Override
    public void stsartData(String url) {
        iModellmpl.setData(url, new IConcate.Callback() {
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
        if(iModellmpl!=null){
            iModellmpl=null;
        }
    }
}
