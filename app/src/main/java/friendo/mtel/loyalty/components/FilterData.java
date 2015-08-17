package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/17.
 */
public class FilterData {
    private AreaData[] area;
    private FilterCatData[] cats;
    private OrderData[] order;

    public AreaData[] getAreas() {
        return area;
    }

    public void setAreas(AreaData[] area) {
        this.area = area;
    }

    public FilterCatData[] getCats() {
        return cats;
    }

    public void setCats(Object cats) {
            this.cats = (FilterCatData[]) cats;
    }

    public OrderData[] getOrders() {
        return order;
    }

    public void setOrders(OrderData[] order) {
        this.order = order;
    }
}
