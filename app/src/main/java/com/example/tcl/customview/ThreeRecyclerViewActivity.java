package com.example.tcl.customview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
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
import com.example.tcl.customview.util.AppUtils;

import java.util.ArrayList;

public class ThreeRecyclerViewActivity extends BaseActivity {

    private String TAG = "ThreeRecyclerViewActivity";
    public ArrayList<MultiItemType> mList;
    public ActionBar mActionBar;

    @BindView(R.id.rv)
    RecyclerView mRecyclerView;

//    public List<MultiItemType> mList;
    public MyRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_recycler_view);
        BindViewUtility.bind(this);
        initActionBar();
        initData();

        initView();

    }

    private void initActionBar() {
        mActionBar = getSupportActionBar();

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

    private void initData() {

        mList = new ArrayList<>();
        initFirstDay();

    }

    private void initFirstDay() {

        Level1Item vLevel1Item = new Level1Item(AppUtils.getString(R.string.android_about));

        Level2Item vLevel2Item1 = addItemNo1();
        vLevel1Item.addSubItem(vLevel2Item1);

        Level2Item vLevel2Item2 = new Level2Item(AppUtils.getString(R.string.service_about));
        vLevel1Item.addSubItem(vLevel2Item2);

        Level2Item vLevel2Item3 = new Level2Item(AppUtils.getString(R.string.content_provider_about));
        vLevel1Item.addSubItem(vLevel2Item3);

        Level2Item vLevel2Item4 = new Level2Item(AppUtils.getString(R.string.broadcast_receiver_about));
        vLevel1Item.addSubItem(vLevel2Item4);
        mList.add(vLevel1Item);
    }

    private Level2Item addItemNo1() {
        Level2Item vLevel2Item1 = new Level2Item(AppUtils.getString(R.string.activity_about));
        Level3Item level3Item1 = new Level3Item(AppUtils.getString(R.string.activity_life_cycle), R.string.life_cycle);
        vLevel2Item1.addSubItem(level3Item1);
        return vLevel2Item1;
    }
}
