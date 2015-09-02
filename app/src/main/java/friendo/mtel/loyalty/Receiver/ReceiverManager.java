package friendo.mtel.loyalty.Receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.activity.MainActivity;

/**
 * Created by MTel on 2015/8/31.
 */
public class ReceiverManager  {
    private final static String MSG_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    public static final int CHATMSG_NOTIFICATION_ID = 100;

    private static SMSReceiver mSmsReceiver = null;

    public static void registerSMSReceiver(Context context,GetReceverResponse listener){
        IntentFilter filter = new IntentFilter(MSG_RECEIVED);
        SMSReceiver receiver = new SMSReceiver(listener);
        mSmsReceiver = receiver;
        context.registerReceiver(receiver,filter);
    }

    public static void unregisterSMSReceiver(Context context){
        if(mSmsReceiver != null){
            context.unregisterReceiver(mSmsReceiver);
        }
    }

    public static void sendNotification(Context context, Intent intent){
        String msg = intent.getExtras().getString("MY_PUSH_MESSAGE");
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notIntent = new Intent(context, MainActivity.class);
        Bundle b = new Bundle();
//		b.putString("goto", "ChatActivity");
//		b.putString("withuuid", intent.getExtras().getString("withuuid"));
//		b.putInt("msgtype", Integer.parseInt(intent.getExtras().getString("msgtypee")));
        notIntent.putExtras(b);

        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                notIntent,
                0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                context).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(context.getString(R.string.app_name))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setDefaults(Notification.DEFAULT_ALL)  //設定音效，震動，閃屏等都用系統預設模式
                .setContentText(msg);


        mBuilder.setContentIntent(contentIntent);
        notificationManager.notify(CHATMSG_NOTIFICATION_ID, mBuilder.build());
    }
}
