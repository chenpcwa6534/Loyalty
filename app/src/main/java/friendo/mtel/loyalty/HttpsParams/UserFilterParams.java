package friendo.mtel.loyalty.HttpsParams;

/**
 * Created by MTel on 2015/8/2.
 */
public class UserFilterParams {
    private int cat_id;
    private int city_id;
    private int order_id;
    private int subcat_id;
    private String subarea_id;

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getSubcat_id() {
        return subcat_id;
    }

    public void setSubarea_id(String subarea_id) {
        this.subarea_id = subarea_id;
    }

    public String getSubarea_id() {
        return subarea_id;
    }

    public void setSubcat_id(int subcat_id) {
        this.subcat_id = subcat_id;
    }
}
