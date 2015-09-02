package friendo.mtel.loyalty.Receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

/**
 * Created by MTel on 2015/9/2.
 */
public class GCMReceiver extends BroadcastReceiver {
    private String TAG = GCMReceiver.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "action = " + intent.getAction());
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
        String messageType = gcm.getMessageType(intent);
        if(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR.equals(messageType)){
            Log.e(TAG,"Send error : "+ intent.getExtras().toString());
        }else if(GoogleCloudMessaging.MESSAGE_TYPE_DELETED.equals(messageType)){
            Log.e(TAG,"Deleted message on server : " +intent.getExtras().toString());
        }else{
            ReceiverManager.sendNotification(context,intent);
        }
        setResultCode(Activity.RESULT_OK);
    }

}
