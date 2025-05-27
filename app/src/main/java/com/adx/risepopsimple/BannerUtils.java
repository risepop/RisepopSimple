package com.adx.risepopsimple;

import android.text.TextUtils;
import android.view.ViewGroup;

import com.risepop.adx.adxcore.banner.RSBannerAdView;

public class BannerUtils {

    private static BannerUtils sInstance;
    private RSBannerAdView mTpbanner;


    public synchronized static BannerUtils getInstance() {
        if (sInstance == null) {
            sInstance = new BannerUtils();
        }
        return sInstance;
    }

    public void loadBanner(RSBannerAdView tpbanner, String adUnitId) {
       if (tpbanner != null && !TextUtils.isEmpty(adUnitId)) {
           mTpbanner = tpbanner;
           tpbanner.loadAd(adUnitId);
       }
    }

    public void showBanner(ViewGroup adContainer) {
        if (mTpbanner != null) {
            if(mTpbanner.getParent() != null) {
                ((ViewGroup) mTpbanner.getParent()).removeView(mTpbanner);
            }
            adContainer.addView(mTpbanner);
            mTpbanner.showAd();
        }

    }

    public boolean isReady() {
        return mTpbanner != null && mTpbanner.isReady();
    }

    public void onDestroy() {
        if (mTpbanner != null) {
            mTpbanner.onDestroy();
        }

    }
}
