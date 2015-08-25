package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/17.
 */
public class CatsData {
    private int catID;
    private String catName;
    private boolean catVaild;
    private SubCatsData[] subcats;

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public SubCatsData[] getSubcats() {
        return subcats;
    }

    public void setSubcats(SubCatsData[] subcats) {
        this.subcats = subcats;
    }

    public boolean isCatVaild() {
        return catVaild;
    }

    public void setCatVaild(boolean catVaild) {
        this.catVaild = catVaild;
    }
}
