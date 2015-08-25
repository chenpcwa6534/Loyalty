package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/24.
 */
public class MemberExChangeData {
    private int storeID;
    private String name;
    private String picture;
    private String picturePath;
    private int convertdate;
    private String description;

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getConvertdate() {
        return convertdate;
    }

    public void setConvertdate(int convertdate) {
        this.convertdate = convertdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
