package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/17.
 */
public class FilterData {
    private String updateTime;
    private AreaData[] area;
    private CatsData[] cats;
    private OrdersData order;

    public AreaData[] getArea() {
        return area;
    }

    public void setArea(AreaData[] area) {
        this.area = area;
    }

    public CatsData[] getCats() {
        return cats;
    }

    public void setCats(CatsData[] cats) {
        this.cats = cats;
    }

    public OrdersData getOrder() {
        return order;
    }

    public void setOrder(OrdersData order) {
        this.order = order;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
