package com.huarenkeji.china_push.receiver;

import android.os.Bundle;

import com.huarenkeji.china_push.PushManager;
import com.huarenkeji.china_push.util.Logger;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;

public class HmsPushMessageReceiver extends HmsMessageService {

    private static final String TAG = "HmsPushMessageReceiver";

    @Override
    public void onNewToken(String token, Bundle bundle) {
        super.onNewToken(token, bundle);
        Logger.i("onNewToken token : " + token + " bundle ： " + bundle);

    }

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Logger.i("onNewToken token : " + token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Logger.i("HmsPushMessageReceiver onMessageReceived");

        if (remoteMessage == null) {
            Logger.i("Received message entity is null!");
            return;
        }

        if (remoteMessage.getDataOfMap() != null) {
            PushManager.onMessageReceived(remoteMessage.getDataOfMap());
        }
    }
}
