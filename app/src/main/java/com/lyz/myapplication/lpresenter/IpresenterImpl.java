package com.lyz.myapplication.lpresenter;

import android.content.Context;

import com.lyz.myapplication.lmodel.IModelImpl;
import com.lyz.myapplication.view.IContact;

public class IpresenterImpl implements IContact.IPersenter {
    private IContact.IView iView;
    private IModelImpl iModel;
    private Context context;
    public IpresenterImpl(Context context, IContact.IView iView) {
        this.iView=iView;
        this.context=context;
        iModel=new IModelImpl(context);
    }


    @Override
    public void startRequest(String json) {
       iModel.getData(json, new IContact.Callback() {
           @Override
           public void saveData(String json) {
               iView.setData(json);
           }
       });
    }

    @Override
    public void getjson(String json) {
        iModel.getData(json, new IContact.Callback() {
            @Override
            public void saveData(String json) {
                iView.setDataa(json);
            }
        });
    }

    @Override
    public void onDeatch() {

        if(iView!=null){
            iView=null;
        }
        if(iModel!=null){
            iModel=null;
        }
    }
}
