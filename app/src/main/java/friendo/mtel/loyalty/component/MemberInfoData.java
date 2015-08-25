package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/24.
 */
public class MemberInfoData {
    private int LV;
    private int progress;
    private boolean benefitstatus;
    private String benefitnotic;
    private int store;
    private int point;
    private int count;
    private int money;

    public int getLV() {
        return LV;
    }

    public void setLV(int LV) {
        this.LV = LV;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isBenefitstatus() {
        return benefitstatus;
    }

    public void setBenefitstatus(boolean benefitstatus) {
        this.benefitstatus = benefitstatus;
    }

    public String getBenefitnotic() {
        return benefitnotic;
    }

    public void setBenefitnotic(String benefitnotic) {
        this.benefitnotic = benefitnotic;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
