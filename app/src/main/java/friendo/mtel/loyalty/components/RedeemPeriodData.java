package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/18.
 */
public class RedeemPeriodData {
    private PeriodData[] period;
    private int[] weekday;

    public PeriodData[] getPeriod() {
        return period;
    }

    public void setPeriod(PeriodData[] period) {
        this.period = period;
    }

    public int[] getWeekday() {
        return weekday;
    }

    public void setWeekday(int[] weekday) {
        this.weekday = weekday;
    }
}
