package friendo.mtel.loyalty.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.facebook.FacebookSdk;

import java.util.Random;

import friendo.mtel.loyalty.GCM.GetGCMResponse;
import friendo.mtel.loyalty.GCM.RegisterTask;
import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.TestDataJson.ErrorMessageResult;
import friendo.mtel.loyalty.component.ErrorMessageData;
import friendo.mtel.loyalty.component.FilterData;
import friendo.mtel.loyalty.component.VersionControlData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.db.DBManager;
import friendo.mtel.loyalty.preferences.LoyaltyPreference;
import friendo.mtel.loyalty.utility.Utilitys;
import friendo.mtel.loyalty.view.MessageDialog;
import friendo.mtel.loyalty.view.ProgressWheel;

/**
 * Created by MTel on 2015/8/13.
 */
public class InitializationActivity extends Activity {

    private String TAG = InitializationActivity.class.getSimpleName();

    private ProgressBar mProgressBar;
    private TextView mLoadMessage;

    private int inspectioncount = 2;
    private int inspection_success = 0;
    private int inspection_fail = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initalzation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        try{
            new RegisterTask(this,getGCMResponse).execute();
            String VerControl_UpdateTime = LoyaltyPreference.getAPIRequestTime(this, LoyaltyPreference.API.VersionControl);
            DataManager.getInstance(this).qryVersionControl(VerControl_UpdateTime, getDataResponse);
            //error message 改為V2 使用
            //DataManager.getInstance(this).qryErrorMessage("", getDataResponse);
            String Filter_UpdateTime = LoyaltyPreference.getAPIRequestTime(this, LoyaltyPreference.API.Filter);
            DataManager.getInstance(this).qryFilter(Filter_UpdateTime, true, getDataResponse);

        }catch (Exception e){
            Log.e(TAG,"DataManager call api fail (InitializationActivity.class line 51) Exception:"+e.getMessage());
        }
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
        if(!Utilitys.isLogin(this)){
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

    private void inspection(){
        if(inspectioncount == inspection_fail+inspection_success && inspection_fail != 0 ){
//            MessageDialog messageDialog = new MessageDialog(this);
//            messageDialog.setLogo(MessageDialog.LogoType.Question);
//            messageDialog.setTitle(getResources().getString(R.string.app_system_fail));
//            messageDialog.setButton(getResources().getString(R.string.app_system_ok));
//            messageDialog.setCallback(dialogCallback);
//            messageDialog.show();
            initView();
        }else if(inspectioncount == inspection_success){
            initView();
        }
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
                inspection_success +=1;
            }else if(obj instanceof ErrorMessageResult){
                //save data
                inspection_success += 1;
            }else if(obj instanceof FilterData){
                FilterData filterData = (FilterData) obj;
                inspection_success += 1;
            }

            inspection();
        }

        @Override
        public void onSuccess(Object[] obj) {
            if(obj instanceof ErrorMessageData[]){
                inspection_success += 1;
            }
            inspection();
        }

        @Override
        public void onFailure(Object obj) {
            inspection_fail += 1;
            inspection();
        }

        @Override
        public void onFinish() {
            inspection();
        }
    };

    private GetGCMResponse getGCMResponse = new GetGCMResponse() {
        @Override
        public void onSuccess(String type, String token) {
            LoyaltyPreference.setDeviceToken(InitializationActivity.this,token);
            inspection_success += 1;
            inspection();
        }

        @Override
        public void onFail(String type) {
            inspection_fail += 1;
            inspection();
        }

        @Override
        public void onMessage(String msg) {

        }
    };

    private MessageDialog.DialogCallback dialogCallback = new MessageDialog.DialogCallback() {
        @Override
        public void onClick(int position, String btnStr) {
            finish();
        }
    };

}
