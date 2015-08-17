package friendo.mtel.loyalty.data;

/**
 * Created by MTel on 2015/7/17.
 */
public interface GetDataResponse {

    public void onStart();

    public void onSuccess(Object obj);

    public void onSuccess(Object[] obj);

    public void onFailure(Object obj);

    public void onFinish();
}
