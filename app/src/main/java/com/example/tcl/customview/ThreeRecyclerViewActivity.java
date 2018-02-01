package com.example.tcl.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bindviewtool.BindView;
import com.example.bindviewtool.BindViewUtility;
import com.example.tcl.customview.text01.Constants;
import com.example.tcl.customview.text01.Level1Item;
import com.example.tcl.customview.text01.Level2Item;
import com.example.tcl.customview.text01.Level3Item;
import com.example.tcl.customview.text01.MultiItemType;
import com.example.tcl.customview.text01.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreeRecyclerViewActivity extends AppCompatActivity {

    private String TAG = "ThreeRecyclerViewActivity";

    @BindView(R.id.rv)
    RecyclerView mRecyclerView;

    public List<MultiItemType> mList;
    public MyRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_recycler_view);
        BindViewUtility.bind(this);
//        mRecyclerView = findViewById(R.id.rv);
        setTitle("多级item");
        mList = initData();

        initView();

    }

    private void initView() {

        mAdapter = new MyRecyclerViewAdapter(this,mList);
        final GridLayoutManager vLayoutManager = new GridLayoutManager(this, 3);
        vLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                return mAdapter.getItemViewType(position) == Constants.TYPE_LEVEL_3 ? 1 : vLayoutManager.getSpanCount();
            }
        });
        mRecyclerView.setLayoutManager(vLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<MultiItemType> initData() {
        int level1 = 9;
        int level2 = 3;
        int level3 = 5;

        String[] name = {"Bob", "Andy", "Lily", "Brown", "Bruce"};
        Random vRandom = new Random();
        ArrayList<MultiItemType> vList = new ArrayList<>();

        for (int i = 0; i < level1; i++) {
            Level1Item vLevel1Item = new Level1Item("Level1的第" + (i+1) + "个条目", "subTitle of" + i);
            for (int j = 0; j < level2; j++) {
                Level2Item vLevel2Item = new Level2Item("   level2的第" + j + "个条目", "(没有动画)");
                for (int k = 0; k < level3; k++) {
                    vLevel2Item.addSubItem(new Level3Item(name[k], vRandom.nextInt(40)));
                }
                vLevel1Item.addSubItem(vLevel2Item);
            }
            vList.add(vLevel1Item);
        }

        return vList;
    }
}
