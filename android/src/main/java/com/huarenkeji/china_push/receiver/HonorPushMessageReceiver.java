package com.huarenkeji.china_push.receiver;

import com.hihonor.push.sdk.HonorMessageService;
import com.hihonor.push.sdk.HonorPushDataMsg;
import com.huarenkeji.china_push.PushManager;
import com.huarenkeji.china_push.core.HonorPushInterface;
import com.huarenkeji.china_push.util.Logger;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HonorPushMessageReceiver extends HonorMessageService {
    //Token发生变化时，会以onNewToken方法返回
    @Override
    public void onNewToken(String pushToken) {
        Logger.i("onNewToken pushToken:" + pushToken);
        PushManager.onRegisterSuccess(pushToken, HonorPushInterface.MANUFACTURER);
    }

    @Override
    public void onMessageReceived(HonorPushDataMsg msg) {
        Logger.i("onMessageReceived msg:" + msg.getData());
        if (msg != null && msg.getData() != null) {
            try {
                // 假设透传消息是 JSON 字符串
                JSONObject json = new JSONObject(msg.getData());
                Map<String, String> map = new HashMap<>();
                Iterator<String> keys = json.keys();
                while(keys.hasNext()) {
                    String key = keys.next();
                    map.put(key, json.optString(key));
                }
                PushManager.onMessageReceived(map);
            } catch (Exception e) {
                Logger.e("Honor onMessageReceived parse error: " + e.getMessage());
            }
        }
    }



}
