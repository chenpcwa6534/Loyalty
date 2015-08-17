package friendo.mtel.loyalty.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.Request.VerControlRequest;
import friendo.mtel.loyalty.component.VersionControlData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.preferences.LoyaltyPreference;

/**
 * Created by MTel on 2015/8/13.
 */
public class InitializationActivity extends Activity{

    private String TAG = InitializationActivity.class.getSimpleName();

    private ProgressBar mProgressBar;
    private TextView mLoadMessage;

    private int progress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initalzation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataManager.getInstance(this).qryVersionControl("",getDataResponse);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void findView(){
        mProgressBar = (ProgressBar) findViewById(R.id.pb_loading);
        mLoadMessage = (TextView) findViewById(R.id.txt_loadmessage);
    }
    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            if(obj instanceof VersionControlData){
                VersionControlData versionControlData = (VersionControlData) obj;
                LoyaltyPreference.setPersonInformation(InitializationActivity.this,versionControlData.getProtitle().getName(),versionControlData.getProtitle().getBirthday(),versionControlData.getProtitle().getGender(),versionControlData.getProtitle().getPicture());
                progress +=25;
            }
        }

        @Override
        public void onSuccess(Object[] obj) {

        }

        @Override
        public void onFailure(Object obj) {

        }

        @Override
        public void onFinish() {

        }
    };
}
