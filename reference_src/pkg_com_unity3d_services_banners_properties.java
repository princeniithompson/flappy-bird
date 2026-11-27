// Package bundle: com.unity3d.services.banners.properties (1 classes)

// ============================================================
// CLASS: com.unity3d.services.banners.properties.BannerRefreshInfo
// ============================================================
package com.unity3d.services.banners.properties;

public class BannerRefreshInfo {
    private static BannerRefreshInfo instance;
    private HashMap _refreshRateMap;

    public BannerRefreshInfo() {
        new Object();
        new HashMap();
        _refreshRateMap = new HashMap(..);
        return;
    }

    public static BannerRefreshInfo getInstance() {
        if (if-nez(BannerRefreshInfo.instance)) goto L_b;
        new BannerRefreshInfo();
        instance = new BannerRefreshInfo(..);
      L_b:
        return BannerRefreshInfo.instance;
    }

    public Integer getRefreshRate(String p0) {
        _refreshRateMap.get(p0);
        return HashMap.get(..);
        throw HashMap.get(..);
    }

    public void setRefreshRate(String p0, Integer p1) {
        _refreshRateMap.put(p0, p1);
        return;
        throw p0;
    }

}

