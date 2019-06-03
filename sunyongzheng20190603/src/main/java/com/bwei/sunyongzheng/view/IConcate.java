package com.bwei.sunyongzheng.view;

public interface IConcate {
    interface IView{
        void setData(String json);
    }
    interface IModel{
        void setData(String json,Callback callback);
    }
    interface IPresenter{
        void startData(String url);
        void onDetach();
    }
    interface Callback{
        void saveData(String json);
    }
}
