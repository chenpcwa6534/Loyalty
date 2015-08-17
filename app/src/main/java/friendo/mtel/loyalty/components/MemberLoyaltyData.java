package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/29.
 */
public class MemberLoyaltyData {
    private String grade_name;
    private int grade_no;
    private int pointed_cnt;
    private PointedFirmData[] pointed_firm;
    private int progress;
    private int saved_money;
    private int total_point;
    private int visited_firm_cnt;
    private String welfare;

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    public int getGrade_no() {
        return grade_no;
    }

    public void setGrade_no(int grade_no) {
        this.grade_no = grade_no;
    }

    public int getPointed_cnt() {
        return pointed_cnt;
    }

    public void setPointed_cnt(int pointed_cnt) {
        this.pointed_cnt = pointed_cnt;
    }

    public PointedFirmData[] getPointed_firm() {
        return pointed_firm;
    }

    public void setPointed_firm(PointedFirmData[] pointed_firm) {
        this.pointed_firm = pointed_firm;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getSaved_money() {
        return saved_money;
    }

    public void setSaved_money(int saved_money) {
        this.saved_money = saved_money;
    }

    public int getTotal_point() {
        return total_point;
    }

    public void setTotal_point(int total_point) {
        this.total_point = total_point;
    }

    public int getVisited_firm_cnt() {
        return visited_firm_cnt;
    }

    public void setVisited_firm_cnt(int visited_firm_cnt) {
        this.visited_firm_cnt = visited_firm_cnt;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }
}
