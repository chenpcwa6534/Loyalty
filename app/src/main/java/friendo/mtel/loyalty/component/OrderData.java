package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/17.
 */
public class OrderData {
    private int orderID;
    private String orderName;
    private boolean orderVaild;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public boolean isOrderVaild() {
        return orderVaild;
    }

    public void setOrderVaild(boolean orderVaild) {
        this.orderVaild = orderVaild;
    }
}
