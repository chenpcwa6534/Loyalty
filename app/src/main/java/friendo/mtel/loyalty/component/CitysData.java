package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/17.
 */
public class CitysData {
    private int cityID;
    private String cityName;
    private boolean cityVaild;
    private SubAreaData[] subareas;

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public boolean isCityVaild() {
        return cityVaild;
    }

    public void setCityVaild(boolean cityVaild) {
        this.cityVaild = cityVaild;
    }

    public SubAreaData[] getSubareas() {
        return subareas;
    }

    public void setSubareas(SubAreaData[] subareas) {
        this.subareas = subareas;
    }
}
