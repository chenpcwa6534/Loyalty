package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/20.
 */
public class AdsInfoData {
    private String title;
    private int adType;
    private String picture;
    private String picturePath;
    private IntentInfoData intentInfo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public IntentInfoData getIntentInfo() {
        return intentInfo;
    }

    public void setIntentInfo(IntentInfoData intentInfo) {
        this.intentInfo = intentInfo;
    }
}
