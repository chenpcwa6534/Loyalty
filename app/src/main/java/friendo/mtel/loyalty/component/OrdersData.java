package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/17.
 */
public class OrdersData {
    private OrderData[] point;
    private OrderData[] limit;

    public OrderData[] getLimit() {
        return limit;
    }

    public void setLimit(OrderData[] limit) {
        this.limit = limit;
    }

    public OrderData[] getPoint() {
        return point;
    }

    public void setPoint(OrderData[] point) {
        this.point = point;
    }
}
