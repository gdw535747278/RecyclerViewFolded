package com.example.tcl.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bindviewtool.BindView;
import com.example.bindviewtool.BindViewUtility;
import com.example.tcl.customview.util.MyAdapter;
import com.example.tcl.customview.util.MyBean;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    @BindView(R.id.recycler_001)
    RecyclerView R_id_recycler_001;

    public ArrayList<MyBean> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindViewUtility.bind(this);


        mList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {

            MyBean vMyBean = new MyBean();
            vMyBean.setStr("第" + (i + 1) + "个条目");
            mList.add(vMyBean);
        }
//        R_id_recycler_001 = findViewById(R.id.recycler_001);
        R_id_recycler_001.setLayoutManager(new LinearLayoutManager(Main4Activity.this));
        MyAdapter vMyAdapter = new MyAdapter(mList);
        R_id_recycler_001.setAdapter(vMyAdapter);
    }

    private String changeNumber(int num) {
        int preNum = num / 10000;
        int endNum = (num % 10000) / 1000;
        return String.valueOf(preNum + "." + endNum + "w");
    }
}
