package friendo.mtel.loyalty.httpapi;

/**
 * Created by MTel on 2015/7/16.
 */
public interface CallAPIResponse {

    public void onStart();

    public void onSuccess(Object response);

    public void onSuccess(Object[] response);

    public void onFailure(Object response);

    public void onFinish();
}

