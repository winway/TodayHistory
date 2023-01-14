package com.example.todayhistory.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.todayhistory.R;
import com.example.todayhistory.bean.HistoryBean;

import java.util.List;

/**
 * @PackageName: com.example.todayhistory.adapter
 * @ClassName: TimelineListAdapter
 * @Author: winwa
 * @Date: 2023/1/12 7:59
 * @Description:
 **/
public class TimelineListAdapter extends BaseAdapter {
    private Context mContext;
    private List<HistoryBean.ResultBean> mData;

    public TimelineListAdapter(Context context, List<HistoryBean.ResultBean> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item_main_timeline, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        HistoryBean.ResultBean currentItem = mData.get(i);
        HistoryBean.ResultBean lastItem = i > 0 ? mData.get(i - 1) : null;

        if (lastItem != null && currentItem.getDate().equals(lastItem.getDate())) {
            holder.mHeaderLinearLayout.setVisibility(View.GONE);
        } else {
            holder.mHeaderLinearLayout.setVisibility(View.VISIBLE);
            holder.mTimeTextView.setText(currentItem.getDate());
        }

        holder.mTitleTextView.setText(currentItem.getTitle());
        holder.mPicImageView.setVisibility(View.GONE);

        return view;
    }

    class ViewHolder {
        TextView mTimeTextView;
        TextView mTitleTextView;
        ImageView mPicImageView;
        LinearLayout mHeaderLinearLayout;

        public ViewHolder(View view) {
            mTimeTextView = view.findViewById(R.id.main_timeline_time_tv);
            mTitleTextView = view.findViewById(R.id.main_timeline_title_tv);
            mPicImageView = view.findViewById(R.id.main_timeline_picture_iv);
            mHeaderLinearLayout = view.findViewById(R.id.main_timeline_header_ll);
        }
    }
}
