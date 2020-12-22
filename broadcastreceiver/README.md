# 广播接收器 BroadcastReceiver

## 注册步骤

应用可以通过两种方式接收广播：`清单声明的接收器`和 `上下文注册的接收器`


清单声明的接收器 也就是在menifest文件里面进行声明


上下文注册的接收器  也就是在代码里面用context进行声明

![](https://pic.downk.cc/item/5fe1b5453ffa7d37b35965a3.jpg)

### 一、静态注册

显式在menifest文件里面进行注册

1. 首先创建 MyBroadcastReceiver 继承自 BroadcastReceiver，然后实现他的 onReceive() 方法
2. 在menifest文件里面的<application>标签下，用<receiver>标签来声明自己注册的receiver

```
<receiver
    android:name=".MyBroadcastReceiver"
    android:enabled="true"
    android:exported="true">
    <intent-filter>
        <action android:name="android.intent.action.BOOT_COMPLETED" />
        <action android:name="android.intent.action.INPUT_METHOD_CHANGED" />
        <action android:name="android.intent.action.LOCALE_CHANGED" />
        <action android:name="com.licoba.action.CUSTOM_MSG" />
    </intent-filter>
</receiver>
```


**静态注册广播的特点是：广播常驻后台，不会随着其他组件的消亡而变化。这样的话不仅占用内存，而且会增加应用的耗电量。**


### 二、 动态注册

`registerReceiver(mBroadcastReceiver, intentFilter);` 和 `unregisterReceiver(mBroadcastReceiver);`方法，成对调用就可以了`


**对于动态广播，有注册就必然得有注销，否则会导致内存泄露**
