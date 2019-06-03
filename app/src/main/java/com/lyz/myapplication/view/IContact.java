package com.lyz.myapplication.view;

import android.content.Context;

public interface IContact {
    interface IView{
        void setData(String json);
        void setDataa(String s);
    }
    interface IMolde{
        void getData(String url, Callback callback);
    }
    interface IPersenter{
        void startRequest(String json);
        void getjson(String json);
        void onDeatch();
    }
    interface Callback{
        void saveData(String json);
    }
}
