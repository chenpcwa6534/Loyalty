package friendo.mtel.loyalty.components;

import com.android.volley.toolbox.StringRequest;

/**
 * Created by MTel on 2015/7/29.
 */
public class CouponsAttrData {
    private String barcode_picture;
    private String barcode_picturepath;
    private String mode;
    private String notices;

    public String getBarcode_picture() {
        return barcode_picture;
    }

    public void setBarcode_picture(String barcode_picture) {
        this.barcode_picture = barcode_picture;
    }

    public String getBarcode_picturepath() {
        return barcode_picturepath;
    }

    public void setBarcode_picturepath(String barcode_picturepath) {
        this.barcode_picturepath = barcode_picturepath;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getNotices() {
        return notices;
    }

    public void setNotices(String notices) {
        this.notices = notices;
    }
}
