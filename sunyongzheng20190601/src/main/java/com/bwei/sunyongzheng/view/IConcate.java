package com.bwei.sunyongzheng.view;

import android.content.Context;

public interface IConcate {
    interface IView{
        void setData(String json);
    }
    interface IModel{
        void setData(String url, Callback callback);
    }
    interface  IPresenter{
        void stsartData(String url);
        void onDetach();
    }
    interface Callback{
        void saveData(String json);
    }
}
