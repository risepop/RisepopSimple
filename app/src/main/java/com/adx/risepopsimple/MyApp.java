package com.adx.risepopsimple;

import android.app.Application;

import androidx.annotation.Nullable;

import com.risepop.adx.adxcore.api.RSOpenSDK;
import com.risepop.adx.adxcore.api.RSSDKInitListener;
import com.risepop.adx.adxcore.base.ErrorMsg;
import com.risepop.adx.adxcore.utils.RSSDKLog;

public class MyApp extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
        RSOpenSDK.init(this, "APP250401A7B3C9D2", "f47ac10b-58cc-4372-a567-0e02b2c3d479");
        //打开测试模式 输出debug日志
        RSOpenSDK.setDebugMode(true);
        RSOpenSDK.setRSSDKInitListener(new RSSDKInitListener() {
            @Override
            public void onSuccess() {
                RSSDKLog.logD("sdk 初始化成功");
            }

            @Override
            public void onFail(@Nullable ErrorMsg errormsg) {
                RSSDKLog.logD("sdk 初始化失败：" + errormsg != null ? errormsg.getError_msg() : "");
            }
        });
    }
}
