package com.dlwx.wisdomschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dlwx.baselib.base.BaseFastAdapter;
import com.dlwx.baselib.view.CircleImageView;
import com.dlwx.wisdomschool.R;

/**
 * Created by Administrator on 2017/12/29/029.
 */

public class FriendListAdapter extends BaseFastAdapter {
    public FriendListAdapter(Context ctx) {
        super(ctx);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_frendlist, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    private class ViewHolder {
        public View rootView;
        public CircleImageView iv_head;
        public TextView tv_name;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_head = (CircleImageView) rootView.findViewById(R.id.iv_head);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        }

    }
}
