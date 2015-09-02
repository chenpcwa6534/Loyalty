package friendo.mtel.loyalty.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;


/**
 * Created by MTel on 2015/8/31.
 */
public class SMSReceiver extends BroadcastReceiver{
    private String TAG = SMSReceiver.class.getSimpleName();

    private GetReceverResponse mListener;

    public SMSReceiver(GetReceverResponse listener){
        this.mListener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
       if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
           Log.d(TAG,"SMS Recever");
           Bundle  bundle = intent.getExtras();
           Object[] pdus = (Object[]) bundle.get("pdus");
           SmsMessage[] smsMessages = new SmsMessage[pdus.length];
           for(int i=0; i<pdus.length; i++){
               smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
               for(SmsMessage message:smsMessages){
                   String msg = message.getMessageBody();
                   String to  = message.getOriginatingAddress();
                   String[] msgSplit = msg.split("　");
                   String code = msgSplit[1];
                   mListener.onSMSRecever(code);
               }
           }
       }
    }
}
