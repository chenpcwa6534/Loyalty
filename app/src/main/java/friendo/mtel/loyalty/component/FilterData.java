package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/17.
 */
public class FilterData {
    private String updateTime;
    private CitysData[] citys;
    private CatsData[] cats;
    private OrdersData order;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public CitysData[] getCitys() {
        return citys;
    }

    public void setCitys(CitysData[] citys) {
        this.citys = citys;
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
}
