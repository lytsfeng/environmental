package com.ldkj.environmental.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class EnvReceiver extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        String _Action = intent.getAction();

        if(WifiManager.WIFI_STATE_CHANGED_ACTION.equals(_Action)){
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
            switch (wifiState) {
                case WifiManager.WIFI_STATE_DISABLED:
                    //关闭网络连接
                    Log.e("log","WIFI_STATE_DISABLED");
                    break;
                case WifiManager.WIFI_STATE_DISABLING:
                    Log.e("log","WIFI_STATE_DISABLING");
                    break;
                case WifiManager.WIFI_STATE_ENABLED:
                    //检查是否可以连接到服务器，
                    Log.e("log","WIFI_STATE_ENABLED");
                    break;
                case WifiManager.WIFI_STATE_ENABLING:
                    Log.e("log","WIFI_STATE_ENABLING");
                    break;
                case WifiManager.WIFI_STATE_UNKNOWN:
                    Log.e("log","WIFI_STATE_UNKNOWN");
                    break;
            }
        }else if(SMS_RECEIVED.equalsIgnoreCase(_Action)){
            Bundle bundle = intent.getExtras();
            Object messages[] = (Object[]) bundle.get("pdus");
            SmsMessage smsMessage[] = new SmsMessage[messages.length];

            if(true){  //检查号码是否为 站的号码
                StringBuffer _Buffer = new StringBuffer();
                for (int n = 0; n < messages.length; n++) {
                    smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
                    //获取短信地址
                  String address =   smsMessage[n].getOriginatingAddress();

                    _Buffer.append(smsMessage[n].getMessageBody());
                }
                String _MsgBody = _Buffer.toString();
                _Buffer.reverse();
                Log.e("log",_MsgBody);
            }

        }else if(WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(_Action)){ //判断网络状态  此处不使用
            Parcelable parcelableExtra = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            if (null != parcelableExtra) {
                NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                boolean isConnected = networkInfo.isAvailable();
                Log.i("log","NETWORK_STATE_CHANGED_ACTION  "+ isConnected);
            }
        }

    }
}
