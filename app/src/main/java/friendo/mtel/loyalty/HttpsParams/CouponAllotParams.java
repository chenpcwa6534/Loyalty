package friendo.mtel.loyalty.HttpsParams;

/**
 * Created by MTel on 2015/8/7.
 */
public class CouponAllotParams {
    private int allot_id;
    private boolean allot_status;
    private int coupons_id;
    private String device_token;

    public int getAllot_id() {
        return allot_id;
    }

    public void setAllot_id(int allot_id) {
        this.allot_id = allot_id;
    }

    public boolean isAllot_status() {
        return allot_status;
    }

    public void setAllot_status(boolean allot_status) {
        this.allot_status = allot_status;
    }

    public int getCoupons_id() {
        return coupons_id;
    }

    public void setCoupons_id(int coupons_id) {
        this.coupons_id = coupons_id;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }
}
