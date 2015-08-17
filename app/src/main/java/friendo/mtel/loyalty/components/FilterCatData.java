package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/17.
 */
public class FilterCatData {
    private int cat_id;
    private String cat_name;
    private SubCatData[] subcat;

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public SubCatData[] getSubcats() {
        return subcat;
    }

    public void setSubcats(SubCatData[] subcat) {
        this.subcat = subcat;
    }
}
