package com.lyz.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lyz.myapplication.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class FragmentThree extends Fragment implements View.OnClickListener {
    private EditText edit_text;
    private Button btn_soushuo;
    private TagFlowLayout tagflowlayout;
    private List<String> list=new ArrayList<>();
    private Button btn_shan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmentthree, container, false);
        initView(inflate);
        tagflowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(getContext(),list.get(position),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return inflate;
    }

    private void initView(View inflate) {
        edit_text = (EditText) inflate.findViewById(R.id.edit_text);
        btn_soushuo = (Button) inflate.findViewById(R.id.btn_soushuo);
        tagflowlayout = (TagFlowLayout) inflate.findViewById(R.id.tagflowlayout);

        btn_soushuo.setOnClickListener(this);
        btn_shan = (Button) inflate.findViewById(R.id.btn_shan);
        btn_shan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_soushuo:
                String name = edit_text.getText().toString().trim();
                list.add(name);
                tagflowlayout.setAdapter(new TagAdapter(list) {
                    @Override
                    public View getView(FlowLayout parent, int position, Object o) {
                        TextView tx = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.textview, tagflowlayout, false);
                        tx.setText(list.get(position));
                        return tx;
                    }
                });
                break;
            case R.id.btn_shan:
                tagflowlayout.removeAllViews();
                list.clear();
                break;
        }
    }

}
