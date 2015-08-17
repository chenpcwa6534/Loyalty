package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/29.
 */
public class MemberRedeemLogData {
    private int firm_id;
    private String firm_name;
    private String firm_picture;
    private String picturepath;
    private String redeem_date;
    private String redeem_rule;

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

    public String getFirm_picture() {
        return firm_picture;
    }

    public void setFirm_picture(String firm_picture) {
        this.firm_picture = firm_picture;
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

    public String getRedeem_date() {
        return redeem_date;
    }

    public void setRedeem_date(String redeem_date) {
        this.redeem_date = redeem_date;
    }

    public String getRedeem_rule() {
        return redeem_rule;
    }

    public void setRedeem_rule(String redeem_rule) {
        this.redeem_rule = redeem_rule;
    }
}
