package friendo.mtel.loyalty.httpapi;

import android.content.Context;

import java.util.concurrent.CopyOnWriteArrayList;

import friendo.mtel.loyalty.R;

/**
 * Created by MTel on 2015/8/12.
 */
public class HttpErrorMessage {

    private String TAG = HttpErrorMessage.class.getSimpleName();
    private static HttpErrorMessage httpErrorMessage = null;
    private Context mContext;

    public HttpErrorMessage(Context context){
        mContext = context;
    }

    public static HttpErrorMessage getInstance(Context context){
        if(httpErrorMessage != null){
            httpErrorMessage = new HttpErrorMessage(context);
        }
        return httpErrorMessage;
    }

    public String errorMessage(int ErrorCode){
        switch (ErrorCode){
            default:
                return httpErrorMessage.mContext.getResources().getString(R.string.app_system_fail);
        }
    }
}
