package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/20.
 */
public class FirmListData {
    private int firmID;
    private String firmName;
    private String picture;
    private String picturePath;
    private String pointDesc;
    private String firstDesc;
    private int distance;
    private String latitude;
    private String longitude;
    private int catID;
    private String thumbnail;
    private String thumbnailPath;
    private boolean partner;
    private String partnerMessage;

    public int getFirmID() {
        return firmID;
    }

    public void setFirmID(int firmID) {
        this.firmID = firmID;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
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

    public String getPointDesc() {
        return pointDesc;
    }

    public void setPointDesc(String pointDesc) {
        this.pointDesc = pointDesc;
    }

    public String getFirstDesc() {
        return firstDesc;
    }

    public void setFirstDesc(String firstDesc) {
        this.firstDesc = firstDesc;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public boolean isPartner() {
        return partner;
    }

    public void setPartner(boolean partner) {
        this.partner = partner;
    }

    public String getPartnerMessage() {
        return partnerMessage;
    }

    public void setPartnerMessage(String partnerMessage) {
        this.partnerMessage = partnerMessage;
    }
}
