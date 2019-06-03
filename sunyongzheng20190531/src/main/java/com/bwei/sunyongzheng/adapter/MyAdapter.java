package com.bwei.sunyongzheng.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.sunyongzheng.R;
import com.bwei.sunyongzheng.bean.GsonBean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GsonBean.ResultBean> list;
    private Context context;

    public MyAdapter(List<GsonBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder=null;
        View view=null;
        view= View.inflate(context, R.layout.item_one, null);
        holder=new ViewHolderOne(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        GsonBean.ResultBean resultBean = list.get(i);
        if(viewHolder instanceof ViewHolderOne){
            Glide.with(context).load(list.get(i).getMasterPic()).into(((ViewHolderOne) viewHolder).imageView);
            ((ViewHolderOne) viewHolder).textView.setText(list.get(i).getCommodityName());
        }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolderOne extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_one);
            textView=itemView.findViewById(R.id.text_one);
        }
    }
}
