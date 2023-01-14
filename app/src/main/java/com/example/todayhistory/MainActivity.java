package com.example.todayhistory;

import static com.example.todayhistory.utils.DateUtils.getDate;
import static com.example.todayhistory.utils.DateUtils.getDay;
import static com.example.todayhistory.utils.DateUtils.getMonth;
import static com.example.todayhistory.utils.DateUtils.getWeekName;
import static com.example.todayhistory.utils.DateUtils.getYear;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.todayhistory.adapter.TimelineListAdapter;
import com.example.todayhistory.bean.HistoryBean;
import com.example.todayhistory.bean.LaoHuangLiBean;
import com.example.todayhistory.common.BaseActivity;
import com.example.todayhistory.common.URLHelper;
import com.example.todayhistory.utils.DateUtils;
import com.google.gson.Gson;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private TextView mYangliTextView;
    private TextView mDayTextView;
    private TextView mWeekTextView;
    private TextView mNongliTextView;
    private TextView mBaijiTextView, mWuxingTextView, mChongshaTextView;
    private TextView mJishenTextView, mXiongshenTextView;
    private TextView mYiTextView, mJiTextView;
    private ListView mListView;
    private ImageButton mImageButton;

    private List<HistoryBean.ResultBean> mData;
    private TimelineListAdapter mAdapter;

    private Date mDate;
    private HistoryBean mHistoryBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDate = new Date();

        mListView = findViewById(R.id.main_lv);
        mImageButton = findViewById(R.id.main_calendar_imgbtn);
        mImageButton.setOnClickListener(this);

        mData = new ArrayList<>();
        mAdapter = new TimelineListAdapter(this, mData);
        mListView.setAdapter(mAdapter);

        addHeaderAndFooterView();

        String url = URLHelper.getTodayHistoryURL(DateUtils.getMonth(mDate), DateUtils.getDay(mDate));
        Log.i(TAG, "onCreate: " + url);

        loadData(url);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, HistoryDetailActivity.class);
                intent.putExtra("history_id", mData.get(i).getE_id());
                startActivity(intent);
            }
        });
    }

    private void addHeaderAndFooterView() {
        View headerView = LayoutInflater.from(this).inflate(R.layout.activity_main_header, null);
        initHeaderView(headerView);
        mListView.addHeaderView(headerView);

        View footerView = LayoutInflater.from(this).inflate(R.layout.activity_main_footer, null);
        footerView.setTag("footer");
        footerView.setOnClickListener(this);
        mListView.addFooterView(footerView);
    }

    private void initHeaderView(View headerView) {
        mYangliTextView = headerView.findViewById(R.id.main_header_yangli_tv);
        mDayTextView = headerView.findViewById(R.id.main_header_day_tv);
        mWeekTextView = headerView.findViewById(R.id.main_header_week_tv);
        mNongliTextView = headerView.findViewById(R.id.main_header_nongli_tv);
        mBaijiTextView = headerView.findViewById(R.id.main_header_baiji_tv);
        mWuxingTextView = headerView.findViewById(R.id.main_header_wuxing_tv);
        mChongshaTextView = headerView.findViewById(R.id.main_header_chongsha_tv);
        mJishenTextView = headerView.findViewById(R.id.main_header_jishen_tv);
        mXiongshenTextView = headerView.findViewById(R.id.main_header_xiongshen_tv);
        mYiTextView = headerView.findViewById(R.id.main_header_yi_tv);
        mJiTextView = headerView.findViewById(R.id.main_header_ji_tv);

        String url = URLHelper.getLaoHuangLiURL(getDate(mDate, "yyyy-MM-dd"));
        Log.i(TAG, "initHeaderView: " + url);

        loadHeaderData(url);
    }

    private void loadHeaderData(String url) {
        RequestParams params = new RequestParams(url);
        x.http().get(params, new CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                LaoHuangLiBean laoHuangLiBean = new Gson().fromJson(result, LaoHuangLiBean.class);
                if (laoHuangLiBean.getError_code() != 0) {
                    Log.e(TAG, "onSuccess: " + laoHuangLiBean.getReason());
                    return;
                }

                LaoHuangLiBean.ResultBean resultBean = laoHuangLiBean.getResult();

                Date date = getDate(resultBean.getYangli(), "yyyy-MM-dd");
                int year = getYear(date);
                int month = getMonth(date);
                int day = getDay(date);
                String week = getWeekName(date);

                mYangliTextView.setText("公历 " + year + " 年 " + month + " 月 " + day + " 日 " + week + "（阳历）");
                mDayTextView.setText("" + day);
                mWeekTextView.setText("" + week);
                mNongliTextView.setText("农历 " + resultBean.getYinli() + "（阴历）");
                mBaijiTextView.setText("彭祖百忌：" + resultBean.getBaiji());
                mWuxingTextView.setText("五行：" + resultBean.getWuxing());
                mChongshaTextView.setText("冲煞：" + resultBean.getChongsha());
                mJishenTextView.setText("吉神宜趋：" + resultBean.getJishen());
                mXiongshenTextView.setText("凶神宜忌：" + resultBean.getXiongshen());
                mYiTextView.setText("宜：" + resultBean.getYi());
                mJiTextView.setText("忌：" + resultBean.getJi());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                try {
                    throw ex;
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    @Override
    public void onSuccess(String result) {
        mData.clear();

        mHistoryBean = new Gson().fromJson(result, HistoryBean.class);
        if (mHistoryBean.getError_code() != 0) {
            Log.e(TAG, "onSuccess: " + mHistoryBean.getReason());
            return;
        }

        List<HistoryBean.ResultBean> resultBeanList = mHistoryBean.getResult();
        for (int i = 0; i < 5; i++) {
            mData.add(resultBeanList.get(i));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        try {
            throw ex;
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.main_calendar_imgbtn) {
            popCalendarDialog();
        } else if (view.getTag().equals("footer")) {
            Intent intent = new Intent(this, HistoryActivity.class);
            if (mHistoryBean != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("history", mHistoryBean);
                intent.putExtras(bundle);
            }
            startActivity(intent);
        }
    }

    private void popCalendarDialog() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                mDate = getDate(i + "-" + (i1 + 1) + "-" + i2, "yyyy-MM-dd");

                String url = URLHelper.getLaoHuangLiURL(getDate(mDate, "yyyy-MM-dd"));
                Log.i(TAG, "onDateSet: " + url);
                loadHeaderData(url);

                url = URLHelper.getTodayHistoryURL(i1 + 1, i2);
                Log.i(TAG, "onDateSet: " + url);
                loadData(url);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }
}