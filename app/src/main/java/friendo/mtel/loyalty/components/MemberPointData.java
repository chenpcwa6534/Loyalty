package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/8/4.
 */
public class MemberPointData {
    private String description;
    private boolean is_favorite;
    private int point;
    private MemberPointRangeData[] point_range;
    private MemberPointRedeemData[] point_redeem;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean is_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(boolean is_favorite) {
        this.is_favorite = is_favorite;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public MemberPointRangeData[] getPoint_range() {
        return point_range;
    }

    public void setPoint_redeem(MemberPointRedeemData[] point_redeem) {
        this.point_redeem = point_redeem;
    }

    public MemberPointRedeemData[] getPoint_redeem() {
        return point_redeem;
    }

    public void setPoint_range(MemberPointRangeData[] point_range) {
        this.point_range = point_range;
    }
}
