package com.lyz.xingliulian.view;

public interface IContect {
    interface IView{
        void setData(String json);
    }
    interface IModel{
        void setData(String url,Callback callback);
    }
    interface  IPresenter{
        void startData(String json);
        void onDetach();
    }
    interface Callback{
        void saveData(String json);
    }
}
