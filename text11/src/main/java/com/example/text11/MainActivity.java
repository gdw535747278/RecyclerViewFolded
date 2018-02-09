package com.example.text11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bindviewtool.BindView;
import com.example.bindviewtool.BindViewUtility;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<MyBean> mList;
    @BindView(R.id.rl_001)
    RecyclerView mRecyclerView;

  /*  @BindView(R.id.bottom001)
    public View mView;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindViewUtility.bind(this);

        mList = new ArrayList<>();

        initData();
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mRecyclerView.setLayoutManager(new MyLinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false));
        mRecyclerView.addItemDecoration(new MyItemDecoration(this,MyItemDecoration.VERTICAL_LIST,R.drawable.recyclerview_line));
        mRecyclerView.setAdapter(new MyAdapter(this,mList));
    }

    private void initData() {
        mList.add(new MyBean("弹窗1", 001));
        mList.add(new MyBean("弹窗2", 002));
    }
}
