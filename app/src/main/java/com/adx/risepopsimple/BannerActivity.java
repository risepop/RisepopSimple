package com.adx.risepopsimple;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.risepop.adx.adxcore.banner.RSBannerAdView;
import com.risepop.adx.adxcore.banner.RSBannerViewListener;
import com.risepop.adx.adxcore.base.RSAdError;
import com.risepop.adx.adxcore.base.RSAdInfo;

public class BannerActivity  extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


    private BannerUtils bannerUtils;
    private RSBannerAdView tpBanner;
    private ViewGroup adContainer;
    private static final String TAG = "RSBannerTest";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        adContainer = findViewById(R.id.ad_container);
        bannerUtils = BannerUtils.getInstance();
        findViewById(R.id.btn_load).setOnClickListener(this);
        findViewById(R.id.btn_show).setOnClickListener(this);
        findViewById(R.id.second_page).setOnClickListener(this);
        loadBanner();
    }


    /**
     * --------------------------------------------------------------------------------------------------------------
     * banner的基本用法，如果没有特殊需求，按照如下代码接入即可
     * --------------------------------------------------------------------------------------------------------------
     */

    private void loadBanner() {
        tpBanner = new RSBannerAdView(this);
        tpBanner.closeAutoShow();
        tpBanner.setBannerAdListener(new RSBannerViewListener() {
            @Override
            public void onAdClicked(RSAdInfo tpAdInfo) {
                Log.i(TAG, "onAdClicked: " + tpAdInfo.getAdSourceName() + "广告被点击了");
                Toast.makeText(BannerActivity.this, "广告被点击了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdImpression(RSAdInfo tpAdInfo) {
                Log.i(TAG, "onAdImpression: " + tpAdInfo.getAdSourceName() + "广告展示");
                Toast.makeText(BannerActivity.this, "广告展示", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdBeginLoad() {
                Log.i(TAG, "onAdBeginLoad: "  + "onAdBeginLoad");
            }

            @Override
            public void onAdLoaded(RSAdInfo tpAdInfo) {
                Log.i(TAG, "onAdLoaded: " + tpAdInfo.getAdSourceName() + "广告加载完成");
                Toast.makeText(BannerActivity.this, "广告加载完成", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoadFailed(RSAdError error) {
                Log.i(TAG, "onAdLoadFailed: " + error.getErrorMsg() + "广告加载失败");
                Toast.makeText(BannerActivity.this, "广告加载失败", Toast.LENGTH_SHORT).show();
//                findViewById(R.id.btn_show).setClickable(false);
//                findViewById(R.id.second_page).setClickable(false);
            }

            @Override
            public void onAdClosed(RSAdInfo tpAdInfo) {
                Log.i(TAG, "onAdClosed: " + tpAdInfo.getAdSourceName() + "广告关闭");
            }

            @Override
            public void onAdShowFailed(RSAdError error, RSAdInfo info) {
                Log.i(TAG, "onAdShowFailed: " + info.getAdSourceName() + "广告展示失败");
            }

            @Override
            public void onBannerRefreshed() {
                Log.i(TAG, "onBannerRefreshed: " +  "广告刷新完成");
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn_load){
            if (tpBanner != null) {
                bannerUtils.loadBanner(tpBanner, TestAdUnitId.BANNER_ADUNITID);
            }
        }
        if (view.getId()==R.id.btn_show){
            if (bannerUtils.isReady()) {
                bannerUtils.showBanner(adContainer);
            }else {
                Toast.makeText(BannerActivity.this, "无可用广告 or 已经展示", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.second_page){

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bannerUtils.onDestroy();
    }
}
