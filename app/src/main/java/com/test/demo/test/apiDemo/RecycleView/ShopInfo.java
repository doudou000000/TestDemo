package com.test.demo.test.apiDemo.RecycleView;

public class ShopInfo {

    private String shopName;

    private String isUse;

    private String shopTip;

    private String useData;

    private ShopDetailInfo shopDetailInfo;

    public ShopInfo() {
    }

    public ShopInfo(String shopName, String isUse, String shopTip, String useData, ShopDetailInfo shopDetailInfo) {
        this.shopName = shopName;
        this.isUse = isUse;
        this.shopTip = shopTip;
        this.useData = useData;
        this.shopDetailInfo = shopDetailInfo;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }

    public String getShopTip() {
        return shopTip;
    }

    public void setShopTip(String shopTip) {
        this.shopTip = shopTip;
    }

    public String getUseData() {
        return useData;
    }

    public void setUseData(String useData) {
        this.useData = useData;
    }

    public ShopDetailInfo getShopDetailInfo() {
        return shopDetailInfo;
    }

    public void setShopDetailInfo(ShopDetailInfo shopDetailInfo) {
        this.shopDetailInfo = shopDetailInfo;
    }
}
