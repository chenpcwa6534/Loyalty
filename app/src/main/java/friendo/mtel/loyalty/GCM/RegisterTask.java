package friendo.mtel.loyalty.GCM;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;


/**
 * Created by MTel on 2015/8/31.
 */
public class RegisterTask extends AsyncTask<Void,Void,String> {
    private String TAG = RegisterTask.class.getSimpleName();

    private Context mContext;
    private GetGCMResponse mListener;

    public RegisterTask(Context context, GetGCMResponse listener) {
        super();
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    protected String doInBackground(Void... params) {
        String token = null;
        try{
            Log.d(TAG,"GCM rsg success senderID:"+Utility.SenderID);
            token = GoogleCloudMessaging.getInstance(mContext).register(Utility.SenderID);
            Log.d(TAG,"GCM rsg success token:"+token);
        }catch (Exception e){
            Log.e(TAG,"get token is fail Exception:"+ e);
        }
        return token;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String token) {
        if(token == null){
            Log.e(TAG,"token rsgister fail");
        }else{
            mListener.onSuccess(TAG,token);
        }
        super.onPostExecute(token);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
