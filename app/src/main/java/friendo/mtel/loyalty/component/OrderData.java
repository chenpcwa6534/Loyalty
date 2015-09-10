package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/17.
 */
public class OrderData {
    private int order_id;
    private String order_name;
    private boolean orderVaild;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public boolean isOrderVaild() {
        return orderVaild;
    }

    public void setOrderVaild(boolean orderVaild) {
        this.orderVaild = orderVaild;
    }
}
