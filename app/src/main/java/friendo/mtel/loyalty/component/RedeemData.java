package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/21.
 */
public class RedeemData {
    private int point;
    private String Adpicture;
    private String AdpicturePath;
    private ConvertData[] convertlist;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAdpicture() {
        return Adpicture;
    }

    public void setAdpicture(String adpicture) {
        Adpicture = adpicture;
    }

    public String getAdpicturePath() {
        return AdpicturePath;
    }

    public void setAdpicturePath(String adpicturePath) {
        AdpicturePath = adpicturePath;
    }

    public ConvertData[] getConvertlist() {
        return convertlist;
    }

    public void setConvertlist(ConvertData[] convertlist) {
        this.convertlist = convertlist;
    }
}
