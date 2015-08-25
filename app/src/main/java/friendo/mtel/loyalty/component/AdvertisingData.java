package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/20.
 */
public class AdvertisingData {
    private String updateTime;
    private AdsInfoData[] adsInfo;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public AdsInfoData[] getAdsInfo() {
        return adsInfo;
    }

    public void setAdsInfo(AdsInfoData[] adsInfo) {
        this.adsInfo = adsInfo;
    }
}
