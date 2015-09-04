package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/17.
 */
public class CatsData {
    private int cat_id;
    private String cat_name;
    private boolean catVaild;
    private SubCatsData[] subcat;

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

    public boolean isCatVaild() {
        return catVaild;
    }

    public void setCatVaild(boolean catVaild) {
        this.catVaild = catVaild;
    }

    public SubCatsData[] getSubcat() {
        return subcat;
    }

    public void setSubcat(SubCatsData[] subcat) {
        this.subcat = subcat;
    }
}
