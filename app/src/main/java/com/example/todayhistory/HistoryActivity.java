package com.example.todayhistory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todayhistory.adapter.TimelineListAdapter;
import com.example.todayhistory.bean.HistoryBean;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {

    List<HistoryBean.ResultBean> mData;
    private ImageView mBackIv;
    private TextView mNullTv;
    private ListView mHistoryLv;
    private TimelineListAdapter mTimelineListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mBackIv = findViewById(R.id.history_back_iv);
        mNullTv = findViewById(R.id.history_null_tv);
        mHistoryLv = findViewById(R.id.history_lv);

        mBackIv.setOnClickListener(this);

        mData = new ArrayList<>();
        mTimelineListAdapter = new TimelineListAdapter(this, mData);
        mHistoryLv.setAdapter(mTimelineListAdapter);

        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            HistoryBean history = (HistoryBean) bundle.getSerializable("history");
            mData.addAll(history.getResult());
            mTimelineListAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
            mNullTv.setVisibility(View.VISIBLE);
        }

        mHistoryLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HistoryActivity.this, HistoryDetailActivity.class);
                intent.putExtra("history_id", mData.get(i).getE_id());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.history_back_iv:
                finish();
                break;
        }
    }
}