package com.dlwx.wisdomschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dlwx.baselib.base.BaseFastAdapter;
import com.dlwx.wisdomschool.R;
import com.dlwx.wisdomschool.bean.AllXuekeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19/019.
 */

public class YearAllStuAnalyzeAdapter extends BaseFastAdapter {
    private List<AllXuekeBean.BodyBean> body;
    public YearAllStuAnalyzeAdapter(Context ctx,List<AllXuekeBean.BodyBean> body) {
        super(ctx);
        this.body = body;
    }

    @Override
    public int getCount() {
        return body.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_allsubject, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();

        }
        AllXuekeBean.BodyBean bodyBean = body.get(position);
        vh.tv_name.setText(bodyBean.getXueke_name());
        return convertView;
    }

    private class ViewHolder {
        public View rootView;
        public TextView tv_name;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        }

    }
}
