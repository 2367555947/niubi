package com.bwei.sunyongzheng;

public interface IConcate {
    interface IView{
        void setData(String json);
    }
    interface IModel{
        void setData(String url,Callback callback);
    }
    interface Ipresenter{
        void startTach(String json);
        void onDeatch();
    }
    interface  Callback{
        void saveData(String json);
    }
}
