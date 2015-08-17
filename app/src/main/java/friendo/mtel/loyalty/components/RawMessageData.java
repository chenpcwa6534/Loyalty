package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/8/3.
 */
public class RawMessageData {
    private String apply_id;
    private String transfer;
    private int cat_id;
    private int city_id;
    private String subarea_id;
    private int subcat_id;
    private String video_url;
    private String fb_content;
    private FbImageData fb_image;
    private String fb_title;
    private String fb_url;

    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getSubarea_id() {
        return subarea_id;
    }

    public void setSubarea_id(String subarea_id) {
        this.subarea_id = subarea_id;
    }

    public int getSubcat_id() {
        return subcat_id;
    }

    public void setSubcat_id(int subcat_id) {
        this.subcat_id = subcat_id;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getFb_content() {
        return fb_content;
    }

    public void setFb_content(String fb_content) {
        this.fb_content = fb_content;
    }

    public FbImageData getFb_image() {
        return fb_image;
    }

    public void setFb_image(FbImageData fb_image) {
        this.fb_image = fb_image;
    }

    public String getFb_title() {
        return fb_title;
    }

    public void setFb_title(String fb_title) {
        this.fb_title = fb_title;
    }

    public String getFb_url() {
        return fb_url;
    }

    public void setFb_url(String fb_url) {
        this.fb_url = fb_url;
    }
}
