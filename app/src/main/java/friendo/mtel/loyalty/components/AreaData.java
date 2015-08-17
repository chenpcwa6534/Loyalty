package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/17.
 */
public class AreaData {
    private int city_id;
    private String city_name;
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

    public SubAreaData[] getSubareas() {
        return subarea;
    }

    public void setSubareas(SubAreaData[] subarea) {
        this.subarea = subarea;
    }
}
