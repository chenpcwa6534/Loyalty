package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/29.
 */
public class PeriodData {
    private String begin_time;
    private String end_time;
    private int[] weekday;

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int[] getWeekday() {
        return weekday;
    }

    public void setWeekday(int[] weekday) {
        this.weekday = weekday;
    }
}
