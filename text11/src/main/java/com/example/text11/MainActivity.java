package com.example.text11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bindviewtool.BindView;
import com.example.bindviewtool.BindViewUtility;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rl_001)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindViewUtility.bind(this);

//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mRecyclerView.setLayoutManager(new MyLinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false));
        mRecyclerView.addItemDecoration(new MyItemDecoration(this,MyItemDecoration.VERTICAL_LIST,R.drawable.recyclerview_line));
        mRecyclerView.setAdapter(new MyAdapter());
    }
}
