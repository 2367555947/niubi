package com.lyz.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lyz.myapplication.R;
import com.lyz.myapplication.bean.GsonBeans;

import java.util.List;

public class MyAdapters extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private List<GsonBeans.ResultBean> list;
private Context context;

    public MyAdapters(List<GsonBeans.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        RecyclerView.ViewHolder holder=null;
        View view=null;
        view = View.inflate(context, R.layout.item_two, null);
        holder=new ViewHolderTwo(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClick.setOnItemClick(v,i);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        GsonBeans.ResultBean resultBean = list.get(i);
        if(viewHolder instanceof ViewHolderTwo){
            ((ViewHolderTwo) viewHolder).textView.setText(list.get(i).getCommodityName());
            Glide.with(context).load(resultBean.getMasterPic()).into(((ViewHolderTwo) viewHolder).imageView);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderTwo extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text_two);
            imageView=itemView.findViewById(R.id.image_two);
        }
    }
    public interface OnItemClick{
        void setOnItemClick(View view,int position);
    }
    private OnItemClick mOnItemClick;

    public void OnItemClick(OnItemClick mOnItemClick) {
        this.mOnItemClick = mOnItemClick;
    }
}
