package com.example.demo.frame.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.AdapterView;

import com.common.adapter.base.CommonAdapter;
import com.common.adapter.base.ViewHolder;
import com.common.bean.base.BaseJson;
import com.common.download.autoupdate.AutoUpdateService;
import com.common.engine.interf.IDialogBtnDefaultCallBack;
import com.common.prompt.BaseDialog;
import com.common.prompt.DefaultDialog;
import com.common.ui.base.activity.BaseActivity;
import com.common.utils.JsonUtils;
import com.common.utils.Logger;
import com.common.utils.ResUtils;
import com.common.utils.ScreenUtils;
import com.common.utils.StartActUtils;
import com.common.utils.ViewUtils;
import com.common.view.textview.expandable.ExpandableTextView;
import com.example.demo.R;
import com.example.demo.frame.bean.TestBean;
import com.example.localinterface.JsonReader;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Demo_MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {


    public static final String TAG = "Demo_MainActivity";
    PullToRefreshListView listView;
    private List list;
    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            AutoUpdateService.MyBinder binder = (AutoUpdateService.MyBinder) service;
            AutoUpdateService bindService = binder.getService();
            bindService.dialogBuilder();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_main);
        init();
        bindService(new Intent(this, AutoUpdateService.class), conn, BIND_AUTO_CREATE);
    }

    void init() {
        listView = ViewUtils.findViewById(this, R.id.lv_pull_to_refresh);
        listView.setMode(PullToRefreshBase.Mode.DISABLED);
        list = new ArrayList();
        list.addAll(JsonUtils.parseToObjectList(JsonUtils.parseToObjectBean(ResUtils.getFileFromAssets(JsonReader.CUSTOM_JSON_FOLDER + File.separator + "test_list_main_json.txt"), BaseJson.class).getData(), TestBean.class));
        listView.setAdapter(new CommonAdapter<TestBean>(this, list, R.layout.test_list_item) {
            @Override
            public void convert(ViewHolder holder, TestBean bean) {
                ((ExpandableTextView) holder.getView(R.id.expand_text_view)).setText(bean.getDesc());
                holder.setText(R.id.tv_name, bean.getName());
            }
        });
        listView.setOnItemClickListener(this);
        Logger.i(TAG, ScreenUtils.getScreenWidth(this) + ":" + ScreenUtils.getScreenHeight(this));
        Logger.i(TAG, ResUtils.getFileFromAssets(JsonReader.CUSTOM_JSON_FOLDER + File.separator + "test_list_main_json.txt") + "");
    }


    @Override
    protected String setActionBarTitle() {
        return "主界面";
    }

    /**
     * 返回操作 子类可以覆盖此方法做特殊业务
     */
    protected void actionBack() {
        exitApp();
    }

    @Override
    public void onBackPressed() {
        exitApp();
    }

    /**
     * 退出App
     */
    private void exitApp() {
        new DefaultDialog(this, new IDialogBtnDefaultCallBack() {
            @Override
            public void liftBtnOnClickListener(BaseDialog promptDialog, View v, int callBackTag) {
                promptDialog.dismiss();
            }

            @Override
            public void rightBtnOnClickListener(BaseDialog promptDialog, View v, int callBackTag) {
                promptDialog.dismiss();
                StartActUtils.finish(Demo_MainActivity.this);
            }
        }).getContent().setText("您确定要离开本应用吗?");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        StartActUtils.startForAbsolutePath(Demo_MainActivity.this, ((TestBean) list.get(position - 1)).getActivityPath());
    }
}