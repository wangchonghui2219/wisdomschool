package com.dlwx.wisdomschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dlwx.baselib.base.BaseFastAdapter;
import com.dlwx.wisdomschool.R;
import com.dlwx.wisdomschool.utiles.CityJson;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18/018.
 */

public class CityListAdapter1 extends BaseFastAdapter {
    private List<CityJson.SanJiLianDBean.CityList> citylist;
    private int pos;
    public CityListAdapter1(Context ctx,List<CityJson.SanJiLianDBean.CityList> citylist) {
        super(ctx);
        this.citylist = citylist;
    }

    @Override
    public int getCount() {
        return citylist.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_str, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        if (position == pos) {
            vh.rootView.setBackgroundColor(ctx.getResources().getColor(R.color.white));
        }else{
            vh.rootView.setBackgroundColor(ctx.getResources().getColor(R.color.gary));
        }
        vh.tv_name.setText(citylist.get(position).getP());
        return convertView;
    }
    public void setPos(int pos){
        this.pos = pos;
        notifyDataSetChanged();
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
