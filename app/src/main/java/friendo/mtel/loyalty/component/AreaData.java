package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/17.
 */
public class AreaData {
    private int city_id;
    private String city_name;
    private boolean cityVaild;
    private SubAreaData[] subarea;

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public boolean isCityVaild() {
        return cityVaild;
    }

    public void setCityVaild(boolean cityVaild) {
        this.cityVaild = cityVaild;
    }

    public SubAreaData[] getSubarea() {
        return subarea;
    }

    public void setSubarea(SubAreaData[] subarea) {
        this.subarea = subarea;
    }
}
