package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/29.
 */
public class PointedFirmData {

    private BaseConfData base_conf;
    private String description;
    private int firm_id;
    private String firm_name;
    private int point;
    private String redeemprompt;
    private String thumbnail;

    public BaseConfData getBase_conf() {
        return base_conf;
    }

    public void setBase_conf(BaseConfData base_conf) {
        this.base_conf = base_conf;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getRedeemprompt() {
        return redeemprompt;
    }

    public void setRedeemprompt(String redeemprompt) {
        this.redeemprompt = redeemprompt;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
