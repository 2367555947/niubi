package com.lyz.xingliulian.presenter;

import android.content.Context;
import android.provider.ContactsContract;

import com.lyz.xingliulian.model.IModelImpl;
import com.lyz.xingliulian.view.IContect;

public class IPresenterImpl implements IContect.IPresenter {
    private IContect.IView iView;
    private IModelImpl iModel;
    private Context context;

    public IPresenterImpl(IContect.IView iView, Context context) {
        this.iView = iView;
        this.context = context;
        iModel=new IModelImpl(context);
    }

    @Override
    public void startData(String json) {
        iModel.setData(json, new IContect.Callback() {
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
