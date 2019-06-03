package com.bwei.sunyongzheng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_dong;
    private Button btn_woqu;
    private Button clear_qingkong;
    private TagFlowLayout tagflowlayout;
    private List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

    }

    private void initView() {
        edit_dong = (EditText) findViewById(R.id.edit_dong);
        btn_woqu = (Button) findViewById(R.id.btn_woqu);
        clear_qingkong = (Button) findViewById(R.id.clear_qingkong);
        tagflowlayout = (TagFlowLayout) findViewById(R.id.tagflowlayout);

        btn_woqu.setOnClickListener(this);
        clear_qingkong.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_woqu:
                String trim = edit_dong.getText().toString().trim();
                list.add(trim);
                tagflowlayout.setAdapter(new TagAdapter(list) {
                    @Override
                    public View getView(FlowLayout parent, int position, Object o) {
                        TextView tx = (TextView) LayoutInflater.from(Main2Activity.this).inflate(R.layout.textview, tagflowlayout, false);
                        tx.setText(list.get(position));
                        return tx;
                    }
                });
                break;
            case R.id.clear_qingkong:
                tagflowlayout.removeAllViews();
                list.clear();
                break;
        }
    }

}
