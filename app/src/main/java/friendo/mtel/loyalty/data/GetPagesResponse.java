package friendo.mtel.loyalty.data;

/**
 * Created by MTel on 2015/7/1.
 */
public interface GetPagesResponse {

    public void onPhoneNumber(String phonenumber);

    public void onVerification();

    public void onSkip();
}
