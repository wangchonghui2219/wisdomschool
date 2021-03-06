package com.dlwx.wisdomschool.fragments;


import android.view.View;
import android.widget.ListView;

import com.dlwx.baselib.base.BaseFragment;
import com.dlwx.baselib.presenter.Presenter;
import com.dlwx.wisdomschool.R;
import com.dlwx.wisdomschool.adapter.FamialyRegisterAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 家访纪录汇总
 */
public class FamialyRegisterFragment extends BaseFragment {
    @BindView(R.id.lv_list)
    ListView lvList;
    Unbinder unbinder;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    protected void initDate() {
        lvList.setAdapter(new FamialyRegisterAdapter(ctx));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected Presenter createPresenter() {
        return new Presenter(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
