package com.dlwx.wisdomschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dlwx.baselib.base.BaseFastAdapter;
import com.dlwx.wisdomschool.R;

/**
 * Created by Administrator on 2017/12/22/022.
 */

public class FamialyRegisterItemAdpter extends BaseFastAdapter {
    public FamialyRegisterItemAdpter(Context ctx) {
        super(ctx);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_famialyregisteritem, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    private class ViewHolder {
        public View rootView;
        public TextView tv_conten;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_conten = (TextView) rootView.findViewById(R.id.tv_conten);
        }

    }
}
