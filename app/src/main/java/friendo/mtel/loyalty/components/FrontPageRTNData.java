package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/8/3.
 */
public class FrontPageRTNData {
    private FrontPageAdData[] ads;
    private FrontPageFirmData[] firms;
    private int unreadcouponcnt;

    public FrontPageAdData[] getAds() {
        return ads;
    }

    public void setAds(FrontPageAdData[] ads) {
        this.ads = ads;
    }

    public FrontPageFirmData[] getFirms() {
        return firms;
    }

    public void setFirms(FrontPageFirmData[] firms) {
        this.firms = firms;
    }

    public int getUnreadcouponcnt() {
        return unreadcouponcnt;
    }

    public void setUnreadcouponcnt(int unreadcouponcnt) {
        this.unreadcouponcnt = unreadcouponcnt;
    }
}
