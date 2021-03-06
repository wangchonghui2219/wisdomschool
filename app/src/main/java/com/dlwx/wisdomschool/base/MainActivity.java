package com.dlwx.wisdomschool.base;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.MenuItem;

import com.dlwx.baselib.base.BaseActivity;
import com.dlwx.baselib.presenter.Presenter;
import com.dlwx.baselib.view.BottomNavigationViewHelper;
import com.dlwx.wisdomschool.R;
import com.dlwx.wisdomschool.bean.MessageEvent;
import com.dlwx.wisdomschool.fragments.ChatFragment;
import com.dlwx.wisdomschool.fragments.HomeFragment;
import com.dlwx.wisdomschool.fragments.MyFragment;
import com.dlwx.wisdomschool.fragments.RecordFragment;
import com.dlwx.wisdomschool.fragments.WorkFragment;
import com.dlwx.wisdomschool.interfac.SoftKeyBoard;
import com.dlwx.wisdomschool.service.ExampleUtil;
import com.dlwx.wisdomschool.utiles.SpUtiles;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener,SoftKeyBoard.SoftKeyBoardListener{
    @BindView(R.id.bottom_navigation_container)
    BottomNavigationView bottomNavigationContainer;
    private List<Fragment> fragments = new ArrayList<>();
    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sp.edit().putString(SpUtiles.First,"1").commit();
    }

    @Override
    protected void initData() {
//        AmapUtils.initialization(ctx);
        fragments.add(new HomeFragment());
        fragments.add(new WorkFragment());
//        fragments.add(new ClassFragment());
        fragments.add(new RecordFragment());
        fragments.add(new ChatFragment());
        fragments.add(new MyFragment());
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationContainer);
        bottomNavigationContainer.setOnNavigationItemSelectedListener(this);
        changeFragment(0);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) ctx, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_CONTACTS,Manifest.permission.CAMERA
                }, 1002);
        }
    }

    @Override
    protected void initListener() {
        SoftKeyBoard.setSoftKeyBoardListener(this);
    }

    @Override
    protected Presenter createPresenter() {
        return new Presenter(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_home://首页
                changeFragment(0);
                break;
            case R.id.item_work://作业
                changeFragment(1);
                break;
//                 case R.id.item_class://班级
//                changeFragment(2);
//                break;
                 case R.id.item_record://成长纪录
                changeFragment(2);
                break;
                 case R.id.item_chat://聊天
                changeFragment(3);
                break;
                 case R.id.item_my://我的
                changeFragment(4);
                break;
        }
        return true;
    }
    private Fragment fragment;
    private FragmentTransaction transaction;
    private Fragment lastFragment;

    private void changeFragment(int i) {

        transaction = getSupportFragmentManager().beginTransaction();
        // 上一个不为空 隐藏上一个
        if (lastFragment != null&& lastFragment != fragments.get(i)) {
            transaction.hide(lastFragment);
//            transaction.remove(lastFragment);
        }
        fragment = fragments.get(i);
        // fragment不能重复添加 // 添加过 显示 没有添加过 就隐藏
        if (fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.fl_content, fragment);
        }
        transaction.commitAllowingStateLoss();
        lastFragment = fragment;
    }

    @Override
    public void showorhind(int i) {
        bottomNavigationContainer.setVisibility(i);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
    //接收事件
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void fresh(MessageEvent messageEvent) {
//
//        if (messageEvent.b) {
//
//            LogUtiles.LogI("MessageEvent -----------------> MainActivity");
//            Animation animation = AnimationUtils.loadAnimation(ctx, R.anim.out_anim);
//            bottomNavigationContainer.setAnimation(animation);
//        }else{
//            Animation animation = AnimationUtils.loadAnimation(ctx, R.anim.enter_anim);
//            bottomNavigationContainer.setAnimation(animation);
//            wch("huadong");
//        }
    }


    private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";

    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, filter);
    }
    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("wch","接收到了广播");
            try {
                if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                    String messge = intent.getStringExtra(KEY_MESSAGE);
                    String extras = intent.getStringExtra(KEY_EXTRAS);
                    StringBuilder showMsg = new StringBuilder();
                    showMsg.append(KEY_MESSAGE + " : " + messge + "\n");
                    if (!ExampleUtil.isEmpty(extras)) {
                        showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
                    }

                }
            } catch (Exception e){
            }
        }
    }
}
