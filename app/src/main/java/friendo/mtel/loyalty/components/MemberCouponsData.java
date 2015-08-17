package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/29.
 */
public class MemberCouponsData {

    private int allot_id;
    private String begin_time;
    private int coupon_id;
    private String coupon_rule_type;
    private CouponsAttrData coupons_attr;
    private String description;
    private String end_time;
    private int firm_id;
    private String firm_name;
    private String picture;
    private String picturepath;
    private String pincode;
    private RedeemPeriodData redeem_period;
    private int status;
    private String title;
    private String type;

    public int getAllot_id() {
        return allot_id;
    }

    public void setAllot_id(int allot_id) {
        this.allot_id = allot_id;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getCoupon_rule_type() {
        return coupon_rule_type;
    }

    public void setCoupon_rule_type(String coupon_rule_type) {
        this.coupon_rule_type = coupon_rule_type;
    }

    public CouponsAttrData getCoupons_attr() {
        return coupons_attr;
    }

    public void setCoupons_attr(CouponsAttrData coupons_attr) {
        this.coupons_attr = coupons_attr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getFirm_id() {
        return firm_id;
    }

    public void setFirm_id(int firm_id) {
        this.firm_id = firm_id;
    }

    public String getFirm_name() {
        return firm_name;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public RedeemPeriodData getRedeem_period() {
        return redeem_period;
    }

    public void setRedeem_period(RedeemPeriodData redeem_period) {
        this.redeem_period = redeem_period;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
