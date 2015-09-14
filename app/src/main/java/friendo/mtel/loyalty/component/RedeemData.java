package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/21.
 */
public class RedeemData {
    private int point;
    private String ad_picture;
    private String ad_picture_path;
    private ConvertData[] convert_list;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAd_picture() {
        return ad_picture;
    }

    public void setAd_picture(String ad_picture) {
        this.ad_picture = ad_picture;
    }

    public String getAd_picture_path() {
        return ad_picture_path;
    }

    public void setAd_picture_path(String ad_picture_path) {
        this.ad_picture_path = ad_picture_path;
    }

    public ConvertData[] getConvert_list() {
        return convert_list;
    }

    public void setConvert_list(ConvertData[] convert_list) {
        this.convert_list = convert_list;
    }
}
