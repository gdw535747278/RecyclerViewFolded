package com.example.tcl.customview.util;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bindviewtool.BindView;
import com.example.tcl.customview.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.recycler_001)
    RecyclerView R_id_recycler_001;

    public ArrayList<MyBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        BindViewUtility.bind(this);
        mList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {

            MyBean vMyBean = new MyBean();
            vMyBean.setStr("第" + (i + 1) + "个条目");
            mList.add(vMyBean);
        }
        R_id_recycler_001 = findViewById(R.id.recycler_001);
        R_id_recycler_001.setLayoutManager(new LinearLayoutManager(Main2Activity.this));
        MyAdapter vMyAdapter = new MyAdapter(mList);
        R_id_recycler_001.setAdapter(vMyAdapter);

//        mView.setit

        /*mView.setItemAnimator(new RecyclerView.ItemAnimator() {
            @Override
            public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull ItemHolderInfo preLayoutInfo, @Nullable ItemHolderInfo postLayoutInfo) {
                return false;
            }

            @Override
            public boolean animateAppearance(@NonNull RecyclerView.ViewHolder viewHolder, @Nullable ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
                return false;
            }

            @Override
            public boolean animatePersistence(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
                return false;
            }

            @Override
            public boolean animateChange(@NonNull RecyclerView.ViewHolder oldHolder, @NonNull RecyclerView.ViewHolder newHolder, @NonNull ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
                return false;
            }

            @Override
            public void runPendingAnimations() {

            }

            @Override
            public void endAnimation(RecyclerView.ViewHolder item) {

            }

            @Override
            public void endAnimations() {

            }

            @Override
            public boolean isRunning() {
                return false;
            }
        });*/
    }
}
