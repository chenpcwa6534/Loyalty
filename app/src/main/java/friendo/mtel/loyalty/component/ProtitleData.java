package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/14.
 */
public class ProtitleData {
    private String name;
    private String gender;
    private String birthday;
    private String number;
    private String picture;
    private boolean isModify;
    private boolean pushService;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isModify() {
        return isModify;
    }

    public void setIsModify(boolean isModify) {
        this.isModify = isModify;
    }

    public boolean isPushService() {
        return pushService;
    }

    public void setPushService(boolean pushService) {
        this.pushService = pushService;
    }
}
