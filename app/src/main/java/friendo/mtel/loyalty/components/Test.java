package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/23.
 */
public class Test {

    private String cats;
    private int cats_id;
    private Test1 subcats;

    public int getCats_id() {
        return cats_id;
    }

    public void setCats_id(int cats_id) {
        this.cats_id = cats_id;
    }

    public String getCats() {
        return cats;
    }

    public void setCats(String cats) {
        this.cats = cats;
    }

    public void setSubcats(Test1 subcats) {
        this.subcats = subcats;
    }

    public Test1 getSubcats() {
        return subcats;
    }
}
