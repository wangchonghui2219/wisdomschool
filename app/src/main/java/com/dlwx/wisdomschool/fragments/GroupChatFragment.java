package com.dlwx.wisdomschool.fragments;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.dlwx.baselib.base.BaseFragment;
import com.dlwx.baselib.presenter.Presenter;
import com.dlwx.wisdomschool.R;
import com.dlwx.wisdomschool.activitys.ChatActivity;
import com.dlwx.wisdomschool.activitys.CreateClassActivity;
import com.dlwx.wisdomschool.adapter.GroupChatListAdapter;
import com.dlwx.wisdomschool.bean.GroupList;
import com.dlwx.wisdomschool.listener.ListenerUtile;
import com.dlwx.wisdomschool.utiles.HttpUrl;
import com.google.gson.Gson;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.easeui.EaseConstant;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.dlwx.wisdomschool.base.MyApplication.Token;

/**
 * 群聊
 */
public class GroupChatFragment extends BaseFragment {
    @BindView(R.id.btn_creategroup)
    Button btnCreategroup;
    @BindView(R.id.ll_entry)
    LinearLayout llEntry;
    @BindView(R.id.ll_addgroup)
    LinearLayout llAddgroup;
    @BindView(R.id.lv_list)
    ListView lvList;
    @BindView(R.id.ll_noentry)
    LinearLayout llNoentry;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    Unbinder unbinder;
    private List<GroupList.BodyBean> body;


    @Override
    public int getLayoutID() {
        return R.layout.fragment_group_chat;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    protected void initDate() {
//        lvList.setGroupIndicator(this.getResources().getDrawable(R.drawable.expandablelistviewselector));
        initrefresh(refreshLayout, true);
        llEntry.setVisibility(View.VISIBLE);
        llNoentry.setVisibility(View.GONE);
    }

    @Override
    public void downOnRefresh() {
        Map<String, String> map = new HashMap<>();
        map.put("token", Token);
        mPreenter.fetch(map, true, HttpUrl.Grouplist, HttpUrl.Grouplist + Token);
    }

    @Override
    public void onResume() {
        Map<String, String> map = new HashMap<>();
        map.put("token", Token);
        mPreenter.fetch(map, true, HttpUrl.Grouplist, HttpUrl.Grouplist + Token);
        ListenerUtile.setGroupChatUnReadListener(new ListenerUtile.GroupChatUnReadListener() {
            @Override
            public void groupChatList() {
                handler.sendEmptyMessage(1);
            }
        });
        super.onResume();
    }

    @Override
    public void onPause() {
        ListenerUtile.groupChatUnReadListener = null;
        super.onPause();
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Map<String, String> map = new HashMap<>();
            map.put("token", Token);
            mPreenter.fetch(map, true, HttpUrl.Grouplist, HttpUrl.Grouplist + Token);
        }
    };
    @Override
    protected void initListener() {
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                EaseConstant.EXTRA_USER_ID = grouplist.get(position).getGroupId();
                Intent intent = new Intent(ctx, ChatActivity.class);
                intent.putExtra(EaseConstant.EXTRA_USER_ID, body.get(position).getGroupid());
                intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_GROUP);
                intent.putExtra("title", body.get(position).getGroup_name());
                intent.putExtra("classid", body.get(position).getClassid());
                startActivity(intent);
                try {
                    EMConversation conversation = EMClient.getInstance().chatManager().getConversation(body.get(position).getGroupid());
//指定会话消息未读数清零
                    conversation.markAllMessagesAsRead();
                } catch (Exception e) {
                    wch(e.getMessage());
                }

            }
        });
    }

    @Override
    protected Presenter createPresenter() {
        return new Presenter(this);
    }

    @Override
    public void showData(String s) {
        disLoading();
        wch(s);
        Gson gson = new Gson();
        GroupList groupList = gson.fromJson(s, GroupList.class);
        if (groupList.getCode() == 200) {
            body = groupList.getBody();
            if (body.size() > 0) {
                llNoentry.setVisibility(View.VISIBLE);
                llEntry.setVisibility(View.GONE);
            } else {
                llNoentry.setVisibility(View.GONE);
                llEntry.setVisibility(View.VISIBLE);
            }
            lvList.setAdapter(new GroupChatListAdapter(ctx, body));


        } else {
            Toast.makeText(ctx, groupList.getResult(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_creategroup, R.id.ll_addgroup})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_creategroup:
                intent = new Intent(ctx, CreateClassActivity.class);
                intent.putExtra("type", "cheatgroup");
                startActivity(intent);
                break;
            case R.id.ll_addgroup:
                intent = new Intent(ctx, CreateClassActivity.class);
                intent.putExtra("type", "cheatgroup");
                startActivity(intent);
                break;
        }
    }
}
