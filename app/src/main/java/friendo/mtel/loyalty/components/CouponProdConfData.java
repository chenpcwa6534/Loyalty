package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/29.
 */
public class CouponProdConfData {
    private GraphData barcode_picture;
    private String date_remark;
    private String description;
    //private PeriodData[] manual_period;
    private String mode;
    private String[] notices;
    private String prod_name;
    private int redeem_period;

    public GraphData getBarcode_picture() {
        return barcode_picture;
    }

    public void setBarcode_picture(GraphData barcode_picture) {
        this.barcode_picture = barcode_picture;
    }

    public String getDate_remark() {
        return date_remark;
    }

    public void setDate_remark(String date_remark) {
        this.date_remark = date_remark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public PeriodData[] getManual_period() {
//        return manual_period;
//    }
//
//    public void setManual_period(PeriodData[] manual_period) {
//        this.manual_period = manual_period;
//    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String[] getNotices() {
        return notices;
    }

    public void setNotices(String[] notices) {
        this.notices = notices;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public int getRedeem_period() {
        return redeem_period;
    }

    public void setRedeem_period(int redeem_period) {
        this.redeem_period = redeem_period;
    }
}
