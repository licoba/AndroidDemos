package com.licoba.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyBroadcastListener {

    private MyBroadcastReceiver receiver;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new MyBroadcastReceiver(this);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextTextPersonName);
        //设置接收广播的类型
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.licoba.action.CUSTOM_MSG");
        registerReceiver(receiver,intentFilter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.licoba.action.CUSTOM_MSG");
                intent.setPackage("com.licoba.broadcastreceiver");
                intent.putExtra("msg", editText.getText().toString());
                sendBroadcast(intent);
            }
        });
    }


    @Override
    public void doSomething(String value) {
        Toast.makeText(MainActivity.this, "MainActivity弹窗：\n"+value, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}