package com.dlwx.wisdomschool.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dlwx.baselib.base.BaseRecrviewAdapter;
import com.dlwx.wisdomschool.R;

/**
 * Created by Administrator on 2017/12/25/025.
 */

public class AddLableAdapter extends BaseRecrviewAdapter {
    public AddLableAdapter(Context ctx) {
        super(ctx);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_addlable, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_name;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        }

    }
}
