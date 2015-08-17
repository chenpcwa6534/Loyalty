package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/8/6.
 */
public class DeluxeCoupon {
    private int pageno;
    private CollectibleCoupon[] collectiblecoupon;

    public CollectibleCoupon[] getCollectiblecoupon() {
        return collectiblecoupon;
    }

    public void setCollectiblecoupon(CollectibleCoupon[] collectiblecoupon) {
        this.collectiblecoupon = collectiblecoupon;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }
}
