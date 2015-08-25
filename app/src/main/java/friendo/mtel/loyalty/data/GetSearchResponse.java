package friendo.mtel.loyalty.data;

/**
 * Created by MTel on 2015/8/24.
 */
public interface GetSearchResponse {

    void onFirmSearch(String userFilter);
    void onLimitSearch(String userFilter);
}
