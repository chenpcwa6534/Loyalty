package friendo.mtel.loyalty.GCM;

/**
 * Created by MTel on 2015/9/1.
 */
public interface GetGCMResponse {
    void onSuccess(String type,String token);
    void onFail(String type);
    void onMessage(String msg);
}
