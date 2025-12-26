
package com.huarenkeji.china_push.callback;

import java.util.Map;

public interface OnMessageReceivedListener {
    void onMessageReceived(Map<String, String> data);
}