package com.lyz.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyz.myapplication.R;
import com.lyz.myapplication.bean.GsonBean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GsonBean.ResultBean>list;
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
        view=View.inflate(context,R.layout.item_one,null);
        holder=new ViewHolderOne(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        GsonBean.ResultBean resultBean = list.get(i);
        if(viewHolder instanceof ViewHolderOne){
            ((ViewHolderOne) viewHolder).textView.setText(list.get(i).getName());
            ((ViewHolderOne) viewHolder).textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    monItemClick.setOnItemClick(v,i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolderOne extends RecyclerView.ViewHolder{
        private TextView textView;
        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
           textView=itemView.findViewById(R.id.text_one);
        }
    }
    public interface OnItemClick{
        void setOnItemClick(View view,int position);
    }
    private OnItemClick monItemClick;
    public void setOnItemClick(OnItemClick onItemClick){
        this.monItemClick=onItemClick;
    }
}
