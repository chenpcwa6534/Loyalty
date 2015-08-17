package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/8/4.
 */
public class MemberPointRedeemData {
    private String begin_time;
    private int coupon_id;
    private String description;
    private String editor;
    private String end_time;
    private String mode;
    private GraphData picture;
    private String picturepaht;
    private int points;
    private String prod_name;
    private int redeem_id;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public GraphData getPicture() {
        return picture;
    }

    public void setPicture(GraphData picture) {
        this.picture = picture;
    }

    public String getPicturepaht() {
        return picturepaht;
    }

    public void setPicturepaht(String picturepaht) {
        this.picturepaht = picturepaht;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public int getRedeem_id() {
        return redeem_id;
    }

    public void setRedeem_id(int redeem_id) {
        this.redeem_id = redeem_id;
    }
}
