package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/21.
 */
public class FirmPointData {
    private String description;
    private String notics;
    private int current_point;
    private int max_point;
    private String maturityday;
    private RedeemData[] redeems;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotics() {
        return notics;
    }

    public void setNotics(String notics) {
        this.notics = notics;
    }

    public int getCurrent_point() {
        return current_point;
    }

    public void setCurrent_point(int current_point) {
        this.current_point = current_point;
    }

    public int getMax_point() {
        return max_point;
    }

    public void setMax_point(int max_point) {
        this.max_point = max_point;
    }

    public String getMaturityday() {
        return maturityday;
    }

    public void setMaturityday(String maturityday) {
        this.maturityday = maturityday;
    }

    public RedeemData[] getRedeems() {
        return redeems;
    }

    public void setRedeems(RedeemData[] redeems) {
        this.redeems = redeems;
    }
}
