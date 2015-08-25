package friendo.mtel.loyalty.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import friendo.mtel.loyalty.MainActivity;
import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.TestDataJson.ErrorMessageResult;
import friendo.mtel.loyalty.WelcomeActivity;
import friendo.mtel.loyalty.common.Env;
import friendo.mtel.loyalty.component.ErrorMessageData;
import friendo.mtel.loyalty.component.FilterData;
import friendo.mtel.loyalty.component.VersionControlData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.preferences.LoyaltyPreference;
import friendo.mtel.loyalty.utility.Utilitys;

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
        DataManager.getInstance(this).qryVersionControl("", getDataResponse);
        DataManager.getInstance(this).qryErrorMessage("", getDataResponse);
        DataManager.getInstance(this).qryFilter("", true, getDataResponse);
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

    private void initView(){
        if(Utilitys.isLogin(this)){
            intentPage(WelcomeActivity.class);
        }else{
            intentPage(MainActivity.class);
        }
        finish();
    }

    private void intentPage(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }

    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            if(obj instanceof VersionControlData){
                VersionControlData versionControlData = (VersionControlData) obj;
                LoyaltyPreference.setPersonInformation(InitializationActivity.this,versionControlData.getProtitleData().getName(),versionControlData.getProtitleData().getBirthday(),versionControlData.getProtitleData().getGender(),versionControlData.getProtitleData().getPicture());
                progress +=33;
            }else if(obj instanceof ErrorMessageResult){
                //save data
                progress += 33;
            }else if(obj instanceof FilterData){
                progress += 34;
            }

            if(progress == 100){
                initView();
            }
        }

        @Override
        public void onSuccess(Object[] obj) {
            if(obj instanceof ErrorMessageData[]){
                progress += 33;
            }

            if(progress == 100){
                initView();
            }
        }

        @Override
        public void onFailure(Object obj) {

        }

        @Override
        public void onFinish() {

        }
    };
}
