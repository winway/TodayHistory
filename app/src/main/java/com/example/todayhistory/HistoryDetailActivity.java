package com.example.todayhistory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.todayhistory.bean.HistoryDetailBean;
import com.example.todayhistory.common.BaseActivity;
import com.example.todayhistory.common.URLHelper;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class HistoryDetailActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "HistoryDetailActivity";

    private ImageView mBackIv;
    private ImageView mShareIv;
    private TextView mTitleTv;
    private ImageView mPicIv;
    private TextView mContentTv;

    private HistoryDetailBean.ResultBean resultBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);

        mBackIv = findViewById(R.id.history_detail_back_iv);
        mShareIv = findViewById(R.id.history_detail_share_iv);
        mTitleTv = findViewById(R.id.history_detail_title_tv);
        mPicIv = findViewById(R.id.history_detail_pic_iv);
        mContentTv = findViewById(R.id.history_detail_content_tv);

        mBackIv.setOnClickListener(this);
        mBackIv.setOnClickListener(this);

        String historyId = getIntent().getStringExtra("history_id");
        String url = URLHelper.getHistoryDetailURL(historyId);
        Log.i(TAG, "onCreate: " + url);
        loadData(url);
    }

    @Override
    public void onSuccess(String result) {
        HistoryDetailBean historyDetailBean = new Gson().fromJson(result, HistoryDetailBean.class);
        resultBean = historyDetailBean.getResult().get(0);
        mTitleTv.setText(resultBean.getTitle());
        Integer picNo = Integer.valueOf(resultBean.getPicNo());
        String picUrl = resultBean.getPicUrl().get(0).getUrl();
        if (picNo > 0) {
            mPicIv.setVisibility(View.VISIBLE);
            Picasso.with(this).load(picUrl).into(mPicIv);
        } else {
            mPicIv.setVisibility(View.GONE);
        }
        mContentTv.setText(resultBean.getContent());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.history_detail_back_iv:
                finish();
                break;
            case R.id.history_detail_share_iv:
                String text = "我发现一款软件";
                if (resultBean != null) {
                    text = "发现历史" + resultBean.getTitle();
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(intent, "历史上的今天"));
                }
                break;
        }
    }
}