package com.licoba.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

// 自己定义的广播接收器
public class MyBroadcastReceiver extends BroadcastReceiver {

    private final String TAG = "MyBroadcastReceiver";
    private MyBroadcastListener listener;

    public MyBroadcastReceiver() {
        Log.e(TAG, "自己this空参：" + this);
    }

    public MyBroadcastReceiver(MyBroadcastListener listener) {
        Log.e(TAG, "listener类型：" + listener);
        this.listener = listener;
        Log.e(TAG, "自己this：" + this);
    }

    // 需要实现onReceive方法
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "收到消息, context类型：" + context);
        StringBuilder sb = new StringBuilder();
        sb.append("Action: " + intent.getAction());
        sb.append("\nExtra: " + intent.getStringExtra("msg"));
//        sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
        String log = sb.toString();
        Log.e(TAG, log);
        Log.e(TAG, "自己this：" + this);
        listener.doSomething(log);
        Toast.makeText(context, "MyBroadcastReceiver 弹窗：\n"+log, Toast.LENGTH_SHORT).show();
    }


}