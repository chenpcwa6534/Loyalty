package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/21.
 */
public class FirmPointData {
    private String description;
    private String notics;
    private int currentPoint;
    private int maxPoint;
    private String maturityDay;
    private RedeemData[] redeem;

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

    public int getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(int currentPoint) {
        this.currentPoint = currentPoint;
    }

    public int getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(int maxPoint) {
        this.maxPoint = maxPoint;
    }

    public String getMaturityDay() {
        return maturityDay;
    }

    public void setMaturityDay(String maturityDay) {
        this.maturityDay = maturityDay;
    }

    public RedeemData[] getRedeem() {
        return redeem;
    }

    public void setRedeem(RedeemData[] redeem) {
        this.redeem = redeem;
    }
}
