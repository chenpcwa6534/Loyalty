package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/29.
 */
public class MyCouponData {

    private int allot_id;
    private int coupon_id;
    private int coupons_id;
    private int firm_id;
    private String firm_name;
    private String Pic_url;
    private CouponInfoData coupon_conf;
    private CouponProdConfData prod_conf;
    private String rule;
    private String type;
    private String coupons_status;


    public String getPic_url() {
        return Pic_url;
    }

    public void setPic_url(String pic_url) {
        Pic_url = pic_url;
    }

    public int getAllot_id() {
        return allot_id;
    }

    public void setAllot_id(int allot_id) {
        this.allot_id = allot_id;
    }

    public CouponInfoData getCoupon_conf() {
        return coupon_conf;
    }

    public void setCoupon_conf(CouponInfoData coupon_conf) {
        this.coupon_conf = coupon_conf;
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public int getCoupons_id() {
        return coupons_id;
    }

    public void setCoupons_id(int coupons_id) {
        this.coupons_id = coupons_id;
    }

    public String getCoupons_status() {
        return coupons_status;
    }

    public void setCoupons_status(String coupons_status) {
        this.coupons_status = coupons_status;
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

    public CouponProdConfData getProd_conf() {
        return prod_conf;
    }

    public void setProd_conf(CouponProdConfData prod_conf) {
        this.prod_conf = prod_conf;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
