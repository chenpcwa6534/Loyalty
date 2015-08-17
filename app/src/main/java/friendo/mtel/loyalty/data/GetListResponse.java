package friendo.mtel.loyalty.data;

/**
 * Created by MTel on 2015/7/29.
 */
public interface GetListResponse {
    void onFirmResponse(String firmID);

    void onCouponResponse(int allotID);
}
