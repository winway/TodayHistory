package com.example.todayhistory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private LinearLayout mPicLl;
    private TextView mContentTv;

    private HistoryDetailBean.ResultBean resultBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);

        mBackIv = findViewById(R.id.history_detail_back_iv);
        mShareIv = findViewById(R.id.history_detail_share_iv);
        mTitleTv = findViewById(R.id.history_detail_title_tv);
        mPicLl = findViewById(R.id.history_detail_pic_ll);
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
        Log.i(TAG, "onSuccess: " + picNo);
        if (picNo > 0) {
            mPicLl.removeAllViews();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 280);
            params.setMargins(10, 10, 10, 10);
            for (int i = 0; i < picNo; i++) {
                String picUrl = resultBean.getPicUrl().get(i).getUrl();
                Log.i(TAG, "onSuccess: " + picNo + " " + picUrl);
                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(params);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(this).load(picUrl).into(imageView);
                mPicLl.addView(imageView);
            }
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