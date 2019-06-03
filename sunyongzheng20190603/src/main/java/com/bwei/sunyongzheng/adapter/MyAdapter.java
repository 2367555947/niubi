package com.bwei.sunyongzheng.adapter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.sunyongzheng.R;
import com.bwei.sunyongzheng.bean.GsonBean;

import java.util.List;
import java.util.Random;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolderOne> {
    private List<GsonBean.ResultBean> list;
    private Context context;

    public MyAdapter(List<GsonBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolderOne onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ViewHolderOne viewHolderOne=new ViewHolderOne(inflate);
        return viewHolderOne;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderOne viewHolderOne, int i) {
        ViewGroup.LayoutParams layoutParams = viewHolderOne.itemView.getLayoutParams();
        Random random=new Random();
        int height=random.nextInt(400)+300;
        layoutParams.height=height;
        viewHolderOne.textView.setText(list.get(i).getName());
        Glide.with(context).load(list.get(i).getImageUrl()).into(viewHolderOne.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolderOne extends RecyclerView.ViewHolder{

        private TextView textView;
        private ImageView imageView;
        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview);
            imageView=itemView.findViewById(R.id.imageview);
        }
    }
}
